/**
 * 
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import java.util.List;

/**
 * @author Federico Flores Dimas
 *
 */
public class RepresentanteSGasolina
{

	private List<ItemSelectOption> tipoId;
	private String numeroId;
	private String nombre;
	private List<ItemSelectOption> tipoRelacion;
	private String fechaDesde;
	private String fechaHasta;
	private List<ItemSelectOption> fuenteDato;
	/**
	 * @return the tipoId
	 */
	public List<ItemSelectOption> getTipoId()
	{
		return tipoId;
	}
	/**
	 * @param tipoId the tipoId to set
	 */
	public void setTipoId(List<ItemSelectOption> tipoId)
	{
		this.tipoId = tipoId;
	}
	/**
	 * @return the numeroId
	 */
	public String getNumeroId()
	{
		return numeroId;
	}
	/**
	 * @param numeroId the numeroId to set
	 */
	public void setNumeroId(String numeroId)
	{
		this.numeroId = numeroId;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre()
	{
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	/**
	 * @return the tipoRelacion
	 */
	public List<ItemSelectOption> getTipoRelacion()
	{
		return tipoRelacion;
	}
	/**
	 * @param tipoRelacion the tipoRelacion to set
	 */
	public void setTipoRelacion(List<ItemSelectOption> tipoRelacion)
	{
		this.tipoRelacion = tipoRelacion;
	}
	/**
	 * @return the fechaDesde
	 */
	public String getFechaDesde()
	{
		return fechaDesde;
	}
	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(String fechaDesde)
	{
		this.fechaDesde = fechaDesde;
	}
	/**
	 * @return the fechaHasta
	 */
	public String getFechaHasta()
	{
		return fechaHasta;
	}
	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public void setFechaHasta(String fechaHasta)
	{
		this.fechaHasta = fechaHasta;
	}
	/**
	 * @return the fuenteDato
	 */
	public List<ItemSelectOption> getFuenteDato()
	{
		return fuenteDato;
	}
	/**
	 * @param fuenteDato the fuenteDato to set
	 */
	public void setFuenteDato(List<ItemSelectOption> fuenteDato)
	{
		this.fuenteDato = fuenteDato;
	}

	
	
}
