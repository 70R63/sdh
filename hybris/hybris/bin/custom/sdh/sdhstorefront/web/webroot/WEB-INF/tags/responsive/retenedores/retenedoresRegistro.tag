<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="reteica.declaracion.table.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme
								code="reteica.declaracion.table.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<form:form action="">
		<div class="row mt-3">
			<div class="col-md-7 col-md-offset-3 d-flex align-items-center">
				<div class="table-responsive">
					<table class="table col-md-2 table-bordered">
						<thead>
							<tr>
								<td><label class="control-label labeltabletd tableident"><spring:theme
											code="reteica.declaracion.table.tipodoc" /></label></td>
								<td><label class="control-label labeltabletd tablenumiden"><spring:theme
											code="reteica.declaracion.table.numdoc" /></label></td>
								<td><label class="control-label labeltabletd tablenombre" style="width: 18%"><spring:theme
											code="reteica.declaracion.table.nombre" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew tableident"
									disabled="disabled" type="text" size="30" value="${ docType}" /></td>
								<td><input class="inputtextnew tablenumiden"
									disabled="disabled" type="text" size="30" value="${ docNumber}" /></td>
								<td><input class="inputtextnew tablenombre"
									disabled="disabled" type="text" size="30"
									value="${customerName }" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="container">

			<div class="row mt-3">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.inicial.carga.anio" /></label> <select id="anoGravable"
							name="anoGravable" class="form-control"
							style="width: 200px !important">
							<option value="">Seleccionar</option>
							<c:forEach items="${ years}" var="eachYear">
								<option value="${ eachYear}">${eachYear }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.inicial.carga.periodo" /></label> <select id="periodo"
							name="periodo" class="form-control"
							style="width: 200px !important">
							<option value="">Seleccionar</option>
							<c:forEach items="${ perdiods}" var="eachPeriod">
								<option value="${ eachPeriod}"><spring:theme
										code="reteica.registro.period.${eachPeriod}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="headline">
					<h2>
						<span class="col-md-10 "><spring:theme
								code="reteica.inicial.carga.titulo" /></span>
					</h2>
				</div>
			</div>

			<hr
				style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.inicial.carga.descarga" /></label>
					</div>
				</div>

				<div class="col-md-4 text-center">
					<div class="form-group">
						<button class="btn btn-primary text-center"
							id="downloadTemplateButton" name="downloadTemplateButton"
							value="descargar">
							<spring:theme code="reteica.inicial.carga.descargar" />
						</button>
						<a id="reteICADownloadHelper" target="_blank"></a>
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.inicial.carga.agrega" /></label>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.inicial.carga.guarda" /></label>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.inicial.carga.adjunta" /></label>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<label class="control-label"><spring:theme
								code="reteica.inicial.carga.seleccionar" /></label><input
							id="retencionesFile" name="retencionesFile" type="file"
							class="form-control" id="" accept=".txt">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-10 text-center">
					<div class="col-md-2">
						<div class="form-group">
							<button class="btn btn-secondary text-left" id="" name=""
								value="regresar" onclick="goBack()" type="button">
								<spring:theme code="reteica.inicial.carga.regresar" />
							</button>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<button class="btn btn-primary text-left" id="bindCargarButton"
								name="bindCargarButton" type="button" value="cargar">
								<spring:theme code="reteica.inicial.carga.cargar" />
							</button>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<button class="btn btn-primary text-left" type="button" id=""
								name="" value="consulta"
								onclick="window.location.href ='<c:url value='/retenedores/estadocargas' />';">
								<spring:theme code="reteica.inicial.carga.consultar" />
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>

<script>
	function goBack() {
			window.history.back();
		
	}
</script>

