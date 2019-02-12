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
	<div class="col-md-6">
		<h3>
			<span class="cintillo col-md-10"><spring:theme code="declaracion.publicidad.infovalla" /></span>
		</h3>
	</div>
</div>
 <br display:block; 
    margin: 5px 0;> 
<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.luginst" /></label>
	</div>
	<div class="col-md-3">
<<<<<<< Updated upstream
<c:choose>
	<c:when test="${declaPublicidadForm.luginst eq '01'}">
		<input id="luginst" name="luginst" class="inputtextnew" aria-required="true" type="text" value="Predio" maxlength="30" disabled="disabled">
	</c:when>
	<c:when test="${declaPublicidadForm.luginst eq '02'}">
		<input id="luginst" name="luginst" class="inputtextnew" aria-required="true" type="text" value="Vehículo" maxlength="30" disabled="disabled">
	</c:when>
	<c:otherwise>
		<input id="luginst" name="luginst" class="inputtextnew" aria-required="true" type="text" value="" maxlength="30" disabled="disabled">
	</c:otherwise>
</c:choose>
		
=======
<!-- dev-federico INI cambio de control para visualizar la lista-->
								<form:select path="luginst"
							items="${declaPublicidadForm.catalogos.luginst}"
							referenceData="${declaPublicidadForm.catalogos.luginst}"
							class="inputdropdown" id="luginst" onchange="ShowSelected(luginst)"/>
<!-- 		<select id="luginst" class="inputdropdown" -->
<!-- 			onchange="ShowSelected(this);"> -->
<!-- 			<option value="">Seleccionar</option> -->
<!-- 			<option value="0">Predio</option> -->
<!-- 			<option value="1">Veh&iacuteculo</option> -->
<!-- 		</select> -->
<!-- dev-federico FIN cambio de control para visualizar la lista-->
>>>>>>> Stashed changes
	</div>
</div>
<br display:block;
   margin: 5px 0;>
<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.OrValla" /></label>
	</div>
	<div class="col-md-3">
<<<<<<< Updated upstream
<c:choose>
	<c:when test="${declaPublicidadForm.orValla eq '01'}">
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="Oriente-Occidente" maxlength="30" disabled="disabled">
	</c:when>
	<c:when test="${declaPublicidadForm.orValla eq '02'}">
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="Occidente-Oriente" maxlength="30" disabled="disabled">
	</c:when>
	<c:when test="${declaPublicidadForm.orValla eq '03'}">
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="Norte-Sur" maxlength="30" disabled="disabled">
	</c:when>
	<c:when test="${declaPublicidadForm.orValla eq '04'}">
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="Sur-Norte" maxlength="30" disabled="disabled">
	</c:when>
	<c:when test="${declaPublicidadForm.orValla eq '05'}">
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="Derecha" maxlength="30" disabled="disabled">
	</c:when>
	<c:when test="${declaPublicidadForm.orValla eq '06'}">
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="Izquierda" maxlength="30" disabled="disabled">
	</c:when>
	<c:when test="${declaPublicidadForm.orValla eq '07'}">
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="Ambos sentidos" maxlength="30" disabled="disabled">
	</c:when>
	<c:otherwise>
		<input id="orValla" name="orValla" class="inputtextnew" aria-required="true" type="text" value="" maxlength="30" disabled="disabled">
	</c:otherwise>
</c:choose>

=======
<!-- dev-federico INI cambio de control para visualizar la lista-->
								<form:select path="orValla"
 							items="${declaPublicidadForm.catalogos.orientacionValla}"
 							referenceData="${declaPublicidadForm.catalogos.orientacionValla}"
 							class="inputdropdown" id="orValla"/> -
<!-- 		<select id="OrValla" class="inputdropdown"> -->
<!-- 			<option value=" ">Seleccionar</option> -->

<!-- 		</select> -->
<!-- dev-federico FIN -->
>>>>>>> Stashed changes
	</div>
</div>
 <br display:block; 
    margin: 5px 0;> 

<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme code="declaracion.publicidad.tamvalla" /></label>
	</div>
	<div class="col-md-3">
<<<<<<< Updated upstream

<c:choose>
	<c:when test="${declaPublicidadForm.luginst eq '01'}">
		<select id="tamValla" class="inputdropdown">
			<c:set var="selected" value="" />
			<c:if test="${declaPublicidadForm.basegrav eq '01' }">
				<c:set var="selected" value="selected" />
			</c:if>
			<option ${selected } value="01">Vallas de más de 8 m2 hasta 24 m2</option>
			<c:set var="selected" value="" />
			<c:if test="${declaPublicidadForm.basegrav eq '02' }">
				<c:set var="selected" value="selected" />
			</c:if>
			<option ${selected } value="02">Vallas de más de 24 m2</option>
				<c:set var="selected" value="" />
			<c:if test="${declaPublicidadForm.basegrav eq '03' }">
				<c:set var="selected" value="selected" />
			</c:if>
			<option ${selected } value="03">Vallas de propiedad de constructores de más de 8 m2</option>
		</select>
	</c:when>
	<c:when test="${declaPublicidadForm.luginst eq '02'}">
		<option value="04">Vallas en vehículos automotores con dimensión superior a 8 m2</option>
	</c:when>
	<c:otherwise>
		<select id="tamValla" class="inputdropdown">
		<option value=" ">Seleccionar</option>
		</select>
	</c:otherwise>
</c:choose>


=======
<!-- dev-federico INI cambio de control para visualizar la lista-->
									<form:select path="basegrav"
							items="${declaPublicidadForm.catalogos.basegrav}"
							referenceData="${declaPublicidadForm.catalogos.basegrav}"
							class="inputdropdown" id="basegrav" />
	
	
<!-- 		<select id="basegrav" class="inputdropdown"> -->
<!-- 		<option value=" ">Seleccionar</option> -->

<!-- 		</select> -->
<!-- dev-federico FIN cambio de control para visualizar la lista-->
>>>>>>> Stashed changes
	</div>
</div>


<br>
<br>


<input type="hidden" value="${declaPublicidadForm.opuso }" id="opuso"/>
<input type="hidden" value="${declaPublicidadForm.direccion }" id="direccion"/>
<input type="hidden" value="${declaPublicidadForm.placa }" id="placa"/>
<input type="hidden" value="${declaPublicidadForm.municipioContrib }" id="municipioContrib"/>
<input type="hidden" value="${declaPublicidadForm.tipoIDdeclara }" id="tipoIDdeclara"/>
<input type="hidden" value="${declaPublicidadForm.idDeclarante }" id="idDeclarante"/>







