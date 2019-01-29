/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class CertificacionRIT
{
	private String tipoDoc;
	private String numDoc;
	private String stringRIT;


	/**
	 * @return the stringRIT
	 */
	public String getStringRIT()
	{
		return stringRIT;
	}

	/**
	 * @param stringRIT
	 *           the stringRIT to set
	 */
	public void setStringRIT(final String stringRIT)
	{
		this.stringRIT = stringRIT;
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


}
