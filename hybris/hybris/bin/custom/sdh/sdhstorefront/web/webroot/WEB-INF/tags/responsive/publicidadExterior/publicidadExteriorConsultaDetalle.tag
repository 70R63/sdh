<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<!-- <select id="anio" -->
	<!-- 				class="form-control" name="anoGravable"> -->
	<!-- 				<option value="2019">2019</option> -->
	<!-- 				<option value="2018">2018</option> -->
	<!-- 				<option value="2017">2017</option> -->
	<!-- 				<option value="2016">2016</option> -->

	<!-- 			</select> -->

	<input type="hidden" id="anio" name="anio" value="2019" />

	<!-- <div class="row"> -->
	<!-- 	<div class="headline"> -->
	<!-- 		<h2> -->
	<%-- 			<span class="col-md-10"><spring:theme --%>
	<%-- 					code="publicidad.exterior.detail.outdooradvertising" /></span> --%>
	<!-- 		</h2> -->
	<!-- 	</div> -->
	<!-- </div> -->

	<!-- <div class="row"> -->
	<!-- 	<div class="col-md-4"> -->
	<!-- 		<div class="form-group"> -->
	<%-- 			<label class="control-label"><spring:theme --%>
	<%-- 					code="publicidad.exterior.detail.selectYear" /></label> <select id="anio" --%>
	<!-- 				class="form-control" name="anoGravable"> -->
	<!-- 				<option value="2019">2019</option> -->
	<!-- 				<option value="2018">2018</option> -->
	<!-- 				<option value="2017">2017</option> -->
	<!-- 				<option value="2016">2016</option> -->

	<!-- 			</select> -->


	<!-- 		</div> -->
	<!-- 	</div> -->
	<!-- 	<div class="col-md-1"> -->
	<!-- 	<div class="form-group"> -->
	<!-- 		<div> -->
	<!-- 			<button style = "margin-top: 27px" id="searchDetailButton"  class="btn btn-primary btn-lg" -->
	<!-- 				type="button"> -->
	<%-- 				<spring:theme code="publicdad.exterior.searchDetailButton" --%>
	<%-- 					text="Buscar" /> --%>
	<!-- 			</button> -->
	<!-- </div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<!-- </div> -->

	<div class="row mb-2">
		<div class="col-md-4 col-md-offset-5 centercol-md-8 text-right">

			<button style="margin-top: 3px;" id="regresar"
				class="btn btn-secondary btn-lg" onclick="goBack()" type="button">
				<spring:theme code="publicidad.exterior.regresar" />
			</button>
			<button style="margin-top: 3px;" id="presentarDeclaracionButton"
				class="btn btn-primary btn-lg" type="button">
				<spring:theme code="publicidad.exterior.declarationpresent" />
			</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12"
			style="background: #d2d2d2; margin-top: 20px !important;">
			<label class="control-label "><spring:theme
					code="ica.inicial.representantes.nota1" /></label>
			<div class="form-group">
				<label class="control-label "><spring:theme
						code="ica.inicial.representantes.nota2" /></label>
			</div>
		</div>
	</div>
</div>