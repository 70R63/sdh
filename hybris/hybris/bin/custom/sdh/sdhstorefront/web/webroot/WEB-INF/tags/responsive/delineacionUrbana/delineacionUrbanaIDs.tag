<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new_page">
<c:if test="${mensajeDelinea != null}">
			<div class="row">
				<div class="col-12 notas_deli">
					<div class="alert alert-danger mt-3">
						<spring:theme code="${mensajeDelinea}" />
					</div>
				</div>
			</div>
		</c:if>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="delineacion.urbana.title" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="delineacion.urbana.desciption" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<c:set var="nombreCompleto"
	value='${dataForm.valCont.infoContrib.primNom} ${dataForm.valCont.infoContrib.primApe}' />
<div class="row mt-3">
	<div class="col-md-12 col-md-offset-4 d-flex align-items-center">
		<form:form action="">
			<div class="table-responsive text-center">
				<table class="table table-bordered" style="width:auto !important">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd tableident"><spring:theme
										code="publicidad.exterior.tipodocumento" /></label></td>
							<td><label class="control-label labeltabletd tablenumiden"><spring:theme
										code="publicidad.exterior.numdocumento" /></label></td>
							<td><label class="control-label labeltabletd "><spring:theme
										code="publicidad.esterior.nombre" /></label></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${dataForm.valCont.infoContrib.tipoDoc}" /></td>
							<td><c:out value="${dataForm.valCont.infoContrib.numDoc}" /></td>
							<td><c:out value="${nombreCompleto}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>
</div>

<div class="container">
	<div class="col-md-12">
		<spring:theme code="delineacion.urbana.nota" />
	</div>
</div>




