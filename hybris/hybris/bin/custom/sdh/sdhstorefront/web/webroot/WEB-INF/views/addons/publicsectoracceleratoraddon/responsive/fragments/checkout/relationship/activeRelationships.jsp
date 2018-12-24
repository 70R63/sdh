<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/checkout/multi/relations/chooseApplicant" var="chooseApplicantUrl" />

<div class="row no-margin">
	<div class="col-md-10">
		<div class="active-relationship">
			<spring:theme code="checkout.changeApplicant.popup.message" var="changeApplicantPopupMessage" />
			<span tabindex="0" aria-label="${changeApplicantPopupMessage}"> <spring:theme code="checkout.changeApplicant.popup.message" />
			</span>
		</div>

		<br>

		<c:if test="${ showCurrentUser eq true }">
			<spring:theme code="checkout.changeApplicant.popup.currentUser.accessibility.text"
				arguments="${currentUser.title},${currentUser.firstName},${currentUser.lastName}" var="currentUserText" />
			<div tabindex="0" aria-label="${currentUserText}">
				<spring:theme code="checkout.changeApplicant.popup.currentUser.text"
					arguments="${currentUser.title},${currentUser.firstName},${currentUser.lastName}" htmlEscape="false" var="currentUserText" />
					${ycommerce:sanitizeHTML(currentUserText)}
			</div>
			<br>
			<form id="${ycommerce:encodeHTML(currentUser.uid)}_chooseApplicantForm" action="${chooseApplicantUrl}" method="post">
				<input type="hidden" name="userId" value="${ycommerce:encodeHTML(currentUser.uid)}" /> <input type="hidden" name="CSRFToken" value="${CSRFToken.token}" />
				<button type="submit" class="btn btn-primary btn-block">
					<spring:theme code="checkout.changeApplicant.popup.currentUser.button.text" />
				</button>
			</form>
			<br>
			<br>
		</c:if>
		<c:forEach items="${relations}" var="relation">
			<spring:theme code="checkout.changeApplicant.popup.accessibility.text"
				arguments=" ${relation.title }, ${relation.firstName}, ${relation.lastName}" var="changeApplicantPopupText" />
			<div tabindex="0" aria-label="${changeApplicantPopupText}">
				<spring:theme code="checkout.changeApplicant.popup.text" arguments=" ${relation.title }, ${relation.firstName}, ${relation.lastName}"  htmlEscape="false" var="changeApplicantPopupText"/>
			    ${ycommerce:sanitizeHTML(changeApplicantPopupText)}
			</div>
			<br>
			<form id="${ycommerce:encodeHTML(relation.uid)}_chooseApplicantForm" action="${chooseApplicantUrl}" method="post">
				<input type="hidden" name="userId" value="${ycommerce:encodeHTML(relation.uid)}" /> <input type="hidden" name="CSRFToken" value="${CSRFToken.token}" />
				<button type="submit" class="btn btn-primary btn-block" value="">
					<spring:theme code="checkout.changeApplicant.popup.button.text" />
				</button>
			</form>
			<br>
			<br>
		</c:forEach>

	</div>
</div>