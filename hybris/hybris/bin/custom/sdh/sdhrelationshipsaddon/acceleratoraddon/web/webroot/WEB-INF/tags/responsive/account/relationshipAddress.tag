<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="relAddresses" required="true" type="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:htmlEscape defaultHtmlEscape="true" />

<div class="panel-body">
	<div class="account-cards card-select">
	    <div class="row">
			<c:forEach items="${relationshipsAddressData}" var="relAddress">
				<div class="col-xs-12 col-sm-6 col-md-4 well">
			        <div class="row">
			            <div class="card col-md-12">
							<br/>
							<c:if test="${not relAddress.defaultAddress}">
								<ul>
									<li>
										${fn:escapeXml(relAddress.title)}&nbsp;${fn:escapeXml(relAddress.firstName)}&nbsp;${fn:escapeXml(relAddress.lastName)}
									</li>
									<li>${fn:escapeXml(relAddress.line1)}</li>
									<c:if test="${not empty fn:escapeXml(relAddress.line2)}">
										<li>${fn:escapeXml(relAddress.line2)}</li>
									</c:if>
									<li>${fn:escapeXml(relAddress.town)}&nbsp;${fn:escapeXml(relAddress.region.name)}</li>
									<li>${fn:escapeXml(relAddress.country.name)}&nbsp;${fn:escapeXml(relAddress.postalCode)}</li>
									<li>${fn:escapeXml(relAddress.phone)}</li>
								</ul>
							</c:if>
							<c:if test="${relAddress.defaultAddress}">
								<ul>
									<li>
										${fn:escapeXml(relAddress.title)}&nbsp;${fn:escapeXml(relAddress.firstName)}&nbsp;${fn:escapeXml(relAddress.lastName)}
										(<spring:theme code="text.default"/>)
									</li>
									<li><strong>${fn:escapeXml(relAddress.line1)}</strong></li>
									<c:if test="${not empty fn:escapeXml(relAddress.line2)}">
										<li><strong>${fn:escapeXml(relAddress.line2)}</strong></li>
									</c:if>
									<li>
										<strong>${fn:escapeXml(relAddress.town)}&nbsp;${fn:escapeXml(relAddress.region.name)}</strong>
									</li>
									<li>
										<strong>${fn:escapeXml(relAddress.country.name)}&nbsp;${fn:escapeXml(relAddress.postalCode)}</strong>
									</li>
									<li><strong>${fn:escapeXml(relAddress.phone)}</strong></li>
								</ul>
							</c:if>
							<br/>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>