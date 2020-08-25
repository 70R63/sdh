/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Consultor
 *
 */
public class CertificaRITRequest
{
	private String numBP;
	private String tipoCert;
	private String tipoImp;
	private String numObjeto;


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
	 * @return the tipoCert
	 */
	public String getTipoCert()
	{
		return tipoCert;
	}




	/**
	 * @param tipoCert
	 *           the tipoCert to set
	 */
	public void setTipoCert(final String tipoCert)
	{
		this.tipoCert = tipoCert;
	}




	/**
	 * @return the tipoImp
	 */
	public String getTipoImp()
	{
		return tipoImp;
	}




	/**
	 * @param tipoImp
	 *           the tipoImp to set
	 */
	public void setTipoImp(final String tipoImp)
	{
		this.tipoImp = tipoImp;
	}

	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
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
		stringBuilder.append("\"tipoCert\":\"" + this.getTipoCert() + "\",");
		stringBuilder.append("\"tipoImp\":\"" + this.getTipoImp() + "\",");
		stringBuilder.append("\"numObjeto\":\"" + this.getNumObjeto() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
