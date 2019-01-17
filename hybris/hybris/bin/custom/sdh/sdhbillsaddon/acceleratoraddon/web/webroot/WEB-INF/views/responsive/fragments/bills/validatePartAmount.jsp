<%@ page trimDirectiveWhitespaces="true" contentType="application/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
{"result": {"valid": "${valid}",
"errorMessage":"<spring:theme code="${errorMessage}" text="${errorMessage}" />"
} }
