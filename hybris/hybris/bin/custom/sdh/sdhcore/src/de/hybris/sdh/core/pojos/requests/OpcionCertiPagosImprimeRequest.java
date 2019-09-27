/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class OpcionCertiPagosImprimeRequest
{

	private String numBP;
	private String ctaContrato;
	private String numObjeto;
	private String numDoc;
	private String tipoDoc;
	private String anoGravable;
	private String periodo;
	private String importe;
	private String clavePeriodo;

	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the ctaContrato
	 */
	public String getCtaContrato()
	{
		return ctaContrato;
	}

	/**
	 * @param ctaContrato
	 *           the ctaContrato to set
	 */
	public void setCtaContrato(final String ctaContrato)
	{
		this.ctaContrato = ctaContrato;
	}

	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
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
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}

	/**
	 * @return the importe
	 */
	public String getImporte()
	{
		return importe;
	}

	/**
	 * @param importe
	 *           the importe to set
	 */
	public void setImporte(final String importe)
	{
		this.importe = importe;
	}

	/**
	 * @return the clavePeriodo
	 */
	public String getClavePeriodo()
	{
		return clavePeriodo;
	}

	/**
	 * @param clavePeriodo
	 *           the clavePeriodo to set
	 */
	public void setClavePeriodo(final String clavePeriodo)
	{
		this.clavePeriodo = clavePeriodo;
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
		stringBuilder.append(obtenerValorJson("\"numBP\":\"", this.getNumBP(), "\","));
		stringBuilder.append(obtenerValorJson("\"ctaContrato\":\"", this.getCtaContrato(), "\","));
		stringBuilder.append(obtenerValorJson("\"numObjeto\":\"", this.getNumObjeto(), "\","));
		stringBuilder.append(obtenerValorJson("\"numDoc\":\"", this.getNumDoc(), "\","));
		stringBuilder.append(obtenerValorJson("\"tipoDoc\":\"", this.getTipoDoc(), "\","));
		stringBuilder.append(obtenerValorJson("\"anoGravable\":\"", this.getAnoGravable(), "\","));
		stringBuilder.append(obtenerValorJson("\"clavePeriodo\":\"", this.getClavePeriodo(), "\","));
		stringBuilder.append(obtenerValorJson("\"Periodo\":\"", this.getPeriodo(), "\","));
		stringBuilder.append(obtenerValorJson("\"importe\":\"", this.getImporte(), "\""));
		stringBuilder.append("}");


		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}


}
