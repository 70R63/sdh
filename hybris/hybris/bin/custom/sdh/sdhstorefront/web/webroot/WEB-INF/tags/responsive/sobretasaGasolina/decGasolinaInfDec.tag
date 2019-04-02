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
<sf:form action="${declaracionURL}" method="POST" modelAttribute="dataForm" id="forma">

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
<div class="row">
	<div class="col-md-3">
		<label class="control-label text-capitalize !important" for="">
			<spring:theme
				code="impuestos.decGasolina.InformacionDec.claseProducto" />
		</label>
	</div>
	<div class="col-md-1">
		<label class="control-label text-capitalize !important" for="">
			<spring:theme code="impuestos.decGasolina.InformacionDec.galones" />
		</label>
	</div>
	<div class="col-md-2">
		<label class="control-label text-capitalize !important"><spring:theme
				code="impuestos.decGasolina.InformacionDec.preciosReferencia" /></label>
	</div>

	<div class="col-md-1">
		<label class="col-md-4 control-label text-capitalize !important"><spring:theme
				code="impuestos.decGasolina.InformacionDec.porcentajeAlcohol" /></label>
	</div>
	<div class="col-md-2">
		<label class="control-label text-capitalize !important"><spring:theme
				code="impuestos.decGasolina.InformacionDec.baseGravable" /></label>
	</div>
	<div class="col-md-2">
		<label class="control-label text-capitalize !important"><spring:theme
				code="impuestos.decGasolina.InformacionDec.valorSobretasa" /></label>
	</div>
	<div class="col-md-1">
		<div class="form-group ">
			<img onclick="addinformadeclara()"
				src="${themeResourcePath}/images/adddelineacion.png"
				style="width: 25px"></img> <img onclick="deleinformadeclara()"
				src="${themeResourcePath}/images/deledelineacion.png"
				style="width: 25px"></img>
		</div>
	</div>
</div>


<c:forEach items="${dataForm.dataForm.infoDeclara}" var="info"
	varStatus="loop">
	<div class="row informadeclara">

		<div class="col-md-3">
			<sf:select class="form-control-gasolina claseProducto"
				path="dataForm.infoDeclara[${loop.index}].claseProd"
				items="${dataForm.catalogosSo.claseProd}"
				referenceData="${dataForm.catalogosSo.claseProd}" maxlength="10" />
		</div>
		<div class="col-md-1">
			<sf:input path="dataForm.infoDeclara[${loop.index}].galonesGra"
				value="${info.galonesGra}" class="form-control form-control galones"
				maxlength="30" size="20" />
		</div>
		<div class="col-md-2">
			<sf:input path="dataForm.infoDeclara[${loop.index}].precioRef"
				value="${info.precioRef}" class="form-control form-control precio"
				maxlength="30" size="20" readonly="true" type="" />
		</div>
		<div class="col-sm-1">
			<sf:select path="dataForm.infoDeclara[${loop.index}].alcoholCarbu"
				items="${dataForm.catalogosSo.alcoholCarbu}"
				referenceData="${dataForm.catalogosSo.alcoholCarbu}"
				class="form-control alcohol" />
		</div>
		<div class="col-md-2">
			<sf:input path="dataForm.infoDeclara[${loop.index}].baseGravable"
				value="${info.baseGravable}" class="form-control form-control base"
				maxlength="30" size="20" readonly="true" />
		</div>
		<div class="col-md-2">
			<sf:input path="dataForm.infoDeclara[${loop.index}].vlrSobretasa"
				value="${info.vlrSobretasa}"
				class="form-control form-control vlrsobre" maxlength="30" size="20"
				readonly="true" />
		</div>
	</div>

</c:forEach>
</sf:form>


<sf:form action="${declaracionURL}" method="POST" modelAttribute="dataForm" id="forma">



<br>
<br>
<div class="row">
	<div class="col-md-12 col-md-offset-4">
		<div class="form-group ">
			<sf:button action="${presentarDeclaracionUrl}" type="submit"
				class="btn btn-primary btn-lg" id="action" name="action"
				value="calcular">
				<spring:theme code="impuestos.decGasolina.InformacionDec.calcular" />
			</sf:button>
		</div>
	</div>
</div>
</sf:form>
<div class="row"></div>

<script>
	function addinformadeclara() {
		
		var tam = $(".informadeclara").length;
		if ($(".informadeclara").length < 8) {
			
			$($(".informadeclara")[0]).parent().append($($(".informadeclara")[0]).clone());
			$($(".informadeclara")[0]).parent().children().last().find(".claseProducto").val("")
			$($(".informadeclara")[0]).parent().children().last().find(".galones").val("")
			$($(".informadeclara")[0]).parent().children().last().find(".precio").val("")
			$($(".informadeclara")[0]).parent().children().last().find(".alcohol").val("")
			$($(".informadeclara")[0]).parent().children().last().find(".base").val("")
			$($(".informadeclara")[0]).parent().children().last().find(".vlrsobre").val("")
		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function deleinformadeclara() {
		debugger;
		var i = $(".informadeclara").length;
		var val = i - 1;
		if ($(".informadeclara").length <= 8 && $(".informadeclara").length > 1) {

			$($(".informadeclara")[val]).closest(
					$($(".informadeclara")[val]).remove());

		} else if ($(".informadeclara").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}
</script>
