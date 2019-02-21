/**
 *
 */
package de.hybris.sdh.storefront.forms;

/**
 * @author hybris
 *
 */
public class UpdateEmailRitForm
{
	private String email;
	private String newEmailAddress;
	private String confirmNewEmailAddress;


	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *           the email to set
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * @return the newEmailAddress
	 */
	public String getNewEmailAddress()
	{
		return newEmailAddress;
	}

	/**
	 * @param newEmailAddress
	 *           the newEmailAddress to set
	 */
	public void setNewEmailAddress(final String newEmailAddress)
	{
		this.newEmailAddress = newEmailAddress;
	}

	/**
	 * @return the confirmNewEmailAddress
	 */
	public String getConfirmNewEmailAddress()
	{
		return confirmNewEmailAddress;
	}

	/**
	 * @param confirmNewEmailAddress
	 *           the confirmNewEmailAddress to set
	 */
	public void setConfirmNewEmailAddress(final String confirmNewEmailAddress)
	{
		this.confirmNewEmailAddress = confirmNewEmailAddress;
	}




}
