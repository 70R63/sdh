/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.LogReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaFileStatusInTRMRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaRequest;
import de.hybris.sdh.core.pojos.responses.CalculoReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.LogReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.ReteIcaResponse;

import org.springframework.web.multipart.MultipartFile;


/**
 * @author hybris
 *
 */
public interface SDHReteIcaFacade
{
	ReteIcaResponse reteICA(ReteIcaRequest request);

	ReteIcaResponse reteICAMock(ReteIcaRequest request);

	CalculoReteIcaResponse calculo(CalculoReteIcaRequest request);

	LogReteIcaResponse logReteICA(LogReteIcaRequest request);

	Boolean sendFile(MultipartFile multipartFile);

	Boolean writeFile(MultipartFile multipartFile, String numBP, String numObjeto);

	String getFileStatusInTRM(ReteIcaFileStatusInTRMRequest request);

}
