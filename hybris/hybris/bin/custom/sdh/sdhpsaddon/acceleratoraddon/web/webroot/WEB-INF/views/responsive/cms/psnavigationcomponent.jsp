<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<c:set value="${ycommerce:encodeHTML(component.styleClass)}" var="navigationClass" />

<c:if test="${component.visible}">
		<div class="container ${navigationClass}" style="display:none;" data-title="${ycommerce:encodeHTML(component.navigationNode.title)}">
			<nav style="display:none;">
				<ul>
					<c:if test="${not empty component.navigationNode.title }">
						<li>
							<c:out value="${ycommerce:encodeHTML(component.navigationNode.title)}"/>
						</li>
					</c:if>
					<c:forEach items="${component.navigationNode.children}" var="topLevelChild">
						<li>
							<c:forEach items="${topLevelChild.entries}" var="entry">
								<div>
									<cms:component component="${entry.item}" evaluateRestriction="true" />
								</div>
							</c:forEach>
						</li>
					</c:forEach>
				</ul>
			</nav>
		</div>
</c:if>