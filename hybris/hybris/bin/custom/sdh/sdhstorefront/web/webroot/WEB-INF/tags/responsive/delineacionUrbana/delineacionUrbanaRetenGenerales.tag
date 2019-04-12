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
						<option value="1">Adecuación</option>
						<option value="2">Ampliación</option>
						<option value="3">Cerramiento</option>
						<option value="4">Demolición</option>
						<option value="5">Modificación</option>
						<option value="6">Obra nueva</option>
						<option value="7">Reforma estructural</option>
						<option value="8">Restauración</option>
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
						<option value="1">Calcular con base en la Resolución de
							la Secretaría Distrital de Planeación</option>
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
						<option value="2">Obras De Autocontrucción De Vivienda,
							De Estratos 1 Y 2, Que No Excedan Los Topes Definidos Por La Ley
							Para El Valor De La Vivienda De Interés Social</option>
						<option value="3">Ampliaciones, Modificaciones,
							Adecuaciones O Reparaciones Inmuebles Residenciales Estrato 1, 2
							Y 3. Avalúo Catastral Inferior A 135 Smimv</option>
						<option value="4">Obras Que Se Realicen Para Reparar
							Inmuebles Afectados Por Actos Terroristas O Catástrofes Naturales</option>
						<option value="5">Obras De Restauración Y Conservación En
							Bien Inmueble De Interés Cultural</option>
					</select>
				</div>
			</div>

		</div>

	</form:form>
</div>

