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
package de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.strategy;

import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.publicsectoracceleratoraddon.checkout.steps.CheckoutStep;
import de.hybris.platform.publicsectoracceleratoraddon.controllers.pages.checkout.steps.AbstractCheckoutStepController;
import de.hybris.platform.xyformscommercefacades.form.data.FormDetailData;
import de.hybris.platform.xyformsfacades.data.YFormDefinitionData;

import java.util.List;
import java.util.Map;


public interface DynamicFormCheckoutStrategy
{
	/**
	 * Create dynamic form progress checkout steps based on the cart entries. <br/>
	 * Depends on the content of the cart, dynamically create the form steps and defined the navigation between the
	 * forms.
	 *
	 * @param formCheckoutStepPlaceholder
	 */
	List<CheckoutStep> createDynamicFormSteps(final CheckoutStep formCheckoutStepPlaceholder);


	/**
	 * Combine the Form Checkout Steps to the original Checkout steps for display at the progress bar.
	 *
	 * @param formCheckoutStepPlaceholder
	 * @param originalCheckoutSteps
	 */
	List<AbstractCheckoutStepController.CheckoutSteps> combineFormCheckoutStepProgressBar(CheckoutStep formCheckoutStepPlaceholder,
			List<AbstractCheckoutStepController.CheckoutSteps> originalCheckoutSteps);

	/**
	 * Get all the Form HTMLs to display on the given formPageId
	 *
	 * @param formPageId
	 * @param productCode
	 */
	List<String> getFormsInlineHtmlByFormPageId(final String formPageId, final String productCode);

	/**
	 * Simulation of different cases of dynamic checkout form pages depends on the entries in the cart.<br/>
	 * If one item then display no forms; Else display a number of form pages up to the defined Maximum.
	 *
	 * @param cartData
	 * @return Map<FormPageId, ProgressBarId> where the FormPageId defines the navigation of the FormPages, i.e. UniqueId
	 *         separating different FormPages, FormPageId will also be used for retrieve the forms. Whereas the
	 *         ProgressBarId is used as OOTB for linking the labels to display for each of the Checkout Pages, i.e. Form
	 *         Page and OOTB checkout pages.
	 */
	Map<ProductData, List<YFormDefinitionData>> getFormPageIdList(final CartData cartData);

	/**
	 * Get YFormDefinitions By FormPageId and Product Code. <br/>
	 * FormPageId is the value defined earlier the CartData to represent the different form page from the cart entries.
	 *
	 * @param cartData
	 * @param formPageId
	 * @param productCode
	 * @return
	 */
	List<FormDetailData> getFormDetailDataByProductCodeAndFormPageId(final CartData cartData, final String formPageId,
			final String productCode);

}
