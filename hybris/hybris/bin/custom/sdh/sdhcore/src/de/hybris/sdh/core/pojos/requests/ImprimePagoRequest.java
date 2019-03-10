/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Consultor
 *
 */
public class ImprimePagoRequest
{
	private String numBP;
	private String ctaContrato;
	private String numObjeto;
	private String clavePeriodo;
	private String referencia;
	private String fechaCompensa;
	private String importe;
	private String moneda;
	private String numfactForm;
	private String numDocPago;
	private String refROP;

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

	/**
	 * @return the referencia
	 */
	public String getReferencia()
	{
		return referencia;
	}

	/**
	 * @param referencia
	 *           the referencia to set
	 */
	public void setReferencia(final String referencia)
	{
		this.referencia = referencia;
	}

	/**
	 * @return the fechaCompensa
	 */
	public String getFechaCompensa()
	{
		return fechaCompensa;
	}

	/**
	 * @param fechaCompensa
	 *           the fechaCompensa to set
	 */
	public void setFechaCompensa(final String fechaCompensa)
	{
		this.fechaCompensa = fechaCompensa;
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
	 * @return the moneda
	 */
	public String getMoneda()
	{
		return moneda;
	}

	/**
	 * @param moneda
	 *           the moneda to set
	 */
	public void setMoneda(final String moneda)
	{
		this.moneda = moneda;
	}

	/**
	 * @return the numfactForm
	 */
	public String getNumfactForm()
	{
		return numfactForm;
	}

	/**
	 * @param numfactForm
	 *           the numfactForm to set
	 */
	public void setNumfactForm(final String numfactForm)
	{
		this.numfactForm = numfactForm;
	}

	/**
	 * @return the numDocPago
	 */
	public String getNumDocPago()
	{
		return numDocPago;
	}

	/**
	 * @param numDocPago
	 *           the numDocPago to set
	 */
	public void setNumDocPago(final String numDocPago)
	{
		this.numDocPago = numDocPago;
	}

	/**
	 * @return the refROP
	 */
	public String getRefROP()
	{
		return refROP;
	}

	/**
	 * @param refROP
	 *           the refROP to set
	 */
	public void setRefROP(final String refROP)
	{
		this.refROP = refROP;
	}


	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"ctaContrato\":\"" + this.getCtaContrato() + "\",");
		stringBuilder.append("\"numObjeto\":\"" + this.getNumObjeto() + "\",");
		stringBuilder.append("\"clavePeriodo\":\"" + this.getClavePeriodo() + "\",");
		stringBuilder.append("\"referencia\":\"" + this.getReferencia() + "\",");
		stringBuilder.append("\"fechaCompensa\":\"" + this.getFechaCompensa() + "\",");
		stringBuilder.append("\"importe\":\"" + this.getImporte() + "\",");
		stringBuilder.append("\"moneda\":\"" + this.getMoneda() + "\",");
		stringBuilder.append("\"numfactForm\":\"" + this.getNumfactForm() + "\",");
		stringBuilder.append("\"numDocPago\":\"" + this.getNumDocPago() + "\",");
		stringBuilder.append("\"refROP\":\"" + this.getRefROP() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

}
