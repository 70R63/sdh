<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="dashboard">
	<div class="row no-margin content-space">
		<div class="dashboard-header">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<span tabindex="0"><spring:theme code="text.account.dashboard.heading" /></span>
					</h1>
				</div>
			</div>
		</div>
		<div class="grid">
			<div class="grid-sizer"></div>
			<div class="gutter-sizer"></div>
			<c:forEach items="${dashlets}" var="dashlet">
				<cms:component component="${dashlet}" />
			</c:forEach>
		</div>
	</div>
</div>
