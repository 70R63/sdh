/**
 *
 */
package de.hybris.sdh.facades.impl;

import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.facades.SDHValidaContribuyenteFacade;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author hybris
 *
 */
public class DefaultValidaContribuyenteFacade implements SDHValidaContribuyenteFacade
{

	private static final Logger LOG = Logger.getLogger(DefaultValidaContribuyenteFacade.class);

	@Resource(name = "sdhValidaContribuyenteService")
	SDHValidaContribuyenteService sdhValidaContribuyenteService;

	@Resource(name = "sessionService")
	SessionService sessionService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHValidaContribuyenteFacade#existeContribuyente(de.hybris.sdh.core.pojos.requests.
	 * ValidaContribuyenteRequest)
	 */
	@Override
	public boolean existeContribuyente(final ValidaContribuyenteRequest request)
	{
		final String response = sdhValidaContribuyenteService.validaContribuyente(request);

		if (StringUtils.isBlank(response))
		{
			return false;
		}

		if (response.contains("Registro encontrado"))
		{

			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final SDHValidaMailRolResponse sdhValidaMailRolResponse = mapper.readValue(response, SDHValidaMailRolResponse.class);

				if (sdhValidaMailRolResponse != null
						&& sdhValidaMailRolResponse.getInfoContrib() != null
						&& sdhValidaMailRolResponse.getInfoContrib().getAdicionales() != null
						&& sdhValidaMailRolResponse.getInfoContrib().getAdicionales().getSMTP_ADDR() != null)
				{
					if (sdhValidaMailRolResponse.getInfoContrib().getNumBP() != null)
					{
						sessionService.setAttribute("numBP", sdhValidaMailRolResponse.getInfoContrib().getNumBP());
					}

					sessionService.setAttribute("SMTP_ADDR", sdhValidaMailRolResponse.getInfoContrib().getAdicionales().getSMTP_ADDR());
				}
			}
			catch (final IOException e)
			{
				// XXX Auto-generated catch block
				LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
			}

			return true;
		}

		return false;
	}


}
