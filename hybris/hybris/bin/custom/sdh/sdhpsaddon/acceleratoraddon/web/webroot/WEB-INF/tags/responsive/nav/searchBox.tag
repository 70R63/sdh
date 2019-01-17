<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<h1 class="acc_hidden"><span tabindex="0"><spring:theme code="text.homepage.label" /></span></h1>
<span class="site-search-heading"><spring:theme code="searchBox.label" /></span>
<cms:component uid="SearchBox" class="search-field" />

