<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="retenedor.servicio.representantes.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>


	<form:form action="">
		<div class="row" style="margin-top: 9px;">
			<div class="col-md-12">

				<div class="table-responsive">
					<table class="table col-md-2 table-bordered">
						<thead style="background-color: rgb(235, 235, 228) !important">
							<tr>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.representantes.tipiden" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.representantes.numiden" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.representantes.nombre" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.representantes.tiprela" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.representantes.fecdesde" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.representantes.fechasta" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.representantes.fuentedato" /></label></td>


							</tr>
						</thead>
						<tbody>
							<tr>
								<td><div class="form-group">
										<select class="form-control form-control" disabled></select>
									</div></td>
								<td><div class="form-group">
										<input class="form-control" disabled="disabled" type="text"
											size="30" />
									</div></td>
								<td><div class="form-group">
										<input class="form-control" disabled="disabled" type="text"
											size="30" />
									</div></td>
								<td><div class="form-group">
										<select class="form-control form-control" disabled></select>
									</div></td>
								<td><div class="form-group">
										<input class="form-control" disabled="disabled" type="text"
											size="30" />
									</div></td>
								<td><div class="form-group">
										<input class="form-control" disabled="disabled" type="text"
											size="30" />
									</div></td>
								<td><div class="form-group">
										<select class="form-control form-control" disabled></select>
									</div></td>

							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<div class="row" style="marging-top: 5px">
			<div class="col-md-12 centercol-md-8 text-center">
				<button style="margin-top: 3px;" id="regresar"
					class="btn btn-primary btn-lg" onclick="goBack()" type="button">
					<spring:theme code="retenedor.servicio.representantes.regresar" />
				</button>
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="retenedor.servicio.representantes.gendecla" />
				</button>
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="retenedor.servicio.representantes.paglinea" />
				</button>
			</div>
		</div>
	</form:form>
</div>
