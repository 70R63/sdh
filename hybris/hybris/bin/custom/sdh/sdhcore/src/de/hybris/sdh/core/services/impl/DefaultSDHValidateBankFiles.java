/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.TypFileBancoRequest;
import de.hybris.sdh.core.pojos.responses.TypFileBancoListResponse;
import de.hybris.sdh.core.services.SDHValidateBankFiles;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


/**
 * @author edson.roa
 *
 */
public class DefaultSDHValidateBankFiles implements SDHValidateBankFiles
{
	private static final Logger LOG = Logger.getLogger(DefaultSDHValidateBankFiles.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHValidateBankFiles#getTypeFileBank(java.lang.String)
	 */
	@Override
	public TypFileBancoListResponse getTypeFileBank(final String codbk)
	{
		final TypFileBancoRequest typFileBancoRequest = new TypFileBancoRequest();
		final RestTemplate restTemplate = new RestTemplate();
		final String usuario = configurationService.getConfiguration().getString("sdh.reteica.bankFileValidation.getTypeFile.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteica.bankFileValidation.getTypeFile.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.reteica.bankFileValidation.getTypeFile.url");

		typFileBancoRequest.setCODBK(codbk);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final HttpEntity<TypFileBancoRequest> request = new HttpEntity<>(typFileBancoRequest);
		return restTemplate.postForObject(urlService, request, TypFileBancoListResponse.class);

	}

}
