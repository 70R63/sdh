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
<div class="container_new_page">
	<div class="headlinecol-md-12">
		<h2>
			<span class="col-md-10 "><spring:theme code="terceros.objeto.publicidad.titulo" /></span>
		</h2>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table id="tabPaginacion5" 
					class="table table-bordered">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.publicidad.anoGravable" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.publicidad.numResolucion" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.publicidad.direccionValla" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.publicidad.orientacionValla" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.publicidad.estadoObligacion" /></label></td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

