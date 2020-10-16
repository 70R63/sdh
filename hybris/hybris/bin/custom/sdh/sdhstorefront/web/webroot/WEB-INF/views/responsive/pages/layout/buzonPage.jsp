<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="mibuzon" tagdir="/WEB-INF/tags/responsive/buzon"%>


<div class="loader"></div>
<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>

<mibuzon:buzonInicio />
<div id="idNotifi" style="display: none;">
	<mibuzon:buzonNotificaciones />
</div>
<div id="idMsn" style="display: none;">
	<mibuzon:buzonMensajes />
</div>


<script>

window.onload = function() {
	debugger;
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
	$(".loader").fadeOut("slow");
}
	function myFunction(idButton) {

		var idNotifi = document.getElementById('idNotifi');
		var idMsn = document.getElementById('idMsn');

		switch (idButton) {
		case 1:

			idNotifi.style.display = 'block';
			idMsn.style.display = 'none';

			break;

		case 2:
			idNotifi.style.display = 'none';
			idMsn.style.display = 'block';

			break;

		default:
			alert("")
		}

	}
</script>

