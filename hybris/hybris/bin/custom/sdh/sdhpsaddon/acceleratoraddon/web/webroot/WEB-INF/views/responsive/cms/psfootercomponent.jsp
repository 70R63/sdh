<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/responsive/common/footer"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container-fluid">

	<div class="footer__top">
		<div class="row">
<!-- 			<div class="footer-left col-xs-12 col-sm-12 col-md-8 col-md-offset-2"> -->
<!-- 				<div> -->
<%-- 					<c:forEach items="${footerComponent.navigationNodes}" var="node"> --%>
<%-- 						<c:if test="${node.visible}"> --%>
<%-- 							<c:forEach items="${node.links}" step="${component.wrapAfter}" --%>
<%-- 								varStatus="i"> --%>
<!-- 								<div class="footer__nav--container links col-xs-12 col-sm-3"> -->
<%-- 									<c:if test="${component.wrapAfter > i.index}"> --%>
<%-- 										<div class="title">${node.title}</div> --%>
<%-- 									</c:if> --%>
<!-- 									<ul class="footer__nav--links"> -->
<%-- 										<c:forEach items="${node.links}" var="childlink" --%>
<%-- 											begin="${i.index}" end="${i.index + component.wrapAfter - 1}"> --%>
<%-- 											<cms:component component="${childlink}" --%>
<%-- 												evaluateRestriction="true" element="li" /> --%>
<%-- 										</c:forEach> --%>
<!-- 									</ul> -->
<!-- 								</div> -->
<%-- 							</c:forEach> --%>
<%-- 						</c:if> --%>
<%-- 					</c:forEach> --%>
<!-- 					<div class="links col-xs-12 col-sm-6 col-md-12 col-lg-12"> -->
<!-- 						<div class="col-xs-12 col-sm-12"> -->
<!-- 							<div class="clearfix social-links"> -->
<%-- 								<c:if test="${footerComponent.socialNavigationNode.visible}"> --%>
<%-- 									<c:forEach --%>
<%-- 										items="${footerComponent.socialNavigationNode.links}" --%>
<%-- 										step="${component.wrapAfter}" varStatus="i"> --%>
<%-- 										<c:if test="${component.wrapAfter > i.index}"> --%>
<%-- 											<div class="title">${ycommerce:encodeHTML(footerComponent.socialNavigationNode.title)}</div> --%>
<%-- 										</c:if> --%>
<!-- 										<ul> -->
<%-- 											<c:forEach --%>
<%-- 												items="${footerComponent.socialNavigationNode.links}" --%>
<%-- 												var="socialLink" begin="${i.index}" --%>
<%-- 												end="${i.index + component.wrapAfter - 1}"> --%>
<%-- 												<cms:component component="${socialLink}" --%>
<%-- 													evaluateRestriction="true" element="li" /> --%>
<%-- 											</c:forEach> --%>
<!-- 										</ul> -->
<%-- 									</c:forEach> --%>
<%-- 								</c:if> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="footer__right col-xs-12 col-sm-12 col-md-12 col-lg-8"> -->
<!-- 							<div class="lang-currency-section"> -->
<!-- 								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 footer__dropdown"> -->
<%-- 									<footer:languageSelector languages="${languages}" --%>
<%-- 										currentLanguage="${currentLanguage}" /> --%>
<!-- 								</div> -->
<!-- 								<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 footer__dropdown"> -->
<%-- 									<footer:currencySelector currencies="${currencies}" --%>
<%-- 										currentCurrency="${currentCurrency}" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
	</div>
</div>

<div class="copyright footer__bottom">
	<div class="container">
		<div class="row">

			<div class="col-sm-4"></div>
<%-- 			<div class="copyright-text col-sm-4 center-block footer__copyright">${fn:escapeXml(footerComponent.notice)}</div> --%>

<!-- 			<div class="col-sm-4"></div> -->
<%-- 			<div class="copyright-text col-sm-4 center-block footer__copyright">${fn:escapeXml(footerComponent.notice)}} --%>
<!-- 			</div> -->

			<!-- Chat Toggle -->
<%-- 			<button value='<c:url value="/chat/chatWindow"/>' tabindex="0" --%>
<!-- 				class="js-newWindow btn btn-lg mobile-chat" id="mobile-chat" -->
<!-- 				data-popup="scrollbars=yes"> -->
<%-- 				<spring:theme code="chat.box.mobile.title" /> --%>
<!-- 			</button> -->
<!-- 			<div class="col-sm-6 chat-footer"> -->
<!-- 				<button type="button" -->
<!-- 					class="btn btn-lg pop-over pop-over-toggle" onclick="openChatWindow();" -->
<!-- 					id="pop-over-toggle" data-placement="top" > -->
<!-- 					<div class="chat-glyphicon-close"> -->
<%-- 						<spring:theme code="chatbox.title" /> --%>
<!-- 					</div> -->
<!-- 				</button> -->
<!-- 			</div> -->
<div class="col-md-1">
<a>
<img title="Bogota" alt="Bogota" class="footerimg" src="/bogota/_ui/addons/sdhpsaddon/responsive/theme-psalpha/images/Bogota_footer_1.svg" width="200" height="196">
</a>
</div>
<div class="col-md-1">
<a>
<img title="Bogota" alt="Bogota" class="footerimg_gov" src="/bogota/_ui/addons/sdhpsaddon/responsive/theme-psalpha/images/Bogota_footer_2.svg" width="135" height="27">
</a>
</div>
		</div>
	</div>
	
	<!-- Chat Module -->
	 <div class="container chat-container popover-content" id="popover-content">
		 <div class="chat-module active col-xs-12 col-sm-12 col-md-12 col-lg-12 no-space">
			<div class="chat-module-container col-xs-6 col-sm-5 col-md-5 col-lg-3 no-space">
				 <div class="chat-module-header">
					<div>
						<span tabindex="0" class="chat-glyphicon-open">
						    <spring:theme code="chatbox.title" />
						</span>
						<span>
						   <spring:theme code="chat.box.close" var="chatClose"></spring:theme>
						   <spring:theme code="chat.box.new.chat" var="chatWindow"></spring:theme>
						   <button class="close chat-glyphicon" tabindex="0" title="${chatClose}"></button>
						   <button value='<c:url value="/bogota/chat/customer"/>'
								class="glyphicon glyphicon-new-window js-newWindow"
								data-popup="scrollbars=yes" title="${chatWindow}"></button>
						</span>
					</div>
				</div>
				<div class="chat-module-content">
					<div class="form-group ">
						<label for="chat-name" class="control-label required"> <spring:theme
								code="chatbox.name" />
						</label> <input type="text" value="" class="chat-text form-control chat-name"
							name="chat.name" id="chat-name" data-trigger="focus">
					</div>
					<div class="form-group ">
						<label for="chat-email" class="control-label"> <spring:theme
								code="chatbox.email" />
						</label> <input type="text" value="" class="chat-text form-control chat-email"
							name="chat.email" id="chat-email">
					</div>
					<div class="form-group ">
						<label for="chat-message" class="control-label required">
							<spring:theme code="chatbox.message" />
						</label>
						<textarea
							class="chat-text form-control chat-textarea chat-message" name="chat.message"
							id="chat-message"> </textarea>
					</div>
					<spring:message code="chatbox.start.chat" var="startChatText" />
					<input type="submit" name="submit"
						class="btn btn-black btn-block btn-chat" value="${fn:escapeXml(startChatText)}"></input>
					<br />
				</div>
			  </div>
		 </div>
	</div>

</div>

	</div>


	<script>
        function openChatWindow(){
           var url = window.location.href;
           url = url.substring(0, url.indexOf("bogota")) + "bogota/chat/customer";
           myWindow = window.open(url, "", "width=345, height=575");
        }
    </script>