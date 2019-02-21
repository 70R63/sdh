<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/calculo" var="CalculodeclaracionUrl"
	htmlEscape="false" />


<div class="row">
	<div class="avisoheadline">
		<h3>
			<span class="p"><spring:theme code="publicidad.exterior.title"
					text="Publicidad Exterior" /></span>
		</h3>
	</div>
	<p class="avisobody">
		<spring:theme code="publicidad.exterior.description" />
	</p>
</div>

<br>

<!-- <form:form action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior/detalle" method="post" commandName="publicidadFormReq"> -->

<input type="hidden" value="" id="selectedTipoValla" />

<input type="hidden" value="" id="selectedNumRes" />
<div class="row">
	<div class="table-responsive">
		<table class="table col-md-2 table-bordered">
			<thead>
				<tr>
					<td><label class="control-label text-capitalize !important"><spring:theme
								code="publicidad.exterior.tipodocumento" /></label></td>
					<td><label class="control-label text-capitalize !important"><spring:theme
								code="publicidad.exterior.numdocumento" /></label></td>
					<td><label class="control-label text-capitalize !important"><spring:theme
								code="publicidad.esterior.nombre" /></label></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input value="tipoDocumento" disabled class="inputtextnew"
						aria-required="true" maxlength="30" size="30" readonly="readonly"
						type="text" /></td>
					<td><input value="numeroDocumento" readonly="readonly"
						class="inputtextnew" aria-required="true" maxlength="30" size="30"
						disabled="disabled" type="text" /></td>
					<td><input value="nombre" disabled class="inputtextnew"
						aria-required="true" maxlength="30" size="30" readonly="readonly"
						type="text" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="row">
		<div class="col-md-1">
			<label class="control-label text-capitalize !important"><spring:theme
					code="publicidad.exterior.showing" /></label>
		</div>
		<div class="col-md-1">
			<select id="mostrando" name="mostrando" class="form-control">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
			</select>
		</div>
		<div class="col-md-2 col-md-offset-5">
			<label class="control-label text-capitalize !important"><spring:theme
					code="publicidad.exterior.search" /></label>
		</div>
		<div class="col-md-2">
			<input value="referencia" class="form-control" maxlength="30"
				size="30" type="text" />
		</div>
	</div>
	<br>
	<div class="row">
		<div class="table-responsive">
			<table class="table col-md-2 table-bordered" id="example ">
				<thead>
					<tr>
						<th><label class="control-label " for=""><spring:theme
									code="publicidad.exterior.resolutionnumber" /></label></th>
						<th><label class="control-label " for=""> <spring:theme
									code="publicidad.exterior.typefence" /></label></th>
						<th><label class="control-label " for=""> <spring:theme
									code="publicidad.exterior.detalle" /></label></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="loop" items="${publicidadForm.publicidadExt}"
						var="eachPubExtTax">
						<tr>
							<td><c:out value="${eachPubExtTax.numResolu}"></c:out></td>
							<td><c:out value="${eachPubExtTax.tipoValla}"></c:out></td>
							<td><label data-numRes="${eachPubExtTax.numResolu}" data-tipoValla="${eachPubExtTax.tipoValla}" class="control-label text-capitalize !important labelVer"><spring:theme
										code="publicidad.exterior.ver" /></label></td>

						<%--	<td><input id="action"
								style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" type="radio"
								value="${eachPubExtTax.numResolu}, ${eachPubExtTax.tipoValla}"
								data-numRes="${eachPubExtTax.numResolu}"
								data-tipoValla="${eachPubExtTax.tipoValla}"></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<input name="numResolu" type="hidden" id="resol" /> <input
				name="tipoValla" type="hidden" id="tValla" /> <input
				id="inIdVariable" type="hidden" value="">

			<div id="divIdVariable"
				style="display: none !important; margin: 0; min-height: 0;">
				<input id="inIdVariable" value="">
			</div>

			<div id="numResolu"
				style="display: none !important; margin: 0; min-height: 0;">
				<input id="resol" value="">
			</div>

			<div id="anoGravable"
				style="display: none !important; margin: 0; min-height: 0;">
				<input id="tValla" value="">
			</div>

		</div>

	</div>

	<div class="row">
		<div class="col-md-2 col-md-offset-5 center">

			<%-- 		<sf:button --%>
			<%-- 			action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior" --%>
			<%-- 			type="submit" class="boton" id="accionBoton" name="accionBoton" --%>
			<%-- 			value="declarar"> --%>
			<%-- 			<spring:theme code="publicidad.exterior.declarationpresent" /> --%>
			<%-- 		</sf:button> --%>
			<button id="presentarDeclaracionButton" class="" type="button">
				<spring:theme code="publicdad.exterior.presentarDeclaracionButton"
					text="Presentar" />
			</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-offset-5 center">
			<div class="boton">
				<spring:theme code="publicidad.exterior.rop" />
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2 col-md-offset-5 center">
			<div class="boton">
				<spring:theme code="publicidad.exterior.payonline" />
			</div>
		</div>
	</div>

	<div class="row">
		<div class="headline">
			<h3>
				<span class="cintillo col-md-10"><spring:theme
						code="publicidad.exterior.detail.outdooradvertising" /></span>
			</h3>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme
					code="publicidad.exterior.detail.selectYear" /></label>
		</div>
		<div class="col-md-1">
			<select id="anio" class="inputdropdown" name="anoGravable">
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>

			</select>
		</div>

		<div class="col-md-1 col-md-offset-1">
			<div>
				<%-- 			<sf:button --%>
				<%-- 				action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior" --%>
				<%-- 				type="submit" class="boton" id="accionBoton" name="accionBoton" --%>
				<%-- 				value="buscar"> --%>
				<%-- 				<spring:theme code="publicidad.exterior.detail.search" /> --%>
				<%-- 			</sf:button> --%>
				<button id="searchDetailButton" class="" type="button">
					<spring:theme code="publicdad.exterior.searchDetailButton"
						text="Buscar" />
				</button>

			</div>
		</div>
	</div>
</div>
<!-- </form:form> -->



