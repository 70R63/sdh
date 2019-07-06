<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<div class="container">
	<div class="row">
		<div class="headline">
			<h2>
				<span class="col-md-10 "><spring:theme
						code="ica.detalle.datadicionales.titulo" /></span>
			</h2>
		</div>
	</div>
	<div class="row">

		<div class="col-md-4">
			<div class="form-group">

				<label class="control-label"><spring:theme
						code="ica.detalle.datadicionales.clase" /></label> <select id="" name=""
					class="form-control" disabled>

				</select>
			</div>
		</div>
	</div>
</div>



