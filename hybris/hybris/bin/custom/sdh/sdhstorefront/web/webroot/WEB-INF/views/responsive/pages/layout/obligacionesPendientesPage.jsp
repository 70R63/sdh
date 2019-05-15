<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="obligaciones"
	tagdir="/WEB-INF/tags/responsive/obligacionesPendi"%>



<obligaciones:obliPendientes />
<div id="sujeto" style="display: none;">
	<obligaciones:obliPendientesSujeto />
</div>
<div id="impuesto" style="display: none;">
	<obligaciones:obliPendientesImpuesto />
</div>


<script type="text/javascript">
	function Selected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idimp").value = value;
	}

	function ShowSujeto(selectObject) {
		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;
		var suj = document.getElementById('sujeto');
		var im = document.getElementById('impuesto');

		suj.style.display = 'block';
		im.style.display = 'none';

	}
	function ShowImpuesto(selectObject) {
		var value = selectObject.value;
		var x = document.getElementById('Idimp').value;
		var suj = document.getElementById('sujeto');
		var im = document.getElementById('impuesto');

		suj.style.display = 'none';
		im.style.display = 'block';

	}
</script>

