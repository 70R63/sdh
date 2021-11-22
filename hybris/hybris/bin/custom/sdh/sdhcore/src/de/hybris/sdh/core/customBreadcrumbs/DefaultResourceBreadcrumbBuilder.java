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
	private static final String ROLE = "Roles";
	private static final String CONTRIBUYENTE = "Contribuyentes";
	private static final String CONTRIBUYENTE_PATH = "/contribuyentes";
	private static final String DECLARACION_TEXT = "text.account.profile.declaraciones";
	private static final String TRAMITES = "Tramites";
	private static final String TRAMITE_PATH = "/contibuyentes/tramites";
	private static final String DELINEACION_URBANA = "/contribuyentes/delineacion-urbana";
	private static final String PROFILE_DELINEACION = "text.account.profile.delineacion";
	private static final String PROFILE_ICA = "text.account.profile.ica";
	private static final String BREADCRUMB_PUBLICIDAD = "breadcrumb.publicidad";
	private static final String PROFILE_GASOLINA = "text.account.profile.gasolina";
	private static final String PROFILE_GASOLINE_DECLARACION = "text.account.profile.gasolina.declaracion";
	private static final String BREADCRUMB_REPORTANTE_SANCIONES = "breadcrumb.reportante.sanciones";
	private static final String CREAR_TRAMITE = "Crear Tramites";
	private static final String SEGUIMIENTO_TRAMITE = "Seguimiento Trámites";
	private static final String RETENCION_DELINEACION_URBANA ="Retencion Delineación Urbana";
	private static final String BREADCRUMB_MIRIT = "breadcrumb.miRIT";
	private static final String BREADCRUMB_CERTIFICACION = "breadcrumb.certificacion";
	private static final String DECLARACION_DELINEACION_URBANA = "Declaración Delineación Urbana";
	private static final String DECLARACION_ICA = "Declaracion ICA";
	private static final String PROFILE_DECLARACION_PUBLICIDAD = "text.account.profile.declarapublicidad";
	private static final String PROFILE_BUZON = "text.account.profile.buzon";
	private static final String PROFILE_VEHICULO = "text.account.profile.vehiculos";
	private static final String PROFILE_VEHICULO_DECLARACION = "text.account.profile.vehiculos.declaracion";
	private static final String PREDIAL = "Predial";
	private static final String TEXT_DECLARACION_PREDIAL = "text.declaracion.predial";
	private static final String PROFILE_DESCARGAFAC = "text.account.profile.descargaFac";
	private static final String PROFILE_REEXPEDICION_FAC = "text.account.profile.reexpedicionFac";
	private static final String PROFILE_PRESENDECLA = "text.account.profile.presendecla";
	private static final String PROFILE_DECLARAFIRM = "text.account.profile.declarafirm";
	private static final String PROFILE_CERTIPAGOS = "text.account.profile.certipagos";
	private static final String PROFILE_OBLIPENDIENETES = "text.account.profile.oblipendienetes";
	private static final String PROFILE_RELAPAGOS = "text.account.profile.relapagos";
	private static final String PROFILE_EDOCUENTA = "text.account.profile.estadocuenta";
	private static final String TEXT_CERTIFICACIONES_DE_PAGOS =  "Certificaciones de Declaración";
	private static final String PROFILE_CERTIDECLARA = "text.account.profile.certiDeclara";
	private static final String AGENTE_AUTORIZADOS = "Agentes Autorizados";
	private static final String CONSULTAS = "Consultas";
	private static final String REPORTAR_INFORMACION = "Reportar Información";
	private static final String LISTA_CONTRIBUYENTE = "Lista contribuyentes";
	private static final String AGENTES_TERCEROS_AUTORIZADOS = "AgentesTerceros Autorizados";
	private static final String TERCEROS_AUTORIZADOS_SIM = "Terceros Autorizados SIM";
	private static final String TERCEROS_AUTORIZADOS_NOTARIOS = "Terceros Autorizados Notario";
	private static final String TERCEROS_AUTORIZADOS = "Terceros Autorizados";
	private static final String TERFCEROS_PATH = "/terceros";
	private static final String REGISTRO_DE_RETENCIONES = "Registro de Retenciones";
	private static final String AGENTE_RETENEDOR_TEXT = "Agente Retenedor";
	private static final String AUTORIZADOS_PATH = "/autorizados";
	private static final String RETENEDOR_LINK = "/retenedores";
	private static final String REPORTANTE = "Reportante";
	private static final String REPORTANTE_PATH = "/reportantes";
	private static final String REPORTANTE_HISTORICO = "breadcrumb.reportante.historico";
	private static final String CERTIFICACION_REPO = "breadcrumb.certificacionREPO";
	private static final String MI_RIT_REPO = "breadcrumb.miRITREPO";
	private static final String REPORTANTE_CARGA = "breadcrumb.reportante.carga";
	private static final String PROFILE_REPO = "TEXT_ACCOUNT_PROFILE_REPO";
	private static final String BREADCRUMB_REPORTANTE = "breadcrumb.reportante";
	private static final String DECLARACION_POR_FIRMA = "Declaraciones por Firmar";
	private static final String BREADCRUMB_RETENEDOR_CARGA = "breadcrumb.retenedor.carga";
	private static final String PROFILE_DECLARACIONES2 = "text.account.profile.declaraciones2";
	private static final String PROFILE_AR_ESTADOCUENTA = "text.account.profile.arEstadocuenta";
	private static final String PROFILE_ARRELAPAGOS = "text.account.profile.arRelapagos";
	private static final String PROFILE_AROBLIPENDIENTES = "text.account.profile.arOblipendienetes";
	private static final String PROFILE_AR_CERTIPAGOS = "text.account.profile.arCertipagos";
	private static final String PROFILE_OBLIGARETE = "text.account.profile.obligaRETE";
	private static final String PROFILE_EDOCTARETE = "text.account.profile.edoctaRETE";
	private static final String PROFILE_BUZONRETE = "text.account.profile.buzonRETE";
	private static final String BREADCRUMB_CERTIFICACIONRETE = "breadcrumb.certificacionRETE";
	private static final String MI_RIT = "Mi RIT";
	private static final String CRUMBS_LINK = "#";
	private static final String ROOT = "/";
	private static final String PROFILE_CONCE = "/concesionarios";
	private static final String BREADCRUMB_CONCESIONARIO = "breadcrumb.concesionarios";

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
			final String link = breadcrumbLinkPath != null && !breadcrumbLinkPath.isEmpty() ? breadcrumbLinkPath : CRUMBS_LINK;
			breadcrumbs.add(new Breadcrumb(link, name, null));
		}

		if (StringUtils.isNotBlank(resourceKey))
		{

			breadcrumbs = getCustomBreadcrmbs(resourceKey);
			final String name = messageSource.getMessage(resourceKey, null, getI18nService().getCurrentLocale());
			breadcrumbs.add(new Breadcrumb(CRUMBS_LINK, name, null));
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
		if (resourceKey.equals(BREADCRUMB_MIRIT))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(BREADCRUMB_MIRIT, subTreeMap);
		}


		if (resourceKey.equals(BREADCRUMB_CERTIFICACION))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(BREADCRUMB_MIRIT, "/contribuyentes/mirit"));
			treeMap.put(BREADCRUMB_CERTIFICACION, subTreeMap);
		}
		//*->FIN MI RIT---------------------------------------------------------------------------------



		//*->INI MI BUZON-------------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_BUZON))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_BUZON, subTreeMap);
		}
		//*->FIN MI BUZON-------------------------------------------------------------------------------



		//*->INI TRAMITES-------------------------------------------------------------------------------
		if (resourceKey.equals(TRAMITES))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(TRAMITES, subTreeMap);
		}

		if (resourceKey.equals(CREAR_TRAMITE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(TRAMITES, TRAMITE_PATH));
			treeMap.put(CREAR_TRAMITE, subTreeMap);
		}

		if (resourceKey.equals(SEGUIMIENTO_TRAMITE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(TRAMITES, TRAMITE_PATH));
			treeMap.put(SEGUIMIENTO_TRAMITE, subTreeMap);
		}
		//*->FIN TRAMITES-------------------------------------------------------------------------------




		//*->INI DELINEACION URBANA-------------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_DELINEACION))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_DELINEACION, subTreeMap);
		}


		if (resourceKey.equals(RETENCION_DELINEACION_URBANA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(PROFILE_DELINEACION, DELINEACION_URBANA));
			treeMap.put(RETENCION_DELINEACION_URBANA, subTreeMap);
		}

		if (resourceKey.equals(DECLARACION_DELINEACION_URBANA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(PROFILE_DELINEACION, DELINEACION_URBANA));
			treeMap.put(DECLARACION_DELINEACION_URBANA, subTreeMap);
		}
		//*->FIN DELINEACION URBANA-------------------------------------------------------------------------------


		//*->INI ICA-------------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_ICA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_ICA, subTreeMap);
		}


		if (resourceKey.equals(DECLARACION_ICA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(PROFILE_ICA, "/contribuyentes/ica"));
			treeMap.put(DECLARACION_ICA, subTreeMap);
		}
		//*->FIN ICA-------------------------------------------------------------------------------


		//*->INI PUBLICIDAD------------------------------------------------------------------------
		if (resourceKey.equals(BREADCRUMB_PUBLICIDAD))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(BREADCRUMB_PUBLICIDAD, subTreeMap);
		}


		if (resourceKey.equals(PROFILE_DECLARACION_PUBLICIDAD))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(BREADCRUMB_PUBLICIDAD, "/contribuyentes/publicidadexterior"));
			treeMap.put(PROFILE_DECLARACION_PUBLICIDAD, subTreeMap);
		}
		//*->FIN PUBLICIDAD------------------------------------------------------------------------


		//*->INI GASOLINA--------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_GASOLINA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_GASOLINA, subTreeMap);
		}


		if (resourceKey.equals(PROFILE_GASOLINE_DECLARACION))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(PROFILE_GASOLINA, "/contribuyentes/sobretasa-gasolina"));
			treeMap.put(PROFILE_GASOLINE_DECLARACION, subTreeMap);
		}
		//*->FIN GASOLINA--------------------------------------------------------------------------

		//*->INI vehiculos--------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_VEHICULO))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_VEHICULO, subTreeMap);
		}


		if (resourceKey.equals(PROFILE_VEHICULO_DECLARACION))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3,
					new CustomBreadcrumb(PROFILE_VEHICULO, "/contribuyentes/sobrevehiculosautomotores/detalle"));
			treeMap.put(PROFILE_VEHICULO_DECLARACION, subTreeMap);
		}
		//*->FIN vehiculos--------------------------------------------------------------------------

		//*->INI Predial--------------------------------------------------------------------------
		if (resourceKey.equals(PREDIAL))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PREDIAL, subTreeMap);
		}


		if (resourceKey.equals(TEXT_DECLARACION_PREDIAL))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(PREDIAL, "/contribuyentes/predialunificado_inicio"));
			treeMap.put(TEXT_DECLARACION_PREDIAL, subTreeMap);
		}
		//*->FIN Predial--------------------------------------------------------------------------


		//*->INI Descarga Factura--------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_DESCARGAFAC))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_DESCARGAFAC, subTreeMap);
		}
		//*->FIN Descarga Factura--------------------------------------------------------------------------

		//*->INI Reexpedición Factura--------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_REEXPEDICION_FAC))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_REEXPEDICION_FAC, subTreeMap);
		}
		//*->FIN Reexpedición Factura--------------------------------------------------------------------------


		//*->INI PRESENTAR DECLARACION-------------------------------------------------------------
		if (resourceKey.equals(PROFILE_PRESENDECLA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_PRESENDECLA, subTreeMap);
		}
		//*->FIN PRESENTAR DECLARACION-------------------------------------------------------------


		//*->INI PRESENTAR DECLARACION-------------------------------------------------------------
		if (resourceKey.equals(PROFILE_DECLARAFIRM))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(PROFILE_DECLARAFIRM, subTreeMap);
		}
		//*->FIN PRESENTAR DECLARACION-------------------------------------------------------------


		//*->INI CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------
		if (resourceKey.equals(PROFILE_CERTIPAGOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_CERTIPAGOS, subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------

		//*->INI CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------
		if (resourceKey.equals(PROFILE_OBLIPENDIENETES))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_OBLIPENDIENETES, subTreeMap);
		}
		//*->FIN CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------


		//*->INI CONSULTAS RELACION PAGOS-------------------------------------------------
		if (resourceKey.equals(PROFILE_RELAPAGOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_RELAPAGOS, subTreeMap);
		}
		//*->FIN CONSULTAS RELACION PAGOS-------------------------------------------------

		//*->INI CONSULTAS ESTADO CUENTA--------------------------------------------------
		if (resourceKey.equals(PROFILE_EDOCUENTA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_EDOCUENTA, subTreeMap);
		}
		//*->FIN CONSULTAS ESTADO CUENTA--------------------------------------------------


		//*->INI CONSULTAS CERTIFICACIONES DECLARACION------------------------------------
		if (resourceKey.equals(TEXT_CERTIFICACIONES_DE_PAGOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(TEXT_CERTIFICACIONES_DE_PAGOS, subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACIONES DECLARACION------------------------------------

		//*->INI CONSULTAS CERTIFICACIONES DECLARACION------------------------------------
		if (resourceKey.equals(PROFILE_CERTIDECLARA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_CERTIDECLARA, subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACIONES DECLARACION------------------------------------

		//*->INI CONSULTAS CERTIFICACIONES DECLARACIONDECLARACIONES------------------------------------
		if (resourceKey.equals(DECLARACION_TEXT))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(DECLARACION_TEXT, subTreeMap);
		}
		//*->FIN CONSULTAS DECLARACIONES------------------------------------

		//*->INI CONTRIBUYENTES RETEICA------------------------------------
		if (resourceKey.equals("text.account.profile.registroretenciones"))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(CONTRIBUYENTE, CONTRIBUYENTE_PATH));
			treeMap.put(DECLARACION_TEXT, subTreeMap);
		}
		//*->FIN CONTRIBUYENTES RETEICA-----------------------------------




		//*->INI AGENTES AUTRORIZADOS--------------------------------------------------------------
		if (resourceKey.equals(AGENTE_AUTORIZADOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			treeMap.put(AGENTE_AUTORIZADOS, subTreeMap);
		}
		//*->FIN AGENTES AUTRORIZADOS--------------------------------------------------------------


		//*->INI REPORTAR INFORMACION--------------------------------------------------------------
		if (resourceKey.equals(REPORTAR_INFORMACION))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_AUTORIZADOS, AUTORIZADOS_PATH));
			treeMap.put(REPORTAR_INFORMACION, subTreeMap);
		}
		//*->FIN REPORTAR INFORMACION--------------------------------------------------------------

		//*->INI REPORTAR INFORMACION--------------------------------------------------------------
		if (resourceKey.equals(CONSULTAS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTAR_INFORMACION, AUTORIZADOS_PATH));
			treeMap.put(CONSULTAS, subTreeMap);
		}
		//*->FIN REPORTAR INFORMACION--------------------------------------------------------------

		//*->INI LISTA CONTRUBUYENTES--------------------------------------------------------------
		if (resourceKey.equals(LISTA_CONTRIBUYENTE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTAR_INFORMACION, AUTORIZADOS_PATH));
			treeMap.put(LISTA_CONTRIBUYENTE, subTreeMap);
		}
		//*->FIN LISTA CONTRUBUYENTES--------------------------------------------------------------

		//*->INI TERCEROS AUTORIZADOS--------------------------------------------------------------
		if (resourceKey.equals(AGENTES_TERCEROS_AUTORIZADOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			treeMap.put(AGENTES_TERCEROS_AUTORIZADOS, subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS--------------------------------------------------------------

		//*->INI TERCEROS AUTORIZADOS SIM-----------------------------------------------------------
		if (resourceKey.equals(TERCEROS_AUTORIZADOS_SIM))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTES_TERCEROS_AUTORIZADOS, TERFCEROS_PATH));
			treeMap.put(TERCEROS_AUTORIZADOS_SIM, subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS SIM-----------------------------------------------------------


		//*->INI TERCEROS AUTORIZADOS NOTARIO-------------------------------------------------------
		if (resourceKey.equals(TERCEROS_AUTORIZADOS_NOTARIOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTES_TERCEROS_AUTORIZADOS, TERFCEROS_PATH));
			treeMap.put(TERCEROS_AUTORIZADOS_NOTARIOS, subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS NOTARIO-------------------------------------------------------

		//*->INI TERCEROS AUTORIZADOS REPORTAR INFORMACION------------------------------------------
		if (resourceKey.equals(TERCEROS_AUTORIZADOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTES_TERCEROS_AUTORIZADOS, TERFCEROS_PATH));
			treeMap.put(TERCEROS_AUTORIZADOS, subTreeMap);
		}
		//*->FIN TERCEROS AUTORIZADOS REPORTAR INFORMACION------------------------------------------

		//*->INI AGENTES REGISTRO RETENCIONES-------------------------------------------------------
		if (resourceKey.equals(REGISTRO_DE_RETENCIONES))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			treeMap.put(REGISTRO_DE_RETENCIONES, subTreeMap);
		}
		//*->FIN AGENTES REGISTRO RETENCIONES-------------------------------------------------------

		if (resourceKey.equals(MI_RIT))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			treeMap.put(MI_RIT, subTreeMap);
		}

		if (resourceKey.equals(BREADCRUMB_CERTIFICACIONRETE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(MI_RIT, "/agenteRetenedor/mirit"));
			treeMap.put(BREADCRUMB_CERTIFICACIONRETE, subTreeMap);
		}

		//*->INI MI BUZON-------------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_BUZONRETE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			treeMap.put(PROFILE_BUZONRETE, subTreeMap);
		}
		//*->FIN MI BUZON-------------------------------------------------------------------------------


		//*->INI estado de cuenta-------------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_EDOCTARETE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			treeMap.put(PROFILE_EDOCTARETE, subTreeMap);
		}
		//*->FIN estado de cuenta-------------------------------------------------------------------------------

		//*->INI obligaciones-------------------------------------------------------------------------------
		if (resourceKey.equals(PROFILE_OBLIGARETE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			treeMap.put(PROFILE_OBLIGARETE, subTreeMap);
		}
		//*->FIN obligaciones-------------------------------------------------------------------------------





		//*->INI CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------
		if (resourceKey.equals(PROFILE_AR_CERTIPAGOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_AR_CERTIPAGOS, subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACION PAGOS-----------------------------------------------------

		//*->INI CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------
		if (resourceKey.equals(PROFILE_AROBLIPENDIENTES))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_AROBLIPENDIENTES, subTreeMap);
		}
		//*->FIN CONSULTAS OBLIGACIONES PENDIENTES-------------------------------------------------


		//*->INI CONSULTAS RELACION PAGOS-------------------------------------------------
		if (resourceKey.equals(PROFILE_ARRELAPAGOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_ARRELAPAGOS, subTreeMap);
		}
		//*->FIN CONSULTAS RELACION PAGOS-------------------------------------------------

		//*->INI CONSULTAS ESTADO CUENTA--------------------------------------------------
		if (resourceKey.equals(PROFILE_AR_ESTADOCUENTA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_AR_ESTADOCUENTA, subTreeMap);
		}
		//*->FIN CONSULTAS ESTADO CUENTA--------------------------------------------------


		//*->INI CONSULTAS CERTIFICACIONES DECLARACION------------------------------------
		if (resourceKey.equals(TEXT_CERTIFICACIONES_DE_PAGOS))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(TEXT_CERTIFICACIONES_DE_PAGOS, subTreeMap);
		}
		//*->FIN CONSULTAS CERTIFICACIONES DECLARACION------------------------------------

		//*->INI CONSULTAS DECLARACIONES------------------------------------
		if (resourceKey.equals(PROFILE_DECLARACIONES2))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(CONSULTAS, CRUMBS_LINK));
			treeMap.put(PROFILE_DECLARACIONES2, subTreeMap);
		}
		//*->FIN CONSULTAS DECLARACIONES------------------------------------


















		//*->INI AGENTES ESTADO DE CARGAS-----------------------------------------------------------
		if (resourceKey.equals(BREADCRUMB_RETENEDOR_CARGA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			subTreeMap.put(3, new CustomBreadcrumb(REGISTRO_DE_RETENCIONES, "/retenedores/cargadocumentos"));
			treeMap.put(BREADCRUMB_RETENEDOR_CARGA, subTreeMap);
		}
		//*->FIN AGENTES ESTADO DE CARGAS-----------------------------------------------------------

		//*->INI AGENTES DECLARACION POR FIRMAR-----------------------------------------------------
		if (resourceKey.equals(DECLARACION_POR_FIRMA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(AGENTE_RETENEDOR_TEXT, RETENEDOR_LINK));
			treeMap.put(DECLARACION_POR_FIRMA, subTreeMap);
		}
		//*->FIN AGENTES DECLARACION POR FIRMAR-----------------------------------------------------

		//*->INI REPORTANTE DECLARACION POR FIRMAR-----------------------------------------------------
		if (resourceKey.equals(BREADCRUMB_REPORTANTE))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			treeMap.put(BREADCRUMB_REPORTANTE, subTreeMap);
		}
		//*->FIN AGENTES DECLARACION POR FIRMAR-----------------------------------------------------



		//*->INI REPORTANTE CARGA DOCUMENTOS-----------------------------------------------------
		if (resourceKey.equals(PROFILE_REPO))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTANTE, REPORTANTE_PATH));
			treeMap.put(PROFILE_REPO, subTreeMap);
		}
		//*->FIN REPORTANTE CARGA DOCUMENTOS-----------------------------------------------------

		if (resourceKey.equals(REPORTANTE_CARGA))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTANTE, REPORTANTE_PATH));
			treeMap.put(REPORTANTE_CARGA, subTreeMap);
		}
		//*->MIRIT REPORTANTE CARGA DOCUMENTOS
		if (resourceKey.equals(MI_RIT_REPO))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTANTE, REPORTANTE_PATH));
			treeMap.put(MI_RIT_REPO, subTreeMap);
		}

		if (resourceKey.equals(CERTIFICACION_REPO))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTANTE, REPORTANTE_PATH));
			treeMap.put(CERTIFICACION_REPO, subTreeMap);
		}
		//*->FIN REPORTANTE CARGA DOCUMENTOS-----------------------------------------------------



		//*->INI REPORTANTE HISTORICO-----------------------------------------------------
		if (resourceKey.equals(REPORTANTE_HISTORICO))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTANTE, REPORTANTE_PATH));
			treeMap.put(REPORTANTE_HISTORICO, subTreeMap);
		}
		//*->FIN REPORTANTE HISTORICO-----------------------------------------------------


		//*->INI REPORTANTE SANCIONES-----------------------------------------------------
		if (resourceKey.equals(BREADCRUMB_REPORTANTE_SANCIONES))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(REPORTANTE, REPORTANTE_PATH));
			treeMap.put(BREADCRUMB_REPORTANTE_SANCIONES, subTreeMap);
		}
		//*->FIN REPORTANTE SANCIONES-----------------------------------------------------


		//*->INI REPORTANTE CONCESIONARIOS-----------------------------------------------------
		if (resourceKey.equals(BREADCRUMB_CONCESIONARIO))
		{
			subTreeMap.clear();
			subTreeMap.put(1, new CustomBreadcrumb(ROLE, ROOT));
			subTreeMap.put(2, new CustomBreadcrumb(PROFILE_CONCE, PROFILE_CONCE));
			treeMap.put(BREADCRUMB_REPORTANTE_SANCIONES, subTreeMap);
		}
		//*->FIN REPORTANTE CONCESIONARIOS-----------------------------------------------------



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
