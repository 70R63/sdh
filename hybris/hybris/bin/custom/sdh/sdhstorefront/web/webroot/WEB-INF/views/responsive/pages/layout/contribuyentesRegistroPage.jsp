<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="reteica"
	tagdir="/WEB-INF/tags/responsive/contriRegistroReteICA"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="loader"></div>

<sf:form>
<reteica:contribuyenteRegistro/>

<div id="dialogReteICA" title="ReteICA" ><div id="reteICADialogContent"></div></div>
<div id="dialogConfirmReteICA" title="ReteICA" ><div id="reteICADialogConfirmContent"></div></div>

</sf:form>

<script type="text/javascript">
window.onload = function() {
	debugger;
	var url = window.parent.location.href;
	var contenido_url = url.includes('retenedores');
    $(".loader").fadeOut("slow");
}

	function goBack() {
		window.history.back();
	}
</script>