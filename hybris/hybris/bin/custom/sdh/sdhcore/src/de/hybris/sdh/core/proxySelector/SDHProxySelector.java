/**
 *
 */
package de.hybris.sdh.core.proxySelector;


import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author Praxis
 *
 */
public class SDHProxySelector extends ProxySelector
{

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	ProxySelector defsel = null;
	private static final Logger LOG = Logger.getLogger(SDHProxySelector.class);

	String config;
	String httpProxyHostACH;
	String httpProxyPortACH;
	String httpProxyHostInternet;
	String httpProxyPortInternet;
	String proxyType;



	class InnerProxy
	{
		Proxy proxy;
		SocketAddress addr;

		InnerProxy(final InetSocketAddress a)
		{
			addr = a;


			if (proxyType.equals("SOCKS"))
			{
				proxy = new Proxy(Proxy.Type.SOCKS, a);
				LOG.info("Tipo Proxy: " + Proxy.Type.SOCKS);
				LOG.info("Address: " + a.toString());
			}

			if (proxyType.equals("HTTP"))
			{
				proxy = new Proxy(Proxy.Type.HTTP, a);
				LOG.info("Tipo Proxy: " + Proxy.Type.HTTP);
				LOG.info("Address: " + a.toString());
			}

		}

		SocketAddress address()
		{
			return addr;
		}

		Proxy toProxy()
		{
			return proxy;
		}

	}

	HashMap<SocketAddress, InnerProxy> proxies = new HashMap<SocketAddress, InnerProxy>();
	HashMap<SocketAddress, InnerProxy> proxiACH = new HashMap<SocketAddress, InnerProxy>();
	HashMap<SocketAddress, InnerProxy> proxiInternet = new HashMap<SocketAddress, InnerProxy>();

	public SDHProxySelector(final ProxySelector def, final String pconfig, final String phttpProxyHostACH,
			final String phttpProxyPortACH, final String phttpProxyHostInternet, final String phttpProxyPortInternet,
			final String pproxyType)
	{

		super();

		config = pconfig;
		httpProxyHostACH = phttpProxyHostACH;
		httpProxyPortACH = phttpProxyPortACH;
		httpProxyHostInternet = phttpProxyHostInternet;
		httpProxyPortInternet = phttpProxyPortInternet;
		proxyType = pproxyType;

		defsel = def;



		LOG.info("---------------INI Carga de lista de proxys:------------------------");

		if (config.equals("1"))
		{

			try
			{
				final InnerProxy i = new InnerProxy(
						new InetSocketAddress(InetAddress.getByName(httpProxyHostACH), new Integer(httpProxyPortACH).intValue()));
				proxiACH.put(i.address(), i);
			}
			catch (final Exception ex)
			{
				System.err.println(ex);
			}

		}

		if (config.equals("2"))
		{

			try
			{
				final InnerProxy i = new InnerProxy(new InetSocketAddress(InetAddress.getByName(httpProxyHostInternet),
						new Integer(httpProxyPortInternet).intValue()));
				proxiInternet.put(i.address(), i);
			}
			catch (final Exception ex)
			{
				LOG.info(ex);
			}
		}


		if (config.equals("3"))
		{

			try
			{
				final InnerProxy i = new InnerProxy(
						new InetSocketAddress(InetAddress.getByName(httpProxyHostACH), new Integer(httpProxyPortACH).intValue()));
				proxiACH.put(i.address(), i);
			}
			catch (final Exception ex)
			{
				LOG.info(ex);
			}

			try
			{
				final InnerProxy i = new InnerProxy(new InetSocketAddress(InetAddress.getByName(httpProxyHostInternet),
						new Integer(httpProxyPortInternet).intValue()));
				proxiInternet.put(i.address(), i);
			}
			catch (final Exception ex)
			{
				LOG.info(ex);
			}


			/*
			 * try { final String httpProxyHostACH =
			 * configurationService.getConfiguration().getString("sdh.pse.http.proxyHostACH"); final String
			 * httpProxyPortACH = configurationService.getConfiguration().getString("sdh.pse.http.proxyPortACH");
			 * InnerProxy i = new InnerProxy( new InetSocketAddress(InetAddress.getByName(httpProxyHostACH), new
			 * Integer(httpProxyPortACH).intValue())); proxies.put(i.address(), i);
			 *
			 * final String httpProxyHostInternet = configurationService.getConfiguration()
			 * .getString("sdh.pse.http.proxyHostInternet"); final String httpProxyPortInternet =
			 * configurationService.getConfiguration() .getString("sdh.pse.http.proxyPortInternet"); i = new InnerProxy(new
			 * InetSocketAddress(InetAddress.getByName(httpProxyHostInternet), new
			 * Integer(httpProxyPortInternet).intValue())); proxies.put(i.address(), i); } catch (final Exception ex) {
			 * System.err.println(ex); }
			 */
		}

		LOG.info("---------------FIN Carga de lista de proxys:------------------------");
	}



	@Override
	public java.util.List<Proxy> select(final URI uri)
	{

		if (uri == null)
		{
			throw new IllegalArgumentException("URI can't be null.");
		}





		if (config.equals("1"))
		{

			LOG.info("---------------INI Configuracion 1:------------------------");
			final String host = uri.getHost();
			if ("200.1.124.65".equalsIgnoreCase(host))
			{
				final ArrayList<Proxy> l = new ArrayList<Proxy>();
				final SocketAddress sa;
				for (final InnerProxy p : proxiACH.values())
				{
					l.add(p.toProxy());
					LOG.info(p.address());
				}
				return l;
			}
			LOG.info("---------------FIN Configuracion 1:------------------------");

		}




		if (config.equals("2"))
		{

			LOG.info("---------------INI Configuracion 2:------------------------");
			final String protocol = uri.getScheme();
			if ("http".equalsIgnoreCase(protocol) || "https".equalsIgnoreCase(protocol))
			{
				final ArrayList<Proxy> l = new ArrayList<Proxy>();
				final SocketAddress sa;
				for (final InnerProxy p : proxiInternet.values())
				{
					l.add(p.toProxy());
					LOG.info(p.address());

				}
				return l;
			}
			LOG.info("---------------FIN Configuracion 2:------------------------");

		}




		if (config.equals("3"))
		{


			final String host = uri.getHost();
			if ("200.1.124.65".equalsIgnoreCase(host))
			{
				LOG.info("---------------INI Configuracion 3:------------------------");
				final ArrayList<Proxy> l = new ArrayList<Proxy>();
				final SocketAddress sa;
				for (final InnerProxy p : proxiACH.values())
				{
					l.add(p.toProxy());
					LOG.info(p.address());

				}
				LOG.info("---------------FIN Configuracion 3:------------------------");
				return l;
			}


			final String protocol = uri.getScheme();
			if ("http".equalsIgnoreCase(protocol) || "https".equalsIgnoreCase(protocol))
			{
				LOG.info("---------------INI Configuracion 3:------------------------");
				final ArrayList<Proxy> l = new ArrayList<Proxy>();
				final SocketAddress sa;
				for (final InnerProxy p : proxiInternet.values())
				{
					l.add(p.toProxy());
					LOG.info(p.address());

				}
				LOG.info("---------------FIN Configuracion 3:------------------------");
				return l;
			}


		}



		if (config.equals("4"))
		{

			LOG.info("---------------INI Configuracion 4:------------------------");


			LOG.info("Authority = " +  uri.getAuthority ());
			LOG.info("Fragment = " + uri.getFragment ());
			LOG.info("Host = " + uri.getHost ());
			LOG.info("Path = " + uri.getPath ());
			LOG.info("Port = " + uri.getPort ());
			LOG.info("Query = " + uri.getQuery ());
			LOG.info("Scheme = " + uri.getScheme ());

			final String host = uri.getHost();
			if ("200.1.124.65".equalsIgnoreCase(host))
			{


				final ArrayList<Proxy> proxies = new ArrayList<>();

				if (proxyType.equals("SOCKS"))
				{
					proxies.add(new Proxy(Proxy.Type.SOCKS,
							new InetSocketAddress(httpProxyHostACH, new Integer(httpProxyPortACH).intValue())));

					LOG.info("Proxy Type: SOCKS");
					LOG.info("httpProxyHostACH: " + httpProxyHostACH);
					LOG.info("httpProxyPortACH: " + httpProxyPortACH);

				}
				else if (proxyType.equals("HTTP"))
				{
					proxies.add(new Proxy(Proxy.Type.HTTP,
							new InetSocketAddress(httpProxyHostACH, new Integer(httpProxyPortACH).intValue())));

					LOG.info("Proxy Type: HTTP");
					LOG.info("httpProxyHostACH: " + httpProxyHostACH);
					LOG.info("httpProxyPortACH: " + httpProxyPortACH);
				}

				LOG.info("we enter to proxy server 186");

				return proxies;
			}

			LOG.info("---------------FIN Configuracion 4:------------------------");
		}



		/*
		 * Not HTTP or HTTPS (could be SOCKS or FTP) defer to the default selector.
		 */
		if (defsel != null)
		{
			return defsel.select(uri);
		}
		else
		{
			final ArrayList<Proxy> l = new ArrayList<Proxy>();
				l.add(Proxy.NO_PROXY);
				return l;
			}
		}



	@Override
	public void connectFailed(final URI arg0, final SocketAddress arg1, final IOException arg2)
	{
		// XXX Auto-generated method stub

	}


}
