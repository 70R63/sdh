	<%@ page trimDirectiveWhitespaces="true"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
		<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
		<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


		<spring:htmlEscape defaultHtmlEscape="true" />
<div class="loader"></div>


		<template:page pageTitle="${pageTitle}">
<div class="container_menu">
	<div class="row ">
        <c:if test="${not empty entidadBancaria}">
            <div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
                <a href="<c:url value='/autorizados/entidades/reportarinfo' />">
            	    <div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
            			<img title="Entidad" alt="Entidad" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/agentes_autorizados_entidad.jpg">
            		</div>
            		<div class="card-section  col-xs-8 col-sm-10 col-md-10">
            			<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="agent.auto.bancaria.titulo" /></span></h2></div>
            				<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
            					<div id="helpSection"><div><spring:theme code="agent.auto.bancaria.descripcion" /></div>
            				</div>
           				</div>
            		</div>
            	</a>
            </div>
        </c:if>


		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/autorizados/contribuyente' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="Contrib" alt="Contrib" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/agentes_autorizados_contribuyente.png">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="agent.auto.contribuyente.titulo" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div><spring:theme code="agent.auto.contribuyente.decripcion" /></div></div>
					</div>
				</div>
			</a>
		</div>	
	</div>
</div>
<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>
	</template:page>