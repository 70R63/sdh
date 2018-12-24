<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>

<%@ attribute name="openingSchedule" required="true" type="de.hybris.platform.commercefacades.storelocator.data.OpeningScheduleData" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true"/>

<c:if test="${not empty openingSchedule}">
	<spring:theme code="storeDetails.table.opening.closed" var="closedHtml" />
	{
	<c:forEach items="${openingSchedule.weekDayOpeningList}" var="weekDay" varStatus="weekDayNumber">
		<c:set var="dayOfTheWeekHtml" value="${fn:escapeXml(weekDay.weekDay)}" />
		<c:set var="openingTimeHtml" value="${fn:escapeXml(weekDay.openingTime.formattedHour)}" />
		<c:set var="closingTimeHtml" value="${fn:escapeXml(weekDay.closingTime.formattedHour)}" />

		<c:choose>
			<c:when test="${weekDay.closed}" >
				"${ycommerce:encodeJSON(dayOfTheWeekHtml)}":"${ycommerce:encodeJSON(closedHtml)}"<c:if test="${!weekDayNumber.last}">,</c:if>
			</c:when>
			<c:otherwise>
				"${ycommerce:encodeJSON(dayOfTheWeekHtml)}":"${ycommerce:encodeJSON(openingTimeHtml)} - ${ycommerce:encodeJSON(closingTimeHtml)}"<c:if test="${!weekDayNumber.last}">,</c:if>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	},
</c:if>
