<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="retenedores" tagdir="/WEB-INF/tags/responsive/retenedores"%>
<%@ taglib prefix="firmas" tagdir="/WEB-INF/tags/responsive/firmas"%>

<div class="loader"></div>

<retenedores:retenedoresDeclaracionTable />
<retenedores:retenedoresDeclaracionJuridico />
<c:url value='${redirectURL}' var="taxRedirection"/>
<firmas:generalFirmas firmaContribuyenteRedirection="${taxRedirection}"/>
<retenedores:retenedoresDeclaracionFirma />

<div id="dialogReteICA" title="ReteICA" ><div id="reteICADialogContent"></div></div>

<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}

	function goBack() {
		window.history.back();
	}
</script>