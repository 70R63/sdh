<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/formElement"%>
<%@ taglib prefix="relationship" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/relationship"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="addOntemplate" tagdir="/WEB-INF/tags/addons/relationshipaddon/responsive/template"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<addOntemplate:psJavaScriptVariables />
<spring:url value="/my-account/my-relationships/manage-details/${ycommerce:encodeHTML(relationId)}/${ycommerce:encodeHTML(customerPk)}" var="cancelUrl" />
<spring:theme code="relation.permission.change.requestMorePermissions.back.accessibility" var="relationRequestMoreBack" />

<div class="row no-margin global-content-space">
	<div class="col-sm-12 col-md-8 no-space request-more-permissions request-change-permissions">
		<div class="back-link border">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${cancelUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${relationRequestMoreBack}"></span>
					</button>
					<h1 class="custom-h1">
						<span class="label" tabindex="0"><spring:theme code="relation.permission.requestMorePermissions.heading" text="Request Permissions" /></span>
					</h1>
				</div>
			</div>
		</div>

		<div class="continuous-text" tabindex="0">
			<strong><spring:theme code="relation.permission.requestMorePermissions.text" arguments="${permissionSourceUser.name}" /></strong>
		</div>
		<br />
		<div>
			<div class="col-md-6 col-sm-6 col-xs-6 no-space" tabindex="0">
				<strong> <spring:theme code="relation.permission.requestMorePermissions.additionalPermissions.heading" />
				</strong>
			</div>


			<spring:theme code="permission.help.text" var="permissionHelpText" />
			<spring:theme code="relation.permission.requestMorePermissions.help.message" var="requestMorePermissionHelpMessage" />
			<div class="visible-xs visible-sm col-md-6 col-sm-6 col-xs-6 permission-helpIcon">
				<span class="js-permissionHelp-mobile pull-right glyphicon glyphicon-question-sign" aria-label="${ycommerce:encodeHTML(permissionHelpText)}" tabindex="0"></span>
			</div>
			<div class="visible-md visible-lg relationship-popover col-md-6 col-sm-6 col-xs-6 relationship-helpIcon">
					<span class="pull-right glyphicon glyphicon-question-sign" title='<spring:theme code="relation.permission.requestMorePermissions.help.message" />' tabindex="0"><span class="acc_hidden"><spring:theme code="permission.help.popup.heading" /></span></span>
			</div>
		</div>
		<br />

		<c:forEach items="${activePermissibleTypes}" var="activePermissibleItem">
			<div class="row no-margin">
				<div class="card col-sm-12">
					<div class="card-section">
						<div class="card-section-h2">
							<spring:theme code="text.account.pending.request.access.to" var="givenAriaLabel" />
							<div tabindex="0" aria-label="${givenAriaLabel}&nbsp;${activePermissibleItem.displayName}">
								<span class="card-icon-permissions glyphicon glyphicon-ok"></span>&nbsp;&nbsp; <span class="permissible-item-name">${ycommerce:encodeHTML(activePermissibleItem.displayName)}</span>
							</div>
						</div>
						<div class="card-section-content">
							<div></div>
							<div></div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

		<form:form id="permissionForm" name="permissionForm" commandName="permissionForm" method="POST">
			<c:forEach items="${availablePermissibleAreaTypes}" var="permissibleItem">
				<c:if test="${not empty permissibleItem.shareableType}">
					<div class="row">
						<div class="card col-sm-12">
							<div class="card-section">
								<div class="card-section-h2">
									<div class="sourcePermission">
										<formElement:formCheckbox path="targetPermissibleItemTypes" idKey="${permissibleItem.displayName}" labelKey="${permissibleItem.displayName}" valueKey="${permissibleItem.shareableType}" tabindex="0" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>

			<br />
			<br />

			<div class="row">
				<div class="col-sm-12 no-space desc-text" tabindex="0">
					<spring:theme code="relation.permission.requestPermission.view.text" arguments="${permissionSourceUser.firstName}" htmlEscape="false" var="requestPermissionViewText"/>
				    ${ycommerce:sanitizeHTML(requestPermissionViewText)}
				</div>
				<ul class="dashed">
					<li>
					    <spring:theme
							code="relation.permission.givePermission.customer.personal.details"
							arguments="${permissionSourceUser.firstName}" htmlEscape="false"
							var="customerPaymentDetails" />
						${ycommerce:sanitizeHTML(customerPaymentDetails)}
					</li>
					<li>
					    <spring:theme
							code="relation.permission.givePermission.customer.email.address"
							arguments="${permissionSourceUser.firstName}" htmlEscape="false"
							var="customerEmailAddress" />
						${ycommerce:sanitizeHTML(customerEmailAddress)}
					</li>
				</ul>
			</div>
			<br />
			<div class="row">
				<div class="col-sm-12 no-space desc-text" tabindex="0">
					<spring:theme code="relation.permission.requestPermission.neverView.text" arguments="${permissionSourceUser.firstName}" htmlEscape="false" var="requestPermissionNeverViewText" />
				    ${ycommerce:sanitizeHTML(requestPermissionNeverViewText)}
				</div>
				<ul class="dashed">
					<li>
					    <spring:theme
							code="relationship.permission.customer.payment.details"
							arguments="${permissionSourceUser.firstName}" htmlEscape="false"
							var="customerPaymentDetails" />
						${ycommerce:sanitizeHTML(customerPaymentDetails)}
					</li>
					<li>
					    <spring:theme
							code="relationship.permission.customer.password"
							arguments="${permissionSourceUser.firstName}" htmlEscape="false"
							var="customerPassword" />
						${ycommerce:sanitizeHTML(customerPassword)}
				    </li>
					<li>
					    <spring:theme
							code="relation.permission.givePermission.customer.relationships.and.permissions"
							arguments="${permissionSourceUser.firstName}" htmlEscape="false"
							var="customerRelationshipsAndPermissions" />
						${ycommerce:sanitizeHTML(customerRelationshipsAndPermissions)}
				    </li>
				</ul>
			</div>
			<br />

			<div class="row">
				<div class="col-xs-12 col-sm-6 col-sm-offset-6 no-space">
					<div class="col-xs-12 col-sm-5 col-md-5 setup-btn">
						<button tabindex="0" type="button" onclick="window.location='${cancelUrl}'" class="btn btn-grey checkout-next  btn-block">
							<spring:theme code="relationship.cancel" />
						</button>
					</div>

					<div class="col-xs-12 col-sm-7 col-md-7 setup-btn">
						<button id="addPermission" type="submit" disabled="true" class="btn checkout-next btn-primary btn-block">
							<spring:theme code="relation.permission.requestMorePermissions.heading" />
						</button>
					</div>

				</div>
			</div>


			<div id="savedPermissionHelp" class="saved-permission-help">
				<div id="savedPermissionttitle">
					<div class="headline">
						<span class="headline-text" tabindex="0"><spring:theme code="permission.help.popup.heading" /></span>
					</div>
				</div>
				<div id="savedPermissionbody">
					<spring:theme code="relation.permission.requestMorePermissions.help.message" var="requestMorepermissionHelpMessage" />
					<div aria-label="${requestMorepermissionHelpMessage}" tabindex="0">
						<spring:theme code="relation.permission.requestMorePermissions.help.message" />
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>

