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
package de.hybris.platform.relationshipaddon.forms.validator;

import de.hybris.platform.relationshipaddon.forms.PermissionForm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * PermissionFormValidator used for validating {@link PermissionForm}
 */
@Component("permissionFormValidator")
public class PermissionFormValidator implements Validator
{

	@Override
	public boolean supports(final Class<?> aClass)
	{
		return PermissionForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final PermissionForm form = (PermissionForm) object;

		if (!StringUtils.isNotBlank(form.getPermissionType()))
		{
			errors.rejectValue("permissionType", "error.permission.type.empty");
		}
	}
}
