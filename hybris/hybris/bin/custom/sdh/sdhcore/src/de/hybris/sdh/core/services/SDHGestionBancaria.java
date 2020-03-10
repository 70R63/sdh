/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.pojos.requests.FileConciliaRequest;
import de.hybris.sdh.core.pojos.responses.FileConciliaResponse;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hybris
 *
 */
public interface SDHGestionBancaria
{
	String validade7ZipCertificates(MultipartFile multipartFile);
	String updateFileToServer(MultipartFile multipartFile) throws IOException;
	void extractAndUpdateTxtFileFrom7zip(String zipFilePath, String targetFilePath);
	String verifyFile(String source, String target, String autoridades);
	FileConciliaResponse fileConcilia(FileConciliaRequest request);
}
