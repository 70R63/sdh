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
 */
package de.hybris.platform.sdhbillsaddon.controllers.pages;

import de.hybris.platform.acceleratorfacades.flow.CheckoutFlowFacade;
import de.hybris.platform.acceleratorfacades.payment.PaymentFacade;
import de.hybris.platform.acceleratorfacades.payment.data.PaymentSubscriptionResultData;
import de.hybris.platform.acceleratorservices.checkout.pci.CheckoutPciStrategy;
import de.hybris.platform.acceleratorservices.enums.CheckoutPciOptionEnum;
import de.hybris.platform.acceleratorservices.payment.constants.PaymentConstants;
import de.hybris.platform.acceleratorservices.payment.data.PaymentData;
import de.hybris.platform.acceleratorservices.payment.data.PaymentErrorField;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractCheckoutController.SelectOption;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.security.GUIDCookieStrategy;
import de.hybris.platform.acceleratorstorefrontcommons.tags.Functions;
import de.hybris.platform.billfacades.bill.PSBillPaymentFacade;
import de.hybris.platform.billfacades.bill.PSDocumentGenerationFacade;
import de.hybris.platform.billfacades.bill.data.PSBillMessageData;
import de.hybris.platform.billfacades.bill.data.PSBillPaymentData;
import de.hybris.platform.billfacades.bill.data.PSBillReceiptData;
import de.hybris.platform.billfacades.bill.impl.DefaultPSDocumentGenerationFacade;
import de.hybris.platform.billservices.enums.PSBillMessageCondition;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.i18n.I18NFacade;
import de.hybris.platform.commercefacades.order.CheckoutFacade;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commercefacades.order.data.CardTypeData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.commercefacades.user.data.TitleData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.strategies.CheckoutCustomerStrategy;
import de.hybris.platform.sdhbillsaddon.controllers.ControllerConstants;
import de.hybris.platform.sdhbillsaddon.forms.BillPaymentForm;
import de.hybris.platform.sdhbillsaddon.forms.RetrieveBillForm;
import de.hybris.platform.sdhbillsaddon.forms.validation.BillPaymentValidator;
import de.hybris.platform.sdhbillsaddon.forms.validation.RetrieveBillValidator;
import de.hybris.platform.sdhpsaddon.security.PSOpenRedirectValidator;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.tx.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Controller for bills
 */
@Controller
@RequestMapping(value = "/bills")
public class PSBillController extends AbstractPageController
{
	private static final Logger LOG = LoggerFactory.getLogger(PSBillController.class);
	private static final int BILL_AMOUNT_MAX_LENGTH = 254;
	private static final String RETRIEVE_BILL_FORM = "retrieveBillForm";
	private static final String VALID_JSON_PROPERTY = "valid";
	private static final String ERROR_MESSAGE_JSON_PROPERTY = "errorMessage";
	private static final String RETRIEVE_BILL_PAGE = "/bills/retrieve-bill";
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String RETRIEVE_BILL_BREADCRUMB = "breadcrumb.retrieve.bill";
	private static final String BILL_CONFIRMATION_BREADCRUMB = "breadcrumb.bill.confirmation";
	private static final String RETRIEVE_BILLS_CMS_PAGE = "retrieve-bill";
	private static final String MY_BILLS_CONFIRMATION_CMS_PAGE = "bills-confirmation";
	private static final String RETRIEVE_BILL_CONFIRMATION = "/bills/bills-confirmation/";
	private static final String INVALID_BILLID_LASTNAME_ERROR = "form.invalid.billId.lastName";
	private static final String BILL_AMOUNT_INVALID_CHARACTERS_MESSAGE = "bill.amount.invalid.characters";
	private static final String BILL_AMOUNT_INVALID_MESSAGE = "bill.amount.invalid";
	private static final String BILL_PAY_AMOUNT_OVERDUE_ERROR_MESSAGE = "bill.pay.amount.overdue";
	private static final String BILL_AMOUNT_MAX_LENGTH_MESSAGE = "bill.amount.maxlength";
	private static final String BILL_AMOUNT_LESS_THAN_ZERO_MESSAGE = "bill.amount.invalid";
	private static final String SEPARATOR_STR = Character.toString('\u00AC');
	private static final String BILL_PAYMENT_FORM_NAME = "billPaymentForm";
	private static final String EMAIL_FORM_FIELD = "emailAddress";
	private static final String ERROR_VALUE = "error";
	private static final String BEGIN_SUBSCRIPTION_ERROR = "Failed to build beginCreateSubscription request";
	private static final String GENERAL_ERROR_KEY = "bill.paymentMethod.addPaymentDetails.generalError";
	private static final String DEFAULTL_ERROR_MESSAGE = "Please enter a value for this field";
	private static final String HOP_BILL_PAYMENT_FORM = "HOPBillPaymentForm";
	private static final String UNIDENTIFIED_BILL_PAID = "UnidentifiedBillPaid";
	private static final String RETRIEVE_BILL_URL = "/bills/retrieve-bill";
	private static final String LAST_REFERER_SOURCE = "source";
	private static final String ORIGINAL_REFERER = "originalReferer";
	private static final String DEFAULT_COUNTRY = "sdhbillsaddon.address.default.country";
	private static final String BILL_AMOUNT_INVALID_AFTER_DECIMAL = "bill.amount.invalid.after.decimal";
	private static final String MYACCOUNT_URL = "/my-account";

	protected static final Map<String, String> CYBERSOURCE_SOP_CARD_TYPES = new HashMap<>();

	final String[] DISALLOWED_FIELDS = new String[] {};

	@InitBinder
	public void initBinder(final WebDataBinder binder)
	{
		binder.setDisallowedFields(DISALLOWED_FIELDS);
	}

	@Resource(name = "simpleBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder resourceBreadcrumbBuilder;

	@Resource(name = "retrieveBillValidator")
	private RetrieveBillValidator retrieveBillValidator;

	@Resource(name = "billPaymentValidator")
	private BillPaymentValidator billPaymentValidator;

	@Resource(name = "checkoutFacade")
	private CheckoutFacade checkoutFacade;

	@Resource(name = "i18NFacade")
	private I18NFacade i18NFacade;

	@Resource(name = "paymentFacade")
	private PaymentFacade paymentFacade;

	@Resource(name = "checkoutPciStrategy")
	private CheckoutPciStrategy checkoutPciStrategy;

	@Resource(name = "guidCookieStrategy")
	private GUIDCookieStrategy guidCookieStrategy;

	@Resource(name = "psDocumentGenerationFacade")
	PSDocumentGenerationFacade pSDocumentGenerationFacade;

	@Resource(name = "psBillPaymentFacade")
	PSBillPaymentFacade psBillPaymentFacade;

	@Resource(name = "checkoutCustomerStrategy")
	private CheckoutCustomerStrategy checkoutCustomerStrategy;

	@Resource(name = "checkoutFlowFacade")
	private CheckoutFlowFacade checkoutFlowFacade;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@ModelAttribute("defaultCountry")
	public String getDefaultCountry()
	{
		return configurationService.getConfiguration().getString(DEFAULT_COUNTRY);
	}

	/**
	 * Retrieve bill page GET Request
	 *
	 * @param model
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/retrieve-bill", method = RequestMethod.GET)
	public String showRetrieveBill(final Model model) throws CMSItemNotFoundException
	{
		if (model.asMap().get(RETRIEVE_BILL_FORM) == null)
		{
			final RetrieveBillForm retrieveForm = new RetrieveBillForm();
			model.addAttribute(RETRIEVE_BILL_FORM, retrieveForm);
		}
		return setUpCMSPageForRetrieveBill(model);
	}

	/**
	 * redirects to the retrieve bill if user tries to access the overview page directly by hitting the url
	 *
	 * @return String
	 */

	@RequestMapping(value = "/bills-confirmation/{billCode:.*}", method = RequestMethod.GET)
	public String billConfirmation(@PathVariable("billCode")
	final String billCode, @RequestParam("receiptId")
	final String receiptId, final Model model) throws CMSItemNotFoundException
	{
		if (StringUtils.isNotBlank(billCode) && StringUtils.isNotBlank(receiptId))
		{
			final PSBillReceiptData billData = pSDocumentGenerationFacade.generateBillReceipt(billCode, receiptId);
			setupBillConfirmationPage(model);
			model.addAttribute("billData", billData);
			model.addAttribute("unidentifiedUserFlag", Boolean.valueOf(getUserFacade().isAnonymousUser()));
			if (getUserFacade().isAnonymousUser())
			{
				model.addAttribute("paidByEmail",
						psBillPaymentFacade.guestUserEmailForBillPayment(billData.getReceiptInfo().getPaidBy().getUid()));
			}
			else
			{
				model.addAttribute("paidByEmail", getUser().getUid());
			}
			return ControllerConstants.Pages.Bills.BillsPaymentConfirmationPage;
		}
		else
		{
			return FORWARD_PREFIX + "/404";
		}
	}

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public String retrieveBill()
	{
		return REDIRECT_PREFIX + RETRIEVE_BILL_PAGE;
	}

	/**
	 * returns overview page on valid bill else returns retrieve bill form with errors. POST action for retrieve bill
	 *
	 * @param model
	 * @param retrieveForm
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param redirectModel
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/overview", method = RequestMethod.POST)
	public String retrieveBill(final Model model, final RetrieveBillForm retrieveForm, final BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		getRetrieveBillValidator().validate(retrieveForm, bindingResult);

		if (bindingResult.hasErrors())
		{
			return redirectToRetrieveBillPage(retrieveForm, bindingResult, redirectModel);
		}
		final PSBillPaymentData bill;
		try
		{
			bill = getPsBillPaymentFacade().getBill(retrieveForm.getBillId(), retrieveForm.getLastName());
			if (bill != null)
			{
				if (CheckoutPciOptionEnum.SOP.equals(getCheckoutPciStrategy().getSubscriptionPciOption())
						&& !getPsBillPaymentFacade().isCurrentUserRegistered())
				{
					getPsBillPaymentFacade().createGuestUserForBillPayment(bill.getBillId(), bill.getBillId());
					getGuidCookieStrategy().setCookie(request, response);
				}
				model.addAttribute(LAST_REFERER_SOURCE, RETRIEVE_BILL_URL);
				return getPaymentPageForBill(model, bill);
			}
			else
			{
				return redirectToRetrieveBillPage(retrieveForm, bindingResult, redirectModel);
			}
		}
		catch (final DuplicateUidException | CMSItemNotFoundException e)
		{
			LOG.error("Error occured while retrieving bill with id: " + retrieveForm.getBillId(), e);
			return redirectToRetrieveBillPage(retrieveForm, bindingResult, redirectModel);
		}
	}

	/**
	 * mock action for payment
	 *
	 * @param model
	 * @param retrieveForm
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String billPaymentPage(final Model model, final BillPaymentForm retrieveForm, final BindingResult bindingResult,
			final HttpServletRequest request, final HttpServletResponse response) throws CMSItemNotFoundException
	{
		getBillPaymentValidator().validate(retrieveForm, bindingResult);
		if (bindingResult.hasErrors())
		{
			GlobalMessages.addErrorMessage(model, "error.payment.info");
			setupAddPaymentPage(model);
			setUpBillPaymentSOPPage(retrieveForm, model);
			final PSBillPaymentData bill = getPsBillPaymentFacade().getBill(retrieveForm.getBillCode());
			addBillInfoToModel(bill, model);
			return ControllerConstants.Pages.Bills.BillsPaymentSOPPage;
		}
		return ControllerConstants.Pages.Bills.BillsPaymentConfirmationPage;
	}

	/**
	 * returns bill overview page for the given bill code for logged in user if not logged in returns retrieve bill page
	 *
	 * @param billCode
	 * @param request
	 * @param model
	 * @param redirectModel
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	@RequireHardLogIn
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String billPaymentPage(@RequestParam(value = "billCode", required = false)
	final String billCode, final HttpServletRequest request, final Model model, final RedirectAttributes redirectModel)
			throws CMSItemNotFoundException
	{
		PSBillPaymentData bill = null;
		if (StringUtils.isNotBlank(billCode))
		{
			try
			{
				final String refererURL = request.getHeader("referer");
				final String contextPath = request.getContextPath();
				if (PSOpenRedirectValidator.isValidDomain(request))
				{
					final String returnURL = StringUtils.substringAfter(refererURL, contextPath);
					model.addAttribute(LAST_REFERER_SOURCE, returnURL);
				}
				bill = getPsBillPaymentFacade().getBill(billCode);
				if (!getUser().getUid().equalsIgnoreCase(bill.getCustomer().getUid()))
				{
					model.addAttribute("billCustomer", bill.getCustomer());
				}
				return getPaymentPageForBill(model, bill);
			}
			catch (final CMSItemNotFoundException e)
			{
				LOG.error("Error occured while retrieving bill ", e);
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, INVALID_BILLID_LASTNAME_ERROR);
				return REDIRECT_PREFIX + RETRIEVE_BILL_PAGE;
			}
		}
		else
		{
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, INVALID_BILLID_LASTNAME_ERROR);
			return REDIRECT_PREFIX + RETRIEVE_BILL_PAGE;
		}
	}

	/**
	 * To generate bill receipt PDF.
	 *
	 * @param billCode
	 * @param receiptId
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/receipt/pdf", method = RequestMethod.GET)
	public void pdfPrint(@RequestHeader(value = "referer", required = false)
	final String referer, @RequestParam("billCode")
	final String billCode, @RequestParam("receiptId")
	final String receiptId, final HttpServletRequest request, final HttpServletResponse response) throws IOException
	{
		// Update the original referer to fix the OOTB issue with language
		// change .
		if (StringUtils.isNotBlank(referer))
		{
			request.getSession().setAttribute(ORIGINAL_REFERER, referer);
		}
		if (!getUserFacade().isAnonymousUser() || getSessionService().getAttribute(UNIDENTIFIED_BILL_PAID) != null)
		{
			LOG.info("Pdf Print with billId - " + billCode + " : " + receiptId);
			try
			{
				pSDocumentGenerationFacade.generate(DefaultPSDocumentGenerationFacade.PDF_DOCUMENT, billCode, receiptId, response);
			}
			catch (final Exception e)
			{
				LOG.error("Error occurred while generating the PDF.", e);
				final String encodedRedirectUrl = response.encodeRedirectURL(request.getContextPath() + "/404");
				response.sendRedirect(encodedRedirectUrl);
			}
		}
		else
		{
			final String encodedRedirectUrl = response.encodeRedirectURL(request.getContextPath() + "/404");
			response.sendRedirect(encodedRedirectUrl);
		}
	}

	/**
	 * Validates the partial amount and return whether it's valid or not
	 *
	 * @param billCode
	 * @param model
	 * @param partialAmount
	 * @return String
	 */
	@RequestMapping(value = "/validatePartialAmount", method = RequestMethod.GET, produces = "application/json")
	public String checkFormData(@RequestParam("billCode")
	final String billCode, final Model model, @RequestParam("partialAmount")
	final String partialAmount)
	{
		final Double amount = getParsedDoubleForString(partialAmount);
		final String errorMessage = getErrorMessageForInvalidAmount(partialAmount, amount);
		if (errorMessage == null)
		{
			final PSBillPaymentData bill = getPsBillPaymentFacade().getBill(billCode);
			if (bill != null)
			{
				model.addAttribute(VALID_JSON_PROPERTY, getPsBillPaymentFacade().isAmountValidForPayment(amount, bill));
				final PSBillMessageData message = getPsBillPaymentFacade().getMessageForBillAndCondition(bill,
						PSBillMessageCondition.OVER_PAYMENT_NOT_ALLOWED);
				model.addAttribute(ERROR_MESSAGE_JSON_PROPERTY,
						(message == null) ? BILL_PAY_AMOUNT_OVERDUE_ERROR_MESSAGE : message.getLongMessage());
			}
		}
		else
		{
			model.addAttribute(VALID_JSON_PROPERTY, Boolean.FALSE);
			model.addAttribute(ERROR_MESSAGE_JSON_PROPERTY, errorMessage);
		}
		return ControllerConstants.Views.Fragments.validatePartAmount;
	}

	/**
	 * returns the address form when user changes country or selects address from address book
	 *
	 * @param countryIsoCode
	 * @param usePrimaryAddress
	 * @param addressCode
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/billingaddressform", method = RequestMethod.GET)
	public String getCountryAddressForm(@RequestParam("countryIsoCode")
	final String countryIsoCode, @RequestParam(value = "usePrimaryAddress", required = false)
	final boolean usePrimaryAddress, @RequestParam(value = "addressCode", required = false)
	final String addressCode, final Model model)
	{

		final BillPaymentForm billPaymentDetailsForm = new BillPaymentForm();
		model.addAttribute("supportedCountries", getCountries());
		if (StringUtils.isNotBlank(countryIsoCode))
		{
			model.addAttribute("regions", getI18NFacade().getRegionsForCountryIso(countryIsoCode));
			model.addAttribute("country", countryIsoCode);
		}
		model.addAttribute(BILL_PAYMENT_FORM_NAME, billPaymentDetailsForm);
		if (usePrimaryAddress)
		{
			final AddressData deliveryAddress = getUserFacade().getDefaultAddress();
			updateAddressDetailsInForm(billPaymentDetailsForm, deliveryAddress);
		}
		else if (addressCode != null)
		{
			final AddressData savedAddress = getUserFacade().getAddressForCode(addressCode);
			updateAddressDetailsInForm(billPaymentDetailsForm, savedAddress);
		}
		return ControllerConstants.Views.Fragments.BillingAddressForm;
	}

	/**
	 * redirect to retrieve bill page
	 *
	 * @param retrieveForm
	 * @param bindingResult
	 * @param redirectModel
	 * @return String
	 */
	private String redirectToRetrieveBillPage(final RetrieveBillForm retrieveForm, final BindingResult bindingResult,
			final RedirectAttributes redirectModel)
	{
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, INVALID_BILLID_LASTNAME_ERROR);
		redirectModel.addFlashAttribute(RETRIEVE_BILL_FORM, retrieveForm);
		redirectModel.addFlashAttribute("org.springframework.validation.BindingResult.retrieveBillForm", bindingResult);
		return REDIRECT_PREFIX + RETRIEVE_BILL_PAGE;
	}

	/**
	 * returns the payment page based PCI Option
	 *
	 * @param model
	 * @param bill
	 * @return String
	 * @throws CMSItemNotFoundException
	 */
	private String getPaymentPageForBill(final Model model, final PSBillPaymentData bill) throws CMSItemNotFoundException
	{
		if (CheckoutPciOptionEnum.SOP.equals(getCheckoutPciStrategy().getSubscriptionPciOption()))
		{
			final BillPaymentForm billPaymentDetailsForm = new BillPaymentForm();
			billPaymentDetailsForm
					.setAmount(bill.getOutstandingBillAmount() != null ? bill.getOutstandingBillAmount().setScale(2) : null);
			setupAddPaymentPage(model);
			setUpBillPaymentSOPPage(billPaymentDetailsForm, model);
			addBillInfoToModel(bill, model);
			return ControllerConstants.Pages.Bills.BillsPaymentSOPPage;
		}
		else if (CheckoutPciOptionEnum.HOP.equals(getCheckoutPciStrategy().getSubscriptionPciOption()))
		{
			try
			{
				setupAddPaymentPage(model);
				addBillInfoToModel(bill, model);
				final BillPaymentForm billPaymentDetailsForm = new BillPaymentForm();
				billPaymentDetailsForm.setAmount(bill.getOutstandingBillAmount());
				model.addAttribute(BILL_PAYMENT_FORM_NAME, billPaymentDetailsForm);
				return ControllerConstants.Pages.Bills.BillsPaymentHOPPage;
			}
			catch (final CMSItemNotFoundException e)
			{
				LOG.error(BEGIN_SUBSCRIPTION_ERROR, e);
				GlobalMessages.addErrorMessage(model, GENERAL_ERROR_KEY);
			}
		}
		return ControllerConstants.Pages.Bills.AddPaymentMethodPage;
	}

	/**
	 * @param sopPaymentDetailsForm
	 * @param deliveryAddress
	 */
	protected void updateAddressDetailsInForm(final BillPaymentForm sopPaymentDetailsForm, final AddressData deliveryAddress)
	{
		if (deliveryAddress.getRegion() != null && !StringUtils.isEmpty(deliveryAddress.getRegion().getIsocode()))
		{
			sopPaymentDetailsForm.setBillTo_state(deliveryAddress.getRegion().getIsocodeShort());
		}
		sopPaymentDetailsForm.setBillTo_titleCode(deliveryAddress.getTitleCode());
		sopPaymentDetailsForm.setBillTo_firstName(deliveryAddress.getFirstName());
		sopPaymentDetailsForm.setBillTo_lastName(deliveryAddress.getLastName());
		sopPaymentDetailsForm.setBillTo_street1(deliveryAddress.getLine1());
		sopPaymentDetailsForm.setBillTo_street2(deliveryAddress.getLine2());
		sopPaymentDetailsForm.setBillTo_city(deliveryAddress.getTown());
		sopPaymentDetailsForm.setBillTo_postalCode(deliveryAddress.getPostalCode());
		sopPaymentDetailsForm.setBillTo_country(deliveryAddress.getCountry().getIsocode());
		sopPaymentDetailsForm.setBillTo_phoneNumber(deliveryAddress.getPhone());
	}

	/**
	 * @param partialAmount
	 * @return Double
	 */
	private static Double getParsedDoubleForString(final String partialAmount)
	{
		Double amount = null;
		try
		{
			amount = StringUtils.isNotEmpty(partialAmount) ? Double.valueOf(partialAmount) : null;
		}
		catch (final NumberFormatException e)
		{
			LOG.error("error while parsing the partial amount " + partialAmount);
		}
		return amount;
	}

	private static String getErrorMessageForInvalidAmount(final String amount, final Double amountInDouble)
	{
		String errorMessage = null;
		if (StringUtils.isEmpty(amount))
		{
			errorMessage = BILL_AMOUNT_INVALID_MESSAGE;
		}
		else if (amountInDouble == null)
		{
			errorMessage = BILL_AMOUNT_INVALID_CHARACTERS_MESSAGE;
		}
		else if (amountInDouble.compareTo(Double.valueOf(0.0d)) <= 0)
		{
			errorMessage = BILL_AMOUNT_LESS_THAN_ZERO_MESSAGE;
		}
		else if (amount.length() > BILL_AMOUNT_MAX_LENGTH)
		{
			errorMessage = BILL_AMOUNT_MAX_LENGTH_MESSAGE;
		}
		else if (validateBillAmountAfterDecimal(amount))
		{
			errorMessage = BILL_AMOUNT_INVALID_AFTER_DECIMAL;
		}
		return errorMessage;
	}

	private static boolean validateBillAmountAfterDecimal(final String amountInDecimal)
	{
		final String pattern = "\\d+(\\.\\d{2})?";
		final Pattern r = Pattern.compile(pattern);
		return !r.matcher(amountInDecimal).matches();
	}

	@SuppressWarnings("boxing")
	private void addBillInfoToModel(final PSBillPaymentData bill, final Model model)
	{
		model.addAttribute("bill", bill);
		model.addAttribute("isBillPaid", bill.getOutstandingBillAmount().doubleValue() <= 0);
		model.addAttribute("isBillOverDue", getPsBillPaymentFacade().isBillOverDue(bill));
		model.addAttribute("isPartPaymentAllowed", bill.getBillType().getIsPartPaymentAllowed());
		model.addAttribute("isPaymentAllowed", bill.getBillType().getIsPaymentAllowed());
		model.addAttribute("loggedInUserEmailAddress",
				(!getUserFacade().isAnonymousUser()) ? getCustomerFacade().getCurrentCustomerUid() : "");
	}

	protected void setupAddPaymentPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("metaRobots", "noindex,nofollow");
		final ContentPageModel contentPage = getContentPageForLabelOrId("bill-payment");
		storeCmsPageInModel(model, contentPage);
		setUpMetaDataForContentPage(model, contentPage);
	}

	/**
	 * method created to add the transaction id to the bill-confirmation url
	 *
	 * @param receiptId
	 * @param billCode
	 * @return String
	 */

	protected String redirectToBillConfirmationPage(final String receiptId, final String billCode)
	{
		if (getUserFacade().isAnonymousUser())
		{
			getSessionService().setAttribute(UNIDENTIFIED_BILL_PAID, true);
		}
		return REDIRECT_PREFIX + RETRIEVE_BILL_CONFIRMATION + Functions.encodeUrl(billCode) + "?receiptId="
				+ Functions.encodeUrl(receiptId);
	}

	protected void setupBillConfirmationPage(final Model model) throws CMSItemNotFoundException
	{
		model.addAttribute("metaRobots", "noindex,nofollow");
		final ContentPageModel contentPage = getContentPageForLabelOrId(MY_BILLS_CONFIRMATION_CMS_PAGE);
		storeCmsPageInModel(model, contentPage);
		setUpMetaDataForContentPage(model, contentPage);
	}

	protected void setUpBillPaymentSOPPage(final BillPaymentForm billPaymentDetailsForm, final Model model)
	{
		try
		{
			final PaymentData silentOrderPageData = getPaymentFacade().beginSopCreateSubscription("/bills/sop/response",
					"/integration/merchant_callback");
			model.addAttribute("silentOrderPageData", silentOrderPageData);
			billPaymentDetailsForm.setParameters(silentOrderPageData.getParameters());
			model.addAttribute("paymentFormUrl", silentOrderPageData.getPostUrl());
		}
		catch (final IllegalArgumentException e)
		{
			model.addAttribute("paymentFormUrl", "");
			model.addAttribute("silentOrderPageData", null);
			LOG.warn("Failed to set up silent order post page : " + e);
			GlobalMessages.addErrorMessage(model, "bill.payment.sop.globalError");
		}
		model.addAttribute(BILL_PAYMENT_FORM_NAME, billPaymentDetailsForm);
		model.addAttribute("primaryAddress", getUserFacade().getDefaultAddress());
		model.addAttribute("deliveryAddresses", getUserFacade().getAddressBook());
		model.addAttribute("paymentInfos", (!getUserFacade().isAnonymousUser()) ? getUserFacade().getCCPaymentInfos(true) : "");
		model.addAttribute("sopCardTypes", getSopCardTypes());
		if (StringUtils.isNotBlank(billPaymentDetailsForm.getBillTo_country()))
		{
			model.addAttribute("regions", getI18NFacade().getRegionsForCountryIso(billPaymentDetailsForm.getBillTo_country()));
			model.addAttribute("country", billPaymentDetailsForm.getBillTo_country());
		}
	}

	protected Collection<CardTypeData> getSopCardTypes()
	{
		final Collection<CardTypeData> sopCardTypes = new ArrayList<>();
		final List<CardTypeData> supportedCardTypes = getCheckoutFacade().getSupportedCardTypes();
		if (CollectionUtils.isNotEmpty(supportedCardTypes))
		{
			supportedCardTypes.stream().filter(e -> CYBERSOURCE_SOP_CARD_TYPES.containsKey(e.getCode()))
					.forEach(s -> sopCardTypes.add(createCardTypeData(CYBERSOURCE_SOP_CARD_TYPES.get(s.getCode()), s.getName())));
		}
		return sopCardTypes;
	}

	static
	{
		CYBERSOURCE_SOP_CARD_TYPES.put("visa", "001");
		CYBERSOURCE_SOP_CARD_TYPES.put("master", "002");
		CYBERSOURCE_SOP_CARD_TYPES.put("amex", "003");
		CYBERSOURCE_SOP_CARD_TYPES.put("diners", "005");
		CYBERSOURCE_SOP_CARD_TYPES.put("maestro", "024");
	}

	protected CardTypeData createCardTypeData(final String code, final String name)
	{
		final CardTypeData cardTypeData = new CardTypeData();
		cardTypeData.setCode(code);
		cardTypeData.setName(name);
		return cardTypeData;
	}

	/**
	 * set's up the cms page and return the view
	 *
	 * @throws CMSItemNotFoundException
	 */
	protected String setUpCMSPageForRetrieveBill(final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(RETRIEVE_BILLS_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(RETRIEVE_BILLS_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, resourceBreadcrumbBuilder.getBreadcrumbs(RETRIEVE_BILL_BREADCRUMB));
		return getViewForPage(model);
	}

	protected String setUpCMSPageForBillConfirmation(final Model model) throws CMSItemNotFoundException
	{
		storeCmsPageInModel(model, getContentPageForLabelOrId(MY_BILLS_CONFIRMATION_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MY_BILLS_CONFIRMATION_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, resourceBreadcrumbBuilder.getBreadcrumbs(BILL_CONFIRMATION_BREADCRUMB));
		return getViewForPage(model);
	}

	@ModelAttribute("countries")
	public Collection<CountryData> getCountries()
	{
		return getCheckoutFacade().getDeliveryCountries();
	}

	@ModelAttribute("cardTypes")
	public Collection<CardTypeData> getCardTypes()
	{
		return getCheckoutFacade().getSupportedCardTypes();
	}

	@ModelAttribute("months")
	public List<SelectOption> getMonths()
	{
		final List<SelectOption> months = new ArrayList<>();
		Collections.addAll(months, new SelectOption("1", "01"), new SelectOption("2", "02"), new SelectOption("3", "03"),
				new SelectOption("4", "04"), new SelectOption("5", "05"), new SelectOption("6", "06"), new SelectOption("7", "07"),
				new SelectOption("8", "08"), new SelectOption("9", "09"), new SelectOption("10", "10"), new SelectOption("11", "11"),
				new SelectOption("12", "12"));
		return months;
	}

	@ModelAttribute("startYears")
	public List<SelectOption> getStartYears()
	{
		final List<SelectOption> startYears = new ArrayList<>();
		final Calendar calender = new GregorianCalendar();

		for (int i = calender.get(Calendar.YEAR); i > (calender.get(Calendar.YEAR) - 6); i--)
		{
			startYears.add(new SelectOption(String.valueOf(i), String.valueOf(i)));
		}
		return startYears;
	}

	@ModelAttribute("expiryYears")
	public List<SelectOption> getExpiryYears()
	{
		final List<SelectOption> expiryYears = new ArrayList<>();
		final Calendar calender = new GregorianCalendar();

		for (int i = calender.get(Calendar.YEAR); i < calender.get(Calendar.YEAR) + 11; i++)
		{
			expiryYears.add(new SelectOption(String.valueOf(i), String.valueOf(i)));
		}
		return expiryYears;
	}

	@ModelAttribute("titles")
	public Collection<TitleData> getTitles()
	{
		return getUserFacade().getTitles();
	}

	@RequestMapping(value = "/sop/response", method = RequestMethod.POST)
	@RequireHardLogIn
	public String doHandleSopResponse(final HttpServletRequest request, @Valid
	final BillPaymentForm sopPaymentDetailsForm, final BindingResult bindingResult, final Model model)
			throws CMSItemNotFoundException
	{
		validateAndUpdateRedirectUrl(request, model);
		if (!getPsBillPaymentFacade().isCurrentUserRegistered()
				&& !EmailValidator.getInstance().isValid(sopPaymentDetailsForm.getEmailAddress()))
		{
			bindingResult.rejectValue(EMAIL_FORM_FIELD, "bill.error.paymentethod.formentry.sop.missing.emailAddress",
					DEFAULTL_ERROR_MESSAGE);
			sopPaymentDetailsForm.setCard_accountNumber(null);
			sopPaymentDetailsForm.setCard_cvNumber(null);
			return processErrors(sopPaymentDetailsForm, bindingResult, model, new PaymentSubscriptionResultData());
		}

		getPsBillPaymentFacade().updateGuestUserEmail(sopPaymentDetailsForm.getEmailAddress());

		final Transaction tx = Transaction.current();
		tx.begin();

		try
		{
			String paymentId;

			if (StringUtils.isEmpty(sopPaymentDetailsForm.getPaymentId()))
			{
				final Map<String, String> resultMap = getRequestParameterMap(request);
				final boolean savePaymentInfo = sopPaymentDetailsForm.isSavePaymentInfo()
						|| getCheckoutCustomerStrategy().isAnonymousCheckout();
				final PaymentSubscriptionResultData paymentSubscriptionResultData = this.getPaymentFacade()
						.completeSopCreateSubscription(resultMap, savePaymentInfo);

				if (paymentSubscriptionResultData.isSuccess())
				{
					createNewPaymentSubscription(paymentSubscriptionResultData);
				}
				else
				{
					final boolean isPaymentSubscriptionResultAvailable = paymentSubscriptionResultData.getDecision() != null
							&& ERROR_VALUE.equalsIgnoreCase(paymentSubscriptionResultData.getDecision())
							|| paymentSubscriptionResultData.getErrors() != null && !paymentSubscriptionResultData.getErrors().isEmpty();
					tx.rollback();
					LOG.error("Failed to create subscription.  Please check the log files for more information");
					return processErrors(sopPaymentDetailsForm, bindingResult, model,
							isPaymentSubscriptionResultAvailable ? paymentSubscriptionResultData : new PaymentSubscriptionResultData());
				}

				final CCPaymentInfoData paymentInfoData = paymentSubscriptionResultData.getStoredCard();
				paymentId = paymentInfoData.getId();
			}
			else
			{
				paymentId = sopPaymentDetailsForm.getPaymentId();
			}

			final boolean requestSecurityCode = CheckoutPciOptionEnum.DEFAULT
					.equals(getCheckoutFlowFacade().getSubscriptionPciOption());
			final String paymentTransactionCode = getPsBillPaymentFacade().processPayment(sopPaymentDetailsForm.getBillCode(),
					paymentId, BigDecimal.valueOf(sopPaymentDetailsForm.getAmount().doubleValue()),
					sopPaymentDetailsForm.getCurrency(), Boolean.toString(requestSecurityCode));

			tx.commit();
			return redirectToBillConfirmationPage(paymentTransactionCode, sopPaymentDetailsForm.getBillCode());
		}
		catch (final Exception ex)
		{
			tx.rollback();
			LOG.error("Failed to process SOP Bill payment request", ex);
			GlobalMessages.addErrorMessage(model, GENERAL_ERROR_KEY);
			return processErrors(sopPaymentDetailsForm, bindingResult, model, new PaymentSubscriptionResultData());
		}
	}

	protected void createNewPaymentSubscription(final PaymentSubscriptionResultData paymentSubscriptionResultData)
	{
		if (paymentSubscriptionResultData.getStoredCard() != null
				&& StringUtils.isNotBlank(paymentSubscriptionResultData.getStoredCard().getSubscriptionId())
				&& (getUserFacade().getCCPaymentInfos(true).size() <= 1))
		{
			getUserFacade().setDefaultPaymentInfo(paymentSubscriptionResultData.getStoredCard());
		}
	}

	protected Map<String, String> getRequestParameterMap(final HttpServletRequest request)
	{
		final Map<String, String> map = new HashMap<>();
		final Enumeration myEnum = request.getParameterNames();
		while (myEnum.hasMoreElements())
		{
			final String element = (String) myEnum.nextElement();
			map.put(element, request.getParameter(element));
		}
		return map;
	}

	protected String processErrors(@Valid
	final BillPaymentForm billPaymentDetailsForm, final BindingResult bindingResult, final Model model,
			final PaymentSubscriptionResultData paymentSubscriptionResultData) throws CMSItemNotFoundException
	{
		setupAddPaymentPage(model);

		final PSBillPaymentData bill = getPsBillPaymentFacade().getBill(billPaymentDetailsForm.getBillCode());
		addBillInfoToModel(bill, model);
		setUpBillPaymentSOPPage(billPaymentDetailsForm, model);

		processPaymentSubscriptionErrors(bindingResult, model, paymentSubscriptionResultData);
		return ControllerConstants.Pages.Bills.BillsPaymentSOPPage;
	}

	protected void processPaymentSubscriptionErrors(final BindingResult bindingResult, final Model model,
			final PaymentSubscriptionResultData paymentSubscriptionResultData)
	{
		if (paymentSubscriptionResultData.getErrors() != null && !paymentSubscriptionResultData.getErrors().isEmpty())
		{
			GlobalMessages.addErrorMessage(model, "bill.error.paymentethod.formentry.invalid");
			for (final PaymentErrorField paymentErrorField : paymentSubscriptionResultData.getErrors().values())
			{
				if (paymentErrorField.isMissing())
				{
					bindingResult.rejectValue(paymentErrorField.getName(),
							"bill.error.paymentethod.formentry.sop.missing." + paymentErrorField.getName(), DEFAULTL_ERROR_MESSAGE);
				}
				if (paymentErrorField.isInvalid())
				{
					bindingResult.rejectValue(paymentErrorField.getName(),
							"bill.error.paymentethod.formentry.sop.invalid." + paymentErrorField.getName(),
							"This value is invalid for this field");
				}
			}
		}
		else if (paymentSubscriptionResultData.getDecision() != null
				&& ERROR_VALUE.equalsIgnoreCase(paymentSubscriptionResultData.getDecision()))
		{
			LOG.error("Failed to create subscription. Error occurred while contacting external payment services.");
			GlobalMessages.addErrorMessage(model, GENERAL_ERROR_KEY);
		}
	}

	@RequestMapping(value = "/hop/response", method = RequestMethod.POST)
	@RequireHardLogIn
	public String doHandleHopResponse(final HttpServletRequest request, @Valid
	final BillPaymentForm hopPaymentDetailsForm, final BindingResult bindingResult, final Model model)
			throws CMSItemNotFoundException
	{
		final Transaction tx = Transaction.current();
		tx.begin();
		validateAndUpdateRedirectUrl(request, model);
		try
		{
			final BillPaymentForm sessionBillPaymentForm = (BillPaymentForm) getSessionService().getAttribute(HOP_BILL_PAYMENT_FORM);
			getSessionService().removeAttribute(HOP_BILL_PAYMENT_FORM);

			if (sessionBillPaymentForm != null)
			{
				hopPaymentDetailsForm.setAmount(sessionBillPaymentForm.getAmount());
				hopPaymentDetailsForm.setBillCode(sessionBillPaymentForm.getBillCode());
				hopPaymentDetailsForm.setEmailAddress(sessionBillPaymentForm.getEmailAddress());
			}
			final Map<String, String> resultMap = getRequestParameterMap(request);

			final PaymentSubscriptionResultData paymentSubscriptionResultData = getPaymentFacade()
					.completeHopCreateSubscription(resultMap, true);

			if (paymentSubscriptionResultData.isSuccess())
			{
				createNewPaymentSubscription(paymentSubscriptionResultData);
			}
			else if (paymentSubscriptionResultData.getDecision() != null
					&& ERROR_VALUE.equalsIgnoreCase(paymentSubscriptionResultData.getDecision())
					|| paymentSubscriptionResultData.getErrors() != null && !paymentSubscriptionResultData.getErrors().isEmpty())
			{
				return processErrorsHop(hopPaymentDetailsForm, bindingResult, model, paymentSubscriptionResultData);
			}
			else
			{
				tx.rollback();
				LOG.error("Failed to create subscription.  Please check the log files for more information");
				return processErrors(hopPaymentDetailsForm, bindingResult, model, new PaymentSubscriptionResultData());
			}

			final boolean requestSecurityCode = CheckoutPciOptionEnum.DEFAULT
					.equals(getCheckoutFlowFacade().getSubscriptionPciOption());
			final CCPaymentInfoData paymentInfoData = paymentSubscriptionResultData.getStoredCard();

			final String paymentTransactionCode = getPsBillPaymentFacade().processPayment(hopPaymentDetailsForm.getBillCode(),
					paymentInfoData.getId(), new BigDecimal(hopPaymentDetailsForm.getAmount().doubleValue()),
					hopPaymentDetailsForm.getCurrency(), Boolean.toString(requestSecurityCode));
			tx.commit();
			return redirectToBillConfirmationPage(paymentTransactionCode, hopPaymentDetailsForm.getBillCode());
		}
		catch (final Exception ex)
		{
			tx.rollback();
			LOG.error("Failed to process HOP Bill payment request", ex);
			GlobalMessages.addErrorMessage(model, GENERAL_ERROR_KEY);
			return processErrorsHop(hopPaymentDetailsForm, bindingResult, model, new PaymentSubscriptionResultData());
		}
	}

	protected String processErrorsHop(@Valid
	final BillPaymentForm billPaymentDetailsForm, final BindingResult bindingResult, final Model model,
			final PaymentSubscriptionResultData paymentSubscriptionResultData) throws CMSItemNotFoundException
	{
		try
		{
			setupAddPaymentPage(model);
			final PSBillPaymentData bill = getPsBillPaymentFacade().getBill(billPaymentDetailsForm.getBillCode());
			addBillInfoToModel(bill, model);
			beginHOPSubscription(model);
			model.addAttribute(BILL_PAYMENT_FORM_NAME, billPaymentDetailsForm);
		}
		catch (final CMSItemNotFoundException e)
		{
			LOG.error(BEGIN_SUBSCRIPTION_ERROR, e);
			GlobalMessages.addErrorMessage(model, GENERAL_ERROR_KEY);
			return ControllerConstants.Pages.Bills.BillsPaymentHOPPage;
		}

		processPaymentSubscriptionErrors(bindingResult, model, paymentSubscriptionResultData);
		return ControllerConstants.Pages.Bills.BillsPaymentHOPPage;
	}

	@RequestMapping(value = "/hop-mock", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public String getHopPaymentForm(final BillPaymentForm hopPaymentDetailsForm, final HttpServletRequest request,
			final HttpServletResponse response, final Model model, final BindingResult bindingResult)
			throws DuplicateUidException, CMSItemNotFoundException
	{
		validateAndUpdateRedirectUrl(request, model);
		if (!getPsBillPaymentFacade().isCurrentUserRegistered())
		{
			if (!EmailValidator.getInstance().isValid(request.getParameter(EMAIL_FORM_FIELD)))
			{
				bindingResult.rejectValue(EMAIL_FORM_FIELD, "bill.error.paymentethod.formentry.sop.missing.emailAddress",
						DEFAULTL_ERROR_MESSAGE);
				return processErrorsHop(hopPaymentDetailsForm, bindingResult, model, new PaymentSubscriptionResultData());
			}
			else
			{
				getPsBillPaymentFacade().updateGuestUserEmail(request.getParameter(EMAIL_FORM_FIELD));
			}
		}
		else
		{
			getPsBillPaymentFacade().createGuestUserForBillPayment(request.getParameter(EMAIL_FORM_FIELD),
					request.getParameter("billCode"));
			getGuidCookieStrategy().setCookie(request, response);
		}
		beginHOPSubscription(model);
		setupAddPaymentPage(model);
		getSessionService().setAttribute(HOP_BILL_PAYMENT_FORM, hopPaymentDetailsForm);
		return ControllerConstants.Pages.Bills.HostedOrderPostPage;
	}

	protected void beginHOPSubscription(final Model model)
	{
		final PaymentData hostedOrderPageData = getPaymentFacade().beginHopCreateSubscription("/bills/hop/response",
				"/integration/merchant_callback");
		final boolean hopDebugMode = getSiteConfigService().getBoolean(PaymentConstants.PaymentProperties.HOP_DEBUG_MODE, false);
		model.addAttribute("hostedOrderPageData", hostedOrderPageData);
		model.addAttribute("hopDebugMode", Boolean.valueOf(hopDebugMode));
	}

	protected String serializeRequestParameters(final HttpServletRequest request)
	{
		final StringBuilder result = new StringBuilder();
		final Enumeration myEnum = request.getParameterNames();
		while (myEnum.hasMoreElements())
		{
			final String paramName = (String) myEnum.nextElement();
			result.append(paramName).append(SEPARATOR_STR).append(request.getParameter(paramName));
			if (myEnum.hasMoreElements())
			{
				result.append(SEPARATOR_STR);
			}
		}
		return result.toString();
	}

	private void validateAndUpdateRedirectUrl(final HttpServletRequest request, final Model model)
	{
		final String lastRefererSource = request.getParameter(LAST_REFERER_SOURCE);
		if (StringUtils.isNotBlank(lastRefererSource))
		{
			if (lastRefererSource.equals(MYACCOUNT_URL))
			{
				model.addAttribute(LAST_REFERER_SOURCE, lastRefererSource);
			}
			else
			{
				model.addAttribute(LAST_REFERER_SOURCE, "/");
			}
		}
	}


	protected RetrieveBillValidator getRetrieveBillValidator()
	{
		return retrieveBillValidator;
	}

	protected BillPaymentValidator getBillPaymentValidator()
	{
		return billPaymentValidator;
	}

	protected PSBillPaymentFacade getPsBillPaymentFacade()
	{
		return psBillPaymentFacade;
	}

	protected CheckoutFacade getCheckoutFacade()
	{
		return checkoutFacade;
	}

	protected I18NFacade getI18NFacade()
	{
		return i18NFacade;
	}

	protected PaymentFacade getPaymentFacade()
	{
		return paymentFacade;
	}

	protected CheckoutPciStrategy getCheckoutPciStrategy()
	{
		return checkoutPciStrategy;
	}

	public GUIDCookieStrategy getGuidCookieStrategy()
	{
		return guidCookieStrategy;
	}

	public CheckoutCustomerStrategy getCheckoutCustomerStrategy()
	{
		return checkoutCustomerStrategy;
	}

	public CheckoutFlowFacade getCheckoutFlowFacade()
	{
		return checkoutFlowFacade;
	}
}
