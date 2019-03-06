/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class DetallePagoResponse
{
	private String numRef;
	private String fechVenc;
	private String totalPagar;
	private String numBP;

	private List<ErrorEnWS> errores;


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
	 * @return the fechVenc
	 */
	public String getFechVenc()
	{
		return fechVenc;
	}

	/**
	 * @param fechVenc
	 *           the fechVenc to set
	 */
	public void setFechVenc(final String fechVenc)
	{
		this.fechVenc = fechVenc;
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
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}


}
