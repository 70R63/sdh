<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<%-- JS configuration --%>
<script type="text/javascript">
	<%-- Define a javascript variable to hold the content path --%>
	var PSACC = { };
		PSACC.textNavClose = '<spring:theme code="text.nav.close"/>';
		PSACC.signedInUserOptionsToggle = '<spring:theme code="text.signedIn.user.options.toggle"/>';
		PSACC.textRefinementClose = '<spring:theme code="text.refinement.close"/>';
		PSACC.headerOpenSubMenu ='<spring:theme code="text.OpenSubMenu.label"/>';
		PSACC.textNotExpanded = '<spring:theme code="text.bill.notCollapsed.accessibility"/>';
		PSACC.textExpanded = '<spring:theme code="text.bill.Collapsed.accessibility"/>';
		PSACC.textTitleCartLockOverlay = '<spring:theme code="cart.lock.title.accessibility"/>';
		PSACC.textCloseOverlay ='<spring:theme code="text.close.overlay.accessibility"/>';
		PSACC.textMyAccountTitle ='<spring:theme code="myAccount.acc.title"/>';
		PSACC.textCloseMenu = '<spring:theme code="closeMenu.acc.title"/>';
		PSACC.textSignInRegister = '<spring:theme code="signInRegister.acc.title"/>'; 
		PSACC.textServicePointEmptySearch ='<spring:theme code="storelocator.error.no.results.subtitle"/>';
		PSACC.textSwitchedOn = '<spring:theme code="text.account.consent.management.accessibility.switchedOn"/>';
		PSACC.textSwitchedOff = '<spring:theme code="text.account.consent.management.accessibility.switchedoff"/>';
</script>
