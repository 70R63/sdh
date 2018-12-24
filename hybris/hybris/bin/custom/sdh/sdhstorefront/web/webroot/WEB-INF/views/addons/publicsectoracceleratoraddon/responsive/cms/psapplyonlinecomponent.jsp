<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:if test="${not empty applyOnline and not empty serviceProduct.allYFormDefinitionList and not empty applyOnline.title}">
	<div class="row no-margin">
		<div class="card col-xs-12 col-sm-12 col-md-12">
			<div class="pdp-section-h2"><h2><span tabindex="0">${ycommerce:encodeHTML(applyOnline.title)}</span></h2></div>
			<div class="pdp-section-content">
				<div>
					<p>${ycommerce:sanitizeHTML(applyOnline.description)}</p>
					<action:actions element="div" parentComponent="${component}" />
				</div>
			</div>
		</div>
	</div>
</c:if>