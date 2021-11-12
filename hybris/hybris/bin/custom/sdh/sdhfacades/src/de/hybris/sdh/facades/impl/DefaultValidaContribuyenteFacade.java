/**
 *
 */
package de.hybris.sdh.facades.impl;

import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.ConsultarBPRequest;
import de.hybris.sdh.core.pojos.responses.ConsultarBPResponse;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import de.hybris.sdh.facades.SDHValidaContribuyenteFacade;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



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

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHValidaContribuyenteFacade#existeContribuyente(de.hybris.sdh.core.pojos.requests.
	 * ValidaContribuyenteRequest)
	 */
	@Override
	public boolean existeContribuyente(final ConsultarBPRequest request)
	{


		if ("CC".equalsIgnoreCase(request.getTipoid()))
		{
			final DateTimeFormatter formatterOriginal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			final DateTimeFormatter formatterConvertido = DateTimeFormatter.ofPattern("yyyyMMdd");

			final String fechaOriginal = request.getFechExp();

			try
			{
				final String customerExpDate = LocalDate.parse(fechaOriginal, formatterOriginal).format(formatterConvertido);
				request.setFechExp(customerExpDate);
			}
			catch (final DateTimeParseException e1)
			{
				LOG.error("Error parsing expedition date: " + fechaOriginal);
				return false;
			}


		}




		final String response = sdhValidaContribuyenteService.consultarBP(request);

		if (StringUtils.isBlank(response))
		{
			return false;
		}

		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			final ConsultarBPResponse consultarBPResponse = mapper.readValue(response, ConsultarBPResponse.class);

			if (consultarBPResponse != null && consultarBPResponse.getNumBP() != null)
			{
				sessionService.setAttribute("numBP", consultarBPResponse.getNumBP());

				sessionService.setAttribute("documentNumber", request.getNumid());

				sessionService.setAttribute("documentType", request.getTipoid());

				if (consultarBPResponse.getSmtp_addr() != null)
				{
					sessionService.setAttribute("SMTP_ADDR", consultarBPResponse.getSmtp_addr());
				}

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
