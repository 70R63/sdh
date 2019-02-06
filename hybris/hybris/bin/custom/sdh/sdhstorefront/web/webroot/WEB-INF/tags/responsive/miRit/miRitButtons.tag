<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row ">
	<div class="col-md-8  text-right">
		<button class="btn btn-primary btn-lg" type="button" onclick="window.location.href = '<c:url value="/contribuyentes/mirit/certificacion" />'"><spring:theme code="mirit.buttons.certificate"  /></button>
		<button class="btn btn-primary btn-lg" type="button" id="updateRitButton"><spring:theme code="mirit.buttons.update" /></button>
	</div>
</div>


<div id="dialog" title="Actualizacion de RIT" ><div id="textCertNom"></div></div>


