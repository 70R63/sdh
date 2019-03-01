/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.NombreRolResponse;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class UIContribuyenteForm
{
	private String bPredial;
	private String bVehicular;
	private String bIca;
	private String bPublicidadExt;
	private String bSobreGasolina;
	private String bDelineacionUrbana;
	private List<NombreRolResponse> roles;


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

	/**
	 * @return the bPredial
	 */
	public String getbPredial()
	{
		return bPredial;
	}

	/**
	 * @param bPredial
	 *           the bPredial to set
	 */
	public void setbPredial(final String bPredial)
	{
		this.bPredial = bPredial;
	}

	/**
	 * @return the bVehicular
	 */
	public String getbVehicular()
	{
		return bVehicular;
	}

	/**
	 * @param bVehicular
	 *           the bVehicular to set
	 */
	public void setbVehicular(final String bVehicular)
	{
		this.bVehicular = bVehicular;
	}

	/**
	 * @return the bIca
	 */
	public String getbIca()
	{
		return bIca;
	}

	/**
	 * @param bIca
	 *           the bIca to set
	 */
	public void setbIca(final String bIca)
	{
		this.bIca = bIca;
	}

	/**
	 * @return the bPublicidadExt
	 */
	public String getbPublicidadExt()
	{
		return bPublicidadExt;
	}

	/**
	 * @param bPublicidadExt
	 *           the bPublicidadExt to set
	 */
	public void setbPublicidadExt(final String bPublicidadExt)
	{
		this.bPublicidadExt = bPublicidadExt;
	}

	/**
	 * @return the bSobreGasolina
	 */
	public String getbSobreGasolina()
	{
		return bSobreGasolina;
	}

	/**
	 * @param bSobreGasolina
	 *           the bSobreGasolina to set
	 */
	public void setbSobreGasolina(final String bSobreGasolina)
	{
		this.bSobreGasolina = bSobreGasolina;
	}

	/**
	 * @return the bDelineacionUrbana
	 */
	public String getbDelineacionUrbana()
	{
		return bDelineacionUrbana;
	}

	/**
	 * @param bDelineacionUrbana
	 *           the bDelineacionUrbana to set
	 */
	public void setbDelineacionUrbana(final String bDelineacionUrbana)
	{
		this.bDelineacionUrbana = bDelineacionUrbana;
	}

}
