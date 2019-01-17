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
package de.hybris.sdh.storefront.checkout.steps.validation.impl;

import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdatePasswordForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdatePwdForm;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component("sdhUpdatePasswordFormValidator")
public class SDHUpdatePasswordFormValidator implements Validator
{
	@Override
	public boolean supports(final Class<?> aClass)
	{
		return UpdatePasswordForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final UpdatePwdForm updatePasswordForm = (UpdatePwdForm) object;
        final String newPassword = updatePasswordForm.getPwd();
		final String checkPassword = updatePasswordForm.getCheckPwd();

		validatePassword(errors, newPassword);
		comparePasswords(errors, newPassword, checkPassword);
	}

	protected void validatePassword(final Errors errors, final String pwd)
	{
		if (StringUtils.isEmpty(pwd))
		{
			errors.rejectValue("pwd", "register.pwd.invalid");
			return;
		}
		if (StringUtils.length(pwd) < 8 || StringUtils.length(pwd) > 16)
		{
			errors.rejectValue("pwd", "register.pwd.invalid.size");
		}
		if (!pwd.matches(".*\\d+.*"))
		{
			errors.rejectValue("pwd", "register.pwd.invalid.number");
		}
		if (!pwd.matches("(.*)[a-z](.*)"))
		{
			errors.rejectValue("pwd", "register.pwd.invalid.lowercase");
		}
		if (!pwd.matches("(.*)[A-Z](.*)"))
		{
			errors.rejectValue("pwd", "register.pwd.invalid.uppercase");
		}
	}

	protected void comparePasswords(final Errors errors, final String pwd, final String checkPwd)
	{
		if (StringUtils.isNotEmpty(pwd) && StringUtils.isNotEmpty(checkPwd) && !StringUtils.equals(pwd, checkPwd))
		{
			errors.rejectValue("checkPwd", "validation.checkPwd.equals");
		}
		else
		{
			if (StringUtils.isEmpty(checkPwd))
			{
				errors.rejectValue("checkPwd", "register.checkPwd.invalid");
			}
		}
	}
}
