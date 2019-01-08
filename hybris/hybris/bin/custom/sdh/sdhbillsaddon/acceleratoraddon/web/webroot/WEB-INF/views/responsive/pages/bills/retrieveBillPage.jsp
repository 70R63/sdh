<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/addons/sdhbillsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<h1><span tabindex="0">
	<spring:theme code="bill.retrieve.heading" text="Retrieve My Bill" />
</span></h1>
<spring:url value="/my-account/all-bills" var="myBillsUrl" />
<spring:url value="/bills/overview" var="retriveActionUrl" />
<spring:theme code="bill.retrieve.message"
	text="Easily retrieve your bill. All you need is your bill id and your last name. " htmlEscape="false" var="billRetrieveMessage"/>
	${ycommerce:sanitizeHTML(billRetrieveMessage)}</br></br>
	<div class="retrieve-bill-request">
		<spring:theme code="bill.retrieve.myAccount.message"
			text="If you already have an account, you can find all your bills in My Account - <a href='{0}'"
			arguments="${myBillsUrl}" htmlEscape="false" var="billRetrieveMyAccountMessage"/>
		${ycommerce:sanitizeHTML(billRetrieveMyAccountMessage)}	
	</div>
	<p class="continuous-text">
		<spring:theme code="form.required" text="Fields marked * are required" htmlEscape="false"/>
	</p>
	<ycommerce:testId code="retrieveBillForm">
		<form:form id="retrieveBillForm" name="retrieveBillForm"
			commandName="retrieveBillForm" action="${retriveActionUrl}"
			method="POST">
			<formElement:formInputBox idKey="billId" labelKey="bill.id.text"
				path="billId" inputCSS="form-control" mandatory="true" autocomplete="off" />

			<formElement:formInputBox idKey="lastName"
				labelKey="bill.lastName.text" path="lastName"
				inputCSS="form-control" mandatory="true" autocomplete="off" />
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<ycommerce:testId code="retrievePage_retrieveButton">
						<button class="btn btn-primary btn-block" type="submit">
							<spring:theme code="button.bill.retrieve.text"
								text="Retrieve Bill" />
						</button>
					</ycommerce:testId>
				</div>
				<div class="col-md-3"></div>
			</div>
		</form:form>
	</ycommerce:testId>
