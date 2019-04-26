/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.services.SDHFTPService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;


/**
 * @author hybris
 *
 */
public class DefaultSDHFTPService implements SDHFTPService
{
	private static final Logger LOG = Logger.getLogger(DefaultSDHFTPService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Override
	public void sendFileToServer(final File file)
	{
		final String ftpServer = configurationService.getConfiguration().getString("sdh.conciliaciones.ftp.server");
		final Integer ftpPort = configurationService.getConfiguration().getInteger("sdh.conciliaciones.ftp.port", 21);
		final String ftpUsername = configurationService.getConfiguration().getString("sdh.conciliaciones.ftp.username");
		final String ftpPassword = configurationService.getConfiguration().getString("sdh.conciliaciones.ftp.password");

		final FTPClient client = new FTPClient();
		FileInputStream fis = null;
		OutputStream outputStream = null;

		try
		{
			client.setBufferSize(Integer.MAX_VALUE);
			client.connect(ftpServer, ftpPort);
			client.login(ftpUsername, ftpPassword);
			fis = new FileInputStream(file);

			outputStream = client.storeFileStream(file.getName());

			final byte[] bytesIn = new byte[4096];
			int read = 0;

			while ((read = fis.read(bytesIn)) != -1)
			{
				outputStream.write(bytesIn, 0, read);
			}

			client.logout();
		}
		catch (final IOException e)
		{
			LOG.error("there was an error processing file" + e.getMessage());
		}
		finally
		{
			try
			{
				if (fis != null)
				{
					fis.close();
				}
				client.disconnect();

				if (file != null)
				{
					file.delete();
				}

				if (outputStream != null)
				{
					outputStream.close();
				}
			}
			catch (final IOException e)
			{
				LOG.error("there was an error processing file");
			}
		}

	}


}
