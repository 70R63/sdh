/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class EdoCtaDeli
{
	private String CDU;
	private String licenciaConstruccion;
	private String direccion;
	private String saldocargo;
	private String saldofavor;
	private List<EdoCtaDeliDetail> detalleDelineacion;

	/**
	 * @return the cDU
	 */
	public String getCDU()
	{
		return CDU;
	}

	/**
	 * @param cDU
	 *           the cDU to set
	 */
	public void setCDU(final String cDU)
	{
		CDU = cDU;
	}

	/**
	 * @return the licenciaConstruccion
	 */
	public String getLicenciaConstruccion()
	{
		return licenciaConstruccion;
	}

	/**
	 * @param licenciaConstruccion
	 *           the licenciaConstruccion to set
	 */
	public void setLicenciaConstruccion(final String licenciaConstruccion)
	{
		this.licenciaConstruccion = licenciaConstruccion;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final String direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * @return the saldocargo
	 */
	public String getSaldocargo()
	{
		return saldocargo;
	}

	/**
	 * @param saldocargo
	 *           the saldocargo to set
	 */
	public void setSaldocargo(final String saldocargo)
	{
		this.saldocargo = saldocargo;
	}

	/**
	 * @return the saldofavor
	 */
	public String getSaldofavor()
	{
		return saldofavor;
	}

	/**
	 * @param saldofavor
	 *           the saldofavor to set
	 */
	public void setSaldofavor(final String saldofavor)
	{
		this.saldofavor = saldofavor;
	}

	/**
	 * @return the detalleDelineacion
	 */
	public List<EdoCtaDeliDetail> getDetalleDelineacion()
	{
		return detalleDelineacion;
	}

	/**
	 * @param detalleDelineacion
	 *           the detalleDelineacion to set
	 */
	public void setDetalleDelineacion(final List<EdoCtaDeliDetail> detalleDelineacion)
	{
		this.detalleDelineacion = detalleDelineacion;
	}


}
