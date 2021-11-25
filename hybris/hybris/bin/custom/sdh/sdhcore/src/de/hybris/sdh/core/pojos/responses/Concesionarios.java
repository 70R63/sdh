/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Federico Flores Dimas
 *
 */
public class Concesionarios
{

	private String xblnr;
	private String partner;
	private String psobtxt;
	private String persl;
	private String betrw;
	private String faedn;

	/**
	 * @return the xblnr
	 */
	public String getXblnr()
	{
		return xblnr;
	}

	/**
	 * @param xblnr
	 *           the xblnr to set
	 */
	@JsonSetter("XBLNR")
	public void setXblnr(final String xblnr)
	{
		this.xblnr = xblnr;
	}

	/**
	 * @return the partner
	 */
	public String getPartner()
	{
		return partner;
	}

	/**
	 * @param partner
	 *           the partner to set
	 */
	@JsonSetter("PARTNER")
	public void setPartner(final String partner)
	{
		this.partner = partner;
	}

	/**
	 * @return the psobtxt
	 */
	public String getPsobtxt()
	{
		return psobtxt;
	}

	/**
	 * @param psobtxt
	 *           the psobtxt to set
	 */
	@JsonSetter("PSOBTXT")
	public void setPsobtxt(final String psobtxt)
	{
		this.psobtxt = psobtxt;
	}

	/**
	 * @return the persl
	 */
	public String getPersl()
	{
		return persl;
	}

	/**
	 * @param persl
	 *           the persl to set
	 */
	@JsonSetter("PERSL")
	public void setPersl(final String persl)
	{
		this.persl = persl;
	}

	/**
	 * @return the betrw
	 */
	public String getBetrw()
	{
		return betrw;
	}

	/**
	 * @param betrw
	 *           the betrw to set
	 */
	@JsonSetter("BETRW")
	public void setBetrw(final String betrw)
	{
		this.betrw = betrw;
	}

	/**
	 * @return the faedn
	 */
	public String getFaedn()
	{
		return faedn;
	}

	/**
	 * @param faedn
	 *           the faedn to set
	 */
	@JsonSetter("FAEDN")
	public void setFaedn(final String faedn)
	{
		this.faedn = faedn;
	}

	@Override
	public String toString()
	{
		return "Concesionarios [xblnr=" + xblnr + ", partner=" + partner + ", psobtxt=" + psobtxt + ", persl=" + persl + ", betrw="
				+ betrw + ", faedn=" + faedn + "]";
	}

}
