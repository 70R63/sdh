/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.QuestionForRegistrationResponse;
import de.hybris.sdh.core.services.SDHGetQuestionsForRegistration;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


/**
 * @author Consultor
 *
 */
public class DefaultSDHGetQuestionsForRegistration implements SDHGetQuestionsForRegistration
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHGetQuestionsForRegistration.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	@Override
	public QuestionForRegistrationResponse getQuestionForRegistration(final ConsultaContribuyenteBPRequest requestObject)
	{
		final String usuario = configurationService.getConfiguration().getString("sdh.preguntareto.user");
		final String password = configurationService.getConfiguration().getString("sdh.preguntareto.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.preguntareto.urlhttp");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(requestObject);
		return restTemplate.postForObject(urlService, request, QuestionForRegistrationResponse.class);
	}


}
