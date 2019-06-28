/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author edson.roa
 *
 */
public class TypFileBancoListResponse
{
	List<TypFileBancoResponse> tipos;

	/**
	 * @return the tipos
	 */
	public List<TypFileBancoResponse> getTipos()
	{
		return tipos;
	}

	/**
	 * @param tipos
	 *           the tipos to set
	 */
	public void setTipos(final List<TypFileBancoResponse> tipos)
	{
		this.tipos = tipos;
	}


}
