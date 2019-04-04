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
	<div class="row">
		<div class="col-md-12">
			<div class="avisoheadline "
				style="width: auto; height: 35px;">
				<h2>
					<span class="p"><spring:theme
							code="retenedor.servicio.titulo" /></span>
				</h2>
			</div>
			<p class="avisobody"
				style="width: auto; height: auto;">
				<spring:theme code="retenedor.servicio.descripcion" />
			</p>
		</div>
	</div>



	<div class="row" style="margin-top: 6px;">
		<div class="col-md-12">
			<form:form action="">
				<div class="table-responsive">
					<table class="table col-md-2 table-bordered">
						<thead>
							<tr>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.tipdoc" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.numdoc" /></label></td>
								<td><label class="control-label text-capitalize !important"><spring:theme
											code="retenedor.servicio.nombre" /></label></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input class="inputtextnew" disabled="disabled"
									type="text" size="30" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									type="text" size="30" /></td>
								<td><input class="inputtextnew" disabled="disabled"
									type="text" size="30" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
</div>
