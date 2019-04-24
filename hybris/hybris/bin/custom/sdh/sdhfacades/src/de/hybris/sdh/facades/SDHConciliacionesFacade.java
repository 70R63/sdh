/**
 *
 */
package de.hybris.sdh.facades;

import org.springframework.web.multipart.MultipartFile;

import sun.security.provider.certpath.OCSP.RevocationStatus.CertStatus;


/**
 * @author hybris
 *
 */
public interface SDHConciliacionesFacade
{
	void processConciliacionesFile(MultipartFile file);

	CertStatus checkCertificates(MultipartFile multipartFile);
}
