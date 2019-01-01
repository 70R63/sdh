<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="registration"
	tagdir="/WEB-INF/tags/responsive/registration"%>


<template:page pageTitle="${pageTitle}">




	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="item_container_holder ">
				<div class="forgotten-password item_container ">
					<c:choose>
						<c:when test="${accountActivated eq true }">

							<p>
								<spring:theme code="activate.account.success" />
							</p>

						</c:when>
						<c:otherwise>
							<p>
								<spring:theme code="activate.account.error" />
							</p>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</div>
	</div>

</template:page>
