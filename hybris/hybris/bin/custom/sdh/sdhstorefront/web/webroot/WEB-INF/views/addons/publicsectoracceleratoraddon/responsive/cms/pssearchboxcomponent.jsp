<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<c:url value="/search/" var="searchUrl" />
<c:url value="/search/autocomplete/${ycommerce:encodeHTML(component.uid)}" var="autocompleteUrl" />

<c:set var="title"> <spring:theme code="search.form.title"/></c:set>
<div class="ui-front">
	<form name="search_form_${ycommerce:encodeHTML(component.uid)}" title="${title}" method="get" action="${searchUrl}">
		<div class="input-group">
			<spring:theme code="search.placeholder" var="searchPlaceholder" />
			<spring:theme code="search.title" var="searchInputTitle" />
			<spring:theme code="search.icon" var="searchIconTitle" />

			<ycommerce:testId code="header_search_input">
				<input type="text" aria-label="${searchPlaceholder}" title="${searchInputTitle}" id="js-site-search-input" class="form-control js-site-search-input" name="text" value="" maxlength="100" placeholder="${searchPlaceholder}"
					data-options='{"autocompleteUrl" : "${autocompleteUrl}","minCharactersBeforeRequest" : "${component.minCharactersBeforeRequest}","waitTimeBeforeRequest" : "${component.waitTimeBeforeRequest}","displayProductImages" : ${component.displayProductImages}}'>
			</ycommerce:testId>

			<span class="input-group-btn"> <ycommerce:testId code="header_search_button">
					<button tabindex="0" title="${searchIconTitle}" class="btn btn-link btn-primary btn-search" type="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</ycommerce:testId>
			</span>
		</div>
	</form>

</div>
