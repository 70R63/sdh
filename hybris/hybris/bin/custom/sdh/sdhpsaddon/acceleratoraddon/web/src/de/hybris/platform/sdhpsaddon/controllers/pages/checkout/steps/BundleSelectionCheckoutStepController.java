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
package de.hybris.platform.sdhpsaddon.controllers.pages.checkout.steps;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.configurablebundlefacades.data.BundleTemplateData;
import de.hybris.platform.configurablebundleservices.enums.BundleTemplateStatusEnum;
import de.hybris.platform.sdhpsaddon.checkout.steps.CheckoutStep;
import de.hybris.platform.sdhpsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhpsaddon.forms.BundleOptionsForm;
import de.hybris.platform.publicsectorfacades.bundle.selection.BundleSelectionFacade;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller class for Public Sector Bundle Selection.
 */
@Controller
@RequestMapping(value = "/checkout/multi/bundle")
public class BundleSelectionCheckoutStepController extends AbstractCheckoutStepController
{
	private static final Logger LOG = LoggerFactory.getLogger(BundleSelectionCheckoutStepController.class);

	private static final String BUNDLE = "bundle";
	private static final String DRAFT_CONFIRMATION_PAGE = "draftConfirmationPage";
	private static final String BUNDLE_PACKAGE_NOT_AVAILABLE = "bundle.selection.packagenotavailable";

	@Resource(name = "cartFacade")
	private CartFacade cartFacade;

	@Resource(name = "bundleSelectionFacade")
	private BundleSelectionFacade bundleSelectionFacade;

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		model.addAttribute("cartData", cartData);

		final ProductData product = getPsProductFacade().getServiceProductFromSessionCart();
		final String productCode = (product != null) ? getPsProductFacade().getServiceProductFromSessionCart().getCode() : null;
		if (StringUtils.isEmpty(productCode))
		{
			LOG.error("Service product and bundle templates are not available");
			setupErrorPage(model, MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL, BUNDLE_PACKAGE_NOT_AVAILABLE);
			return ControllerConstants.Views.Pages.Error.ErrorNotFoundPage;
		}
		else if (!bundleSelectionFacade.hasBundleAddons(productCode).booleanValue())
		{
			return getCheckoutStep().nextStep();
		}
		else
		{
			final List<String> cartEntries = new ArrayList<>();
			final List<String> disableProducts = new ArrayList<>();
			final List<BundleTemplateData> childBundles = getChildBundle(cartData, productCode, cartEntries, disableProducts);
			model.addAttribute("cartEntryIdList", cartEntries);
			model.addAttribute("disableProducts", disableProducts);

			final String bundleTemplateId = bundleSelectionFacade.getBundleParentTemplateByProduct(productCode);

			if (childBundles.isEmpty())
			{
				LOG.error("Specified bundleTemplate does not have any active bundle " + bundleTemplateId);
				setupErrorPage(model, MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL, BUNDLE_PACKAGE_NOT_AVAILABLE);
				return ControllerConstants.Views.Pages.Error.ErrorNotFoundPage;
			}
			model.addAttribute("childBundleTemplates", childBundles);

			initialSetup(model);
			BundleTemplateData bundleTemplateData = null;

			try
			{
				bundleTemplateData = bundleSelectionFacade.getBundleTemplateByProductCode(productCode);
				if (bundleTemplateData != null)
				{
					model.addAttribute("bundleHeaderMessage", bundleTemplateData.getHeaderMessage());
					model.addAttribute("bundleCheckoutLabel", bundleTemplateData.getCheckoutStepLabel());
				}
			}
			catch (final ModelNotFoundException e)
			{
				LOG.error("Specified bundleTemplate does not exist: " + bundleTemplateId);
				setupErrorPage(model, MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL, BUNDLE_PACKAGE_NOT_AVAILABLE);
				return ControllerConstants.Views.Pages.Error.ErrorNotFoundPage;
			}

			if (bundleTemplateData != null && !bundleSelectionFacade.getBundleTemplateStatusByCode(productCode)
					.equalsIgnoreCase(BundleTemplateStatusEnum.APPROVED.toString()))
			{
				LOG.error("Specified bundleTemplate is not currently APPROVED: " + bundleTemplateId);
				setupErrorPage(model, MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL, BUNDLE_PACKAGE_NOT_AVAILABLE);
				return ControllerConstants.Views.Pages.Error.ErrorNotFoundPage;
			}
			return ControllerConstants.Views.Pages.MultiStepCheckout.BundleSelectionPage;
		}
	}

	/**
	 * return the child bundle for given product code & cart.
	 *
	 * @param cartData
	 * @param productCode
	 * @param cartEntries
	 * @param disableProducts
	 * @return List<BundleTemplateData>
	 */
	private List<BundleTemplateData> getChildBundle(final CartData cartData, final String productCode,
			final List<String> cartEntries, final List<String> disableProducts)
	{
		List<BundleTemplateData> childBundles = new ArrayList<>();
		if (cartData.getEntries().size() == 1)
		{
			childBundles = bundleSelectionFacade.getChildrenTemplates(productCode);
		}
		else if (cartData.getEntries().size() > 1)
		{
			final OrderEntryData entry = cartData.getEntries().get(cartData.getEntries().size() - 1);
			if (entry != null)
			{
				childBundles = bundleSelectionFacade.getChildrenTemplates(entry.getProduct().getCode());
			}
			populateDisabledProducts(cartData, cartEntries, disableProducts);
		}
		return childBundles;
	}

	/**
	 * Populates the disabled bundled products for the given cart
	 *
	 * @param cartData
	 * @param cartEntries
	 * @param disableProducts
	 */
	private void populateDisabledProducts(final CartData cartData, final List<String> cartEntries,
			final List<String> disableProducts)
	{
		for (final OrderEntryData orderEntryData : cartData.getEntries())
		{
			//exclude the service product
			if (orderEntryData.getEntryNumber().intValue() > 0)
			{
				cartEntries.add(orderEntryData.getProduct().getCode());
				for (final ProductData disbaledProduct : bundleSelectionFacade
						.returnDisabledProducts(orderEntryData.getProduct().getCode()))
				{
					disableProducts.add(disbaledProduct.getCode());
				}
			}
		}
	}

	private void setupErrorPage(final Model model, final String label, final String errorMessage) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(label));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(label));
		GlobalMessages.addErrorMessage(model, errorMessage);
	}

	protected void prepareDataForChildBundle(final Model model, final String bundleId, final String entryCode)
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		final List<BundleTemplateData> childBundles = bundleSelectionFacade.getChildrenTemplates(entryCode);

		boolean isCurrentBundleTemplate = false;
		BundleTemplateData nextBundleTemplate = null;
		for (final BundleTemplateData bundleTemplateData : childBundles)
		{
			if (isCurrentBundleTemplate)
			{
				nextBundleTemplate = bundleTemplateData;
				break;
			}
			if (bundleTemplateData.getId().equals(bundleId))
			{
				isCurrentBundleTemplate = true;
			}
		}

		model.addAttribute("nextBundleTemplate", nextBundleTemplate);

		if (nextBundleTemplate != null)
		{
			final List<String> disableProducts = new ArrayList<>();
			final List<String> cartEntryIdList = new ArrayList<>();
			for (final OrderEntryData orderEntryData : cartData.getEntries())
			{
				//exclude the service product
				if (orderEntryData.getEntryNumber().intValue() > 0)
				{
					for (final ProductData disbaledProduct : bundleSelectionFacade
							.returnDisabledProducts(orderEntryData.getProduct().getCode()))
					{
						disableProducts.add(disbaledProduct.getCode());
					}
					cartEntryIdList.add(orderEntryData.getProduct().getCode());
				}
			}
			model.addAttribute("disableProducts", disableProducts);
			model.addAttribute("cartEntryIdList", cartEntryIdList);
		}
	}

	/**
	 * Add bundle addon to cart.
	 *
	 * @param code
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/addEntry", method = RequestMethod.POST)
	public String addToCart(@RequestParam("productCodePost") final String code, @RequestParam("bundleId") final String bundleId,
			final Model model) throws CommerceCartModificationException

	{
		if (bundleSelectionFacade.isEligibleToAddBundleAddon(code))
		{
			try
			{
				bundleSelectionFacade.cartCleanupBeforeAdd(code);
				cartFacade.addToCart(code, 1);
			}
			catch (final CommerceCartModificationException ex)
			{
				LOG.error("Couldn't add product of code " + code + " to cart.", ex);
			}
		}
		prepareDataForChildBundle(model, bundleId, code);

		final BundleOptionsForm bundleOptionsForm = new BundleOptionsForm();
		model.addAttribute("bundleOptionsForm", bundleOptionsForm);

		return ControllerConstants.Views.Fragments.Checkout.ChildBundleSelection;
	}

	@RequestMapping(value = "/applicationSummary", method = RequestMethod.GET)
	public String getApplicationSummary(final Model model) throws CommerceCartModificationException
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		model.addAttribute("cartData", cartData);

		return ControllerConstants.Views.Fragments.Checkout.ApplicationSummary;
	}

	protected void initialSetup(final Model model) throws CMSItemNotFoundException
	{
		this.prepareDataForPage(model);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		model.addAttribute(WebConstants.BREADCRUMBS_KEY,
				getResourceBreadcrumbBuilder().getBreadcrumbs("checkout.multi.bundle.breadcrumb"));
		model.addAttribute("metaRobots", "noindex,nofollow");
		setCheckoutStepLinksForModel(model, getCheckoutStep());
		final BundleOptionsForm bundleOptionsForm = new BundleOptionsForm();
		model.addAttribute("bundleOptionsForm", bundleOptionsForm);
	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String back(final RedirectAttributes redirectAttributes)
	{
		return getCheckoutStep().previousStep();
	}

	@RequestMapping(value = "/next", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String next(final RedirectAttributes redirectAttributes)
	{
		final ProductData productData = getPsProductFacade().getServiceProductFromSessionCart();
		if (productData != null)
		{
			final String productCode = productData.getCode();
			final List<Integer> bundlesWithNoAnswer = bundleSelectionFacade.getChildBundlesNotInCart(productCode);

			if (CollectionUtils.isNotEmpty(bundlesWithNoAnswer))
			{
				redirectAttributes.addAttribute("bundleWithNoAnswer", bundlesWithNoAnswer);
				GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
						"checkout.multi.bundle.validateForm", new Object[]
						{ bundlesWithNoAnswer });

				return REDIRECT_URL_BUNDLE_SELECTION_PAGE;
			}
			return getCheckoutStep().nextStep();

		}
		GlobalMessages.addFlashMessage(redirectAttributes, GlobalMessages.ERROR_MESSAGES_HOLDER,
				"something.went.wrong.error.message", null);
		return REDIRECT_PREFIX + "/";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(final Model model) throws CMSItemNotFoundException
	{
		getPsCartFacade().setDraftCartDetails(getCheckoutStep().currentStep());

		final CustomerData currentCustomer = getUser();
		final CustomerData userInContext = getCheckoutFacade().getCheckoutCart().getUserInContext();
		final Boolean isCurrentCustomerSameAsUserInContext = userInContext == null
				|| currentCustomer.getUid().equals(userInContext.getUid());

		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		model.addAttribute("draftCode", cartData.getCode());
		model.addAttribute("product", getPsYFormsStrategy().getYFormOrderEntry(cartData).getProduct());
		model.addAttribute("userInContext", getCheckoutFacade().getCheckoutCart().getUserInContext());
		model.addAttribute("isCurrentCustomerSameAsUserInContext", isCurrentCustomerSameAsUserInContext);

		storeCmsPageInModel(model, getContentPageForLabelOrId(DRAFT_CONFIRMATION_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(DRAFT_CONFIRMATION_PAGE));
		return getViewForPage(model);
	}

	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(BUNDLE);
	}

}
