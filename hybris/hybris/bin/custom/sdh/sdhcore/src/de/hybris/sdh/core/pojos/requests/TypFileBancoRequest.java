/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author edson.roa
 *
 */
public class TypFileBancoRequest
{
	private String CODBK;


	/**
	 * @return the CODBK
	 */
	public String getCODBK()
	{
		return CODBK;
	}

	/**
	 * @param CODBK
	 *           the CODBK to set
	 */
	public void setCODBK(final String CODBK)
	{
		this.CODBK = CODBK;
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
		stringBuilder.append("\"CODBK\":\"" + this.getCODBK() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}

}
