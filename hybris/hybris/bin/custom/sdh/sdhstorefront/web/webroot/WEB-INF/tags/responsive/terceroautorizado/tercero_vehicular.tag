<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container_new_page" id="table-vehicular" style="display: none">
	<div class="headlinecol-md-12">
		<h2>
			<span class="col-md-10 "><spring:theme code="terceros.objeto.vehicular.titulo" /></span>
		</h2>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table id="table-vehicular1" 
					class="table table-bordered tabPaginacion1">
					<thead>
						<tr>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.vehicular.anoGravable" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.vehicular.placa" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.vehicular.modelo" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.vehicular.marca" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.vehicular.linea" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.vehicular.estadoObligacion" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-md-3 col-md-offset-8">
		<button type="button" class="btn btn-primary btn-lg" id="action"
			name="action" value="Imprimir" style="margin-top: 3px"
			onclick="ACC.oblipend.bindTrmPdf('0002','4','vehicularReporte.pdf');">
			<spring:theme code="obligacion.inicial.imprimir" />
		</button>
	</div>
	<br>
</div>

