<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<link href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js"></script>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/terceros/objeto" var="actionURL" htmlEscape="false" />
	
<div class="container_new_page" id="buscarObjeto" style="display: none">
    <div class="row">
        <form:form method="get" commandName="tercerosAutForm" action="${actionURL}" >
             <div class="col-md-5">
				<formElement:formInputBox idKey="numObjeto" labelKey="terceros.sim.buscar.numeroObjeto" path="numObjeto" />
             </div>
			<div class="row md-5">
				<div class="col-md-5 text-right">
					<sf:button class="btn btn-primary btn-lg !important taConsultaEnviar" type="button" id="btnEnviar"
					name="btnEnviar" value="enviar" disabled="false" onclick="consultaTA('objeto')" >
					<spring:theme code="terceros.sim.buscar.buscar" />
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
	function consultaTA(opcionBusqueda) {
		ACC.reportesTerceroAutorizado.consultaTA(opcionBusqueda);
	}
	
	function btnCancelar(){
		window.history.back();
	}
</script>