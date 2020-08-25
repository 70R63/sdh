<%-- <%@ tag body-content="empty" trimDirectiveWhitespaces="true"%> --%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- <link href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap.min.css" rel="stylesheet"> -->
<!-- <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script> -->
<!-- <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js"></script> -->

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/terceros/sujeto" var="actionURL" htmlEscape="false" />

<c:set var="flagMostrarObjeto" value="none" />
<c:set var="flagMostrarSujeto" value="none" />
<c:choose>
	<c:when test="${tercerosAutForm.subrol == '03_01'}">
		<c:set var="flagMostrarSujeto" value="block" />
	</c:when>
	<c:when test="${tercerosAutForm.subrol == '03_02'}">
	</c:when>
	<c:when test="${tercerosAutForm.subrol == '03_03'}">
	</c:when>
	<c:when test="${tercerosAutForm.subrol == '03_04'}">
	</c:when>
</c:choose>

<div class="container_new_page" id="buscarSujeto" style="display: ${flagMostrarSujeto}">
    <div class="row">
        <form:form method="get" commandName="tercerosAutForm" action="${actionURL}" >
            <div class="col-sm-3">
                <formElement:formSelectBox idKey="tipdoc" labelKey="terceros.notario.buscar.tipdoc"
                    path="tipdoc" mandatory="false" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"
                    items="${documentTypes}" selectCSSClass="form-control" disabled="false"/>

            </div>
            <div class="col-sm-3">
                <formElement:formInputBox idKey="numdoc" labelKey="terceros.notario.buscar.numdoc" path="numdoc" />
            </div>
            <div class="col-md-5">
                <formElement:formSelectBox idKey="impuesto" labelKey="terceros.notario.buscar.impuesto"
                                path="impuesto" mandatory="false" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"
                                items="${tercerosAutForm.listaImpuestos}" selectCSSClass="form-control" disabled="false" onchange="reiniciarSeleccion()"/>
            </div>

            
			<div class="row md-5">
				<div class="col-md-5 text-right">
					<sf:button class="btn btn-primary btn-lg !important taConsultaEnviar" type="button" id="btnEnviar"
					name="btnEnviar" value="enviar" disabled="false" onclick="consultaTA('sujeto')">
					<spring:theme code="terceros.notario.buscar.buscar" />
					</sf:button>
				</div>
				<div class="col-md-1">
					<button style="margin-top: 3px;" id=""
						class="btn btn-secondary btn-lg" type="button" 
						onclick="btnCancelar()">
						<spring:theme code="tramites.crear.inicial.cancelar" />
					</button>
				</div>
			</div>
         </form:form>
     </div>
</div>


<script>
	function reiniciarSeleccion(){
		ACC.reportesTerceroAutorizado.displayTablas('none');
	}

	function consultaTA(opcionBusqueda) {
		ACC.reportesTerceroAutorizado.consultaTA(opcionBusqueda);
	}
	function btnCancelar(){
		window.history.back();
	}
</script>