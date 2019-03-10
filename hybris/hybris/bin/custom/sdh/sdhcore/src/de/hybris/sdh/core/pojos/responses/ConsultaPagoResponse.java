/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ConsultaPagoResponse
{
	private List<ErrorEnWS> errores;
	private List<ConsultaPagoDeclaraciones> declaraciones;

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

	/**
	 * @return the declaraciones
	 */
	public List<ConsultaPagoDeclaraciones> getDeclaraciones()
	{
		return declaraciones;
	}

	/**
	 * @param declaraciones
	 *           the declaraciones to set
	 */
	public void setDeclaraciones(final List<ConsultaPagoDeclaraciones> declaraciones)
	{
		this.declaraciones = declaraciones;
	}


}
