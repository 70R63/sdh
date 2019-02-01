<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="declaracion.publicidad.totpagar" /></span>
		</h3>
	</div>
</div>

<sf:form action="${pageContext.request.contextPath}/contribuyentes/publicidadexterior/declaracion" method="post" commandName="declaPublicidadForm">
<br display:block;
   margin: 5px 0;>
<div class="row">
	<div class="col-md-2">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.impcargo" /></label>
	</div>
	<div class="col-md-3">
		<input id="impCar" name="impCar" class="inputtextnew"
			aria-required="true" type="" value="${declaPublicidadForm.impCar}" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.valsan" /></label>
	</div>
	<div class="col-md-3">
		<input id="valsan" name="valsan" class="inputtextnew"
			aria-required="true" type="" value="${declaPublicidadForm.valsan}" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>

<div class="row">
	<div class="col-md-2">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.valpaga" /></label>
	</div>
	<div class="col-md-3">
		<input id="valpag" name="valpag" class="inputtextnew"
			aria-required="true" type="" value="${declaPublicidadForm.valsan}" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>
<div class="row">
	<div class="col-md-2">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.intermora" /></label>
	</div>
	<div class="col-md-3">
		<input id="intmora" name="intmora" class="inputtextnew"
			aria-required="true" type="" value="${declaPublicidadForm.intmora}" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>
<div class="row">
	<div class="col-md-2">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.totalapagar" /></label>
	</div>
	<div class="col-md-3">
		<input id="totpag" name="totpag" class="inputtextnew"
			aria-required="true" type="" value="${declaPublicidadForm.totpag}" maxlength="30" size="30"
			disabled="disabled">
	</div>
</div>

<div class="row">
	<div class="col-md-3 col-md-offset-3 center">
	
	<!-- sf:form action="${presentarDeclaracionUrl}" id="presentarDeclaracionUrl1"  method="POST">
			<button id="/contribuyentes/publicidadexterior/declaracion" type="submit"
				class="botton">
				<spring:theme code="declaracion.publicidad.button.calcular" />
				</button>
			</sf:form-->
			
			<sf:button id="/contribuyentes/publicidadexterior/declaracion"  action = "/contribuyentes/publicidadexterior/declaracion" type="submit"
				class="botton">
				<spring:theme code="declaracion.publicidad.button.calcular" />
				</sf:button>
				</div>
</div>
</sf:form>