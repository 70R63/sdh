package de.hybris.sdh.core.pojos.responses;

public class ObligacionesICA {
	private String anoGravable;
	private String periodo;
	private String estadoObligacion;

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
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}

	/**
	 * @return the estadoObligacion
	 */
	public String getEstadoObligacion()
	{
		return estadoObligacion;
	}

	/**
	 * @param estadoObligacion
	 *           the estadoObligacion to set
	 */
	public void setEstadoObligacion(final String estadoObligacion)
	{
		this.estadoObligacion = estadoObligacion;
	}

}
