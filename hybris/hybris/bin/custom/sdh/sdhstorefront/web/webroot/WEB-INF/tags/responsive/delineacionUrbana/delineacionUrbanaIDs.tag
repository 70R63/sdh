<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row" >
		<div class="avisoheadline">
			<h3>
				<span class="p"><spring:theme code="delineacion.urbana.title"
						text="Delineacion Urbana" /></span>
			</h3>
		</div>
		<p class="avisobody">
			<spring:theme code="delineacion.urbana.desciption" />
			<a href="http://www.shd.gov.co/shd/" target="_blank"> Mas
				información</a>
		</p>
	</div>
	<br>
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
						<td><input disabled class="inputtextnew" aria-required="true"
							maxlength="30" size="30" readonly="readonly" type="text"
							value="${dataForm.valCont.infoContrib.tipoDoc}" /></td>
						<td><input readonly="readonly" class="inputtextnew"
							aria-required="true" maxlength="30" size="30" disabled="disabled"
							type="text" value="${dataForm.valCont.infoContrib.numDoc}" /></td>
						<td><input value="${dataForm.valCont.infoContrib.adicionales.NAME_ORG1}" disabled class="inputtextnew"
							aria-required="true" maxlength="30" size="30" readonly="readonly"
							type="text" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-12">
			<spring:theme code="delineacion.urbana.nota" />
		</div>
	</div>
</div>













