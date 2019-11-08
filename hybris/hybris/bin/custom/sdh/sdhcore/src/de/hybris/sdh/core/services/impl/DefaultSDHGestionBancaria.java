package de.hybris.sdh.core.services.impl;

import com.bdg.ca.CACertificateManager;
import com.bdg.verifiers.FileSignVerifier;
import com.bdg.verifiers.SignerInfo;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.FileConciliaRequest;
import de.hybris.sdh.core.pojos.responses.FileConciliaResponse;
import de.hybris.sdh.core.services.SDHGestionBancaria;
import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import org.apache.log4j.Logger;

public class DefaultSDHGestionBancaria implements SDHGestionBancaria {

    private static final Logger LOG = Logger.getLogger(DefaultSDHGestionBancaria.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public boolean validade7ZipCertificates(MultipartFile multipartFile) {
        String updatedFilesFolder = configurationService.getConfiguration().getString("gestion.bancaria.certificados.path");
        String approvedFilesFolder = configurationService.getConfiguration().getString("gestion.bancaria.certificados.aprobados.path");
        String autoridadesPath = configurationService.getConfiguration().getString("gestion.bancaria.certificados.autoridades.path");

        boolean isValid = false;
        String nameFile = this.updateFileToServer(multipartFile);
        if(Objects.nonNull(nameFile)){
            isValid =  this.verifyFile(updatedFilesFolder + nameFile , approvedFilesFolder + nameFile, autoridadesPath);
            if(isValid){ //Extract .txt file from p7zip if file is valid
                this.extractAndUpdateTxtFileFrom7zip(approvedFilesFolder + nameFile, approvedFilesFolder);
            }
            LOG.info("updatedFilesFolder:" + updatedFilesFolder + nameFile);
            LOG.info("updatedFilesFolder:" + approvedFilesFolder + nameFile);
        }

        return isValid;
    }

    @Override
    public String updateFileToServer(MultipartFile multipartFile){
        String filePath = null;
        String fileName = null;
        String corePath = configurationService.getConfiguration().getString("gestion.bancaria.certificados.path");

        try {
            filePath = corePath +  multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(filePath) );
            fileName = multipartFile.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOG.info("PpdateFileToServer");
        LOG.info("FileCreatedFolder: " + corePath +  multipartFile.getOriginalFilename());
        LOG.info(corePath);
        LOG.info(multipartFile.getOriginalFilename());
        return fileName;
    }

    @Override
    public void extractAndUpdateTxtFileFrom7zip(String zipFilePath, String targetFilePath){
        ISevenZipInArchive inArchive = null;
        ISimpleInArchive simpleInArchive = null;
        RandomAccessFile randomAccessFile = null;
        File zip = null;

        try{
            randomAccessFile = new RandomAccessFile(zipFilePath, "r");
            inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));
            simpleInArchive = inArchive.getSimpleInterface();

            for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()){
                final int[] hash = new int[] { 0 };
                if(item.getPath().contains(".txt")){
                    ExtractOperationResult result;
                    final long[] sizeArray = new long[1];

                    result = item.extractSlow(new ISequentialOutStream() {
                        public int write(byte[] data) throws SevenZipException {

                            //Write to file
                            System.out.println(item.getPath());
                            FileOutputStream fos;
                            try {
                                File file = new File(targetFilePath + item.getPath());
                                file.getParentFile().mkdirs();
                                fos = new FileOutputStream(file);
                                fos.write(data);
                                fos.close();

                            } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                LOG.error("Error extracting item: " + e.toString());
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                LOG.error("Error extracting item: " + e.toString());
                            }

                            hash[0] ^= Arrays.hashCode(data); // Consume data
                            sizeArray[0] += data.length;
                            return data.length; // Return amount of consumed data
                        }
                    });
                    if (result == ExtractOperationResult.OK) {
                        LOG.info(String.format("%9X | %10s | %s", //
                                hash[0], sizeArray[0], item.getPath()));
                    } else {
                        LOG.error("Error extracting item: " + result);
                    }
                }
            }
        }catch (Exception e) {
            LOG.error("Error occurs: " + e);
        }finally {
            if (inArchive != null) {
                try {
                    inArchive.close();
                } catch (SevenZipException e) {
                    LOG.error("Error closing archive: " + e);
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    LOG.error("Error closing file: " + e);
                }
            }
        }
    }

    @Override
    public boolean verifyFile(String source, String target, String autoridades){
        boolean isValidCertificate = false;
        FileSignVerifier fv = null;
        String resultado = "";
        CACertificateManager caManager = new CACertificateManager();

        try {
            caManager.setPathTrustedCA(autoridades);
            fv = new FileSignVerifier(caManager);
            resultado = fv.signatureCheck(source, target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Si la validación es exitosa el resultado es OK​, sino se retorna un mensaje con el error
        if (resultado.equalsIgnoreCase("OK")) {
            isValidCertificate = true;
            LOG.info("Firmantes Del Archivo OK" + source);
            // Se recorre el arreglo de firmantes​
            for (SignerInfo signer : fv.getSigners()) {
                // aquí se consultan los OIDs que se requieran para el ejemplo solo puse el Common Name​
                LOG.info(signer.getOID("CN"));
            }
        }else{
            LOG.info("Firmantes Del Archivo FAIL" + source);
        }

        LOG.info("VerifyFile");
        LOG.info("Resultado " + resultado);
        LOG.info("autoridadesFolderPath: " + autoridades);
        return isValidCertificate;
    }

    @Override
    public FileConciliaResponse fileConcilia(FileConciliaRequest fileConciliaRequest) {
        final String usuario = configurationService.getConfiguration().getString("gestion.bancaria.ws.fileConcilia.user");
        final String password = configurationService.getConfiguration().getString("gestion.bancaria.ws.fileConcilia.password");
        final String urlService = configurationService.getConfiguration().getString("gestion.bancaria.ws.fileConcilia.url");

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
        final HttpEntity<FileConciliaRequest> request = new HttpEntity<>(fileConciliaRequest);

        final FileConciliaResponse fileConciliaResponse = restTemplate.postForObject(urlService, request, FileConciliaResponse.class);

        LOG.info(fileConciliaRequest);
        LOG.info(fileConciliaResponse);


        return fileConciliaResponse;
    }

}
