<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme
					code="delineacion.urbana.dec.liqpriv.title" /></span>
		</h3>
	</div>
</div>

<form:form>
	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.liqpriv.totobrcons" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.liqpriv.valorcons" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.liqpriv.valorret" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.liqpriv.pag" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.liqpriv.totpag" /></label>
		</div>
		<div class="col-md-2">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="container">
		<button action="" type="submit" class="boton" id="" name=""
			value="calcular">
			<spring:theme code="delineacion.urbana.dec.liqpriv.calc" />
		</button>
	</div>

</form:form>

