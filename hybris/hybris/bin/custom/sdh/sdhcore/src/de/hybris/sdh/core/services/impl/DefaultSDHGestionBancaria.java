package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.FileConciliaRequest;
import de.hybris.sdh.core.pojos.responses.FileConciliaResponse;
import de.hybris.sdh.core.services.SDHGestionBancaria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bdg.ca.CACertificateManager;
import com.bdg.verifiers.FileSignVerifier;
import com.bdg.verifiers.SignerInfo;

import net.sf.sevenzipjbinding.ExtractOperationResult;
import net.sf.sevenzipjbinding.ISequentialOutStream;
import net.sf.sevenzipjbinding.ISevenZipInArchive;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipException;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;

public class DefaultSDHGestionBancaria implements SDHGestionBancaria {

    private static final Logger LOG = Logger.getLogger(DefaultSDHGestionBancaria.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
	public String validade7ZipCertificates(final MultipartFile multipartFile)
	{
        final String updatedFilesFolder = configurationService.getConfiguration().getString("gestion.bancaria.certificados.path");
        final String approvedFilesFolder = configurationService.getConfiguration().getString("gestion.bancaria.certificados.aprobados.path");
        final String autoridadesPath = configurationService.getConfiguration().getString("gestion.bancaria.certificados.autoridades.path");
		final String approvedAresFilesFolder = configurationService.getConfiguration()
				.getString("gestion.bancaria.certificados.ArchBancos_Ares.path");


		String isValid = null;
        final String nameFile = this.updateFileToServer(multipartFile);
        if(Objects.nonNull(nameFile)){

			try
			{
				LOG.error("-----------Copy file to Ares inicio-----------------");
				final File sourceFile = new File(approvedFilesFolder + nameFile);
				final File destFile = new File(approvedAresFilesFolder + nameFile);
				Files.copy(sourceFile.toPath(), destFile.toPath());
				LOG.error("Copy file source: " + sourceFile.toPath());
				LOG.error("Copy file destination: " + destFile.toPath());
				LOG.error("-----------Copy file to Ares fin--------------------");

			}
			catch (final Exception e)
			{
				LOG.error("Error occurs: " + e);
			}

			isValid = this.verifyFile(updatedFilesFolder + nameFile, approvedFilesFolder + nameFile, autoridadesPath);
			if (isValid == null)
			{ //Extract .txt file from p7zip if file is valid
				this.extractAndUpdateTxtFileFrom7zip(approvedFilesFolder + nameFile, approvedFilesFolder,
						approvedAresFilesFolder + nameFile);
            }
            LOG.info("updatedFilesFolder:" + updatedFilesFolder + nameFile);
            LOG.info("approvedFilesFolder:" + approvedFilesFolder + nameFile);
        }

        return isValid;
    }

    @Override
    public String updateFileToServer(final MultipartFile multipartFile){
        String filePath = null;
        String fileName = null;
        final String corePath = configurationService.getConfiguration().getString("gestion.bancaria.certificados.path");

        try {
            filePath = corePath +  multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(filePath) );
            fileName = multipartFile.getOriginalFilename();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        LOG.info("PpdateFileToServer");
        LOG.info("FileCreatedFolder: " + corePath +  multipartFile.getOriginalFilename());
        LOG.info(corePath);
        LOG.info(multipartFile.getOriginalFilename());
        return fileName;
    }

    @Override
	public void extractAndUpdateTxtFileFrom7zip(final String zipFilePath, final String targetFilePath, final String aresFilePath)
	{
        ISevenZipInArchive inArchive = null;
        ISimpleInArchive simpleInArchive = null;
        RandomAccessFile randomAccessFile = null;
        final File zip = null;

		//		try
		//		{
		//			LOG.error("-----------Copy file to Ares inicio-----------------");
		//			final File sourceFile = new File(zipFilePath);
		//			final File destFile = new File(aresFilePath);
		//			Files.copy(sourceFile.toPath(), destFile.toPath());
		//			LOG.error("Copy file source: " + sourceFile.toPath());
		//			LOG.error("Copy file destination: " + destFile.toPath());
		//			LOG.error("-----------Copy file to Ares fin--------------------");
		//
		//		}
		//		catch (final Exception e)
		//		{
		//			LOG.error("Error occurs: " + e);
		//		}

        try{
            randomAccessFile = new RandomAccessFile(zipFilePath, "r");
            inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));
            simpleInArchive = inArchive.getSimpleInterface();

            for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()){
                final int[] hash = new int[] { 0 };
				if (item.getPath().contains(".txt") || item.getPath().contains(".TXT"))
				{
                    ExtractOperationResult result;
                    final long[] sizeArray = new long[1];

                    result = item.extractSlow(new ISequentialOutStream() {
                        public int write(final byte[] data) throws SevenZipException {

                            //Write to file
                            System.out.println(item.getPath());
                            FileOutputStream fos;
                            try {
                                final File file = new File(targetFilePath + item.getPath());
                                file.getParentFile().mkdirs();
                                fos = new FileOutputStream(file);
                                fos.write(data);
                                fos.close();

                            } catch (final FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                LOG.error("Error extracting item: " + e.toString());
                            } catch (final IOException e) {
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
        }catch (final Exception e) {
            LOG.error("Error occurs: " + e);
        }finally {
            if (inArchive != null) {
                try {
                    inArchive.close();
                } catch (final SevenZipException e) {
                    LOG.error("Error closing archive: " + e);
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (final IOException e) {
                    LOG.error("Error closing file: " + e);
                }
            }
        }
    }

    @Override
	public String verifyFile(final String source, final String target, final String autoridades)
	{
        boolean isValidCertificate = false;
		String respuesta = null;
        FileSignVerifier fv = null;
        String resultado = "";
        final CACertificateManager caManager = new CACertificateManager();

        try {
            caManager.setPathTrustedCA(autoridades);
            fv = new FileSignVerifier(caManager);
            resultado = fv.signatureCheck(source, target);

			// Si la validación es exitosa el resultado es OK​, sino se retorna un mensaje con el error
			if (resultado.equalsIgnoreCase("OK"))
			{
				isValidCertificate = true;
				respuesta = null;
				LOG.info("Firmantes Del Archivo OK" + source);
				// Se recorre el arreglo de firmantes​
				for (final SignerInfo signer : fv.getSigners())
				{
					// aquí se consultan los OIDs que se requieran para el ejemplo solo puse el Common Name​
					LOG.info(signer.getOID("CN"));
				}
			}
			else
			{
				respuesta = "Error al validar la firma digital";
				LOG.info("Firmantes Del Archivo FAIL" + source);
			}


        } catch (final Exception e) {
			respuesta = "Error en los certificados digitales";
            e.printStackTrace();
        }

        LOG.info("VerifyFile");
        LOG.info("Resultado " + resultado);
        LOG.info("autoridadesFolderPath: " + autoridades);
        LOG.info("verifyFile Source: " + source);
        LOG.info("verifyFile Target: " + target);
		return respuesta;
    }

    @Override
    public FileConciliaResponse fileConcilia(final FileConciliaRequest fileConciliaRequest) {
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
