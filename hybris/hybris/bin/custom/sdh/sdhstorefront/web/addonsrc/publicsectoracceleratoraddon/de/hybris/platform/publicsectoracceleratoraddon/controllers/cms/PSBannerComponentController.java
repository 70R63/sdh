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

import de.hybris.platform.acceleratorfacades.device.ResponsiveMediaFacade;
import de.hybris.platform.cms2.enums.LinkTargets;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commerceservices.i18n.CommerceCommonI18NService;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.ControllerConstants;
import de.hybris.platform.publicsectorservices.model.PSBannerComponentModel;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The class of PSBannerComponentController.
 */
@Controller("PSBannerComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PSBannerComponent)
public class PSBannerComponentController<C extends PSBannerComponentModel> extends SubstitutingCMSAddOnComponentController<C>
{
	@Resource(name = "responsiveMediaFacade")
	private ResponsiveMediaFacade responsiveMediaFacade;

	@Resource(name = "commerceCommonI18NService")
	private CommerceCommonI18NService commerceCommonI18NService;


	/**
	 * Fills the model with required attributes for displaying service featured links content
	 *
	 * @param request
	 * @param model
	 * @param component
	 */


	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final C component)
	{
		final List<ImageData> mediaDataList = responsiveMediaFacade
				.getImagesFromMediaContainer(component.getMedia(commerceCommonI18NService.getCurrentLocale()));
		model.addAttribute("medias", mediaDataList);
		model.addAttribute("urlLink", component.getUrlLink());
		model.addAttribute("title", component.getTitle());

		model.addAttribute("bannerComponent", component);
		if (component.getTarget() != null && !LinkTargets.SAMEWINDOW.equals(component.getTarget()))
		{
			final String target = " target=\"_blank\"";
			model.addAttribute("target", target);
		}
	}
}