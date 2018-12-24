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
package de.hybris.platform.publicsectoracceleratoraddon.forms.validation;

import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.EmailValidator;
import de.hybris.platform.publicsectoracceleratoraddon.forms.RetrieveDraftForm;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Validator for retrieve draft forms.
 */
@Component("retrieveDraftValidator")
public class RetrieveDraftValidator implements Validator
{

	private static final String FORM_INVALID_DRAFT_EMAIL = "form.invalid.draft.email";

	@Override
	public boolean supports(final Class<?> aClass)
	{
		return RetrieveDraftForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final RetrieveDraftForm retrieveForm = (RetrieveDraftForm) object;
		final String draftNumber = retrieveForm.getDraftNumber();
		final String email = retrieveForm.getEmail();

		if (StringUtils.isEmpty(draftNumber) || !StringUtils.isNumeric(draftNumber))
		{
			errors.reject(FORM_INVALID_DRAFT_EMAIL);
		}

		if (StringUtils.isEmpty(email))
		{
			errors.reject(FORM_INVALID_DRAFT_EMAIL);
		}
		else if (StringUtils.length(email) > 255 || !EmailValidator.EMAIL_REGEX.matcher(email).matches())
		{
			errors.reject(FORM_INVALID_DRAFT_EMAIL);
		}
	}

}
