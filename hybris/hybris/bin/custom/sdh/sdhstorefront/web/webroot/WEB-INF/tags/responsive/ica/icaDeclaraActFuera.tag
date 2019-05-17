<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
			<div class="col-md-3" style="margin-bottom: 3px !important">
				<button class="btn btn-primary" data-toggle="modal"
			data-target="#fm-modal" type="button" onclick="addfile()">Adjuntar archivo</button>
			</div>
		</div>
		
		<c:forEach items="${infoDeclara.ingFueraBog }" var="eachIngreso">
<%-- 			<c:if test="${not empty eachIngreso.codCIIU }"> --%>
				<div class="row actvifuera">
					<div class="col-md-3">
						<fmt:formatNumber value="${ eachIngreso.codCIIU}" pattern="#######################" var="codCIIUNumber"/>
						
						
						<select id="" class="form-control deno codCIIU" style="height: 48px;">
							<option value="">SELECCIONAR</option>
							<c:set var="selected" value=""/>
							<c:forEach items="${ econActivities}" var="eachActivity">
								<fmt:formatNumber value="${ eachActivity.code}" pattern="#######################" var="eachCodCIIUNumber"/>
								<c:if test="${codCIIUNumber eq eachCodCIIUNumber}">
									<c:set var="selected" value="selected"/>
								</c:if>
								<option ${selected } value="${eachActivity.code}">${eachActivity.code} - ${eachActivity.description }</option>
							</c:forEach>
						</select>
					</div>
		
					<div class="col-md-3">
						<select id="" class="form-control mun codMunicipio" style="height: 48px;">
							<option value="">SELECCIONAR</option>
							
							<c:forEach items="${cities}" var="eachCity">
								<c:set var="selected" value=""/>
								<c:if test="${eachIngreso.codMunicipio eq eachCity.code}">
									<c:set var="selected" value="selected"/>
								</c:if>
								<option value="${ eachCity.code}" ${selected }>${eachCity.name}</option>
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
<%-- 			</c:if> --%>
		</c:forEach>
<!--  se agregan líneas para agregar siempre una linea en la tabla -->
				<div class="row actvifuera">
					<div class="col-md-3">
						<select id="" class="form-control deno codCIIU" style="height: 48px;">
							<option value="">SELECCIONAR</option>
							<c:forEach items="${ econActivities}" var="eachActivity">
								<option ${selected } value="${eachActivity.code}">${eachActivity.code} - ${eachActivity.description }</option>
							</c:forEach>
						</select>
					</div>
		
					
						<div class="col-md-3">
						<select id="" class="form-control mun codMunicipio" style="height: 48px;">
							<option value="">SELECCIONAR</option>
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
						<input class="form-control ing ingresos" type="text" value=""/>
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
<!-- fin de código agregado -->

<div id="adjuntar" class="row" style="display: none;">
		<div class="col-md-3" style="margin-top: 20px !important">
		
		<input class="control-form" type="file"></input>
				
			</div>
		</div>
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
	
	function addfile(){
		debugger;
		var subir = document.getElementById('adjuntar');
		subir.style.display = 'block';
	}
</script>