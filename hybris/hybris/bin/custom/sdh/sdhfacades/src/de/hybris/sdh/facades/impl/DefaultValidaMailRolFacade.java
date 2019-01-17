/**
 *
 */
package de.hybris.sdh.facades.impl;

import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.ValidaMailRolRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHValidaMailRolService;
import de.hybris.sdh.facades.SDHValidaMailRolFacade;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author hybris
 *
 */
public class DefaultValidaMailRolFacade implements SDHValidaMailRolFacade
{

	private static final Logger LOG = Logger.getLogger(DefaultValidaMailRolFacade.class);

	@Resource(name = "sdhValidaMailRolService")
	SDHValidaMailRolService sdhValidaMailRolService;

	@Resource(name = "sessionService")
	SessionService sessionService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.facades.SDHValidaMailRolFacade#isValidEmail(de.hybris.sdh.core.pojos.requests.ValidaMailRolRequest)
	 */
	@Override
	public boolean validaEmail(final ValidaMailRolRequest request)
	{
		final String response = sdhValidaMailRolService.validaMailRol(request);

		if (StringUtils.isBlank(response))
		{
			return false;
		}

		if (response.contains("BP, Encontrado"))
		{
			//before sending valid save result on session


			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				final SDHValidaMailRolResponse sdhValidaMailRolResponse = mapper.readValue(response, SDHValidaMailRolResponse.class);

				sessionService.setAttribute("sdhValidaMailRolResponse", sdhValidaMailRolResponse);
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
