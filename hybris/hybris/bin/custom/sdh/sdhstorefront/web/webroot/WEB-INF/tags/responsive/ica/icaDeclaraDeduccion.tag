<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="headline">
				<h2>
					<span class="col-md-10 "><spring:theme
							code="ica.declaracion.deducciones.titulo" /></span>
				</h2>
			</div>
		</div>
	</div>

	<br>
	<form:form action="">
		<div class="row">
			<div class="col-md-3">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.deducciones.deduccion" />
				</label>
			</div>
			<div class="col-md-3">
				<label class="control-label text-capitalize !important" for="">
					<spring:theme code="ica.declaracion.deducciones.monto" />
				</label>
			</div>
		</div>
		<div class="row deducciones">
			<div class="col-md-3">
				<select id="" class="form-control deducci" style="height: 48px;">
					<option value=" ">Seleccionar</option>
				</select>
			</div>

			<div class="col-md-3">
				<input class="form-control valordedu" type="text" />
			</div>
			<div class="col-md-1">
				<div class="form-group ">
					<img onclick="adddeducciones()"
						src="${themeResourcePath}/images/adddelineacion.png"
						style="width: 25px"></img> <img onclick="delededucciones()"
						src="${themeResourcePath}/images/deledelineacion.png"
						style="width: 25px"></img>
				</div>
			</div>
		</div>
	</form:form>
</div>

<script>
	function adddeducciones() {

		var tam = $(".deducciones").length;
		if ($(".deducciones").length < 20) {
			$($(".deducciones")[0]).parent().append(
					$($(".deducciones")[0]).clone());
			$($(".deducciones")[0]).parent().children().last().find(".deducci")
					.val("")
			$($(".deducciones")[0]).parent().children().last().find(
					".valordedu").val("")

		} else {
			alert("No se pueden agregar más registros");
		}

	}

	function delededucciones() {
		debugger;
		var i = $(".deducciones").length;
		var val = i - 1;
		if ($(".deducciones").length <= 20 && $(".deducciones").length > 1) {

			$($(".deducciones")[val]).closest(
					$($(".deducciones")[val]).remove());

		} else if ($(".deducciones").length <= 1) {
			alert("No puede eliminar todos los registros");
		}
	}
</script>