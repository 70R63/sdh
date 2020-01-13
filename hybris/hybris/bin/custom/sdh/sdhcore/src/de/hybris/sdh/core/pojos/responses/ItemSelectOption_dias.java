/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class ItemSelectOption_dias
{
	private String key;
	private List<ItemSelectOption> dias;
	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}
	
	/**
	 * @param key
	 *           the key to set
	 */
	public void setKey(final String key)
	{
		this.key = key;
	}
	
	/**
	 * @return the dias
	 */
	public List<ItemSelectOption> getDias()
	{
		return dias;
	}
	
	/**
	 * @param dias
	 *           the dias to set
	 */
	public void setDias(final List<ItemSelectOption> dias)
	{
		this.dias = dias;
	}


}
