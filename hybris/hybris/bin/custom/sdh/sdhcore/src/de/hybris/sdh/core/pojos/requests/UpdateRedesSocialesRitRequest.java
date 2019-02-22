/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.ContribRedSocial;

import java.util.List;


/**
 * @author hybris
 *
 */
public class UpdateRedesSocialesRitRequest
{
	private String numBP;

	private List<ContribRedSocial> redsocial;



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
	 * @return the redsocial
	 */
	public List<ContribRedSocial> getRedsocial()
	{
		return redsocial;
	}

	/**
	 * @param redsocial
	 *           the redsocial to set
	 */
	public void setRedsocial(final List<ContribRedSocial> redsocial)
	{
		this.redsocial = redsocial;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");

		stringBuilder.append("\"redsocial\": [");

		for (final ContribRedSocial eachRS : this.getRedsocial())
		{
			stringBuilder.append("{\"RED_SOCIAL\":\"" + eachRS.getRED_SOCIAL() + "\",");
			stringBuilder.append("\"USUARIORED\":\"" + eachRS.getUSUARIORED() + "\"},");
		}

		if (",".equals(stringBuilder.substring(stringBuilder.length() - 1)))
		{
			stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
		}

		stringBuilder.append("               ]");




		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}


}
