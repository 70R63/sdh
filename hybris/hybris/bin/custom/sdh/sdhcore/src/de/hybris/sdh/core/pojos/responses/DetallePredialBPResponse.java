/**
 *
 */
package de.hybris.sdh.core.pojos.responses;


/**
 * @author Federico Flores Dimas
 *
 */
public class DetallePredialBPResponse
{
	private String baseGravable;
	private ErrorEnWS errores;

	/**
	 * @return the baseGravable
	 */
	public String getBaseGravable()
	{
		return baseGravable;
	}

	/**
	 * @param baseGravable
	 *           the baseGravable to set
	 */
	public void setBaseGravable(final String baseGravable)
	{
		this.baseGravable = baseGravable;
	}

	/**
	 * @return the errores
	 */
	public ErrorEnWS getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final ErrorEnWS errores)
	{
		this.errores = errores;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetallePredialBPResponse [baseGravable=" + baseGravable + ", errores=" + errores + "]";
	}




}
