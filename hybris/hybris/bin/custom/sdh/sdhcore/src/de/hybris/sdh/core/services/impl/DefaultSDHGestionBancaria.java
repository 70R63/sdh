package de.hybris.sdh.core.services.impl;

import com.bdg.ca.CACertificateManager;
import com.bdg.verifiers.FileSignVerifier;
import com.bdg.verifiers.SignerInfo;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.services.SDHGestionBancaria;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.apache.log4j.Logger;

public class DefaultSDHGestionBancaria implements SDHGestionBancaria {

    private static final Logger LOG = Logger.getLogger(DefaultSDHGestionBancaria.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public boolean validade7ZipCertificates(MultipartFile multipartFile) {
        String updatedFilesFolder = configurationService.getConfiguration().getString("gestion.bancaria.certificados.path");
        String approvedFilesFolder = configurationService.getConfiguration().getString("gestion.bancaria.certificados.aprobados.path");
        boolean isValid = false;

        String nameFile = this.updateFileToServer(multipartFile);
        if(Objects.nonNull(nameFile)){
            isValid =  this.verifyFile(updatedFilesFolder + nameFile , approvedFilesFolder + nameFile);
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
        return fileName;
    }

    public boolean verifyFile(String source, String target){
        boolean isValidCertificate = false;
        FileSignVerifier fv = null;
        String resultado = "";
        CACertificateManager caManager = new CACertificateManager();
        String autoridadesPath = configurationService.getConfiguration().getString("gestion.bancaria.certificados.autoridades.path");


        try {
            caManager.setPathTrustedCA(autoridadesPath);
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
        LOG.info("autoridadesFolderPath: " + autoridadesPath);
        return isValidCertificate;
    }

}
