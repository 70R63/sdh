<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="registration" tagdir="/WEB-INF/tags/responsive/registration" %>

<div class="loader"></div>
<template:page pageTitle="${pageTitle}">
	<c:choose>
		<c:when test="${currentSection eq 'requestRols' }">
			<div class="cargandoSpinner" id="cargandoSpinner" style="display: none;"></div>
			<registration:requestRols/>
			<div id="dialogMensajes" title="Tramites">
				<div id="dialogMensajesContent"></div>
			</div>
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

    if("${currentSection}" == "requestRols"){
    	ACC.tramitesSeleccion.determinacionSelectRol();
    }
    if("${currentSection}" == "searchUserSection"){
    	$("#dialogMensajes").dialog( "option", "width", 600 );
    	$("#dialogMensajes").dialog( "open" );
    }
}
function changeMessage() {
	
	var rol = document.getElementById("rol").value;
	var email = document.getElementById("email").value;
	var mensaje = document.getElementById("mensaje").value;
	mensaje = "(rol="+rol+")"+"(email="+email+")"+"(mensaje="+mensaje+")";
	document.getElementById("mensaje").value = mensaje;
}
</script>
</template:page>
