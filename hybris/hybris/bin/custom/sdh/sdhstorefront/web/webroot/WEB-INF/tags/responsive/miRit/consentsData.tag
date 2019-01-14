<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

			<div class="headline">
				<h2>
					<span tabindex="0"><spring:theme code="mirit.constents.title" text="Autorizaciones"/></span>
				</h2>
			</div>
		<c:set var="checkBuzon" value="false" />
		<c:set var="checked" value="" />
		<c:if test="${miRitForm.useEmailForNotifications }">
			<c:set var="checkBuzon" value="true" />
			<c:set var="checked" value="checked" />
		</c:if>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<div class="checkbox" role="checkbox" aria-checked="${checkBuzon }">
						<label tabindex="0" class="control-label uncased ${checked }"> 
							<input id="consentForm.consentGiven1" name="consentForm.consentGiven" type="checkbox" value="true">
							<input type="hidden" name="_consentForm.consentGiven" value="on"><spring:theme code="mirit.constents.notifications" />
						</label>
					</div>
				</div>
			</div>
		</div>
		<c:set var="checkAutUsoInfo" value="false" />
		<c:set var="checked" value="" />
		<c:if test="${miRitForm.useInformationForInstitutionalPurposes }">
			<c:set var="checkAutUsoInfo" value="true" />
			<c:set var="checked" value="checked" />
		</c:if>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<div class="checkbox" role="checkbox" aria-checked="${checkAutUsoInfo }">
						<label tabindex="0" class="control-label uncased" ${checked }> 
							<input id="consentForm.consentGiven1" name="consentForm.consentGiven" type="checkbox" value="true">
							<input type="hidden" name="_consentForm.consentGiven" value="on"><spring:theme code="mirit.constents.useOfInformation" />
						</label>
					</div>
				</div>
			</div>
		</div>
		
		
