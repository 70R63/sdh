<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account" var="dashboardUrl" />
<spring:url value="/my-account/asset" var="assetDetailsUrl" />
<spring:theme code="text.back.icon.accessibility" var="back" />

<div class="asset-overview">
	<div class="row no-margin global-content-space">
		<div class="back-link border">
			<div class="row">
				<div class="col-md-6">
					<button type="button" class="addressBackBtn" data-back-to-addresses="${dashboardUrl}">
						<span class="glyphicon glyphicon-chevron-left" aria-label="${back}"></span>
					</button>
					<h1 class="custom-h1">
						<span class="label" tabindex="0"><spring:theme code="text.account.myAssets" /></span>
					</h1>
				</div>
			</div>
		</div>
		<div class="account-section-subheader">
			<div class="pull-left">
				<br /> <span tabindex="0"><spring:theme code="text.account.assetsOverview.heading" /></span>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 ">
				<div class="asset-listing card-section">
					<div class="row">
						<c:forEach items="${assets}" var="asset">
							<div class="col-sm-12 col-md-6 asset-listing-card-cell">
								<div class="asset-listing-card">
									<div class="col-xs-4 col-sm-3 col-md-2 no-space">
									<img class="asset-logo" src="${asset.assetType.iconMediaURL}" alt="${asset.assetType.name}" title="${asset.assetType.name}">
									</div>
									<div class="col-xs-8 col-sm-5 col-md-5">
										<h2>
											<span tabindex="0">${asset.assetName}</span>
										</h2>
									<div tabindex="0">${asset.assetType.name}</div>
									</div>
									<div class="card-section-footer col-xs-12 col-sm-4 col-md-5">
										<button class="btn btn-primary btn-block" onClick="window.location='${assetDetailsUrl}/${asset.code}'">
											<spring:theme code="text.account.assetsOverview.viewDetail.button" />
										</button>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>