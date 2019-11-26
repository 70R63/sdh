<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }"
	var="infoDeclara" />
<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.valor.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>
<br>

<div class="row mt-3">
	<div class="col-md-8 col-md-offset-2 d-flex align-items-center">
		<spring:theme code="ica.declaracion.valor.descripcion1" />
	</div>
</div>

<br>

<form:form action="">
	<div>
		<div class="row">
			<div class="col-md-1" style="width: 10.5% !important">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.angrav" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.tipdoc" />
				</label>
			</div>
			<div class="col-md-1">
				<label style=" text-transform: none !important;" class="control-label format_label"
					for=""> <spring:theme code="ica.declaracion.valor.numide" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.nombre" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme
						code="ica.declaracion.valor.direccion" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.tel" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme
						code="ica.declaracion.valor.municipio" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme
						code="ica.declaracion.valor.taraplicada" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label format_label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.montoret" />
				</label>
			</div>
		</div>

		<!--  se agregan l�neas para agregar siempre una linea en la tabla -->
		<c:if test="${empty infoDeclara.valorRetenido}">
			<div class="row valor" id="valor">
				<div class="col-md-1" style="width: 10.5% !important">
					<input class=" new_alto_anio form-control anio anoGravable "
						type="date" value="${infoDeclara.anoGravable }" />
				</div>
				<div class="col-md-2">
					<select id="" class="etiq_valor form-control tipoID"
						style="height: 48px;">
						<option value="">Seleccionar</option>
						<option value="CC">CC C�dula de ciudadania</option>
						<option value="CE">CE C�dula de extranjer�a</option>
						<option value="NIT">NIT N�mero de identificaci�n
							tributaria</option>
						<option value="PA">PA Pasaporte</option>
						<option value="TI">TI Tarjeta de identidad</option>
						<option value="TIE">TIE Tarjeta de identidad de
							extranjero</option>
						<option value="NITE">NITE NIT extranjero</option>
						<option value="NUIP">NUIP N�mero �nico de identificaci�n
							personal</option>
					</select>
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control numID" type="text"
						value="${infoDeclara.numID }" />
				</div>
				<div class="col-md-2">
					<input class="new_alto form-control razonSocial" type="text"
						value="${infoDeclara.razonSocial }" />
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control direccion" type="text"
						value="${infoDeclara.direccion }" />
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control telefono" type="text"
						value="${infoDeclara.telefono }" />
				</div>
				<div class="col-md-1">
					<select id="" class="form-control codMunicipio"
						style="height: 48px;">
						<option value="">SELECCIONAR</option>
						<c:forEach items="${cities}" var="eachCity">
							<option value="${eachCity.code}">${eachCity.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control tarifaApl" type="text"
						value="${infoDeclara.tarifaApl }" />
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control montoRetenido" type="text"
						value="${infoDeclara.montoRetenido }" />
				</div>
				<div class="col-md-1" style="width: 5.9% !important">
					<div class="form-group ">
						<img onclick="addvalor()"
							src="${themeResourcePath}/images/adddelineacion.png"
							style="width: 25px"></img> <img onclick="delevalor()"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:if>
		<!-- fin de c�digo agregado -->


		<c:forEach items="${infoDeclara.valorRetenido }" var="eachValor">
			<div class="row valor" id="valor">
				<div class="col-md-1" style="width: 10.5% !important">
					<input class="new_alto_anio form-control anio anoGravable "
						type="date" value="${eachValor.anoGravable }" />
				</div>
				<div class="col-md-2">
					<select id="" class="etiq_valor form-control tipoID"
						style="height: 48px;">
						<option value="">Seleccionar</option>
						<c:forEach items="${ idTypes}" var="eachType">

							<c:set var="selected" value="" />
							<c:if test="${eachValor.tipoID  eq  eachType}">
								<c:set var="selected" value="selected" />
							</c:if>

							<option value="${eachType }" ${selected }><spring:theme
									code="register.id.types.${eachType }" /></option>

						</c:forEach>


					</select>
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control numID" type="text"
						value="${eachValor.numID }" />
				</div>
				<div class="col-md-2">
					<input class="new_alto form-control razonSocial" type="text"
						value="${eachValor.razonSocial }" />
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control direccion" type="text"
						value="${eachValor.direccion }" />
				</div>
				<div class="col-md-1">
					<input class="new_alto form-control telefono" type="text"
						value="${eachValor.telefono }" />
				</div>
				<div class="col-md-1">
					<select id="" class="new_alto form-control codMunicipio"
						style="height: 48px;">
						<option value="">SELECCIONAR</option>
						<c:forEach items="${cities}" var="eachCity">

							<c:set var="selected" value="" />
							<c:if test="${eachCity.code eq  eachValor.codMunicipio}">
								<c:set var="selected" value="selected" />
							</c:if>

							<option value="${ eachCity.code}" ${selected }>${eachCity.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-1">
					<!-- 						<input class="form-control tarifaApl" type="text" -->
					<%-- 							value="${eachValor.tarifaApl }" /> --%>
					<select id="" class="new_alto form-control tarifaApl"
						style="height: 48px;">
						<option value="">Seleccionar</option>
						<c:forEach items="${ tarifasValorRetenido}" var="eachTarifa">

							<c:set var="selected" value="" />
							<c:if test="${ fn:trim(eachValor.tarifaApl)  eq  eachTarifa}">
								<c:set var="selected" value="selected" />
							</c:if>

							<option value="${eachTarifa }" ${selected }>${eachTarifa }</option>

						</c:forEach>


					</select>

				</div>
				<div class="col-md-1">
					<input class="new_alto form-control montoRetenido" type="text"
						value="${eachValor.montoRetenido }" />
				</div>
				<div class="col-md-1" style="width: 5.9% !important">
					<div class="form-group ">
						<img onclick="addvalor()"
							src="${themeResourcePath}/images/adddelineacion.png"
							style="width: 25px"></img> <img onclick="delevalor()"
							src="${themeResourcePath}/images/deledelineacion.png"
							style="width: 25px"></img>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- 	se agrega boton para adjuntar archivo -->
	<div class="container" style="margin-top: 15px !important">


		<div class="row">
			<!-- 			<div class="col-md-3" style="margin-bottom: 3px !important"> -->
			<!-- 				<button class="btn btn-primary" data-toggle="modal" -->
			<!-- 					data-target="#fm-modal" type="button" onclick="addfilevalor()" -->
			<!-- 					style="margin-top: 15px!importan">Adjuntar archivo</button> -->
			<!-- 			</div> -->

			<!-- 			<div id="adjuntar-valor" class="row" style="display: none;"> -->
			<!-- 				<div class="col-md-3" style="margin-top: 20px !important"> -->

			<!-- 					<input class="control-form" type="file"></input> -->

			<!-- 				</div> -->
			<!-- 			</div> -->
			<div class="row">
				<div class="col-md-12 text-center" style="marging-top: 15px">
					<button style="margin-top: 3px;" id="icaCalculoButton"
						class="btn btn-primary btn-lg" type="button">
						<spring:theme code="ica.declaracion.valor.calcular" />
					</button>
				</div>
			</div>
		</div>

	</div>
	<!-- fin de codigo adjuntar archivo -->
</form:form>

<script type="text/javascript">
	function addvalor() {

		var tam = $(".valor").length;
		if ($(".valor").length < 20) {
			$($(".valor")[0]).parent().append($($(".valor")[0]).clone());
			$($(".valor")[0]).parent().children().last().find(".anio").val("")
			$($(".valor")[0]).parent().children().last().find(".tipo").val("")
			$($(".valor")[0]).parent().children().last().find(".numID").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".razonSocial")
					.val("")
			$($(".valor")[0]).parent().children().last().find(".direccion").val("")
			$($(".valor")[0]).parent().children().last().find(".telefono").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".denoact").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".valbrut").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".valtotal").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".montoRetenido").val("")

		} else {
			alert("No se pueden agregar m�s registros");
		}

	}

	function delevalor() {
		var elem = document.getElementsByTagName("img");
		var ElementosClick = new Array();
		var HaHechoClick;

		HaHechoClick = event.srcElement;
		ElementosClick.push(HaHechoClick);

		for (var i = 0; i < elem.length; i++) {
			var cual = elem[i];
			var cual2 = ElementosClick[0];

			if (cual == cual2) {
				var eliminar = cual.parentNode;
				while (eliminar.id != "valor") {
					eliminar = eliminar.parentNode;
				}
				var h = $(".valor").length;
				if ($(".valor").length <= 20 && $(".valor").length > 1) {
					for (var j = 0; j < $(".valor").length; j++) {
						eliminar.remove();
					}
				} else if ($(".valor").length <= 1) {
					alert("No puede eliminar todos los registros");
				}
				break;
			} else {
			}
		}
	}

	function addfilevalor() {
		debugger;
		var subir = document.getElementById('adjuntar-valor');
		subir.style.display = 'block';
	}
</script>
