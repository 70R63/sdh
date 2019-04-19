<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form>
	<div class="container">
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr class="avisoheadline p">
						<td><spring:theme code="obligacion.inicial.encabezado" /></td>
					</tr>
				</thead>
				<tbody>
					<tr class="avisobody">

						<td><spring:theme code="obligacion.inicial.descripcion" /><a
							href="http://www.shd.gov.co/shd/" target="_blank"> Mas
								información.</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		<div class="row">
			<div class="headline">
				<h2 align="center">
					<span><spring:theme code="obligacion.inicial.titulo" /></span>

				</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 text-center">
				<div class="form-group">
					<label class="control-label"><spring:theme
							code="obligacion.inicial.buscarpor" /></label>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6 text-right">
				<div class="form-group">
				<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="generar" style="margin-top: 3px" onclick="ShowSujeto(this)">
						<spring:theme code="obligacion.inicial.sujeto" />
					</button>
				</div>
			</div>
			<div class="col-md-6 text-left">
				<div class="form-group">
				<button type="button" class="btn btn-primary btn-lg" id="action"
						name="action" value="impuesto" style="margin-top: 3px" onclick="ShowImpuesto(this)">
						<spring:theme code="obligacion.inicial.impu" />
					</button>
				</div>
			</div>
		</div>
		<hr
		style="background-color: #56ace3 !important; border-top: 1px solid #56ace3 !important;" />
	</div>
</sf:form>

