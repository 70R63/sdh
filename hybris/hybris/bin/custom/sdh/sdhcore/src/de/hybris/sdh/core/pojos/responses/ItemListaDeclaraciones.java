/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class ItemListaDeclaraciones
{

	private String numBP;
	private String ctaContrato;
	private String numObjeto;
	private String clavePeriodo;
	private String desc_clavePeriodo;
	private String referencia;
	private String numForm;
	private String taxpayer;
	private String numRadicado;
	private String creacion;
	private String modificacion;
	private String fechaCompensa; //Para consulPagos
	private String importe; //Para consulPagos
	private String moneda; //Para consulPagos
	private String numfactForm; //Para consulPagos
	private String numDocPago; //Para consulPagos

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
	 * @return the desc_clavePeriodo
	 */
	public String getDesc_clavePeriodo()
	{
		return desc_clavePeriodo;
	}

	/**
	 * @param desc_clavePeriodo
	 *           the desc_clavePeriodo to set
	 */
	public void setDesc_clavePeriodo(final String desc_clavePeriodo)
	{
		this.desc_clavePeriodo = desc_clavePeriodo;
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
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}

	/**
	 * @param numForm
	 *           the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
	}

	/**
	 * @return the taxpayer
	 */
	public String getTaxpayer()
	{
		return taxpayer;
	}

	/**
	 * @param taxpayer
	 *           the taxpayer to set
	 */
	public void setTaxpayer(final String taxpayer)
	{
		this.taxpayer = taxpayer;
	}

	/**
	 * @return the numRadicado
	 */
	public String getNumRadicado()
	{
		return numRadicado;
	}

	/**
	 * @param numRadicado
	 *           the numRadicado to set
	 */
	public void setNumRadicado(final String numRadicado)
	{
		this.numRadicado = numRadicado;
	}
	/**
	 * @return the creacion
	 */
	public String getCreacion()
	{
		return creacion;
	}

	/**
	 * @param creacion
	 *           the creacion to set
	 */
	public void setCreacion(final String creacion)
	{
		this.creacion = creacion;
	}
	/**
	 * @return the modificacion
	 */
	public String getModificacion()
	{
		return modificacion;
	}

	/**
	 * @param modificacion
	 *           the modificacion to set
	 */
	public void setModificacion(final String modificacion)
	{
		this.modificacion = modificacion;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ItemListaDeclaraciones [numBP=" + numBP + ", ctaContrato=" + ctaContrato + ", numObjeto=" + numObjeto
				+ ", clavePeriodo=" + clavePeriodo + ", referencia=" + referencia + ", numForm=" + numForm + ", taxpayer=" + taxpayer
				+ ", numRadicado=" + numRadicado + ", creacion=" + creacion + ", modificacion=" + modificacion + ", fechaCompensa="
				+ fechaCompensa + ", importe=" + importe + ", moneda=" + moneda + ", numfactForm=" + numfactForm + ", numDocPago="
				+ numDocPago + "]";
	}

}
