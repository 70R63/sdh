package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.EnviaFirmasRequest;
import de.hybris.sdh.core.services.SDHEnviaFirmasService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultSDHEnviaFirmasService implements SDHEnviaFirmasService {

    private static final Logger LOG = Logger.getLogger(DefaultSDHEnviaFirmasService.class);

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Override
    public String enviaFirmas(EnviaFirmasRequest request) {

        final String urlString = configurationService.getConfiguration().getString("sdh.enviaFirmas.url");
        final String user = configurationService.getConfiguration().getString("sdh.enviaFirmas.user");
        final String password = configurationService.getConfiguration().getString("sdh.enviaFirmas.password");

        if (StringUtils.isAnyBlank(urlString, user, password))
        {
            throw new RuntimeException("Error while sending firmas: Empty credentials");
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
            LOG.error("There was an error sending firmas: " + e.getMessage());
        }
        return null;
    }
}
