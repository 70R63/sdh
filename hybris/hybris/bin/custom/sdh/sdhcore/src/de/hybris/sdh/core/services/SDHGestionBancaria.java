/**
 *
 */
package de.hybris.sdh.core.services;


import de.hybris.sdh.core.pojos.requests.FileConciliaRequest;
import de.hybris.sdh.core.pojos.responses.FileConciliaResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hybris
 *
 */
public interface SDHGestionBancaria
{
	boolean validade7ZipCertificates(MultipartFile multipartFile);
	String updateFileToServer(MultipartFile multipartFile) throws IOException;
	boolean verifyFile(String source, String target, String autoridades);
	FileConciliaResponse fileConcilia(FileConciliaRequest request);
}
