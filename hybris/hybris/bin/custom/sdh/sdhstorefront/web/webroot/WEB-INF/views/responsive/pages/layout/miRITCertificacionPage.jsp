<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>


<div class="row">
	<div class="container">
	 	<div class="headline">
			<h3>
				<span tabindex="0"><spring:theme code="mirit.certificacion.titulo" /></span>
				<c:if test="${not empty miRitCertificacionForm.rit.stringRIT}">
				  <iframe width='100%' height='600' width='15' src='data:application/pdf;/Certificación RIT#zoom=100&view=fitH&;base64,${miRitCertificacionForm.rit.stringRIT}'>	</iframe>
				</c:if>  
			</h3>
		</div>
	</div>
</div>