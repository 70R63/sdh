<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6 headline">
		<h2>
			<span><spring:theme
					code="delineacion.urbana.dec.liqpriv.title" /></span>
		</h2>
	</div>
</div>

<form:form>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.costdire" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>

	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.costindi" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.mtcons" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">

				<label class="control-label" style="padding-top: 40px;"><spring:theme
						code="delineacion.urbana.dec.liqpriv.m2" /></label>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.mtventa" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group ">

				<label class="control-label" style="padding-top: 40px;"><spring:theme
						code="delineacion.urbana.dec.liqpriv.m2" /></label>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.valcomcons" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.valaproxmet" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.totprep" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.valrete" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					value="" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.pago" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.totpag" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="" maxlength="240">
			</div>
		</div>
	</div>

	<div class="container">
		<button type="submit" class="btn btn-primary btn-lg" id="" name=""
			value="calcular">
			<spring:theme code="delineacion.urbana.dec.liqpriv.calc" />
		</button>
	</div>

</form:form>

