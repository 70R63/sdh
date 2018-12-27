<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ attribute name="progressBarId" required="true" type="java.lang.String"%>
<%@ attribute name="relationshipUrl" required="false" type="java.lang.String"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row">
<div class="col-sm-12 col-md-8 no-space setup-permissions">
<div class="relationship-steps">
	<div class="checkout-heading">
		<h1>
			<span tabindex="0"><spring:theme code="relationship.heading" /></span>
		</h1>
	</div>
	<ycommerce:testId code="relationSteps">
		<div class="checkout-steps">
			<c:choose>
				<c:when test="${progressBarId eq 'relationship'}">
					<h2>
						<a href="#" role="button" aria-pressed="true" class="step-head active">
							<div class="title">
								<spring:theme code="relationship.step.addRelation" />
							</div>
						</a>
					</h2>
					<div class="step-body"><jsp:doBody /></div>
					<h2>
						<a href="#" role="button" aria-pressed="false" aria-disabled="true" class="step-head js-checkout-step not_visited"> 
							<div class="title">
								<spring:theme code="relationship.step.addPermission" />
							</div>
						</a>
					</h2>
				</c:when>
				<c:when test="${progressBarId eq 'permission'}">
					<h2>
					<spring:url value="/my-account/relationship/edit" var="relationshipEditUrl"/>
						<a href="${relationshipEditUrl}" role="button" aria-pressed="false" aria-disabled="false" class="step-head js-checkout-step "> 
							<div class="title">
								<spring:theme code="relationship.step.addRelation" />
							</div>
							<div class="relationship-edit"></div>
						</a>
					</h2>

					<h2>
						<a href="#" role="button" aria-pressed="true" class="step-head active">
							<div class="title">
								<spring:theme code="relationship.step.addPermission" />
							</div>
						</a>
					</h2>
					<div class="step-body"><jsp:doBody></jsp:doBody></div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</div>
	</ycommerce:testId>
	</div>
</div>
</div>