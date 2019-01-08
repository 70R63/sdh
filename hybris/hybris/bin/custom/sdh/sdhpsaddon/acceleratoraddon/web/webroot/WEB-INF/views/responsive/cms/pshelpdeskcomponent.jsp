<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:if test="${not empty helpDesk and not empty helpDesk.title}">
	<div class="row no-margin">
		<div class="card col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="card-section">
				<div class="card-section-h2"><h2><span tabindex="0">${ycommerce:encodeHTML(helpDesk.title)}</span></h2></div>
				<div class="card-section-content" aria-labelledby="helpSection" tabindex="0">
					<div id="helpSection">${ycommerce:sanitizeHTML(helpDesk.description)}</div>
				</div>
			</div>
		</div>
	</div>
</c:if>
