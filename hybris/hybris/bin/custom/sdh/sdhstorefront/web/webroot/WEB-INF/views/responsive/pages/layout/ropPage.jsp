
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />





<div class="container_new_page">
	<form:form id="form_pdf" action="/sdhstorefront/es/contribuyentes/rop"
		method="post" commandName="ropForm">
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label">
						<spring:theme code="rop.generar.valobli" />
					</label>
					<input class="form-control new_alto" disabled="disabled"
						type="text" size="30" value=""/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="rop.generar.totalpagar" /></label> <form:input
						class="form-control new_alto" disabled="true" type="text"
						size="30" value="" path="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="rop.generar.parcial" /></label> <form:input
						class="form-control new_alto" type="text" size="30" value="" path="importeusuario"  />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<button style="margin-top: 26px; margin-bottom: 15px;" id=""
					class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="rop.generar.regresar" />
				</button>


			</div>
			<div class="col-md-2">
				<button style="margin-top: 26px; margin-bottom: 15px;" id=""
					class="btn btn-primary btn-lg" onclick="" type="submit">
					<spring:theme code="rop.generar.genrop" />
				</button>
			</div>
			
			<div class="col-md-2">
			<button style="margin-top: 26px; margin-bottom: 15px;" id=""
				class="btn btn-primary btn-lg"  onclick="window.location.href ='<c:url value='/impuestos/pagoEnLinea/form'/>';" type="button">
				<spring:theme code="rop.generar.pagolinea" />
			</button>
		</div>
		</div>

	</form:form>
</div>
<script>
	function goBack() {
		window.history.back();
	}
</script>

