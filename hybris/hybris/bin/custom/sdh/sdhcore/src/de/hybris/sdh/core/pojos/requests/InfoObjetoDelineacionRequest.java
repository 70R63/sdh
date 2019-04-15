/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class InfoObjetoDelineacionRequest
{
	private String numBP;
	private String cdu;
	private String numRadicado;
	private String anoGravable;
	private String retencion;
	private String tipoLicencia;
	private String opcionUso;



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
	 * @return the cdu
	 */
	public String getCdu()
	{
		return cdu;
	}



	/**
	 * @param cdu
	 *           the cdu to set
	 */
	public void setCdu(final String cdu)
	{
		this.cdu = cdu;
	}



	/**
	 * @return the numRadicado
	 */
	public String getNumRadicado()
	{
		return numRadicado;
	}



	/**
	 * @param numRadicado
	 *           the numRadicado to set
	 */
	public void setNumRadicado(final String numRadicado)
	{
		this.numRadicado = numRadicado;
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
	 * @return the retencion
	 */
	public String getRetencion()
	{
		return retencion;
	}



	/**
	 * @param retencion
	 *           the retencion to set
	 */
	public void setRetencion(final String retencion)
	{
		this.retencion = retencion;
	}



	/**
	 * @return the tipoLicencia
	 */
	public String getTipoLicencia()
	{
		return tipoLicencia;
	}



	/**
	 * @param tipoLicencia
	 *           the tipoLicencia to set
	 */
	public void setTipoLicencia(final String tipoLicencia)
	{
		this.tipoLicencia = tipoLicencia;
	}



	/**
	 * @return the opcionUso
	 */
	public String getOpcionUso()
	{
		return opcionUso;
	}



	/**
	 * @param opcionUso
	 *           the opcionUso to set
	 */
	public void setOpcionUso(final String opcionUso)
	{
		this.opcionUso = opcionUso;
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
		stringBuilder.append("\"cdu\":\"" + this.getCdu() + "\",");
		stringBuilder.append("\"numRadicado\":\"" + this.getNumRadicado() + "\",");
		stringBuilder.append("\"anoGravable\":\"" + this.getAnoGravable() + "\",");
		stringBuilder.append("\"retencion\":\"" + this.getRetencion() + "\",");
		stringBuilder.append("\"tipoLicencia\":\"" + this.getTipoLicencia() + "\",");
		stringBuilder.append("\"opcionUso\":\"" + this.getOpcionUso() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
