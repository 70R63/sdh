<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6 headline">
		<h2>
			<span><spring:theme
					code="delineacion.urbana.dec.areasusos.title" /></span>
		</h2>
	</div>
</div>

<form:form>

	<div class="row">
		<div class="col-md-2">

			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.uso" />
			</label>


		</div>
		<div class="col-md-2">

			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.areauso" />
			</label>

		</div>
		<div class="col-md-1">

			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.numunidades" />
			</label>

		</div>
		<div class="col-md-2">
			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.netuso" /></label>
		</div>

		<div class="col-md-2">

			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.areainve" />
			</label>

		</div>
		<div class="col-md-2">

			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.m2area" />
			</label>

		</div>
	</div>

	<div class="row">
		<div class="row areasusos">
			<div class="col-md-2">
				<div class="form-group ">
					<select class="form-control select1">
						<option value="">Seleccionar</option>
						<option value="1">Vivienda</option>
						<option value="2">Comercio</option>
						<option value="3">Servicios</option>
						<option value="4">Dot/Instituc</option>
						<option value="5">Industria</option>
						<option value="6">Otros</option>
					</select>
				</div>

			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<select class="form-control select2">
						<option value="Seleccionar">Seleccionar</option>
						<option value="Vivienda estrato 1">Vivienda estrato 1</option>
						<option value="Vivienda estrato 2">Vivienda estrato 2</option>
						<option value="Vivienda estrato 3">Vivienda estrato 3</option>
						<option value="Vivienda estrato 4">Vivienda estrato 4</option>
						<option value="Vivienda estrato 5">Vivienda estrato 5</option>
						<option value="Comercio Metropolitano">Comercio
							Metropolitano</option>
						<option value="Comercio Vecinal o Local">Comercio Vecinal
							o Local</option>
						<option value="comercio Zonal">Comercio Zonal</option>
						<option value="Comercio Urbano">Comercio Urbano</option>
						<option value="Servicios Metropolitano">Servicios
							Metropolitano</option>
						<option value="Servicios Vecinal o Local">Servicios
							Vecinal o Local</option>
						<option value="Servicios Zonal">Servicios Zonal</option>
						<option value="Servicios Urbano">Servicios Urbano</option>
						<option value="Dotacional Metropolitano">Dotacional
							Metropolitano</option>
						<option value="Dotacional Vecinal o Local">Dotacional
							Vecinal o Local</option>
						<option value="Dotacional Zonal">Dotacional Zonal</option>
						<option value="Dotacional Urbano">Dotacional Urbano</option>
						<option value="Industrial">Industrial</option>
					</select>
				</div>
			</div>

			<div class="col-md-1">
				<div class="form-group ">
					<input class="form-control input1" maxlength="30"></input>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<input class="form-control input2" maxlength="30" value="M2"></input>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<select class="form-control select3">
						<option value=" ">Seleccionar</option>
						<option value="Ampliada">Ampliada</option>
						<option value="Modificada">Modificada</option>
						<option value="Adecuada">Adecuada</option>
						<option value="Obra Nueva">Obra Nueva</option>
						<option value="Reconocimiento">Reconocimiento</option>
						<option value="Conservación/Restauración">Conservación/Restauración</option>
						<option value="Reforzamiento est">Reforzamiento est</option>
						<option value="Demolición">Demolición</option>
						<option value="Cerramiento">Cerramiento</option>
					</select>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<input class="form-control input3" maxlength="30" value="M2"></input>
				</div>
			</div>

			<div class="col-md-1">
				<div class="form-group ">
					<img onclick="addinfoareuso()"
						src="${themeResourcePath}/images/adddelineacion.png"
						style="width: 25px"></img>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="row total">
			<div class="col-md-2">
				<div class="form-group ">
					<input class="form-control" maxlength="30" value="Total" disabled></input>
				</div>
			</div>

			<div class="col-md-2 col-md-offset-3">
				<div class="form-group ">
					<input class="form-control" maxlength="30" value=""></input>
				</div>
			</div>
			<div class="col-md-2 col-md-offset-2">
				<div class="form-group ">
					<input class="form-control" maxlength="30" value=""></input>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>

	<div class="row">
		<div class="col-md-3">

			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.netuso" />
			</label>
		</div>
		<div class="col-md-3">

			<label class="control-label" for=""> <spring:theme
					code="delineacion.urbana.dec.areasusos.aream2" />
			</label>

		</div>
	</div>

	<div class="row">
		<div class="row arearquitec">
			<div class="col-md-3">
				<div class="form-group ">
					<select class="form-control sel1">

						<option value="Seleccionar">Seleccionar</option>
						<option value="Lote">Lote</option>
						<option value="Sótano">Sótano</option>
						<option value="Semisotano(s)">Semisotano(s)</option>
						<option value="Primer Piso">Primer Piso</option>
						<option value="Pisos Restantes">Pisos Restantes</option>
						<option value="Libre Primer Piso">Libre Primer Piso</option>
					</select>
				</div>

			</div>



			<div class="col-md-3">
				<div class="form-group ">
					<input class="form-control in1" maxlength="30"></input>
				</div>
			</div>



			<div class="col-md-1">
				<div class="form-group ">
					<img onclick="addinfoareusotable2()"
						src="${themeResourcePath}/images/adddelineacion.png"
						style="width: 25px"></img>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="row totalnew">
			<div class="col-md-3">
				<div class="form-group ">
					<input class="form-control" maxlength="30" value="Total" disabled></input>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group ">
					<input class="form-control" maxlength="30" value=""></input>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>

	<div class="row">
		<div class="col-md-6">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.areasusos.preobra" /></label> <select class="form-control">
          <option value="">Seleccionar</option>
          <option value="1">Calcular con base en la Resolución de la Secretaría Distrital de Planeación</option>
          <option value="2">Incorporar el valor de su presupuesto estimado</option>
        </select>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group ">
				<label class="control-label"><spring:theme
						code="delineacion.urbana.dec.areasusos.cauexen" /></label> <select class="form-control">
          <option value="0">Seleccionar</option>
          <option value="1">Obras Nuevas Vis Estratos 1, 2 Y 3</option>
          <option value="2">Obras De Autocontrucción De Vivienda, De Estratos 1 Y 2, Que No Excedan Los Topes Definidos Por La Ley Para El Valor De La Vivienda De Interés Social</option>
          <option value="3">Ampliaciones, Modificaciones, Adecuaciones O Reparaciones Inmuebles Residenciales Estrato 1, 2 Y 3. Avalúo Catastral Inferior A 135 Smimv</option>
          <option value="4">Obras Que Se Realicen Para Reparar Inmuebles Afectados Por Actos Terroristas O Catástrofes Naturales</option>
          <option value="5">Obras De Restauración Y Conservación En Bien Inmueble De Interés Cultural</option>
        </select>
			</div>
		</div>

	</div>



</form:form>
<script>
	function addinfoareuso() {

		if ($(".areasusos").length < 3) {
			$($(".areasusos")[0]).parent()
					.append($($(".areasusos")[0]).clone());

			$($(".areasusos")[0]).parent().children().last().find(".select1")
					.val("")
			$($(".areasusos")[0]).parent().children().last().find(".select2")
					.val("")
			$($(".areasusos")[0]).parent().children().last().find(".input1")
					.val("")
			$($(".areasusos")[0]).parent().children().last().find(".input2")
					.val("M2")
			$($(".areasusos")[0]).parent().children().last().find(".select3")
					.val("")
			$($(".areasusos")[0]).parent().children().last().find(".input3")
					.val("M2")
		}

	}
	
	function addinfoareusotable2() {

		if ($(".arearquitec").length < 3) {
			$($(".arearquitec")[0]).parent()
					.append($($(".arearquitec")[0]).clone());

			$($(".arearquitec")[0]).parent().children().last().find(".sel1")
					.val("")
			$($(".arearquitec")[0]).parent().children().last().find(".in1")
					.val("")
			
		}

	}
</script>
