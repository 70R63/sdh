/**
 *
 */
package de.hybris.sdh.core.customBreadcrumbs;


import de.hybris.platform.servicelayer.i18n.I18NService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.ui.context.Theme;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;


/**
 * BasicBreadcrumbBuilder implementation
 */
public class DefaultResourceBreadcrumbBuilder implements ResourceBreadcrumbBuilder
{

	private static final Logger LOG = Logger.getLogger(DefaultResourceBreadcrumbBuilder.class);

	private static final String LAST_LINK_CLASS = "active";

	private I18NService i18nService;

	private String parentBreadcrumbResourceKey;
	private String parentBreadcrumbLinkPath;

	protected I18NService getI18nService()
	{
		return i18nService;
	}

	@Required
	public void setI18nService(final I18NService i18nService)
	{
		this.i18nService = i18nService;
	}

	protected MessageSource getMessageSource()
	{
		final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null)
		{
			final HttpServletRequest request = requestAttributes.getRequest();
			final Theme theme = RequestContextUtils.getTheme(request);
			if (theme != null)
			{
				return theme.getMessageSource();
			}
		}

		return null;
	}

	protected String getParentBreadcrumbResourceKey()
	{
		return parentBreadcrumbResourceKey;
	}

	// Optional
	public void setParentBreadcrumbResourceKey(final String parentBreadcrumbResourceKey)
	{
		this.parentBreadcrumbResourceKey = parentBreadcrumbResourceKey;
	}

	protected String getParentBreadcrumbLinkPath()
	{
		return parentBreadcrumbLinkPath;
	}

	// Optional
	public void setParentBreadcrumbLinkPath(final String parentBreadcrumbLinkPath)
	{
		this.parentBreadcrumbLinkPath = parentBreadcrumbLinkPath;
	}

	@Override
	public List<Breadcrumb> getBreadcrumbs(final String resourceKey)
	{
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		final MessageSource messageSource = getMessageSource();


		if (getParentBreadcrumbResourceKey() != null && !getParentBreadcrumbResourceKey().isEmpty())
		{
			final String name = messageSource.getMessage(getParentBreadcrumbResourceKey(), null,
					getI18nService().getCurrentLocale());
			final String breadcrumbLinkPath = getParentBreadcrumbLinkPath();
			final String link = breadcrumbLinkPath != null && !breadcrumbLinkPath.isEmpty() ? breadcrumbLinkPath : "#";
			breadcrumbs.add(new Breadcrumb(link, name, null));
		}

		if (StringUtils.isNotBlank(resourceKey))
		{

			breadcrumbs = getCustomBreadcrmbs(resourceKey);
			final String name = messageSource.getMessage(resourceKey, null, getI18nService().getCurrentLocale());
			breadcrumbs.add(new Breadcrumb("#", name, null));
		}

		if (!breadcrumbs.isEmpty())
		{
			breadcrumbs.get(breadcrumbs.size() - 1).setLinkClass(LAST_LINK_CLASS);
		}

		return breadcrumbs;
	}

	/**
	 * @param resourceKey
	 * @return
	 */
	private List<Breadcrumb> getCustomBreadcrmbs(final String resourceKey)
	{

		class CustomBreadcrumb
		{
			private final String name;
			private final String link;

			public CustomBreadcrumb(final String name, final String link)
			{
				this.name = name;
				this.link = link;
			}

			String getName()
			{
				return this.name;
			}

			String getLink()
			{
				return this.link;
			}
		}

		final Map<String, TreeMap<Integer, CustomBreadcrumb>> treeMap = new HashMap<String, TreeMap<Integer, CustomBreadcrumb>>();
		TreeMap<Integer, CustomBreadcrumb> subTreeMap = new TreeMap<Integer, CustomBreadcrumb>();


		//*->INI TRAMITES-------------------------------------------------------------------------------
		if (resourceKey.equals("Crear Tramites"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Tramites", "/contibuyentes/tramites"));
			treeMap.put("Crear Tramites", subTreeMap);
		}

		if (resourceKey.equals("Seguimiento Trámites"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Tramites", "/contibuyentes/tramites"));
			treeMap.put("Seguimiento Trámites", subTreeMap);
		}
		//*->FIN TRAMITES-------------------------------------------------------------------------------




		//*->INI DELINEACION URBANA-------------------------------------------------------------------------------
		if (resourceKey.equals("Retencion Delineación Urbana"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("text.account.profile.delineacion", "/contribuyentes/delineacion-urbana"));
			treeMap.put("Retencion Delineación Urbana", subTreeMap);
		}

		if (resourceKey.equals("Declaración Delineación Urbana"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("text.account.profile.delineacion", "/contribuyentes/delineacion-urbana"));
			treeMap.put("Declaración Delineación Urbana", subTreeMap);
		}
		//*->FIN DELINEACION URBANA-------------------------------------------------------------------------------


		//*->INI ICA-------------------------------------------------------------------------------
		if (resourceKey.equals("Declaracion ICA"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("text.account.profile.ica", "/contribuyentes/ica"));
			treeMap.put("Declaracion ICA", subTreeMap);
		}
		//*->FIN ICA-------------------------------------------------------------------------------


		//*->INI PUBLICIDAD------------------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.declarapublicidad"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("breadcrumb.publicidad", "/contribuyentes/publicidadexterior"));
			treeMap.put("text.account.profile.declarapublicidad", subTreeMap);
		}
		//*->FIN PUBLICIDAD------------------------------------------------------------------------


		//*->INI GASOLINA--------------------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.gasolina.declaracion"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("text.account.profile.gasolina", "/contribuyentes/sobretasa-gasolina"));
			treeMap.put("text.account.profile.gasolina.declaracion", subTreeMap);
		}
		//*->FIN GASOLINA--------------------------------------------------------------------------




		final List<CustomBreadcrumb> breadcrumbsCustom = new ArrayList<>();
		final List<Breadcrumb> breadcrumbs = new ArrayList<>();
		final MessageSource messageSource = getMessageSource();

		try
		{
			subTreeMap = treeMap.get(resourceKey);
			final Iterator subIt = subTreeMap.keySet().iterator();

			while (subIt.hasNext())
			{
				final Integer subKey = (Integer) subIt.next();
				final CustomBreadcrumb customBreadcrumb = subTreeMap.get(subKey);
				final String link = customBreadcrumb.getLink();
				final String name = messageSource.getMessage(customBreadcrumb.getName(), null, getI18nService().getCurrentLocale());
				breadcrumbs.add(new Breadcrumb(link, name, null));
				System.out.println("Clave menor: " + subKey + " -> Name: " + customBreadcrumb.getName() + " -> Link: "
						+ customBreadcrumb.getLink());
			}
		}
		catch (final Exception e)
		{
			LOG.error("ERROR Breadcrumb Custom:  " + e.getMessage());
		}

		return breadcrumbs;
	}
}
