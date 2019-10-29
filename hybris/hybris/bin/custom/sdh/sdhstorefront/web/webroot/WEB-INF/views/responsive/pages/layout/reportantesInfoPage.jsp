<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="reportantes"
	tagdir="/WEB-INF/tags/responsive/reportantesInformacion"%>


<div class="container_new_page">
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
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>
