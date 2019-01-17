<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<template:page pageTitle="${pageTitle}">
	<div class="row">
		<div class="col-md-4  col-md-offset-4" >
			<div class="item_container_holder">
				<div class="title_holder">
					<h2>
						<spring:theme code="forgottenPwd.title"/>
					</h2>
				</div>
				<div class="item_container">
					<spring:theme code="account.confirmation.forgotten.password.link.sent"/>
				</div>
			</div>
		</div>
	</div>
</template:page>
