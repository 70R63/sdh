/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
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

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.publicsectoracceleratoraddon.model.PSAddToCartActionModel;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The class of PSServiceAddToCartActionController.
 */
@Controller("PSAddToCartActionController")
@RequestMapping(value = "/view/" + PSAddToCartActionModel._TYPECODE + "Controller")
public class PSAddToCartActionController extends AbstractCMSAddOnComponentController<PSAddToCartActionModel>
{
	@Resource(name = "productFacade")
	private ProductFacade productFacade;

	/**
	 * Fills the model with required attributes for displaying add to cart action
	 *
	 * @param request
	 * @param model
	 * @param component
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSAddToCartActionModel component)
	{
		final String productCode = getRequestContextData(request).getProduct().getCode();

		final ProductData serviceProductInfo = productFacade.getProductForCodeAndOptions(productCode,
				Arrays.asList(ProductOption.SERVICE_DETAILS));

		model.addAttribute("serviceDetails", serviceProductInfo);
		model.addAttribute("url", component.getUrl());

	}
}
