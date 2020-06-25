/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class SpacResponse
{
	//	@JsonProperty("Proyecto")


	public List<SpacCuotas> cuotas_Spac;
	public List<SpacErrores> errores;

	/**
	 * @return the cuotas_Spac
	 */
	public List<SpacCuotas> getCuotas_Spac()
	{
		return cuotas_Spac;
	}

	/**
	 * @param cuotas_Spac
	 *           the cuotas_Spac to set
	 */
	public void setCuotas_Spac(final List<SpacCuotas> cuotas_Spac)
	{
		this.cuotas_Spac = cuotas_Spac;
	}

	/**
	 * @return the errores
	 */
	public List<SpacErrores> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<SpacErrores> errores)
	{
		this.errores = errores;
	}


}
