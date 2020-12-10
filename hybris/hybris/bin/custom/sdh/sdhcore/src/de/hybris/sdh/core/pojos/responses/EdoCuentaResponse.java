/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class EdoCuentaResponse
{
	private String tasaInteres;
	private String newPredialSaldoCargo;
	private String newPredialSaldoFavor;
	private String newICASaldoCargo;
	private String newICASaldoFavor;
	private String newVehicularSaldoCargo;
	private String newVehicularSaldoFavor;
	private String newDelineacionSaldoCargo;
	private String newDelineacionSaldoFavor;
	private String newGasolinaSaldoCargo;
	private String newGasolinaSaldoFavor;
	private String newPublicidadSaldoCargo;
	private String newPublicidadSaldoFavor;
	private List<EdoCtaPredial> predial;
	private List<EdoCtaIca> tablaICA;
	private List<EdoCtaVehiculos> tablaVehicular;
	private List<EdoCtaDeli> tablaDelineacion;
	private List<EdoCtaGas> tablaGasolina;
	private List<EdoCtaPublicidad> tablaPublicidad;
	private List<EdoCtaOblig> obligNoTributaria;
	private List<EdoCtaReteIcaCabecera> reteica;
	private String newReteicaSaldoCargo;
	private String newReteicaSaldoFavor;



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
	 * @return the newPredialSaldoCargo
	 */
	public String getNewPredialSaldoCargo()
	{
		return newPredialSaldoCargo;
	}

	/**
	 * @param newPredialSaldoCargo
	 *           the newPredialSaldoCargo to set
	 */
	@JsonProperty("PredialSaldoCargo")
	public void setNewPredialSaldoCargo(final String newPredialSaldoCargo)
	{
		this.newPredialSaldoCargo = newPredialSaldoCargo;
	}

	/**
	 * @return the newPredialSaldoFavor
	 */
	public String getNewPredialSaldoFavor()
	{
		return newPredialSaldoFavor;
	}

	/**
	 * @param newPredialSaldoFavor
	 *           the newPredialSaldoFavor to set
	 */
	@JsonProperty("PredialSaldoFavor")
	public void setNewPredialSaldoFavor(final String newPredialSaldoFavor)
	{
		this.newPredialSaldoFavor = newPredialSaldoFavor;
	}

	/**
	 * @return the newICASaldoCargo
	 */
	public String getNewICASaldoCargo()
	{
		return newICASaldoCargo;
	}

	/**
	 * @param newICASaldoCargo
	 *           the newICASaldoCargo to set
	 */
	@JsonProperty("ICASaldoCargo")
	public void setNewICASaldoCargo(final String newICASaldoCargo)
	{
		this.newICASaldoCargo = newICASaldoCargo;
	}

	/**
	 * @return the newICASaldoFavor
	 */
	public String getNewICASaldoFavor()
	{
		return newICASaldoFavor;
	}

	/**
	 * @param newICASaldoFavor
	 *           the newICASaldoFavor to set
	 */
	@JsonProperty("ICASaldoFavor")
	public void setNewICASaldoFavor(final String newICASaldoFavor)
	{
		this.newICASaldoFavor = newICASaldoFavor;
	}

	/**
	 * @return the newVehicularSaldoCargo
	 */
	public String getNewVehicularSaldoCargo()
	{
		return newVehicularSaldoCargo;
	}

	/**
	 * @param newVehicularSaldoCargo
	 *           the newVehicularSaldoCargo to set
	 */
	@JsonProperty("VehicularSaldoCargo")
	public void setNewVehicularSaldoCargo(final String newVehicularSaldoCargo)
	{
		this.newVehicularSaldoCargo = newVehicularSaldoCargo;
	}

	/**
	 * @return the newVehicularSaldoFavor
	 */
	public String getNewVehicularSaldoFavor()
	{
		return newVehicularSaldoFavor;
	}

	/**
	 * @param newVehicularSaldoFavor
	 *           the newVehicularSaldoFavor to set
	 */
	@JsonProperty("VehicularSaldoFavor")
	public void setNewVehicularSaldoFavor(final String newVehicularSaldoFavor)
	{
		this.newVehicularSaldoFavor = newVehicularSaldoFavor;
	}

	/**
	 * @return the newDelineacionSaldoCargo
	 */
	public String getNewDelineacionSaldoCargo()
	{
		return newDelineacionSaldoCargo;
	}

	/**
	 * @param newDelineacionSaldoCargo
	 *           the newDelineacionSaldoCargo to set
	 */
	@JsonProperty("DelineacionSaldoCargo")
	public void setNewDelineacionSaldoCargo(final String newDelineacionSaldoCargo)
	{
		this.newDelineacionSaldoCargo = newDelineacionSaldoCargo;
	}

	/**
	 * @return the newDelineacionSaldoFavor
	 */
	public String getNewDelineacionSaldoFavor()
	{
		return newDelineacionSaldoFavor;
	}

	/**
	 * @param newDelineacionSaldoFavor
	 *           the newDelineacionSaldoFavor to set
	 */
	@JsonProperty("DelineacionSaldoFavor")
	public void setNewDelineacionSaldoFavor(final String newDelineacionSaldoFavor)
	{
		this.newDelineacionSaldoFavor = newDelineacionSaldoFavor;
	}

	/**
	 * @return the newGasolinaSaldoCargo
	 */
	public String getNewGasolinaSaldoCargo()
	{
		return newGasolinaSaldoCargo;
	}

	/**
	 * @param newGasolinaSaldoCargo
	 *           the newGasolinaSaldoCargo to set
	 */
	@JsonProperty("GasolinaSaldoCargo")
	public void setNewGasolinaSaldoCargo(final String newGasolinaSaldoCargo)
	{
		this.newGasolinaSaldoCargo = newGasolinaSaldoCargo;
	}

	/**
	 * @return the newGasolinaSaldoFavor
	 */
	public String getNewGasolinaSaldoFavor()
	{
		return newGasolinaSaldoFavor;
	}

	/**
	 * @param newGasolinaSaldoFavor
	 *           the newGasolinaSaldoFavor to set
	 */
	@JsonProperty("GasolinaSaldoFavor")
	public void setNewGasolinaSaldoFavor(final String newGasolinaSaldoFavor)
	{
		this.newGasolinaSaldoFavor = newGasolinaSaldoFavor;
	}

	/**
	 * @return the newPublicidadSaldoCargo
	 */
	public String getNewPublicidadSaldoCargo()
	{
		return newPublicidadSaldoCargo;
	}

	/**
	 * @param newPublicidadSaldoCargo
	 *           the newPublicidadSaldoCargo to set
	 */
	@JsonProperty("PublicidadSaldoCargo")
	public void setNewPublicidadSaldoCargo(final String newPublicidadSaldoCargo)
	{
		this.newPublicidadSaldoCargo = newPublicidadSaldoCargo;
	}

	/**
	 * @return the newPublicidadSaldoFavor
	 */
	public String getNewPublicidadSaldoFavor()
	{
		return newPublicidadSaldoFavor;
	}

	/**
	 * @param newPublicidadSaldoFavor
	 *           the newPublicidadSaldoFavor to set
	 */
	@JsonProperty("PublicidadSaldoFavor")
	public void setNewPublicidadSaldoFavor(final String newPublicidadSaldoFavor)
	{
		this.newPublicidadSaldoFavor = newPublicidadSaldoFavor;
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

	/**
	 * @return the obligNoTributaria
	 */
	public List<EdoCtaOblig> getObligNoTributaria()
	{
		return obligNoTributaria;
	}

	/**
	 * @param obligNoTributaria
	 *           the obligNoTributaria to set
	 */
	public void setObligNoTributaria(final List<EdoCtaOblig> obligNoTributaria)
	{
		this.obligNoTributaria = obligNoTributaria;
	}

	/**
	 * @return the reteica
	 */
	public List<EdoCtaReteIcaCabecera> getReteica()
	{
		return reteica;
	}

	/**
	 * @param reteica
	 *           the reteica to set
	 */
	public void setReteica(final List<EdoCtaReteIcaCabecera> reteica)
	{
		this.reteica = reteica;
	}

	/**
	 * @return the newReteicaSaldoCargo
	 */
	public String getNewReteicaSaldoCargo()
	{
		return newReteicaSaldoCargo;
	}

	/**
	 * @param newReteicaSaldoCargo
	 *           the newReteicaSaldoCargo to set
	 */
	@JsonProperty("ReteicaSaldoCargo")
	public void setNewReteicaSaldoCargo(final String newReteicaSaldoCargo)
	{
		this.newReteicaSaldoCargo = newReteicaSaldoCargo;
	}

	/**
	 * @return the newReteicaSaldoFavor
	 */
	public String getNewReteicaSaldoFavor()
	{
		return newReteicaSaldoFavor;
	}

	/**
	 * @param newReteicaSaldoFavor
	 *           the newReteicaSaldoFavor to set
	 */
	@JsonProperty("ReteicaSaldoFavor")
	public void setNewReteicaSaldoFavor(final String newReteicaSaldoFavor)
	{
		this.newReteicaSaldoFavor = newReteicaSaldoFavor;
	}




}
