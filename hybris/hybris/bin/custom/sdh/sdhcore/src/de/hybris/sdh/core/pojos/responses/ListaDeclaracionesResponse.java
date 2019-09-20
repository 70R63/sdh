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

	private List<ItemLlistaDeclaraciones> declaraciones;



	/**
	 * @return the declaraciones
	 */
	public List<ItemLlistaDeclaraciones> getDeclaraciones()
	{
		return declaraciones;
	}

	/**
	 * @param declaraciones
	 *           the declaraciones to set
	 */
	public void setDeclaraciones(final List<ItemLlistaDeclaraciones> declaraciones)
	{
		this.declaraciones = declaraciones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ListaDeclaracionesResponse [declaraciones=" + declaraciones + "]";
	}


}
