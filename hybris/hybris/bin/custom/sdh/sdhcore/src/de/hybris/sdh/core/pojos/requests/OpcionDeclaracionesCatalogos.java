/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.Map;


/**
 * @author Federico Flores Dimas
 *
 */
public class OpcionDeclaracionesCatalogos
{

	private Map<String, String> impuesto;

	/**
	 * @return the impuesto
	 */
	public Map<String, String> getImpuesto()
	{
		return impuesto;
	}

	/**
	 * @param impuesto
	 *           the impuesto to set
	 */
	public void setImpuesto(final Map<String, String> impuesto)
	{
		this.impuesto = impuesto;
	}



}
