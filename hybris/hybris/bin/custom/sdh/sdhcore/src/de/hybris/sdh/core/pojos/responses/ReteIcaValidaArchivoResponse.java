/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class ReteIcaValidaArchivoResponse
{
	private List<ErrorEnWS> errores;
	private Boolean requestCofirmation;
	private Boolean allowFileUpload;


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
	 * @return the requestCofirmation
	 */
	public Boolean getRequestCofirmation()
	{
		return requestCofirmation;
	}

	/**
	 * @param requestCofirmation
	 *           the requestCofirmation to set
	 */
	public void setRequestCofirmation(final Boolean requestCofirmation)
	{
		this.requestCofirmation = requestCofirmation;
	}

	/**
	 * @return the allowFileUpload
	 */
	public Boolean getAllowFileUpload()
	{
		return allowFileUpload;
	}

	/**
	 * @param allowFileUpload
	 *           the allowFileUpload to set
	 */
	public void setAllowFileUpload(final Boolean allowFileUpload)
	{
		this.allowFileUpload = allowFileUpload;
	}




}
