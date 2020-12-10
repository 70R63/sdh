<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<sf:form>
<div class="container">
	<div class="row">
		<div class="col-md-6 headline">
			<h2>
				<span><spring:theme code="sobre.vehiculo.juridicos.title" /></span>
			</h2>
		</div>
	</div>

	
		<div class="row table-responsive">
			<div class="col-md-5">
				<br>
				<table class="table tableJur" id="tableJur">
					<thead>
						<tr>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.juridicos.calidsuje" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.juridicos.propiedad" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.juridicos.fecdesde" /></label></th>
							<th><label class="control-label labeltabletd"><spring:theme
										code="sobre.vehiculo.juridicos.fechasta" /></label></th>
						</tr>
					</thead>

					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</sf:form>