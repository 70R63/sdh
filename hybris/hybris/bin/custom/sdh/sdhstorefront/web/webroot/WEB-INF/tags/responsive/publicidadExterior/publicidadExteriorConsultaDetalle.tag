<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="headline">
		<h2>
			<span class="col-md-10"><spring:theme
					code="publicidad.exterior.detail.outdooradvertising" /></span>
		</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-4">
		<div class="form-group">
			<label class="control-label"><spring:theme
					code="publicidad.exterior.detail.selectYear" /></label> <select id="anio"
				class="form-control" name="anoGravable">
				<option value="0">Selecciona un año</option>
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>

			</select>


		</div>
	</div>
	<div class="col-md-1">
	<div class="form-group">
		<div>
			<%-- 			<sf:button --%>
			<%-- 				action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior" --%>
			<%-- 				type="submit" class="boton" id="accionBoton" name="accionBoton" --%>
			<%-- 				value="buscar"> --%>
			<%-- 				<spring:theme code="publicidad.exterior.detail.search" /> --%>
			<%-- 			</sf:button> --%>
			<button style = "margin-top: 27px" id="searchDetailButton" class="btn btn-primary btn-lg"
				type="button">
				<spring:theme code="publicdad.exterior.searchDetailButton"
					text="Buscar" />
			</button>
</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-4 col-md-offset-5 centercol-md-8 text-right">

		<button id="regresar" class="btn btn-primary btn-lg" type="button">
			<spring:theme code="publicidad.exterior.regresar" />
		</button>

		<%-- 		<sf:button --%>
		<%-- 			action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior" --%>
		<%-- 			type="submit" class="boton" id="accionBoton" name="accionBoton" --%>
		<%-- 			value="declarar"> --%>
		<%-- 			<spring:theme code="publicidad.exterior.declarationpresent" /> --%>
		<%-- 		</sf:button> --%>
		<button id="presentarDeclaracionButton" class="btn btn-primary btn-lg"
			type="button">
			<spring:theme code="publicidad.exterior.declarationpresent" />
		</button>
	</div>
</div>
