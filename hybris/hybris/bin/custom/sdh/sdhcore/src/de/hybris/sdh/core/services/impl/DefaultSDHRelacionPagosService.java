/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.RelacionPagosRequest;
import de.hybris.sdh.core.services.SDHRelacionPagosService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Praxis
 *
 */
public class DefaultSDHRelacionPagosService implements SDHRelacionPagosService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHConsultaFirmasService.class);

   @Resource(name = "configurationService")
   private ConfigurationService configurationService;

	@Override
	public String getRelacionPagos(final RelacionPagosRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.relacionPagos.url");
		final String user = configurationService.getConfiguration().getString("sdh.relacionPagos.user");
		final String password = configurationService.getConfiguration().getString("sdh.relacionPagos.password");

        if (StringUtils.isAnyBlank(urlString, user, password))
        {
            throw new RuntimeException("Error while validating certf nombr: Empty credentials");
		}

        try
        {
            final URL url = new URL(urlString);

            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            final String authString = user + ":" + password;
            final String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            LOG.info("connection to: " + conn.toString());

            final String requestJson = request.toString();
            LOG.info("request: " + requestJson);

            final OutputStream os = conn.getOutputStream();
            os.write(requestJson.getBytes());
            os.flush();
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
            {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            final BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            final StringBuilder builder = new StringBuilder();

            String inputLine;
            while ((inputLine = br.readLine()) != null)
            {
                builder.append(inputLine);
            }


            final String result = builder.toString();
            LOG.info("response: " + result);

            return result;

        }
        catch (final Exception e)
        {
            LOG.error("There was an error validating a contribuyente: " + e.getMessage());
        }
        return null;
	}



}
