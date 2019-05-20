/**
 *
 */
package de.hybris.sdh.core.pojos.responses;



/**
 * @author hybris
 *
 */
public class CalculoReteIcaResponse
{
	private String numForm;

	private CalculoReteIcaInfoDeclara infoDeclara;

	private ReteIcaRelaciones relaciones;

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
	 * @return the infoDeclara
	 */
	public CalculoReteIcaInfoDeclara getInfoDeclara()
	{
		return infoDeclara;
	}

	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	public void setInfoDeclara(final CalculoReteIcaInfoDeclara infoDeclara)
	{
		this.infoDeclara = infoDeclara;
	}

	/**
	 * @return the relaciones
	 */
	public ReteIcaRelaciones getRelaciones()
	{
		return relaciones;
	}

	/**
	 * @param relaciones
	 *           the relaciones to set
	 */
	public void setRelaciones(final ReteIcaRelaciones relaciones)
	{
		this.relaciones = relaciones;
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
