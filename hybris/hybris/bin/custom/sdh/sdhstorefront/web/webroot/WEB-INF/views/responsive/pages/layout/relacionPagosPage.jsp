<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="relacionpagos"
	tagdir="/WEB-INF/tags/responsive/consultas"%>
	<%@ taglib prefix="impuestos"
	tagdir="/WEB-INF/tags/responsive/impuestos"%>
<spring:htmlEscape defaultHtmlEscape="true" />


<div class="container">
	<relacionpagos:relacionPagos />
	<impuestos:declaraFirmar />
</div>

