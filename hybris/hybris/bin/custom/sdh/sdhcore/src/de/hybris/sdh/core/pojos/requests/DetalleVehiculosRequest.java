/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class DetalleVehiculosRequest
{
	private String bpNum;
	private String placa;
	private String anioGravable;


	/**
	 * @return the bpNum
	 */
	public String getBpNum()
	{
		return bpNum;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca()
	{
		return placa;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @param bpNum
	 *           the bpNum to set
	 */
	public void setBpNum(final String bpNum)
	{
		this.bpNum = bpNum;
	}

	/**
	 * @param placa
	 *           the placa to set
	 */
	public void setPlaca(final String placa)
	{
		this.placa = placa;
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
		stringBuilder.append("\"bpNum\":\"" + this.getBpNum() + "\",");
		stringBuilder.append("\"placa\":\"" + this.getPlaca() + "\",");
		stringBuilder.append("\"anioGravable\":\"" + this.getAnioGravable() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}
