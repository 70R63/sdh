/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

/**
 * @author fede
 *
 */
public class SobreTasaGasolinaTabla
{

	private String tipoDocumento;
	private String numeroDocumento;

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
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento()
	{
		return numeroDocumento;
	}
	
	/**
	 * @param numeroDocumento
	 *           the numeroDocumento to set
	 */
	public void setNumeroDocumento(final String numeroDocumento)
	{
		this.numeroDocumento = numeroDocumento;
	}
	
	/**
	 * @param tipoDocumento
	 * @param numeroDocumento
	 */
	public SobreTasaGasolinaTabla(final String tipoDocumento, final String numeroDocumento)
	{
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}



}
