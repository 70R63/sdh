<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <spring:htmlEscape defaultHtmlEscape="true" />
 
	<div id="addressbook">
									<c:forEach items="${addresses}" var="deliveryAddress" varStatus="status">
										<div class="addressEntry">
											<ul>
												<li>
													<strong>${fn:escapeXml(deliveryAddress.title)}&nbsp;
													${fn:escapeXml(deliveryAddress.firstName)}&nbsp;
													${fn:escapeXml(deliveryAddress.lastName)}</strong> <br>
													${fn:escapeXml(deliveryAddress.line1)}&nbsp;
													${fn:escapeXml(deliveryAddress.line2)} <br>
													${fn:escapeXml(deliveryAddress.town)} 
													<c:if test="${not empty deliveryAddress.region.name}">
														&nbsp;${fn:escapeXml(deliveryAddress.region.name)}
													</c:if> <br>
													${fn:escapeXml(deliveryAddress.country.name)}&nbsp;
													${fn:escapeXml(deliveryAddress.postalCode)}</li>
											</ul>
											<button type="submit" class="btn btn-primary btn-block btn-yform-address"  data-addressline1="${deliveryAddress.line1}"  data-addressline2="${deliveryAddress.line2}" data-addresscity="${deliveryAddress.town}" data-addresspostalcode="${deliveryAddress.postalCode}" data-addresscode="${deliveryAddress.id}" data-countryisocode="${deliveryAddress.country.isocode}" data-phone="${deliveryAddress.phone}">
												<spring:theme code="checkout.multi.deliveryAddress.useThisAddress" text="Use this Address" />
											</button>
										</div>
									</c:forEach>
								</div>