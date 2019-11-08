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
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.totobrcons" /></label>
				<sf:input class="newalto form-control" readonly="true" aria-required="true"
					maxlength="240"
					path="infObjetoDelineacion.infoDeclara.totalPresupuesto" />
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.valorExencion" /></label>

				<%-- 				<c:choose> --%>
				<%-- 					<c:when --%>
				<%-- 						test='${(not empty tipoMarca) && (dataForm.infObjetoDelineacion.infoDeclara.tipoLicencia == "02")}'> --%>
				<sf:input id="valorExen" name="" class="newalto form-control"
					aria-required="true" type="text" readonly="false"
					path="infObjetoDelineacion.infoDeclara.valorExen" maxlength="240" onkeyup="numberFormat(this)" onclick="numberFormat(this)" disabled="true" />
				<%-- 					</c:when> --%>
				<%-- 					<c:otherwise> --%>
				<%-- 						<sf:input id="valorExen" name="" class="form-control" --%>
				<%-- 							aria-required="true" type="text" readonly="true" --%>
				<%-- 							path="infObjetoDelineacion.infoDeclara.valorExen" maxlength="240" /> --%>
				<%-- 					</c:otherwise> --%>
				<%-- 				</c:choose> --%>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.valorcons" /></label>
				<sf:input class="newalto form-control" readonly="false" aria-required="true"
					maxlength="240"
					path="infObjetoDelineacion.infoDeclara.valorEjecutado" onkeyup="numberFormat(this)" onclick="numberFormat(this)" />
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.impcargo" /></label> <input id=""
					name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.impuestoCargo}"
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.totvalorsanciones" /></label> <input
					id="" name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.valorSancion}"
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.totreten" /></label> <input id=""
					name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.totalRetencion}"
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.salimpcar" /></label> <input id=""
					name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.saldoImpCargo}"
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.salpag" /></label> <input id=""
					name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.saldoFavor}"
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.valpag" /></label> <input id=""
					name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.valorPagar}"
					maxlength="240">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.intermora" /></label> <input id=""
					name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.interesMora}"
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.liqpriv.totpag" /></label> <input id=""
					name="" class="newalto form-control" aria-required="true" type="text"
					readonly="readonly"
					value="${dataForm.infObjetoDelineacion.infoDeclara.totalPagar}"
					maxlength="240">
			</div>
		</div>
	</div>

	<div class="container">
		<sf:button class="btn btn-primary btn-lg" name="action" id="calcular"
			value="calcular" disabled="false" onclick="presdec()">
			<spring:theme code="delineacion.urbana.dec.liqpriv.calc" />
		</sf:button>
	</div>

</div>

