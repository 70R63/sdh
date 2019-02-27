<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="reportantes"
	tagdir="/WEB-INF/tags/responsive/reportantesInformacion"%>


<div class="container">
	<reportantes:reportantesInicial></reportantes:reportantesInicial>
	<div id="idPredial" style="display: none;">
		<reportantes:reportantesCargaPredial />
	</div>
	<div id="idOpain" style="display: none;">
		<reportantes:reportantesCargaOpain />
	</div>
	<div id="idIca" style="display: none;">
		<reportantes:reportantesCargaIca />
	</div>
	<div id="idVehicular" style="display: none;">
		<reportantes:reportantesCargaVehicular />
	</div>
</div>


<script type="text/javascript">
	function ShowSelected(selectObject) {
		var value = selectObject.value;
		document.getElementById("Idinrepor").value = value;
	}

	function myFunction() {

		var x = document.getElementById('Idinrepor').value;
		var idPredial = document.getElementById('idPredial');
		var idOpain = document.getElementById('idOpain');
		var idIca = document.getElementById('idIca');
		var idVehicular = document.getElementById('idVehicular');

		if (x == '1') {
			idPredial.style.display = 'block';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';

		} else if (x == '2') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'block';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';

		} else if (x == '3') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'block';
			idVehicular.style.display = 'none';

		} else if (x == '4') {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'block';

		} else {
			idPredial.style.display = 'none';
			idOpain.style.display = 'none';
			idIca.style.display = 'none';
			idVehicular.style.display = 'none';
		}

	}
</script>
