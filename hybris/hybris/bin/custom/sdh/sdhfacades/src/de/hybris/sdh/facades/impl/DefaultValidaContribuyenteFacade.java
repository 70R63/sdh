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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		final String date = request.getExpeditionDate();

		final LocalDate customerExpDate;

		try
		{
			customerExpDate = LocalDate.parse(date, formatter);

			request.setExpeditionDate(formatter.format(customerExpDate));
		}
		catch (final DateTimeParseException e1)
		{
			LOG.error("Error parsing expedition date: " + date);
			return false;
		}

		final String response = sdhValidaContribuyenteService.validaContribuyente(request);

		if (StringUtils.isBlank(response))
		{
			return false;
		}


		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			final SDHValidaMailRolResponse sdhValidaMailRolResponse = mapper.readValue(response, SDHValidaMailRolResponse.class);

			if (sdhValidaMailRolResponse != null && sdhValidaMailRolResponse.getIdmsj() == 0
					&& sdhValidaMailRolResponse.getInfoContrib() != null
					&& sdhValidaMailRolResponse.getInfoContrib().getNumBP() != null
					&& sdhValidaMailRolResponse.getInfoContrib().getAdicionales() != null
					&& sdhValidaMailRolResponse.getInfoContrib().getAdicionales().getSMTP_ADDR() != null)
			{
				sessionService.setAttribute("numBP", sdhValidaMailRolResponse.getInfoContrib().getNumBP());

				sessionService.setAttribute("SMTP_ADDR", sdhValidaMailRolResponse.getInfoContrib().getAdicionales().getSMTP_ADDR());

				return true;
			}
		}
		catch (final IOException e)
		{
			// XXX Auto-generated catch block
			LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
		}
		return false;
	}


}
