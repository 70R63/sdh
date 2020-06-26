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
			<span class="col-md-10 "><spring:theme code="terceros.objeto.predial.titulo" /></span>
		</h2>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table id="tabPaginacion0" 
					class="table table-bordered">
					<thead>
						<tr>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.predial.chip" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.predial.matriculaInmobiliaria" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.predial.direccion" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.predial.anoGravable" /></label></td>
							<td><label class="control-label labeltabletd"><spring:theme
										code="terceros.objeto.predial.estadoObligacion" /></label></td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>