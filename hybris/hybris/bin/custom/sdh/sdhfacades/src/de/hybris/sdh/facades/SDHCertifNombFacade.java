/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.CertifNombRequest;
import de.hybris.sdh.core.pojos.responses.CertifNombResponse;

/**
 * @author hybris
 *
 */
public interface SDHCertifNombFacade
{
	CertifNombResponse certifNomb(CertifNombRequest request);
}
