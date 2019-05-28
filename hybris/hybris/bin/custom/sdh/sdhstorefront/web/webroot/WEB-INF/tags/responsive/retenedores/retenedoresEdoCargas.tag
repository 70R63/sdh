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
								code="reteica.consulta.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="reteica.consulta.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<div class="row">
		<div class="headline">
			<h2>
				<span class="col-md-10 "><spring:theme
						code="reteica.consulta.estado.titulo" /></span>
			</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="reteica.consulta.estado.descripcion1" /></label>
			</div>
		</div>

		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="reteica.consulta.estado.descipcion2" /></label>
			</div>
		</div>
	</div>
	<c:url value="/retenedores/estadocargas" var="edoCargasAction" />
	<form:form commandName="form" action="${edoCargasAction}"
		id="edoCargasForm" name="edoCargasForm">
		<div class="row">
			<div class="col-md-12 col-md-offset-3">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="reteica.consulta.estado.anio" /></label> <select id="anoGravable"
						name="anoGravable" class="form-control"
						style="width: 200px !important">
						<option>Seleccionar</option>
						<c:forEach items="${ years}" var="eachYear">
							<c:set var="selected" value="" />
							<c:if test="${ eachYear eq form.anoGravable}">
								<c:set var="selected" value="selected" />
							</c:if>
							<option value="${ eachYear}" ${selected }>${eachYear }</option>
						</c:forEach>
					</select>
				</div>
			</div>

		</div>
	</form:form>
	<div class="row">
		<div class="col-md-12 tableamplia">
			<div class="table-responsive">
				<table class="table table-bordered" id="example">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tablefechas"><spring:theme
										code="reteica.consulta.estado.fechcarga" /></label></td>
							<td><label class="control-label labeltabletd tablenombre"><spring:theme
										code="reteica.consulta.estado.nomdoc" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="reteica.consulta.estado.perrepor" /></label></td>
							<td><label class="control-label labeltabletd tabledomatri"><spring:theme
										code="reteica.consulta.estado.estado" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme
										code="reteica.consulta.estado.detalle" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme
										code="reteica.consulta.estado.deseacargar" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme
										code="" /></label></td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty archivosTRM }">
								<tr>
									<td><input class="inputtextnew tablefechas"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablenombre"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledomatri"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew" disabled="disabled"
										value="" type="text" /></td>
									<td></td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${archivosTRM }" var="eachArchivo">
									<tr>
										<td><input class="inputtextnew tablefechas"
											disabled="disabled" value="${eachArchivo.fechaCarga }"
											type="text" /></td>
										<td><input class="inputtextnew tablenombre"
											disabled="disabled" value="${eachArchivo.nomArchivo }"
											type="text" /></td>
										<td><input class="inputtextnew " disabled="disabled"
											value="${eachArchivo.perRepor }" type="text" /></td>
										<td><input class="inputtextnew tabledomatri"
											disabled="disabled" value="${eachArchivo.estado }"
											type="text" /></td>
										<td><input class="inputtextnew" disabled="disabled"
											value="<a href="#">Ver log</a>" type="text" /></td>
										<td><input class="inputtextnew" disabled="disabled"
											value="${eachArchivo.numForm }" type="text" /></td>
										<c:choose>
											<c:when
												test='${(eachArchivo.estado == "02")}'>
												<td><a href="#">Presentar Declaración</a></td>
											</c:when>
											<c:otherwise>
												<td></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-10">
			<div class="form-group">
				<button class="btn btn-secondary text-center" id="" name=""
					value="regresar" type="button" onclick="goBack()">
					<spring:theme code="reteica.consulta.estado.regresar" />
				</button>
			</div>
		</div>
	</div>

</div>

<script>
	function goBack() {
		window.history.back();

	}
</script>
