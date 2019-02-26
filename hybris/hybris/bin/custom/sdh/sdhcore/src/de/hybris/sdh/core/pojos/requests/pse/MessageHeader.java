/**
 *
 */
package de.hybris.sdh.core.pojos.requests.pse;

/**
 * @author edson.roa
 *
 */
public class MessageHeader
{
	private String to;
	private String from;
	private String representingParty;

	/**
	 * @return the to
	 */
	public String getTo()
	{
		return to;
	}

	/**
	 * @param to
	 *           the to to set
	 */
	public void setTo(final String to)
	{
		this.to = to;
	}

	/**
	 * @return the from
	 */
	public String getFrom()
	{
		return from;
	}

	/**
	 * @param from
	 *           the from to set
	 */
	public void setFrom(final String from)
	{
		this.from = from;
	}

	/**
	 * @return the representingParty
	 */
	public String getRepresentingParty()
	{
		return representingParty;
	}

	/**
	 * @param representingParty
	 *           the representingParty to set
	 */
	public void setRepresentingParty(final String representingParty)
	{
		this.representingParty = representingParty;
	}


}
