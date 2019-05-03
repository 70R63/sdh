/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ICACalculoImpResponse
{
	private String numForm;

	private ICADeclaracion declaracion;
	private List<ICAValRetenido> valRetenido;
	private List<ErrorEnWS> errores;

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
	 * @return the declaracion
	 */
	public ICADeclaracion getDeclaracion()
	{
		return declaracion;
	}

	/**
	 * @param declaracion
	 *           the declaracion to set
	 */
	public void setDeclaracion(final ICADeclaracion declaracion)
	{
		this.declaracion = declaracion;
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