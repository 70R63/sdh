<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>




<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="autorizado.reportar.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme
								code="autorizado.reportar.inicial.descripcion" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="headline text-center">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="autorizado.reportar.reportar.titulo" /></span>
				</h2>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<p>
				<spring:theme code="autorizado.reportar.reportar.nota" />
			</p>

		</div>
	</div>
	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />

	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="autorizado.reportar.info.titulo" /></span>
				</h2>
			</div>
		</div>

	</div>

	<form:form modelAttribute="importConciliacionForm" enctype="multipart/form-data" action="/bogota/es/gestionBancaria/uploadFile" method="POST" onsubmit="return fncEnviarReporInfo(this);">
		<div class="row" style="margin-top: 6px;">
			<div class="col-md-4">
				<div class="form-group">
					<label class="control-label required" style="text-transform: none">
					        <spring:theme code="autorizado.reportar.info.tiparch" />
					</label>
					<select class="new_alto form-control" id="tipoArchivo" name="tipoArchivo">
						<option value="Seleccionar">Seleccionar</option>
						<c:forEach items="${tipoDeArchivo}" var="tipoArchivo">
                          <option value="${tipoArchivo.code}"><c:out value="${tipoArchivo.name}"/></option>
                        </c:forEach>
					</select>
                    <input id="entidadBancaria" name="entidadBancaria" type="hidden" value="${entidadBancaria}">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label required" style="text-transform: capitalize">
					    <spring:theme code="autorizado.reportar.info.selarch" />
					 </label>
					 <input type="file" id="conciliacionFile" name="conciliacionFile" >
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 6px;">
			<div class="col-md-12 centercol-md-6">

				<button style="margin-top: 3px;" id="regresar"
					class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="autorizado.reportar.info.regresar" />
				</button>
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="autorizado.reportar.info.cancelar" />
				</button>
				<button style="margin-top: 3px;" id="btnEnviarReporInfo"
					class="btn btn-primary btn-lg " type="submit" >
					<spring:theme code="autorizado.reportar.info.enviar" />
				</button>
			</div>
		</div>

	</form:form>
</div>




