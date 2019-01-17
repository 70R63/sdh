<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/formElement"%>
<%@ taglib prefix="relationship" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/relationship"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="addOntemplate" tagdir="/WEB-INF/tags/addons/sdhrelationshipsaddon/responsive/template"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<addOntemplate:psJavaScriptVariables />
<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/my-account" var="cancelUrl" />

<relationship:relationshipSteps progressBarId="permission">
	<jsp:body>

	   <p class="continuous-text">
			<spring:theme code="relationship.fieldsRequired" htmlEscape="false" />
		</p>
	    <div>
			<div class="col-md-6 col-sm-6 col-xs-6 no-space" tabindex="0">
				<strong>
					<spring:theme code="relation.permission.givePermission.radioButton.heading" /><span class="required"></span>
				</strong>
		   </div>
		
		<spring:theme code="permission.help.text" var="permissionHelpText" />
		<spring:theme code="permission.help.message" var="permissionHelpMessage" />
		<div class="visible-xs visible-sm col-md-6 col-sm-6 col-xs-6 permission-helpIcon">
			<span class="js-permissionHelp-mobile pull-right glyphicon glyphicon-question-sign" aria-label="${ycommerce:encodeHTML(permissionHelpText)}" tabindex="0"></span>
		</div>
		<div class="visible-md visible-lg relationship-popover col-md-6 col-sm-6 col-xs-6 relationship-helpIcon">
			<span class="pull-right glyphicon glyphicon-question-sign" title='<spring:theme code="permission.help.message" />' tabindex="0"><span class="acc_hidden"><spring:theme code="permission.help.popup.heading" /></span></span>
	    </div>
		</div>
		 
		<ycommerce:testId code="permissionForm">
		
	    <form:form id="permissionForm" name="permissionForm" commandName="permissionForm" method="POST">
		
	 
	   	<template:errorSpanField path="permissionType">
            <c:forEach items="${permissionTypes}" var="permissionType">
	           <div class="row"> 
		      <div class="col-sm-12 no-space">
			    <div class="radio permissionRadio" role="radio" aria-checked="false" tabindex="0">
		           <label class="permissionTypeLabel" for="${permissionType.code}">
	                  <form:radiobutton path="permissionType" id="PermissionTypeSelection_${permissionType.code}" class="${permissionType.name}" value="${permissionType.code}" /><span><spring:theme code="${permissionType.name}" /></span>
	                 </label>
	                 </div>
		        </div>
	          </div>
           </c:forEach>
	        <span class="radioButton-text"><br /> <hr> <br />
                 <spring:theme code="relation.permission.selectPermission.heading" />
             </span>
            <span class="skip">  <form:errors path="permissionType" /></span>
     </template:errorSpanField>
		  
	<br />
	
	<div class="permissionType permission.give permission.giveandrequest">
				<hr>
				<br />

	<div class="row"> 
		<div class="col-sm-12 no-space desc-text" tabindex="0">
			<c:choose>
				<c:when test="${not empty relationshipCustomer}">
					<spring:theme code="relation.permission.customer.givePermission.heading" arguments="${targetUserFirstName},${relationshipCustomer.firstName}" htmlEscape="false" var="customerGivenPermissionHeading"/>
				    ${ycommerce:sanitizeHTML(customerGivenPermissionHeading)}
				</c:when>
				<c:otherwise>
					<spring:theme code="relation.permission.givePermission.heading" htmlEscape="false" var="givenPermissionHeading"/>
					${ycommerce:sanitizeHTML(givenPermissionHeading)}
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	
<c:forEach items="${permissibleItemTypes}" var="permissibleItem">
	<c:if test="${not empty permissibleItem.shareableType}">
		<div class="row"> 
		 <div class="card col-sm-12">
			<div class="card-section">
				<div class="card-section-h2">
				<div class="sourcePermission">
						<formElement:formCheckbox path="sourcePermissibleItemTypes" idKey="${permissibleItem.displayName}" labelKey="${permissibleItem.displayName}" valueKey="${permissibleItem.shareableType}" tabindex="0" />
				</div>
				</div>
			</div>
		</div>
		</div>
	</c:if>
</c:forEach>

				
	<div class="row"> 
		<div class="col-sm-12 no-space desc-text" tabindex="0">
			<c:choose>
				<c:when test="${not empty relationshipCustomer}">
					<spring:theme code="relation.permission.givePermission.customer.view.text" arguments="${targetUserFirstName}" htmlEscape="false" var="givePermissionCustomerViewText"/>
				    <div>${ycommerce:sanitizeHTML(givePermissionCustomerViewText)}</div>
				    <ul class="dashed">
						<li>
			          		<spring:theme code="relation.permission.givePermission.customer.personal.details" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerPaymentDetails" />
					    	${ycommerce:sanitizeHTML(customerPaymentDetails)}
						</li>
						<li>
							<spring:theme code="relation.permission.givePermission.customer.email.address" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerEmailAddress" />
					    	${ycommerce:sanitizeHTML(customerEmailAddress)}
					    </li>
					</ul>
				</c:when>
				<c:otherwise>
					<spring:theme code="relation.permission.givePermission.view.text" arguments="${targetUserFirstName}" htmlEscape="false" var="givePermissionViewText"/>
				    <div>${ycommerce:sanitizeHTML(givePermissionViewText)}</div>
				    <ul class="dashed">
						<li>
			          		<spring:theme code="relation.permission.givePermission.personal.details"/>
						</li>
						<li>
							<spring:theme code="relation.permission.givePermission.email.address"/>
					    </li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<br />
	<div class="row"> 
		<div class="col-sm-12 no-space desc-text" tabindex="0">
			<c:choose>
				<c:when test="${not empty relationshipCustomer}">
					<spring:theme code="relation.permission.givePermission.customer.neverView.text" arguments="${targetUserFirstName}" htmlEscape="false" var="givePermissionCustomerNeverViewText"/>
				    <div>${ycommerce:sanitizeHTML(givePermissionCustomerNeverViewText)}</div>
				    <ul class="dashed">
						<li>
			          		<spring:theme code="relationship.permission.customer.payment.details" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerPaymentDetails"/>
					   		 ${ycommerce:sanitizeHTML(customerPaymentDetails)}
						</li>
						<li>
							<spring:theme code="relationship.permission.customer.password" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerPassword"/>
					    	${ycommerce:sanitizeHTML(customerPassword)}
					    </li>
						<li>
					    	<spring:theme code="relation.permission.givePermission.customer.relationships.and.permissions" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="customerRelationshipsAndPermissions"/>
							${ycommerce:sanitizeHTML(customerRelationshipsAndPermissions)}
						</li>
					</ul>
				</c:when>
				<c:otherwise>
					<spring:theme code="relation.permission.givePermission.neverView.text" arguments="${targetUserFirstName}" htmlEscape="false" var="givePermissionNeverViewText"/>
				    <div>${ycommerce:sanitizeHTML(givePermissionNeverViewText)}</div>
				    <ul class="dashed">
			       	 	<li>
							<spring:theme code="relationship.permission.payment.details"/>
					 	</li>
					 	<li>
					 		<spring:theme code="relationship.permission.password"/>
					 	</li>
					 	<li>
					 		<spring:theme code="relation.permission.givePermission.relationships.and.permissions"/>
					 	</li>
					 </ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
				</div>
	
   <div class="permissionType permission.giveandrequest">
	<div class="row"> 
		<div class="col-sm-12 no-space">
			     <div class="requestPermission">
						<formElement:formCheckbox path="sameAsSourcePermissibleItemTypes" idKey="" labelCSS="request-permission" labelKey="relation.permission.requestPermission.checkbox.text" valueKey="${declaration.shareableType}" tabindex="0" />
				</div>
		</div>
	</div>
	 </div>

<div class="permissionType permission.request permission.giveandrequest">
<hr />
<br />

	<div class="row"> 
		<div class="col-sm-12 no-space desc-text" tabindex="0">
			<c:choose>
				<c:when test="${not empty relationshipCustomer}">
					<spring:theme code="relation.permission.customer.requestPermission.heading" arguments="${targetUserFirstName},${relationshipCustomer.firstName}" htmlEscape="false" var="customerRequestPermissionHeading"/>
			         ${ycommerce:sanitizeHTML(customerRequestPermissionHeading)}	
				</c:when>
				<c:otherwise>
					<spring:theme code="relation.permission.requestPermission.heading" htmlEscape="false" var="requestPermissionHeading"/>
					${ycommerce:sanitizeHTML(requestPermissionHeading)}
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<c:forEach items="${permissibleItemTypes}" var="permissibleItem">
	<c:if test="${not empty permissibleItem.shareableType}">
		<div class="row"> 
		 <div class="card col-sm-12">
			<div class="card-section">
				<div class="card-section-h2">
				<div class="targetPermission">
					<formElement:formCheckbox path="targetPermissibleItemTypes" idKey="" labelKey="${permissibleItem.displayName}" valueKey="${permissibleItem.shareableType}" tabindex="0" />
				</div>
				</div>
			</div>
		</div>
	</div>
	</c:if>
</c:forEach>
	
	
	<div class="row"> 
		<div class="col-sm-12 no-space desc-text" tabindex="0">
			<c:choose>
				<c:when test="${not empty relationshipCustomer}">
					<spring:theme code="relation.permission.requestPermission.customer.view.text" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="requestPermissionCustomerViewText" />
				    <div>${ycommerce:sanitizeHTML(requestPermissionCustomerViewText)}</div>
				    <ul class="dashed">
						<li>
			          		<spring:theme code="relation.permission.givePermission.customer.personal.details"  arguments="${targetUserFirstName}" htmlEscape="false" var="customerPaymentDetails"/>
					    	${ycommerce:sanitizeHTML(customerPaymentDetails)}
						</li>
						<li>
							<spring:theme code="relation.permission.givePermission.customer.email.address"  arguments="${targetUserFirstName}" htmlEscape="false" var="customerEmailAddress"/>
					    	${ycommerce:sanitizeHTML(customerEmailAddress)}
					    </li>
					</ul>
				</c:when>
				<c:otherwise>
					<spring:theme code="relation.permission.requestPermission.view.text" htmlEscape="false" var="requestPermissionViewText" />
				    <div>${ycommerce:sanitizeHTML(requestPermissionViewText)}</div>
				    <ul class="dashed">
						<li>
			          		<spring:theme code="relation.permission.givePermission.customer.personal.details"  arguments="${targetUserFirstName}" htmlEscape="false" var="customerPaymentDetails"/>
					    	${ycommerce:sanitizeHTML(customerPaymentDetails)}
						</li>
						<li>
							<spring:theme code="relation.permission.givePermission.customer.email.address"  arguments="${targetUserFirstName}" htmlEscape="false" var="customerEmailAddress"/>
					    	${ycommerce:sanitizeHTML(customerEmailAddress)}
					    </li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<br />
	<div class="row"> 
		<div class="col-sm-12 no-space desc-text" tabindex="0">
			<c:choose>
				<c:when test="${not empty relationshipCustomer}">
					<spring:theme code="relation.permission.requestPermission.customer.neverView.text" arguments="${relationshipCustomer.firstName}" htmlEscape="false" var="requestPermissionCustomerNeverViewText"/>
				    <div>${ycommerce:sanitizeHTML(requestPermissionCustomerNeverViewText)}</div>
				    <ul class="dashed">
						<li>
			          		<spring:theme code="relationship.permission.customer.payment.details" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPaymentDetails"/>
					    	${ycommerce:sanitizeHTML(customerPaymentDetails)}
						</li>
						<li>
							<spring:theme code="relationship.permission.customer.password" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPassword"/>
					    	${ycommerce:sanitizeHTML(customerPassword)}
					    </li>
						<li>
					    	<spring:theme code="relation.permission.givePermission.customer.relationships.and.permissions" arguments="${targetUserFirstName}" htmlEscape="false" var="customerRelationshipsAndPermissions"/>
							${ycommerce:sanitizeHTML(customerRelationshipsAndPermissions)}
						</li>
					</ul>
				</c:when>
				<c:otherwise>
					<spring:theme code="relation.permission.requestPermission.neverView.text"  htmlEscape="false" var="requestPermissionNeverViewText"/>
				   <div>${ycommerce:sanitizeHTML(requestPermissionNeverViewText)}</div> 
				    <ul class="dashed">
						<li>
			          		<spring:theme code="relationship.permission.customer.payment.details" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPaymentDetails"/>
					   		 ${ycommerce:sanitizeHTML(customerPaymentDetails)}
						</li>
						<li>
							<spring:theme code="relationship.permission.customer.password" arguments="${targetUserFirstName}" htmlEscape="false" var="customerPassword"/>
					    	${ycommerce:sanitizeHTML(customerPassword)}
					    </li>
						<li>
					    	<spring:theme code="relation.permission.givePermission.customer.relationships.and.permissions" arguments="${targetUserFirstName}" htmlEscape="false" var="customerRelationshipsAndPermissions"/>
							${ycommerce:sanitizeHTML(customerRelationshipsAndPermissions)}
						</li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	</div>
	<br />

    <div class="row">
    <div class="col-xs-12 col-sm-6 col-sm-offset-6 no-space">
         <div class="ol-xs-12 col-sm-5 col-md-5 setup-btn">
				<button tabindex="0" type="button" onclick="window.location='${cancelUrl}'" class="btn btn-grey checkout-next  btn-block">
					<spring:theme code="relationship.cancel" />
				</button>
			</div>
			
			<div class="col-xs-12 col-sm-7 col-md-7 no-space setup-btn">
				<button id="addPermission" type="submit" class="btn checkout-next btn-primary btn-block">
					<spring:theme code="relation.submitPermission" />
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
		<spring:theme code="permission.help.message" var="permissionHelpMessage" />
			<div aria-label="${ycommerce:encodeHTML(permissionHelpMessage)}" tabindex="0">
				<spring:theme code="permission.help.message" />
			</div>
		</div>
	</div>
</form:form>
</ycommerce:testId>
</jsp:body>

</relationship:relationshipSteps>