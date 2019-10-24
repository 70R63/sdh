<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="lista" tagdir="/WEB-INF/tags/responsive/arListaDeclaraciones"%>

<lista:agentesLista/>


<script type="text/javascript">
	
	window.onload = function() {
		debugger;
		var cosas = $(":input");
		var tam = cosas.length;
		if (false){ //EMP-codigo comentado por observaciones en pruebas realizadas el 04 de octubre 2019
			for (var i = 0; i < tam; i++) {
				var valor = cosas[i].value;
				if (valor == "") {
					cosas[i].value = "-";

				}
			}
		}	

	}

	function goBack() {
		window.history.back();
	}

</script>



