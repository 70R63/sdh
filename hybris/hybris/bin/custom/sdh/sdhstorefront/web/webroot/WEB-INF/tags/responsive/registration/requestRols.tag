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
<%-- 							text="Tr�mites Hacienda Bogot�" htmlEscape="false" /> --%>
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
	
	<c:url value="/register/postRol" var="formAction"/>
	<form:form method="post" commandName="tramitesCreacionCasoInfo" action="${formAction}">
	
	<input type="hidden" id="depe0" name="depe0" value="212110">
	<input type="hidden" id="desA0" name="desA0" value="DOCUMENTO DE IDENTIFICACI�N">
	<input type="hidden" id="seri0" name="seri0" value="60">
	<input type="hidden" id="sser0" name="sser0" value="60.15">
	<input type="hidden" id="tipd0" name="tipd0" value="SDH-6274">
	
	<div class="row">
		<div class="col-md-6">
			<div class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="tramites.crear.inicial.tiptramite" />
						</label> 
						<select	class=" form-control !important" id="valorN0" name="valorN0">
							<option value="01">RIT</option>
						</select>
					</div>
				</div>
			</div>
			
			<div id="" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="tramites.crear.inicial.subtramite" />
						</label> 
						<select
							class=" form-control !important" id="valorN1" name="valorN1">
							<option value="01">Creaci�n</option>
						</select>
					</div>
				</div>
			</div>
			<div id="" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="tramites.crear.inicial.categoria" />
						</label> 
						<select	class=" form-control !important" id="valorN2" name="valorN2">
							<option	value="01">Registro/Rol Tributario</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divsubCategoriaI" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="tramites.crear.inicial.subcategoria" />
						</label> 
						<select	class=" form-control !important " id="valorN3" name="valorN3">
							<option	value="00">Seleccionar</option>
							<option value="01">Persona Natural</option>
							<option value="02">Persona Jur�dica</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divRol" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="tramites.crear.inicial.rol" />
						</label> 
						<select	class=" form-control !important " id="rol" >
							<option	value="00">Seleccionar</option>
							<option value="01">Contribuyente</option>
							<option value="02">Agente Retenedor</option>
							<option value="03">Reportate de la Informaci�n</option>
							<option value="04">Terceros Autorizados</option>
						</select>
					</div>
				</div>
			</div>
			<div id="divCorreo" class="row mt-3">
				<div class="col-md-12 text-center">
					<div class="form-group">
						<label class="control-label required">
							<spring:theme code="tramites.crear.inicial.correo" />
						</label>
						<input	class="form-control" value="" type="email" id="email"/>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="row mt-3">
				<div class="col-md-12 ">
					<div class="form-group">
						<label class="control-label required" style="text-align: center !important;">
							<spring:theme code="tramites.crear.inicial.mensaje" />
						</label>
						<textarea name="mensaje" id="mensaje" class="form-control"
							style="min-height: 220px; max-height: 600px; min-width: 100%; max-width: 100%;"
							maxlength="1000">
						</textarea>
						<small class="form-text text-muted"		style="text-align: right !important">
							<spring:theme code="tramites.crear.inicial.nota" />
						</small>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="row documentos">
		<div class="col-md-6 text-center" style="margin-top: 15px">
			<table>
				<thead>
					<tr>
						<th>
							<label class="contorl-label labeltabletd" >
								<spring:theme code="tramites.crear.inicial.adjdoc" />
							</label>
						</th>
						<th>
							<label class="contorl-label labeltabletd required">
								<spring:theme code="tramites.crear.inicial.adj" />
							</label>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<input style="width:710px; font-size:9px !important" class="inputtextnew" disabled="disabled"	
							type="text" size="30" value="DOCUMENTO DE IDENTIFICACI�N" id="desA0" name="desA0"/>						
						</td>
							
						<td>
							<input style="width:405px" class="inputtextnew" type="file" size="150" id="conA0" name="conA0"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	
	
	
	
	
	
	<div class="row mt-3">
		<div class="col-md-7 text-center">
			<button style="margin-top: 5px;" id="" class="btn btn-primary btn-lg"
				type="submit" onclick="changeMessage();">
				<spring:theme code="tramites.crear.inicial.enviar" />
			</button>
		</div>
		<div class="col-md-1">
			<button type="button" style="margin-top: 5px;"
				class="btn btn-secondary btn-lg" id="action" name="action"
				value="cancelar"
				onclick="window.location.href ='<c:url value='/contribuyentes' />';">
				<spring:theme code="tramites.crear.inicial.cancelar" />
			</button>

		</div>
	</div>
	</form:form>
</div>
