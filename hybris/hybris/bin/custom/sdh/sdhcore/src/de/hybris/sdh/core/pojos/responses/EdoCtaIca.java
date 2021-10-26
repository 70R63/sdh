/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;



/**
 * @author Consultor
 *
 */
public class EdoCtaIca
{
	private String numDoc;
	private String tipoDoc;
	private String saldocargo;
	private String saldofavor;
	private List<EdoCtaIcaDetail> newDetalleICA;

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
	 * @return the newDetalleICA
	 */
	public List<EdoCtaIcaDetail> getNewDetalleICA()
	{
		return newDetalleICA;
	}

	/**
	 * @param newDetalleICA
	 *           the newDetalleICA to set
	 */
	@JsonSetter("DetalleICA")
	public void setNewDetalleICA(final List<EdoCtaIcaDetail> newDetalleICA)
	{
		this.newDetalleICA = newDetalleICA;
	}

	/**
	 * @return the detalleICA
	 */


}
