<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="socialshare" tagdir="/WEB-INF/tags/addons/publicsectoracceleratoraddon/responsive/product/socialshare"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:if test="${not empty shareThisPage and not empty shareThisPage.title }">
	<div class="row no-margin">
		<div class="card col-xs-12 col-sm-12 col-md-12">
			<div class="pdp-section-h2"><h2><span tabindex="0">${ycommerce:encodeHTML(shareThisPage.title)}</span></h2></div>
			<div class="pdp-section-content">
				<div class="social-icons">
					<ul>
						<li><socialshare:fbshare fbAppId="${fbAppId }"/></li>
						<li><socialshare:twittershare/></li>
						<li><socialshare:googleplusshare/></li>
						<li><socialshare:linkedinshare/></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function shareInNewWindow(shareUrl) {
			var url = window.location.href;
			window.open(shareUrl, 'popupwindow',
					'scrollbars=yes,width=800,height=400').focus();
			return false;
		}
	</script>
</c:if>
