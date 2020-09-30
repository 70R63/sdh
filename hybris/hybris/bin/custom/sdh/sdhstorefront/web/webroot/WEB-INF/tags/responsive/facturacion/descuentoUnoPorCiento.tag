<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="fechaActual" value="${now}" pattern="YYYYMMdd" />


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container" style="display:none" id="divDescuento1PC">
	<div class="row">
		<div class="col-md-12">
			<a href="<c:url value='/contribuyentes/facturacion/descuentoUnoPorCiento'/>" ><spring:theme code="text.account.profile.descuento1pc"></spring:theme></a>
			<br>
			<br>
			<br>
		</div>
	</div>
</div>



