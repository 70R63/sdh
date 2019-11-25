<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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
		<!-- 			<div class="col-md-3"> -->
		<%-- 				<label class="control-label" for=""> <spring:theme --%>
		<%-- 						code="delineacion.urbana.dec.areasusos.uso" /> --%>
		<!-- 				</label> -->
		<!-- 			</div> -->
		<div class="col-md-3">
			<label class="control-label format_label" for=""
				style="text-transform: none !important"> <spring:theme
					code="delineacion.urbana.dec.areasusos.uso" />
			</label>
		</div>
		<div class="col-md-2">
			<label class="control-label format_label" for=""
				style="text-transform: none !important"> <spring:theme
					code="delineacion.urbana.dec.areasusos.netuso" /></label>
		</div>
	</div>

	<!-- LINEA DE USO -->
	<c:forEach items="${dataForm.infObjetoDelineacion.usos}" var="info"
		varStatus="loop">
		<div class="row">
			<div class="row areasusos">
				<!-- 					<div class="col-md-3"> -->
				<!-- 						<div class="form-group "> -->
				<%-- 							<sf:select --%>
				<%-- 								path="infObjetoDelineacion.usos[${loop.index}].usoCatalogo" --%>
				<%-- 								items="${dataForm.catalogos.uso}" --%>
				<%-- 								referenceData="${dataForm.catalogos.uso}" class="form-control"></sf:select> --%>
				<!-- 						</div> -->

				<!-- 					</div> -->

				<div class="col-md-3">
					<div class="form-group ">
						<c:if test='${dataForm.input.tipoFlujo == "D"}'>
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].uso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="new_alto form-control" disabled="false"></sf:select>
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].uso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="new_alto form-control" disabled="false"></sf:select>
						</c:if>

					</div>
				</div>


				<div class="col-md-2">
					<div class="form-group ">
						<c:if test='${dataForm.input.tipoFlujo == "D"}'>
							<sf:input class="newalto form-control" readonly="false"
								aria-required="true" maxlength="240"
								path="infObjetoDelineacion.usos[${loop.index}].areaNeta"
								onkeyup="numberFormat(this)" onclick="numberFormat(this)" disabled="false" />
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:input class="newalto form-control" readonly="false"
								aria-required="true" maxlength="240"
								path="infObjetoDelineacion.usos[${loop.index}].areaNeta"
								 disabled="false" onkeyup="numberFormat(this)"
								onclick="numberFormat(this)" />
						</c:if>
					</div>
				</div>


				<c:if test='${dataForm.input.tipoFlujo == "D"}'>
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareuso()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deleinfoareuso()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</c:forEach>


	<!-- LINEA DE TOTAL - USO -->
	<div class="row">
		<div class="row total">
			<div class="col-md-3">
				<div class="form-group ">
					<input id="inputareainter" class="new_alto form-control"
						maxlength="30" value="Total" disabled="disabled" readonly="readonly"></input>
				</div>
			</div>

			<div class="col-md-2 offset-md-3">
				<div class="form-group ">
					<sf:input id="inputareainter" class="newalto form-control"
						maxlength="30" path="infObjetoDelineacion.infoDeclara.totalUsos"  disabled="true"></sf:input>
				</div>
			</div>
		</div>
	</div>



	<!-- 	comienza tabla dos -->

	<div class="row">
		<div class="row">
			<div class="col-md-3">
				<label class="control-label format_label" for=""
					style="text-transform: none !important"> <spring:theme
						code="delineacion.urbana.dec.areasusos.areainve" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label" for=""
					style="text-transform: none !important"> <spring:theme
						code="delineacion.urbana.dec.areasusos.m2area" />
				</label>
			</div>
		</div>
	</div>

	<c:forEach items="${dataForm.infObjetoDelineacion.areaIntervenida}"
		var="varAreaIntervenida" varStatus="loop">
		<div class="row">
			<div class="row areausosdos">
				<div class="col-md-3">
					<div class="form-group ">
						<sf:select
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].areaInter"
							items="${dataForm.catalogos.areaInter}"
							referenceData="${dataForm.catalogos.areaInter}"
							class="new_alto form-control"></sf:select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<sf:input class="newalto form-control" readonly="false"
							aria-required="true" maxlength="240"
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].aream2"
							onkeyup="numberFormat(this)" onclick="numberFormat(this)" />
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
	</c:forEach>


	<div class="row">
		<div class="row total">
			<div class="col-md-3">
				<div class="form-group ">
					<input id="inputareainter" class="new_alto form-control"
						maxlength="30" value="Total" disabled="disabled" readonly="readonly"></input>
				</div>
			</div>

			<div class="col-md-2 offset-md-2">
				<div class="form-group ">
					<input id="inputareainter" class="newalto form-control"
						maxlength="30"
						value="${dataForm.infObjetoDelineacion.infoDeclara.totalAreai}" disabled="disabled" readonly="readonly"></input>
				</div>
			</div>
		</div>
	</div>

	<!-- 	comienza tabla tres -->

	<div class="row">

		<div class="col-md-3">

			<label class="control-label format_label" for=""
				style="text-transform: none !important"> <spring:theme
					code="delineacion.urbana.dec.areasusos.areaproyin" />
			</label>
		</div>
		<div class="col-md-2">

			<label class="control-label format_label" for=""
				style="text-transform: none !important"> <spring:theme
					code="delineacion.urbana.dec.areasusos.aream2" />
			</label>

		</div>
	</div>


	<c:forEach items="${dataForm.infObjetoDelineacion.areaProyecto}"
		var="varAreaIntervenida" varStatus="loop">
		<div class="row">
			<div class=" arearquitec row" id="arearquitec"> 
				<div class="col-md-3">
					<div class="form-group ">
						<sf:select
							path="infObjetoDelineacion.areaProyecto[${loop.index}].areaProy"
							items="${dataForm.catalogos.areaProy}"
							referenceData="${dataForm.catalogos.areaProy}"
							class="new_alto form-control"></sf:select>
					</div>

				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<sf:input class="newalto form-control" readonly="false"
							aria-required="true" maxlength="240"
							path="infObjetoDelineacion.areaProyecto[${loop.index}].aream2" />
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
	</c:forEach>

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
						value="${dataForm.infObjetoDelineacion.infoDeclara.totalAreap}" disabled="true"></input>
				</div>
			</div>
		</div>
	</div>

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
		}else{
			alert("No puede agregar más registros");
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
debugger;
if ($(".arearquitec").length < 10000) {
	$($(".arearquitec")[0]).parent()
			.append($($(".arearquitec")[0]).clone());

// 	$($(".areasusos")[0]).parent().children().last().find(".select1")
// 			.val("")
// 	$($(".areasusos")[0]).parent().children().last().find(".select2")
// 			.val("")
// 	$($(".areasusos")[0]).parent().children().last().find(".input1")
// 			.val("")
// 	$($(".areasusos")[0]).parent().children().last().find(".input2")
// 			.val("M2")
}else{
	alert("No puede agregar más registros");
}

	}

	function deleinfoareusotable2() {
		debugger;
		var i = $(".arearquitec").length;
		var val = i - 1;
		if ($(".arearquitec").length <= 10000 && $(".arearquitec").length > 1) {

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
		}else{
			alert("No puede agregar más registros");
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
