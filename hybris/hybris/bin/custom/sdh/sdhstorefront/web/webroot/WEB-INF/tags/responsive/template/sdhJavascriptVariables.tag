<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:set value="1" var="configCatalogos_cantidadAnios_Consultas_predial" />
<c:set value="1" var="configCatalogos_cantidadAnios_Consultas_vehiculos" />
<c:set value="1" var="configCatalogos_cantidadAnios_Consultas_ica" />
<c:set value="2" var="configCatalogos_cantidadAnios_Consultas_gasolina" />
<c:set value="1" var="configCatalogos_cantidadAnios_Consultas_delineacion" />
<c:set value="2" var="configCatalogos_cantidadAnios_Consultas_publicidad" />
<%-- JS configuration --%>
	<script type="text/javascript">

		/*<![CDATA[*/
			<c:if test="${not empty representado}">
				ACC.aamenus = "${aamenus}";
			</c:if>
			ACC.flagFiltrarMenuContrib = true;
			<c:if test="${uiMenuForm.bNoFiltrarMenuContrib}">
				ACC.flagFiltrarMenuContrib = false;
			</c:if>
			ACC.aaEntidadBancariaMenuflagEjecutar = false;
			<c:if test="${aaEntidadBancaria == true}">
				ACC.aaEntidadBancariaMenuflagEjecutar = true;
			</c:if>

			
			ACC.certifNombURL ="<c:url value='/contribuyentes/mirit/certifNomb' />";
			ACC.validaCurrentPasswrodURL ="<c:url value='/contribuyentes/mirit/validCurrentPassword' />";
			ACC.validaEmailURL ="<c:url value='/contribuyentes/mirit/validNewEmail' />";
			ACC.updateRitURL ="<c:url value='/contribuyentes/mirit/updateRit' />";
			ACC.updateEmailRitURL ="<c:url value='/contribuyentes/mirit/updateEmail' />";
			ACC.updatePasswordRitURL ="<c:url value='/contribuyentes/mirit/updatePassword' />";
			ACC.updateAutorizacionesRitURL ="<c:url value='/contribuyentes/mirit/updateAutorizaciones' />";
			ACC.updateRedesSocialesRitURL ="<c:url value='/contribuyentes/mirit/updateRedesSociales' />";
			ACC.updateTelefonoRitURL ="<c:url value='/contribuyentes/mirit/updateTelefono' />";
			ACC.updateTelefonosRitURL ="<c:url value='/contribuyentes/mirit/updateTelefonos' />";
			ACC.updateAddressRitURL ="<c:url value='/contribuyentes/mirit/updateAddress' />";
			ACC.updateNombreRitURL ="<c:url value='/contribuyentes/mirit/updateNombre' />";
			
			ACC.addressNotificationCountry = "";
			<c:if test="${not empty miRitForm.direccionNotificacion.COUNTRY}">
				ACC.addressNotificationCountry = "${ miRitForm.direccionNotificacion.COUNTRY}";
			</c:if>
			
			ACC.addressNotificationDep = "";
			<c:if test="${not empty miRitForm.direccionNotificacion.REGION}">
				ACC.addressNotificationDep = "${ miRitForm.direccionNotificacion.REGION}";
			</c:if>
			
			ACC.addressNotificationMun = "";
			<c:if test="${not empty miRitForm.direccionNotificacion.CITY1}">
				ACC.addressNotificationMun = "${ miRitForm.direccionNotificacion.CITY1}";
			</c:if>
			
			ACC.addressNotificationPC = "";
			<c:if test="${not empty miRitForm.direccionNotificacion.POST_CODE}">
				ACC.addressNotificationPC = "${ miRitForm.direccionNotificacion.POST_CODE}";
			</c:if>
				
			ACC.addressContactoCountry = "";
			<c:if test="${not empty miRitForm.direccionContacto.COUNTRY}">
				ACC.addressContactoCountry = "${ miRitForm.direccionContacto.COUNTRY}";
			</c:if>
			
			ACC.addressContactoDep = "";
			<c:if test="${not empty miRitForm.direccionContacto.REGION}">
				ACC.addressContactoDep = "${ miRitForm.direccionContacto.REGION}";
			</c:if>
			
			ACC.addressContactoMun = "";
			<c:if test="${not empty miRitForm.direccionContacto.CITY1}">
				ACC.addressContactoMun = "${ miRitForm.direccionContacto.CITY1}";
			</c:if>
			
			ACC.addressContactoPC = "";
			<c:if test="${not empty miRitForm.direccionContacto.POST_CODE}">
				ACC.addressContactoPC = "${ miRitForm.direccionContacto.POST_CODE}";
			</c:if>
			
			ACC.publicidadExteriorDetalleURL = "<c:url value='/contribuyentes/publicidadexterior/detalle' />";
			
			ACC.contribList = "<c:url value='/contribuyentes'/>";
			
			ACC.generaROPURL = "<c:url value='/contribuyentes/rop' />";
			
			ACC.publicidadExteriorDeclararionURL = "<c:url value='/contribuyentes/publicidadexterior/declaracion' />";
			
			ACC.publicidadExteriorCalculoURL = "<c:url value='/contribuyentes/publicidadexterior/declaracion/calculo' />";
			
			ACC.generaDeclaracionURL = "<c:url value='/contribuyentes/publicidadexterior/declaracion/generar' />";
			
			ACC.gasolinaGeneraDeclaracionURL = "<c:url value='/contribuyentes/sobretasa-gasolina/generar' />";
			
			ACC.certificacionPagosGenerarURL= "<c:url value='/contribuyentes/consultas/certipagos' />";
			
			ACC.declaracionDelineacionurbanaURL= "<c:url value='/contribuyentes/delineacionurbana/declaracion' />";
			
			ACC.retencionDelineacionurbanaURL= "<c:url value='/contribuyentes/delineacionurbana/retencion' />";

			ACC.radicaDelinDetallesURL= "<c:url value='/contribuyentes/delineacion-urbana/detalle' />";
			
		  	ACC.duGeneraDeclaracionURL = "<c:url value='/contribuyentes/delineacion-urbana/generar' />";
			
		  	ACC.icaDeclaracionCalculoURL = "<c:url value='/contribuyentes/ica/declaracion/calculo' />";
		  	
		  	ACC.reteICARegistroRetencionesURL = "<c:url value='/retenedores/registroretenciones' />";
		  	
			ACC.reteICAValidaArchivoURL = "<c:url value='/retenedores/registroretenciones/validaArchivo' />";
			
			ACC.reteICACalculoURL = "<c:url value='/retenedores/declaracion/calculo' />";
			
			ACC.reteICAGeneraDeclaracionURL = "<c:url value='/retenedores/declaracion/generar' />";

			ACC.casoSeleccionURL= "<c:url value='/contribuyentes/tramites/seleccionNivel' />";			
			
			ACC.casoSeleccionURLRol= "<c:url value='/register/contribuyentes/tramites/seleccionNivelRol' />";			

			ACC.casoCreacionURL= "<c:url value='/contribuyentes/tramites/creacionCaso' />";		

			ACC.casoCreacionURLRol= "<c:url value='/register/contribuyentes/tramites/creacionCaso' />";				

			ACC.casoConsultaURL= "<c:url value='/contribuyentes/tramites/consultaCaso' />";			

			ACC.declaracionPDFURL= "<c:url value='/contribuyentes/consultas/declaraciones/declaracionPDF' />";	

			ACC.declaracionImprimirURL= "<c:url value='/contribuyentes/consultas/certideclaraciones/declaracionImprimir' />";	
			
			ACC.listaDeclaracionesURL= "<c:url value='/contribuyentes/consultas/declaraciones/listaDeclaraciones' />";	

			ACC.presentarDecListaDeclaracionesURL= "<c:url value='/contribuyentes/presentar-declaracion/listaDeclaraciones' />";	

			ACC.presentarDecValidacionPublicidadURL= "<c:url value='/contribuyentes/presentar-declaracion/validacionPublicidad' />";	

			ACC.certiPagosListaURL= "<c:url value='/contribuyentes/consultas/certipagos/listaPagos' />";	

			ACC.tipoPeriodoDeclaracionURL= "<c:url value='/contribuyentes/consultas/declaraciones/tipoPeriodoDec' />";	
			
			ACC.certiPagoImprimeURL= "<c:url value='/contribuyentes/consultas/certipagos/pagoImprimir' />";	
			
			ACC.certiPagoImprimeFormURL= "<c:url value='/impuestos/pagoEnLinea/pseResponse/pagoImprimirForm' />";	
			
			ACC.predial_presentarDecURL= "<c:url value='/contribuyentes/predialunificado_inicio/presentarDec' />";
			
			ACC.vehiculosDetalleURL = "<c:url value='/contribuyentes/sobrevehiculosautomotores/detalle/vehiculo' />";
			
			ACC.gestionBancariaCargaArchivo = "<c:url value='/autorizados/entidades/reportarinfo' />";
			
			ACC.vehiculosDeclararionURL = "<c:url value='/contribuyentes/sobrevehiculosautomotores/declaracion' />";
			
			ACC.vehiculosDeclaCalculoURL = "<c:url value='/contribuyentes/sobrevehiculosautomotores/declaracion/calculo' />";
			
			ACC.vehiculosCatalogosURL = "<c:url value='/contribuyentes/sobrevehiculosautomotores/declaracion/catalogos' />";
			
			ACC.vehiculosGeneraDeclaracionURL = "<c:url value='/contribuyentes/sobrevehiculosautomotores/declaracion/generar' />";

			ACC.tramiteExitosoURL = "<c:url value='/contibuyentes/tramites' />";
			
			ACC.predialDetalleURL="<c:url value='/contribuyentes/predialunificado_inicio/detalle' />";
			ACC.precalculoPredialBPURL="<c:url value='/contribuyentes/predialunificado_inicio/precalculoPredialBP' />";
			
			ACC.predialDeclaraURL="<c:url value='/contribuyentes/predialunificado/URL' />";
			ACC.predialDeclaradosURL="<c:url value='/contribuyentes/predialunificado_2' />";
			ACC.predialDeclaratresURL="<c:url value='/contribuyentes/predialunificado_3' />";
			ACC.predialDeclaracuatroURL="<c:url value='/contribuyentes/predialunificado_4' />";
			ACC.predialDeclaracincoURL="<c:url value='/contribuyentes/predialunificado_5' />";
			ACC.predialDeclaraseisURL="<c:url value='/contribuyentes/predialunificado_6' />";
			ACC.predialDeclarasieteURL="<c:url value='/contribuyentes/predialunificado_7' />";
			ACC.predialDeclaraochoURL="<c:url value='/contribuyentes/predialunificado_8' />";
			ACC.predialDeclarabasesURL="<c:url value='/contribuyentes/predialunificado/basespresuntivas' />";
			
			ACC.calculoPredialURL="<c:url value='/contribuyentes/predialunificado/calculo' />";

			ACC.declaracionPredialURL="<c:url value='/contribuyentes/predialunificado/URL/declara' />";
			
			ACC.listaConcesionariosURL="<c:url value='/concesionarios/listado' />";
			
			ACC.descargaFacturaURL="<c:url value='/contribuyentes/descargafactura/descargarFactura' />";
			ACC.facturacionPagosURL="<c:url value='/contribuyentes/descargafactura/facturacionPagos' />";

			ACC.spacURL="<c:url value='/contribuyentes/spac' />";

			ACC.spacPDFURL="<c:url value='/contribuyentes/spac/PDF' />";
			
			ACC.consultaTerceroAutorizado= "<c:url value='/terceros/consultaTA' />";

			ACC.trmPDFString= "<c:url value='/trmService/getPdfString' />";
			
			ACC.actualizaICAActEcoURL= "<c:url value='/contribuyentes/mirit/updateICAActEco' />";
			ACC.consultaEstadoCuentaURL= "<c:url value='/contribuyentes/mirit/consultaEstadoCuenta' />";
			
			
			ACC.relacionPagosServicioURL = "<c:url value='/contribuyentes/consultas/relacionpagos/servicio' />";

		  	ACC.currentURL = "${currentURL}";
		  	
		  	ACC.inicialURL = "<c:url value='/' />";

		  	
			
		  	<c:if test="${not empty reteICATemplateURL}">
		  		ACC.reteICADownloadTemplate ="${reteICATemplateURL}";
			</c:if>
			ACC.hideSubmenuDelineacionUrbana = true;
			ACC.hideSubmenuICA = true;
			ACC.hideSubmenuPredial = true;
			ACC.hideSubmenuPublicidadExt = true;
			ACC.hideSubmenuVehicular = true;
			ACC.hideSubmenuGasolina = true;
			
			
			<c:if test="${(hasCORol and fn:contains(currentURL, 'contribuyentes')) or (hasCORol and fn:contains(currentURL, 'pagoEnLinea') or (hasAARol))}">
				
				<c:if test = "${uiMenuForm.bDelineacionUrbana == 'X'}">
					ACC.hideSubmenuDelineacionUrbana = false;
				</c:if>
				
				<c:if test = "${uiMenuForm.bIca == 'X'}">
					ACC.hideSubmenuICA = false;
				</c:if>
				
				<c:if test = "${uiMenuForm.bPredial == 'X'}">
					ACC.hideSubmenuPredial = false;
				</c:if>
				
				<c:if test = "${uiMenuForm.bPublicidadExt == 'X'}">
					ACC.hideSubmenuPublicidadExt = false;
				</c:if>
				
				<c:if test = "${uiMenuForm.bVehicular == 'X'}">
					ACC.hideSubmenuVehicular = false;
				</c:if>
				<c:if test = "${uiMenuForm.bSobreGasolina == 'X'}">
					ACC.hideSubmenuGasolina = false;
				</c:if>	
			</c:if>
			<c:if test="${hasAARol }">
			</c:if>
			<c:if test="${hasTARol }">
			</c:if>
			<c:if test="${hasARRol }">
			</c:if>
			<c:if test="${hasRIRol and fn:contains(currentURL, 'reportantes')}">
			</c:if>
			
			
			<c:choose>
				<c:when test="${not empty reteIcaMaxFileSize}">
					ACC.reteIcaMaxFileSize = ${reteIcaMaxFileSize};
					ACC.customerNIT
				</c:when>
				<c:otherwise>
					ACC.reteIcaMaxFileSize = 1024;
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${not empty customerNIT}">
					ACC.customerNIT = ${customerNIT};
				</c:when>
				<c:otherwise>
					ACC.customerNIT = "";
				</c:otherwise>
			</c:choose>
            <c:if test="${not empty agents}">
		        ACC.agentesFirmas = ${agents};
		        ACC.agentFunctions = ${agentFunctions};
            </c:if>

			ACC.publicidadExteriorFirmar  = '<c:url value="/contribuyentes/publicidadexterior/declaracion/firmar"  />';
			ACC.gasolinaFirmar  = '<c:url value="/contribuyentes/gasolina/declaracion/firmar"  />';

			ACC.declaracionFirmas = '<c:url value="/contribuyentes/declaracion/firmar"  />';
			
			
			ACC.configCatalogos_cantidadAnios_Consultas_predial="${configCatalogos_cantidadAnios_Consultas_predial}";
			ACC.configCatalogos_cantidadAnios_Consultas_vehiculos="${configCatalogos_cantidadAnios_Consultas_vehiculos}";
			ACC.configCatalogos_cantidadAnios_Consultas_ica="${configCatalogos_cantidadAnios_Consultas_ica}";
			ACC.configCatalogos_cantidadAnios_Consultas_gasolina="${configCatalogos_cantidadAnios_Consultas_gasolina}";
			ACC.configCatalogos_cantidadAnios_Consultas_delineacion="${configCatalogos_cantidadAnios_Consultas_delineacion}";
			ACC.configCatalogos_cantidadAnios_Consultas_publicidad="${configCatalogos_cantidadAnios_Consultas_publicidad}";	
	
		/*]]>*/
	</script>