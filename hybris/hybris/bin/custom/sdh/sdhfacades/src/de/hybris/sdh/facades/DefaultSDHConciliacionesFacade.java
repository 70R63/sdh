/**
 *
 */
package de.hybris.sdh.facades;

import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import net.sf.sevenzipjbinding.ExtractOperationResult;
import net.sf.sevenzipjbinding.ISequentialOutStream;
import net.sf.sevenzipjbinding.ISevenZipInArchive;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.SevenZipException;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;
import sun.security.provider.certpath.OCSP.RevocationStatus;
import sun.security.provider.certpath.OCSP.RevocationStatus.CertStatus;


/**
 * @author hybris
 *
 */
public class DefaultSDHConciliacionesFacade implements SDHConciliacionesFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultSDHConciliacionesFacade.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Override
	public void processConciliacionesFile(final MultipartFile multipartFile)
	{
		final long startTime = System.nanoTime();

		final String ftpServer = configurationService.getConfiguration().getString("sdh.conciliaciones.ftp.server");
		final Integer ftpPort = configurationService.getConfiguration().getInteger("sdh.conciliaciones.ftp.port", 21);
		final String ftpUsername = configurationService.getConfiguration().getString("sdh.conciliaciones.ftp.username");
		final String ftpPassword = configurationService.getConfiguration().getString("sdh.conciliaciones.ftp.password");

		final FTPClient client = new FTPClient();
		client.setBufferSize(9843540);


		try
		{
			client.connect(ftpServer);
			//client.connect(ftpServer, ftpPort);
			//client.login(ftpUsername, ftpPassword);
		}
		catch (final IOException e1)
		{
			LOG.error("Error connecting to FTP Server");
			return;
		}

		ISevenZipInArchive inArchive = null;
		ISimpleInArchive simpleInArchive = null;
		RandomAccessFile randomAccessFile = null;
		File zip = null;
		try
		{
			zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
			final FileOutputStream o = new FileOutputStream(zip);
			IOUtils.copy(multipartFile.getInputStream(), o);
			o.close();

			randomAccessFile = new RandomAccessFile(zip.getAbsolutePath(), "r");

			inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));

			simpleInArchive = inArchive.getSimpleInterface();

			LOG.info("   Hash   |    Size    | Filename");
			LOG.info("----------+------------+---------");

			for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems())
			{

				final int[] hash = new int[] { 0 };
				if (!item.isFolder() && item.getPath().contains(".txt"))
				{

					ExtractOperationResult result;

					final long[] sizeArray = new long[1];
					final File tempFile = new File(item.getPath());

					final OutputStream outputStream = client.storeFileStream(tempFile.getName());

					result = item.extractSlow(new ISequentialOutStream()
					{

						public int write(final byte[] data) throws SevenZipException
						{

							try
							{
								outputStream.write(data);
							}
							catch (final Exception e)
							{
								LOG.error("Error writing file: " + e.getMessage() + " on FTP Server");
							}

							hash[0] ^= Arrays.hashCode(data); // Consume data
							sizeArray[0] += data.length;
							return data.length; // Return amount of consumed data
						}


					});

					if (outputStream != null)
					{
						outputStream.close();
					}

					if (result == ExtractOperationResult.OK)
					{
						LOG.info(String.format("%9X | %10s | %s", //
								hash[0], sizeArray[0], item.getPath()));
					}
					else
					{
						LOG.error("Error extracting item: " + result);
					}
				}
			}
		}
		catch (final SevenZipException e)
		{
			LOG.error("Error extracting item: " + e.getMessage());
		}
		catch (final Exception e)
		{
			LOG.error("Error occurs: " + e);
		}
		finally
		{
			if (inArchive != null)
			{
				try
				{
					inArchive.close();
				}
				catch (final SevenZipException e)
				{
					LOG.error("Error closing archive: " + e);
				}
			}
			if (randomAccessFile != null)
			{
				try
				{
					randomAccessFile.close();
				}
				catch (final IOException e)
				{
					LOG.error("Error closing file: " + e);
				}
			}
			if (zip != null)
			{
				zip.delete();
			}

		}

		final long estimatedTime = System.nanoTime() - startTime;

		LOG.info("All process took: " + (estimatedTime / 1000) + "ms");

	}




	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.facades.SDHConciliacionesFacade#checkCertificates(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public CertStatus checkCertificates(final MultipartFile multipartFile)
	{
		return RevocationStatus.CertStatus.GOOD;
	}




	/* (non-Javadoc)
	 * @see de.hybris.sdh.facades.SDHConciliacionesFacade#validade7ZipCertificates(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public void validade7ZipCertificates(final MultipartFile multipartFile)
	{
		final long startTime = System.nanoTime();
		ISevenZipInArchive inArchive = null;
		ISimpleInArchive simpleInArchive = null;
		RandomAccessFile randomAccessFile = null;
		File zip = null;

		LOG.info("  Validating 7Zip Certificate ");
		LOG.info("----------+------------+---------");


		try
		{
			zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
			final FileOutputStream o = new FileOutputStream(zip);
			IOUtils.copy(multipartFile.getInputStream(), o);
			o.close();

			randomAccessFile = new RandomAccessFile(zip.getAbsolutePath(), "r");
			inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));
			simpleInArchive = inArchive.getSimpleInterface();


			for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems())
			{
				final int[] hash = new int[] { 0 };
				LOG.info(item.getPath());
				if (!item.isFolder() && item.getPath().contains(".cer"))
				{

				}
			}
		}
		catch (final SevenZipException e)
		{
			LOG.error("Error extracting item: " + e.getMessage());
		}
		catch (final Exception e)
		{
			LOG.error("Error occurs: " + e);
		}
		finally
		{
			if (inArchive != null)
			{
				try
				{
					inArchive.close();
				}
				catch (final SevenZipException e)
				{
					LOG.error("Error closing archive: " + e);
				}
			}
			if (randomAccessFile != null)
			{
				try
				{
					randomAccessFile.close();
				}
				catch (final IOException e)
				{
					LOG.error("Error closing file: " + e);
				}
			}
			if (zip != null)
			{
				zip.delete();
			}

		}

		final long estimatedTime = System.nanoTime() - startTime;

		LOG.info("All process took: " + (estimatedTime / 1000) + "ms");
		// XXX Auto-generated method stub

	}

}
