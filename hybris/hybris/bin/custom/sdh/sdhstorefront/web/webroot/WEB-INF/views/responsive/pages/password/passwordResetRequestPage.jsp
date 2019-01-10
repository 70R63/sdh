<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>

<template:page pageTitle="${pageTitle}">
	<div class="row">
		<div class="col-md-4  col-md-offset-4" >
			<c:if test="${not passwordRequestSent}">
				<user:forgottenPwd />
			</c:if>
		</div>
	</div>
</template:page>
