<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<spring:htmlEscape defaultHtmlEscape="true" />
<!-- Agregar el valor del acto que venga del form para determinar si se muestran los campos de acto o no -->
<c:set var="idacto" value="123"/>


<div class="container">
<div class="alert alert-success" role="alert">
 <span><spring:theme code="message.download" /> </span>
</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="sobre.vehiculo.declaracion.vehiculo.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">
						<td><spring:theme
								code="sobre.vehiculo.declaracion.vehiculo.descripcion1" /> <br>
							<spring:theme
								code="sobre.vehiculo.declaracion.vehiculo.descripcion2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.aniograv" /></label> <input
						id="aniograv" name="aniograv" class="newalto form-control"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.anioGravable}" maxlength="30"
						disabled="disabled">

				</div>
			</div>
			<div class="col-md-1">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.placa" /></label> <input
						id="placaDec" name="" class="newalto form-control placaDec"
						aria-required="true" type="text"
						value="${vehiculosFormDeclaracion.placa}" maxlength="30"
						disabled="disabled">
				</div>
			</div>
			<c:set var="opuso" value="${fn:trim(vehiculosFormDeclaracion.opcionUso)}"/>
			<c:if test="${fn:length(opuso) > 2}">
				<c:set var="opuso" value="${fn:substring(opuso, 0, 2)}"/>
			</c:if>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.opuso" /></label> <input id=""
						name="" class="newalto form-control"
						value='<spring:theme code="vehiculos.detalle.opuso.${opuso}"/>'
						aria-required="true" type="text" maxlength="30"
						disabled="disabled">

				</div>
			</div>
			<c:if test="${idacto != ''}">
			<div class="col-md-1">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.idacto" /></label> <input id=""
						name="" class="newalto form-control"
						value=""
						aria-required="false" type="text" maxlength="30"
						disabled="disabled">

				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.fechanotiacto" /></label> <input id=""
						name="" class="newalto form-control"
						value=""
						aria-required="false" type="text" maxlength="30"
						disabled="disabled">

				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.descriacto" /></label> <input id=""
						name="" class="newalto form-control"
						value=""
						aria-required="false" type="text" maxlength="30"
						disabled="disabled">

				</div>
			</div>
			<div class="col-md-2">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="sobre.vehiculo.declaracion.vehiculo.numeroexpediente" /></label> <input id=""
						name="" class="newalto form-control"
						value=""
						aria-required="false" type="text" maxlength="30"
						disabled="disabled">

				</div>
			</div>
			</c:if>
		</div>
	</form:form>
</div>

