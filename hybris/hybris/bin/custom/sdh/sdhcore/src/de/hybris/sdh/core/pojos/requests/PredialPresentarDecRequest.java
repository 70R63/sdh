/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Federico Flores Dimas
 *
 */
public class PredialPresentarDecRequest
{

	private String bp;
	private String chip;
	private String anioGravable;

	/**
	 * @return the bp
	 */
	public String getBp()
	{
		return bp;
	}

	/**
	 * @param bp
	 *           the bp to set
	 */
	public void setBp(final String bp)
	{
		this.bp = bp;
	}

	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}

	/**
	 * @param chip
	 *           the chip to set
	 */
	public void setChip(final String chip)
	{
		this.chip = chip;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
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
		stringBuilder.append("\"BP\":\"" + ((StringUtils.isBlank(this.getBp())) ? "" : this.getBp()) + "\",");
		stringBuilder.append("\"CHIP\":\"" + ((StringUtils.isBlank(this.getChip())) ? "" : this.getChip()) + "\",");
		stringBuilder.append("\"ANIO\":\"" + ((StringUtils.isBlank(this.getAnioGravable())) ? "" : this.getAnioGravable()) + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
