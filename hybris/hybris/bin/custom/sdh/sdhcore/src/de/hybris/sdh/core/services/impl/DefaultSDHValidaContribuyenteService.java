/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.ConsultarBPRequest;
import de.hybris.sdh.core.pojos.requests.RadicaDelinRequest;
import de.hybris.sdh.core.pojos.requests.SdhValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbanaWithRadicados;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.RadicaDelinResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


/**
 * @author hybris
 *
 */
public class DefaultSDHValidaContribuyenteService implements SDHValidaContribuyenteService
{

	private static final Logger LOG = Logger.getLogger(DefaultSDHValidaContribuyenteService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "userService")
	UserService userService;

	@Resource(name = "sdhCustomerAccountService")
	SDHCustomerAccountService sdhCustomerAccountService;

	/* (non-Javadoc)
	 * @see de.hybris.sdh.core.services.SDHValidaContribuyente#validaContribuyente(de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest)
	 */
	@Override
	public String validaContribuyente(final ValidaContribuyenteRequest request)
	{
		final String urlString = configurationService.getConfiguration().getString("sdh.validacontribuyente.url");
		final String user = configurationService.getConfiguration().getString("sdh.validacontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.validacontribuyente.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error while validating contribuyente: Empty credentials");
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

	@Override
	public SDHValidaMailRolResponse validaContribuyente(final SdhValidaContribuyenteRequest request) throws Exception{
		final String usuario = configurationService.getConfiguration().getString("sdh.validacontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.validacontribuyente.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.validacontribuyente.url");

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));

		final HttpEntity<SdhValidaContribuyenteRequest> requestData = new HttpEntity<>(request);
		return restTemplate.postForObject(urlService, requestData, SDHValidaMailRolResponse.class);
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHValidaContribuyenteService#validaContibuyente(de.hybris.sdh.core.pojos.requests.
	 * ConsultaContribuyenteBPRequest)
	 */
	@Override
	public SDHValidaMailRolResponse validaContribuyente(final String stringBp)
	{
		final String usuario = configurationService.getConfiguration().getString("sdh.validacontribuyente.user");
		final String password = configurationService.getConfiguration().getString("sdh.validacontribuyente.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.validacontribuyente.url");

		final ConsultaContribuyenteBPRequest bp = new ConsultaContribuyenteBPRequest();
		bp.setNumBP(stringBp);

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));

		final HttpEntity<ConsultaContribuyenteBPRequest> request = new HttpEntity<>(bp);
		return restTemplate.postForObject(urlService, request, SDHValidaMailRolResponse.class);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHValidaContribuyenteService#getpublicidadExtListByBpAndYear(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<ImpuestoPublicidadExterior> getpublicidadExtListByBpAndYear(final String stringBp, final String stringYear)
	{
		//final SDHValidaMailRolResponse contribuyente = this.validaContribuyente(stringBp);

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SDHValidaMailRolResponse contribuyente = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "07");

		final List<ImpuestoPublicidadExterior> returnList = new ArrayList<>();
		if (Objects.nonNull(contribuyente))
		{
			for (final ImpuestoPublicidadExterior pExterior : contribuyente.getPublicidadExt())
			{
				if (Objects.nonNull(pExterior.getAnoGravable()))
				{
					if (pExterior.getAnoGravable().equals(stringYear))
					{
						returnList.add(pExterior);
					}
				}
			}
		}
		// XXX Auto-generated method stub
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHValidaContribuyenteService#getDelineacionListByBpAndYear(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<ImpuestoDelineacionUrbana> getDelineacionListByBpAndYear(final String stringBp, final String stringYear)
	{
		final SDHValidaMailRolResponse contribuyente = this.validaContribuyente(stringBp);
		final List<ImpuestoDelineacionUrbana> returnList = new ArrayList<>();

		System.out.println("----------- getDelineacionListByBpAndYear -----------");
		System.out.println(contribuyente);

		if (Objects.nonNull(contribuyente))
		{
			for (final ImpuestoDelineacionUrbana delineacion : contribuyente.getDelineacion())
			{
				System.out.println("delineacion [" + delineacion + "]");
				if (Objects.nonNull(delineacion.getFechaExp()))
				{
					final String anio = delineacion.getFechaExp().split("/")[2];
					System.out.println("getDelineacionListByBpAndYear ----- > " + anio);
					if (Objects.nonNull(anio))
					{
						if (anio.equals(stringYear))
						{
							returnList.add(delineacion);
						}
					}
				}

			}
		}
		return returnList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHValidaContribuyenteService#getRadicadosDelineacion(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public RadicaDelinResponse getRadicadosDelineacion(final String numBp, final String cdu)
	{
		RadicaDelinResponse response = null;

		final String usuario = configurationService.getConfiguration().getString("sdh.radicaDelin.user");
		final String password = configurationService.getConfiguration().getString("sdh.radicaDelin.password");
		final String urlService = configurationService.getConfiguration().getString("sdh.radicaDelin.url");

		final RadicaDelinRequest bp = new RadicaDelinRequest();
		bp.setNumBP(numBp);
		bp.setCdu(cdu);

		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(usuario, password));

		final HttpEntity<RadicaDelinRequest> request = new HttpEntity<>(bp);
		try
		{
			response = restTemplate.postForObject(urlService, request, RadicaDelinResponse.class);
		}
		catch (final Exception e)
		{
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.services.SDHValidaContribuyenteService#getDelineacionListByBpAndYearWithRadicados(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public List<ImpuestoDelineacionUrbanaWithRadicados> getDelineacionListByBpAndYearWithRadicados(final String stringBp,
			final String stringYear)
	{
		//final SDHValidaMailRolResponse contribuyente = this.validaContribuyente(stringBp);

		final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
		final SDHValidaMailRolResponse contribuyente = sdhCustomerAccountService.getBPAndTaxDataFromCustomer(customerModel, "06");

		final List<ImpuestoDelineacionUrbanaWithRadicados> returnList = new ArrayList<>();

		if (Objects.nonNull(contribuyente) && contribuyente.getDelineacion() != null)
		{
			ImpuestoDelineacionUrbanaWithRadicados deli;
			for (final ImpuestoDelineacionUrbana delineacion : contribuyente.getDelineacion())
			{

				if (Objects.nonNull(delineacion.getFechaExp()) && !delineacion.getFechaExp().equals(""))
				{
					final String anio = delineacion.getFechaExp().split("/")[2];
					System.out.println("getDelineacionListByBpAndYear ----- > " + anio);
					if (Objects.nonNull(anio) && (anio.matches("[0-9]+") && anio.length() == 4))
					{
						if (delineacion.getCdu() != null) //anio.equals(stringYear))
						{
							final int anioCdu = Integer.parseInt(delineacion.getCdu().substring(3, 5));
							final int anioEjec = Integer.parseInt(stringYear.substring(2, 4));

							if (anioCdu <= anioEjec)
							{
								final RadicaDelinResponse radicaDelinResponse = this.getRadicadosDelineacion(stringBp,
										delineacion.getCdu());
								if (radicaDelinResponse != null)
								{

									deli = new ImpuestoDelineacionUrbanaWithRadicados();

									deli.setNumObjeto(delineacion.getNumObjeto());
									deli.setCdu(delineacion.getCdu());
									deli.setLicenConst(delineacion.getLicenConst());
									deli.setFechaExp(delineacion.getFechaExp());
									deli.setFechaReval(delineacion.getFechaReval());
									deli.setFechFinObra(delineacion.getFechFinObra());
									deli.setFechaEjecutoria(delineacion.getFechaEjecutoria());
									deli.setRadicados(radicaDelinResponse.getRadicados());

									returnList.add(deli);
								}
							}
						}
					}
				}

			}
		}
		return returnList;
	}

	@Override
	public String consultarBP(final ConsultarBPRequest request)
	{

		final String urlString = configurationService.getConfiguration().getString("sdh.consultarBP.url");
		final String user = configurationService.getConfiguration().getString("sdh.consultarBP.user");
		final String password = configurationService.getConfiguration().getString("sdh.consultarBP.password");

		if (StringUtils.isAnyBlank(urlString, user, password))
		{
			throw new RuntimeException("Error consultar BP: Empty credentials");
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
			LOG.error("There was an error in consultar BP: " + e.getMessage());
		}
		return null;
	}



}
