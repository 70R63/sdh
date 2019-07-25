<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div id="divConvencional" style="display: none;">
		<div class="row">
			<div class="headline">
				<h3>
					<span class="cintillo col-md-10 "><spring:theme
							code="publicidad.exterior.conventional" /></span>
				</h3>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.typeitemreg" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.tipoElemento}" maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.buildingpermit" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.licenciaConstruc}" maxlength="240">
				</div>
			</div>

			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.locationaddress" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.direccion}" maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.totalarea" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.areaTotal}" maxlength="240">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.workcontract" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.contratoObra}" maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.visualorientation" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.orientacion}" maxlength="240">
				</div>
			</div>

			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.Trust" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text" value="${publicidadForm.fiducia}"
						maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.location" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.localidad}" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.urbanlicense" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.licenciaUrb}" maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.postalcode" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.codPostal}" maxlength="240">
				</div>
			</div>

			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.CHIP" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text" value="${publicidadForm.chip}"
						maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.elementlocation" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.ubicacion}" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.propertyregistration" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.vehicles.typeadvertising" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.tipoPublici}" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.numberfaces" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.numCaras}" maxlength="240">
				</div>
			</div>
			<div class="col-md-3">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.licensevalidity" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.vigLicenConstruc}" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 ">
				<label class="inputlabelnew avisos"><spring:theme
						code="publicidad.exterior.conventional.Periodicity" /></label>
			</div>
			<div class="col-md-2">
				<div class="form-group ">
					<input id="address.surname" name="lastName" class="inputtextnew"
						aria-required="true" type="text"
						value="${publicidadForm.periodicidad}" maxlength="240">
				</div>
			</div>

		</div>
	</div>
</div>










