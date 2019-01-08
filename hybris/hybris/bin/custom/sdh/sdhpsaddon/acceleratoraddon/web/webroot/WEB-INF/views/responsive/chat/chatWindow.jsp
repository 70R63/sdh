<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="addOnTemplate" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/template"%>
<%@ taglib prefix="analytics" tagdir="/WEB-INF/tags/shared/analytics"%>
<%@ taglib prefix="addonScripts" tagdir="/WEB-INF/tags/responsive/common/header"%>
<%@ taglib prefix="generatedVariables" tagdir="/WEB-INF/tags/shared/variables"%>
<%@ taglib prefix="debug" tagdir="/WEB-INF/tags/shared/debug"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="htmlmeta" uri="http://hybris.com/tld/htmlmeta"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<!-- test -->
<html>
<head>
	<link rel="stylesheet" type="text/css" media="all" href="${themeResourcePath}/css/style.css" />		

</head>
<body>

<div class="container" id="popover-content-window">
      <div class="chat-module active col-xs-12 col-sm-12 col-md-12 col-lg-12 no-space">
        <div class="chat-module-container-window col-xs-12 col-sm-6 col-md-6 col-lg-6 no-space">
        <div class="chat-module-header">
          <div>
            <span class="chat-glyphicon-open"> <spring:theme code="chatbox.title" />
            </span> 
            <span> 
             <spring:theme code="chat.box.close" var="chatClose"></spring:theme>
              <button class="close chat-glyphicon" id="close" tabindex="0" title="${chatClose}"></button> 
            </span>
          </div>
        </div>
        <div class="chat-module-content-window">
          <div class="form-group ">
            <label for="chat-name" class="control-label required"> <spring:theme code="chatbox.name" /> </label> 
              <input type="text" value="" class="chat-text form-control chat-name" name="chat.name" id="chat-name">
          </div>
          <div class="form-group ">
            <label for="chat-email" class="control-label"> <spring:theme code="chatbox.email" /> </label> 
              <input type="text" value="" class="chat-text form-control chat-email" name="chat.email" id="chat-email">
          </div>
          <div class="form-group ">
            <label for="chat-message" class="control-label required"> <spring:theme code="chatbox.message" /></label>
              <textarea class="chat-text form-control chat-textarea chat-message" name="chat.message" id="chat-message"> </textarea>
          </div>
          <spring:message code="chatbox.start.chat" var="startChatText"/>
          <input type="submit" name="submit" class="btn btn-black btn-block btn-chat" value="${startChatText}"></input>
          <br />
        </div>
      </div>
    </div>
  </div>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script type="text/javascript">
	$(document).ready(function(){
		$('#close').click(function(){
	    window.close();
    	});
	});
	</script>
</body>
  </html>