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

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;
import de.hybris.sdh.core.services.SDHCustomerAccountService;
import de.hybris.sdh.storefront.forms.SDHRegisterForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Validates registration forms.
 */
@Component("sdhRegistrationValidator")
public class SDHRegistrationValidator implements Validator
{
	public static final Pattern EMAIL_REGEX = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");

	@Resource(name = "sdhCustomerAccountService")
	private SDHCustomerAccountService sdhCustomerAccountService;

	@Override
	public boolean supports(final Class<?> aClass)
	{
		return RegisterForm.class.equals(aClass);
	}

	@Override
	public void validate(final Object object, final Errors errors)
	{
		final SDHRegisterForm registerForm = (SDHRegisterForm) object;
		//		final String titleCode = registerForm.getTitleCode();
		//		final String firstName = registerForm.getFirstName();
		//		final String lastName = registerForm.getLastName();
		final String email = registerForm.getEmail();

		final String confirmEmail = registerForm.getConfirmEmail();
		final String pwd = registerForm.getPwd();
		final String checkPwd = registerForm.getCheckPwd();
		final String numBP = registerForm.getNumBP();
		//		final boolean termsCheck = registerForm.isTermsCheck();

		//		validateTitleCode(errors, titleCode);
		//		validateName(errors, firstName, "firstName", "register.firstName.invalid");
		//		validateName(errors, lastName, "lastName", "register.lastName.invalid");

		//		if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255)
		//		{
		//			errors.rejectValue("lastName", "register.name.invalid");
		//			errors.rejectValue("firstName", "register.name.invalid");
		//		}

		validateNumBPUnique(errors, numBP);
		validateEmail(errors, email);
		validateConfirmEmail(errors, confirmEmail);
		validatePassword(errors, pwd);
		compareEmails(errors, email, confirmEmail);
		comparePasswords(errors, pwd, checkPwd);
		//		validateTermsAndConditions(errors, termsCheck);
	}

	protected void compareEmails(final Errors errors, final String pwd, final String checkPwd)
	{
		if (StringUtils.isNotEmpty(pwd) && StringUtils.isNotEmpty(checkPwd) && !StringUtils.equals(pwd, checkPwd))
		{
			errors.rejectValue("checkPwd", "validation.confirmEmail.equals");
		}
		else
		{
			if (StringUtils.isEmpty(checkPwd))
			{
				errors.rejectValue("checkPwd", "register.confirmEmail.invalid");
			}
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

	protected void validateEmail(final Errors errors, final String email)
	{
		if (StringUtils.isEmpty(email) || (StringUtils.length(email) > 255 || !validateEmailAddress(email)))
		{
			errors.rejectValue("email", "register.email.invalid");
		}
		//		else if (StringUtils.length(email) > 255 || !validateEmailAddress(email))
		//		{
		//			errors.rejectValue("email", "register.email.invalid");
		//		}
	}

	protected void validateNumBPUnique(final Errors errors, final String numBP)
	{

		if (!StringUtils.isEmpty(numBP) && sdhCustomerAccountService.isUserRegisteredByNumBP(numBP))
		{
			errors.rejectValue("email", "register.numBP.invalid");
		}

	}

	protected void validateConfirmEmail(final Errors errors, final String confirmEmail)
	{
		if (StringUtils.isEmpty(confirmEmail) || (StringUtils.length(confirmEmail) > 255 || !validateEmailAddress(confirmEmail)))
		{
			errors.rejectValue("confirmEmail", "register.confirmEmail.invalid");
		}
		//		else if (StringUtils.length(confirmEmail) > 255 || !validateEmailAddress(confirmEmail))
		//		{
		//			errors.rejectValue("confirmEmail", "register.confirmEmail.invalid");
		//		}
	}

	protected void validateName(final Errors errors, final String name, final String propertyName, final String property)
	{
		if (StringUtils.isBlank(name) || (StringUtils.length(name) > 255))
		{
			errors.rejectValue(propertyName, property);
		}
		//		else if (StringUtils.length(name) > 255)
		//		{
		//			errors.rejectValue(propertyName, property);
		//		}
	}

	protected void validateTitleCode(final Errors errors, final String titleCode)
	{
		if (StringUtils.isEmpty(titleCode) || (StringUtils.length(titleCode) > 255))
		{
			errors.rejectValue("titleCode", "register.title.invalid");
		}
		//		else if (StringUtils.length(titleCode) > 255)
		//		{
		//			errors.rejectValue("titleCode", "register.title.invalid");
		//		}
	}

	public boolean validateEmailAddress(final String email)
	{
		final Matcher matcher = EMAIL_REGEX.matcher(email);
		return matcher.matches();
	}

	protected void validateTermsAndConditions(final Errors errors, final boolean termsCheck)
	{
		if (!termsCheck)
		{
			errors.rejectValue("termsCheck", "register.terms.not.accepted");
		}
	}
}
