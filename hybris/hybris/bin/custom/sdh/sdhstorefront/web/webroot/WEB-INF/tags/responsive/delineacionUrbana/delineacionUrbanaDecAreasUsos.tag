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
		<div class="container">
			<table class="decurbana">
				<thead>
					<tr>
						<th><label class="control-label" for=""><spring:theme
									code="delineacion.urbana.dec.areasusos.vivienda" /></label></th>
						<th><label class="control-label" for=""> <spring:theme
									code="delineacion.urbana.dec.areasusos.comercio" /></label></th>
						<th><label class="control-label" for=""> <spring:theme
									code="delineacion.urbana.dec.areasusos.servicios" /></label></th>
						<th><label class="control-label" for=""> <spring:theme
									code="delineacion.urbana.dec.areasusos.dotacional" /></label></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><select class="form-control">
								<option value="01">Vivienda Estrato 1</option>
								<option value="02">Comercio Metropilitano</option>
								<option value="03">Servicios vecinal o local</option>
						</select> <label class="control-label" for=""> <spring:theme
									code="delineacion.urbana.dec.areasusos.numunidades" /></label> <input
							class="form-control" maxlength="10"></input></td>
						<td><select class="form-control">
								<option value="01">Vivienda Estrato 1</option>
								<option value="02">Comercio Metropilitano</option>
								<option value="03">Servicios vecinal o local</option>
						</select> <label class="control-label" for=""> <spring:theme
									code="delineacion.urbana.dec.areasusos.numunidades" /></label> <input
							class="form-control" maxlength="30"></input></td>
						<td><select class="form-control">
								<option value="01">Vivienda Estrato 1</option>
								<option value="02">Comercio Metropilitano</option>
								<option value="03">Servicios vecinal o local</option>
						</select> <label class="control-label" for=""> <spring:theme
									code="delineacion.urbana.dec.areasusos.numunidades" /></label> <input
							class="form-control" maxlength="30"></input></td>
						<td><select class="form-control">
								<option value="01">Vivienda Estrato 1</option>
								<option value="02">Comercio Metropilitano</option>
								<option value="03">Servicios vecinal o local</option>
						</select> <label class="control-label" for=""> <spring:theme
									code="delineacion.urbana.dec.areasusos.numunidades" /></label> <input
							class="form-control" maxlength="30"></input></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="container">
		<table class="decurbanaarea">
			<thead>
				<tr>
					<th><label class="control-label" for=""><spring:theme
								code="delineacion.urbana.dec.areasusos.arquitec" /></label></th>
					<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.dec.areasusos.netuso" /></label></th>
					<th><label class="control-label" for=""> <spring:theme
								code="delineacion.urbana.dec.areasusos.intervenidas" /></label></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><br>
						<div class="row">
							<div class="col-md-5">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.lote" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-5">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.sotano" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control2" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-5">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.semisotano" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control2" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-5">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.pisouno" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control2" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-5">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.pisorestan" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control2" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-5">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.totalcons" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control2" disabled="disabled" maxlength="30"
									style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-5">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.libpisouno" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control2" disabled="disabled" maxlength="30"
									style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div></td>


					<td><div class="row">
							<div class="col-md-7">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.usovivi" /></label> <select
										class="form-control">
										<option value="01">Vivienda Estrato 1</option>
										<option value="02">Vivienda Estrato 2</option>
										<option value="03">Vivienda Estrato 3</option>
										<option value="04">Vivienda Estrato 4</option>
										<option value="05">Vivienda Estrato 5</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.vivienda" /></label> <input
										class="form-control" maxlength="30" style="width: 90px"></input><label
										class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.m2" /></label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-7">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.usocom" /></label><select
										class="form-control">
										<option value="01">Comercio Metropilitano</option>
										<option value="02">Comercio Vecinal o Local</option>
										<option value="03">Comercio Zonal</option>
										<option value="04">Comercio Urbano</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.comercio" /></label> <input
										class="form-control" maxlength="30" style="width: 90px"></input><label
										class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.m2" /></label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-7">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.usoserv" /></label><select
										class="form-control">
										<option value="01">Servicios Vecinal o Local</option>
										<option value="02">Servicios Zonal</option>
										<option value="03">Servicios Urbano</option>
										<option value="04">Servicios Metropolitano</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.serv" /></label> <input
										class="form-control" maxlength="30" style="width: 90px"></input><label
										class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.m2" /></label>
								</div>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-7">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.usodot" /></label><select
										class="form-control">
										<option value="01">Dotacional Vecinal o Local</option>
										<option value="02">Dotacional Zonal</option>
										<option value="03">Dotacional Urbano</option>
										<option value="04">Dotacional Metropilitano</option>
										<option value="05">Industrial</option>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.dot" /></label> <input
										class="form-control" maxlength="30" style="width: 90px"></input>

									<label class="control-label" for=""> <spring:theme
											code="delineacion.urbana.dec.areasusos.m2" /></label>
								</div>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-3">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.indus" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-3">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.otros" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-3">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.total" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div></td>

					<td>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.ampl" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.modf" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.adec" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.obnu" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.recono" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.conserv" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.reforz" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.demo" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.cerra" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div> <br>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.total" /></label>
							</div>
							<div class="col-md-4">
								<input class="form-control" maxlength="30" style="width: 90px"></input>
							</div>
							<div class="col-md-2">
								<label class="control-label" for=""> <spring:theme
										code="delineacion.urbana.dec.areasusos.m2" /></label>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>

		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label "><spring:theme
							code="delineacion.urbana.dec.generales.opuso" /></label> <select
						id="opuso" class="form-control " name=" " onchange=" ">
						<option value="01">Retención</option>
						<option value="02">Declaración</option>
						<option value="03">Corrección</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.areasusos.fechultabo" /></label> <input
						id="" name="" class="form-control" aria-required="true"
						type="text" readonly="readonly" value="" maxlength="240">
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group ">
					<label class="control-label"><spring:theme
							code="delineacion.urbana.dec.areasusos.fechejec" /></label> <input id=""
						name="" class="form-control" aria-required="true" type="text"
						readonly="readonly" value="" maxlength="240">
				</div>
			</div>

		</div>
	</div>
</form:form>

