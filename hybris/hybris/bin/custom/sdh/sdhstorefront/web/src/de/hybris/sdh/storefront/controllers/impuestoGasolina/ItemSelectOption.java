/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

/**
 * @author fede
 *
 */
public class ItemSelectOption
{
	private String key;
	private String label;


	/**
	 * @param key
	 * @param label
	 */
	public ItemSelectOption(final String key, final String label)
	{
		super();
		this.key = key;
		this.label = label;
	}

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
	 * @return the label
	 */
	public String getLabel()
	{
		return label;
	}

	/**
	 * @param label
	 *           the label to set
	 */
	public void setLabel(final String label)
	{
		this.label = label;
	}

}
