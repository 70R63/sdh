<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:if test="${not empty relatedLinks and not empty relatedLinks.title and not empty relatedLinks.links}">
	<div class="row no-margin">
		<div class="card col-xs-12 col-sm-12 col-md-12">
			<div class="pdp-section-h2"><h2><span tabindex="0">${ycommerce:encodeHTML(relatedLinks.title)}</span></h2></div>
			<div class="pdp-section-content">
				<c:forEach items="${relatedLinks.links}" var="link" varStatus="step">
					<div>
						<a href="${ycommerce:encodeHTML(link.url)}"
						   title="${ycommerce:encodeHTML(link.linkName)}"> ${ycommerce:encodeHTML(link.linkName)}</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</c:if>
