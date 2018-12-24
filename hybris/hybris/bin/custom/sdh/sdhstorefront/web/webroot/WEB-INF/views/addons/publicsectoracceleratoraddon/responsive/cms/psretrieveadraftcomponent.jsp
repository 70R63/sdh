<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
 
<spring:url var="retrieveDraftsUrl" value="${retrieveDraftUrl}" />
<div class="retrieve-draft-request card-section">
	<div class="card">
		<div class="card-section-h2">
			<span class="glyphicon glyphicon-search"></span> <h3><span tabindex="0">${ycommerce:encodeHTML(title)}</span></h3>
		</div>
		<div class="card-section-content" >
			 ${ycommerce:sanitizeHTML(description)} <br /> <br />
			<form action="${retrieveDraftsUrl}">
				<button class="btn btn-primary btn-block" >
					 ${ycommerce:encodeHTML(retrieveDraftButtonLabel)}
				</button>
			</form>
		</div>
	</div>
</div>