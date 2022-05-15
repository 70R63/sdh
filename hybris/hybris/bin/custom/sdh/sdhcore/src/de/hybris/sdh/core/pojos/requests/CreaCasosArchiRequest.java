/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class CreaCasosArchiRequest
{

	private String ZZWCC_DEPEND_ID;
	private String ZZWCC_SERIE_ID;
	private String ZZWCC_SSERIE_ID;
	private String ZZWCC_TIPODOC_ID;
	private String ZZWCC_DESC_TIPODOC;
	private String ZZWCC_ARCIVO;


	/**
	 * @return the zZWCC_DEPEND_ID
	 */
	public String getZZWCC_DEPEND_ID()
	{
		return ZZWCC_DEPEND_ID;
	}

	/**
	 * @param zZWCC_DEPEND_ID
	 *           the zZWCC_DEPEND_ID to set
	 */
	public void setZZWCC_DEPEND_ID(final String zZWCC_DEPEND_ID)
	{
		ZZWCC_DEPEND_ID = zZWCC_DEPEND_ID;
	}

	/**
	 * @return the zZWCC_SERIE_ID
	 */
	public String getZZWCC_SERIE_ID()
	{
		return ZZWCC_SERIE_ID;
	}

	/**
	 * @param zZWCC_SERIE_ID
	 *           the zZWCC_SERIE_ID to set
	 */
	public void setZZWCC_SERIE_ID(final String zZWCC_SERIE_ID)
	{
		ZZWCC_SERIE_ID = zZWCC_SERIE_ID;
	}

	/**
	 * @return the zZWCC_SSERIE_ID
	 */
	public String getZZWCC_SSERIE_ID()
	{
		return ZZWCC_SSERIE_ID;
	}

	/**
	 * @param zZWCC_SSERIE_ID
	 *           the zZWCC_SSERIE_ID to set
	 */
	public void setZZWCC_SSERIE_ID(final String zZWCC_SSERIE_ID)
	{
		ZZWCC_SSERIE_ID = zZWCC_SSERIE_ID;
	}

	/**
	 * @return the zZWCC_TIPODOC_ID
	 */
	public String getZZWCC_TIPODOC_ID()
	{
		return ZZWCC_TIPODOC_ID;
	}

	/**
	 * @param zZWCC_TIPODOC_ID
	 *           the zZWCC_TIPODOC_ID to set
	 */
	public void setZZWCC_TIPODOC_ID(final String zZWCC_TIPODOC_ID)
	{
		ZZWCC_TIPODOC_ID = zZWCC_TIPODOC_ID;
	}

	/**
	 * @return the zZWCC_DESC_TIPODOC
	 */
	public String getZZWCC_DESC_TIPODOC()
	{
		return ZZWCC_DESC_TIPODOC;
	}

	/**
	 * @param zZWCC_DESC_TIPODOC
	 *           the zZWCC_DESC_TIPODOC to set
	 */
	public void setZZWCC_DESC_TIPODOC(final String zZWCC_DESC_TIPODOC)
	{
		ZZWCC_DESC_TIPODOC = zZWCC_DESC_TIPODOC;
	}

	/**
	 * @return the zZWCC_ARCIVO
	 */
	public String getZZWCC_ARCIVO()
	{
		return ZZWCC_ARCIVO;
	}

	/**
	 * @param zZWCC_ARCIVO
	 *           the zZWCC_ARCIVO to set
	 */
	public void setZZWCC_ARCIVO(final String zZWCC_ARCIVO)
	{
		ZZWCC_ARCIVO = zZWCC_ARCIVO;
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

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"ZZWCC_DEPEND_ID\":\"", this.getZZWCC_DEPEND_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_SERIE_ID\":\"", this.getZZWCC_SERIE_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_SSERIE_ID\":\"", this.getZZWCC_SSERIE_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_TIPODOC_ID\":\"", this.getZZWCC_TIPODOC_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_DESC_TIPODOC\":\"", this.getZZWCC_DESC_TIPODOC(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_ARCIVO\":\"", this.getZZWCC_ARCIVO(), "\""));
		stringBuilder.append("}");


		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}


	public String toString_reducido()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"ZZWCC_DEPEND_ID\":\"", this.getZZWCC_DEPEND_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_SERIE_ID\":\"", this.getZZWCC_SERIE_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_SSERIE_ID\":\"", this.getZZWCC_SSERIE_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_TIPODOC_ID\":\"", this.getZZWCC_TIPODOC_ID(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_DESC_TIPODOC\":\"", this.getZZWCC_DESC_TIPODOC(), "\","));
		stringBuilder.append(obtenerValorJson("\"ZZWCC_ARCIVO\":\"", Integer.toString(this.getZZWCC_ARCIVO().length()), "\""));
		stringBuilder.append("}");


		return stringBuilder.toString();
	}
}
