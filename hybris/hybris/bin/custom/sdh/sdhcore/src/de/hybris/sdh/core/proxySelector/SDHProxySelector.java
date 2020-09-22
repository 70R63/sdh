/**
 *
 */
package de.hybris.sdh.core.proxySelector;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Praxis
 *
 */
public class SDHProxySelector extends ProxySelector
{
	ProxySelector defsel = null;



	class InnerProxy
	{
		Proxy proxy;
		SocketAddress addr;

		InnerProxy(final InetSocketAddress a)
		{
			addr = a;
			proxy = new Proxy(Proxy.Type.HTTP, a);
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

	public SDHProxySelector(final ProxySelector def)
	{

		super();

		defsel = def;

		try
		{
			InnerProxy i = new InnerProxy(new InetSocketAddress(InetAddress.getByName("186.31.132.21"), 3128));
			proxies.put(i.address(), i);
			i = new InnerProxy(new InetSocketAddress(InetAddress.getByName("147.204.152.42"), 3128));
			proxies.put(i.address(), i);
		}
		catch (final Exception ex)
		{
			System.err.println(ex);
		}
	}



	@Override
	public java.util.List<Proxy> select(final URI uri)
	{

		if (uri == null)
		{
			throw new IllegalArgumentException("URI can't be null.");
		}

		final String protocol = uri.getScheme();
		if ("http".equalsIgnoreCase(protocol) || "https".equalsIgnoreCase(protocol))
		{
			final ArrayList<Proxy> l = new ArrayList<Proxy>();
			final SocketAddress sa;
			for (final InnerProxy p : proxies.values())
			{
				l.add(p.toProxy());
				System.out.println(p.address());

			}
			return l;
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
