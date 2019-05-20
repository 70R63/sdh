/**
 *
 */
package de.hybris.sdh.facades.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.LogReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaRequest;
import de.hybris.sdh.core.pojos.responses.CalculoReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.LogReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.ReteIcaResponse;
import de.hybris.sdh.core.services.SDHReteIcaService;
import de.hybris.sdh.facades.SDHReteIcaFacade;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author hybris
 *
 */
public class DefaultSDHReteIcaFacade implements SDHReteIcaFacade
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHReteIcaFacade.class);

	@Resource(name = "sdhReteIcaService")
	SDHReteIcaService sdhReteIcaService;

	@Resource(name = "sessionService")
	SessionService sessionService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Override
	public ReteIcaResponse reteICA(final ReteIcaRequest request)
	{

		final String response = sdhReteIcaService.reteICA(request);


		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final ReteIcaResponse reteIcaResponse = mapper.readValue(response, ReteIcaResponse.class);

			return reteIcaResponse;
		}
		catch (final IOException e)
		{
			LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHReteIcaFacade#calculo(de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest)
	 */
	@Override
	public CalculoReteIcaResponse calculo(final CalculoReteIcaRequest request)
	{
		final String response = sdhReteIcaService.calculo(request);


		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final CalculoReteIcaResponse reteIcaCalculoResponse = mapper.readValue(response, CalculoReteIcaResponse.class);

			return reteIcaCalculoResponse;
		}
		catch (final IOException e)
		{
			LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHReteIcaFacade#logReteICA(de.hybris.sdh.core.pojos.requests.LogReteIcaRequest)
	 */
	@Override
	public LogReteIcaResponse logReteICA(final LogReteIcaRequest request)
	{
		final String response = sdhReteIcaService.logReteICA(request);


		try
		{
			final ObjectMapper mapper = new ObjectMapper();
			mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			final LogReteIcaResponse logReteIcaResponse = mapper.readValue(response, LogReteIcaResponse.class);

			return logReteIcaResponse;
		}
		catch (final IOException e)
		{
			LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
		}

		return null;
	}

	@Override
	public Boolean sendFile(final MultipartFile multipartFile)
	{
		final String ftpServer = configurationService.getConfiguration().getString("sdh.reteica.ftp.server");
		final Integer ftpPort = configurationService.getConfiguration().getInteger("sdh.reteica.ftp.port", 21);
		final String ftpUsername = configurationService.getConfiguration().getString("sdh.reteica.ftp.username");
		final String ftpPassword = configurationService.getConfiguration().getString("sdh.reteica.ftp.password");
		final String ftpDir = configurationService.getConfiguration().getString("sdh.reteica.ftp.dir");

		final FTPClient client = new FTPClient();

		client.setBufferSize(1024000);
		try
		{
			client.connect(ftpServer, ftpPort);
			client.login(ftpUsername, ftpPassword);
		}
		catch (final IOException e1)
		{
			LOG.error("Error connecting to FTP Server");
			return false;
		}


		try
		{
			client.changeWorkingDirectory(ftpDir);
			client.storeFile(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
			client.logout();
		}
		catch (final Exception ex)
		{
			LOG.error("Error sending ReteICA file to FTP" + ex.getMessage());
			return false;
		}
		finally
		{
			try
			{
				client.disconnect();
			}
			catch (final IOException e)
			{
				LOG.error("Error disconecting FTP client after sending ReteICA file to FTP" + e.getMessage());
				return false;
			}
		}

		return true;
	}

}
