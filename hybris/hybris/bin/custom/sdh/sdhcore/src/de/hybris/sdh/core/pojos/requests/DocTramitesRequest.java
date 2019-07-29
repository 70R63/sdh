/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class DocTramitesRequest
{
	private String processType;
	private String categoriza;



	/**
	 * @return the processType
	 */
	public String getProcessType()
	{
		return processType;
	}

	/**
	 * @param processType
	 *           the processType to set
	 */
	public void setProcessType(final String processType)
	{
		this.processType = processType;
	}

	/**
	 * @return the categoriza
	 */
	public String getCategoriza()
	{
		return categoriza;
	}

	/**
	 * @param categoriza
	 *           the categoriza to set
	 */
	public void setCategoriza(final String categoriza)
	{
		this.categoriza = categoriza;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"processType\":\"" + this.getProcessType() + "\",");
		stringBuilder.append("\"categoriza\":\"" + this.getCategoriza() + "\"");
		stringBuilder.append("}");


		return stringBuilder.toString();
	}
}
