<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/login/recuperacorreo" var="mailURL"
	htmlEscape="false" />
<c:set var="mailExist" value="false" />
<c:if test="${not empty forgottenMailForm.mail}">
	<c:set var="mailExist" value="true" />
</c:if>
<div class="container">
	<div class="row">
		<c:if test="${mailExist}">
			<div class="alert alert-success" role="alert">
				<span><spring:theme
						code="Tu correo: ${forgottenMailForm.mail}" /> </span>
			</div>
		</c:if>
		<c:if test="${mensaje != null}">
			<div class="alert alert-success" role="alert">
				<h1><spring:theme code="${mensaje}" /> </h1>
			</div>
		</c:if>
	</div>
	<div class="account-section">
		<div class="account-section-header no-border center">
			<spring:theme code="text.account.profile.mail" />
		</div>
		<div class="account-section-content row">
			<form:form action="${mailURL}" method="POST"
				modelAttribute="forgottenMailForm" id="forgottenMailForm">
				<div class="row">
					<div class="col-md-2 col-md-offset-4">
						<div class="form-group">
							<label class="control-label"
								style="text-transform: none; font-weight: 400 !important"><spring:theme
									code="text.account.profile.mail.docType" /></label>
							<form:select path="docype" id="docype"
								class="new_alto form-control">
								<form:options items="${documentTypes}" itemValue="code"
									itemLabel="name" />
							</form:select>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label class="control-label"
								style="text-transform: none; font-weight: 400 !important"><spring:theme
									code="text.account.profile.mail.docNum" /></label>
							<form:input type="text" path="docNumber" id="docNumber"
								class="alto form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-md-offset-5">
						<div class="form-group">
							<button type="submit" id="sendData"
								class="btn btn-primary btn-lg">
								<spring:theme code="text.account.profile.mail.recMail" />
							</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<h4>
								<span><spring:theme
										code="text.account.profile.mail.description1" /></span>
							</h4>
							<ol>
								<li><span><spring:theme
											code="text.account.profile.mail.description2" /></span></li>
								<li><span><spring:theme
											code="text.account.profile.mail.description3" /></span></li>
								<li><span><spring:theme
											code="text.account.profile.mail.description4" /></span></li>
								<li><span><spring:theme
											code="text.account.profile.mail.description5" /></span></li>
								<li><span><spring:theme
											code="text.account.profile.mail.description6" /></span></li>
								<li><span><spring:theme
											code="text.account.profile.mail.description7" /></span></li>
							</ol>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
