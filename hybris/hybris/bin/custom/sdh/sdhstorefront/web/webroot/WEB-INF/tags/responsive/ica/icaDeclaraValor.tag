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
							code="ica.declaracion.valor.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>
</div>
<br>

<form:form action="">
	<div>
		<div class="row">
			<div class="col-md-1">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.angrav" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.tipdoc" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.numide" />
				</label>
			</div>
			<div class="col-md-2">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.nombre" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme
						code="ica.declaracion.valor.direccion" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.tel" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme
						code="ica.declaracion.valor.municipio" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme
						code="ica.declaracion.valor.taraplicada" />
				</label>
			</div>
			<div class="col-md-1">
				<label class="control-label" style="text-transform: none !important"
					for=""> <spring:theme code="ica.declaracion.valor.montoret" />
				</label>
			</div>
		</div>
		<c:forEach items="${infoDeclara.valorRetenido }" var="eachValor">
			<c:if test="${not empty eachValor.tipoID }">
				<div class="row valor">
					<div class="col-md-1">
						<input class="form-control anio" type="text" value="${eachValor.anoGravable }"/>
					</div>
					<div class="col-md-2">
						<select id="" class="form-control tipo" style="height: 48px;">
							<option value=" ">${eachValor.tipoID }</option>
						</select>
					</div>
					<div class="col-md-1">
						<input class="form-control numiden" type="text" value="${eachValor.numID }"/>
					</div>
					<div class="col-md-2">
						<input class="form-control nombre" type="text" value="${eachValor.razonSocial }"/>
					</div>
					<div class="col-md-1">
						<input class="form-control direc" type="text" value="${eachValor.direccion }"/>
					</div>
					<div class="col-md-1">
						<input class="form-control telefono" type="text" value="${eachValor.telefono }"/>
					</div>
					<div class="col-md-1">
						<select id="" class="form-control denoact" style="height: 48px;">
							<option value=" ">Seleccionar</option>
						</select>
					</div>
					<div class="col-md-1">
						<input class="form-control valbrut" type="text" value="${eachValor.tarifaApl }"/>
					</div>
					<div class="col-md-1">
						<input class="form-control valtotal" type="text"  value="${eachValor.montoRetenido }"/>
					</div>
					<div class="col-md-1">
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
		</c:forEach>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center" style="marging-top: 15px">
				<button style="margin-top: 3px;" id=""
					class="btn btn-primary btn-lg" type="button">
					<spring:theme code="ica.declaracion.valor.calcular" />
				</button>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
	function addvalor() {

		var tam = $(".valor").length;
		if ($(".valor").length < 20) {
			$($(".valor")[0]).parent().append($($(".valor")[0]).clone());
			$($(".valor")[0]).parent().children().last().find(".anio").val("")
			$($(".valor")[0]).parent().children().last().find(".tipo").val("")
			$($(".valor")[0]).parent().children().last().find(".numiden").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".nombre")
					.val("")
			$($(".valor")[0]).parent().children().last().find(".direc").val("")
			$($(".valor")[0]).parent().children().last().find(".telefono").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".denoact").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".valbrut").val(
					"")
			$($(".valor")[0]).parent().children().last().find(".valtotal").val(
					"")

		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function delevalor() {
		var i = $(".valor").length;
		var val = i - 1;
		if ($(".valor").length <= 20 && $(".valor").length > 1) {

			$($(".valor")[val]).closest($($(".valor")[val]).remove());

		} else if ($(".valor").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}
</script>
