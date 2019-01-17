<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<%-- JS configuration --%>
<script type="text/javascript">
		<%-- Define a javascript variable to hold the content path --%>
		var PSBILL = { };
			PSBILL.textCloseOverlay  = '<spring:theme code="bill.text.close.overlay.accessibility"/>';
	</script>