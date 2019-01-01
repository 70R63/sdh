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
package de.hybris.platform.sdhpsaddon.controllers.cms;

import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.service.data.PSApplyByPhoneData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSApplyByPhoneComponentModel;
import de.hybris.platform.publicsectorservices.model.PSServiceProductModel;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The class of PSApplyByPhoneComponentController.
 */
@Controller("PSApplyByPhoneComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSApplyByPhoneComponent)
public class PSApplyByPhoneComponentController<C extends PSApplyByPhoneComponentModel>
		extends SubstitutingCMSAddOnComponentController<C>
{
	@Resource(name = "productFacade")
	private ProductFacade productFacade;

	/**
	 * Fills the model with required attributes for displaying service applybyphone content
	 *
	 * @param request
	 * @param model
	 * @param component
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSApplyByPhoneComponentModel component)
	{
		final ProductModel currentProduct = getRequestContextData(request).getProduct();

		if (currentProduct != null && (currentProduct instanceof PSServiceProductModel))
		{
			final ProductData productData = productFacade.getProductForCodeAndOptions(currentProduct.getCode(),
					Arrays.asList(ProductOption.SERVICE_DETAILS));
			final PSApplyByPhoneData applyByPhoneData = productData.getApplyByPhoneCMS();
			model.addAttribute("applyByPhone", applyByPhoneData);
		}
	}
}
