<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme
						code="delineacion.urbana.dec.generales.title" /></span>
			</h2>
		</div>
	</div>

	<form:form>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.codigo" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="" maxlength="240">
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.anigrav" /></label> <select
						id="an" class="form-control " name=" " onchange=" " disabled>
						<option value="2019">2019</option>
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.radic" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="" maxlength="240">
				</div>
			</div>


			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.opuso" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="" maxlength="240">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.tiplicencia" /></label> <select
						id="an" class="form-control " name=" " onchange=" " disabled>
						<option value="1">Licencia</option>
						<option value="2">Reconocimiento</option>
					</select>
				</div>
			</div>

			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.modlicencia" /></label> <select
						id="an" class="form-control " name=" " onchange="obranueva(this)">

						<option value="">Seleccionar</option>
						<option value="1">Adecuaci�n</option>
						<option value="2">Ampliaci�n</option>
						<option value="3">Cerramiento</option>
						<option value="4">Demolici�n</option>
						<option value="5">Modificaci�n</option>
						<option value="6">Obra nueva</option>
						<option value="7">Reforma estructural</option>
						<option value="8">Restauraci�n</option>
					</select>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.areasusos.preobra" /></label> <select
						class="form-control" onchange="costoshabil(this)">
						<option value="">Seleccionar</option>
						<option value="1">Calcular con base en la Resoluci�n de
							la Secretar�a Distrital de Planeaci�n</option>
						<option value="2">Incorporar el valor de su presupuesto
							estimado</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.areasusos.cauexen" /></label> <select
						class="form-control">
						<option value="0">Seleccionar</option>
						<option value="1">Obras Nuevas Vis Estratos 1, 2 Y 3</option>
						<option value="2">Obras De Autocontrucci�n De Vivienda,
							De Estratos 1 Y 2, Que No Excedan Los Topes Definidos Por La Ley
							Para El Valor De La Vivienda De Inter�s Social</option>
						<option value="3">Ampliaciones, Modificaciones,
							Adecuaciones O Reparaciones Inmuebles Residenciales Estrato 1, 2
							Y 3. Aval�o Catastral Inferior A 135 Smimv</option>
						<option value="4">Obras Que Se Realicen Para Reparar
							Inmuebles Afectados Por Actos Terroristas O Cat�strofes Naturales</option>
						<option value="5">Obras De Restauraci�n Y Conservaci�n En
							Bien Inmueble De Inter�s Cultural</option>
					</select>
				</div>
			</div>

		</div>

	</form:form>
</div>

