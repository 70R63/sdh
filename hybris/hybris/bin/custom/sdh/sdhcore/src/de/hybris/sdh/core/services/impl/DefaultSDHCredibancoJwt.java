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

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author edson.roa
 *
 */
public class DefaultSDHCredibancoJwt implements SDHCredibancoJwt
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCredibancoJwt#inititalizeTransaction(de.hybris.sdh.core.credibanco.
	 * InititalizeTransactionRequest)
	 */
	private static final Logger LOG = Logger.getLogger(DefaultSDHCredibancoJwt.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	final String PRIVATE_KEY_FILE_RSA512 = configurationService.getConfiguration()
			.getString("credibanco.credential.privateKey.path"); //"src/resources/rsa-private.pem";

	final String PUBLIC_KEY_FILE_RSA512 = configurationService.getConfiguration()
			.getString("credibanco.credential.publicKey.path"); //"src/resources/rsa-public.pem";




	@Override
	public InititalizeTransactionResponse inititalizeTransaction(final InititalizeTransactionRequest request)
	{

		return null;
	}




	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHCredibancoJwt#getTransactionToken(de.hybris.sdh.core.credibanco.
	 * InititalizeTransactionRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getTransactionToken(final InititalizeTransactionRequest request, final String iss, final String iat, final String sub) throws IOException
	{
		final RSAPrivateKey privateKey = (RSAPrivateKey) JKSUtils.readPrivateKeyFromFile(PRIVATE_KEY_FILE_RSA512, "RSA");
		final RSAPublicKey publicKey = (RSAPublicKey) JKSUtils.readPublicKeyFromFile(PUBLIC_KEY_FILE_RSA512, "RSA");
		final String objectHashMd5 = JKSUtils.getObjectToHashMd5(request);

		LOG.info("-------------------------------------------");
		LOG.info(privateKey);
		LOG.info(publicKey);
		LOG.info(objectHashMd5);
		LOG.info(PRIVATE_KEY_FILE_RSA512);
		LOG.info(PUBLIC_KEY_FILE_RSA512);
		LOG.info("-------------------------------------------");

		return null;
	}





}
