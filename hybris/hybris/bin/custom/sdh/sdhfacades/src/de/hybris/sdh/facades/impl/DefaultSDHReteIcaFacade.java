/**
 *
 */
package de.hybris.sdh.facades.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.LogReteIcaRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaAvisoArchivoRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaFileStatusInTRMRequest;
import de.hybris.sdh.core.pojos.requests.ReteIcaRequest;
import de.hybris.sdh.core.pojos.responses.ArchivosTRM;
import de.hybris.sdh.core.pojos.responses.CalculoReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.LogReteIcaResponse;
import de.hybris.sdh.core.pojos.responses.ReteIcaResponse;
import de.hybris.sdh.core.services.SDHReteIcaService;
import de.hybris.sdh.facades.SDHReteIcaFacade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
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
		ReteIcaResponse reteIcaResponse = new ReteIcaResponse();

		final String response = sdhReteIcaService.reteICA(request);

		if (StringUtils.isNotBlank(response))
		{
			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				reteIcaResponse = mapper.readValue(response, ReteIcaResponse.class);

				return reteIcaResponse;
			}
			catch (final IOException e)
			{
				LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
			}
		}
		return reteIcaResponse;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.facades.SDHReteIcaFacade#calculo(de.hybris.sdh.core.pojos.requests.CalculoReteIcaRequest)
	 */
	@Override
	public CalculoReteIcaResponse calculo(final CalculoReteIcaRequest request)
	{

		CalculoReteIcaResponse reteIcaCalculoResponse = new CalculoReteIcaResponse();

		final String response = sdhReteIcaService.calculo(request);

		if (StringUtils.isNoneBlank(response))
		{
			try
			{
				final ObjectMapper mapper = new ObjectMapper();
				mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				reteIcaCalculoResponse = mapper.readValue(response, CalculoReteIcaResponse.class);

				return reteIcaCalculoResponse;
			}
			catch (final IOException e)
			{
				LOG.error("Error trying to parse JSON :" + response + " to String. Ex.Message" + e.getMessage());
			}
		}

		return reteIcaCalculoResponse;
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
			final Boolean fileSent = client.storeFile(multipartFile.getOriginalFilename(), multipartFile.getInputStream());

			if (!Boolean.TRUE.equals(fileSent))
			{
				LOG.error("Error sending ReteICA file to FTP");
				return false;
			}

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

	@Override
	public Boolean writeFile(final MultipartFile multipartFile,final String numBP,final String numObjeto)
	{
		final String directory = configurationService.getConfiguration().getString("sdh.reteica.nfs.directory");

		final File file = new File(directory + multipartFile.getOriginalFilename());
		try
		{
			multipartFile.transferTo(file);

			final ReteIcaAvisoArchivoRequest request = new ReteIcaAvisoArchivoRequest();
			request.setNumBP(numBP);
			request.setNumObjeto(numObjeto);

			final String fileName = multipartFile.getOriginalFilename();

			final List<String> archivos = new ArrayList<String>();
			archivos.add(fileName.substring(0, fileName.length() - 4));
			request.setArchivos(archivos);

			final Boolean aviso = sdhReteIcaService.avisoArchivo(request );

			if (!Boolean.TRUE.equals(aviso))
			{
				LOG.error("not able to notice TRM about new file");
				if (file != null && file.exists())
				{
					file.delete();
				}
				return false;
			}
		}
		catch (IllegalStateException | IOException e)
		{
			LOG.error("Error sending file to NFS");
			return false;
		}

		return true;
	}

	@Override
	public ReteIcaResponse reteICAMock(final ReteIcaRequest request)
	{
		final ReteIcaResponse response = new ReteIcaResponse();

		final List<ArchivosTRM> archivosTRM = new ArrayList<ArchivosTRM>();

		final ArchivosTRM archivo1 = new ArchivosTRM();

		archivo1.setEstado("proceso");
		archivo1.setFechaCarga("20/05/2019");
		archivo1.setNomArchivo("0420180100800897987.csv");
		archivo1.setNumForm("01324657498");
		archivo1.setPerRepor("Valor 1");

		archivosTRM.add(archivo1);

		final ArchivosTRM archivo2 = new ArchivosTRM();

		archivo2.setEstado("Aceptado");
		archivo2.setFechaCarga("20/05/2018");
		archivo2.setNomArchivo("Archivo de Prueba 2.csv");
		archivo2.setNumForm("qweuyqwe");
		archivo2.setPerRepor("Valor 2");

		archivosTRM.add(archivo2);

		response.setArchivosTRM(archivosTRM);

		return response;
	}

	@Override
	public String getFileStatusInTRM(final ReteIcaFileStatusInTRMRequest request)
	{

		final ReteIcaRequest reteICARequest = new ReteIcaRequest();


		reteICARequest.setAnoGravable(request.getAnoGravable());
		reteICARequest.setNumBP(request.getNumBP());
		reteICARequest.setNumObjeto(request.getNumObjeto());
		reteICARequest.setPeriodo(request.getPeriodo());

		final ReteIcaResponse response = this.reteICA(reteICARequest);

		if (response == null || response.getArchivosTRM() == null || response.getArchivosTRM().isEmpty())
		{
			return "00";
		}

		String filenameRequest = request.getFileName();
		int fileNameLength = request.getFileName().length();
		filenameRequest = filenameRequest.substring(0, fileNameLength - 6);

		String filenameResponse;

		for (final ArchivosTRM eachArchivo : response.getArchivosTRM())
		{

			fileNameLength = eachArchivo.getNomArchivo().length();
			filenameResponse = eachArchivo.getNomArchivo().substring(0, fileNameLength - 2);
			if (filenameResponse.equals(filenameRequest))
			{
				if ("X".equalsIgnoreCase(eachArchivo.getBandera()))
				{
					return eachArchivo.getEstado();
				}
			}
		}

		return "00";
	}



}
