<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	function bogota(selectObject) {
		debugger;
		var muni = selectObject.value;
		if (muni == '000000011001') {
			alert("Seleccione un municipio diferente, ya que las actividades deben ser fuera de Bogot�");
		}
	}
</script>

<c:set value="${icaInfObjetoFormResp.icaInfObjetoResponse.infoDeclara }"
	var="infoDeclara" />
<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.actifuera.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>

	<br>
	<form:form action="">
		<div class="row">
			<div class="col-md-7">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.actifuera.ciiu" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.actifuera.municipio" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.actifuera.ingre" />
				</label>
			</div>
			<!-- 			<div class="col-md-2" style="margin-bottom: 3px !important"> -->
			<!-- 				<button class="btn btn-primary" data-toggle="modal" -->
			<!-- 			data-target="#fm-modal" type="button" onclick="addfile()">Adjuntar archivo</button> -->
			<!-- 			</div> -->
		</div>

		<c:forEach items="${infoDeclara.ingFueraBog }" var="eachIngreso">
			<c:if test="${not empty eachIngreso.codCIIU }">
				<div class="row actvifuera">
					<div class="col-md-7">
						<fmt:formatNumber value="${ eachIngreso.codCIIU}"
							pattern="#######################" var="codCIIUNumber" />


						<select id="" class="alto form-control deno codCIIU"
							style="font-size: 11px !important">
							<option value="">SELECCIONAR</option>
							<c:set var="selected" value="" />
							<c:forEach items="${ gravableNetIncomes}" var="eachActivity">
								<fmt:formatNumber value="${ eachActivity.ciiu}"
									pattern="#######################" var="eachCodCIIUNumber" />
								<c:if test="${codCIIUNumber eq eachCodCIIUNumber}">
									<c:set var="selected" value="selected" />
								</c:if>
								<option ${selected } value="${eachActivity.ciiu}">${eachActivity.ciiu}
									- ${eachActivity.denominacion }</option>
							</c:forEach>
						</select>
					</div>

					<div class="col-md-2">
						<select id="" class="new_alto form-control mun codMunicipio"
							style="height: 48px;">
							<option value="">SELECCIONAR</option>

							<c:forEach items="${cities}" var="eachCity">
								<c:set var="selected" value="" />
								<c:if test="${eachIngreso.codMunicipio eq eachCity.code}">
									<c:set var="selected" value="selected" />
								</c:if>
								<option value="${ eachCity.code}" ${selected }>${eachCity.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-1">
						<input class="new_alto form-control ing ingresos" type="text"
							value="${eachIngreso.ingresos }" />
					</div>
					<div class="col-md-1">
						<div class="form-group ">
							<img onclick="addactvifuera()"
								src="${themeResourcePath}/images/adddelineacion.png"
								style="width: 25px"></img> <img id="dele"
								onclick="deleactvifuera(this)"
								src="${themeResourcePath}/images/deledelineacion.png"
								style="width: 25px"></img>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>

		<!--  se agregan l�neas para agregar siempre una linea en la tabla -->
		<div class="row actvifuera" id="actvifuera">
			<div class="col-md-7">
				<select id="" class="alto form-control deno codCIIU"
					style="font-size: 11px !important">
					<option value="">SELECCIONAR</option>
					<c:forEach items="${ gravableNetIncomes}" var="eachActivity">
						<option ${selected } value="${eachActivity.ciiu}">${eachActivity.ciiu}
							- ${eachActivity.denominacion }</option>
					</c:forEach>
				</select>
			</div>


			<div class="col-md-2">
				<select id="" class="new_alto form-control mun codMunicipio"
					style="height: 48px;" onchange="bogota(this)">
					<option value="">SELECCIONAR</option>
					<c:set var="selected" value="" />
					<c:if test="${eachIngreso.codMunicipio eq eachCity.code}">
						<c:set var="selected" value="" />
					</c:if>
					<c:forEach items="${cities}" var="eachCity">
						<option value="${ eachCity.code}">${eachCity.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-1">
				<input class="new_alto form-control ing ingresos" type="text"
					value="" />
			</div>
			<div class="col-md-1">
				<div class="form-group ">
					<img onclick="addactvifuera()"
						src="${themeResourcePath}/images/adddelineacion.png"
						style="width: 25px"></img> <img onclick="deleactvifuera()"
						src="${themeResourcePath}/images/deledelineacion.png"
						style="width: 25px"></img>
				</div>
			</div>
		</div>
		<!-- fin de c�digo agregado -->

		<!-- <div id="adjuntar" class="row" style="display: none;"> -->
		<!-- 		<div class="col-md-3" style="margin-top: 20px !important"> -->

		<!-- 		<input class="control-form" type="file"></input> -->

		<!-- 			</div> -->
		<!-- 		</div> -->
	</form:form>
</div>

<script>
	function alertbogota() {

	}
	function addactvifuera() {

		var tam = $(".actvifuera").length;
		if ($(".actvifuera").length < 20) {
			$($(".actvifuera")[0]).parent().append(
					$($(".actvifuera")[0]).clone());
			$($(".actvifuera")[0]).parent().children().last().find(".deno")
					.val("")
			$($(".actvifuera")[0]).parent().children().last().find(".mun").val(
					"")
			$($(".actvifuera")[0]).parent().children().last().find(".ing").val(
					"")

		} else {
			alert("No se pueden agregar m�s registros");
		}

	}

	function deleactvifuera(selectObject) {
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
				while (eliminar.id != "actvifuera") {
					eliminar = eliminar.parentNode;
				}
				var h = $(".actvifuera").length;
				if ($(".actvifuera").length <= 20
						&& $(".actvifuera").length > 1) {
					for (var j = 0; j < $(".actvifuera").length; j++) {
						eliminar.remove();
					}
				} else if ($(".actvifuera").length <= 1) {
					alert("No puede eliminar todos los registros");
				}
				break;
			} else {
			}
		}
	}

	function addfile() {
		debugger;
		var subir = document.getElementById('adjuntar');
		subir.style.display = 'block';
	}
</script>