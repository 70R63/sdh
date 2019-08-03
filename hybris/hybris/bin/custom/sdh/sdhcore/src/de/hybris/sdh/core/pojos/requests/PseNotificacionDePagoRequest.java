/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author edson.roa
 *
 */
public class PseNotificacionDePagoRequest
{
	private String idBancos;
	private String modalidad;
	private String procPago;
	private String fchRecaudo;
	private String horRecaudo;
	private String codImpuesto;
	//private String tipoHorario;
	private String refPago;
	private String vlrRecuado;
	private String medioPago;
	private String numOperacion;
	private String objPago;

	/**
	 * @return the idBancos
	 */
	public String getIdBancos()
	{
		return idBancos;
	}

	/**
	 * @param idBancos
	 *           the idBancos to set
	 */
	public void setIdBancos(final String idBancos)
	{
		this.idBancos = idBancos;
	}

	/**
	 * @return the modalidad
	 */
	public String getModalidad()
	{
		return modalidad;
	}

	/**
	 * @param modalidad
	 *           the modalidad to set
	 */
	public void setModalidad(final String modalidad)
	{
		this.modalidad = modalidad;
	}

	/**
	 * @return the procPago
	 */
	public String getProcPago()
	{
		return procPago;
	}

	/**
	 * @param procPago
	 *           the procPago to set
	 */
	public void setProcPago(final String procPago)
	{
		this.procPago = procPago;
	}

	/**
	 * @return the fchRecaudo
	 */
	public String getFchRecaudo()
	{
		return fchRecaudo;
	}

	/**
	 * @param fchRecaudo
	 *           the fchRecaudo to set
	 */
	public void setFchRecaudo(final String fchRecaudo)
	{
		this.fchRecaudo = fchRecaudo;
	}

	/**
	 * @return the horRecaudo
	 */
	public String getHorRecaudo()
	{
		return horRecaudo;
	}

	/**
	 * @param horRecaudo
	 *           the horRecaudo to set
	 */
	public void setHorRecaudo(final String horRecaudo)
	{
		this.horRecaudo = horRecaudo;
	}

	/**
	 * @return the codImpuesto
	 */
	public String getCodImpuesto()
	{
		return codImpuesto;
	}

	/**
	 * @param codImpuesto
	 *           the codImpuesto to set
	 */
	public void setCodImpuesto(final String codImpuesto)
	{
		this.codImpuesto = codImpuesto;
	}

	/**
	 * @return the refPago
	 */
	public String getRefPago()
	{
		return refPago;
	}

	/**
	 * @param refPago
	 *           the refPago to set
	 */
	public void setRefPago(final String refPago)
	{
		this.refPago = refPago;
	}

	/**
	 * @return the vlrRecuado
	 */
	public String getVlrRecuado()
	{
		return vlrRecuado;
	}

	/**
	 * @param vlrRecuado
	 *           the vlrRecuado to set
	 */
	public void setVlrRecuado(final String vlrRecuado)
	{
		this.vlrRecuado = vlrRecuado;
	}

	/**
	 * @return the medioPago
	 */
	public String getMedioPago()
	{
		return medioPago;
	}

	/**
	 * @param medioPago
	 *           the medioPago to set
	 */
	public void setMedioPago(final String medioPago)
	{
		this.medioPago = medioPago;
	}

	/**
	 * @return the numOperacion
	 */
	public String getNumOperacion()
	{
		return numOperacion;
	}

	/**
	 * @param numOperacion
	 *           the numOperacion to set
	 */
	public void setNumOperacion(final String numOperacion)
	{
		this.numOperacion = numOperacion;
	}

	/**
	 * @return the objPago
	 */
	public String getObjPago()
	{
		return objPago;
	}

	/**
	 * @param objPago
	 *           the objPago to set
	 */
	public void setObjPago(final String objPago)
	{
		this.objPago = objPago;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PseNotificacionDePagoRequest [idBancos=" + idBancos + ", modalidad=" + modalidad + ", procPago=" + procPago
				+ ", fchRecaudo=" + fchRecaudo + ", horRecaudo=" + horRecaudo + ", codImpuesto=" + codImpuesto + ", refPago="
				+ refPago + ", vlrRecuado=" + vlrRecuado + ", medioPago=" + medioPago + ", numOperacion="
				+ numOperacion + ", objPago=" + objPago + "]";
	}


}
