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
				<c:url var="action" value="/register/validateAnswers"/> 
			
				<form:form method="post" commandName="SecretAnswerForm" action="${action}">
					<fieldset>
						<div class="headline">
							<h2>
								<span tabindex="0"><spring:theme code="register.questions.title" /></span>
							</h2>
						</div>
						
						<c:set var = "question" value = "${questionCatalog['AGE']}"/>
						
						<c:forEach  items="${questionAndOptions}" var="entry">
							<c:set var = "keyQuestionDesc" value = "${entry.key}"/>
 							<formElement:formSelectBox idKey="${entry.key}" labelKey="${questionCatalog[keyQuestionDesc]}" path="${entry.key}" mandatory="true" skipBlank="false" skipBlankMessageKey="----- Seleccionar -----"  items="${entry.value}" selectedValue="" selectCSSClass="form-control"/>
						</c:forEach>			
						
						<div class="text-right">
							<ycommerce:testId code="login_forgotPasswordSubmit_button">
								<button class="btn btn-primary btn-lg" type="submit">
									<spring:theme code="register.send"/>
								</button>
								<button class="btn btn-secondary btn-lg" type="button" onclick="window.location.href = '<c:url value="/" />'">
									<spring:theme code="register.cancel"/>
								</button>
							</ycommerce:testId>
						</div>
						
					</fieldset>
				</form:form>
				
						
				
			</div>
		</div>
	</div>
</div>