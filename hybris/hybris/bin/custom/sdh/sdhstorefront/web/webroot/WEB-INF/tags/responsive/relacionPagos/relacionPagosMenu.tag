<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />


<c:set var="claveImpuesto_1" value="false"/>
<c:set var="claveImpuesto_2" value="false"/>
<c:set var="claveImpuesto_3" value="false"/>
<c:set var="claveImpuesto_4" value="false"/>
<c:set var="claveImpuesto_5" value="false"/>
<c:set var="claveImpuesto_6" value="false"/>

<c:if test="${not empty relacionPagosForm.predial}">
<c:set var="claveImpuesto_1" value="true"/>
</c:if>
<c:if test="${not empty relacionPagosForm.vehicular}">
<c:set var="claveImpuesto_2" value="true"/>
</c:if>
<c:if test="${not empty relacionPagosForm.impuestoICA}">
<c:set var="claveImpuesto_3" value="true"/>
</c:if>
<c:if test="${not empty relacionPagosForm.publicidadExt}">
<c:set var="claveImpuesto_4" value="true"/>
</c:if>
<c:if test="${not empty relacionPagosForm.gasolina}">
<c:set var="claveImpuesto_5" value="true"/>
</c:if>
<c:if test="${not empty relacionPagosForm.delineacion}">
<c:set var="claveImpuesto_6" value="true"/>
</c:if>
<div class="container_new_page">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td style="text-align: center"><spring:theme
								code="relacion.inicial.titulo" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="relacion.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información.</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="headline">
			<h2>
				<span><spring:theme code="relacion.inicial.titulo" /></span>

			</h2>
		</div>
	</div>


	<sf:form>
		<div class="row">
			<div class="col-md-6"></div>
			<c:choose>
			<c:when test="${not empty Retenedor}">
						<div class="col-md-3" id="idImpuesto">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="relacion.inicial.selcimpuesto" /></label> <select id="impuesto"
						class="new_alto form-control " name="impuesto"
						onchange="Selected(this)">
						<option value="7">RETEICA</option>
					</select>
				</div>
			</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-3" id="idImpuesto">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="relacion.inicial.selcimpuesto" /></label> <select id="impuesto"
						class="new_alto form-control " name="impuesto"
						onchange="Selected(this)">
						<option value="0">Seleccionar</option>
						<c:if test="${claveImpuesto_1}"><option value="1"><spring:theme code="relacion.inicial.impuestos.0001"/></option></c:if>
						<c:if test="${claveImpuesto_2}"><option value="2"><spring:theme code="relacion.inicial.impuestos.0002"/></option></c:if>
						<c:if test="${claveImpuesto_3}"><option value="3"><spring:theme code="relacion.inicial.impuestos.0003"/></option></c:if>
						<c:if test="${claveImpuesto_4}"><option value="4"><spring:theme code="relacion.inicial.impuestos.0004"/></option></c:if>
						<c:if test="${claveImpuesto_5}"><option value="5"><spring:theme code="relacion.inicial.impuestos.0005"/></option></c:if>
						<c:if test="${claveImpuesto_6}"><option value="6"><spring:theme code="relacion.inicial.impuestos.0006"/></option></c:if>
					</select>
				</div>
			</div>
			</c:otherwise>
			</c:choose>

		</div>

		

		<div class="row">
			<div class="col-md-2">
				<div class="form-group">
					<button type="button" class="btn btn-primary btn-lg" id="descargaRelacionPDF" name="action" value="generar" style="margin-top: 3px" onclick="descargaRelacionPagosPDF()">  
						<spring:theme code="relacion.inicial.descargar" />
					</button>
				</div>
			</div>
			
			<div class="col-md-2">
				<div class="form-check">

				</div>
			</div>

			<div class="col-md-2">
				<div class="form-group ">
					<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="buscar" style="margin-top: 3px"
						onclick=" Selectedver(this)">
						<spring:theme code="relacion.inicial.buscar" />
					</button>

				</div>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-secondary btn-lg" id="action"
					name="action" value="cancelar" style="margin-top: 3px"
					onclick="cancelfun(this)">
					<spring:theme code="relacion.inicial.cancelar" />
				</button>

			</div>
		</div>
	</sf:form>
</div>
