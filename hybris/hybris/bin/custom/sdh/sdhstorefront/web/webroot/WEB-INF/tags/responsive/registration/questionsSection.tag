<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="currentQuestion" required="true"
              type="java.lang.Integer" %>
<%@ attribute name="currentQuestionDescription" required="true"
              type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="false" />

<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
<%-- 				<div class="description text-center"><spring:theme code="register.dearUser"/></div> --%>
<%-- 				<div class="description text-center"><spring:theme code="register.descriptionStartSection"/></div> --%>
<%-- 				<div class="description text-center"><spring:theme code="register.steps"/></div> --%>

					<div class="description"><spring:theme code="register.questions.title" /></div>
					<div class="bundleSelectionTemplate">
						<div id="bundleTemplatesDiv">
						<div
							id="bundleTemplateDiv_WORKING_withChildren_ApplicationType_Bundle"
							data-bundleid="WORKING_withChildren_ApplicationType_Bundle"
							class="bundleTemplateDiv">
							<fieldset>
								<legend aria-label="Objetivo del certificado">
									<br>${currentQuestionDescription }
								</legend>
								<form
									id="childBundleTemplateForm_WORKING_withChildren_ApplicationType_Bundle"
									action="/sdhstorefront/es/checkout/multi/bundle" method="post">
									<div class="radio bundleRadio" role="radio" aria-checked="true"
										tabindex="0">
										<label class="bundleTemplateLabel checked"
											for="apply-as-volunteer-addon"> <input
											id="" name="bundleOption"
											class="bundleOption" type="radio"
											value="apply-as-volunteer-addon"><span>Respuesta 1</span>
										</label>
									</div>
									<div class="radio bundleRadio" role="radio"
										aria-checked="false" tabindex="0">
										<label class="bundleTemplateLabel"
											for="apply-as-paid-employee-addon"> <input
											id="" name="bundleOption"
											class="bundleOption" type="radio"
											value="apply-as-paid-employee-addon"><span>Respuesta 2</span>
										</label>
									</div>
									<div></div>
								</form>
							</fieldset>
						</div>
					</div>
				</div>
				
				<div class="text-right">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<button class="btn btn-primary btn-lg" type="button" onclick="window.location.href = '<c:url value="/register/getQuestion?currentQuestion=${currentQuestion }" />'">
									<spring:theme code="register.continue"/>
								</button>
								<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href = '<c:url value="/" />'">
									<spring:theme code="register.cancel"/>
								</button>
							</ycommerce:testId>
				</div>
				
			</div>
		</div>
	</div>
</div>