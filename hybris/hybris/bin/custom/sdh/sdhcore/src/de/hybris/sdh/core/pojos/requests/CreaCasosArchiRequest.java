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
	private String ZZWCC_TIPODOC_ID;
	private String ZZWCC_DESC_TIPODOC;
	private String ZZWCC_ARCIVO;


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
		stringBuilder.append("\"ZZWCC_TIPODOC_ID\"\":\"" + this.getZZWCC_TIPODOC_ID() + "\",");
		stringBuilder.append("\"ZZWCC_DESC_TIPODOC\":\"" + this.getZZWCC_DESC_TIPODOC() + "\",");
		stringBuilder.append("\"ZZWCC_ARCIVO\":\"" + this.getZZWCC_ARCIVO() + "\"");
		stringBuilder.append("}");


		return stringBuilder.toString();
	}
}
