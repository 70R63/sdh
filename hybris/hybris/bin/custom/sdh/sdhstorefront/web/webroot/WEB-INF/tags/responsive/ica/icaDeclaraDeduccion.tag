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
				<select id="" class="form-control deducci"
					style="height: 48px; text-transform: none !important; font-size: 14px !important">
					<option value="0">Seleccionar</option>
					<option value="1">1.- Actividad no sujeta por la
						producción Primaria Agricola</option>
					<option value="2">2.- Enajenación de Activo Fijos</option>
					<option value="3">3.- Exportación de bienes</option>
					<option value="4">4.- Exportación de Servicios</option>
					<option value="5">5.- Actividad no sujeta Art. 39 Decreto
						352 de 2002</option>
					<option value="6">6.- Actividades no sujetas propias de
						obj.soc. de prop.horiz.</option>
					<option value="7">7.- Explotación de los juegos de suerte
						y azar (Ley 643 de 2001)</option>
					<option value="8">8.- Donaciones</option>
					<option value="9">9.- Exen.consec.de actos terroristas o
						catástrofes naturales</option>
					<option value="10">10.- Base gravable especial</option>
					<option value="11">11.- Ingresos por actividades
						realizadas a través de Consorcios</option>
					<option value="12">12.- Dividendos que no hacen parte del
						giro ordinario del negocio</option>
					<option value="13">13.- Exención víctima del secuestro o
						de la desaparición forzada</option>
					<option value="14">14.- Corrección monetaria y/o
						Diferencia en cambio</option>
					<option value="15">15.- Reintegro de costos y gastos</option>
					<option value="16">16.- Salarios</option>
					<option value="17">17.- Devoluciones</option>
					<option value="18">18.- Rebajas</option>
					<option value="19">19.- Descuentos</option>
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