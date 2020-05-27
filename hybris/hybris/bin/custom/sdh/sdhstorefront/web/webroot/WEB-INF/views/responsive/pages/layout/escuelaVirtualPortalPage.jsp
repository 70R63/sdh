<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="virtual" tagdir="/WEB-INF/tags/responsive/escuelavirtual"%>

<div class="loader"></div>
<virtual:escuelaVirtualPortal/>
		<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>