<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="consultas"
	tagdir="/WEB-INF/tags/responsive/consultas"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<sf:form action="" method="POST" modelAttribute="dataForm" id="forma">
		<consultas:estadoCuentaMenu/>

	</sf:form>
</div>