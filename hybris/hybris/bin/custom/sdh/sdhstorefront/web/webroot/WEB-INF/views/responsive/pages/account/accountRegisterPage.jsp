<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="registration" tagdir="/WEB-INF/tags/responsive/registration" %>


<template:page pageTitle="${pageTitle}">
	<c:choose>
		<c:when test="${currentSection eq 'requestRols' }">
			<registration:requestRols/>
		</c:when>
		<c:when test="${currentSection eq 'searchUserSection' }">
			<registration:searchUserSection/>
		</c:when>
		<c:when test="${currentSection eq 'startSection' }">
			<registration:registrationInstructionsSection/>
		</c:when>
		<c:when test="${currentSection eq 'questionsSection' }">
			<registration:questionsSection currentQuestion="${currentQuestion }" currentQuestionDescription="${currentQuestionDescription }" />
		</c:when>
		<c:when test="${currentSection eq 'personalDataSection' }">
			<registration:personalDataSection/>
		</c:when>
		<c:when test="${currentSection eq 'confirmationSection' }">
			<registration:confirmationSection/>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>


<script  type="text/javascript">
window.onload = function() {
	
    $(".loader").fadeOut("slow");
}
function changeMessage() {
	debugger;
	var rol = document.getElementById("rol").value;
	var email = document.getElementById("email").value;
	var mensaje = document.getElementById("mensaje").value;
	mensaje = "(rol="+rol+")"+"(email="+email+")"+"(mensaje="+mensaje+")";
	document.getElementById("mensaje").value = mensaje;
}
</script>
</template:page>
