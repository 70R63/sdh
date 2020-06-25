/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.SpacCuotas;
import de.hybris.sdh.core.pojos.responses.SpacErrores;

import java.util.List;

/**
 * @author Maria Luisa
 *
 */
public class SpacForm
{
	public String pdf;
	public List<SpacCuotas> cuotas_Spac;
	public List<SpacErrores> errores;



	/**
	 * @return the pdf
	 */
	public String getPdf()
	{
		return pdf;
	}

	/**
	 * @param pdf
	 *           the pdf to set
	 */
	public void setPdf(final String pdf)
	{
		this.pdf = pdf;
	}

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
