/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DetRadicadosResponse
{

	private String numRadicado;
	private String fechaRadicado;
	private String modLicencia;
	private String presupuesto;
	private String estrato;




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
	 * @return the fechaRadicado
	 */
	public String getFechaRadicado()
	{
		return fechaRadicado;
	}




	/**
	 * @param fechaRadicado
	 *           the fechaRadicado to set
	 */
	public void setFechaRadicado(final String fechaRadicado)
	{
		this.fechaRadicado = fechaRadicado;
	}




	/**
	 * @return the modLicencia
	 */
	public String getModLicencia()
	{
		return modLicencia;
	}




	/**
	 * @param modLicencia
	 *           the modLicencia to set
	 */
	public void setModLicencia(final String modLicencia)
	{
		this.modLicencia = modLicencia;
	}




	/**
	 * @return the presupuesto
	 */
	public String getPresupuesto()
	{
		return presupuesto;
	}




	/**
	 * @param presupuesto
	 *           the presupuesto to set
	 */
	public void setPresupuesto(final String presupuesto)
	{
		this.presupuesto = presupuesto;
	}




	/**
	 * @return the estrato
	 */
	public String getEstrato()
	{
		return estrato;
	}




	/**
	 * @param estrato
	 *           the estrato to set
	 */
	public void setEstrato(final String estrato)
	{
		this.estrato = estrato;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetRadicadosResponse [numRadicado=" + numRadicado + ", fechaRadicado=" + fechaRadicado + ", modLicencia="
				+ modLicencia + ", presupuesto=" + presupuesto + "]";
	}






}
