<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="custom-store" tagdir="/WEB-INF/tags/addons/sdhpsaddon/responsive/store"%>

<custom-store:storeSearch errorNoResults="${errorNoResults}" />
<custom-store:storeListForm searchPageData="${searchPageData}" locationQuery="${locationQuery}" numberPagesShown="${numberPagesShown}" geoPoint="${geoPoint}" />