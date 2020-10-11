/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class InfoPreviaPSE
{
	private String tipoImpuesto;
	private String numBP;
	private String numDoc;
	private String tipoDoc;
	private String anoGravable;
	private String periodo;
	private String clavePeriodo;
	private String dv;
	private String numObjeto;
	private String CDU;
	private String radicado;
	private String anticipo;
	private String chip;
	private String fechaVenc;
	private String numRef;
	private String totalPagar;
	private String cdu;
	private String placa;





	/**
	 * @return the cdu
	 */
	public String getCdu()
	{
		return cdu;
	}

	/**
	 * @param cdu
	 *           the cdu to set
	 */
	public void setCdu(final String cdu)
	{
		this.cdu = cdu;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca()
	{
		return placa;
	}

	/**
	 * @param placa
	 *           the placa to set
	 */
	public void setPlaca(final String placa)
	{
		this.placa = placa;
	}

	/**
	 * @return the fechaVenc
	 */
	public String getFechaVenc()
	{
		return fechaVenc;
	}

	/**
	 * @param fechaVenc
	 *           the fechaVenc to set
	 */
	public void setFechaVenc(final String fechaVenc)
	{
		this.fechaVenc = fechaVenc;
	}

	/**
	 * @return the numRef
	 */
	public String getNumRef()
	{
		return numRef;
	}

	/**
	 * @param numRef
	 *           the numRef to set
	 */
	public void setNumRef(final String numRef)
	{
		this.numRef = numRef;
	}

	/**
	 * @return the totalPagar
	 */
	public String getTotalPagar()
	{
		return totalPagar;
	}

	/**
	 * @param totalPagar
	 *           the totalPagar to set
	 */
	public void setTotalPagar(final String totalPagar)
	{
		this.totalPagar = totalPagar;
	}

	/**
	 * @return the radicado
	 */
	public String getRadicado()
	{
		return radicado;
	}

	/**
	 * @param radicado
	 *           the radicado to set
	 */
	public void setRadicado(final String radicado)
	{
		this.radicado = radicado;
	}

	/**
	 * @return the tipoImpuesto
	 */
	public String getTipoImpuesto()
	{
		return tipoImpuesto;
	}

	/**
	 * @param tipoImpuesto
	 *           the tipoImpuesto to set
	 */
	public void setTipoImpuesto(final String tipoImpuesto)
	{
		this.tipoImpuesto = tipoImpuesto;
	}
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
	 * @return the dv
	 */
	public String getDv()
	{
		return dv;
	}

	/**
	 * @param dv
	 *           the dv to set
	 */
	public void setDv(final String dv)
	{
		this.dv = dv;
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
	 * @return the cDU
	 */
	public String getCDU()
	{
		return CDU;
	}

	/**
	 * @param cDU
	 *           the cDU to set
	 */
	public void setCDU(final String cDU)
	{
		CDU = cDU;
	}

	/**
	 * @return the anticipo
	 */
	public String getAnticipo()
	{
		return anticipo;
	}

	/**
	 * @param anticipo
	 *           the anticipo to set
	 */
	public void setAnticipo(final String anticipo)
	{
		this.anticipo = anticipo;
	}

	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}

	/**
	 * @param chip
	 *           the chip to set
	 */
	public void setChip(final String chip)
	{
		this.chip = chip;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "InfoPreviaPSE [tipoImpuesto=" + tipoImpuesto + ", numBP=" + numBP + ", numDoc=" + numDoc + ", tipoDoc=" + tipoDoc
				+ ", anoGravable=" + anoGravable + ", periodo=" + periodo + ", clavePeriodo=" + clavePeriodo + ", dv=" + dv
				+ ", numObjeto=" + numObjeto + ", CDU=" + CDU + ", radicado=" + radicado + ", anticipo=" + anticipo + ", chip=" + chip
				+ "]";
	}

}
