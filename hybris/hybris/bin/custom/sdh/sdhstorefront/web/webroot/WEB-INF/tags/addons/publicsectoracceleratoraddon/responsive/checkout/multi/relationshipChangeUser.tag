<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="user" required="true" type="de.hybris.platform.commercefacades.user.data.CustomerData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:if test="${hasRelationWithRequestAccess eq true}">
	<div class="row no-margin relationship-change-user">
		<div class="card col-md-12">
			<div class="card-section">
				<c:if test="${isContextUserCurrentUser eq false}">
					<p tabindex="0">
						<spring:theme code="relationship.changeUser.text"  htmlEscape="false" var="changeUserText" arguments="${userInContext.firstName}, ${userInContext.lastName}"/>
						${ycommerce:sanitizeHTML(changeUserText)}
					</p>
				</c:if>
				<c:if test="${isContextUserCurrentUser eq true }">
					<p tabindex="0">
						<spring:theme code="relationship.currentUser.text" htmlEscape="false" var="currentUserText"/>
						${ycommerce:sanitizeHTML(currentUserText)}
					</p>
				</c:if>
				<button type="button" class="btn btn-primary btn-block checkout-next positive right place-order changeUserBtn">
					<spring:theme code="relationship.changeUser.button.text" text="Change" />
				</button>
				<div class="hide">
					<div class="headline">
						<span class="headline-text" tabindex="0"><spring:theme code="relationship.changeUser.popup.Heading" text="Change Applicant" /></span>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>