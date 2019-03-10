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
	private String seleccionado;


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
	 * @return the seleccionado
	 */
	public String getSeleccionado()
	{
		return seleccionado;
	}

	/**
	 * @param seleccionado
	 *           the seleccionado to set
	 */
	public void setSeleccionado(final String seleccionado)
	{
		this.seleccionado = seleccionado;
	}

	public SobreTasaGasolinaTabla(final String tipoDocumento, final String numeroDocumento)
	{
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 *
	 */
	public SobreTasaGasolinaTabla()
	{
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "SobreTasaGasolinaTabla [tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", seleccionado="
				+ seleccionado + "]";
	}


}
