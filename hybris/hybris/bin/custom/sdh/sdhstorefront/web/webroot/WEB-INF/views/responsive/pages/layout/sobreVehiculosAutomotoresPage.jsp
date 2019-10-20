<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sobreVehiculos"
	tagdir="/WEB-INF/tags/responsive/sobreVehiculos"%>


<sobreVehiculos:sobreVehiculosTable />
<div id="detalleVehiculos" style="display: none">
<sobreVehiculos:sobreVehiculosDetail />
<sobreVehiculos:sobreVehiculosJuridicos />
<sobreVehiculos:sobreVehiculosMarcas />
<sobreVehiculos:sobreVehiculosLiquida />
</div>

<script>
	function goBack() {
		window.history.back();
	}

	window.onload = function() {
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){
			for (var i = 0; i < tam; i++) {
				var valor = cosas[i].value;
				if (valor == "") {
					cosas[i].value = "-";
				}
			}
		}	
	}
</script>
