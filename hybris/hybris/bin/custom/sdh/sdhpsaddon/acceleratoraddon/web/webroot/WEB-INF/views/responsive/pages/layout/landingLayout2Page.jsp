<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="loader"></div>
<template:page pageTitle="${pageTitle}">

<div class="container_menu">
	<div class="row ">
		<c:if test="${hasCORol }">
			<div class="card col-xs-12 col-sm-12 col-md-3 col-lg-3 col-lg-offset-3">
				<a href="<c:url value='/setRole?role=sdh_01' />">
					<div class=" card-section col-xs-12 col-sm-2 col-md-2 col-lg-1 center">
						<img title="Contribuyente" alt="Contribuyente" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/Contribuyente.png" width="91">
					</div>
					<div class="card-section  col-xs-12 col-sm-10 col-md-10 ">
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
				<div class=" card-section col-xs-12 col-sm-2 col-md-2 col-lg-1 center">
					<img title="Agentes Autorizados" alt="Agentes Autorizados" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/AgenteAutorizado.png" width="91">
				</div>
				<div class="card-section  col-xs-12 col-sm-10 col-md-10 ">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="authorizedAgents.title" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div><spring:theme code="authorizedAgents.description" /></div></div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
		<c:if test="${true eq false}">
		<c:if test="${hasTARol_01 || hasTARol_02 || hasTARol_03 || hasTARol_04}">
		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/setRole?role=sdh_03' />">
				<div class=" card-section col-xs-12 col-sm-2 col-md-2 col-lg-1 center">
					<img title="Terceros Autorizados" alt="Terceros Autorizados" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/TerceroAutorizado.png" width="91">
				</div>
				<div class="card-section  col-xs-12 col-sm-10 col-md-10 ">
				<c:choose>
					<c:when test="${hasTARol_01}"><div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="thirdAutorized.title_01" /></span></h2></div></c:when>
					<c:when test="${hasTARol_02}"><div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="thirdAutorized.title_02" /></span></h2></div></c:when>
					<c:when test="${hasTARol_03}"><div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="thirdAutorized.title_03" /></span></h2></div></c:when>
					<c:when test="${hasTARol_04}"><div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="thirdAutorized.title_04" /></span></h2></div></c:when>
				</c:choose>
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
				<div class=" card-section col-xs-12 col-sm-2 col-md-2 col-lg-1 center">
					<img title="Agente Retenedor" alt="Agente Retenedor" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/AgenteRetenedor.png" width="91">
				</div>
				<div class="card-section  col-xs-12 col-sm-10 col-md-10">
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
				<div class=" card-section col-xs-12 col-sm-2 col-md-2 col-lg-1 center">
					<img title="Reportates de Información" alt="Reportates de Información" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/ReportanteInformacion.png" width="91">
				</div>
				<div class="card-section  col-xs-12 col-sm-10 col-md-10 ">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="informationReporters.title" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div><spring:theme code="informationReporters.description" /></div></div>
					</div>
				</div>
			</a>
		</div>
		</c:if>
		</c:if>
	</div>
</div>

</template:page>

<script type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
</script>