/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 * Base controller for all page controllers. Provides common functionality for all page controllers.
 */
public abstract class RetenedoresAbstractPageController extends AbstractPageController
{

	static final String RETEICA_TEMPLATE_ID = "reteICATemplate";

	@Resource(name = "mediaService")
	MediaService mediaService;

	@Resource(name = "modelService")
	ModelService modelService;

	@ModelAttribute("reteICATemplateURL")
	public String getReteICATemplateURL()
	{
		final MediaModel mediaModel = mediaService.getMedia(RETEICA_TEMPLATE_ID);

		return mediaModel.getDownloadURL();
	}

	@ModelAttribute("perdiods")
	public List<String> getPeriods()
	{
		return Arrays.asList("01", "02", "03", "04", "05", "06");
	}

	@ModelAttribute("customerNIT")
	public String getNIT()
	{
		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();
		final String customerNit = StringUtils.leftPad(customerData.getDocumentNumber(), 11, "0");
		return customerNit;
	}

	@ModelAttribute("customerName")
	public String getCustomerName()
	{
		final CustomerData customerData = getCustomerFacade().getCurrentCustomer();
		return customerData.getCompleteName();
	}

	@ModelAttribute("years")
	public List<String> getYears()
	{
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		final int minimunYear = currentYear - 4;

		final List<String> years = new ArrayList<String>();

		while (currentYear > minimunYear)
		{
			years.add(String.valueOf(currentYear));
			currentYear--;
		}


		return years;
	}

	@ModelAttribute("reteIcaMaxFileSize")
	public String getReteIcaMaxFileSize()
	{
		return getConfigurationService().getConfiguration().getString("sdh.reteica.file.max.upload.size.bytes", "10485760");
	}
}
