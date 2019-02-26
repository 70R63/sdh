/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class DetallePublicidadRequest
{
	private String numBP;
	private String numResolu;
	private String anoGravable;
	private String tipoValla;

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
	 * @return the numResolu
	 */
	public String getNumResolu()
	{
		return numResolu;
	}


	/**
	 * @param numResolu
	 *           the numResolu to set
	 */
	public void setNumResolu(final String numResolu)
	{
		this.numResolu = numResolu;
	}


	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}


	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
	}




	/**
	 * @return the tipoValla
	 */
	public String getTipoValla()
	{
		return tipoValla;
	}


	/**
	 * @param tipoValla
	 *           the tipoValla to set
	 */
	public void setTipoValla(final String tipoValla)
	{
		this.tipoValla = tipoValla;
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
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"numResolu\":\"" + this.getNumResolu() + "\",");
		stringBuilder.append("\"anoGravable\":\"" + this.getAnoGravable() + "\",");
		stringBuilder.append("\"tipoValla\":\"" + this.getTipoValla() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}
