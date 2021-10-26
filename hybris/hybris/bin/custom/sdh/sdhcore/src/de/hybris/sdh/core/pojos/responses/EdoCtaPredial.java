/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;



/**
 * @author hybris
 *
 */
public class EdoCtaPredial
{
	private String newCHIP;
	private String matrInmobiliaria;
	private String direccion;
	private String saldocargo;
	private String saldofavor;
	private List<EdoCtaPredialDetail> detallePredial;







	/**
	 * @return the newCHIP
	 */
	public String getNewCHIP()
	{
		return newCHIP;
	}

	/**
	 * @param newCHIP
	 *           the newCHIP to set
	 */
	@JsonSetter("CHIP")
	public void setNewCHIP(final String newCHIP)
	{
		this.newCHIP = newCHIP;
	}

	/**
	 * @return the matrInmobiliaria
	 */
	public String getMatrInmobiliaria()
	{
		return matrInmobiliaria;
	}

	/**
	 * @param matrInmobiliaria
	 *           the matrInmobiliaria to set
	 */
	public void setMatrInmobiliaria(final String matrInmobiliaria)
	{
		this.matrInmobiliaria = matrInmobiliaria;
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
	 * @return the detallePredial
	 */
	public List<EdoCtaPredialDetail> getDetallePredial()
	{
		return detallePredial;
	}

	/**
	 * @param detallePredial
	 *           the detallePredial to set
	 */
	public void setDetallePredial(final List<EdoCtaPredialDetail> detallePredial)
	{
		this.detallePredial = detallePredial;
	}


}

