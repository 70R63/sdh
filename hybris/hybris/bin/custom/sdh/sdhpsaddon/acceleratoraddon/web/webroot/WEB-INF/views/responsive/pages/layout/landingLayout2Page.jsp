<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<template:page pageTitle="${pageTitle}">

<div class="container_menu">
	<div class="row ">
		<c:if test="${hasCORol }">
			<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
				<a href="<c:url value='/setRole?role=sdh_01' />">
					<div class=" card-section col-xs-5 col-sm-2 col-md-2 col-lg-1">
						<img title="Contribuyente" alt="Kennedy" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/contribuyentes.png">
					</div>
					<div class="card-section  col-xs-8 col-sm-10 col-md-10">
						<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="taxpayers.title" /></span></h2></div>
						<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
							<div id="helpSection"><div><spring:theme code="taxpayers.description" /></div></div>
						</div>
					</div>
				</a>
			</div>
		</c:if>
		<c:if test="${hasAARol }">
		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/setRole?role=sdh_02' />">
				<div class=" card-section col-xs-5 col-sm-2 col-md-2 col-lg-1">
					<img title="Agentes Autorizados" alt="Kennedy" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/agentes_autorizados.png">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="authorizedAgents.title" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div><spring:theme code="authorizedAgents.description" /></div></div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
		<c:if test="${hasTARol }">
		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/setRole?role=sdh_03' />">
				<div class=" card-section col-xs-5 col-sm-2 col-md-2 col-lg-1">
					<img title="Terceros Autorizados" alt="Kennedy" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/terceros_autorizados.png">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="thirdAutorized.title" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div><spring:theme code="thirdAutorized.description" /></div></div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
		<c:if test="${hasARRol }">
		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/setRole?role=sdh_04' />">
				<div class=" card-section col-xs-5 col-sm-2 col-md-2 col-lg-1">
					<img title="Agente Retenedor" alt="Kennedy" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/agente_retenedor.png">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="retainingAgent.title" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div><spring:theme code="retainingAgent.description" /></div></div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
		<c:if test="${hasRIRol }">
		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/setRole?role=sdh_05' />">
				<div class=" card-section col-xs-5 col-sm-2 col-md-2 col-lg-1">
					<img title="Reportates de Información" alt="Kennedy" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/reportante_de_informacion.png">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="informationReporters.title" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div><spring:theme code="informationReporters.description" /></div></div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
	</div>
</div>

</template:page>

<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>