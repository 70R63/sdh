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

	<div class="col-md-12">

		<div class="row">
			<!-- 			<div class="col-md-3"> -->
			<%-- 				<label class="control-label" for=""> <spring:theme --%>
			<%-- 						code="delineacion.urbana.dec.areasusos.uso" /> --%>
			<!-- 				</label> -->
			<!-- 			</div> -->
			<div class="col-md-3">
				<label class="control-label" for=""> <spring:theme
						code="delineacion.urbana.dec.areasusos.uso" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label" for=""> <spring:theme
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
							<sf:select path="infObjetoDelineacion.usos[${loop.index}].codUso"
								items="${dataForm.catalogos.codUso}"
								referenceData="${dataForm.catalogos.codUso}"
								class="form-control"></sf:select>
						</div>
					</div>


					<div class="col-md-2">
						<div class="form-group ">
							<sf:input class="form-control" readonly="false"
								aria-required="true" maxlength="240"
								path="infObjetoDelineacion.usos[${loop.index}].areaNeta" />
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
						<input id="inputareainter" class="form-control" maxlength="30"
							value="Total" disabled></input>
					</div>
				</div>

				<div class="col-md-2 offset-md-3">
					<div class="form-group ">
						<input id="inputareainter" class="form-control" maxlength="30"
							value="${dataForm.infObjetoDelineacion.infoDeclara.totalUsos}"></input>
					</div>
				</div>
			</div>
		</div>










		<!-- 	comienza tabla dos -->
		<br> <br>
		<div class="row">
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
		</div>

		<c:forEach items="${dataForm.infObjetoDelineacion.areaIntervenida}"
			var="varAreaIntervenida" varStatus="loop">
			<div class="row">
				<div class="col-md-5">
					<div class="form-group ">
						<sf:select
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].areaInter"
							items="${dataForm.catalogos.areaInter}"
							referenceData="${dataForm.catalogos.areaInter}"
							class="form-control"></sf:select>
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group ">
						<sf:input class="form-control" readonly="false"
							aria-required="true" maxlength="240"
							path="infObjetoDelineacion.areaIntervenida[${loop.index}].aream2" />
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

		</c:forEach>


		<div class="row">
			<div class="row total">
				<div class="col-md-5">
					<div class="form-group ">
						<input id="inputareainter" class="form-control" maxlength="30"
							value="Total" disabled></input>
					</div>
				</div>

				<div class="col-md-3 offset-md-3">
					<div class="form-group ">
						<input id="inputareainter" class="form-control" maxlength="30"
							value="${dataForm.infObjetoDelineacion.infoDeclara.totalAreai}"></input>
					</div>
				</div>
			</div>
		</div>







		<!-- 	comienza tabla tres -->
		<br> <br>
		<div class="row">
			<div class="col-md-3">

				<label class="control-label" for=""> <spring:theme
						code="delineacion.urbana.dec.areasusos.areaproyin" />
				</label>
			</div>
			<div class="col-md-3">

				<label class="control-label" for=""> <spring:theme
						code="delineacion.urbana.dec.areasusos.aream2" />
				</label>

			</div>
		</div>


		<c:forEach items="${dataForm.infObjetoDelineacion.areaProyecto}"
			var="varAreaIntervenida" varStatus="loop">
			<div class="row">
				<div class="row arearquitec">
					<div class="col-md-3">
						<div class="form-group ">
							<sf:select
								path="infObjetoDelineacion.areaProyecto[${loop.index}].areaProy"
								items="${dataForm.catalogos.areaProy}"
								referenceData="${dataForm.catalogos.areaProy}"
								class="form-control"></sf:select>
						</div>

					</div>

					<div class="col-md-3">
						<div class="form-group ">
							<sf:input class="form-control" readonly="false"
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
						<input class="form-control" maxlength="30" value="Total" disabled></input>
					</div>
				</div>

				<div class="col-md-3">
					<div class="form-group ">
						<input class="form-control" maxlength="30"
							value="${dataForm.infObjetoDelineacion.infoDeclara.totalAreap}"></input>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>

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
		}

	}
	function deleinfoareuso() {
		var i = $(".areasusos").length;
		var val = i - 1;
		if ($(".areasusos").length <= 3 && $(".areasusos").length > 1) {

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

		if ($(".areausosdos").length < 3) {
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
		if ($(".areausosdos").length <= 3 && $(".areausosdos").length > 1) {

			$($(".areausosdos")[val]).closest(
					$($(".areausosdos")[val]).remove());

		} else if ($(".areausosdos").length <= 1) {
			alert("No puede eliminar todos los registros");
		}

	}
</script>
