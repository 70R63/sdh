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


		//*->INI MI RIT---------------------------------------------------------------------------------
		if (resourceKey.equals("breadcrumb.miRIT"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("breadcrumb.miRIT", subTreeMap);
		}


		if (resourceKey.equals("breadcrumb.certificacion"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("breadcrumb.miRIT", "/contribuyentes/mirit"));
			treeMap.put("breadcrumb.certificacion", subTreeMap);
		}
		//*->FIN MI RIT---------------------------------------------------------------------------------



		//*->INI MI BUZON-------------------------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.buzon"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("text.account.profile.buzon", subTreeMap);
		}
		//*->FIN MI BUZON-------------------------------------------------------------------------------



		//*->INI TRAMITES-------------------------------------------------------------------------------
		if (resourceKey.equals("Tramites"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("Tramites", subTreeMap);
		}

		if (resourceKey.equals("Crear Tramites"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("Tramites", "/contibuyentes/tramites"));
			treeMap.put("Crear Tramites", subTreeMap);
		}

		if (resourceKey.equals("Seguimiento Trámites"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("Tramites", "/contibuyentes/tramites"));
			treeMap.put("Seguimiento Trámites", subTreeMap);
		}
		//*->FIN TRAMITES-------------------------------------------------------------------------------




		//*->INI DELINEACION URBANA-------------------------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.delineacion"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("text.account.profile.delineacion", subTreeMap);
		}


		if (resourceKey.equals("Retencion Delineación Urbana"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("text.account.profile.delineacion", "/contribuyentes/delineacion-urbana"));
			treeMap.put("Retencion Delineación Urbana", subTreeMap);
		}

		if (resourceKey.equals("Declaración Delineación Urbana"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("text.account.profile.delineacion", "/contribuyentes/delineacion-urbana"));
			treeMap.put("Declaración Delineación Urbana", subTreeMap);
		}
		//*->FIN DELINEACION URBANA-------------------------------------------------------------------------------


		//*->INI ICA-------------------------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.ica"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("text.account.profile.ica", subTreeMap);
		}


		if (resourceKey.equals("Declaracion ICA"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("text.account.profile.ica", "/contribuyentes/ica"));
			treeMap.put("Declaracion ICA", subTreeMap);
		}
		//*->FIN ICA-------------------------------------------------------------------------------


		//*->INI PUBLICIDAD------------------------------------------------------------------------
		if (resourceKey.equals("breadcrumb.publicidad"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("breadcrumb.publicidad", subTreeMap);
		}


		if (resourceKey.equals("text.account.profile.declarapublicidad"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("breadcrumb.publicidad", "/contribuyentes/publicidadexterior"));
			treeMap.put("text.account.profile.declarapublicidad", subTreeMap);
		}
		//*->FIN PUBLICIDAD------------------------------------------------------------------------


		//*->INI GASOLINA--------------------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.gasolina"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("text.account.profile.gasolina", subTreeMap);
		}


		if (resourceKey.equals("text.account.profile.gasolina.declaracion"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("text.account.profile.gasolina", "/contribuyentes/sobretasa-gasolina"));
			treeMap.put("text.account.profile.gasolina.declaracion", subTreeMap);
		}
		//*->FIN GASOLINA--------------------------------------------------------------------------


		//*->INI PRESENTAR DECLARACION-------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.presendecla"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("text.account.profile.presendecla", subTreeMap);
		}
		//*->FIN PRESENTAR DECLARACION-------------------------------------------------------------


		//*->INI PRESENTAR DECLARACION-------------------------------------------------------------
		if (resourceKey.equals("text.account.profile.declarafirm"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			treeMap.put("text.account.profile.declarafirm", subTreeMap);
		}
		//*->FIN PRESENTAR DECLARACION-------------------------------------------------------------


		//*->INI CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------
		if (resourceKey.equals("text.account.profile.certipagos"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.certipagos", subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------

		//*->INI CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------
		if (resourceKey.equals("text.account.profile.oblipendienetes"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.oblipendienetes", subTreeMap);
		}
		//*->FIN CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------


		//*->INI CONSULTAS RELACION PAGOS-------------------------------------------------
		if (resourceKey.equals("text.account.profile.relapagos"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.relapagos", subTreeMap);
		}
		//*->FIN CONSULTAS RELACION PAGOS-------------------------------------------------

		//*->INI CONSULTAS ESTADO CUENTA--------------------------------------------------
		if (resourceKey.equals("text.account.profile.estadocuenta"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.estadocuenta", subTreeMap);
		}
		//*->FIN CONSULTAS ESTADO CUENTA--------------------------------------------------


		//*->INI CONSULTAS CERTIFICACIONES DECLARACION------------------------------------
		if (resourceKey.equals("Certificaciones de Declaración"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Contribuyentes", "/contribuyentes"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("Certificaciones de Declaración", subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACIONES DECLARACION------------------------------------





		//*->INI AGENTES AUTRORIZADOS--------------------------------------------------------------
		if (resourceKey.equals("Agentes Autorizados"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			treeMap.put("Agentes Autorizados", subTreeMap);
		}
		//*->FIN AGENTES AUTRORIZADOS--------------------------------------------------------------


		//*->INI REPORTAR INFORMACION--------------------------------------------------------------
		if (resourceKey.equals("Reportar Información"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agentes Autorizados", "/autorizados"));
			treeMap.put("Reportar Información", subTreeMap);
		}
		//*->FIN REPORTAR INFORMACION--------------------------------------------------------------

		//*->INI REPORTAR INFORMACION--------------------------------------------------------------
		if (resourceKey.equals("Consultas"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agentes Autorizados", "/autorizados"));
			treeMap.put("Consultas", subTreeMap);
		}
		//*->FIN REPORTAR INFORMACION--------------------------------------------------------------

		//*->INI LISTA CONTRUBUYENTES--------------------------------------------------------------
		if (resourceKey.equals("Lista contribuyentes"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agentes Autorizados", "/autorizados"));
			treeMap.put("Lista contribuyentes", subTreeMap);
		}
		//*->FIN LISTA CONTRUBUYENTES--------------------------------------------------------------

		//*->INI TERCEROS AUTORIZADOS--------------------------------------------------------------
		if (resourceKey.equals("AgentesTerceros Autorizados"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			treeMap.put("AgentesTerceros Autorizados", subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS--------------------------------------------------------------

		//*->INI TERCEROS AUTORIZADOS SIM-----------------------------------------------------------
		if (resourceKey.equals("Terceros Autorizados SIM"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("AgentesTerceros Autorizados", "/terceros"));
			treeMap.put("Terceros Autorizados SIM", subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS SIM-----------------------------------------------------------


		//*->INI TERCEROS AUTORIZADOS NOTARIO-------------------------------------------------------
		if (resourceKey.equals("Terceros Autorizados Notario"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("AgentesTerceros Autorizados", "/terceros"));
			treeMap.put("Terceros Autorizados Notario", subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS NOTARIO-------------------------------------------------------

		//*->INI TERCEROS AUTORIZADOS REPORTAR INFORMACION------------------------------------------
		if (resourceKey.equals("Terceros Autorizados"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("AgentesTerceros Autorizados", "/terceros"));
			treeMap.put("Terceros Autorizados", subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS REPORTAR INFORMACION------------------------------------------

		//*->INI AGENTES REGISTRO RETENCIONES-------------------------------------------------------
		if (resourceKey.equals("Registro de Retenciones"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			treeMap.put("Registro de Retenciones", subTreeMap);
		}
		//*->FIN AGENTES REGISTRO RETENCIONES-------------------------------------------------------










		//*->INI CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------
		if (resourceKey.equals("text.account.profile.arCertipagos"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.arCertipagos", subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------

		//*->INI CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------
		if (resourceKey.equals("text.account.profile.arOblipendienetes"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.arOblipendienetes", subTreeMap);
		}
		//*->FIN CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------


		//*->INI CONSULTAS RELACION PAGOS-------------------------------------------------
		if (resourceKey.equals("text.account.profile.arRelapagos"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.arRelapagos", subTreeMap);
		}
		//*->FIN CONSULTAS RELACION PAGOS-------------------------------------------------

		//*->INI CONSULTAS ESTADO CUENTA--------------------------------------------------
		if (resourceKey.equals("text.account.profile.arEstadocuenta"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("text.account.profile.arEstadocuenta", subTreeMap);
		}
		//*->FIN CONSULTAS ESTADO CUENTA--------------------------------------------------


		//*->INI CONSULTAS CERTIFICACIONES DECLARACION------------------------------------
		if (resourceKey.equals("Certificaciones de Declaración"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			subTreeMap.put(3, new CustomBreadcrumb("Consultas", "#"));
			treeMap.put("Certificaciones de Declaración", subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACIONES DECLARACION------------------------------------

















		//*->INI AGENTES ESTADO DE CARGAS-----------------------------------------------------------
		if (resourceKey.equals("Estado de Cargas"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			subTreeMap.put(3, new CustomBreadcrumb("Registro de Retenciones", "/retenedores/registroretenciones"));
			treeMap.put("Estado de Cargas", subTreeMap);
		}
		//*->FIN AGENTES ESTADO DE CARGAS-----------------------------------------------------------

		//*->INI AGENTES DECLARACION POR FIRMAR-----------------------------------------------------
		if (resourceKey.equals("Declaraciones por Firmar"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Agente Retenedor", "/retenedores"));
			treeMap.put("Declaraciones por Firmar", subTreeMap);
		}
		//*->FIN AGENTES DECLARACION POR FIRMAR-----------------------------------------------------

		//*->INI REPORTANTE DECLARACION POR FIRMAR-----------------------------------------------------
		if (resourceKey.equals("breadcrumb.reportante"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			treeMap.put("breadcrumb.reportante", subTreeMap);
		}
		//*->FIN AGENTES DECLARACION POR FIRMAR-----------------------------------------------------

		//*->INI REPORTANTE CARGA DOCUMENTOS-----------------------------------------------------
		if (resourceKey.equals("breadcrumb.reportante.carga"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Reportante", "/reportantes"));
			treeMap.put("breadcrumb.reportante.carga", subTreeMap);
		}
		//*->FIN REPORTANTE CARGA DOCUMENTOS-----------------------------------------------------


		//*->INI REPORTANTE HISTORICO-----------------------------------------------------
		if (resourceKey.equals("breadcrumb.reportante.historico"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Reportante", "/reportantes"));
			treeMap.put("breadcrumb.reportante.historico", subTreeMap);
		}
		//*->FIN REPORTANTE HISTORICO-----------------------------------------------------


		//*->INI REPORTANTE SANCIONES-----------------------------------------------------
		if (resourceKey.equals("breadcrumb.reportante.sanciones"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb("Roles", "/"));
			subTreeMap.put(2, new CustomBreadcrumb("Reportante", "/reportantes"));
			treeMap.put("breadcrumb.reportante.sanciones", subTreeMap);
		}
		//*->FIN REPORTANTE SANCIONES-----------------------------------------------------




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
