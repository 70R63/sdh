/**
 *
 */
package de.hybris.sdh.storefront.controllers.pages;

import java.util.Map;


/**
 * @author Federico Flores Dimas
 *
 */
public class InfoDelineacionInput
{
	private String selectedCDU;
	private String selectedRadicado;
	private String selectedTipoLicencia;
	private String tipoFlujo;

	private Map<String, String> modalidadLicencia;
	private Map<String, String> presupuestoObra;
	private Map<String, String> causalExencion;
	
	/**
	 * @return the tipoFlujo
	 */
	public String getTipoFlujo()
	{
		return tipoFlujo;
	}

	/**
	 * @param tipoFlujo
	 *           the tipoFlujo to set
	 */
	public void setTipoFlujo(final String tipoFlujo)
	{
		this.tipoFlujo = tipoFlujo;
	}

	/**
	 * @return the modalidadLicencia
	 */
	public Map<String, String> getModalidadLicencia()
	{
		return modalidadLicencia;
	}

	/**
	 * @param modalidadLicencia
	 *           the modalidadLicencia to set
	 */
	public void setModalidadLicencia(final Map<String, String> modalidadLicencia)
	{
		this.modalidadLicencia = modalidadLicencia;
	}

	/**
	 * @return the presupuestoObra
	 */
	public Map<String, String> getPresupuestoObra()
	{
		return presupuestoObra;
	}

	/**
	 * @param presupuestoObra
	 *           the presupuestoObra to set
	 */
	public void setPresupuestoObra(final Map<String, String> presupuestoObra)
	{
		this.presupuestoObra = presupuestoObra;
	}

	/**
	 * @return the causalExencion
	 */
	public Map<String, String> getCausalExencion()
	{
		return causalExencion;
	}

	/**
	 * @param causalExencion
	 *           the causalExencion to set
	 */
	public void setCausalExencion(final Map<String, String> causalExencion)
	{
		this.causalExencion = causalExencion;
	}

	/**
	 * @return the selectedTipoLicencia
	 */
	public String getSelectedTipoLicencia()
	{
		return selectedTipoLicencia;
	}

	/**
	 * @param selectedTipoLicencia
	 *           the selectedTipoLicencia to set
	 */
	public void setSelectedTipoLicencia(final String selectedTipoLicencia)
	{
		this.selectedTipoLicencia = selectedTipoLicencia;
	}

	/**
	 * @return the selectedCDU
	 */
	public String getSelectedCDU()
	{
		return selectedCDU;
	}

	/**
	 * @param selectedCDU
	 *           the selectedCDU to set
	 */
	public void setSelectedCDU(final String selectedCDU)
	{
		this.selectedCDU = selectedCDU;
	}

	/**
	 * @return the selectedRadicado
	 */
	public String getSelectedRadicado()
	{
		return selectedRadicado;
	}

	/**
	 * @param selectedRadicado
	 *           the selectedRadicado to set
	 */
	public void setSelectedRadicado(final String selectedRadicado)
	{
		this.selectedRadicado = selectedRadicado;
	}

}
