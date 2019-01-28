/**
 *
 */
package de.hybris.sdh.facades.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.CertifNombRequest;
import de.hybris.sdh.core.pojos.responses.CertifNombResponse;
import de.hybris.sdh.core.services.SDHCertifNombService;
import de.hybris.sdh.facades.SDHCertifNombFacade;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author hybris
 *
 */
public class DefaultSDHCertifNombFacade implements SDHCertifNombFacade
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHCertifNombFacade.class);

	@Resource(name = "sdhCertifNombService")
	private SDHCertifNombService sdhCertifNombService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHCertifNombFacade#certifNomb(de.hybris.sdh.core.pojos.requests.CertifNombRequest)
	 */
	@Override
	public CertifNombResponse certifNomb(final CertifNombRequest request)
	{
		final String response = sdhCertifNombService.certifNomb(request);

		final Double minPercentage = configurationService.getConfiguration().getDouble("sdh.certifNomb.authorization.percentage", 0.90);

		try
		{

			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			final CertifNombResponse certifNombResponse = mapper.readValue(response, CertifNombResponse.class);

			if(certifNombResponse != null && certifNombResponse.getPorcentaje()!= null && certifNombResponse.getPorcentaje() >= minPercentage)
			{
				certifNombResponse.setSuccess(Boolean.TRUE);
			}
			else
			{
				certifNombResponse.setSuccess(Boolean.FALSE);
			}

			certifNombResponse.setMinPercentage(minPercentage);

			return certifNombResponse;

		}
		catch (final Exception e)
		{
			// XXX Auto-generated catch block
			LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());

			final CertifNombResponse certifNombResponse = new CertifNombResponse();

			certifNombResponse.setSuccess(Boolean.FALSE);

			return certifNombResponse;

		}

	}


}
