package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.services.SDHGestionBancaria;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

public class DefaultSDHGestionBancaria implements SDHGestionBancaria {
    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public boolean validade7ZipCertificates(MultipartFile multipartFile) {
        this.updateFileToServer(multipartFile);
        return false;
    }

    @Override
    public String updateFileToServer(MultipartFile multipartFile){
        String filePath = null;
        String corePath = configurationService.getConfiguration().getString("gestion.bancaria.certificados.path");

        try {
            filePath = corePath +  multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(filePath) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

}
