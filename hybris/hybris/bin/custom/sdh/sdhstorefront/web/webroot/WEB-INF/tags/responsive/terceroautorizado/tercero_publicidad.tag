<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>

<spring:htmlEscape defaultHtmlEscape="true"/>
<div class="container_new_page" id="table-publicidad" style="display: none">
	<div class="headlinecol-md-12">
		<h2>
			<span class="col-md-10 "><spring:theme code="terceros.objeto.publicidad.titulo" /></span>
		</h2>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="table-responsive">
				<table id="table-publicidad1" 
					class="table table-bordered tabPaginacion6">
					<thead>
						<tr>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.publicidad.anoGravable" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.publicidad.numResolucion" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.publicidad.direccionValla" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.publicidad.orientacionValla" /></label></th>
							<th><label class="control-label labeltableth"><spring:theme
										code="terceros.objeto.publicidad.estadoObligacion" /></label></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<br>
</div>

