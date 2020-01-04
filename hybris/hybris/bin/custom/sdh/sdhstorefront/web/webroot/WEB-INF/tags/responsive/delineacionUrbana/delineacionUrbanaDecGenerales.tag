<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<input type="hidden" value="${tipoMarca}" id="tipoMarca" />
<div class="container_new_page">

	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme
						code="delineacion.urbana.dec.generales.title" /></span>
			</h2>
		</div>
	</div>
	
	

	<div class="row">
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.codigo" /></label>
				<sf:input class="newalto form-control" readonly="true" aria-required="true"
					maxlength="240" path="input.selectedCDU" />
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.anigrav" /></label>
				<sf:select path="infObjetoDelineacionExtras.anoGravable"
					items="${dataForm.catalogos.anoGravable}"
					referenceData="${dataForm.catalogos.anoGravable}"
					class="newalto form-control" disabled="true" readonly="true"></sf:select>

				<!-- 				<select -->
				<!-- 					id="an" class="form-control " name=" " onchange=" " disabled> -->
				<!-- 					<option value="2019">2019</option> -->
				<!-- 					<option value="2018">2018</option> -->
				<!-- 					<option value="2017">2017</option> -->
				<!-- 					<option value="2016">2016</option> -->
				<!-- 				</select> -->
			</div>
		</div>


		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.opuso" /></label>
				<sf:input class="new_alto form-control" readonly="true" aria-required="true"
					maxlength="240" path="infObjetoDelineacion.infoDeclara.opcionUso" />
				<!-- 						<input id="" -->
				<!-- 					name="" class="form-control" aria-required="true" type="text" -->
				<!-- 					readonly="readonly" value="" maxlength="240"> -->
			</div>
		</div>
<!-- 	</div> -->
<!-- 	<div class="row"> -->
		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.tiplicencia" /></label>
				<c:if test="${empty tipoMarca}">
					<sf:select path="infObjetoDelineacion.infoDeclara.tipoLicencia"
						id="tipoDeLicencia" items="${dataForm.catalogos.tipoDeLicencia}"
						referenceData="${dataForm.catalogos.tipoDeLicencia}"
						class="newalto form-control" disabled="true" readonly="true">
					</sf:select>
				</c:if>
				<c:if test="${not empty  tipoMarca}">
					<sf:select path="infObjetoDelineacion.infoDeclara.tipoLicencia"
						id="tipoDeLicencia" items="${dataForm.catalogos.tipoDeLicencia}"
						referenceData="${dataForm.catalogos.tipoDeLicencia}"
						class="new_alto form-control">
					</sf:select>
				</c:if>
				<!-- 				<select -->
				<!-- 					id="an" class="form-control " name=" " onchange=" "> -->
				<!-- 					<option value="">Seleccionar</option> -->
				<!-- 					<option value="1">Licencia</option> -->
				<!-- 					<option value="2">Reconocimiento</option> -->
				<!-- 				</select> -->
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.modlicencia" /></label>
				<sf:select class="new_alto form-control" id="an"
					path="infObjetoDelineacion.infoDeclara.modalidad"
					items="${dataForm.catalogos.modalidadLicencia}" onchange="nuevos(this)">
				</sf:select>
				<!-- 								<select -->
				<!-- 									id="selecmodlicen" class="form-control " name=" " onchange="obranueva(this)"> -->
				<!-- 									<option value="00">Seleccionar</option> -->
				<!-- 									<option value="01">Adecuación</option>  -->
				<!-- 									<option value="02">Ampliación</option> -->
				<!-- 									<option value="03">Cerramiento</option> -->
				<!-- 									<option value="04">Demolición</option>  -->
				<!-- 									<option value="05">Modificación</option> -->
				<!-- 									<option value="06">Obra nueva</option>  -->
				<!-- 									<option value="07">Reforma</option> -->
				<!-- 									<option value="08">Estructural</option> -->
				<!-- 									<option value="09">Restauración</option> -->
				<!-- 								</select> -->
			</div>
		</div>

		<div class="col-md-2">
			<div class="form-group ">

				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.Objetolicencia" /></label>
				<div class="form-group ">
					<sf:select path="infObjetoDelineacion.infoDeclara.objetoLicen"
						items="${dataForm.catalogos.objetoLicencia}"
						referenceData="${dataForm.catalogos.objetoLicencia}"
						class="new_alto form-control"></sf:select>
				</div>

			</div>
		</div>

	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="form-group ">
				<label class="control-label "><spring:theme
						code="delineacion.urbana.dec.generales.cauexen" /></label>
				<sf:input id="cauexen" class="newalto_dir form-control cauexen" readonly="true"
					aria-required="true" maxlength="240"
					path="infObjetoDelineacion.infoDeclara.causalExcepDESCRIPCION" />
				<%-- 				<sf:select class="form-control" onchange="costoshabil(this)" path="infObjetoDelineacion.infoDeclara.causalExcep" --%>
				<%-- 						items="${dataForm.catalogos.causalExencion}" disabled="true"></sf:select>		 --%>

				<!-- 				<select id="" -->
				<!-- 					class="form-control " name=" " onchange=" "> -->
				<!-- 					<option value="0">Seleccionar</option> -->
				<!-- 					<option value="1">Obras Nuevas Vis Estratos 1, 2 Y 3</option> -->
				<!-- 					<option value="2">Obras De Autocontrucción De Vivienda, De -->
				<!-- 						Estratos 1 Y 2, Que No Excedan Los Topes Definidos Por La Ley Para -->
				<!-- 						El Valor De La Vivienda De Interés Social</option> -->
				<!-- 					<option value="3">Ampliaciones, Modificaciones, -->
				<!-- 						Adecuaciones O Reparaciones Inmuebles Residenciales Estrato 1, 2 Y -->
				<!-- 						3. Avalúo Catastral Inferior A 135 Smimv</option> -->
				<!-- 					<option value="4">Obras Que Se Realicen Para Reparar -->
				<!-- 						Inmuebles Afectados Por Actos Terroristas O Catástrofes Naturales</option> -->
				<!-- 					<option value="5">Obras De Restauración Y Conservación En -->
				<!-- 						Bien Inmueble De Interés Cultural</option> -->
				<!-- 				</select> -->
			</div>
		</div>

	</div>

</div>




