/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class ListaDeclaracionesResponse
{

	private List<ItemListaDeclaraciones> declaraciones;
	private List<ErrorEnWS> errores;



	/**
	 * @return the declaraciones
	 */
	public List<ItemListaDeclaraciones> getDeclaraciones()
	{
		return declaraciones;
	}

	/**
	 * @param declaraciones
	 *           the declaraciones to set
	 */
	public void setDeclaraciones(final List<ItemListaDeclaraciones> declaraciones)
	{
		this.declaraciones = declaraciones;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ListaDeclaracionesResponse [declaraciones=" + declaraciones + ", errores=" + errores + "]";
	}



}
