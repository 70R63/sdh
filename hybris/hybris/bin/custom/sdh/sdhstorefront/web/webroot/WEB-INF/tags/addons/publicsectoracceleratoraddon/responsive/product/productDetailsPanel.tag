<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>

<div class="pdp-section">
	<div class="pdp-list">
		<div class="row">
			<div class="col-xs-12 col-sm-8 col-md-8 pdp-left-slot">
				<div class="card-transparent col-xs-12 col-sm-12 col-md-12">
					<div class="pdp-section-content-nospace">
						<ycommerce:testId code="productDetails_productNamePrice_label_${product.code}">
							<h1><span tabindex="0">${ycommerce:encodeHTML(product.name)}</span></h1>
						</ycommerce:testId>
						 ${product.description}
					</div>
				</div>

				<cms:pageSlot position="LeftSection" var="component">
					<cms:component component="${component}" />
				</cms:pageSlot>
        	</div>
			<div class="col-xs-12 col-sm-4 col-md-4 pdp-right-slot">
				<cms:pageSlot position="RightSection" var="component">
					<cms:component component="${component}" />
				</cms:pageSlot>
			</div>
		</div>
	</div>
</div>