<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ attribute name="fbAppId" required="true" type="java.lang.String"%>

<c:if test="${not empty fbAppId }">
	<a class="follow-us-Facebook icon" href="#" onclick="fbShare('${fbAppId}');"
		title="Facebook" > <span class="visuallyhidden">Facebook</span></a>
	<script type="text/javascript">
		function fbShare(appId) {
			var url = window.location.href;
			var shareUrl = '<spring:theme code="general.share.facebook.url" arguments="' + appId +',' + url + '"/>';
			shareInNewWindow(shareUrl);
		}
	</script>
</c:if>