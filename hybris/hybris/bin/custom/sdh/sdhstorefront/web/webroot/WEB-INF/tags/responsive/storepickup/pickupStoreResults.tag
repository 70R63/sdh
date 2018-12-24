<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="searchPageData" required="true" type="de.hybris.platform.commerceservices.search.pagedata.SearchPageData" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="storepickup" tagdir="/WEB-INF/tags/responsive/storepickup" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

{"data":[
	<c:forEach items="${searchPageData.results}" var="pickupStore" varStatus="pickupEntryNumber">
		<c:set value="${ycommerce:storeImage(pickupStore, 'store')}"  var="storeImage"/>
		<c:set var="stockPickup"><storepickup:pickupStoreStockLevel stockData="${pickupStore.stockData}"/></c:set>
		
		<c:set var="pickupStoreNameHTML" value="${fn:escapeXml(pickupStore.name)}" />
		<c:set var="pickupStoreDisplayNameHTML" value="${fn:escapeXml(pickupStore.displayName)}" />
		<c:set var="pickupStoreAddressTownHTML" value="${fn:escapeXml(pickupStore.address.town)}" />
		<c:set var="pickupStoreAddressLine1HTML" value="${fn:escapeXml(pickupStore.address.line1)}" />
		<c:set var="pickupStoreAddressLine2HTML" value="${fn:escapeXml(pickupStore.address.line2)}" />
		<c:set var="pickupStoreAddressCountryNameHTML" value="${fn:escapeXml(pickupStore.address.country.name)}" />
		<c:set var="pickupStoreAddressPostalCodeHTML" value="${fn:escapeXml(pickupStore.address.postalCode)}" />
		<c:set var="pickupStoreFormattedDistanceHTML" value="${fn:escapeXml(pickupStore.formattedDistance)}" />
		<c:set var="pickupStoreStoreImageUrlHTML" value="${fn:escapeXml(storeImage.url)}" />
		<c:set var="searchPageDataProductCodeHTML" value="${fn:escapeXml(searchPageData.product.code)}" />
		<c:set var="pickupStoreGeoPointLatitudeHTML" value="${fn:escapeXml(pickupStore.geoPoint.latitude)}" />
		<c:set var="pickupStoreGeoPointLongitudeHTML" value="${fn:escapeXml(pickupStore.geoPoint.longitude)}" />
		<c:set var="pickupStoreStockDataStockLevelHTML" value="${fn:escapeXml(pickupStore.stockData.stockLevel)}" />
		{
			"name" : "${ycommerce:encodeJSON(pickupStoreNameHTML)}",
			"displayName" : "${ycommerce:encodeJSON(pickupStoreDisplayNameHTML)}",
			"town" : "${ycommerce:encodeJSON(pickupStoreAddressTownHTML)}",
			"line1" : "${ycommerce:encodeJSON(pickupStore.address.line1)}",
			"line2" : "${ycommerce:encodeJSON(pickupStoreAddressLine2HTML)}",
			"country" : "${ycommerce:encodeJSON(pickupStoreAddressCountryNameHTML)}",
			"postalCode" : "${ycommerce:encodeJSON(pickupStoreAddressPostalCodeHTML)}",
			"formattedDistance" : "${ycommerce:encodeJSON(pickupStoreFormattedDistanceHTML)}",
			"url" : "${ycommerce:encodeJSON(pickupStoreStoreImageUrlHTML)}",
			"stockPickup" : "${stockPickup}",
			<storepickup:pickupStoreOpeningSchedule store="${pickupStore}"/>
			"productcode":"${ycommerce:encodeJSON(searchPageDataProductCodeHTML)}",
			"storeLatitude":"${ycommerce:encodeJSON(pickupStoreGeoPointLatitudeHTML)}",
			"storeLongitude":"${ycommerce:encodeJSON(pickupStoreGeoPointLongitudeHTML)}",
			"stockLevel": "${ycommerce:encodeJSON(pickupStoreStockDataStockLevelHTML)}"
		}<c:if test="${!pickupEntryNumber.last}">,</c:if>
	</c:forEach>
]}
