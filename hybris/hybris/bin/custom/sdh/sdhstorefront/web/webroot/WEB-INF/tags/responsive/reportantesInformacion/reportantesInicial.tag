<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url
	value="/contribuyentes/sobretasa-gasolina/declaracion-gasolina"
	var="presentarDeclaracionUrl" htmlEscape="false" />
<spring:url value="/contribuyentes/sobretasa-gasolina" var="buscarUrl"
	htmlEscape="false" />

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr class="avisoheadline p">
							<td><spring:theme code="" /></td>
						</tr>
					</thead>
					<tbody>
						<tr class="avisobody">

							<td><spring:theme code="representantes.info.inicial.leyenda" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>



	<div class="row">
		<div class="headline">
			<h2 align="center">
				<span><spring:theme code="representantes.info.inicial.titulo" /></span>

			</h2>
		</div>
	</div>
	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />

	<div class="row">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="representantes.info.inicial.bienvenido" /></label>
		</div>
	</div>

	<div class="row">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="representantes.info.inicial.seleccion" /></label>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3">
			<div class="form-group">
				<label class="control-label required"><spring:theme
						code="representantes.info.inicial.resolucion" /></label> <select
					aria-required="true" id="aniograva" class="newalto form-control "
					name="aniograva" onchange=" " required='required'>
					<option value="">Seleccionar</option>
					<option value="">Estampillas</option>
					<option value="">Predial</option>
					<option value="">Predial-Opain</option>
					<option value="">ICA</option>
					<option value="">Vehículos</option>

				</select>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="control-label required"><spring:theme
						code="representantes.info.inicial.anigrav" /></label> <select
					aria-required="true" id="aniograva" class="newalto form-control "
					name="aniograva" onchange=" " required='required'>
					<option value="">Seleccionar</option>

				</select>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label class="control-label"><spring:theme
						code="representantes.info.inicial.articulo" /></label> <select
					id="impuesto" class="newalto form-control " name="impuesto"
					onchange="">
					<option value="">Seleccionar</option>
				</select>
			</div>
		</div>

		<div>
			<div id="inrepor" style="display: none">
				<input id="Idinrepor" value="">
			</div>

		</div>
	</div>

	<div class="row">
		<div class="col-md-3  col-md-offset-1 text-right">
			<div class="form-group">
				<button class="btn btn-primary btn-block" id="" name=""
					value="cancelar">
					<spring:theme code="representantes.info.inicial.cacelar" />
				</button>
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block" id=""
					name="" value="continuar" onclick="myFunction()">
					<spring:theme code="representantes.info.inicial.continuar" />
				</button>
			</div>
		</div>
	</div>


	<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />
	<div class="row">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="representantes.info.inicial.antes" /></label>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<table class="table">
				<thead style="cellspacing: 10 !important">
					<tr>
						<!-- 				<th colspan="2" style="text-align: center"><label -->
						<%-- 					class="control-label " for=""><spring:theme --%>
						<%-- 							code="representantes.info.inicial.predial" /></label></th> --%>
						<!-- 				<th colspan="2" style="text-align: center"><label -->
						<%-- 					class="control-label" for=""> <spring:theme --%>
						<%-- 							code="representantes.info.inicial.opain" /></label></th> --%>
						<!-- 				<th colspan="2" style="text-align: center"><label -->
						<%-- 					class="control-label" for=""> <spring:theme --%>
						<%-- 							code="representantes.info.inicial.vehicular" /></label></th> --%>
						<th colspan="2" style="text-align: center"><label
							class="control-label" for=""> <spring:theme
									code="representantes.info.inicial.ica" /></label></th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<!-- 				<td style="text-align: center !important"><img -->
						<%-- 					src="${themeResourcePath}/images/resolucion_reportantes.png" --%>
						<!-- 					style="width: 50"></img></td> -->
						<!-- 				<td style="text-align: center !important"><img -->
						<%-- 					src="${themeResourcePath}/images/anexotecnico_reportantes.png" --%>
						<!-- 					style="width: 50"></img></td> -->
						<!-- 				<td style="text-align: center !important"><img -->
						<%-- 					src="${themeResourcePath}/images/resolucion_reportantes.png" --%>
						<!-- 					style="width: 50"></img></td> -->
						<!-- 				<td style="text-align: center !important"><img -->
						<%-- 					src="${themeResourcePath}/images/anexotecnico_reportantes.png" --%>
						<!-- 					style="width: 50"></img></td> -->
						<!-- 				<td style="text-align: center !important"><img -->
						<%-- 					src="${themeResourcePath}/images/resolucion_reportantes.png" --%>
						<!-- 					style="width: 50"></img></td> -->
						<!-- 				<td style="text-align: center !important"><img -->
						<%-- 					src="${themeResourcePath}/images/anexotecnico_reportantes.png" --%>
						<!-- 					style="width: 50"></img></td> -->
						<td style="text-align: center !important"><img
							src="${themeResourcePath}/images/resolucion_reportantes.png"
							style="width: 50"></img></td>
						<td style="text-align: center !important"><img
							src="${themeResourcePath}/images/anexotecnico_reportantes.png"
							style="width: 50"></img></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label required"><spring:theme
						code="representantes.info.inicial.seleccionar" /></label><input
					type="file" class="form-control" id="exampleFormControlFile1">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-offset-3">
			<button type="submit" class="btn btn-primary btn-lg" id="" name=""
				value="regresar">
				<spring:theme code="representantes.info.vehiculos.regresar" />
			</button>
		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary btn-lg" id="" name=""
				value="cancelar">
				<spring:theme code="representantes.info.vehiculos.cancelar" />
			</button>
		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary btn-lg" id="" name=""
				value="enviar">
				<spring:theme code="representantes.info.vehiculos.enviar" />
			</button>
		</div>
	</div>
</div>

