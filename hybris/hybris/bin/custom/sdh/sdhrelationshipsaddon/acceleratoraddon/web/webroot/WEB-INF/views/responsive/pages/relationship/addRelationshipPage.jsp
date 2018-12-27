<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/formElement"%>
<%@ taglib prefix="relationship" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/relationship"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/my-account/relationship/add" var="relationshipPostUrl"/>
<spring:url value="${source}" var="cancelUrl"/>
<spring:url value="/my-account/relationship/poa/add"  var="setUpPermissionsUrlForRelationshipUser"/>
<spring:htmlEscape defaultHtmlEscape="true" />

<relationship:relationshipSteps progressBarId="relationship">
	<jsp:body>
		<div class="checkout-steps">
		<!-- Step 1-->
			<p class="continuous-text">
				<spring:theme code="relationship.fieldsRequired" htmlEscape="false"/>
			</p>
			<p class="continuous-text">
				<h3>
				<span tabindex="0">
					<c:choose>
						<c:when test="${not empty relationshipCustomer}">
							<spring:theme code="relationship.customer.text" arguments="${relationshipCustomer.firstName}"/>
						</c:when>
						<c:otherwise>
							<strong><spring:theme code="relationship.text" /></strong>
						</c:otherwise>
					</c:choose>
					</span>
				</h3>
			</p>
			<ycommerce:testId code="relationshipForm">
				<c:if test="${not empty relationshipCustomer}">
						<spring:url value="/my-account/relationship/poa/add"  var="relationshipPostUrl"/>
				</c:if>

				<form:form id="relationshipForm" name="relationshipForm" action="${relationshipPostUrl}" commandName="relationshipForm" method="POST">
					<div class="row">
						<div class="col-sm-12 no-space">
							<div class="form-group">
								<formElement:formSelectBox idKey="title" labelKey="relation.title" path="title" selectCSSClass="form-control" mandatory="true" skipBlank="false" skipBlankMessageKey="relation.title.pleaseSelect" items="${titles}" tabindex="0" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 no-space">
							<div class="form-group ">
								<formElement:formInputBox idKey="firstName" labelKey="relation.firstName" path="firstName" inputCSS="form-control" tabindex="0" mandatory="true" maxlength="240"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 no-space">
							<div class="form-group ">
								<formElement:formInputBox idKey="lastName" labelKey="relation.lastName" path="lastName" inputCSS="form-control" tabindex="0" mandatory="true" maxlength="240" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 no-space">
							<div class="form-group ">
								<formElement:formInputBox idKey="emailAddress" labelKey="relation.emailAddress" path="emailAddress" inputCSS="form-control" tabindex="0" mandatory="true" maxlength="255"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 no-space">
							<div class="form-group ">
								<formElement:formInputBox idKey="confirmEmailAddress" labelKey="relation.confirmEmailAddress" path="confirmEmailAddress" inputCSS="form-control" tabindex="0" mandatory="true" maxlength="255" />
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-sm-12 no-space" tabindex="0">
							<c:choose>
								<c:when test="${not empty relationshipCustomer}">
									<spring:theme code="relationship.step.addRelation.customer.text" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="addRelationCustomerText"/>
								     ${ycommerce:sanitizeHTML(addRelationCustomerText)}
								    <ul class="dashed">
						            	<li>
			          				    	<spring:theme code="relation.personal.details"/>
						                </li>
						                <li>
											<spring:theme code="relation.emailAddress"/>
					                    </li>
					                </ul>
								</c:when>
								<c:otherwise>
									<spring:theme code="relationship.step.addRelation.text" htmlEscape="false" var="addRelationText"/>  <br /> <br />
								   ${ycommerce:sanitizeHTML(addRelationText)}
								    <ul class="dashed">
						            	<li>
			          				    	<spring:theme code="relation.personal.details"/>
						                </li>
						                <li>
											<spring:theme code="relation.emailAddress"/>
					                    </li>
					                </ul>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				  <div class="row">
				   	<div class="col-xs-12 col-sm-6 col-sm-offset-6 no-space">
				    	<div class="col-xs-12 col-sm-6 col-md-6 setup-btn">
							<button type= "button" onclick="window.location='${cancelUrl}'" class="btn btn-grey checkout-next btn-block" tabindex="0"><spring:theme code="relationship.cancel" /></button>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 no-space setup-btn">
							<button id="placeOrder" type="submit" class="btn btn-primary btn-block checkout-next submit_relationshipForm">
								<spring:theme code="relationship.next" />
							</button>
						</div>
					</div>
				   </div>
				</form:form>
			</ycommerce:testId>
	</div>
</jsp:body>
</relationship:relationshipSteps>