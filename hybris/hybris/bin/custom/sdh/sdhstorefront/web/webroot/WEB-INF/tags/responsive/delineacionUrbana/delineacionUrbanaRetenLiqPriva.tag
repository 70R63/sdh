<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />



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
						code="delineacion.urbana.dec.liqpriv.totprep" /></label> <input id="totalpresu"
					name="infObjetoDelineacion.infoDeclara.totalPresupuesto" class="form-control" aria-required="true" type="text" value="${dataForm.infObjetoDelineacion.infoDeclara.totalPresupuesto}" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.valrete" /></label> 
<!-- 					<input id="totalRetencion" -->
<!-- 					name="totalRetencion" class="form-control" aria-required="true" type="text" -->
<%-- 					value="${dataForm.infObjetoDelineacion.infoDeclara.totalRetencion}" maxlength="240" disabled> --%>
					<sf:hidden path="input.totalRetencionOBLIGATORIO" id="totalRetencionOBLIGATORIO"/>
					<c:if test="${empty totalRetencionOBLIGATORIO}">
						<sf:input id="totalRetencion" class="form-control" readonly="true"
						aria-required="true" maxlength="240"
						path="infObjetoDelineacion.infoDeclara.totalRetencion" readOnly="true"/>						
					</c:if>
					<c:if test="${not empty totalRetencionOBLIGATORIO}">
						<sf:input id="totalRetencion" class="form-control" readonly="true"
						aria-required="true" maxlength="240"
						path="infObjetoDelineacion.infoDeclara.totalRetencion" 
						name="infObjetoDelineacion.infoDeclara.totalRetencion" readOnly="false"/>						
					</c:if>
			</div>
		</div>
	</div>
	

	<div class="row">
		<div class="col-md-4">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.totpag" /></label> <input id=""
					name="" class="form-control" aria-required="true" type="text"
					readonly="readonly" value="${dataForm.infObjetoDelineacion.infoDeclara.valorPagar}" maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
				<sf:button class="btn btn-primary btn-lg" name="action"
					id="calcular" value="calcular" disabled="false" onclick="presdecla()">
					<spring:theme code="delineacion.urbana.dec.liqpriv.calc" />
				</sf:button>
		</div>
	</div>
</div>

