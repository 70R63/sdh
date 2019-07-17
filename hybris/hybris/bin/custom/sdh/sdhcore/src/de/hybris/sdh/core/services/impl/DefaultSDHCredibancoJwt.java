/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.credibanco.InititalizeTransactionRequest;
import de.hybris.sdh.core.credibanco.InititalizeTransactionResponse;
import de.hybris.sdh.core.credibanco.JKSUtils;
import de.hybris.sdh.core.services.SDHCredibancoJwt;

import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;


/**
 * @author edson.roa
 *
 */
public class DefaultSDHCredibancoJwt implements SDHCredibancoJwt
{
	private static final Logger LOG = Logger.getLogger(DefaultSDHCredibancoJwt.class);


	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCredibancoJwt#getTransactionToken(de.hybris.sdh.core.credibanco.
	 * InititalizeTransactionRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getTransactionToken(final InititalizeTransactionRequest request, final String iss, final Date iat,
			final String sub)
	{
		final String PRIVATE_KEY_FILE_RSA512 = configurationService.getConfiguration().getString("credibanco.credential.privateKey.path");
		final String PUBLIC_KEY_FILE_RSA512 = configurationService.getConfiguration().getString("credibanco.credential.publicKey.path");
		final String hashMd5 = JKSUtils.getObjectToHashMd5(request);
		final JWTCreator.Builder builder = com.auth0.jwt.JWT.create();
		RSAPrivateKey privateKey = null;
		RSAPublicKey publicKey = null;


		builder.withJWTId(hashMd5).withIssuer(iss).withIssuedAt(iat).withSubject(sub);

		try
		{
			privateKey = (RSAPrivateKey) JKSUtils.readPrivateKeyFromFile(PRIVATE_KEY_FILE_RSA512, "RSA");
			publicKey = (RSAPublicKey) JKSUtils.readPublicKeyFromFile(PUBLIC_KEY_FILE_RSA512, "RSA");
		}
		catch (final IOException e)
		{
			LOG.error(e.toString());
		}

		LOG.info("HashMd5 [" + hashMd5 + "]");
		LOG.info("PrivateKey [" + privateKey + "]");
		LOG.info("PublicKey [" + publicKey + "]");
		LOG.info("RequestObject [" + request + "]");
		LOG.info("RequestObjectJson [" + JKSUtils.objectToJson(request) + "]");

		return builder.sign(Algorithm.RSA512(publicKey, privateKey));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCredibancoJwt#inititalizeTransaction(de.hybris.sdh.core.credibanco.
	 * InititalizeTransactionRequest)
	 */
	@Override
	public InititalizeTransactionResponse inititalizeTransaction(final InititalizeTransactionRequest request)
	{
		final String token = this.getTransactionToken(request, "SDH", new Date(), "initializeTransaction");
		final String URL = configurationService.getConfiguration().getString("credibanco.credential.webService.url");
		final HttpHeaders headers = new HttpHeaders();
		final RestTemplate restTemplate = new RestTemplate();
		HttpEntity<InititalizeTransactionRequest> rqt;

		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		rqt = new HttpEntity<InititalizeTransactionRequest>(request, headers);

		LOG.info("Token [" + token + "]");
		LOG.info("URL [" + URL + "]");


		return restTemplate.postForObject(URL, rqt, InititalizeTransactionResponse.class);
	}

}
