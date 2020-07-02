package de.hybris.sdh.core.pojos.requests;

public class TercerosAutRequest {
	private String impuesto;
	private String numeroObjeto;
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
	 * @return the numeroObjeto
	 */
	public String getNumeroObjeto()
	{
		return numeroObjeto;
	}

	/**
	 * @param numeroObjeto
	 *           the numeroObjeto to set
	 */
	public void setNumeroObjeto(final String numeroObjeto)
	{
		this.numeroObjeto = numeroObjeto;
	}

	/**
	 * @param impuesto
	 * @param numeroObjeto
	 * @param tipoDocumento
	 * @param numeroDocumento
	 */
	public TercerosAutRequest(final String impuesto, final String numeroObjeto, final String tipoDocumento, final String numeroDocumento)
	{
		super();
		this.impuesto = impuesto;
		this.numeroObjeto = numeroObjeto;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{\"parametros\":{");
		stringBuilder.append(obtenerValorJson("\"impuesto\":\"", this.getImpuesto(), "\","));
		stringBuilder.append(obtenerValorJson("\"numeroObjeto\":\"", this.getNumeroObjeto(), "\","));
		stringBuilder.append(obtenerValorJson("\"tipoDocumento\":\"", this.getTipoDocumento(), "\","));
		stringBuilder.append(obtenerValorJson("\"numeroDocumento\":\"", this.getNumeroDocumento(), "\""));
		stringBuilder.append("}}");

		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}

}
