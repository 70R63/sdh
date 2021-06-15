/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.model.SDHContribTaxModel;
import de.hybris.sdh.core.pojos.requests.ConsultaContribBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.ImpuestosResponse;
import de.hybris.sdh.core.pojos.responses.InfoContribResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * @author hybris
 *
 */
public class DefaultSDHConsultaContribuyenteBPService implements SDHConsultaContribuyenteBPService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaContribuyenteBPService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService#consultaContribuyenteBP(de.hybris.sdh.core.pojos.
	 * requests.ConsultaContribuyenteBPRequest)
	 */
	@Override
	public String consultaContribuyenteBP(final ConsultaContribuyenteBPRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.validacontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.validacontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.validacontribuyente.password");


		final long startTime = System.currentTimeMillis();


		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while validating contribuyente: Empty credentials");
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info("connection to: " + conn.toString());

			final String requestJson = request.toString();
			LOG.info("request: " + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}


			final String result = builder.toString();
			LOG.info("response: " + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error validating a contribuyente: " + e.getMessage());
		}

		final long endTime = System.currentTimeMillis();
        LOG.info("executed in [" + ((endTime - startTime) / 1000) + "] seconds. ");


		// XXX Auto-generated method stub
		return null;
	}

	public String consultaContribuyenteBP_simplificado_string(final ConsultaContribBPRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.validacontribuyente_simplificado.url");
		final String user = configurationService.getConfiguration().getString("sdh.validacontribuyente_simplificado.user");
		final String password = configurationService.getConfiguration().getString("sdh.validacontribuyente_simplificado.password");


		final long startTime = System.currentTimeMillis();


		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while validating contribuyente: Empty credentials");
		}

		try
		{
			final URL url = new URL(urlString);

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			final String authString = user + ":" + password;
			final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			LOG.info("connection to: " + conn.toString());

			final String requestJson = request.toString();
			LOG.info("request: " + requestJson);

			final OutputStream os = conn.getOutputStream();
			os.write(requestJson.getBytes());
			os.flush();
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			final StringBuilder builder = new StringBuilder();

			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				builder.append(inputLine);
			}


			String result = builder.toString();

			result = result.replaceAll(",\"\"", "");
			result = result.replaceAll("\"\",", "");

			LOG.info("response: " + result);

			return result;

		}
		catch (final Exception e)
		{
			LOG.error("There was an error validating a contribuyente: " + e.getMessage());
		}

		final long endTime = System.currentTimeMillis();
		LOG.info("executed in [" + ((endTime - startTime) / 1000) + "] seconds. ");


		return null;
	}


	@Override
	public SDHValidaMailRolResponse consultaContribuyenteBP_simplificado(final ConsultaContribBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consultaContribuyenteBP_simplificado_string(wsRequest), SDHValidaMailRolResponse.class);
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Vehicular");
		}

		return wsResponse;
	}


	@Override
	public String getEntidadBancaria(final String bp) {
		final ConsultaContribuyenteBPRequest consultaContribuyenteBPRequest = new ConsultaContribuyenteBPRequest();
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;
		consultaContribuyenteBPRequest.setNumBP(bp);
		String entidad = "";

		try{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			sdhConsultaContribuyenteBPResponse = mapper.readValue(
					this.consultaContribuyenteBP(consultaContribuyenteBPRequest),
					SDHValidaMailRolResponse.class);

		}catch (final Exception e){
			LOG.error("error getting customer info from SAP: " + e.getMessage());
		}

		if (Objects.nonNull(sdhConsultaContribuyenteBPResponse)){
			final List<ContribAgente> agentes  = sdhConsultaContribuyenteBPResponse.getAgentes();
			if(Objects.nonNull(agentes)){
				for(final ContribAgente agente : agentes){
					final String entidadBancaria = agente.getEntBanco();
					LOG.debug(agente);
					if(Objects.nonNull(entidadBancaria)){
						if(!entidadBancaria.equals("")){
							entidad = entidadBancaria;
						}
					}
				}
			}
		}

		return entidad;
	}

	public SDHValidaMailRolResponse mapearInfo(final CustomerModel customerModel)
	{
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;

		if (customerModel != null)
		{
			sdhConsultaContribuyenteBPResponse = new SDHValidaMailRolResponse();

			sdhConsultaContribuyenteBPResponse.setImpuestos(mapearImpuestos(customerModel.getContribTaxList()));
		}

		return sdhConsultaContribuyenteBPResponse;
	}

	/**
	 * @param contribTaxList
	 * @return
	 */
	public List<ImpuestosResponse> mapearImpuestos(final List<SDHContribTaxModel> contribTaxList)
	{
		List<ImpuestosResponse> impuestosResponse = null;

		if (contribTaxList != null)
		{
			impuestosResponse = new ArrayList<ImpuestosResponse>();
			ImpuestosResponse elementoImpuestosResponse = null;

			for (final SDHContribTaxModel elementoContribTaxList : contribTaxList)
			{
				elementoImpuestosResponse = new ImpuestosResponse();

				elementoImpuestosResponse.setCantObjetos(elementoContribTaxList.getCantObjetos());
				elementoImpuestosResponse.setClaseObjeto(elementoContribTaxList.getClaseObjeto());

				impuestosResponse.add(elementoImpuestosResponse);
			}
		}


		return impuestosResponse;
	}

	public InfoContribResponse mapearInfoContrib()
	{
		final InfoContribResponse infoContrib = null;



		return infoContrib;
	}


}
