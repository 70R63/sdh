<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>

<a class="follow-us-Twitter icon" id="twitter" href="#" onclick="twitterShare();"
	title="twitter"><span class="visuallyhidden">twitter</span></a>

<script type="text/javascript">
	function twitterShare() {
		var url = window.location.href;
		var shareUrl = '<spring:theme code="general.share.twitter.url" arguments="' + url + '"/>';
		shareInNewWindow(shareUrl);
	}
</script>