<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script type="text/javascript">
  var msg = "Funcionaliadad no disponible";
  document.onmousedown = function disableclick(event){
    if(event.button==2){
       alert(msg);
       return false;
     }
  }
  document.onkeydown = function(e) {
    if(event.keyCode == 123) {
        alert(msg);
        return false;
    }
    if(e.ctrlKey && e.shiftKey && e.keyCode == 'I'.charCodeAt(0)) {
        alert(msg);
        return false;
    }
    if(e.ctrlKey && e.shiftKey && e.keyCode == 'C'.charCodeAt(0)) {
        alert(msg);
        return false;
    }
    if(e.ctrlKey && e.shiftKey && e.keyCode == 'J'.charCodeAt(0)) {
        alert(msg);
        return false;
    }
    if(e.ctrlKey && e.keyCode == 'U'.charCodeAt(0)) {
        alert(msg);
        return false;
    }
  }

  var idleTime = 0;
  $(document).ready(function () {
      //Increment the idle time counter every minute.
      var idleInterval = setInterval(timerIncrement, 60000); // 1 minute

      //Zero the idle timer on mouse movement.
      $(this).mousemove(function (e) {
          idleTime = 0;
      });
      $(this).keypress(function (e) {
          idleTime = 0;
      });
  });

  function timerIncrement() {
      idleTime = idleTime + 1;
      console.log($.cookie("sessionActived"));
      console.log(idleTime);
      if (idleTime > 2) { // 5 minutes
          if($.cookie("sessionActived") == "true"){
            window.location.href = "/bogota/es/logout?sessionExpired=true";
          }          
      }
  }
</script>

<c:url value="${fn:escapeXml(urlLink)}" var="encodedUrl" />
<div class="simple-banner-component simple-banner center-block">
	<c:choose>
		<c:when test="${empty encodedUrl || encodedUrl eq '#'}">
			<img title="${fn:escapeXml(media.altText)}" alt="${fn:escapeXml(media.altText)}"
				src="${media.url}">
		</c:when>
		<c:otherwise>
		<a aria-label="${fn:escapeXml(title)}" href="${encodedUrl}"><img class="img-responsive center-block" title="${fn:escapeXml(title)}"
				alt="${fn:escapeXml(media.altText)}" src="${media.url}"></a>
		</c:otherwise>
	</c:choose>
</div>

