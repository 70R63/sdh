/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DetGasRepResponse
{

	private String tipoDoc;
	private String numDoc;
	private String nombre;
	private String tipoRelacion;
	private String fechDesde;
	private String fechHasta;
	private String fuente;


	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc()
	{
		return tipoDoc;
	}

	/**
	 * @param tipoDoc
	 *           the tipoDoc to set
	 */
	public void setTipoDoc(final String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * @param nombre
	 *           the nombre to set
	 */
	public void setNombre(final String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * @return the tipoRelacion
	 */
	public String getTipoRelacion()
	{
		return tipoRelacion;
	}

	/**
	 * @param tipoRelacion
	 *           the tipoRelacion to set
	 */
	public void setTipoRelacion(final String tipoRelacion)
	{
		this.tipoRelacion = tipoRelacion;
	}

	/**
	 * @return the fechDesde
	 */
	public String getFechDesde()
	{
		return fechDesde;
	}

	/**
	 * @param fechDesde
	 *           the fechDesde to set
	 */
	public void setFechDesde(final String fechDesde)
	{
		this.fechDesde = fechDesde;
	}

	/**
	 * @return the fechHasta
	 */
	public String getFechHasta()
	{
		return fechHasta;
	}

	/**
	 * @param fechHasta
	 *           the fechHasta to set
	 */
	public void setFechHasta(final String fechHasta)
	{
		this.fechHasta = fechHasta;
	}

	/**
	 * @return the fuente
	 */
	public String getFuente()
	{
		return fuente;
	}

	/**
	 * @param fuente
	 *           the fuente to set
	 */
	public void setFuente(final String fuente)
	{
		this.fuente = fuente;
	}


}
