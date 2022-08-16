package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.util.Config;
import de.hybris.sdh.core.pojos.requests.ConsultaContribPredialRequest;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.ReteICA;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class DefaultSDHConsultaImpuesto_simplificado implements SDHConsultaImpuesto_simplificado
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaImpuesto_simplificado.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;


	//Vehicular
    @Override
	public List<ImpuestoVehiculos> consulta_impVehicular(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoVehiculos> impuestosVehiculos = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impVehicular_string(wsRequest), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosVehiculos = wsResponse.getVehicular();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Vehicular");
		}


		return impuestosVehiculos;
	}


	@Override
	public String consulta_impVehicular_string(final Object wsRequest)
	{
		final String usuario = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.user");
		final String password = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.password");
		final String urlService = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.url");
		String wsResponse = null;

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));

		LOG.info(urlService);
		if (wsRequest instanceof ConsultaContribuyenteBPRequest)
		{
			((ConsultaContribuyenteBPRequest) wsRequest)
					.setNumBP(StringUtils.leftPad(((ConsultaContribuyenteBPRequest) wsRequest).getNumBP(), 10, "0"));
			final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>((ConsultaContribuyenteBPRequest) wsRequest);
			LOG.info(wsRequest);
			wsResponse = restTemplate.postForObject(urlService, request, String.class);
		}
		else if (wsRequest instanceof ConsultaContribPredialRequest)
		{
			((ConsultaContribPredialRequest) wsRequest)
					.setNumBP(StringUtils.leftPad(((ConsultaContribPredialRequest) wsRequest).getNumBP(), 10, "0"));
			final HttpEntity<ConsultaContribPredialRequest> request = new HttpEntity<>((ConsultaContribPredialRequest) wsRequest);
			LOG.info(wsRequest);
			wsResponse = restTemplate.postForObject(urlService, request, String.class);
		}
		LOG.info(wsResponse);


		return wsResponse;
	}

	@Override
	public List<ImpuestoVehiculos> consulta_impVehicular2(final ConsultaContribPredialRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoVehiculos> impuestosVehiculos = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impVehicular_string(wsRequest), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosVehiculos = wsResponse.getVehicular();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Vehicular");
		}


		return impuestosVehiculos;
	}


	//Gasolina
	@Override
	public List<ImpuestoGasolina> consulta_impGasolina(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoGasolina> impuestosGasolina = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impGasolina_string(wsRequest), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosGasolina = wsResponse.getGasolina();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Gasolina");
		}


		return impuestosGasolina;
	}


	@Override
	public String consulta_impGasolina_string(final ConsultaContribuyenteBPRequest request)
	{

		final String urlString = configurationService.getConfiguration().getString("sdh.gasolinaSimpli.url");
		final String user = configurationService.getConfiguration().getString("sdh.gasolinaSimpli.user");
		final String password = configurationService.getConfiguration().getString("sdh.gasolinaSimpli.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error in Consulta Gasolina: Empty credentials");
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
			LOG.error("There was an error in Consulta Gasolina: " + e.getMessage());
		}



		// XXX Auto-generated method stub
		return null;

	}



	//Delineacion
	@Override
	public List<ImpuestoDelineacionUrbana> consulta_impDelineacion(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoDelineacionUrbana> impuestosDelineacion = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impDelineacion_string(wsRequest), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosDelineacion = wsResponse.getDelineacion();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Delineacion");
		}


		return impuestosDelineacion;
	}


	@Override
	public SDHValidaMailRolResponse consulta_impDelineacion_valCont(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		final List<ImpuestoDelineacionUrbana> impuestosDelineacion = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impDelineacion_string(wsRequest), SDHValidaMailRolResponse.class);
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Delineacion");
		}


		return wsResponse;
	}


	@Override
	public String consulta_impDelineacion_string(final ConsultaContribuyenteBPRequest wsRequest)
	{
		final String usuario = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impDelineacion.user");
		final String password = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impDelineacion.password");
		final String urlService = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impDelineacion.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(wsRequest);

		LOG.info(urlService);
		LOG.info(wsRequest);
		final String wsResponse = restTemplate.postForObject(urlService, request, String.class);
		LOG.info(wsResponse);


		return wsResponse;
	}



	//Publicidad
	@Override
	public List<ImpuestoPublicidadExterior> consulta_impPublicidad(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoPublicidadExterior> impuestosPublicidad = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impPublicidad_string(wsRequest), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosPublicidad = wsResponse.getPublicidadExt();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Publicidad Exterior:" + e.getMessage());
		}


		return impuestosPublicidad;
	}



	@Override
	public String consulta_impPublicidad_string(final ConsultaContribuyenteBPRequest wsRequest)
	{
		final String usuario = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impPublicidad.user");
		final String password = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impPublicidad.password");
		final String urlService = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impPublicidad.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(wsRequest);

		LOG.info(urlService);
		LOG.info(wsRequest);
		final String wsResponse = restTemplate.postForObject(urlService, request, String.class);
		LOG.info(wsResponse);


		return wsResponse;
	}





	//Predial
	@Override
	public List<PredialResponse> consulta_impPredial(final ConsultaContribuyenteBPRequest request)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<PredialResponse> impuestosPredial = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impPredial_string(request), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosPredial = wsResponse.getPredial();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Predial" + e.getMessage());
		}


		return impuestosPredial;
	}



	public String consulta_impPredial_string(final Object wsRequest)
	{
		final String usuario = configurationService.getConfiguration().getString("sdh.ingreso.impPredial.user");
		final String password = configurationService.getConfiguration().getString("sdh.ingreso.impPredial.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.ingreso.impPredial.url");
		String wsResponse = null;

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));

		LOG.info(urlService);
		if (wsRequest instanceof ConsultaContribuyenteBPRequest)
		{
			((ConsultaContribuyenteBPRequest) wsRequest)
					.setNumBP(StringUtils.leftPad(((ConsultaContribuyenteBPRequest) wsRequest).getNumBP(), 10, "0"));
			final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>((ConsultaContribuyenteBPRequest) wsRequest);
			LOG.info(wsRequest);
			wsResponse = restTemplate.postForObject(urlService, request, String.class);
		}
		else if (wsRequest instanceof ConsultaContribPredialRequest)
		{
			((ConsultaContribPredialRequest) wsRequest)
					.setNumBP(StringUtils.leftPad(((ConsultaContribPredialRequest) wsRequest).getNumBP(), 10, "0"));
			final HttpEntity<ConsultaContribPredialRequest> request = new HttpEntity<>((ConsultaContribPredialRequest) wsRequest);
			LOG.info(wsRequest);
			wsResponse = restTemplate.postForObject(urlService, request, String.class);
		}
		LOG.info(wsResponse);


		return wsResponse;
	}


	//Predial
	@Override
	public List<PredialResponse> consulta_impPredial2(final ConsultaContribPredialRequest request)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<PredialResponse> impuestosPredial = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impPredial_string(request), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosPredial = wsResponse.getPredial();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto Predial");
		}


		return impuestosPredial;
	}


	@Override
	public ImpuestoICA consulta_impICA(final ConsultaContribuyenteBPRequest request)
	{
		SDHValidaMailRolResponse wsResponse = null;
		ImpuestoICA impuestosICA = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			wsResponse = mapper.readValue(consulta_impICA_string(request), SDHValidaMailRolResponse.class);
			if (wsResponse != null)
			{
				impuestosICA = wsResponse.getIca();
			}
		}
		catch (final Exception e)
		{
			LOG.info("Error al convertir response de consulta impuesto ICA");
		}


		return impuestosICA;

	}

	@Override
	public String consulta_impICA_string(final ConsultaContribuyenteBPRequest wsRequest)
	{
		final String usuario = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impICA.user");
		final String password = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impICA.password");
		final String urlService = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impICA.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(wsRequest);

		LOG.info(urlService);
		LOG.info(wsRequest);
		String wsResponse = restTemplate.postForObject(urlService, request, String.class);
		wsResponse = wsResponse.replaceAll("numOjbeto", "numObjeto");
		LOG.info(wsResponse);


		return wsResponse;
	}


    @Override
    public ReteICA consulta_impReteICA(final ConsultaContribuyenteBPRequest request)
    {
        SDHValidaMailRolResponse wsResponse = null;
        ReteICA impuestoReteICA = null;
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try
        {
            wsResponse = mapper.readValue(consulta_impReteICA_string(request), SDHValidaMailRolResponse.class);
            if (wsResponse != null)
            {
                impuestoReteICA = wsResponse.getReteIca();
            }

        }
        catch (final Exception e)
        {
			  LOG.info("Error al convertir response de consulta impuesto ReteICA");
        }


        return impuestoReteICA;

    }

    @Override
    public String consulta_impReteICA_string(final ConsultaContribuyenteBPRequest wsRequest)
    {
        final String usuario = configurationService.getConfiguration()
                .getString("sdh.validacontribuyente_simplificado_impReteICA.user");
        final String password = configurationService.getConfiguration()
                .getString("sdh.validacontribuyente_simplificado_impReteICA.password");
        final String urlService = configurationService.getConfiguration()
                .getString("sdh.validacontribuyente_simplificado_impReteICA.url");

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
        final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(wsRequest);

        LOG.info(urlService);
        LOG.info(wsRequest);
        String wsResponse = restTemplate.postForObject(urlService, request, String.class);
        wsResponse = wsResponse.replaceAll("numOjbeto", "numObjeto");
        LOG.info(wsResponse);


        return wsResponse;
    }




	@Override
	public Map<String, String> obtenerListaImpuestosActivos(final String ambito)
	{
		final Map<String, String> elementos = new LinkedHashMap<String, String>();
		final String impReteIca = "impuestosActivos." + ambito + ".reteica";
        final String reteIcaActivo = Config.getParameter(impReteIca);


		elementos.put(SDHConsultaImpuesto_simplificado.PREDIAL, Config.getParameter("impuestosActivos." + ambito + ".predial"));
		elementos.put(SDHConsultaImpuesto_simplificado.VEHICULOS, Config.getParameter("impuestosActivos." + ambito + ".vehiculos"));
		elementos.put(SDHConsultaImpuesto_simplificado.ICA, Config.getParameter("impuestosActivos." + ambito + ".ica"));
		elementos.put(SDHConsultaImpuesto_simplificado.RETEICA, Config.getParameter("impuestosActivos." + ambito + ".reteica"));
		elementos.put(SDHConsultaImpuesto_simplificado.GASOLINA, Config.getParameter("impuestosActivos." + ambito + ".gasolina"));
		elementos.put(SDHConsultaImpuesto_simplificado.DELINEACION,
				Config.getParameter("impuestosActivos." + ambito + ".delineacion"));
		elementos.put(SDHConsultaImpuesto_simplificado.PUBLICIDAD,
				Config.getParameter("impuestosActivos." + ambito + ".publicidad"));


		return elementos;
	}


	@Override
	public boolean esImpuestoActivo(final Map<String, String> impuestosActivos, final String claveImpuesto)
	{
		boolean validacionOK = false;

		if (impuestosActivos != null && "X".equals(impuestosActivos.get(claveImpuesto)))
		{
			validacionOK = true;
		}


		return validacionOK;
	}


	@Override
	public String getAnioGravableActual_impDelineacion()
	{
		return getAnioGravableActual_generico();
	}


	/**
	 * @return
	 */
	private String getAnioGravableActual_generico()
	{
		final Calendar now = Calendar.getInstance();
		final int year = now.get(Calendar.YEAR);
		final String yearInString = String.valueOf(year);


		return yearInString;
	}

}
