<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
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

<c:set var="disabledInformacionDeclaracion" value=""/>
<c:if test="${dataForm.controlCampos.informacionDeclaracion == true}">
	<c:set var="disabledInformacionDeclaracion" value="true"/>
</c:if>


<div class="container">
	<sf:form action="${declaracionURL}" method="POST"
		modelAttribute="dataForm" id="forma">

		<div class="row">
			<div class="col-md-6">
				<div class="hieadline">
					<h2>
						<span tabindex="0"><spring:theme
								code="impuestos.decGasolina.InformacionDec.titulo" /></span>
					</h2>
				</div>
			</div>
		</div>
		<div class="row mostrarMD">
			<div class="col-md-3">
				<label class="control-label format_label" for="">
					<spring:theme
						code="impuestos.decGasolina.InformacionDec.claseProducto" />
				</label>
			</div>
			<div class="col-md-1" style="padding-left: 12px;">
				<label class="control-label format_label" for="">
					<spring:theme code="impuestos.decGasolina.InformacionDec.galones" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label"><spring:theme
						code="impuestos.decGasolina.InformacionDec.preciosReferencia" /></label>
			</div>

			<div class="col-md-1" style="padding-left: 0px;">
				<label class="col-md-4 control-label format_label"><spring:theme
						code="impuestos.decGasolina.InformacionDec.porcentajeAlcohol" /></label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label"><spring:theme
						code="impuestos.decGasolina.InformacionDec.baseGravable" /></label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label"><spring:theme
						code="impuestos.decGasolina.InformacionDec.valorSobretasa" /></label>
			</div>
			<div class="col-md-1">
				<div class="form-group" style="display: flex">
<!-- 					<img onclick="addinformadeclara()" -->
<%-- 						src="${themeResourcePath}/images/adddelineacion.png" --%>
<!-- 						style="width: 25px"></img> <img onclick="deleinformadeclara()" -->
<%-- 						src="${themeResourcePath}/images/deledelineacion.png" --%>
<!-- 						style="width: 25px"></img> -->
				<c:if test="${empty disabledInformacionDeclaracion}">
					<button type="button" onclick="addinformadeclara()" class="btn btn-default btn-sm" style="font-size: 9px!important; border-color: green; background: green; padding: 5px; float: left">Agregar</button>
						<button type="button" onclick="deleinformadeclara()" class="btn btn-default btn-sm" style="font-size: 9px!important; border-color: red; background: red; padding: 5px; float: right; margin-left: 1px">Eliminar</button>
				</c:if>
				</div>
			</div>
	</div>

		<div class="">
			<input type='hidden' name='dataForm.dataForm.infoDeclara' value='' />
			<c:forEach items="${dataForm.dataForm.infoDeclara}" var="info"
				varStatus="loop">
				<div class="row informadeclara">

					<div class="col-md-3">
					<label class="control-label format_label mostrarXS" for="">
					<spring:theme
						code="impuestos.decGasolina.InformacionDec.claseProducto" />
				</label>
						<c:set var = "claseProd_id" value = 'dataForm.infoDeclara${loop.index}.claseProd'/>
						<sf:select class="new_alto form-control-gasolina claseProducto"
							path="dataForm.infoDeclara[${loop.index}].claseProd"
							items="${dataForm.catalogosSo.claseProd}"
							referenceData="${dataForm.catalogosSo.claseProd}" maxlength="10"
							style="width: 235px" onchange="getProductClassOccurrance(this)" id="${claseProd_id}" disabled="${disabledInformacionDeclaracion}" readonly="${disabledInformacionDeclaracion}" />
					</div>
					<div class="col-md-1">
					<label class="control-label format_label mostrarXS" for="">
					<spring:theme code="impuestos.decGasolina.InformacionDec.galones" />
				</label>
						<sf:input path="dataForm.infoDeclara[${loop.index}].galonesGra"
							value="${info.galonesGra}"
							class="new_alto form-control galones" maxlength="30"
							size="20" onkeyup="numberFormattable(this)" onclick="numberFormattable(this)" id="number1" readonly="${disabledInformacionDeclaracion}"/>
					</div>
					<div class="col-md-2">
					<label class="control-label format_label mostrarXS"><spring:theme
						code="impuestos.decGasolina.InformacionDec.preciosReferencia" /></label>
					
						<sf:input path="dataForm.infoDeclara[${loop.index}].precioRef"
							value="${info.precioRef}"
							class="new_alto form-control precio" maxlength="30" size="20"
							readonly="true" type=""/>
					</div>
					<div class="col-sm-1">
					<label class="col-md-4 control-label format_label mostrarXS"><spring:theme
						code="impuestos.decGasolina.InformacionDec.porcentajeAlcohol" /></label>
						<c:set var = "alcoholCarbu_id" value = 'dataForm.infoDeclara${loop.index}.alcoholCarbu'/>
						<c:choose>
							<c:when
								test="${info.claseProd eq '01' or info.claseProd eq '03'}">
								<sf:select
									path="dataForm.infoDeclara[${loop.index}].alcoholCarbu"
									items="${dataForm.catalogosSo.alcoholCarbu}"
									referenceData="${dataForm.catalogosSo.alcoholCarbu}"
									class="new_alto form-control-gasolina alcohol"
									readonly="true" style="width: auto !important;" id="${alcoholCarbu_id}"/>
							</c:when>
							<c:otherwise>
								<sf:select
									path="dataForm.infoDeclara[${loop.index}].alcoholCarbu"
									items="${dataForm.catalogosSo.alcoholCarbu}"
									referenceData="${dataForm.catalogosSo.alcoholCarbu}"
									class="new_alto form-control-gasolina alcohol"
									style="width: auto !important;" id="${alcoholCarbu_id}" disabled="${disabledInformacionDeclaracion}" readonly="${disabledInformacionDeclaracion}"/>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-2">
					<label class="control-label format_label mostrarXS"><spring:theme
						code="impuestos.decGasolina.InformacionDec.baseGravable" /></label>
						<sf:input path="dataForm.infoDeclara[${loop.index}].baseGravable"
							value="${info.baseGravable}"
							class="new_alto form-control base" maxlength="30" size="20"
							readonly="true" />
					</div>
					<div class="col-md-2">
					<label class="control-label format_label mostrarXS"><spring:theme
						code="impuestos.decGasolina.InformacionDec.valorSobretasa" /></label>
						<sf:input path="dataForm.infoDeclara[${loop.index}].vlrSobretasa"
							value="${info.vlrSobretasa}"
							class="new_alto form-control vlrsobre" maxlength="30"
							size="20" readonly="true" />
					</div>
					<div class="col-md-1">
				<c:if test="${empty disabledInformacionDeclaracion}">
				<div class="form-group mostrarXS" style="margin-top: 5px !important">
					<img onclick="addinformadeclara()"
						src="${themeResourcePath}/images/adddelineacion.png"
						style="width: 25px"></img> <img onclick="deleinformadeclara()"
						src="${themeResourcePath}/images/deledelineacion.png"
						style="width: 25px"></img>
				</div>
				</c:if>
			</div>
				</div>

			</c:forEach>
		</div>
		<br>
		<br>
		<c:if test="${empty disabledInformacionDeclaracion }">
			<div class="row">
				<div class="col-md-12 col-md-offset-4">
					<div class="form-group ">
						<sf:button action="${presentarDeclaracionUrl}" type="submit"
							class="btn btn-primary btn-lg" id="calcular" name="action"
							value="calcular">
							<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" />
						</sf:button>
					</div>
				</div>
			</div>
		</c:if>
	</sf:form>
	<div class="row"></div>
</div>

<script>
	function getProductClassOccurrance(currentSelected) {
		var seleccion = currentSelected.value;
		var idModificar = currentSelected.id;
		idModificar = idModificar.replace('.claseProd','.alcoholCarbu');
		
		if(seleccion == '01' || seleccion == '03'){
			document.getElementById(idModificar).disabled = true;
		}else{
			document.getElementById(idModificar).disabled = false;			
		}
		
		var map = new Map();
		var mapMaxOcc = new Map();
		var tableLength = $(".informadeclara").length;
		var maxOcc = '${productClassMaximumOccurrencies}';

		maxOcc = maxOcc.replace('{', '');
		maxOcc = maxOcc.replace('}', '');
		maxOcc = maxOcc.replace(' ', '');
		maxOcc = maxOcc.split(',');

		for (var i = 0; i < tableLength; i++) {
			var productClass = document.getElementById("dataForm.infoDeclara"
					+ i + ".claseProd").value;
			if (map.has(productClass)) {
				var productClassCounter = map.get(productClass)
				map.set(productClass, productClassCounter + 1);
			} else {
				map.set(productClass, 1);
			}
		}

		for (var i = 0; i < maxOcc.length; i++) {
			var item = maxOcc[i];
			item = item.split("=");
			mapMaxOcc.set(item[0], item[1]);
		}

		if (mapMaxOcc.has(currentSelected.value)) {
			var maxOccuNum = Number(mapMaxOcc.get(currentSelected.value)) + 1;
			if (map.get(currentSelected.value) == maxOccuNum) {
				alert("Excedido número de entradas permitidas");
				currentSelected.value = 0;
			}
		}
	}

	function addinformadeclara() {

		var tam = $(".informadeclara").length;

		if ($(".informadeclara").length < 55) {

			$($(".informadeclara")[0]).parent().append(
					$($(".informadeclara")[0]).clone());
			$($(".informadeclara")[0]).parent().children().last().find(
					".claseProducto").val("")
			$($(".informadeclara")[0]).parent().children().last().find(
					".galones").val("")
			$($(".informadeclara")[0]).parent().children().last().find(
					".precio").val("")
			$($(".informadeclara")[0]).parent().children().last().find(
					".alcohol").val("")
			$($(".informadeclara")[0]).parent().children().last().find(".base")
					.val("")
			$($(".informadeclara")[0]).parent().children().last().find(
					".vlrsobre").val("")

			$($(".informadeclara")[0]).parent().children().last().find(
					".claseProducto").attr("id",
					"dataForm.infoDeclara" + tam + ".claseProd");
			$($(".informadeclara")[0]).parent().children().last().find(
					".galones").attr("id",
					"dataForm.infoDeclara" + tam + ".galonesGra");
			$($(".informadeclara")[0]).parent().children().last().find(
					".precio").attr("id",
					"dataForm.infoDeclara" + tam + ".precioRef");
			$($(".informadeclara")[0]).parent().children().last().find(
					".alcohol").attr("id",
					"dataForm.infoDeclara" + tam + ".alcoholCarbu");
			$($(".informadeclara")[0]).parent().children().last().find(".base")
					.attr("id", "dataForm.infoDeclara" + tam + ".baseGravable");
			$($(".informadeclara")[0]).parent().children().last().find(
					".vlrsobre").attr("id",
					"dataForm.infoDeclara" + tam + ".vlrSobretasa");

			$($(".informadeclara")[0]).parent().children().last().find(
					".claseProducto").attr("name",
					"dataForm.infoDeclara[" + tam + "].claseProd");
			$($(".informadeclara")[0]).parent().children().last().find(
					".galones").attr("name",
					"dataForm.infoDeclara[" + tam + "].galonesGra");
			$($(".informadeclara")[0]).parent().children().last().find(
					".precio").attr("name",
					"dataForm.infoDeclara[" + tam + "].precioRef");
			$($(".informadeclara")[0]).parent().children().last().find(
					".alcohol").attr("name",
					"dataForm.infoDeclara[" + tam + "].alcoholCarbu");
			$($(".informadeclara")[0]).parent().children().last().find(".base")
					.attr("name",
							"dataForm.infoDeclara[" + tam + "].baseGravable");
			$($(".informadeclara")[0]).parent().children().last().find(
					".vlrsobre").attr("name",
					"dataForm.infoDeclara[" + tam + "].vlrSobretasa");
		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function deleinformadeclara() {
		debugger;
		var i = $(".informadeclara").length;
		var val = i - 1;
		if ($(".informadeclara").length <= 55
				&& $(".informadeclara").length > 1) {

			$($(".informadeclara")[val]).closest(
					$($(".informadeclara")[val]).remove());

		} else if ($(".informadeclara").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}
</script>
