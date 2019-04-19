/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class InfoObjetoDelineacionResponse
{

	private String numForm;
	private DelineacionUInfoDeclara infoDeclara;
	private List<DelineacionUUsos> usos;
	private List<DelineacionUAreaIntervenida> areaIntervenida;
	private List<DelineacionUAreaProyecto> areaProyecto;
	private List<DelineacionURelaciones> relaciones;
	private List<ErrorEnWS> errores;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "InfoObjetoDelineacionResponse [numForm=" + numForm + ", infoDeclara=" + infoDeclara + ", usos=" + usos
				+ ", areaIntervenida=" + areaIntervenida + ", areaProyecto=" + areaProyecto + ", relaciones=" + relaciones
				+ ", errores=" + errores + "]";
	}


	/**
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}
	
	/**
	 * @param numForm
	 *           the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
	}
	
	/**
	 * @return the infoDeclara
	 */
	public DelineacionUInfoDeclara getInfoDeclara()
	{
		return infoDeclara;
	}

	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	public void setInfoDeclara(final DelineacionUInfoDeclara infoDeclara)
	{
		this.infoDeclara = infoDeclara;
	}
	/**
	 * @return the usos
	 */
	public List<DelineacionUUsos> getUsos()
	{
		return usos;
	}

	/**
	 * @param usos
	 *           the usos to set
	 */
	public void setUsos(final List<DelineacionUUsos> usos)
	{
		this.usos = usos;
	}
	/**
	 * @return the areaIntervenida
	 */
	public List<DelineacionUAreaIntervenida> getAreaIntervenida()
	{
		return areaIntervenida;
	}

	/**
	 * @param areaIntervenida
	 *           the areaIntervenida to set
	 */
	public void setAreaIntervenida(final List<DelineacionUAreaIntervenida> areaIntervenida)
	{
		this.areaIntervenida = areaIntervenida;
	}
	/**
	 * @return the areaProyecto
	 */
	public List<DelineacionUAreaProyecto> getAreaProyecto()
	{
		return areaProyecto;
	}

	/**
	 * @param areaProyecto
	 *           the areaProyecto to set
	 */
	public void setAreaProyecto(final List<DelineacionUAreaProyecto> areaProyecto)
	{
		this.areaProyecto = areaProyecto;
	}
	/**
	 * @return the relaciones
	 */
	public List<DelineacionURelaciones> getRelaciones()
	{
		return relaciones;
	}

	/**
	 * @param relaciones
	 *           the relaciones to set
	 */
	public void setRelaciones(final List<DelineacionURelaciones> relaciones)
	{
		this.relaciones = relaciones;
	}
	/**
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}
}
