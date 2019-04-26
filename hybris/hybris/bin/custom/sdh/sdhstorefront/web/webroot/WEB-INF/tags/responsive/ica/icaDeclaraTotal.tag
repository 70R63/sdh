<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }" var="infoDeclara" />
<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.total.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>
<br>
<form:form action="">
	<div class="container">
		<div class="row">
			<div class="col-md-1">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.total.actprinci" />
				</label>
			</div>
			<div class="col-md-3">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.total.denomi" />
				</label>
			</div>
			<div class="col-md-3">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.total.ingnet" />
				</label>
			</div>
		</div>
		<c:forEach items="${infoDeclara.ingNetosGrava }" var="eachIngreso">
			<div class="row totaluno">
					<div class="col-md-1">
						<c:choose>
						<c:when test="${eachIngreso.actPrincipal eq 'X' }">
						<input type="checkbox" name=""
							class="form-check-input mr-2 actividad actPrincipal"
							style="visibility: visible !important; min-height: 4px !important; width: 20px;"
							size="10" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="checkbox" name=""
							class="form-check-input mr-2 actividad actPrincipal"
							style="visibility: visible !important; min-height: 4px !important; width: 20px;"
							size="10" >
						</c:otherwise>
						</c:choose>
					</div>
		
					<div class="col-md-3">
						<input class="form-control denomina codCIIU" type="text" value="${eachIngreso.codCIIU}"/>
					</div>
					<div class="col-md-3">
						<input class="form-control ingreso ingresos" type="text" value="${eachIngreso.ingresos}"/>
					</div>
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addtotaluno()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img onclick="deletotaluno()"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
			</div>
			</c:forEach>
	</div>

	<br>
	<div class="row">
		<div class="col-md-1">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme code="ica.declaracion.total.angrava" />
			</label>
		</div>
		<div class="col-md-1">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme code="ica.declaracion.total.tipdoc" />
			</label>
		</div>
		<div class="col-md-1">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme code="ica.declaracion.total.numide" />
			</label>
		</div>
		<div class="col-md-2">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme code="ica.declaracion.total.nombre" />
			</label>
		</div>
		<div class="col-md-1">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme code="ica.declaracion.total.direc" />
			</label>
		</div>
		<div class="col-md-1">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme code="ica.declaracion.total.tel" />
			</label>
		</div>
		<div class="col-md-2">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme code="ica.declaracion.total.denomi" />
			</label>
		</div>
		<div class="col-md-1">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme
					code="ica.declaracion.total.valtotaliva" />
			</label>
		</div>
		<div class="col-md-1">
			<label class="control-label" style="text-transform: none !important"
				for=""> <spring:theme
					code="ica.declaracion.total.valtotaldev" />
			</label>
		</div>
	</div>
	<div class="row totaldos">
		<div class="col-md-1">
			<input class="form-control anoGravable" type="text" />
		</div>


		<div class="col-md-1">
			<select id="" class="form-control tipoID" style="height: 48px;">
				<option value="0">Seleccionar</option>
				<option value="CC">CC Cédula de ciudadania</option>
				<option value="CE">CE Cédula de extranjería</option>
				<option value="NIT">NIT Número de identificación tributaria</option>
				<option value="PA">PA Pasaporte</option>
				<option value="TI">TI Tarjeta de identidad</option>
				<option value="TIE">TIE Tarjeta de identidad de extranjero</option>
				<option value="NITE">NITE NIT extranjero</option>
				<option value="NUIP">NUIP Número único de identificación
					personal</option>
			</select>
		</div>
		<div class="col-md-1">
			<input class="form-control numID" type="text" />
		</div>
		<div class="col-md-2">
			<input class="form-control razonSocial" type="text" />
		</div>
		<div class="col-md-1">
			<input class="form-control direccion" type="text" />
		</div>
		<div class="col-md-1">
			<input class="form-control telefono" type="text" />
		</div>
		<div class="col-md-2">
			<select id="" class="form-control codCIIU" style="height: 48px;">
				<option value=" ">Seleccionar</option>
			</select>
		</div>
		<div class="col-md-1">
			<input class="form-control ingBrutoSINIVA" type="text" />
		</div>
		<div class="col-md-1">
			<input class="form-control valorTotalDevol" type="text" />
		</div>
		<div class="col-md-1">
			<div class="form-group ">
				<img onclick="addtotaldos()"
					src="${themeResourcePath}/images/adddelineacion.png"
					style="width: 25px"></img> <img onclick="deletotaldos()"
					src="${themeResourcePath}/images/deledelineacion.png"
					style="width: 25px"></img>
			</div>
		</div>
	</div>
</form:form>


<script>
	function addtotaluno() {

		var tam = $(".totaluno").length;
		if ($(".totaluno").length < 20) {
			$($(".totaluno")[0]).parent().append($($(".totaluno")[0]).clone());
			$($(".totaluno")[0]).parent().children().last().find(".actividad")
					.val("")
			$($(".totaluno")[0]).parent().children().last().find(".denomina")
					.val("")
			$($(".totaluno")[0]).parent().children().last().find(".ingreso")
					.val("")

		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function deletotaluno() {
		var i = $(".totaluno").length;
		var val = i - 1;
		if ($(".totaluno").length <= 20 && $(".totaluno").length > 1) {

			$($(".totaluno")[val]).closest($($(".totaluno")[val]).remove());

		} else if ($(".totaluno").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}

	function addtotaldos() {

		var tam = $(".totaldos").length;
		if ($(".totaldos").length < 20) {
			$($(".totaldos")[0]).parent().append($($(".totaldos")[0]).clone());
			$($(".totaldos")[0]).parent().children().last().find(".anio").val(
					"")
			$($(".totaldos")[0]).parent().children().last().find(".tipo").val(
					"")
			$($(".totaldos")[0]).parent().children().last().find(".numiden")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".nombre")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".direc").val(
					"")
			$($(".totaldos")[0]).parent().children().last().find(".telefono")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".denoact")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".valbrut")
					.val("")
			$($(".totaldos")[0]).parent().children().last().find(".valtotal")
					.val("")

		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function deletotaldos() {
		var i = $(".totaldos").length;
		var val = i - 1;
		if ($(".totaldos").length <= 20 && $(".totaldos").length > 1) {

			$($(".totaldos")[val]).closest($($(".totaldos")[val]).remove());

		} else if ($(".totaldos").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}
</script>