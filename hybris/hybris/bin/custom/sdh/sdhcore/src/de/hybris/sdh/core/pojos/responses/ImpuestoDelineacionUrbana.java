/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class ImpuestoDelineacionUrbana
{
	private String numObjeto;
	private String cdu;
	private String licenConst;
	private String fechaExp;


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
	 * @return the licenConst
	 */
	public String getLicenConst()
	{
		return licenConst;
	}

	/**
	 * @param licenConst
	 *           the licenConst to set
	 */
	public void setLicenConst(final String licenConst)
	{
		this.licenConst = licenConst;
	}

	/**
	 * @return the fechaExp
	 */
	public String getFechaExp()
	{
		return fechaExp;
	}

	/**
	 * @param fechaExp
	 *           the fechaExp to set
	 */
	public void setFechaExp(final String fechaExp)
	{
		this.fechaExp = fechaExp;
	}


}
