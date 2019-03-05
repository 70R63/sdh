<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<!-- dev-federico INI cambio de control para visualizar la lista-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- dev-federico FIN cambio de control para visualizar la lista-->

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6 headline">
		<h3>
			<span class="col-md-10"><spring:theme
					code="declaracion.publicidad.infovalla" /></span>
		</h3>
	</div>
</div>


<div class="row">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="declaracion.publicidad.luginst" /></label>
			<c:choose>
				<c:when test="${declaPublicidadForm.tipoValla eq '01' || declaPublicidadForm.tipoValla eq '03' || declaPublicidadForm.tipoValla eq '04' ||declaPublicidadForm.tipoValla eq '05'}">
					<input id="luginst" name="luginst" class="form-control"
						aria-required="true" type="text" value="Predio" maxlength="30"
						disabled="disabled">
				</c:when>
				<c:when test="${declaPublicidadForm.tipoValla eq '02'}">
					<input id="luginst" name="luginst" class="form-control"
						aria-required="true" type="text" value="Vehículo" maxlength="30"
						disabled="disabled">
				</c:when>
				<c:otherwise>
					<input id="luginst" name="luginst" class="form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="declaracion.publicidad.OrValla" /></label>

			<c:choose>
				<c:when test="${declaPublicidadForm.orValla eq '1'}">
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="Oriente-Occidente"
						maxlength="30" disabled="disabled">
				</c:when>
				<c:when test="${declaPublicidadForm.orValla eq '2'}">
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="Occidente-Oriente"
						maxlength="30" disabled="disabled">
				</c:when>
				<c:when test="${declaPublicidadForm.orValla eq '3'}">
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="Norte-Sur" maxlength="30"
						disabled="disabled">
				</c:when>
				<c:when test="${declaPublicidadForm.orValla eq '4'}">
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="Sur-Norte" maxlength="30"
						disabled="disabled">
				</c:when>
				<c:when test="${declaPublicidadForm.orValla eq '5'}">
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="Derecha" maxlength="30"
						disabled="disabled">
				</c:when>
				<c:when test="${declaPublicidadForm.orValla eq '6'}">
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="Izquierda" maxlength="30"
						disabled="disabled">
				</c:when>
				<c:when test="${declaPublicidadForm.orValla eq '7'}">
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="Ambos sentidos"
						maxlength="30" disabled="disabled">
				</c:when>
				<c:otherwise>
					<input id="orValla" name="orValla" class="form-control"
						aria-required="true" type="text" value="" maxlength="30"
						disabled="disabled">
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</div>


<div class="row">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="declaracion.publicidad.tamvalla" /></label>

			<c:choose>
				<c:when test="${declaPublicidadForm.tipoValla eq '01' || declaPublicidadForm.tipoValla eq '03'|| declaPublicidadForm.tipoValla eq '04' || declaPublicidadForm.tipoValla eq '05'}">
					<select id="tamValla" class="form-control">
						<c:set var="selected" value="" />
						<c:if test="${declaPublicidadForm.basegrav eq '01' }">
							<c:set var="selected" value="selected" />
						</c:if>
						<option ${selected } value="01">Vallas de más de 8 m2
							hasta 24 m2</option>
						<c:set var="selected" value="" />
						<c:if test="${declaPublicidadForm.basegrav eq '02' }">
							<c:set var="selected" value="selected" />
						</c:if>
						<option ${selected } value="02">Vallas de más de 24 m2</option>
						<c:set var="selected" value="" />
						<c:if test="${declaPublicidadForm.basegrav eq '03' }">
							<c:set var="selected" value="selected" />
						</c:if>
						<option ${selected } value="03">Vallas de propiedad de
							constructores de más de 8 m2</option>
					</select>
				</c:when>
				<c:when test="${declaPublicidadForm.tipoValla eq '02'}">
					<option value="04">Vallas en vehículos automotores con
						dimensión superior a 8 m2</option>
				</c:when>
				<c:otherwise>
					<select id="tamValla" class="form-control">
						<option value=" ">Seleccionar</option>
					</select>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</div>


<br>
<br>


<input type="hidden" value="${declaPublicidadForm.opuso }" id="opuso" />
<input type="hidden" value="${declaPublicidadForm.direccion }"
	id="direccion" />
<input type="hidden" value="${declaPublicidadForm.placa }" id="placa" />
<input type="hidden" value="${declaPublicidadForm.municipioContrib }"
	id="municipioContrib" />
<input type="hidden" value="${declaPublicidadForm.tipoIDdeclara }"
	id="tipoIDdeclara" />
<input type="hidden" value="${declaPublicidadForm.idDeclarante }"
	id="idDeclarante" />







