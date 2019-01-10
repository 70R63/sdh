/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class SDHValidaMailRolResponse
{
	private int idmsj;
	private String txtmsj;
	private InfoContribResponse infoContrib;
	private List<NombreRolResponse> roles;

	/**
	 * @return the infoContrib
	 */
	public InfoContribResponse getInfoContrib()
	{
		return infoContrib;
	}

	/**
	 * @param infoContrib
	 *           the infoContrib to set
	 */
	public void setInfoContrib(final InfoContribResponse infoContrib)
	{
		this.infoContrib = infoContrib;
	}

	/**
	 * @return the idmsj
	 */
	public int getIdmsj()
	{
		return idmsj;
	}

	/**
	 * @param idmsj
	 *           the idmsj to set
	 */
	public void setIdmsj(final int idmsj)
	{
		this.idmsj = idmsj;
	}

	/**
	 * @return the txtmsj
	 */
	public String getTxtmsj()
	{
		return txtmsj;
	}

	/**
	 * @param txtmsj
	 *           the txtmsj to set
	 */
	public void setTxtmsj(final String txtmsj)
	{
		this.txtmsj = txtmsj;
	}

	/**
	 * @return the roles
	 */
	public List<NombreRolResponse> getRoles()
	{
		return roles;
	}

	/**
	 * @param roles
	 *           the roles to set
	 */
	public void setRoles(final List<NombreRolResponse> roles)
	{
		this.roles = roles;
	}



}
