<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-6">
			<div class="form-group">
				<button id="certificacionRIT" class="btn btn-primary btn-lg" type="button" onclick="descargaFactura()">
					<spring:theme code="facturacion.reexpedirFactura.inicial.reexpedirFactura" />
				</button>
			</div>
		</div>
	</div>

</div>
<div class="container">
	<spring:url value="/contribuyentes/reexpedicionfacturaAct" var="reexpedicionURL" htmlEscape="false" />
	<sf:form action="${reexpedicionURL}" method="GET"
		modelAttribute="dataForm" id="reexpedicionFacturaAct">
		<sf:hidden path="descargaFactura.anoGravable" id="anoGravable"/>
		<sf:hidden path="descargaFactura.numObjeto" id="numObjeto"/>
	</sf:form>
</div>

<script>
	function descargaFactura() {

		var anoGravable = $("#anoGravable").val();
		var numObjeto = $("#numObjeto").val();
		
		ACC.facturacion.descargaFactura(anoGravable,numObjeto,2);
	}
</script>
