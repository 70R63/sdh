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
							code="ica.declaracion.actifuera.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>

	<br>
	<form:form action="">
		<div class="row">
			<div class="col-md-3">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.actifuera.ciiu" />
				</label>
			</div>
			<div class="col-md-3">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.actifuera.municipio" />
				</label>
			</div>
			<div class="col-md-3">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.actifuera.ingre" />
				</label>
			</div>
		</div>
		<c:forEach items="${infoDeclara.ingFueraBog }" var="eachIngreso">
			<c:if test="${not empty eachIngreso.codCIIU }">
				<div class="row actvifuera">
					<div class="col-md-3">
						<select id="" class="form-control deno codCIIU" style="height: 48px;">
							<c:set var="selected" value=""/>
							<c:if test="${eachIngreso.codCIIU eq eachActivity.code}">
								<c:set var="selected" value="selected"/>
							</c:if>
							<c:forEach items="${ econActivities}" var="eachActivity">
								<option ${selected } value="${eachActivity.code}">${eachActivity.description }</option>
							</c:forEach>
						</select>
					</div>
		
					<div class="col-md-3">
						<select id="" class="form-control mun codMunicipio" style="height: 48px;">
							<c:set var="selected" value=""/>
							<c:if test="${eachIngreso.codMunicipio eq eachCity.code}">
								<c:set var="selected" value=""/>
							</c:if>
							<c:forEach items="${cities}" var="eachCity">
							<option value="${ eachCity.code}">${eachCity.name}</option>
						</c:forEach>
						</select>
					</div>
					<div class="col-md-3">
						<input class="form-control ing ingresos" type="text" value="${eachIngreso.ingresos }"/>
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
			</c:if>
		</c:forEach>
	</form:form>
</div>

<script>
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
			alert("No se pueden agregar más registros");
		}

	}

	function deleactvifuera() {

		var i = $(".actvifuera").length;
		var val = i - 1;
		if ($(".actvifuera").length <= 20 && $(".actvifuera").length > 1) {

			$($(".actvifuera")[val]).closest($($(".actvifuera")[val]).remove());

		} else if ($(".actvifuera").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}
</script>