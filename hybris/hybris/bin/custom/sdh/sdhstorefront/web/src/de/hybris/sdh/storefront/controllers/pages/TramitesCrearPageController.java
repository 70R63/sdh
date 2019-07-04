/**
*
*/
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.pojos.requests.TramitesSeleccionInfo;
import de.hybris.sdh.core.services.SDHCertificaRITService;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.ItemSelectOption;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Maria Luisa
 *
 */
@Controller
//@RequestMapping("")
public class TramitesCrearPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(MiRitCertificacionPageController.class);

	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_PROFILE = "Crear Tramites";

	// CMS Pages
	private static final String TRAMITES_CREAR_CMS_PAGE = "tramitesCrearPage";

	private static final String REDIRECT_TO_TRAMITES_CREAR_PAGE = REDIRECT_PREFIX + "/contibuyentes/tramites/crear";

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "sdhCertificaRITService")
	SDHCertificaRITService sdhCertificaRITService;

	@Resource(name = "sdhConsultaContribuyenteBPService")
	SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	@RequestMapping(value = "/contibuyentes/tramites/crear", method = RequestMethod.GET)
	@RequireHardLogIn
	public String tramitescreaar(final Model model) throws CMSItemNotFoundException
	{
		System.out.println("---------------- Hola entro al GET TRAMITES crear --------------------------");



		storeCmsPageInModel(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));

		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_PROFILE));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

		return getViewForPage(model);
	}

	@RequestMapping(value = "/contibuyentes/tramites/crear", method = RequestMethod.POST)
	@RequireHardLogIn
	public String tramitescrearpost(final BindingResult bindingResult, final Model model,
			final RedirectAttributes redirectAttributes) throws CMSItemNotFoundException
	{
		System.out.println("------------------Entro al POST de TRAMITES CREAR------------------------");

		return REDIRECT_TO_TRAMITES_CREAR_PAGE;
	}

	@RequestMapping(value = "/contribuyentes/tramites/seleccionNivel", method = RequestMethod.GET)
	@ResponseBody
	public List<ItemSelectOption> tramitesSeleccionNivelGET(@ModelAttribute("tramitesSeleccionInfo")
	final TramitesSeleccionInfo tramitesSeleccionInfo, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{

		System.out.println("------------------En GET SeleccionNivel------------------------");
		final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
		final List<ItemSelectOption> elementosResponse = new ArrayList<ItemSelectOption>();
		final List<TramiteOpcion> elementos = new ArrayList<TramiteOpcion>();



		//RIT
		elementos.add(new TramiteOpcion("010000", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("010000", new ItemSelectOption("01", "Creación")));
		elementos.add(new TramiteOpcion("010000", new ItemSelectOption("02", "Actualización")));
		//RIT-Creación
		elementos.add(new TramiteOpcion("010100", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("010100", new ItemSelectOption("01", "Creación de RIT")));
		elementos.add(new TramiteOpcion("010100", new ItemSelectOption("02", "Registro / Rol Tributario")));
		elementos.add(new TramiteOpcion("010100", new ItemSelectOption("03", "Creación de Calidad Sujeción Pasiva")));
		//RIT-Creación-Registro / Rol Tributario
		elementos.add(new TramiteOpcion("010102", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("010102", new ItemSelectOption("01", "Persona Natural")));
		elementos.add(new TramiteOpcion("010102", new ItemSelectOption("02", "Persona Jurídica")));
		//RIT-Creación-Creación de Calidad Sujeción Pasiva
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("01", "Predial unificado/ Propietario")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("02", "Predial unificado/ Usufructuario")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("03", "Predial unificado/ Beneficio/Fideicomitente")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("04", "Predial unificado/ Arrendatario")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("05", "Predial unificado/ Poseedor")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("06", "Vehículos automotores / Propietario")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("07", "Vehículos automotores / Poseedor")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("08", "Vehículos / Beneficio/Fideicomitente")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("09", "Industria y comercio ICA")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("10", "Delineación urbana")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("11", "Sobretasa a la gasolina")));
		elementos.add(new TramiteOpcion("010103", new ItemSelectOption("12", "Publicidad exterior visual")));
		//RIT-Actualización
		elementos.add(new TramiteOpcion("010200", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("010200", new ItemSelectOption("01", "Actualización de RIT")));
		elementos.add(new TramiteOpcion("010200", new ItemSelectOption("02", "Actualización de Rol tributario")));
		elementos.add(new TramiteOpcion("010200", new ItemSelectOption("03", "Actualización Calidad Sujeción Pasiva")));
		//RIT-Actualización-Actualización de Rol tributario
		elementos.add(new TramiteOpcion("010202", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("010202", new ItemSelectOption("01", "Persona Natural")));
		elementos.add(new TramiteOpcion("010202", new ItemSelectOption("02", "Persona Jurídica")));
		//RIT-Actualización-Actualización Calidad Sujeción Pasiva
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("01", "Predial unificado/ Propietario")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("02", "Predial unificado/ Usufructuario")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Predial unificado/ Beneficio/Fideicomitente")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Predial unificado/ Arrendatario")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Predial unificado/ Poseedor")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Vehículos automotores / Propietario")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Vehículos automotores / Poseedor")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Vehículos / Beneficio/Fideicomitente")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Industria y comercio ICA")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Delineación urbana")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Sobretasa a la gasolina")));
		elementos.add(new TramiteOpcion("010203", new ItemSelectOption("0", "Publicidad exterior visual")));

		//Novedades de registro
		elementos.add(new TramiteOpcion("020000", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020000", new ItemSelectOption("01", "Exclusiones")));
		elementos.add(new TramiteOpcion("020000", new ItemSelectOption("02", "Excenciones")));
		elementos.add(new TramiteOpcion("020000", new ItemSelectOption("03", "Tratamiento Especial")));
		elementos.add(new TramiteOpcion("020000", new ItemSelectOption("04", "Novedades RIT")));
		//Novedades de registro-Exclusiones
		elementos.add(new TramiteOpcion("020100", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020100", new ItemSelectOption("01", "Por Predial")));
		elementos.add(new TramiteOpcion("020100", new ItemSelectOption("02", "Por Vehículos")));
		elementos.add(new TramiteOpcion("020100", new ItemSelectOption("03", "Por Delineación Urbana")));
		//Novedades de registro-Exclusiones-Por Predial
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("01", "Uso Publico. Ronda-Canal-Zampa")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("02", "Uso Publico. General")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("03", "Iglesias Católicas")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("04", "Iglesias No Católicas")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("05", "Juntas de acción comunal")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("06", "Policía Nacional")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("07", "Fuerzas Militares")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("08", "Parques recreativos")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("09", "Instituto de desarrollo urbano IDU")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("10", "Avalúos inferiores a 16 SMLV")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("11", "Tumbas y bóvedas funerarias")));
		elementos.add(new TramiteOpcion("020101", new ItemSelectOption("12", "Victimas del despojo o Desplazamiento forzado")));
		//Novedades de registro-Exclusiones-Por Vehículos
		elementos.add(new TramiteOpcion("020102", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020102", new ItemSelectOption("01", "Motocicletas 125 cm3")));
		elementos.add(new TramiteOpcion("020102", new ItemSelectOption("02", "Maquinaria agrícola")));
		elementos.add(new TramiteOpcion("020102", new ItemSelectOption("03", "Vehículos oficiales")));
		//Novedades de registro-Exclusiones-Por Delineación Urbana
		elementos.add(new TramiteOpcion("020103", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020103", new ItemSelectOption("01", "Sujetos  convención Viena")));
		elementos.add(new TramiteOpcion("020103", new ItemSelectOption("02", "Soc. Nac. Cruz Roja Colombiana")));
		elementos.add(new TramiteOpcion("020103", new ItemSelectOption("03", "Distrito Capital")));
		//Novedades de registro-Excenciones
		elementos.add(new TramiteOpcion("020200", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020200", new ItemSelectOption("01", "Por Predial")));
		elementos.add(new TramiteOpcion("020200", new ItemSelectOption("02", "Vehículos")));
		elementos.add(new TramiteOpcion("020200", new ItemSelectOption("03", "Por Delineación Urbana")));
		elementos.add(new TramiteOpcion("020200", new ItemSelectOption("04", "Por ICA")));
		//Novedades de registro-Excenciones-Por Predial
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("01", "Interes Actual")));
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("02", "Sindicatos")));
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("03", "Distrito bienes por dependencia")));
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("04", "Actos Terroristas")));
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("05", "Catástrofes Nataturales")));
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("06", "Secuestro/Desaparición forzada")));
		elementos.add(new TramiteOpcion("020201", new ItemSelectOption("07", "Banco de Suelo Distrital")));
		//Novedades de registro-Excenciones-Vehículos
		elementos.add(new TramiteOpcion("020202", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020202", new ItemSelectOption("01", "Actos Terroristas")));
		elementos.add(new TramiteOpcion("020202", new ItemSelectOption("02", "Catástrofes Nataturales")));
		elementos.add(new TramiteOpcion("020202", new ItemSelectOption("03", "Secuestro/Desaparición forzada")));
		//Novedades de registro-Excenciones-Por Delineación Urbana
		elementos.add(new TramiteOpcion("020203", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020203", new ItemSelectOption("01", "Actos Terroristas")));
		elementos.add(new TramiteOpcion("020203", new ItemSelectOption("02", "Catástrofes Nataturales")));
		elementos.add(new TramiteOpcion("020203",
				new ItemSelectOption("03", "Obras nuevas de vivienda de interés social estratos 1,2, y 3")));
		elementos.add(new TramiteOpcion("020203",
				new ItemSelectOption("04", "Obras de autoconstrucción de vivienda, de estratos 1 y 2 que no excedan de 135 SMLV")));
		elementos.add(new TramiteOpcion("020203", new ItemSelectOption("05",
				"Las ampliaciones, modificaciones, adecuaciones o reparación de los inmuebles de los estratos 1, 2 y 3 de uso residencial, con avalúo catastral vigente inferior a 135")));
		elementos.add(new TramiteOpcion("020203",
				new ItemSelectOption("06", "Las obras de restauración y conservación en los bienes inmuebles de interés cultural.")));
		//Novedades de registro-Excenciones-Por ICA
		elementos.add(new TramiteOpcion("020204", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020204", new ItemSelectOption("01", "Actos Terroristas")));
		elementos.add(new TramiteOpcion("020204", new ItemSelectOption("02", "Catástrofes Nataturales")));
		elementos.add(new TramiteOpcion("020204", new ItemSelectOption("03", "Secuestro/Desaparición forzada")));
		//Novedades de registro-Tratamiento Especial
		elementos.add(new TramiteOpcion("020300", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020300", new ItemSelectOption("01", "Por Predial")));
		//Novedades de registro-Tratamiento Especial-Por Predial
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("01", "Suelo Rural")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("02", "Desarrollo Urbanístico")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("03", "Áreas Protegidas")));
		elementos.add(new TramiteOpcion("020301",
				new ItemSelectOption("04", "Predios con actividades industriales de bajo y   medio impacto al medio ambiente")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("05", "Remoción de tierras y riesgo no mitigable")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("06", "Desastres naturales o atentado terrorista")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("07",
				"Entidades de asistencia pública, entidades con fines de interés social y de utilidad pública y fundaciones, sin animo de lucro, de derecho público o privado")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("08", "Extinción de dominio")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("09", "Predios con actividad financiera")));
		elementos.add(new TramiteOpcion("020301", new ItemSelectOption("10", "Zona Franca")));
		//Novedades de registro-Novedades RIT
		elementos.add(new TramiteOpcion("020400", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020400", new ItemSelectOption("01", "Por ICA")));
		//Novedades de registro-Novedades RIT-Por ICA
		elementos.add(new TramiteOpcion("020401", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("020401", new ItemSelectOption("01", "Actividad Económica")));
		elementos.add(new TramiteOpcion("020401", new ItemSelectOption("01", "Cambio de representante legal")));
		elementos.add(new TramiteOpcion("020401", new ItemSelectOption("01", "Cambio de revisor Fiscal")));
		elementos.add(new TramiteOpcion("020401", new ItemSelectOption("01", "Cambio de Contador")));
		elementos.add(new TramiteOpcion("020401", new ItemSelectOption("01", "Cambio de establecimientos")));

		//Facturación
		elementos.add(new TramiteOpcion("030000", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("030000", new ItemSelectOption("01", "Por Predial")));
		elementos.add(new TramiteOpcion("030000", new ItemSelectOption("02", "Por Vehículos")));
		//Facturación-Por Predial
		elementos.add(new TramiteOpcion("030100", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("030100", new ItemSelectOption("01", "Descarga de Factura")));
		elementos.add(new TramiteOpcion("030100", new ItemSelectOption("02", "Descuento adicional del 1%")));
		elementos.add(new TramiteOpcion("030100", new ItemSelectOption("03", "Reexpedicion de facturas")));
		elementos.add(new TramiteOpcion("030100", new ItemSelectOption("04", "Solicitud de moficación de Factura")));
		elementos.add(new TramiteOpcion("030100", new ItemSelectOption("05", "Solicitud de anulacion de facturas ")));
		//Facturación-Por Predial-Solicitud de moficación de Factura
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("01", "Modificación Avaluó Catastral")));
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("02", "Modificación de destino hacendario")));
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("03", "Modificación  tarifa")));
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("04", "Ajuste % Participación")));
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("05", "Exclusiones Parciales Predial")));
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("06", "Exenciones Parciales Predial")));
		elementos.add(new TramiteOpcion("030104", new ItemSelectOption("07", "Descuentos por incremento diferencial")));
		//Facturación-Por Predial-Solicitud de anulacion de facturas
		elementos.add(new TramiteOpcion("030105", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("030105", new ItemSelectOption("01", "No sujeción")));
		elementos.add(new TramiteOpcion("030105", new ItemSelectOption("02", "Inexistencia actual del objeto")));
		elementos.add(new TramiteOpcion("030105", new ItemSelectOption("03", "Exencion total del  objeto")));
		elementos.add(new TramiteOpcion("030105", new ItemSelectOption("04", "Exclusión total del  objeto")));
		//Facturación-Por Vehículos
		elementos.add(new TramiteOpcion("030200", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("030200", new ItemSelectOption("01", "Descarga de Factura")));
		elementos.add(new TramiteOpcion("030200", new ItemSelectOption("02", "Reexpedición de Factura")));
		elementos.add(new TramiteOpcion("030200", new ItemSelectOption("03", "Moficación de Factura")));
		elementos.add(new TramiteOpcion("030200", new ItemSelectOption("04", "Anulación de Factura")));
		//Facturación-Por Vehículos-Moficación de Factura
		elementos.add(new TramiteOpcion("030203", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("030203", new ItemSelectOption("01", "Modificación Avaluó")));
		elementos.add(new TramiteOpcion("030203",
				new ItemSelectOption("02", "Modificación de placa, marca, línea, modelo, capacidad(cilindraje),  uso y grupo")));
		//Facturación-Por Vehículos-Anulación de Factura
		elementos.add(new TramiteOpcion("030204", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("030204", new ItemSelectOption("01", "No sujeción")));
		elementos.add(new TramiteOpcion("030204", new ItemSelectOption("02", "Inexistencia objeto")));
		elementos.add(new TramiteOpcion("030204", new ItemSelectOption("03", "Exención total del  objeto")));
		elementos.add(new TramiteOpcion("030204", new ItemSelectOption("04", "Exclusión total  del  objeto")));

		//Analisis de la cuenta
		elementos.add(new TramiteOpcion("040000", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("040000", new ItemSelectOption("01", "Certificación de deuda")));
		elementos.add(new TramiteOpcion("040000",
				new ItemSelectOption("02", "Diferencia en la imputación de pagos efectuados a través de declaraciones y/o ROP")));
		elementos.add(new TramiteOpcion("040000", new ItemSelectOption("03", "Ajuste por situaciones administrativas")));
		elementos.add(new TramiteOpcion("040000", new ItemSelectOption("04", "Revisión de datos SAP")));

		//Boletín de deudores Morosos del Estado
		elementos.add(new TramiteOpcion("050000", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("050000", new ItemSelectOption("01", "Deuda Cancelada")));
		elementos.add(new TramiteOpcion("050000", new ItemSelectOption("02", "Saneamiento de información")));
		elementos.add(new TramiteOpcion("050000", new ItemSelectOption("03", "Existe acuerdo de pago vigente")));
		elementos.add(new TramiteOpcion("050000", new ItemSelectOption("04", "Otra cual")));

		//Declaración
		elementos.add(new TramiteOpcion("080000", new ItemSelectOption("00", "Seleccionar")));
		elementos.add(new TramiteOpcion("080000",
				new ItemSelectOption("01", "Autorización por declaración valores inferiores al sugerido")));
		elementos.add(new TramiteOpcion("080000", new ItemSelectOption("02", "Porcentaje de copropiedad")));
		elementos.add(new TramiteOpcion("080000", new ItemSelectOption("03", "Doble sujeción pasiva (Propietario, Poseedor)")));
		elementos.add(new TramiteOpcion("080000", new ItemSelectOption("04", "Pago Equivocado")));


		final String valorN0 = tramitesSeleccionInfo.getValorN0().isEmpty() ? "00" : tramitesSeleccionInfo.getValorN0();
		final String valorN1 = tramitesSeleccionInfo.getValorN1().isEmpty() ? "00" : tramitesSeleccionInfo.getValorN1();
		final String valorN2 = tramitesSeleccionInfo.getValorN2().isEmpty() ? "00" : tramitesSeleccionInfo.getValorN2();


		final String seleccionStr = valorN0 + valorN1 + valorN2;
		for (final TramiteOpcion elemento : elementos)
		{
			if (elemento.getKey().equals(seleccionStr))
			{
				elementosResponse
						.add(new ItemSelectOption(elemento.getTramiteOpcion().getKey(), elemento.getTramiteOpcion().getLabel()));
			}
		}


		storeCmsPageInModel(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(TRAMITES_CREAR_CMS_PAGE));


		return elementosResponse;
	}

}
