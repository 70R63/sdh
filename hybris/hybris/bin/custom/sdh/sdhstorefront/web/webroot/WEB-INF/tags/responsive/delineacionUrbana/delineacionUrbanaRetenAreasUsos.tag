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


	<div class="row mostrarMD">
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
		<div class="row mostrarMD">
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
								class="new_alto form-control"
								disabled="${disabledInformacionAreaUso}"></sf:select>
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].uso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="new_alto form-control"
								disabled="${disabledInformacionAreaUso}"></sf:select>
						</c:if>

					</div>
				</div>


				<div class="col-md-2">
					<div class="form-group ">
						<c:if test='${dataForm.input.tipoFlujo == "D"}'>
							<sf:input class="newalto form-control"
								readonly="${disabledInformacionAreaUso}" aria-required="true"
								maxlength="240"
								path="infObjetoDelineacion.usos[${loop.index}].areaNeta"
								onkeyup="numberFormat(this)" onclick="numberFormat(this)"
								disabled="false" />
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:input class="newalto form-control"
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
								<img onclick="addinfoareuso()"
									src="${themeResourcePath}/images/adddelineacion.png"
									style="width: 25px"></img> <img onclick="deleinfoareuso()"
									src="${themeResourcePath}/images/deledelineacion.png"
									style="width: 25px"></img>
							</div>
						</div>
					</c:if>
					<c:if test='${dataForm.input.tipoFlujo == "R"}'>
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
				</c:if>
			</div>
		</div>

		<div class="row mostrarXS">
			<div class="row areasusos">
				<div class="col-md-3">
					<div class="form-group ">
						<label class="control-label format_label" for=""
							style="text-transform: none !important"> <spring:theme
								code="delineacion.urbana.dec.areasusos.uso" />
						</label>
						<c:if test='${dataForm.input.tipoFlujo == "D"}'>
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].uso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="new_alto form-control"
								disabled="${disabledInformacionAreaUso}"></sf:select>
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].uso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="new_alto form-control"
								disabled="${disabledInformacionAreaUso}"></sf:select>
						</c:if>

					</div>
				</div>


				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label format_label" for=""
							style="text-transform: none !important"> <spring:theme
								code="delineacion.urbana.dec.areasusos.netuso" /></label>
						<c:if test='${dataForm.input.tipoFlujo == "D"}'>
							<sf:input class="newalto form-control"
								readonly="${disabledInformacionAreaUso}" aria-required="true"
								maxlength="240"
								path="infObjetoDelineacion.usos[${loop.index}].areaNeta"
								onkeyup="numberFormat(this)" onclick="numberFormat(this)"
								disabled="false" />
						</c:if>
						<c:if test='${dataForm.input.tipoFlujo == "R"}'>
							<sf:input class="newalto form-control"
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
								<img onclick="addinfoareuso()"
									src="${themeResourcePath}/images/adddelineacion.png"
									style="width: 25px"></img> <img onclick="deleinfoareuso()"
									src="${themeResourcePath}/images/deledelineacion.png"
									style="width: 25px"></img>
							</div>
						</div>
					</c:if>
					<c:if test='${dataForm.input.tipoFlujo == "R"}'>
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
						maxlength="30" value="Total" disabled="disabled"
						readonly="readonly"></input>
				</div>
			</div>

			<div class="col-md-2 offset-md-3">
				<div class="form-group ">
					<sf:input id="inputareainter" class="newalto form-control"
						maxlength="30" path="infObjetoDelineacion.infoDeclara.totalUsos"
						disabled="true"></sf:input>
				</div>
			</div>
		</div>
	</div>



	<!-- 	comienza tabla dos -->

	<div class="row mostrarMD">
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
		<div class="row mostrarMD">
			<div class="row areausosdos">
				<div class="col-md-3">
					<div class="form-group ">
						<sf:select id="select"
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].areaInter"
							items="${dataForm.catalogos.areaInter}"
							referenceData="${dataForm.catalogos.areaInter}"
							class="new_alto form-control"
							disabled="${disabledInformacionAreaUso}"></sf:select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<sf:input class="newalto form-control"
							readonly="${disabledInformacionAreaUso}" aria-required="true"
							maxlength="240"
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].aream2"
							onkeyup="numberFormat(this)" onclick="numberFormat(this)" />
					</div>
				</div>
				<c:if test="${dataForm.controlCampos.informacionAreaUso != true}">
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareuso3()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deleinfoareusotable3()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div class="row mostrarXS">
			<div class="row areausosdos">
				<div class="col-md-3">
					<div class="form-group ">
						<label class="control-label format_label" for=""
							style="text-transform: none !important"> <spring:theme
								code="delineacion.urbana.dec.areasusos.areainve" />
						</label>
						<sf:select id="select"
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].areaInter"
							items="${dataForm.catalogos.areaInter}"
							referenceData="${dataForm.catalogos.areaInter}"
							class="new_alto form-control"
							disabled="${disabledInformacionAreaUso}"></sf:select>
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label format_label" for=""
							style="text-transform: none !important"> <spring:theme
								code="delineacion.urbana.dec.areasusos.m2area" />
						</label>
						<sf:input class="newalto form-control"
							readonly="${disabledInformacionAreaUso}" aria-required="true"
							maxlength="240"
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].aream2"
							onkeyup="numberFormat(this)" onclick="numberFormat(this)" />
					</div>
				</div>
				<c:if test="${dataForm.controlCampos.informacionAreaUso != true}">
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareuso3()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deleinfoareusotable3()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</c:forEach>


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
		<div class="row mostrarMD">
			<div class=" arearquitec row" id="arearquitec">
				<div class="col-md-3">
					<div class="form-group ">
						<sf:select
							path="infObjetoDelineacion.areaProyecto[${loop.index}].areaProy"
							items="${dataForm.catalogos.areaProy}"
							referenceData="${dataForm.catalogos.areaProy}"
							class="new_alto form-control"
							disabled="${disabledInformacionAreaUso}"></sf:select>
					</div>

				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<sf:input class="newalto form-control"
							readonly="${disabledInformacionAreaUso}" aria-required="true"
							maxlength="240"
							path="infObjetoDelineacion.areaProyecto[${loop.index}].aream2" />
					</div>
				</div>

				<c:if test="${dataForm.controlCampos.informacionAreaUso != true}">
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareusotable2()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deleinfoareusotable2()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
				</c:if>
			</div>
		</div>

		<div class="row mostrarXS">
			<div class=" arearquitec row" id="arearquitec">
				<div class="col-md-3">
					<div class="form-group ">
						<label class="control-label format_label" for=""
							style="text-transform: none !important"> <spring:theme
								code="delineacion.urbana.dec.areasusos.areaproyin" />
						</label>
						<sf:select
							path="infObjetoDelineacion.areaProyecto[${loop.index}].areaProy"
							items="${dataForm.catalogos.areaProy}"
							referenceData="${dataForm.catalogos.areaProy}"
							class="new_alto form-control"
							disabled="${disabledInformacionAreaUso}"></sf:select>
					</div>

				</div>

				<div class="col-md-2">
					<div class="form-group ">
						<label class="control-label format_label" for=""
							style="text-transform: none !important"> <spring:theme
								code="delineacion.urbana.dec.areasusos.aream2" />
						</label>
						<sf:input class="newalto form-control"
							readonly="${disabledInformacionAreaUso}" aria-required="true"
							maxlength="240"
							path="infObjetoDelineacion.areaProyecto[${loop.index}].aream2" />
					</div>
				</div>

				<c:if test="${dataForm.controlCampos.informacionAreaUso != true}">
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addinfoareusotable2()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deleinfoareusotable2()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
				</c:if>
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
						value="${dataForm.infObjetoDelineacion.infoDeclara.totalAreap}"
						disabled="true"></input>
				</div>
			</div>
		</div>
	</div>

</div>

<script>
	function addinfoareuso() {
		if ($(".areasusos").length < 10000) {

			var tam = $(".areasusos").length;
			var i = tam - 1;
			$($(".areasusos")[i]).parent()
					.append($($(".areasusos")[i]).clone()) //.find('select').val("00"));

			for (var j = 0; j <= tam; j++) {
				var arr = $(".areasusos");
				if (j == tam) {

					$($(".areasusos")[j]).find('select').val("00");
					var area = $($(".areasusos")[j]).find('select');
					var nom = "infObjetoDelineacion.usos[" + tam + "].uso";
					var nomid = "infObjetoDelineacion.usos" + tam + ".uso";
					area.attr("name", nom);
					area.attr("id", nomid);

					$($(".areasusos")[j]).find('input').val("");
					var areainp = $($(".areasusos")[j]).find('input');
					var nom2 = "infObjetoDelineacion.usos[" + tam
							+ "].areaNeta";
					var nomid2 = "infObjetoDelineacion.usos" + tam
							+ ".areaNeta";
					areainp.attr("name", nom2);
					areainp.attr("id", nomid2);

				}
			}
		} else {
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

		var tam = $(".arearquitec").length;
		var i = tam - 1;
		if ($(".arearquitec").length < 10000) {
			$($(".arearquitec")[i]).parent().append(
					$($(".arearquitec")[i]).clone());

			for (var j = 0; j <= tam; j++) {
				var arr = $(".arearquitec");
				if (j == tam) {

					$($(".arearquitec")[j]).find('select').val("00");
					var area = $($(".arearquitec")[j]).find('select');
					var nom = "infObjetoDelineacion.areaProyecto[" + tam
							+ "].areaProy";
					var nomid = "infObjetoDelineacion.areaProyecto" + tam
							+ ".areaProy";
					area.attr("name", nom);
					area.attr("id", nomid);

					$($(".arearquitec")[j]).find('input').val("");
					var areainp = $($(".arearquitec")[j]).find('input');
					var nom2 = "infObjetoDelineacion.areaProyecto[" + tam
							+ "].aream2";
					var nomid2 = "infObjetoDelineacion.areaProyecto" + tam
							+ ".aream2";
					areainp.attr("name", nom2);
					areainp.attr("id", nomid2);

				}
			}

		} else {
			alert("No puede agregar más registros");
		}

	}

	function deleinfoareusotable2() {

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

		var tam = $(".areausosdos").length;
		var i = tam - 1;
		if ($(".areausosdos").length < 10000) {
			$($(".areausosdos")[i]).parent().append(
					$($(".areausosdos")[i]).clone());

			for (var j = 0; j <= tam; j++) {
				var arr = $(".areausosdos");
				if (j == tam) {

					$($(".areausosdos")[j]).find('select').val("00");
					var areau = $($(".areasusosdos")[j]).find('select');
					var nom = "infObjetoDelineacion.areaIntervenida[" + tam
							+ "].areaInter";
					var nomid = "infObjetoDelineacion.areaIntervenida" + tam
							+ ".areaInter";
					$($(".areausosdos")[j]).find('select').attr("name", nom);
					$($(".areausosdos")[j]).find('select').attr("id", nomid);

					$($(".areausosdos")[j]).find('input').val("");
					var areainpu = $($(".areasusosdos")[j]).find('input');
					var nom2 = "infObjetoDelineacion.areaIntervenida[" + tam
							+ "].aream2";
					var nomid2 = "infObjetoDelineacion.areaIntervenida" + tam
							+ ".aream2";
					$($(".areausosdos")[j]).find('input').attr("name", nom2);
					$($(".areausosdos")[j]).find('input').attr("id", nomid2);

				}
			}
		} else {
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
