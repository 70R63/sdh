/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class UpdateEmailRitRequest
{
	private String numBP;
	private String email;

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
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}


	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"personal\": {");
		stringBuilder.append("\"SMTP_ADDR\":\"" + this.getEmail() + "\"");
		stringBuilder.append("               }");
		stringBuilder.append("}");
		return stringBuilder.toString();
	}


}
