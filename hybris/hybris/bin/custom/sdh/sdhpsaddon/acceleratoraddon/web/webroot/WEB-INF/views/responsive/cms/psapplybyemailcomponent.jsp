<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:if test="${not empty applyByEmail and not empty applyByEmail.title}">
	<div class="row no-margin">
		<div class="card col-xs-12 col-sm-12 col-md-12">
			<div class="pdp-section-h2"><h2><span tabindex="0">${ycommerce:encodeHTML(applyByEmail.title)}</span></h2></div>
			<div class="pdp-section-content">${ycommerce:sanitizeHTML(applyByEmail.description)}</div>
		</div>
	</div>
</c:if>

