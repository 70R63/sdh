<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:url value="${requestScope['javax.servlet.forward.servlet_path']}"
	var="currentUrl" />
<a class="follow-us-Googleplus icon" href="#" onclick="gPlusShare();" title="Google+"> <span class="visuallyhidden">Google+</span></a>

<script type="text/javascript">
function gPlusShare() {
	var url = window.location.href;
	var shareUrl = '<spring:theme code="general.share.googleplus.url" arguments="' + url + '"/>';
	shareInNewWindow(shareUrl);
}
</script>
