<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">

	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<tbody>
					<tr class="avisobody">
						<td><spring:theme code="facturacion.descuento1PC.inicial.autorizaciones.nota1" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>



	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="facturacion.descuento1PC.inicial.autorizaciones.siAcepto" /> <input
					class="predialNoAceptaFactura"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="checkbox" name="optionSiAceptaFactura"
					id="predialNoAceptaFactura" value="true"> </label>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="facturacion.descuento1PC.inicial.autorizaciones.noAcepto" /> <input
					class="predialNoAceptaFactura"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="checkbox" name="optionSiAceptaFactura"
					id="predialNoAceptaFactura" value="true"> </label>
			</div>
		</div>
	</div>
	
	
		<div class="row">
		<div class="col-md-12">
			<table class="table">
				<tbody>
					<tr class="avisobody">
						<td><spring:theme code="facturacion.descuento1PC.inicial.autorizaciones.nota2" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>



	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="facturacion.descuento1PC.inicial.autorizaciones.siAcepto" /> <input
					class="predialNoAceptaFactura"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="checkbox" name="optionSiAceptaFactura"
					id="predialNoAceptaFactura" value="true"> </label>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label "
					style="font-weight: 400; text-transform: none !important;"><spring:theme
						code="facturacion.descuento1PC.inicial.autorizaciones.noAcepto" /> <input
					class="predialNoAceptaFactura"
					style="visibility: visible !important; left: 0px !important; display: inline-block !important; min-height: 0px; margin-left: 5px !important;"
					type="checkbox" name="optionSiAceptaFactura"
					id="predialNoAceptaFactura" value="true"> </label>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-6">
			<div class="form-group">
				<button id="certificacionRIT" class="btn btn-primary btn-lg" type="button" onclick="certificacionRIT()">
					<spring:theme code="facturacion.descuento1PC.inicial.autorizaciones.certificacionRIT" />
				</button>
				<button id="actualizarRIT" class="btn btn-primary btn-lg" type="button" onclick="actualizarRIT()">
					<spring:theme code="facturacion.descuento1PC.inicial.autorizaciones.actualizarRIT" />
				</button>
			</div>
		</div>
	</div>

</div>



