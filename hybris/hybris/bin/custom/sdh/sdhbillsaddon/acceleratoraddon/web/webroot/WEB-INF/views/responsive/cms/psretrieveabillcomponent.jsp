<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url var="retrieveBillsUrl" value="${retrieveBillUrl}" />
<div class="col-xs-12 yComponentWrapper retrieve-bill-request card-section">
	<div class="card">
		<div class="card-section-h2">
			<span class="glyphicon glyphicon-search"></span> <h3><span tabindex="0">${ycommerce:encodeHTML(title)}</span></h3>
		</div>
		<div class="card-section-content" >
			${ycommerce:sanitizeHTML(description)} <br /> <br />
			<form action="${retrieveBillsUrl}">
				<button class="btn btn-primary btn-block" >
					${ycommerce:encodeHTML(retrieveBillButtonLabel)}
				</button>
			</form>
		</div>
	</div>
</div>