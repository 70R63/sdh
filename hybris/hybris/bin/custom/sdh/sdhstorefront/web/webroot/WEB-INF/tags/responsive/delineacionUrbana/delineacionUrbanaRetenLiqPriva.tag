<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/contribuyentes/delineacion-urbana" var="duURL"
	htmlEscape="false" />


<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme
						code="delineacion.urbana.dec.liqpriv.title" /></span>
			</h2>
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
					value="" maxlength="240" disabled>
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
	<div class="row">
		<div class="col-md-4">
			<sf:form action="${duURL}" method="POST" modelAttribute="dataForm"
				id="forma">
				<sf:button class="btn btn-primary btn-lg" name="action"
					id="retenciondelibutton1" value="retencion" disabled="false">
					<spring:theme code="delineacion.urbana.dec.liqpriv.calc" />
				</sf:button>
			</sf:form>
		</div>
	</div>
</div>

