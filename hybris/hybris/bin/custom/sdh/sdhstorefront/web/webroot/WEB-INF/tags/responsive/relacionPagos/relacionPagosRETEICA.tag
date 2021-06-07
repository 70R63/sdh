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
		<div id="detalle-reteica" style="display: block;">
			<div class="row">
				<div class="headline">
					<h2>
						<span><spring:theme code="relacion.inicial.reteica.titulo" /></span>
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8 text-center">
					<div class="table-responsive">
						<table class="table table-bordered" id="">
							<thead>
								<tr>
									<th><label class="control-label labeltabletd tableangrav"><spring:theme
												code="relacion.inicial.reteica.aniograv" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.reteica.periodo" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.reteica.tipdocu" /> </label></th>
									<th><label class="control-label labeltabletd"><spring:theme
												code="relacion.inicial.reteica.numrefrec" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.reteica.numform" /> </label></th>
									<th><label class="control-label labeltabletd tablefechas"><spring:theme
												code="relacion.inicial.reteica.fecprese" /> </label></th>
									<th><label class="control-label labeltabletd tabledoobli"><spring:theme
												code="relacion.inicial.reteica.totpag" /> </label></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew " disabled="disabled"
										value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tablefechas"
										disabled="disabled" value="" type="text" /></td>
									<td><input class="inputtextnew tabledoobli"
										disabled="disabled" value="" type="text" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</sf:form>