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
			
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<div class="checkbox" role="checkbox" aria-checked="false">
						<label tabindex="0" class="control-label uncased"> 
							<input id="consentForm.consentGiven1" name="consentForm.consentGiven" type="checkbox" value="true">
							<input type="hidden" name="_consentForm.consentGiven" value="on"><spring:theme code="mirit.constents.notifications" />
						</label>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4  ">
				<div class="form-group ">
					<div class="checkbox" role="checkbox" aria-checked="false">
						<label tabindex="0" class="control-label uncased"> 
							<input id="consentForm.consentGiven1" name="consentForm.consentGiven" type="checkbox" value="true">
							<input type="hidden" name="_consentForm.consentGiven" value="on"><spring:theme code="mirit.constents.useOfInformation" />
						</label>
					</div>
				</div>
			</div>
		</div>
		
		
