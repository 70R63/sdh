/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.publicsectoracceleratoraddon.controllers.cms;

import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.service.data.PSKeyFactsData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSKeyFactsComponentModel;
import de.hybris.platform.publicsectorservices.model.PSServiceProductModel;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The class of PSKeyFactsComponentController.
 */
@Controller("PSKeyFactsComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSKeyFactsComponent)
public class PSKeyFactsComponentController<C extends PSKeyFactsComponentModel> extends SubstitutingCMSAddOnComponentController<C>
{
	@Resource(name = "productFacade")
	private ProductFacade productFacade;

	/**
	 * Fills the model with required attributes for displaying service keyFacts content
	 *
	 * @param request
	 * @param model
	 * @param component
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSKeyFactsComponentModel component)
	{
		final ProductModel currentProduct = getRequestContextData(request).getProduct();

		if (currentProduct != null && (currentProduct instanceof PSServiceProductModel))
		{
			final ProductData productData = productFacade.getProductForCodeAndOptions(currentProduct.getCode(),
					Arrays.asList(ProductOption.SERVICE_DETAILS));
			final PSKeyFactsData keyFactsData = productData.getKeyFacts();

			model.addAttribute("serviceProduct", productData);
			model.addAttribute("keyFacts", keyFactsData);
			model.addAttribute("actions", component.getActions());
		}
	}
}
