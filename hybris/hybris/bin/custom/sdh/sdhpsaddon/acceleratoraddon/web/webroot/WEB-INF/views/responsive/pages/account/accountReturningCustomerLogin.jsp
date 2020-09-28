<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user"
           tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/user"%>

<c:url value="/j_spring_security_check" var="loginActionUrl" />
<div class="login-section">
   <user:login actionNameKey="login.login" action="${loginActionUrl}"/>
	<br><br><div><a href="https://www.shd.gov.co/shd/sites/default/files/files/impuestos/paso%20a%20paso%20registro%20general.jpeg" 
		target="_blank">Instructivo registro Oficina Virtual</a></div>
</div>