/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class ICACalculoImpResponse
{
	private String numForm;

	private ICADeclaracion declaracion;
	private ICAValRetenido valRetenido;
	private ErrorEnWS errores;

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
	 * @return the valRetenido
	 */
	public ICAValRetenido getValRetenido()
	{
		return valRetenido;
	}

	/**
	 * @param valRetenido
	 *           the valRetenido to set
	 */
	public void setValRetenido(final ICAValRetenido valRetenido)
	{
		this.valRetenido = valRetenido;
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



}
