<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
	<div class="col-md-6">
		<h3>
			<span tabindex="0"><spring:theme
					code="declaracion.publicidad.pago" /></span>
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-sm-6 col-sm-push-6">
		<div class="accountActions">
			<button type="button" class="btn btn-default btn-block">
				<spring:theme code="declaracion.publicidad.button.gendecl"/>
			</button>
		</div>

		<div class="accountActions">
			<button type="button" class="btn btn-default btn-block">
				<spring:theme code="declaracion.publicidad.button.crenewdec"/>
			</button>
		</div>
		<div class="accountActions">
			<button type="button" class="btn btn-default btn-block">
				<spring:theme code="declaracion.publicidad.button.presdec"/>
			</button>
		</div>
		<div class="accountActions">
			<button type="button" class="btn btn-default btn-block">
				<spring:theme code="declaracion.publicidad.button.pag"/>
			</button>
		</div>
	</div>

</div>

