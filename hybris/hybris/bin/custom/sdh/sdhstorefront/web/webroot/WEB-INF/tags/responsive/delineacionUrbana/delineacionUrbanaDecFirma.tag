<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/impuestos/preparaPagoPSE" var="pagarURL" htmlEscape="false" />

<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h3>
				<span><spring:theme code="delineacion.urbana.dec.firm.title" /></span>
			</h3>
		</div>
	</div>

<c:set var="tipoDescripcionID" value='${dataForm.valCont.infoContrib.tipoDoc}' />
<c:set var="nombreCompleto" value='${dataForm.valCont.infoContrib.primNom} ${dataForm.valCont.infoContrib.primApe}' />
		<div class="row">
			<div class="col-md-3">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.firm.tipiden" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="${tipoDescripcionID}" maxlength="240">
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.firm.numide" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="${dataForm.valCont.infoContrib.numDoc}" maxlength="240">
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.firm.nombraz" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						value="${nombreCompleto}" maxlength="240" disabled>
				</div>
			</div>
		</div>



		<br>
		<div class="container">
			<div class="row">
				<sf:form action="${pagarURL}" method="POST" modelAttribute="infoPreviaPSE" id="infoPreviaPSE">

				<div class=" col-md-3">
					<button type="button" class="btn btn-secondary btn-lg"
						id="regresarButton" name="" value="regresar" onclick="goBack4()">
						<spring:theme code="delineacion.urbana.dec.firm.regresar" />
					</button>
				</div>

				<div class=" col-md-3">
					<button type="button" class="btn btn-primary btn-lg" id="" name=""
						value="" onclick="window.location.href ='<c:url value='/contribuyentes' />';">
						<spring:theme code="delineacion.urbana.dec.firm.cancelar" />
					</button>
				</div>

				<div class="col-md-3">
		<a id="downloadHelper" target="_blank"></a>		
		<button id="duGeneraDeclaracionButton" type="button"
			<c:out value='${empty dataForm.infObjetoDelineacion.numForm ? "disabled":""}'/>
			class="btn btn-primary btn-lg" onclick="pagarlinea()">
			<spring:theme code="delineacion.urbana.dec.firm.predec" />
		</button>
				</div>

				<sf:hidden path="tipoImpuesto"/>
				<sf:hidden path="numBP" />
				<sf:hidden path="numDoc" />
				<sf:hidden path="tipoDoc" />
				<sf:hidden path="anoGravable" />
				<sf:hidden path="periodo" />
				<sf:hidden path="clavePeriodo" />
				<sf:hidden path="dv" />
				<sf:hidden path="numObjeto" />
				<div class="col-md-3">
				<sf:button class="btn btn-primary btn-lg" type="submit" id="action" name="pagar" value="pagar" disabled="true">
					<spring:theme code="impuestos.decGasolina.Pago.Pagar" />
				</sf:button>
				</div>
				</sf:form>
			</div>
		</div>

</div>

<div id="dialogDU" title="Delineación Urbana">
	<div id="duDialogContent"></div>
</div>

<script>
function goBack4() {
  window.history.back();
}
</script>