/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class DetalleVehiculos
{
	private String idServicio;
	private String idEstado;
	private String watts;
	private String clasicoAntig;
	private String tipoVeh;
	private String capacidadPas;
	private String capacidadTon;
	private String fechaCambio;
	private String fechaInacti;

	/**
	 * @return the idServicio
	 */
	public String getIdServicio()
	{
		return idServicio;
	}
	
	/**
	 * @param idServicio
	 *           the idServicio to set
	 */
	public void setIdServicio(final String idServicio)
	{
		this.idServicio = idServicio;
	}
	
	/**
	 * @return the idEstado
	 */
	public String getIdEstado()
	{
		return idEstado;
	}
	
	/**
	 * @param idEstado
	 *           the idEstado to set
	 */
	public void setIdEstado(final String idEstado)
	{
		this.idEstado = idEstado;
	}
	
	/**
	 * @return the watts
	 */
	public String getWatts()
	{
		return watts;
	}
	
	/**
	 * @param watts
	 *           the watts to set
	 */
	public void setWatts(final String watts)
	{
		this.watts = watts;
	}
	
	/**
	 * @return the clasicoAntig
	 */
	public String getClasicoAntig()
	{
		return clasicoAntig;
	}
	
	/**
	 * @param clasicoAntig
	 *           the clasicoAntig to set
	 */
	public void setClasicoAntig(final String clasicoAntig)
	{
		this.clasicoAntig = clasicoAntig;
	}
	
	/**
	 * @return the tipoVeh
	 */
	public String getTipoVeh()
	{
		return tipoVeh;
	}
	
	/**
	 * @param tipoVeh
	 *           the tipoVeh to set
	 */
	public void setTipoVeh(final String tipoVeh)
	{
		this.tipoVeh = tipoVeh;
	}
	
	/**
	 * @return the capacidadPas
	 */
	public String getCapacidadPas()
	{
		return capacidadPas;
	}
	
	/**
	 * @param capacidadPas
	 *           the capacidadPas to set
	 */
	public void setCapacidadPas(final String capacidadPas)
	{
		this.capacidadPas = capacidadPas;
	}
	
	/**
	 * @return the capacidadTon
	 */
	public String getCapacidadTon()
	{
		return capacidadTon;
	}
	
	/**
	 * @param capacidadTon
	 *           the capacidadTon to set
	 */
	public void setCapacidadTon(final String capacidadTon)
	{
		this.capacidadTon = capacidadTon;
	}
	
	/**
	 * @return the fechaCambio
	 */
	public String getFechaCambio()
	{
		return fechaCambio;
	}
	
	/**
	 * @param fechaCambio
	 *           the fechaCambio to set
	 */
	public void setFechaCambio(final String fechaCambio)
	{
		this.fechaCambio = fechaCambio;
	}

	public String getFechaInacti() {
		return fechaInacti;
	}

	public void setFechaInacti(String fechaInacti) {
		this.fechaInacti = fechaInacti;
	}
}
