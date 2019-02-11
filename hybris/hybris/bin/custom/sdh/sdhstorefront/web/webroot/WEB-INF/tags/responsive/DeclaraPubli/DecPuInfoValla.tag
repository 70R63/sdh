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
			<span class="cintillo col-md-10"><spring:theme
					code="declaracion.publicidad.infovalla" /></span>
		</h3>
	</div>
</div>
 <br display:block; 
    margin: 5px 0;> 
<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.luginst" /></label>
	</div>
	<div class="col-md-3">
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
	</div>
</div>
<br display:block;
   margin: 5px 0;>
<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.OrValla" /></label>
	</div>
	<div class="col-md-3">
<!-- dev-federico INI cambio de control para visualizar la lista-->
								<form:select path="orValla"
 							items="${declaPublicidadForm.catalogos.orientacionValla}"
 							referenceData="${declaPublicidadForm.catalogos.orientacionValla}"
 							class="inputdropdown" id="orValla"/> -
<!-- 		<select id="OrValla" class="inputdropdown"> -->
<!-- 			<option value=" ">Seleccionar</option> -->

<!-- 		</select> -->
<!-- dev-federico FIN -->
	</div>
</div>
 <br display:block; 
    margin: 5px 0;> 

<div class="row">
	<div class="col-md-3">
		<label class="inputlabelnew"><spring:theme
				code="declaracion.publicidad.tamvalla" /></label>
	</div>
	<div class="col-md-3">
<!-- dev-federico INI cambio de control para visualizar la lista-->
									<form:select path="basegrav"
							items="${declaPublicidadForm.catalogos.basegrav}"
							referenceData="${declaPublicidadForm.catalogos.basegrav}"
							class="inputdropdown" id="basegrav" />
	
	
<!-- 		<select id="basegrav" class="inputdropdown"> -->
<!-- 		<option value=" ">Seleccionar</option> -->

<!-- 		</select> -->
<!-- dev-federico FIN cambio de control para visualizar la lista-->
	</div>
</div>


<br>
<br>









