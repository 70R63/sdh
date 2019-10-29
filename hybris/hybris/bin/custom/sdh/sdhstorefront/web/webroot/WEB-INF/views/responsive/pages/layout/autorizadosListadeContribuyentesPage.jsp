<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="agente" tagdir="/WEB-INF/tags/responsive/agentesAutorizados"%>

    <%@ page trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
    <%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
    <%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


    <spring:htmlEscape defaultHtmlEscape="true" />
<div class="loader"></div>

    <template:page pageTitle="${pageTitle}">
<agente:autorizadosListadeContribuyentes/>
<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>
    </template:page>