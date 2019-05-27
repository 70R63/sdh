/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonSetter;


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
	private List<ImpuestoGasolina> gasolina;
	private List<ImpuestoPublicidadExterior> publicidadExt;
	private List<ContribAgente> agentes;
	private List<ImpuestoDelineacionUrbana> delineacion;
	private ImpuestoICA ica;
	private ReteICA reteIca;
	//	private ImpuestoReteICA reteICA;

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

	/**
	 * @return the gasolina
	 */
	public List<ImpuestoGasolina> getGasolina()
	{
		return gasolina;
	}

	/**
	 * @param gasolina
	 *           the gasolina to set
	 */
	public void setGasolina(final List<ImpuestoGasolina> gasolina)
	{
		this.gasolina = gasolina;
	}

	/**
	 * @return the publicidadExt
	 */
	public List<ImpuestoPublicidadExterior> getPublicidadExt()
	{
		return publicidadExt;
	}

	/**
	 * @param publicidadExt
	 *           the publicidadExt to set
	 */
	public void setPublicidadExt(final List<ImpuestoPublicidadExterior> publicidadExt)
	{
		this.publicidadExt = publicidadExt;
	}

	/**
	 * @return the agentes
	 */
	public List<ContribAgente> getAgentes()
	{
		return agentes;
	}

	/**
	 * @param agentes
	 *           the agentes to set
	 */
	public void setAgentes(final List<ContribAgente> agentes)
	{
		this.agentes = agentes;
	}

	/**
	 * @return the delineacion
	 */
	public List<ImpuestoDelineacionUrbana> getDelineacion()
	{
		return delineacion;
	}

	/**
	 * @param delineacion
	 *           the delineacion to set
	 */
	public void setDelineacion(final List<ImpuestoDelineacionUrbana> delineacion)
	{
		this.delineacion = delineacion;
	}

	/**
	 * @return the ica
	 */
	public ImpuestoICA getIca()
	{
		return ica;
	}

	/**
	 * @param ica
	 *           the ica to set
	 */
	@JsonSetter("ICA")
	public void setIca(final ImpuestoICA ica)
	{
		this.ica = ica;
	}

	/**
	 * @return the reteIca
	 */
	public ReteICA getReteIca()
	{
		return reteIca;
	}

	@JsonSetter("reteICA")
	public void setReteIca(final ReteICA reteIca)
	{
		this.reteIca = reteIca;
	}


}
