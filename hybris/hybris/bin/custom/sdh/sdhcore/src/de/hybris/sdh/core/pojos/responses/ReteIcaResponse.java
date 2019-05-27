/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class ReteIcaResponse
{
	private List<ErrorEnWS> errores;
	private List<ArchivosTRM> archivosTRM;


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
	 * @return the archivosTRM
	 */
	public List<ArchivosTRM> getArchivosTRM()
	{
		return archivosTRM;
	}

	/**
	 * @param archivosTRM
	 *           the archivosTRM to set
	 */
	public void setArchivosTRM(final List<ArchivosTRM> archivosTRM)
	{
		this.archivosTRM = archivosTRM;
	}





}
