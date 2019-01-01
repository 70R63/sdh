/**
 *
 */
package de.hybris.sdh.storefront.forms;

/**
 * @author hybris
 *
 */
public class SearchUserForm
{
	private String documentType;
	private String documentNumber;
	private String expeditionDate;

	/**
	 * @return the documentType
	 */
	public String getDocumentType()
	{
		return documentType;
	}

	/**
	 * @param documentType
	 *           the documentType to set
	 */
	public void setDocumentType(final String documentType)
	{
		this.documentType = documentType;
	}

	/**
	 * @return the documentNumber
	 */
	public String getDocumentNumber()
	{
		return documentNumber;
	}

	/**
	 * @param documentNumber
	 *           the documentNumber to set
	 */
	public void setDocumentNumber(final String documentNumber)
	{
		this.documentNumber = documentNumber;
	}

	/**
	 * @return the expeditionDate
	 */
	public String getExpeditionDate()
	{
		return expeditionDate;
	}

	/**
	 * @param expeditionDate
	 *           the expeditionDate to set
	 */
	public void setExpeditionDate(final String expeditionDate)
	{
		this.expeditionDate = expeditionDate;
	}




}
