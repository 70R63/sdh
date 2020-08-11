<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<%-- <div>--${tercerosAutForm.subrol}--</div> --%>
<spring:htmlEscape defaultHtmlEscape="true" />
<c:set var="mostrarObjeto" value="false" />
<c:set var="mostrarSujeto" value="false" />
<c:choose>
<c:when test="${tercerosAutForm.subrol == '03_01'}">
<c:set var="mostrarObjeto" value="false" />
<c:set var="mostrarSujeto" value="true" />
</c:when>
<c:when test="${tercerosAutForm.subrol == '03_02'}">
<c:set var="mostrarObjeto" value="false" />
<c:set var="mostrarSujeto" value="true" />
</c:when>
<c:when test="${tercerosAutForm.subrol == '03_03'}">
<c:set var="mostrarObjeto" value="true" />
<c:set var="mostrarSujeto" value="false" />
</c:when>
<c:when test="${tercerosAutForm.subrol == '03_04'}">
<c:set var="mostrarObjeto" value="true" />
<c:set var="mostrarSujeto" value="false" />
</c:when>

</c:choose>
<div class="container_new_page" id="opcionesBuscar">
	<c:if test="${mostrarSujeto == true}">
		<div class="col-md-3 col-md-offset-1">
			<button type="button" class="btn btn-primary btn-lg" id="action"
				name="action" value="Imprimir" style="margin-top: 3px"
				onclick="habilitarBusqueda('sujeto');">
				<spring:theme code="terceros.menu.sujeto" />
			</button>
		</div>
	</c:if>
	<c:if test="${mostrarObjeto == true}">
		<div class="col-md-3 col-md-offset-1">
			<button type="button" class="btn btn-primary btn-lg" id="action"
				name="action" value="Imprimir" style="margin-top: 3px"
				onclick="habilitarBusqueda('objeto');">
				<spring:theme code="terceros.menu.objeto" />
			</button>
		</div>
	</c:if>
</div>


<script type="text/javascript">
function habilitarBusqueda(opcionBusqueda){
	
	var nombreObjeto = null;
	
	switch(opcionBusqueda){
	case "sujeto":
		opcionVisualizar("buscarSujeto","block");
		opcionVisualizar("buscarObjeto","none");
		break;
	case "objeto":
		opcionVisualizar("buscarSujeto","none");
		opcionVisualizar("buscarObjeto","block");
		break;		
	}
	
	
}

function opcionVisualizar(nombreObjeto,opcionMostrar){
	
	if(nombreObjeto != null){
		var doc = document.getElementById(nombreObjeto);
		if(doc != null){
			doc.style.display = opcionMostrar; 
		}
	}
	
}
</script>