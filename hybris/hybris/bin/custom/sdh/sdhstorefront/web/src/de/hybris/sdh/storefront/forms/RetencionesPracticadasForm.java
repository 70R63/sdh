/**
 *
 */
package de.hybris.sdh.storefront.forms;

import java.util.Map;


/**
 * @author Maria Torres
 *
 */
public class RetencionesPracticadasForm
{
	private Map<String, String> anioGravable;
	private String numBP;
	private String anio;

	private String impuesto;
	private String reporte;
	private String idretenedor;

	/**
	 * @return the anioGravable
	 */
	public Map<String, String> getAnioGravable()
	{
		return anioGravable;
	}





	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final Map<String, String> anioGravable)
	{
		this.anioGravable = anioGravable;
	}





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
	 * @return the anio
	 */
	public String getAnio()
	{
		return anio;
	}





	/**
	 * @param anio
	 *           the anio to set
	 */
	public void setAnio(final String anio)
	{
		this.anio = anio;
	}





	/**
	 * @return the impuesto
	 */
	public String getImpuesto()
	{
		return impuesto;
	}





	/**
	 * @param impuesto
	 *           the impuesto to set
	 */
	public void setImpuesto(final String impuesto)
	{
		this.impuesto = impuesto;
	}





	/**
	 * @return the reporte
	 */
	public String getReporte()
	{
		return reporte;
	}





	/**
	 * @param reporte
	 *           the reporte to set
	 */
	public void setReporte(final String reporte)
	{
		this.reporte = reporte;
	}





	/**
	 * @return the idretenedor
	 */
	public String getIdretenedor()
	{
		return idretenedor;
	}





	/**
	 * @param idretenedor
	 *           the idretenedor to set
	 */
	public void setIdretenedor(final String idretenedor)
	{
		this.idretenedor = idretenedor;
	}


}