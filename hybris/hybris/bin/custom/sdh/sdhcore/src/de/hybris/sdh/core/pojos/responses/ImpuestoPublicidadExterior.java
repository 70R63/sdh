/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class ImpuestoPublicidadExterior
{
	private String numResolu;
	private String tipoValla;
	private boolean seleccionado;
	private String tipoVallaCode;
	private String numObjeto;




	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
	}

	/**
	 *
	 */
	public ImpuestoPublicidadExterior()
	{
		// XXX Auto-generated constructor stub
		this.seleccionado = false;
	}

	/**
	 * @return the numResolu
	 */
	public String getNumResolu()
	{
		return numResolu;
	}

	/**
	 * @param numResolu
	 *           the numResolu to set
	 */
	public void setNumResolu(final String numResolu)
	{
		this.numResolu = numResolu;
	}

	/**
	 * @return the tipoValla
	 */
	public String getTipoValla()
	{
		return tipoValla;
	}

	/**
	 * @param tipoValla
	 *           the tipoValla to set
	 */
	public void setTipoValla(final String tipoValla)
	{
		this.tipoValla = tipoValla;
	}

	/**
	 * @return the seleccionado
	 */
	public boolean isSeleccionado()
	{
		return seleccionado;
	}

	/**
	 * @param seleccionado
	 *           the seleccionado to set
	 */
	public void setSeleccionado(final boolean seleccionado)
	{
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the tipoVallaCode
	 */
	public String getTipoVallaCode()
	{
		return tipoVallaCode;
	}

	/**
	 * @param tipoVallaCode
	 *           the tipoVallaCode to set
	 */
	public void setTipoVallaCode(final String tipoVallaCode)
	{
		this.tipoVallaCode = tipoVallaCode;
	}




}
