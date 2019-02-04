<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url	value="/calculo" var="CalculodeclaracionUrl" htmlEscape="false" />


<div class="row">
	<div class="avisoheadline">
		<h3>
			<span class="p"><spring:theme code="publicidad.exterior.title"	text="Publicidad Exterior" /></span>
		</h3>
	</div>
	<p class="avisobody">
		<spring:theme code="publicidad.exterior.description" />
	</p>
</div>

<br>

<!-- <form:form action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior/detalle" method="post" commandName="publicidadFormReq"> -->

	<div class="col-md-6 col-md-offset-3">
		<div class="table-responsive">
			<table class="table" id="example">
				<thead>
					<tr>
						<th><label class="control-label " for=""><spring:theme code="publicidad.exterior.resolutionnumber" /></label></th>
						<th><label class="control-label " for=""> <spring:theme code="publicidad.exterior.typefence" /></label></th>
						<th><label class="control-label " for=""> <spring:theme code="publicidad.exterior.select" /></label></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach varStatus="loop" items="${publicidadForm.publicidadExt}"	var="eachPubExtTax">
						<tr>
							<td><c:out value="${eachPubExtTax.numResolu}"></c:out></td>
							<td><c:out value="${eachPubExtTax.tipoValla}"></c:out></td>
							<td><input id="action"	style="visibility: visible !important; margin: 0; min-height: 0;"
								name="action" onchange="funcionUno(${loop.index})" type="radio"
								value="${eachPubExtTax.numResolu}, ${eachPubExtTax.tipoValla}"></td>
								
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<input name="numResolu" type="hidden" id="resol"/>
			<input name="tipoValla" type="hidden" id="tValla"/>
			<input id="inIdVariable" type="hidden" value="">
			
			  <div id="divIdVariable" style= "display:none !important; margin: 0; min-height: 0;" > 
				<input id="inIdVariable" value="">
			</div>

			<div id="numResolu" style="display:none !important; margin: 0; min-height: 0;">
				<input id="resol" value="">
			</div>

			<div id="anoGravable" style="display:none !important; margin: 0; min-height: 0;">
				<input id="tValla" value="">
			</div>
			
		</div>
	</div>



	<div class="row">
		<div class="col-md-2 col-md-offset-5 center">
			
			<sf:button action="" class="boton" type="submit">
			<spring:theme code="publicidad.exterior.declarationpresent" />
		</sf:button> 
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
				<span class="cintillo col-md-10"><spring:theme	code="publicidad.exterior.detail.outdooradvertising" /></span>
			</h3>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<label class="inputlabelnew"><spring:theme	code="publicidad.exterior.detail.selectYear" /></label>
		</div>
		<div class="col-md-1">
			<select id="anio" class="inputdropdown" name="anoGravable" onchange="ShowSelected(this)">
				<option value="0">Selecciona un año</option>
				<option value="2019">2019</option>
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>

			</select>
		</div>
		
		<div class="col-md-1 col-md-offset-1">
			<div>		
		<!-- 	<sf:form action="/sdhstorefront/contribuyentes2/publicidadexterior/detalle" id="detalle"  method="POST">
			<button action="/sdhstorefront/contribuyentes2/publicidadexterior/detalle" type="submit" class = "botton">
					<spring:theme code="publicidad.exterior.detail.search" />
				</button>
			</sf:form> -->
			
			<form:form action="${pageContext.request.contextPath}/contribuyentes2/publicidadexterior/detalle" method="post" commandName="publicidadForm">
				<button  type="submit" class = "botton"> <!-- /sdhstorefront/es onclick="functionDos()" id="/contribuyentes2/publicidadexterior/detalle -->
					<spring:theme code="publicidad.exterior.detail.search" />
				</button>
			</form:form>
				
			</div>
		</div>
	</div>
<!-- </form:form> -->



