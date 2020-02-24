/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class EdoCuentaResponse
{
	private String tasaInteres;
	private String PredialSaldoCargo;
	private String PredialSaldoFavor;
	private String ICASaldoCargo;
	private String ICASaldoFavor;
	private String VehicularSaldoCargo;
	private String VehicularSaldoFavor;
	private String DelineacionSaldoCargo;
	private String DelineacionSaldoFavor;
	private String GasolinaSaldoCargo;
	private String GasolinaSaldoFavor;
	private String PublicidadSaldoCargo;
	private String PublicidadSaldoFavor;
	private List<EdoCtaPredial> predial;
	private List<EdoCtaIca> tablaICA;
	private List<EdoCtaVehiculos> tablaVehicular;
	private List<EdoCtaDeli> tablaDelineacion;
	private List<EdoCtaGas> tablaGasolina;
	private List<EdoCtaPublicidad> tablaPublicidad;

	/**
	 * @return the tasaInteres
	 */
	public String getTasaInteres()
	{
		return tasaInteres;
	}

	/**
	 * @param tasaInteres
	 *           the tasaInteres to set
	 */
	public void setTasaInteres(final String tasaInteres)
	{
		this.tasaInteres = tasaInteres;
	}

	/**
	 * @return the predialSaldoCargo
	 */
	public String getPredialSaldoCargo()
	{
		return PredialSaldoCargo;
	}

	/**
	 * @param predialSaldoCargo
	 *           the predialSaldoCargo to set
	 */
	public void setPredialSaldoCargo(final String predialSaldoCargo)
	{
		PredialSaldoCargo = predialSaldoCargo;
	}

	/**
	 * @return the predialSaldoFavor
	 */
	public String getPredialSaldoFavor()
	{
		return PredialSaldoFavor;
	}

	/**
	 * @param predialSaldoFavor
	 *           the predialSaldoFavor to set
	 */
	public void setPredialSaldoFavor(final String predialSaldoFavor)
	{
		PredialSaldoFavor = predialSaldoFavor;
	}

	/**
	 * @return the iCASaldoCargo
	 */
	public String getICASaldoCargo()
	{
		return ICASaldoCargo;
	}

	/**
	 * @param iCASaldoCargo
	 *           the iCASaldoCargo to set
	 */
	public void setICASaldoCargo(final String iCASaldoCargo)
	{
		ICASaldoCargo = iCASaldoCargo;
	}

	/**
	 * @return the iCASaldoFavor
	 */
	public String getICASaldoFavor()
	{
		return ICASaldoFavor;
	}

	/**
	 * @param iCASaldoFavor
	 *           the iCASaldoFavor to set
	 */
	public void setICASaldoFavor(final String iCASaldoFavor)
	{
		ICASaldoFavor = iCASaldoFavor;
	}

	/**
	 * @return the vehicularSaldoCargo
	 */
	public String getVehicularSaldoCargo()
	{
		return VehicularSaldoCargo;
	}

	/**
	 * @param vehicularSaldoCargo
	 *           the vehicularSaldoCargo to set
	 */
	public void setVehicularSaldoCargo(final String vehicularSaldoCargo)
	{
		VehicularSaldoCargo = vehicularSaldoCargo;
	}

	/**
	 * @return the vehicularSaldoFavor
	 */
	public String getVehicularSaldoFavor()
	{
		return VehicularSaldoFavor;
	}

	/**
	 * @param vehicularSaldoFavor
	 *           the vehicularSaldoFavor to set
	 */
	public void setVehicularSaldoFavor(final String vehicularSaldoFavor)
	{
		VehicularSaldoFavor = vehicularSaldoFavor;
	}

	/**
	 * @return the delineacionSaldoCargo
	 */
	public String getDelineacionSaldoCargo()
	{
		return DelineacionSaldoCargo;
	}

	/**
	 * @param delineacionSaldoCargo
	 *           the delineacionSaldoCargo to set
	 */
	public void setDelineacionSaldoCargo(final String delineacionSaldoCargo)
	{
		DelineacionSaldoCargo = delineacionSaldoCargo;
	}

	/**
	 * @return the delineacionSaldoFavor
	 */
	public String getDelineacionSaldoFavor()
	{
		return DelineacionSaldoFavor;
	}

	/**
	 * @param delineacionSaldoFavor
	 *           the delineacionSaldoFavor to set
	 */
	public void setDelineacionSaldoFavor(final String delineacionSaldoFavor)
	{
		DelineacionSaldoFavor = delineacionSaldoFavor;
	}

	/**
	 * @return the gasolinaSaldoCargo
	 */
	public String getGasolinaSaldoCargo()
	{
		return GasolinaSaldoCargo;
	}

	/**
	 * @param gasolinaSaldoCargo
	 *           the gasolinaSaldoCargo to set
	 */
	public void setGasolinaSaldoCargo(final String gasolinaSaldoCargo)
	{
		GasolinaSaldoCargo = gasolinaSaldoCargo;
	}

	/**
	 * @return the gasolinaSaldoFavor
	 */
	public String getGasolinaSaldoFavor()
	{
		return GasolinaSaldoFavor;
	}

	/**
	 * @param gasolinaSaldoFavor
	 *           the gasolinaSaldoFavor to set
	 */
	public void setGasolinaSaldoFavor(final String gasolinaSaldoFavor)
	{
		GasolinaSaldoFavor = gasolinaSaldoFavor;
	}

	/**
	 * @return the publicidadSaldoCargo
	 */
	public String getPublicidadSaldoCargo()
	{
		return PublicidadSaldoCargo;
	}

	/**
	 * @param publicidadSaldoCargo
	 *           the publicidadSaldoCargo to set
	 */
	public void setPublicidadSaldoCargo(final String publicidadSaldoCargo)
	{
		PublicidadSaldoCargo = publicidadSaldoCargo;
	}

	/**
	 * @return the publicidadSaldoFavor
	 */
	public String getPublicidadSaldoFavor()
	{
		return PublicidadSaldoFavor;
	}

	/**
	 * @param publicidadSaldoFavor
	 *           the publicidadSaldoFavor to set
	 */
	public void setPublicidadSaldoFavor(final String publicidadSaldoFavor)
	{
		PublicidadSaldoFavor = publicidadSaldoFavor;
	}



	/**
	 * @return the predial
	 */
	public List<EdoCtaPredial> getPredial()
	{
		return predial;
	}

	/**
	 * @param predial
	 *           the predial to set
	 */
	public void setPredial(final List<EdoCtaPredial> predial)
	{
		this.predial = predial;
	}

	/**
	 * @return the tablaICA
	 */
	public List<EdoCtaIca> getTablaICA()
	{
		return tablaICA;
	}

	/**
	 * @param tablaICA
	 *           the tablaICA to set
	 */
	public void setTablaICA(final List<EdoCtaIca> tablaICA)
	{
		this.tablaICA = tablaICA;
	}

	/**
	 * @return the tablaVehicular
	 */
	public List<EdoCtaVehiculos> getTablaVehicular()
	{
		return tablaVehicular;
	}

	/**
	 * @param tablaVehicular
	 *           the tablaVehicular to set
	 */
	public void setTablaVehicular(final List<EdoCtaVehiculos> tablaVehicular)
	{
		this.tablaVehicular = tablaVehicular;
	}

	/**
	 * @return the tablaDelineacion
	 */
	public List<EdoCtaDeli> getTablaDelineacion()
	{
		return tablaDelineacion;
	}

	/**
	 * @param tablaDelineacion
	 *           the tablaDelineacion to set
	 */
	public void setTablaDelineacion(final List<EdoCtaDeli> tablaDelineacion)
	{
		this.tablaDelineacion = tablaDelineacion;
	}

	/**
	 * @return the tablaGasolina
	 */
	public List<EdoCtaGas> getTablaGasolina()
	{
		return tablaGasolina;
	}

	/**
	 * @param tablaGasolina
	 *           the tablaGasolina to set
	 */
	public void setTablaGasolina(final List<EdoCtaGas> tablaGasolina)
	{
		this.tablaGasolina = tablaGasolina;
	}

	/**
	 * @return the tablaPublicidad
	 */
	public List<EdoCtaPublicidad> getTablaPublicidad()
	{
		return tablaPublicidad;
	}

	/**
	 * @param tablaPublicidad
	 *           the tablaPublicidad to set
	 */
	public void setTablaPublicidad(final List<EdoCtaPublicidad> tablaPublicidad)
	{
		this.tablaPublicidad = tablaPublicidad;
	}



}
