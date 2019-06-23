<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="nav"
	tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/nav"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="tramites.menu.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="tramites.menu.inicial.descripcion" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row ">
		<div
			class="card col-xs-12 col-sm-12 col-md-11 col-lg-9 col-lg-offset-3">
			<a href="<c:url value='/contibuyentes/tramites/crear' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="crear" alt="crear" class="card-section-content"
						src="${themeResourcePath}/images/crear_tramites.jpg">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2">
						<h2>
							<span tabindex="0"><spring:theme
									code="tramites.menu.inicial.crear" /></span>
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
			<a href="<c:url value='/contibuyentes/tramites/seguimiento' />">
				<div class=" card-section col-xs-3 col-sm-2 col-md-2 col-lg-1">
					<img title="seguimiento" alt="seguimiento" class="card-section-content"
						src="${themeResourcePath}/images/seguimiento_tramites.jpg">
				</div>
				<div class="card-section  col-xs-8 col-sm-10 col-md-10">
					<div class="card-section-h2">
						<h2>
							<span tabindex="0"><spring:theme
									code="tramites.menu.inicial.segui" /></span>
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
