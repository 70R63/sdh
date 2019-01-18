<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="DeclaraPubli"
	tagdir="/WEB-INF/tags/responsive/DeclaraPubli"%>


<div class="row">
	<div class="container">
		<div class="account-section-content">
			<div class="account-section-form">
<<<<<<< HEAD
			<!--	<c:out value="${action}" />-->
=======
>>>>>>> dev
				<form:form action="DeclaraPublicidadPage" method="post"
					commandName="declaraPublicidadpage">
					<DeclaraPubli:DecPuGeneral/>
					<DeclaraPubli:DecPuInfoValla/>
					<DeclaraPubli:DecPuTotalPag/>
					<DeclaraPubli:DecPuFirmDecl/>
					<DeclaraPubli:DecPuPago/>
				</form:form>
			</div>
		</div>
	</div>
</div>