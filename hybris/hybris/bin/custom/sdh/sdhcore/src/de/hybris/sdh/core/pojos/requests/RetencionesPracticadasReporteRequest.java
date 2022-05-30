/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author MTorres
 *
 */
public class RetencionesPracticadasReporteRequest
{
	private String numBP;
	private String impuesto;
	private String reporte;
	private String idretenedor;


	/**
	 * @return the numBP
	 */
	@JsonGetter("NumBP")
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP the numBP to set
	 */
	@JsonSetter("NumBP")
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the impuesto
	 */
	@JsonGetter("Impuesto")
	public String getImpuesto()
	{
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	@JsonSetter("Impuesto")
	public void setImpuesto(final String impuesto)
	{
		this.impuesto = impuesto;
	}

	/**
	 * @return the reporte
	 */
	@JsonGetter("reporte")
	public String getReporte()
	{
		return reporte;
	}

	/**
	 * @param reporte the reporte to set
	 */
	@JsonSetter("reporte")
	public void setReporte(final String reporte)
	{
		this.reporte = reporte;
	}

	/**
	 * @return the idretenedor
	 */
	@JsonGetter("IDretenedor")
	public String getIdretenedor()
	{
		return idretenedor;
	}

	/**
	 * @param idretenedor the idretenedor to set
	 */
	@JsonSetter("IDretenedor")
	public void setIdretenedor(final String idretenedor)
	{
		this.idretenedor = idretenedor;
	}
}
