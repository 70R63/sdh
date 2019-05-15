<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="publicidadExterior"
	tagdir="/WEB-INF/tags/responsive/publicidadExterior"%>

<div class="container">
	<spring:htmlEscape defaultHtmlEscape="true" />
	<div id="divPublicidadExteriorDetail" style="display: none;">
		<div class="row">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="publicidad.exterior.detail.basicdata" /></span>
				</h2>
			</div>
		</div>


		<div class="row">
			<div class="col-md-4 ">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.detail.dateresolution" /></label> <input
						id="fechResolu" name="fechResolu" class="form-control" disabled
						type="text" value="" maxlength="240"></input>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.detail.type" /></label> <input
						id="tipoSolicitud" name="tipoSolicitud" class="form-control"
						disabled type="text" value="" maxlength="240"></input>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="publicidad.exterior.detail.Datenotification" /></label> <input
						id="fechNotif" name="fechNotif" class="form-control" disabled
						type="text" value="" maxlength="240">
				</div>
			</div>
		</div>
	</div>
</div>


