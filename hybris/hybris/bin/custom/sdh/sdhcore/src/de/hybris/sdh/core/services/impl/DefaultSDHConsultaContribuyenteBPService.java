/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ContribAgente;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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



		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public String getEntidadBancaria(String bp) {
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
			List<ContribAgente> agentes  = sdhConsultaContribuyenteBPResponse.getAgentes();
			if(Objects.nonNull(agentes)){
				for(ContribAgente agente : agentes){
					String entidadBancaria = agente.getEntBanco();
					LOG.info(agente);
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

}
