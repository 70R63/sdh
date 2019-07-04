<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="false" />

<div class="container">
<div class="row" >
	<div class="col-md-6 col-md-offset-3">
		<div class="item_container_holder ">
			<div class="forgotten-password item_container ">
				<div class="description"><spring:theme code="register.dearUser"/></div>
				<div class="description"><spring:theme code="register.descriptionStartSection"/></div>
				<div class="description"><spring:theme code="register.steps"/></div>
				
						<div class="text-right">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<button class="btn btn-primary btn-lg" type="button" onclick="window.location.href = '<c:url value="/register/getQuestion" />'">
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
</div>