<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="action" tagdir="/WEB-INF/tags/responsive/action"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:if test="${not empty keyFacts and not empty keyFacts.title}">
	<div class="row no-margin">
		<div class="card col-xs-12 col-sm-12 col-md-12 hidden-xs ">
			<div class="pdp-section-h2"><h2><span tabindex="0">${ycommerce:encodeHTML(keyFacts.title)}</span></h2></div>
			<div class="pdp-section-content ">${ycommerce:sanitizeHTML(keyFacts.description)}</div>
			<p></p>
			<div>
				<c:if test="${not empty serviceProduct.allYFormDefinitionList }">
					<action:actions element="div" parentComponent="${component}"/>
				</c:if>
			</div>
		</div>
	</div>
</c:if>
