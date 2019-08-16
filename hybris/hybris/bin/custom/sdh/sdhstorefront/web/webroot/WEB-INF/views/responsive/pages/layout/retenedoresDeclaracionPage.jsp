<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="retenedores" tagdir="/WEB-INF/tags/responsive/retenedores"%>


<retenedores:retenedoresDeclaracionTable />
<retenedores:retenedoresDeclaracionJuridico />
<retenedores:retenedoresDeclaracionFirma />

<div id="dialogReteICA" title="ReteICA" ><div id="reteICADialogContent"></div></div>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>