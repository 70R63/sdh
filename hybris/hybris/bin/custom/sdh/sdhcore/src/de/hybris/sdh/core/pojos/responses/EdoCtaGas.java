/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class EdoCtaGas
{
	private String tipoDocumento;
	private String numDoc;
	private String saldocargo;
	private String saldofavor;
	private List<EdoCtaGasDetail> detalleGasolina;

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento()
	{
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento
	 *           the tipoDocumento to set
	 */
	public void setTipoDocumento(final String tipoDocumento)
	{
		this.tipoDocumento = tipoDocumento;
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
	 * @return the detalleGasolina
	 */
	public List<EdoCtaGasDetail> getDetalleGasolina()
	{
		return detalleGasolina;
	}

	/**
	 * @param detalleGasolina
	 *           the detalleGasolina to set
	 */
	public void setDetalleGasolina(final List<EdoCtaGasDetail> detalleGasolina)
	{
		this.detalleGasolina = detalleGasolina;
	}


}
