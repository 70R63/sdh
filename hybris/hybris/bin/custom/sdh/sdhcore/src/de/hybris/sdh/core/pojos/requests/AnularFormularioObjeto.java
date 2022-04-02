/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author MTorres
 *
 */
public class AnularFormularioObjeto
{
	private String fbnum;
	private String casef;

	/**
	 * @return the fbnum
	 */
	@JsonGetter("FBNUM")
	public String getFbnum()
	{
		return fbnum;
	}

	/**
	 * @param fbnum
	 *           the fbnum to set
	 */
	@JsonSetter("FBNUM")
	public void setFbnum(final String fbnum)
	{
		this.fbnum = fbnum;
	}

	/**
	 * @return the casef
	 */
	@JsonGetter("CASEF")
	public String getCasef()
	{
		return casef;
	}

	/**
	 * @param casef
	 *           the casef to set
	 */
	@JsonSetter("CASEF")
	public void setCasef(final String casef)
	{
		this.casef = casef;
	}

	@Override
	public String toString()
	{
		return "AnularFormularioObjeto [fbnum=" + fbnum + ", casef=" + casef + "]";
	}
}
