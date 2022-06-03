/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


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
		final String timeout = configurationService.getConfiguration().getString("sdh.validacontribuyente_simplificado.timeout");
		int valTimeOut = 0;

		final long startTime = System.currentTimeMillis();


		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while validating contribuyente: Empty credentials");
		}
		if (!StringUtils.isBlank(timeout))
		{
			valTimeOut = Integer.valueOf(timeout).intValue();
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
			conn.setConnectTimeout(valTimeOut);
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
		if (wsRequest.getIndicador() == null)
		{
			wsRequest.setIndicador("01");
		}
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consultaContribuyenteBP_simplificado_string(wsRequest), SDHValidaMailRolResponse.class);
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de validaContrib: "+e.getMessage());
		}

		return wsResponse;
	}

	@Override
	public SDHValidaMailRolResponse consultaContribuyenteBP_simplificado(final ConsultaContribuyenteBPRequest wsRequestOriginal)
	{
		SDHValidaMailRolResponse wsResponse = null;


		if (wsRequestOriginal != null)
		{
			final ConsultaContribBPRequest wsRequest = new ConsultaContribBPRequest();
			final ObjectMapper mapper = new ObjectMapper();

			wsRequest.setIndicador("01");
			wsRequest.setNumBP(wsRequestOriginal.getNumBP());
			wsResponse = consultaContribuyenteBP_simplificado(wsRequest);

		}
		else
		{
			LOG.info("El request para el WS es null");
		}


		return wsResponse;
	}


	@Override
	public String getEntidadBancaria(final String bp) {
		final ConsultaContribBPRequest consultaContribuyenteBPRequest = new ConsultaContribBPRequest();
		SDHValidaMailRolResponse sdhConsultaContribuyenteBPResponse = null;
		consultaContribuyenteBPRequest.setNumBP(bp);
		consultaContribuyenteBPRequest.setIndicador("01,02");
		String entidad = "";

		try{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			sdhConsultaContribuyenteBPResponse = consultaContribuyenteBP_simplificado(consultaContribuyenteBPRequest);
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


	public InfoContribResponse mapearInfoContrib()
	{
		final InfoContribResponse infoContrib = null;



		return infoContrib;
	}

	@Override
	public boolean tieneImpuestoActivo(final SDHValidaMailRolResponse infoContrib, final String claveImpuesto)
	{
		boolean validacionImpuesto = false;
		List<ImpuestosResponse> impuestos = null;
		List<ImpuestosResponse> impuestos_tmp = null;
		int cantidadRegistros = 0;

		if (claveImpuesto != null && StringUtils.isNotBlank(claveImpuesto) && infoContrib != null
				&& infoContrib.getImpuestos() != null && !infoContrib.getImpuestos().isEmpty())
		{
			impuestos = infoContrib.getImpuestos().stream().collect(Collectors.toList());
			String claveImpuestoBusqueda_tmp = claveImpuesto;
			if (claveImpuesto.length() == 4)
			{
				claveImpuestoBusqueda_tmp = claveImpuesto.substring(2);
			}
			final String claveImpuestoBusqueda = claveImpuestoBusqueda_tmp;

			impuestos_tmp = impuestos.stream().filter(eachTax -> claveImpuestoBusqueda.equals(eachTax.getClaseObjeto()))
					.collect(Collectors.toList());
			if (impuestos_tmp.size() > 0)
			{
				final ImpuestosResponse impuestoActivo = impuestos_tmp.get(0);
				if (impuestoActivo != null && claveImpuestoBusqueda_tmp.equals(impuestoActivo.getClaseObjeto())
						&& impuestoActivo.getCantObjetos() != null)
				{
					try
					{
						final String cantidadRegistros_str = impuestoActivo.getCantObjetos().trim();
						cantidadRegistros = Integer.parseInt(cantidadRegistros_str);
					}
					catch (final Exception e)
					{
						LOG.error("Error al determinar cantidad de registros para impuesto activo de cliente: " + e.getMessage());
					}
				}
			}
		}

		if (cantidadRegistros > 0)
		{
			validacionImpuesto = true;
		}

		return validacionImpuesto;
	}


}
