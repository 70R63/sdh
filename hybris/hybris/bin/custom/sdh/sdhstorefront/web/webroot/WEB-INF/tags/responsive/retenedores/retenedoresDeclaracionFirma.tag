<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<input type="hidden" id="numForm" name="numForm" value="${calculoResponse.numForm }"/>
<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL" htmlEscape="false" />
<div class="container">
	<div class="row mt-3">
		<div class="col-md-12 mt-3">
			<div class="row">
				<div class="col-md-3">
					<c:url value="/retenedores/estadocargas" var="edoCargasURL"/>
					<a id="downloadReteICADeclaracionHelper" target="_blank"></a>
					<button type="button" id="" class="btn btn-secondary btn-lg" type="button" onclick="window.location.href = '${edoCargasURL}'">
						<spring:theme code="reteica.declaracion.firma.regresar" />
					</button>
				</div>
					<div class="col-md-3">
					<c:set var="disbled" value=""/>
					<c:if test="${empty calculoResponse.numForm }">
						<c:set var="disabled" value="disabled"/>	
					</c:if>
					
					<button id="generaDeclaracionReteICAButton" class="btn btn-primary btn-lg" type="button" ${disabled }>
						<spring:theme code="reteica.declaracion.firma.presendecla" />
					</button>
				</div>
					<div class="col-md-3">
						<sf:form action="${pagarURL}" method="POST" modelAttribute="infoPreviaPSE" id="infoPreviaPSE">
							<sf:hidden path="tipoImpuesto" />
							<sf:hidden path="numBP" />
							<sf:hidden path="numDoc" />
							<sf:hidden path="tipoDoc" />
							<sf:hidden path="anoGravable" />
							<sf:hidden path="periodo" />
							<sf:hidden path="clavePeriodo" />
							<sf:hidden path="dv" />
							<sf:hidden path="numObjeto" />
							<sf:hidden path="fechaVenc"/>
                            <sf:hidden path="numRef"/>
                            <sf:hidden path="totalPagar"/>
							<button id="pagar" class="btn btn-primary btn-lg" type="submit" id="action" name="pagar" value="pagar" ${paymentDisabled} >
								<spring:theme code="reteica.declaracion.firma.paglinea" />
							</button>
						</sf:form>
					</div>
			</div>

		</div>
	</div>
</div>




<script>
	function addfirma() {

		var tam = $(".firma").length;
		if ($(".firma").length < 3) {
			$($(".firma")[0]).parent().append($($(".firma")[0]).clone());
			$($(".firma")[0]).parent().children().last().find(".tipodoc").val(
					"")
			$($(".firma")[0]).parent().children().last().find(".numdoc")
					.val("")
			$($(".firma")[0]).parent().children().last().find(".name").val("")

		} else {
			alert("No se pueden agregar más registros");
		}

	}
</script>