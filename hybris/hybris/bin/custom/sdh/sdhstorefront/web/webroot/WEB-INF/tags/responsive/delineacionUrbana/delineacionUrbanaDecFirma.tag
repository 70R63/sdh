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
					code="delineacion.urbana.dec.firm.title" /></span>
		</h3>
	</div>
</div>

<form:form>
	<div class="row">
		<div class="col-md-3">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.firm.tipiden" /></label>
		</div>

		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.firm.numide" /></label>
		</div>
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="delineacion.urbana.dec.firm.nombraz" /></label>
		</div>

	</div>

	<br>
	<div class="row">
		<div class="col-md-3">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" readonly="readonly" value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">
				<input id="" name="" class="inputtextnew" aria-required="true"
					type="text" value="" maxlength="240">
			</div>
		</div>
		<button action="" type="submit" class="boton" id="" name=""
			value="calcular">
			<spring:theme code="delineacion.urbana.dec.firm.firma" />
		</button>
	</div>
	<div class="container">
		<div class="row">
			<div class="accountActions">
				<button action="" type="submit" class="boton" id="" name=""
					value="calcular">
					<spring:theme code="delineacion.urbana.dec.firm.predec" />
				</button>
			</div>
		</div>
		<div class="row">
			<div class="accountActions">
				<button action="" type="submit" class="boton" id="" name=""
					value="calcular">
					<spring:theme code="delineacion.urbana.dec.firm.paglin" />
				</button>
			</div>
		</div>
		<div class="row">
			<div class="accountActions">
				<button action="" type="submit" class="boton" id="" name=""
					value="calcular">
					<spring:theme code="delineacion.urbana.dec.firm.genrop" />
				</button>
			</div>
		</div>
	</div>

</form:form>

