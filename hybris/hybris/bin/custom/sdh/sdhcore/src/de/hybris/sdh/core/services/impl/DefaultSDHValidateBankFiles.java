/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.form.SelectAtomValue;
import de.hybris.sdh.core.pojos.responses.TypFileBancoListResponse;
import de.hybris.sdh.core.pojos.responses.TypFileBancoResponse;
import de.hybris.sdh.core.services.SDHValidateBankFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


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
	public List<SelectAtomValue> getTypeFileBank(final String codbk)
	{

		List<SelectAtomValue> returnData = new ArrayList<>();
		SelectAtomValue atomData = null;
		final RestTemplate restTemplate = new RestTemplate();
		final TypFileBancoListResponse typFileBancoListResponse = new TypFileBancoListResponse();
		final List<TypFileBancoResponse> arrayTipos = new ArrayList<>();
		TypFileBancoResponse typFileBancoResponse;
		final String usuario = configurationService.getConfiguration().getString("sdh.reteica.bankFileValidation.getTypeFile.user");
		final String password = configurationService.getConfiguration().getString("sdh.reteica.bankFileValidation.getTypeFile.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.reteica.bankFileValidation.getTypeFile.url");

		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		final Map map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		headers.setAll(map);

		final Map req_payload = new HashMap();
		req_payload.put("CODBK", codbk);

		final HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));
		final ResponseEntity<?> response = restTemplate.postForEntity(urlService, request, String.class);

		final ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		try
		{
			root = mapper.readTree(response.getBody().toString());
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		final JsonNode tipos = Objects.isNull(root) ? null : root.path("tipos");
		for (final JsonNode objNode : tipos)
		{
			atomData = new SelectAtomValue(
					objNode.path("FTYPE").isInt() ? String.valueOf(objNode.path("FTYPE").intValue())  : objNode.path("FTYPE").textValue(),
					objNode.path("FNAME").textValue()
			);
            LOG.info(atomData);
			returnData.add(atomData);
		}

		return returnData;

	}

}
