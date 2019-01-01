<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:if test="${ not empty applyByPhone and not empty applyByPhone.title}">
	<div class="row no-margin">
		<div class="card col-xs-12 col-sm-12 col-md-12">
			<div class="pdp-section-h2"><h2><span tabindex="0">${ycommerce:encodeHTML(applyByPhone.title)}</span></h2></div>
			<div class="pdp-section-content card-section-content">
				<div>${ycommerce:sanitizeHTML(applyByPhone.description)}</div>
			</div>
		</div>
	</div>
</c:if>