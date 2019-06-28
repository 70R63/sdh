/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author edson.roa
 *
 */
public class TypFileBancoResponse
{
	private String FTYPE;
	private String FNAME;
	/**
	 * @return the fTYPE
	 */
	public String getFTYPE()
	{
		return FTYPE;
	}

	/**
	 * @param fTYPE
	 *           the fTYPE to set
	 */
	public void setFTYPE(final String FTYPE)
	{
		this.FTYPE = FTYPE;
	}

	/**
	 * @return the fNAME
	 */
	public String getFNAME()
	{
		return FNAME;
	}

	/**
	 * @param fNAME
	 *           the fNAME to set
	 */
	public void setFNAME(final String FNAME)
	{
		this.FNAME = FNAME;
	}


}
