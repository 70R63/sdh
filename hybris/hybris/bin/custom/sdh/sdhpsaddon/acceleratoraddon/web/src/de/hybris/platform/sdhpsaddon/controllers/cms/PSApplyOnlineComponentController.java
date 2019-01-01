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
import de.hybris.platform.commercefacades.service.data.PSApplyOnlineData;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.enums.PSApplyOnlineCustomerType;
import de.hybris.platform.publicsectorservices.model.PSApplyOnlineComponentModel;
import de.hybris.platform.publicsectorservices.model.PSServiceProductModel;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The class of PSApplyOnlineComponentController.
 */
@Controller("PSApplyOnlineComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSApplyOnlineComponent)
public class PSApplyOnlineComponentController<C extends PSApplyOnlineComponentModel>
		extends SubstitutingCMSAddOnComponentController<C>
{

	@Resource(name = "productFacade")
	private ProductFacade productFacade;

	@Resource(name = "userFacade")
	private UserFacade userFacade;

	/**
	 * Fills the model with required attributes for displaying service applyonline content
	 *
	 * @param request
	 * @param model
	 * @param component
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final PSApplyOnlineComponentModel component)
	{
		final ProductModel currentProduct = getRequestContextData(request).getProduct();

		if (currentProduct instanceof PSServiceProductModel)
		{
			final ProductData productData = productFacade.getProductForCodeAndOptions(currentProduct.getCode(),
					java.util.Arrays.asList(ProductOption.SERVICE_DETAILS));
			final List<PSApplyOnlineData> applyOnlineDataList = productData.getApplyOnlineCMS();

			PSApplyOnlineData applyOnlineDataForCurrentCustomer = null;
			if (CollectionUtils.isNotEmpty(applyOnlineDataList))
			{
				if (!userFacade.isAnonymousUser())
				{
					applyOnlineDataForCurrentCustomer = findApplyOnlineDataByCustomerType(applyOnlineDataList,
							PSApplyOnlineCustomerType.SIGNED_IN);
				}

				if (applyOnlineDataForCurrentCustomer == null)
				{
					applyOnlineDataForCurrentCustomer = findApplyOnlineDataByCustomerType(applyOnlineDataList,
							PSApplyOnlineCustomerType.NOT_SIGNED_IN);
				}
			}
			model.addAttribute("serviceProduct", productData);
			model.addAttribute("applyOnline", applyOnlineDataForCurrentCustomer);
			model.addAttribute("actions", component.getActions());
		}
	}

	private PSApplyOnlineData findApplyOnlineDataByCustomerType(final List<PSApplyOnlineData> applyOnlineDataList,
			final PSApplyOnlineCustomerType customerType)
	{
		for (final PSApplyOnlineData applyOnlineData : applyOnlineDataList)
		{
			if (applyOnlineData.getCustomerType().equals(customerType))
			{
				return applyOnlineData;
			}
		}
		return null;
	}
}

