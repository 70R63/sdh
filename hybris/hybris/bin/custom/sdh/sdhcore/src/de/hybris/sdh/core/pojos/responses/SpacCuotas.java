/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class SpacCuotas
{
	//	@JsonProperty("Proyecto")


	public String numCuotas;
	public String fechaPago;
	public String monto;
	public String status;

	/**
	 * @return the numCuotas
	 */
	public String getNumCuotas()
	{
		return numCuotas;
	}

	/**
	 * @param numCuotas
	 *           the numCuotas to set
	 */
	public void setNumCuotas(final String numCuotas)
	{
		this.numCuotas = numCuotas;
	}

	/**
	 * @return the fechaPago
	 */
	public String getFechaPago()
	{
		return fechaPago;
	}

	/**
	 * @param fechaPago
	 *           the fechaPago to set
	 */
	public void setFechaPago(final String fechaPago)
	{
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the monto
	 */
	public String getMonto()
	{
		return monto;
	}

	/**
	 * @param monto
	 *           the monto to set
	 */
	public void setMonto(final String monto)
	{
		this.monto = monto;
	}

	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *           the status to set
	 */
	public void setStatus(final String status)
	{
		this.status = status;
	}



}
