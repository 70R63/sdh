<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="row ">
			<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
				<a href="<c:url value='/terceros/sim/buscar' />">
					<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
						<img title="sim" alt="sim" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/terceros_sim.jpg">
					</div>
					<div class="card-section  col-xs-8 col-sm-10 col-md-10">
						<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="terceros.menu.sim" /></span></h2></div>
						<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
							<div id="helpSection"><div></div></div>
						</div>
					</div>
				</a>
			</div>

		<div class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/terceros/notarios/buscar' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="notarios" alt="notarios" class="card-section-content imgagen_tran" src="${themeResourcePath}/images/terceros_notario.jpg">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2"><h2><span tabindex="0"><spring:theme code="terceros.menu.notarios" /></span></h2></div>
					<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
						<div id="helpSection"><div></div></div>
					</div>
				</div>
			</a>
		</div>	
	</div>
</div>
