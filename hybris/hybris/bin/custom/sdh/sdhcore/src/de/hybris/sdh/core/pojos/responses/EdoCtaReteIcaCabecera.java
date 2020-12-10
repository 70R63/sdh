/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class EdoCtaReteIcaCabecera
{
	private String noDocumento;
	private String tipoDocumento;
	private String saldoCargo;
	private String saldoFavor;
	private List<EdoCtaReteIcaDetail> detalleReteica;


	/**
	 * @return the noDocumento
	 */
	public String getNoDocumento()
	{
		return noDocumento;
	}

	/**
	 * @param noDocumento
	 *           the noDocumento to set
	 */
	public void setNoDocumento(final String noDocumento)
	{
		this.noDocumento = noDocumento;
	}

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
	 * @return the saldoCargo
	 */
	public String getSaldoCargo()
	{
		return saldoCargo;
	}

	/**
	 * @param saldoCargo
	 *           the saldoCargo to set
	 */
	public void setSaldoCargo(final String saldoCargo)
	{
		this.saldoCargo = saldoCargo;
	}

	/**
	 * @return the saldoFavor
	 */
	public String getSaldoFavor()
	{
		return saldoFavor;
	}

	/**
	 * @param saldoFavor
	 *           the saldoFavor to set
	 */
	public void setSaldoFavor(final String saldoFavor)
	{
		this.saldoFavor = saldoFavor;
	}

	/**
	 * @return the detalleReteica
	 */
	public List<EdoCtaReteIcaDetail> getDetalleReteica()
	{
		return detalleReteica;
	}

	/**
	 * @param detalleReteica
	 *           the detalleReteica to set
	 */
	public void setDetalleReteica(final List<EdoCtaReteIcaDetail> detalleReteica)
	{
		this.detalleReteica = detalleReteica;
	}


}

