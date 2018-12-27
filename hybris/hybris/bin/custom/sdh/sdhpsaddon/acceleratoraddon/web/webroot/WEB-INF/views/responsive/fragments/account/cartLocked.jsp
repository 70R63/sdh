<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
 
<spring:theme code="cart.lock.message.line1" var="messageLine1"/>
<spring:theme code="cart.lock.message.line2" arguments="${lockedRemainingTime}" htmlEscape="false" var="messageLine2"/> 

<div id="locked-draft-overlay">
	<span tabindex="0" aria-label="${ycommerce:sanitizeHTML(messageLine1)}">
		${ycommerce:sanitizeHTML(messageLine1)}
	</span>
	<p tabindex="0" aria-label="${ycommerce:sanitizeHTML(messageLine2)}">
		${ycommerce:sanitizeHTML(messageLine2)}
	</p>
</div>