<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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