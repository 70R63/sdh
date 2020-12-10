/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.EdoCtaDeli;
import de.hybris.sdh.core.pojos.responses.EdoCtaGas;
import de.hybris.sdh.core.pojos.responses.EdoCtaIca;
import de.hybris.sdh.core.pojos.responses.EdoCtaOblig;
import de.hybris.sdh.core.pojos.responses.EdoCtaPredial;
import de.hybris.sdh.core.pojos.responses.EdoCtaPublicidad;
import de.hybris.sdh.core.pojos.responses.EdoCtaReteIcaCabecera;
import de.hybris.sdh.core.pojos.responses.EdoCtaVehiculos;
import de.hybris.sdh.core.pojos.responses.ReteICA;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class EdoCuentaForm
{

	private String compleName;
	private String numBP;
	private String tipoDoc;
	private String numDoc;
	private String tasaInteres;
	private String predialSaldoCargo;
	private String predialSaldoFavor;
	private String iCASaldoCargo;
	private String iCASaldoFavor;
	private String vehicularSaldoCargo;
	private String vehicularSaldoFavor;
	private String delineacionSaldoCargo;
	private String delineacionSaldoFavor;
	private String gasolinaSaldoCargo;
	private String gasolinaSaldoFavor;
	private String publicidadSaldoCargo;
	private String publicidadSaldoFavor;
	private List<EdoCtaPredial> predial;
	private List<EdoCtaIca> tablaICA;
	private List<EdoCtaVehiculos> tablaVehicular;
	private List<EdoCtaDeli> tablaDelineacion;
	private List<EdoCtaGas> tablaGasolina;
	private List<EdoCtaPublicidad> tablaPublicidad;
	private List<EdoCtaOblig> obligNoTributaria;
	private String fechageneracion;
	private ReteICA tablaReteica;

	private List<EdoCtaReteIcaCabecera> reteica;

	private String reteicaSaldoCargo;
	private String reteicaSaldoFavor;



	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc()
	{
		return tipoDoc;
	}

	/**
	 * @param tipoDoc
	 *           the tipoDoc to set
	 */
	public void setTipoDoc(final String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}

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
		return predialSaldoCargo;
	}

	/**
	 * @param predialSaldoCargo
	 *           the predialSaldoCargo to set
	 */
	public void setPredialSaldoCargo(final String predialSaldoCargo)
	{
		this.predialSaldoCargo = predialSaldoCargo;
	}

	/**
	 * @return the predialSaldoFavor
	 */
	public String getPredialSaldoFavor()
	{
		return predialSaldoFavor;
	}

	/**
	 * @param predialSaldoFavor
	 *           the predialSaldoFavor to set
	 */
	public void setPredialSaldoFavor(final String predialSaldoFavor)
	{
		this.predialSaldoFavor = predialSaldoFavor;
	}

	/**
	 * @return the iCASaldoCargo
	 */
	public String getiCASaldoCargo()
	{
		return iCASaldoCargo;
	}

	/**
	 * @param iCASaldoCargo
	 *           the iCASaldoCargo to set
	 */
	public void setiCASaldoCargo(final String iCASaldoCargo)
	{
		this.iCASaldoCargo = iCASaldoCargo;
	}

	/**
	 * @return the iCASaldoFavor
	 */
	public String getiCASaldoFavor()
	{
		return iCASaldoFavor;
	}

	/**
	 * @param iCASaldoFavor
	 *           the iCASaldoFavor to set
	 */
	public void setiCASaldoFavor(final String iCASaldoFavor)
	{
		this.iCASaldoFavor = iCASaldoFavor;
	}

	/**
	 * @return the vehicularSaldoCargo
	 */
	public String getVehicularSaldoCargo()
	{
		return vehicularSaldoCargo;
	}

	/**
	 * @param vehicularSaldoCargo
	 *           the vehicularSaldoCargo to set
	 */
	public void setVehicularSaldoCargo(final String vehicularSaldoCargo)
	{
		this.vehicularSaldoCargo = vehicularSaldoCargo;
	}

	/**
	 * @return the vehicularSaldoFavor
	 */
	public String getVehicularSaldoFavor()
	{
		return vehicularSaldoFavor;
	}

	/**
	 * @param vehicularSaldoFavor
	 *           the vehicularSaldoFavor to set
	 */
	public void setVehicularSaldoFavor(final String vehicularSaldoFavor)
	{
		this.vehicularSaldoFavor = vehicularSaldoFavor;
	}

	/**
	 * @return the delineacionSaldoCargo
	 */
	public String getDelineacionSaldoCargo()
	{
		return delineacionSaldoCargo;
	}

	/**
	 * @param delineacionSaldoCargo
	 *           the delineacionSaldoCargo to set
	 */
	public void setDelineacionSaldoCargo(final String delineacionSaldoCargo)
	{
		this.delineacionSaldoCargo = delineacionSaldoCargo;
	}

	/**
	 * @return the delineacionSaldoFavor
	 */
	public String getDelineacionSaldoFavor()
	{
		return delineacionSaldoFavor;
	}

	/**
	 * @param delineacionSaldoFavor
	 *           the delineacionSaldoFavor to set
	 */
	public void setDelineacionSaldoFavor(final String delineacionSaldoFavor)
	{
		this.delineacionSaldoFavor = delineacionSaldoFavor;
	}

	/**
	 * @return the gasolinaSaldoCargo
	 */
	public String getGasolinaSaldoCargo()
	{
		return gasolinaSaldoCargo;
	}

	/**
	 * @param gasolinaSaldoCargo
	 *           the gasolinaSaldoCargo to set
	 */
	public void setGasolinaSaldoCargo(final String gasolinaSaldoCargo)
	{
		this.gasolinaSaldoCargo = gasolinaSaldoCargo;
	}

	/**
	 * @return the gasolinaSaldoFavor
	 */
	public String getGasolinaSaldoFavor()
	{
		return gasolinaSaldoFavor;
	}

	/**
	 * @param gasolinaSaldoFavor
	 *           the gasolinaSaldoFavor to set
	 */
	public void setGasolinaSaldoFavor(final String gasolinaSaldoFavor)
	{
		this.gasolinaSaldoFavor = gasolinaSaldoFavor;
	}

	/**
	 * @return the publicidadSaldoCargo
	 */
	public String getPublicidadSaldoCargo()
	{
		return publicidadSaldoCargo;
	}

	/**
	 * @param publicidadSaldoCargo
	 *           the publicidadSaldoCargo to set
	 */
	public void setPublicidadSaldoCargo(final String publicidadSaldoCargo)
	{
		this.publicidadSaldoCargo = publicidadSaldoCargo;
	}

	/**
	 * @return the publicidadSaldoFavor
	 */
	public String getPublicidadSaldoFavor()
	{
		return publicidadSaldoFavor;
	}

	/**
	 * @param publicidadSaldoFavor
	 *           the publicidadSaldoFavor to set
	 */
	public void setPublicidadSaldoFavor(final String publicidadSaldoFavor)
	{
		this.publicidadSaldoFavor = publicidadSaldoFavor;
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
	 * @return the compleName
	 */
	public String getCompleName()
	{
		return compleName;
	}

	/**
	 * @param compleName the compleName to set
	 */
	public void setCompleName(final String compleName)
	{
		this.compleName = compleName;
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
	 * @return the fechageneracion
	 */
	public String getFechageneracion()
	{
		return fechageneracion;
	}

	/**
	 * @param fechageneracion
	 *           the fechageneracion to set
	 */
	public void setFechageneracion(final String fechageneracion)
	{
		this.fechageneracion = fechageneracion;
	}

	/**
	 * @return the tablaReteica
	 */
	public ReteICA getTablaReteica()
	{
		return tablaReteica;
	}

	/**
	 * @param tablaReteica
	 *           the tablaReteica to set
	 */
	public void setTablaReteica(final ReteICA tablaReteica)
	{
		this.tablaReteica = tablaReteica;
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
	 * @return the reteicaSaldoCargo
	 */
	public String getReteicaSaldoCargo()
	{
		return reteicaSaldoCargo;
	}

	/**
	 * @param reteicaSaldoCargo
	 *           the reteicaSaldoCargo to set
	 */
	public void setReteicaSaldoCargo(final String reteicaSaldoCargo)
	{
		this.reteicaSaldoCargo = reteicaSaldoCargo;
	}

	/**
	 * @return the reteicaSaldoFavor
	 */
	public String getReteicaSaldoFavor()
	{
		return reteicaSaldoFavor;
	}

	/**
	 * @param reteicaSaldoFavor
	 *           the reteicaSaldoFavor to set
	 */
	public void setReteicaSaldoFavor(final String reteicaSaldoFavor)
	{
		this.reteicaSaldoFavor = reteicaSaldoFavor;
	}



}
