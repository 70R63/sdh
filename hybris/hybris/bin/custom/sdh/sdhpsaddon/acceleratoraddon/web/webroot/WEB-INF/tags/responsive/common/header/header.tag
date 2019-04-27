<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="hideHeaderLinks" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:theme code="text.megamenu" var="textMegamenu" />
<spring:theme code="serviceFinder.acc.title" var="serviceFinderTitle" />
<header class="js-mainHeader main-header">
	<nav class="navigation navigation--top hidden-xs hidden-sm">
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<div class="nav__left js-site-logo">
					<div class="col-xs-12 no-space yComponentWrapper">
						<cms:pageSlot position="TopHeaderSlot" var="component"
							element="div" class="col-xs-12 no-space yComponentWrapper">
							<cms:component component="${component}" />
						</cms:pageSlot>
					</div>
				</div>
			</div>
		</div>
	</nav>


	<nav class="navigation navigation--middle js-navigation--middle">
		<div class="container-fluid">
			<div class="row">
				<div class="mobile__nav__row mobile__nav__row--table">
					<div class="mobile__nav__row--table-group">
						<div class="mobile__nav__row--table-row">
							<c:if test="${hideMenuBar ne true}">
								<div class="mobile__nav__row--table-cell visible-xs hidden-sm" >
									<button title="${textMegamenu}" aria-label="${megaMenuText}"
										class="mobile__nav__row--btn  mobile__nav__row--btn-menu js-toggle-sm-navigation header-menu-btn"
										type="button">
										<span class="glyphicon glyphicon-align-justify"></span>
									</button>
								</div>
							</c:if>
<!-- 							<div class="mobile__nav__row--table-cell visible-xs hidden-sm "> -->
<!-- 									<div class="col-xs-12 no-space yComponentWrapper hpsa-logo-block "> -->
<%-- 										<cms:pageSlot position="SiteLogo" var="logo" limit="1"> --%>
<%-- 											<cms:component component="${logo}" element="div" --%>
<%-- 												class="col-xs-12 no-space yComponentWrapper" /> --%>
<%-- 										</cms:pageSlot> --%>
<!-- 									</div> -->
<%-- 								</button> --%>
<!-- 							</div> -->

<%-- 							<c:if test="${empty hideHeaderLinks}"> --%>
<%-- 								<ycommerce:testId code="header_StoreFinder_link"> --%>
<!-- 									<div -->
<!-- 										class="mobile__nav__row--table-cell hidden-sm hidden-md hidden-lg" > -->
<%-- 										<spring:theme code="serviceFinder.acc.label" --%>
<%-- 											var="serviceFinderLabel" /> --%>
<%-- 										<a href="<c:url value="/store-finder"/>" --%>
<%-- 											 aria-label="${serviceFinderLabel}" --%>
<!-- 											class="mobile__nav__row--btn mobile__nav__row--btn-location"> -->
<%-- 											<span class="visuallyhidden">${ycommerce:encodeHTML(serviceFinderLabel)}</span><span --%>
<!-- 											class="glyphicon glyphicon-map-marker"></span> -->
<!-- 										</a> -->
<!-- 									</div> -->
<%-- 								</ycommerce:testId> --%>
<%-- 							</c:if> --%>

<!-- 							<div class="mobile__nav__row--table-cell visible-xs "> -->
<%-- 								<ycommerce:testId code="header_search_activation_button"> --%>
<%-- 									<spring:theme code="search.icon" var="searchIconTitle" /> --%>
<%-- 									<button title="${searchIconTitle}" --%>
<!-- 										class="mobile__nav__row--btn btn mobile__nav__row--btn-search js-toggle-xs-search hidden-sm hidden-md hidden-lg" -->
<!-- 										type="button"> -->
<!-- 										<span class="glyphicon glyphicon-search"></span> -->
<!-- 									</button> -->
<%-- 								</ycommerce:testId> --%>
<!-- 							</div> -->

						</div>
					</div>
				</div>
			</div>
			<div class="row desktop__nav">
				<div class="nav__left col-xs-12 col-sm-12 col-md-6">
					<div class="row">

<!-- 						<div class="hidden-xs col-sm-12 col-md-6 hpsa-logo-block"> -->
<!-- 							<div class="col-xs-12 no-space yComponentWrapper"> -->
<%-- 								<cms:pageSlot position="SiteLogo" var="logo" limit="1"> --%>
<%-- 									<cms:component component="${logo}" element="div" --%>
<%-- 										class="col-xs-12 no-space yComponentWrapper" /> --%>
<%-- 								</cms:pageSlot> --%>
<!-- 							</div> -->
<!-- 						</div> -->
						<c:if test="${hideMenuBar ne true}">
							<div class="col-sm-1 hidden-xs visible-sm mobile-menu">
								<button title="${textMegamenu}" aria-label="${megaMenuText}" class="js-toggle-sm-navigation header-menu-btn" type="button">
									<span class="glyphicon glyphicon-align-justify"></span>
								</button>
							</div>
						</c:if>

<%-- 						<c:if test="${empty hideHeaderLinks}"> --%>
<%-- 							<ycommerce:testId code="header_StoreFinder_link"> --%>
<!-- 								<div class="col-sm-1 hidden-xs visible-sm"> -->
<%-- 									<spring:theme code="serviceFinder.acc.label" --%>
<%-- 										var="serviceFinderLabel" /> --%>
<%-- 									<a href="<c:url value="/store-finder"/>" --%>
<%-- 										aria-label="${serviceFinderLabel}" --%>
<%-- 										class="js-toggle-sm-navigation" title="${serviceFinderTitle}"> <span --%>
<%-- 										class="visuallyhidden">${ycommerce:encodeHTML(serviceFinderLabel)}</span><span --%>
<!-- 										class="glyphicon glyphicon-map-marker gi-2x"></span> -->
<!-- 									</a> -->
<!-- 								</div> -->
<%-- 							</ycommerce:testId> --%>
<%-- 						</c:if> --%>

						<div class="col-sm-10 col-md-6">
							<div class="site-search js-toggle-xs-search">
								<cms:pageSlot position="SearchBox" var="component">
									<cms:component component="${component}" element="div" />
								</cms:pageSlot>
							</div>
						</div>
					</div>
				</div>

				<div
					class="nav__right col-md-6 col-lg-6 hidden-xs hidden-sm md-secondary-navigation ">
					<ul class="nav__links nav__links--account pull-right">

						<c:if test="${empty hideHeaderLinks}">

							<c:if test="${uiExperienceOverride}">
								<li class="backToMobileLink"><c:url
										value="/_s/ui-experience?level=" var="backToMobileStoreUrl" />
									<a href="${backToMobileStoreUrl}"> <spring:theme
											code="text.backToMobileStore" />
								</a></li>
							</c:if>
							<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
								<li>
									<span class="logged_in js-logged_in">
									<ycommerce:testId
											code="header_tipo_doc">
											<spring:theme code="header.tipo.doc" htmlEscape="true" />&nbsp;${ docType}
										</ycommerce:testId></span>
								</li>
								<li>
									<span class="logged_in js-logged_in">
									<ycommerce:testId
											code="header_num_doc">
											<spring:theme code="header.num.doc" htmlEscape="true" />&nbsp;${ docNumber}
										</ycommerce:testId></span>
								</li>
							</sec:authorize>
							

							<cms:pageSlot position="HeaderLinks" var="link">
								<li><cms:component component="${link}" element="" /></li>
							</cms:pageSlot>

<%-- 							<sec:authorize access="hasRole('ROLE_ANONYMOUS')"> --%>
<!-- 								<li class="liOffcanvas"> -->
<%-- 									<ycommerce:testId code="header_Login_link"> --%>
<%-- 										<spring:theme code="signInRegister.acc.title" var="signInRegisterTitle" /> --%>
<%-- 										<a title="${signInRegisterTitle}" href="<c:url value='/login'/>"> --%>
<%-- 											<spring:theme code="header.link.login" /> --%>
<!-- 										</a> -->
<%-- 									</ycommerce:testId> --%>
<!-- 								</li> -->
<%-- 							</sec:authorize> --%>

							<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
								<li class="liOffcanvas">
									<ycommerce:testId code="header_tipo_doc_link">
										<spring:theme code="header.tipo.doc" var="Tipo de Documento: " />
									</ycommerce:testId>
								</li>
								<li class="liOffcanvas">
									<ycommerce:testId code="header_num_doc_link">
										<spring:theme code="header.num.doc" var="Número de Documento: " />
									</ycommerce:testId>
								</li>
								<li class="liOffcanvas">
									<ycommerce:testId code="header_signOut">
										<spring:theme code="signOut.acc.title" var="signOutTitle" />
										<a title="${signOutTitle}" href="<c:url value='/logout'/>">
											<spring:theme code="header.link.logout" />
										</a>
									</ycommerce:testId>
								</li>
							</sec:authorize>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		<%-- a hook for the my account links in desktop/wide desktop--%>
		<div class="hidden-xs hidden-sm js-secondaryNavAccount collapse"
			id="accNavComponentDesktopOne">
			<ul class="nav__links">

			</ul>
		</div>
		<div class="hidden-xs hidden-sm js-secondaryNavCompany collapse"
			id="accNavComponentDesktopTwo">
			<ul class="nav__links js-nav__links">

			</ul>
		</div>
	</nav>
	<a id="skiptonavigation" tabindex="-1"></a>
	<nav:topNavigation />
</header>
<cms:pageSlot position="BottomHeaderSlot" var="component" element="div"
	class="container-fluid">
	<cms:component component="${component}" />
</cms:pageSlot>


<script>
	function borraMenu(elementMenu, indexMenu, arrayMenu, html_element, element_attr){
		
		var li_array = document.getElementsByTagName(html_element);
		var attr_value;
		var li_index;
		var error_message;
		
		for( li_index = 0; li_index < li_array.length; li_index++ ) {	    		
			try{
				
				if (element_attr == "innerText"){ attr_value = li_array[li_index].innerText;}				
				if (element_attr == "className"){ attr_value = li_array[li_index].className;}
				
				
				if( attr_value.includes(elementMenu)){					  					
					li_array[li_index].remove();
				}	
			}catch(err){
				error_message = err.message;
			}		
    	}
	}
	
	
	function ajustesMenu() {
		
						
		var currentUrl = document.URL;
		var rol;
		var listaMenus=[];
		var li_index;
		
		if (currentUrl.includes("/sdhstorefront/es/login") && 
			!currentUrl.includes("/pw/request/external") ){
			
			listaMenus=[];
			listaMenus.push("breadcrumb-section");
			
			for( li_index = 0; li_index < listaMenus.length; li_index++ ) {
				borraMenu(listaMenus[li_index], li_index, listaMenus, "div", "className");
			}	
		}
		
	}	
	
	ajustesMenu();	
</script>
