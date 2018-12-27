<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>

<c:url value="${requestScope['javax.servlet.forward.servlet_path']}"
	var="currentUrl" />
<c:set var="linkedInUrl" value="https://www.linkedin.com/shareArticle" />

<a class="follow-us-LinkedIn icon" href="#" onclick="linkedInShare();"
	title="linkedin"><span class="visuallyhidden">linkedin</span> </a>

<script type="text/javascript">
	function linkedInShare() {
		var url = window.location.href;
		var shareUrl = '<spring:theme code="general.share.linkedin.url" arguments="' + url + '"/>';
		shareInNewWindow(shareUrl);
	}
</script>