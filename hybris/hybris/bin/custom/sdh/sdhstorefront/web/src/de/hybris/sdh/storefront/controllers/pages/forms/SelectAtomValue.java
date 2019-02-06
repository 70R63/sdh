/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages.forms;

/**
 * @author Consultor
 *
 */
public class SelectAtomValue
{
	private String code;
	private String name;



	/**
	 * @param code
	 * @param name
	 */
	public SelectAtomValue(final String code, final String name)
	{
		super();
		this.code = code;
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * @param code
	 *           the code to set
	 */
	public void setCode(final String code)
	{
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}


}
