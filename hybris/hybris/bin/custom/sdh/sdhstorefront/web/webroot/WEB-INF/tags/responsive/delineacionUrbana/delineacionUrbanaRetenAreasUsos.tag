<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<c:set var="disabledInformacionAreaUso" value="" />
<c:if test="${dataForm.controlCampos.informacionAreaUso == true}">
	<c:set var="disabledInformacionAreaUso" value='true' />
</c:if>
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


	<div class="row">
		<div class="col-md-3 mostrarMD">
			<label class="control-label format_label" for=""
				style="text-transform: none !important"> <spring:theme
					code="delineacion.urbana.dec.areasusos.uso" />
			</label>
		</div>
		<div class="col-md-2 mostrarMD">
			<label class="control-label format_label" for=""
				style="text-transform: none !important"> <spring:theme
					code="delineacion.urbana.dec.areasusos.netuso" /></label>
		</div>
	</div>

	<!-- LINEA DE USO -->
	<div class="row" id="divUsos">
		<c:forEach items="${dataForm.infObjetoDelineacion.usos}" var="info" varStatus="loop">
			<div class="row areasusos">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label format_label mostrarXS" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.uso" /></label>
						<c:if test='${dataForm.input.tipoFlujo == "D"}'>
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].uso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="new_alto form-control usoSelect"
								disabled="${disabledInformacionAreaUso}"></sf:select>
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].uso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="new_alto form-control usoSelect"
								disabled="${disabledInformacionAreaUso}"></sf:select>
						</c:if>

					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label format_label mostrarXS" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.netuso" /></label>
						<c:if test='${dataForm.input.tipoFlujo == "D"}'>
							<sf:input class="newalto form-control usoInput"
								readonly="${disabledInformacionAreaUso}" aria-required="true"
								maxlength="240"
								path="infObjetoDelineacion.usos[${loop.index}].areaNeta"
								onkeyup="numberFormat(this)" onclick="numberFormat(this)"
								disabled="false" />
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:input class="newalto form-control usoInput"
								readonly="${disabledInformacionAreaUso}" aria-required="true"
								maxlength="240"
								path="infObjetoDelineacion.usos[${loop.index}].areaNeta"
								disabled="false" onkeyup="numberFormat(this)"
								onclick="numberFormat(this)" />
						</c:if>
					</div>
				</div>

				<c:if test="${dataForm.controlCampos.informacionAreaUso != true}">
					<c:if test='${dataForm.input.tipoFlujo == "D"}'>
						<div class="col-md-1">
							<div class="form-group ">
								<img onclick="addinfoareusotable2(this,'areasusos')" src="${themeResourcePath}/images/adddelineacion.png" style="width: 25px"></img> 
								<img onclick="deleinfoareusotable2(this,'areasusos')" src="${themeResourcePath}/images/deledelineacion.png" style="width: 25px"></img>
							</div>
						</div>
					</c:if>
					<c:if test='${dataForm.input.tipoFlujo == "R"}'>
						<div class="col-md-1">
							<div class="form-group ">
								<img onclick="addinfoareusotable2(this,'areasusos')" src="${themeResourcePath}/images/adddelineacion.png" style="width: 25px"></img> 
								<img onclick="deleinfoareusotable2(this,'areasusos')" src="${themeResourcePath}/images/deledelineacion.png" style="width: 25px"></img>
							</div>
						</div>
					</c:if>
				</c:if>
			</div>
		</c:forEach>
	</div>


	<!-- LINEA DE TOTAL - USO -->
	<div class="row">
		<div class="row total">
			<div class="col-md-3">
				<div class="form-group ">
					<input id="inputareainter" class="new_alto form-control" maxlength="30" value="Total" disabled="disabled"readonly="readonly"></input>
				</div>
			</div>

			<div class="col-md-2 offset-md-3">
				<div class="form-group ">
					<sf:input id="inputareainter" class="newalto form-control" maxlength="30" path="infObjetoDelineacion.infoDeclara.totalUsos" disabled="true"></sf:input>
				</div>
			</div>
		</div>
	</div>



	<!-- 	comienza tabla dos -->

	<div class="row">
		<div class="row mostrarMD">
			<div class="col-md-3">
				<label class="control-label format_label" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.areainve" /></label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.m2area" /> </label>
			</div>
		</div>
	</div>

	<div class="row" id="divIntervenida">
		<c:forEach items="${dataForm.infObjetoDelineacion.areaIntervenida}" var="varAreaIntervenida" varStatus="loop">
			<div class="areausosdos row">
				<div class="col-md-3">
					<div class="form-group ">
					<label class="control-label format_label mostrarXS" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.areainve" /></label>
					<sf:select id="select"
						path="infObjetoDelineacion.areaIntervenida[${loop.index}].areaInter"
						items="${dataForm.catalogos.areaInter}"
						referenceData="${dataForm.catalogos.areaInter}"
						class="new_alto form-control intervenidaSelect"
						disabled="${disabledInformacionAreaUso}"></sf:select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label format_label mostrarXS" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.m2area" /></label>
						<sf:input class="newalto form-control intervenidaInput"
							readonly="${disabledInformacionAreaUso}" aria-required="true"
							maxlength="240"
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].aream2"
							onkeyup="numberFormat(this)" onclick="numberFormat(this)" />
					</div>
				</div>
				<c:if test="${dataForm.controlCampos.informacionAreaUso != true}">
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareusotable2(this,'areausosdos')" src="${themeResourcePath}/images/adddelineacion.png" style="width: 25px"></img> 
							<img onclick="deleinfoareusotable2(this,'areausosdos')" src="${themeResourcePath}/images/deledelineacion.png" style="width: 25px"></img>
						</div>
					</div>
				</c:if>
			</div>
		</c:forEach>
	</div>


	<div class="row">
		<div class="row total">
			<div class="col-md-3">
				<div class="form-group ">
					<input id="inputareainter" class="new_alto form-control"
						maxlength="30" value="Total" disabled="disabled"
						readonly="readonly"></input>
				</div>
			</div>

			<div class="col-md-2 offset-md-2">
				<div class="form-group ">
					<input id="inputareainter" class="newalto form-control"
						maxlength="30"
						value="${dataForm.infObjetoDelineacion.infoDeclara.totalAreai}"
						disabled="disabled" readonly="readonly"></input>
				</div>
			</div>
		</div>
	</div>

	<!-- 	comienza tabla tres -->

	<div class="row mostrarMD">
		<div class="col-md-3">
			<label class="control-label format_label" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.areaproyin" /></label>
		</div>
		<div class="col-md-2">
			<label class="control-label format_label" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.aream2" /></label>
		</div>
	</div>


	<div class="row" id="divArearquitec">
		<c:forEach items="${dataForm.infObjetoDelineacion.areaProyecto}" var="varAreaIntervenida" varStatus="loop">
			<div class=" arearquitec row" id="arearquitec" style="display: block;">
				<div class="col-md-3">
					<div class="form-group ">
						<label class="control-label format_label mostrarXS" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.areaproyin" /></label>
						<sf:select
							path="infObjetoDelineacion.areaProyecto[${loop.index}].areaProy"
							items="${dataForm.catalogos.areaProy}"
							referenceData="${dataForm.catalogos.areaProy}"
							class="new_alto form-control areaProySelect"
							disabled="${disabledInformacionAreaUso}"></sf:select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label format_label mostrarXS" for="" style="text-transform: none !important"> <spring:theme code="delineacion.urbana.dec.areasusos.aream2" /></label>
						<sf:input class="newalto form-control areaProyInput"
							readonly="${disabledInformacionAreaUso}" aria-required="true"
							maxlength="240"
							path="infObjetoDelineacion.areaProyecto[${loop.index}].aream2" 
							onkeyup="numberFormat(this)" onclick="numberFormat(this)"/>
					</div>
				</div>
				<c:if test="${dataForm.controlCampos.informacionAreaUso != true}">
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareusotable2(this,'arearquitec')" src="${themeResourcePath}/images/adddelineacion.png" style="width: 25px"></img>
							<img onclick="deleinfoareusotable2(this,'arearquitec')" src="${themeResourcePath}/images/deledelineacion.png" style="width: 25px"></img>
						</div>
					</div>
				</c:if>
			</div>
		</c:forEach>
	</div>

	<div class="row">
		<div class="row totalnew">
			<div class="col-md-3">
				<div class="form-group ">
					<input class="new_alto form-control" maxlength="30" value="Total"
						disabled></input>
				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<input class="newalto form-control" maxlength="30"
						value="${dataForm.infObjetoDelineacion.infoDeclara.totalAreap}"
						disabled="disabled"></input>
				</div>
			</div>
		</div>
	</div>

</div>

<script>

	function addinfoareusotable2(elemento,seccion) {
		ACC.delineacionurbana.agregarRegistro(elemento,ACC.delineacionurbana.obtenerInfoElemento(seccion));

	}
	
	function deleinfoareusotable2(elemento,seccion) {
		ACC.delineacionurbana.borrarRegistro(elemento,ACC.delineacionurbana.obtenerInfoElemento(seccion));

	}
	
	
	function numberFormat(selectObject) {

		var numero = selectObject.value;
		var idinput = selectObject.id;
		var resultado = "";
		if (numero[0] == "-") {
			nuevoNumero = numero.replace(/\./g, '').substring(1);
		} else {
			nuevoNumero = numero.toString().replace(/\./g, '');
		}
		if (numero.toString().indexOf(",") >= 0)
			nuevoNumero = nuevoNumero.substring(0, nuevoNumero.indexOf(","));

		for (var j, i = nuevoNumero.length - 1, j = 0; i >= 0; i--, j++)
			resultado = nuevoNumero.charAt(i)
					+ ((j > 0) && (j % 3 == 0) ? "." : "") + resultado;
		if (numero.toString().indexOf(",") >= 0)
			resultado += numero.substring(numero.indexOf(","));

		if (numero[0] == "-") {
			document.getElementById(idinput).value = "-" + resultado;
			return "-" + resultado;
		} else {
			document.getElementById(idinput).value = resultado;
			return resultado;
		}
	}
</script>
