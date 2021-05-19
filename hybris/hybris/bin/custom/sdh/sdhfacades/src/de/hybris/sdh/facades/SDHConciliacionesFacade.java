/**
 *
 */
package de.hybris.sdh.facades;

import org.springframework.web.multipart.MultipartFile;

//import sun.security.provider.certpath.OCSP.RevocationStatus.CertStatus;


/**
 * @author hybris
 *
 */
public interface SDHConciliacionesFacade
{
	void processConciliacionesFile(MultipartFile file);

	//TODO revisar este metodo para utilizar otra alternativa o buscar la librería correspondiente
	//CertStatus checkCertificates(MultipartFile multipartFile);

	void validade7ZipCertificates(MultipartFile multipartFile);
}
