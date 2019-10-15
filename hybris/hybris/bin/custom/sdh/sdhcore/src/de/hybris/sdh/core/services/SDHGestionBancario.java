/**
 *
 */
package de.hybris.sdh.core.services;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author hybris
 *
 */
public interface SDHGestionBancario
{
	void uploadFile(CommonsMultipartFile file);
}
