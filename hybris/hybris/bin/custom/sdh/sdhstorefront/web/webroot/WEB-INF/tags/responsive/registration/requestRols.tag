<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<!-- <div class="container"> -->
<!-- 	<div class="row"> -->
<!-- 		<div class="col-md-12"> -->
<!-- 			<div class="item_container_holder "> -->
<!-- 				<div class="forgotten-password item_container "> -->
<!-- 					<div class="description text-center"> -->
<%-- 						<spring:theme code="register.request.rols" --%>
<%-- 							text="Trámites Hacienda Bogotá" htmlEscape="false" /> --%>
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> 
<!-- 	</div> -->
<!-- </div> -->


<div class="container">
	<div class="row mt-3">
		<div class="col-md-12 text-center">
			<label class="control-label" style="text-transform: none"><spring:theme
					code="tramites.crear.inicial.descrip" /></label>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.tiptramite" /></label> <select
							class="new_alto form-control !important" id="">
							<!-- 							<option value="00">Seleccionar</option> -->
							<option value="01">RIT</option>
							<!-- 							<option value="02">Novedades de registro</option> -->
							<!-- 							<option value="03">Facturación</option> -->
							<!-- 							<option value="04">Analisis de la cuenta</option> -->
							<!-- 							<option value="05">Boletín de deudores Morosos del Estado</option> -->
							<!-- 							<option value="06">Verificación de pagos</option> -->
							<!-- 							<option value="07">Corrección de la información causada contablemente</option> -->
							<!-- 							<option value="08">Declaración</option> -->
						</select>
					</div>
				</div>
			</div>
			<div id="" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subtramite" /></label> <select
							class="new_alto form-control !important" id="">
							<!-- 						<option value="00">Seleccionar</option> -->
							<option value="01">Creación</option>
							<!-- 						<option value="02">Actualización</option> -->
						</select>
					</div>
				</div>
			</div>
			<div id="" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.categoria" /></label> <select
							class="new_alto form-control !important" id=""><option
								value="01">Registro/Rol Tributario</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divsubCategoriaI" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.subcategoria" /></label> <select
							class="new_alto form-control !important " id=""><option
								value="00">Seleccionar</option>
							<option value="01">Persona Natural</option>
							<option value="02">Persona Jurídica</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divRol" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required"><spring:theme
								code="tramites.crear.inicial.rol" /></label> <select
							class="new_alto form-control !important " id=""><option
								value="00">Seleccionar</option>
							<option value="01">Contribuyente</option>
							<option value="02">Agente Retenedor</option>
							<option value="03">Reportate de la Información</option>
							<option value="04">Terceros Autorizados</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row mt-3">
				<div class="col-md-12 ">
					<div class="form-group">
						<label class="control-label required"
							style="text-align: center !important;"><spring:theme
								code="tramites.crear.inicial.mensaje" /></label>
						<textarea name="mensaje" id="mensaje" class="form-control"
							style="min-height: 220px; max-height: 600px; min-width: 100%; max-width: 100%;"
							maxlength="1000"></textarea>
						<small class="form-text text-muted"
							style="text-align: right !important"><spring:theme
								code="tramites.crear.inicial.nota" /></small>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row mt-3">
		<div class="col-md-7 text-right">
			<button style="margin-top: 3px;" id="" class="btn btn-primary btn-lg"
				type="button">
				<spring:theme code="tramites.crear.inicial.enviar" />
			</button>
		</div>
		<div class="col-md-1">
			<button style="margin-top: 3px;" id=""
				class="btn btn-secondary btn-lg" type="button">
				<spring:theme code="tramites.crear.inicial.cancelar" />
			</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 text-center col-md-offset-3" style="margin-top: 15px">
			<table>
				<thead>
					<tr>
						<th><label class="contorl-label labeltabletd"><spring:theme
									code="tramites.crear.inicial.adjdoc" /></label></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input class="inputtextnew" disabled="disabled"
							type="text" size="30" value="" /></td>
						<td><input class="inputtextnew" type="file" size="30"
							value="" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>