package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaImpuesto_simplificado;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


public class DefaultSDHConsultaImpuesto_simplificado implements SDHConsultaImpuesto_simplificado
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaImpuesto_simplificado.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
	public List<ImpuestoVehiculos> consulta_impVehicular(final ConsultaContribuyenteBPRequest wsRequest)
	{
		SDHValidaMailRolResponse wsResponse = null;
		List<ImpuestoVehiculos> impuestosVehiculos = null;
		final ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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

	public String consulta_impVehicular_string(final ConsultaContribuyenteBPRequest wsRequest)
	{
		final String usuario = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.user");
		final String password = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.password");
		final String urlService = configurationService.getConfiguration()
				.getString("sdh.validacontribuyente_simplificado_impVehicular.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(wsRequest);

		LOG.info(wsRequest);
		final String wsResponse = restTemplate.postForObject(urlService, request, String.class);
		LOG.info(wsResponse);


		return wsResponse;
	}

}
