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
package de.hybris.platform.publicsectoracceleratoraddon.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.asset.data.PSAssetData;
import de.hybris.platform.publicsectorfacades.asset.PSAssetFacade;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Extended Controller for functionality related with user's assets
 */
@RequestMapping("/my-account")
public class PSAccountAssetsController extends AbstractSearchPageController
{
	private static final Logger LOG = LoggerFactory.getLogger(PSAccountAssetsController.class);

	protected static final String BREADCRUMBS_ATTR = "breadcrumbs";
	protected static final String MAX_COUNT_PER_PAGE = "bills.perpage.maxresults.count";

	private static final String ACCOUNT_MY_ASSETS = "text.account.myAssets";
	private static final String ACCOUNT_ASSET_DETAILS = "text.account.assetDetail";
	private static final String MY_ASSETS_CMS_PAGE = "my-assets";
	private static final String ASSET_DETAIL_CMS_PAGE = "asset-detail";

	@Resource(name = "psMyAccountBreadcrumbBuilder")
	protected ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "psAssetFacade")
	protected PSAssetFacade psAssetFacade;

	@RequestMapping(value = "/my-assets", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getMyAssets(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("assets", psAssetFacade.getAssetsForUser(getUser().getUid()));

		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_ASSETS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_MY_ASSETS));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_ASSETS_CMS_PAGE));
		return getViewForPage(model);
	}

	@RequestMapping(value = "/asset/{assetCode}", method = RequestMethod.GET)
	@RequireHardLogIn
	public String getAssetDetails(@PathVariable("assetCode") final String assetCode, final Model model)
			throws CMSItemNotFoundException
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug("Fetch asset details for asset code: " + assetCode);
		}

		final PSAssetData assetData = fetchAssetEssentialDetails(assetCode);
		model.addAttribute("asset", assetData);

		final String assetAttributesTemplate = getAssetAttributesDetails(assetData);
		model.addAttribute("assetAttributes", assetAttributesTemplate);

		storeCmsPageInModel(model, getContentPageForLabelOrId(ASSET_DETAIL_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, getAccountBreadcrumbBuilder().getBreadcrumbs(ACCOUNT_ASSET_DETAILS));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(ASSET_DETAIL_CMS_PAGE));
		return getViewForPage(model);
	}

	private PSAssetData fetchAssetEssentialDetails(final String assetCode)
	{
		return psAssetFacade.getAssetDetailsByCode(assetCode);
	}

	private String getAssetAttributesDetails(final PSAssetData assetData)
	{
		return psAssetFacade.getAssetAttributeDetails(assetData.getCode(), assetData.getAssetType().getCode());
	}

	protected ResourceBreadcrumbBuilder getAccountBreadcrumbBuilder()
	{
		return accountBreadcrumbBuilder;
	}
}
