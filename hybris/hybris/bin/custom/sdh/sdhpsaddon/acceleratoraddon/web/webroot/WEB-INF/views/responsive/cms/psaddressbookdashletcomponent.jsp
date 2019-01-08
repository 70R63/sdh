<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="my-account/edit-address/${ycommerce:encodeHTML(defaultAddress.id)}" var="editAddress" />

<div class="grid-item dashlet-addressBook">
	<h2 class="header">
		<span tabindex="0">${ycommerce:encodeHTML(component.title)}</span>
	</h2>
	<c:choose>
		<c:when test="${empty defaultAddress}">
			<div class="content">
				<div class="row notification-box">
					<div class="col-xs-12 text-center notification-inner-box">
						<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.addressBook.no.saved.address" /></span>
					</div>
				</div>
				<c:if test="${relationshipsHaveAddresses}">
					<div class="row notification-box">
						<div class="col-xs-12 text-center notification-inner-box">
							<span class="glyphicon glyphicon-info-sign gi-2x notification-icon"></span> <span class="notification-text" tabindex="0"><spring:theme code="text.account.dashlet.addressBook.relationships.saved.addresses" /></span>
						</div>
					</div>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<h3 class="sub-header">
				<span tabindex="0">${ycommerce:encodeHTML(component.summary)}</span>
			</h3>
			<div class="content">
				<p>
				<div class="row">
					<div class="col-xs-8 col-sm-8" tabindex="0">
						<ul>
							<li>${fn:escapeXml(defaultAddress.title)}&nbsp;${fn:escapeXml(defaultAddress.firstName)}&nbsp;${fn:escapeXml(defaultAddress.lastName)}</li>
							<li>${fn:escapeXml(defaultAddress.line1)}</li>
							<c:if test="${not empty fn:escapeXml(defaultAddress.line2)}">
								<li>${fn:escapeXml(defaultAddress.line2)}</li>
							</c:if>
							<li>${fn:escapeXml(defaultAddress.town)}&nbsp;${fn:escapeXml(defaultAddress.region.name)}</li>
							<li>${fn:escapeXml(defaultAddress.country.name)}&nbsp;${fn:escapeXml(defaultAddress.postalCode)}</li>
							<li>${fn:escapeXml(defaultAddress.phone)}</li>
						</ul>
					</div>
					<div class="col-xs-4 col-sm-4 text-right no-space">
						<ycommerce:testId code="addressBook_editAddress_button">
							<spring:theme code="text.account.dashlet.addressBook.accessibility.updateThisAddress" var="updateThisAddress" />
							<div class="editIconForm">
								<button type="button" class="address-edit" onclick="window.location='${editAddress}'">
					               <span class="visuallyhidden">${updateThisAddress}</span><span class="glyphicon glyphicon-edit gi-2x edit-address-icon"></span>
			                    </button>
							</div>
						</ycommerce:testId>
						<ycommerce:testId code="addressBook_removeAddress_button">
							<spring:theme code="text.account.dashlet.addressBook.accessibility.deleteThisAddress" var="deleteThisAddress" />
							<div class="deleteIconForm">
								<button type="button" class="removeAddressFromBookButton delete-address" data-address-id="${ycommerce:encodeHTML(defaultAddress.id)}" data-popup-title="<spring:theme code="text.address.delete.popup.title" />">
					               <span class="visuallyhidden">${deleteThisAddress}</span> <span class="glyphicon glyphicon-trash gi-2x delete-address-icon"></span>
			                    </button>
							</div>
						</ycommerce:testId>
					</div>
				</div>
				</p>
			</div>

			<div id="popup_confirm_address_removal_${ycommerce:encodeHTML(defaultAddress.id)}" class="account-address-removal-popup">
				<div class="addressItem">
					<spring:theme code="text.address.remove.following" var="deleteAddressText" />
					<div tabindex="0" aria-label="${deleteAddressText}">${deleteAddressText}</div>
					<div class="address" tabindex="0" aria-labelledby="addressDetails">
						<div id=addressDetails>
							<strong> ${fn:escapeXml(defaultAddress.title)}&nbsp; ${fn:escapeXml(defaultAddress.firstName)}&nbsp; ${fn:escapeXml(defaultAddress.lastName)} </strong> <br> ${fn:escapeXml(defaultAddress.line1)}&nbsp; ${fn:escapeXml(defaultAddress.line2)} <br> ${fn:escapeXml(defaultAddress.town)}&nbsp;
							<c:if test="${not empty defaultAddress.region.name }">
                            	${fn:escapeXml(defaultAddress.region.name)}&nbsp;
                            </c:if>
							<br> ${fn:escapeXml(defaultAddress.country.name)}&nbsp; ${fn:escapeXml(defaultAddress.postalCode)} <br /> ${fn:escapeXml(defaultAddress.phone)}
						</div>
					</div>
					<div class="modal-actions">
						<div class="col-xs-12 col-sm-6">
							<button type="submit" class="btn btn btn-grey btn-block center-block closeColorBox" data-address-id="${ycommerce:encodeHTML(defaultAddress.id)}">
								<spring:theme code="text.button.cancel" />
							</button>
						</div>
						<ycommerce:testId code="addressRemove_delete_button">
							<div class="col-xs-12 col-sm-6">
								<spring:url var="deleteAddressUrl" value="/my-account/remove-address"/>
								<button class="btn btn-primary btn-block" data-address-id="${ycommerce:encodeHTML(defaultAddress.id)}" onclick="window.location='${deleteAddressUrl}/${ycommerce:encodeHTML(defaultAddress.id)}?CSRFToken=${CSRFToken.token}'">
									<spring:theme code="text.address.delete" />
								</button>
							</div>
						</ycommerce:testId>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<div class="content">
		<div class="row">
			<div class="col-xs-12 col-sm-5 pull-right ${(userHasMoreAddresses || relationshipsHaveAddresses) ? 'pull-left' : ''} button-box text-center">
				<spring:url var="addAddressUrl" value="/my-account/add-address" htmlEscape="false" />
				<button type="button" class="btn btn-primary btn-block" onclick="window.location='${addAddressUrl}'">
					<spring:theme code="text.account.addressBook.addAddress" />
				</button>
			</div>
			<c:if test="${userHasMoreAddresses || relationshipsHaveAddresses}">
				<div class="col-xs-12 col-sm-2 button-box text-center">
					<span class="or-text" tabindex="0"><spring:theme code="text.account.dashlet.addressBook.or" /></span>
				</div>
				<div class="col-xs-12 col-sm-5 button-box text-center">
				    <spring:url var="addressBookUrl" value="/my-account/address-book"/>
					<button type="button" class="btn btn-primary btn-block" onclick="window.location='${addressBookUrl}'">
						<spring:theme code="text.account.dashlet.addressBook.seeAllAddresses" />
					</button>
				</div>
			</c:if>
		</div>
	</div>
</div>