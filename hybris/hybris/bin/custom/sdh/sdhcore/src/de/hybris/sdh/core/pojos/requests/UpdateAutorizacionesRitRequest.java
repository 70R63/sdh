/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class UpdateAutorizacionesRitRequest
{
	private String numBP;
	private Boolean useEmailForNotifications;
	private Boolean useInformationForInstitutionalPurposes;
	private String autoBuzonDate;




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




	/**
	 * @return the autoBuzonDate
	 */
	public String getAutoBuzonDate()
	{
		return autoBuzonDate;
	}




	/**
	 * @param autoBuzonDate
	 *           the autoBuzonDate to set
	 */
	public void setAutoBuzonDate(final String autoBuzonDate)
	{
		this.autoBuzonDate = autoBuzonDate;
	}




	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"personal\": {");
		stringBuilder.append("\"ZZAUTOUSOINF\":\""
				+ String.valueOf((Boolean.TRUE.equals(this.getUseInformationForInstitutionalPurposes()) ? 1 : 2)) + "\",");
		stringBuilder.append("\"ZZFECHAAUTOB\":\"" + this.getAutoBuzonDate() + "\",");
		stringBuilder.append(
				"\"ZZAUTOBUZONE\":\"" + String.valueOf((Boolean.TRUE.equals(this.getUseEmailForNotifications()) ? 1 : 2)) + "\"");
		stringBuilder.append("               }");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}


}
