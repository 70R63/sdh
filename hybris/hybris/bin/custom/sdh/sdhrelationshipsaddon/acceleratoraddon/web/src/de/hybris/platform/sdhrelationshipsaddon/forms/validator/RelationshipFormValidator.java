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
package de.hybris.platform.sdhrelationshipsaddon.forms.validator;

import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.EmailValidator;
import de.hybris.platform.sdhrelationshipsaddon.forms.RelationshipForm;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * RelationshipFormValidator used for validating {@link RelationshipForm}
 */
@Component("relationshipFormValidator")
public class RelationshipFormValidator extends EmailValidator implements Validator
{

	private static final int MAX_LENGTH_240 = 240;
	private static final int MAX_LENGTH = 255;

	private static final String RELATIONSHIP_EMAIL_MISMATCH = "relationship.email.mismatch";
	private static final String RELATIONSHIP_EMAIL_INVALID = "relationship.email.invalid";
	private static final String RELATIONSHIP_EMAIL_MAXLENGTH = "relationship.email.maxlength";
	private static final String RELATIONSHIP_EMAIL_EMPTY = "relationship.email.empty";
	private static final String RELATIONSHIP_CONFIRMEMAIL_EMPTY = "relationship.confirmemail.empty";
	private static final String RELATIONSHIP_NAME_MAXLENGTH = "relationship.name.maxlength";
	private static final String RELATIONSHIP_LAST_NAME_MAXLENGTH = "relationship.lastName.maxlength";
	private static final String RELATIONSHIP_LAST_NAME_INVALID = "relationship.lastName.invalid";
	private static final String RELATIONSHIP_FIRST_NAME_MAXLENGTH = "relationship.firstName.maxlength";
	private static final String RELATIONSHIP_FIRST_NAME_INVALID = "relationship.firstName.invalid";
	private static final String RELATIONSHIP_TITLE_PLEASESELECT = "relationship.title.pleaseselect";

	private static final String TITLE = "title";
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String CONFIRM_EMAIL_ADDRESS = "confirmEmailAddress";
	private static final String EMAIL_ADDRESS = "emailAddress";

	@Override
	public boolean supports(final Class<?> aClass)
	{
		return RelationshipForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final RelationshipForm form = (RelationshipForm) object;

		validateFirstName(errors, form);
		validateLastName(errors, form);
		validateEmailInfo(errors, form);
		validateConfirmEmailInfo(errors, form);

	}

	private void validateLastName(final Errors errors, final RelationshipForm form)
	{
		if (!StringUtils.isNotBlank(form.getLastName()))
		{
			errors.rejectValue(LAST_NAME, RELATIONSHIP_LAST_NAME_INVALID);
		}
		else if (StringUtils.isNotBlank(form.getLastName()) && form.getLastName().length() > MAX_LENGTH_240)
		{
			errors.rejectValue(LAST_NAME, RELATIONSHIP_LAST_NAME_MAXLENGTH);
		}
		else if (StringUtils.isNotBlank(form.getFirstName()) && StringUtils.isNotBlank(form.getLastName())
				&& form.getLastName().length() + form.getFirstName().length() > MAX_LENGTH)
		{
			errors.reject(FIRST_NAME);
			errors.rejectValue(LAST_NAME, RELATIONSHIP_NAME_MAXLENGTH);
		}
	}

	private void validateFirstName(final Errors errors, final RelationshipForm form)
	{
		if (!StringUtils.isNotBlank(form.getTitle()))
		{
			errors.rejectValue(TITLE, RELATIONSHIP_TITLE_PLEASESELECT);
		}
		if (!StringUtils.isNotBlank(form.getFirstName()))
		{
			errors.rejectValue(FIRST_NAME, RELATIONSHIP_FIRST_NAME_INVALID);
		}
		else if (StringUtils.isNotBlank(form.getFirstName()) && form.getFirstName().length() > 240)
		{
			errors.rejectValue(FIRST_NAME, RELATIONSHIP_FIRST_NAME_MAXLENGTH);
		}
	}

	private void validateEmailInfo(final Errors errors, final RelationshipForm form)
	{
		if (!StringUtils.isNotBlank(form.getEmailAddress()))
		{
			errors.rejectValue(EMAIL_ADDRESS, RELATIONSHIP_EMAIL_EMPTY);
		}
		else if (form.getEmailAddress().length() > MAX_LENGTH)
		{
			errors.rejectValue(EMAIL_ADDRESS, RELATIONSHIP_EMAIL_MAXLENGTH);
		}
		else if (!validateEmailAddress(form.getEmailAddress()))
		{
			errors.rejectValue(EMAIL_ADDRESS, RELATIONSHIP_EMAIL_INVALID);
		}
	}

	private void validateConfirmEmailInfo(final Errors errors, final RelationshipForm form)
	{
		if (!StringUtils.isNotBlank(form.getConfirmEmailAddress()))
		{
			errors.rejectValue(CONFIRM_EMAIL_ADDRESS, RELATIONSHIP_CONFIRMEMAIL_EMPTY);
		}
		else if (!StringUtils.equals(form.getEmailAddress(), form.getConfirmEmailAddress()))
		{
			errors.rejectValue(CONFIRM_EMAIL_ADDRESS, RELATIONSHIP_EMAIL_MISMATCH);
		}
	}
}
