
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="nav"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="loader"></div>

<div class="container_new_page">

	<div class="row ">
		<div
			class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/escuelavirtual/foros' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="foros" alt="foros" class="card-section-content imgagen_tran"
						src="${themeResourcePath}/images/Contribuyente.png" width="91">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2">
						<h2>
							<span tabindex="0"><spring:theme
									code="escuela.menu.foros" /></span>
						</h2>
					</div>
					<div class="card-section-content" aria-labelledby="helpSection"
						tabindex="0">
<!-- 						<div id="helpSection"> -->
<!-- 							<div> -->
<%-- 								<spring:theme code="tramites.menu.inicial.crear" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
			</a>
		</div>

		<div
			class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/escuelavirtual/encuestasdeservicio' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="Encuestas" alt="Encuestas" class="card-section-content imgagen_tran"
						src="${themeResourcePath}/images/ReportanteInformacion.png" width="91">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2">
						<h2>
							<span tabindex="0"><spring:theme
									code="escuela.menu.encuesta" /></span>
						</h2>
					</div>
					<div class="card-section-content" aria-labelledby="helpSection"
						tabindex="0">
<!-- 						<div id="helpSection"> -->
<!-- 							<div> -->
<%-- 								<spring:theme code="tramites.menu.inicial.segui" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
			</a>
		</div>
		<div
			class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/escuelavirtual/portalninos' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="Portal" alt="Portal" class="card-section-content imgagen_tran"
						src="${themeResourcePath}/images/ReportanteInformacion.png" width="91">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2">
						<h2>
							<span tabindex="0"><spring:theme
									code="escuela.menu.ninos" /></span>
						</h2>
					</div>
					<div class="card-section-content" aria-labelledby="helpSection"
						tabindex="0">
<!-- 						<div id="helpSection"> -->
<!-- 							<div> -->
<%-- 								<spring:theme code="tramites.menu.inicial.ninos" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
			</a>
		</div>
		<div
			class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/escuelavirtual/actividades' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="Actividades" alt="Actividades" class="card-section-content imgagen_tran"
						src="${themeResourcePath}/images/ReportanteInformacion.png" width="91">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2">
						<h2>
							<span tabindex="0"><spring:theme
									code="escuela.menu.actividades" /></span>
						</h2>
					</div>
					<div class="card-section-content" aria-labelledby="helpSection"
						tabindex="0">
<!-- 						<div id="helpSection"> -->
<!-- 							<div> -->
<%-- 								<spring:theme code="tramites.menu.inicial.segui" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
				</div>
			</a>
		</div>
	</div>
</div>