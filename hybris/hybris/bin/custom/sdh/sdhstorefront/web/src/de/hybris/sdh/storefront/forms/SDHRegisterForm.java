/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;

/**
 * @author hybris
 *
 */
public class SDHRegisterForm extends RegisterForm
{
	private String confirmEmail;
	private Boolean useEmailForNotifications;
	private Boolean useInformationForInstitutionalPurposes;

	/**
	 * @return the confirmEmail
	 */
	public String getConfirmEmail()
	{
		return confirmEmail;
	}

	/**
	 * @param confirmEmail
	 *           the confirmEmail to set
	 */
	public void setConfirmEmail(final String confirmEmail)
	{
		this.confirmEmail = confirmEmail;
	}

	/**
	 * @return the useEmailForNotifications
	 */
	public Boolean getUseEmailForNotifications()
	{
		return useEmailForNotifications;
	}

	/**
	 * @param useEmailForNotifications
	 *           the useEmailForNotifications to set
	 */
	public void setUseEmailForNotifications(final Boolean useEmailForNotifications)
	{
		this.useEmailForNotifications = useEmailForNotifications;
	}

	/**
	 * @return the useInformationForInstitutionalPurposes
	 */
	public Boolean getUseInformationForInstitutionalPurposes()
	{
		return useInformationForInstitutionalPurposes;
	}

	/**
	 * @param useInformationForInstitutionalPurposes
	 *           the useInformationForInstitutionalPurposes to set
	 */
	public void setUseInformationForInstitutionalPurposes(final Boolean useInformationForInstitutionalPurposes)
	{
		this.useInformationForInstitutionalPurposes = useInformationForInstitutionalPurposes;
	}




}
