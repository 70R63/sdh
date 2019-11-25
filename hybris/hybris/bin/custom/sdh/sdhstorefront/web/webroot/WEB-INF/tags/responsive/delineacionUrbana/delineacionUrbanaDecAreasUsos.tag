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
						code="delineacion.urbana.dec.areasusos.title" /></span>
			</h2>
		</div>
	</div>


	<form:form>
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">

					<label class="control-label" for=""> <spring:theme
							code="delineacion.urbana.dec.areasusos.uso" />
					</label>


				</div>
				<div class="col-md-3">

					<label class="control-label" for=""> <spring:theme
							code="delineacion.urbana.dec.areasusos.areauso" />
					</label>

				</div>
				<div class="col-md-2">

					<label class="control-label" for=""> <spring:theme
							code="delineacion.urbana.dec.areasusos.numunidades" />
					</label>

				</div>
				<div class="col-md-3">
					<label class="control-label" for=""> <spring:theme
							code="delineacion.urbana.dec.areasusos.netuso" /></label>
				</div>
			</div>

			<div class="row">
				<div class="row areasusos">
					<div class="col-md-3">
						<div class=" form-group ">
							<select class="new_alto form-control select1">
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

					<div class="col-md-3">
						<div class="form-group ">
							<select class="new_alto form-control select2">
								<option value="Seleccionar">Seleccionar</option>
								<option value="Vivienda estrato 1">Vivienda estrato 1</option>
								<option value="Vivienda estrato 2">Vivienda estrato 2</option>
								<option value="Vivienda estrato 3">Vivienda estrato 3</option>
								<option value="Vivienda estrato 4">Vivienda estrato 4</option>
								<option value="Vivienda estrato 5">Vivienda estrato 5</option>
								<option value="Comercio Metropolitano">Comercio
									Metropolitano</option>
								<option value="Comercio Vecinal o Local">Comercio
									Vecinal o Local</option>
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

					<div class="col-md-2">
						<div class="form-group ">
							<input class="form-control input1" maxlength="30"></input>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group ">
							<input class="form-control input2" maxlength="30" value="M2"></input>
						</div>
					</div>

					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareuso()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deleinfoareuso()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="row total">
					<div class="col-md-3">
						<div class="form-group ">
							<input class="form-control" maxlength="30" value="Total" disabled></input>
						</div>
					</div>

					<div class="col-md-3">
						<div class="form-group ">
							<input class="form-control" maxlength="30" value="" ></input>
						</div>
					</div>

					<div class="col-md-3 col-md-offset-1" style="margin-left: 169px;">
						<div class="form-group ">
							<input class="form-control" maxlength="30" value="" onkeyup="numberFormat(this)" onclick="numberFormat(this)"></input>
						</div>
					</div>
				</div>
			</div>

			<!-- 		inicio tabla dos -->
			<br> <br>
			<div class="row">
				<div class="col-md-5">

					<label class="control-label" for=""> <spring:theme
							code="delineacion.urbana.dec.areasusos.areainve" />
					</label>

				</div>
				<div class="col-md-3">

					<label class="control-label" for=""> <spring:theme
							code="delineacion.urbana.dec.areasusos.m2area" />
					</label>

				</div>
			</div>
			<div class="row areausosdos">
				<div class="col-md-5">
					<div class="form-group ">
						<select class="form-control sel5">
							<option value="Seleccionar">Seleccionar</option>
							<option value="Obra nueva">Obra nueva</option>
							<option value="Ampliada">Ampliada</option>
							<option value="Modificada">Modificada</option>
							<option value="Adecuada">Adecuada</option>
							<option value="Reconocimiento">Reconocimiento</option>
							<option value="Conservaci�n/Restaruaci�n">Conservaci�n/Restaruaci�n</option>
							<option value="Reforzamiento estructural">Reforzamiento
								estructural</option>
							<option value="Demolici�n">Demolici�n</option>
							<option value="Metros lineales Cerramiento">Metros
								lineales Cerramiento</option>
							<option value="Reconocimiento">Reconocimiento</option>
							<option value="Obra">Obra</option>
						</select>
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group ">
						<input class="form-control input5" maxlength="30" value=""
							id="inputareainter"></input>
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group ">
						<img onclick="addinfoareuso3()"
							src="${themeResourcePath}/images/adddelineacion.png"
							style="width: 25px"></img> <img onclick="deleinfoareusotable3()"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</div>
		<div>
			<div class="row">
				<div class="col-md-5">
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

		<!-- 		inicio tabla tres -->

		<br>
		<br>

		<div class="row">
			<div class="col-md-3">

				<label class="control-label" for=""> <spring:theme
						code="delineacion.urbana.dec.areasusos.arnetpro" />
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
							<option value="S�tano">S�tano</option>
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
							style="width: 25px"></img> <img onclick="deleinfoareusotable2()"
							src="${themeResourcePath}/images/deledelineacion.png"
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
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="delineacion.urbana.dec.areasusos.fechultabo" /></label> <input
							id="" name="" class="form-control" aria-required="true"
							type="text" value="" maxlength="240" disabled>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="delineacion.urbana.dec.areasusos.fecfinalobra" /></label> <input
							id="" name="" class="form-control" aria-required="true"
							type="text" value="" maxlength="240" disabled>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group ">
						<label class="control-label"><spring:theme
								code="delineacion.urbana.dec.areasusos.fechejec" /></label> <input
							id="" name="" class="form-control" aria-required="true"
							type="text" value="" maxlength="240" disabled>
					</div>
				</div>

			</div>
		</div>
</form:form>

</div>
<script>
	function addinfoareuso() {

		if ($(".areasusos").length < 10000) {
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
		}

	}

	function deleinfoareuso() {
		var i = $(".areasusos").length;
		var val = i - 1;
		if ($(".areasusos").length <= 10000 && $(".areasusos").length > 1) {

			$($(".areasusos")[val]).closest($($(".areasusos")[val]).remove());

		} else if ($(".areasusos").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}

	function addinfoareusotable2() {

		if ($(".arearquitec").length < 3) {
			$($(".arearquitec")[0]).parent().append(
					$($(".arearquitec")[0]).clone());

			$($(".arearquitec")[0]).parent().children().last().find(".sel1")
					.val("")
			$($(".arearquitec")[0]).parent().children().last().find(".in1")
					.val("")

		}
	}

	function deleinfoareusotable2() {
		var i = $(".arearquitec").length;
		var val = i - 1;
		if ($(".arearquitec").length <= 3 && $(".arearquitec").length > 1) {

			$($(".arearquitec")[val]).closest(
					$($(".arearquitec")[val]).remove());

		} else if ($(".arearquitec").length <= 1) {
			alert("No puede eliminar todos los registros");
		}

	}

	function addinfoareuso3() {

		if ($(".areausosdos").length < 10000) {
			$($(".areausosdos")[0]).parent().append(
					$($(".areausosdos")[0]).clone());
			$($(".areausosdos")[0]).parent().children().last().find(".sel5")
					.val("")
			$($(".areausosdos")[0]).parent().children().last().find(".input5")
					.val("")
		}

	}

	function deleinfoareusotable3() {
		var i = $(".areausosdos").length;
		var val = i - 1;
		if ($(".areausosdos").length <= 10000 && $(".areausosdos").length > 1) {

			$($(".areausosdos")[val]).closest(
					$($(".areausosdos")[val]).remove());

		} else if ($(".areausosdos").length <= 1) {
			alert("No puede eliminar todos los registros");
		}

	}
</script>
