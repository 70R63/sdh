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
<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="publicidad.exterior.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">
						<td><spring:theme code="publicidad.exterior.description" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>





	<!-- <form:form action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior/detalle" method="post" commandName="publicidadFormReq"> -->

	<input type="hidden" value="" id="selectedTipoValla" /> <input
		type="hidden" value="" id="selectedNumRes" />
	<div class="row mt-3">
		<div class="col-md-12 col-md-offset-4 d-flex align-items-center">

			<div class="table-responsive text-center">
				<table class="table table-bordered" style="width:auto !important">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tableident"><spring:theme
										code="publicidad.exterior.tipodocumento" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="publicidad.exterior.numdocumento" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="publicidad.esterior.nombre" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${docType }" /></td>
							<td><c:out value="${docNumber }" /></td>
							<td><c:out value="${name }" /></td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
	</div>

	<br>
	<div class="row">
		<div class="col-md-7 table-responsive">
			<table class="table col-md-2 table-bordered" id="example">
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
					<c:forEach varStatus="loop" items="${publicidadForm.publicidadExt}" var="eachPubExtTax">
						<tr>
							<td><c:out value="${eachPubExtTax.numResolu}"></c:out></td>
							<td><c:out value="${eachPubExtTax.tipoValla}"></c:out></td>
							<td><label style="color: #0358d8 !important"
								data-numRes="${eachPubExtTax.numResolu}"
								data-anoGravable="${eachPubExtTax.anoGravable}"
								data-tipoValla="${eachPubExtTax.tipoVallaCode}"
								class="text-capitalize !important labelVer "><spring:theme
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

	<!-- </form:form> -->
</div>



