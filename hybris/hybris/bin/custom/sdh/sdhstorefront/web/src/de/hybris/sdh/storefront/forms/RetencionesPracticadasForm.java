/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbana;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;

import java.util.List;
import java.util.Map;


/**
 * @author Maria Torres
 *
 */
public class RetencionesPracticadasForm
{
	private Map<String, String> anioGravable;
	private String numBP;
	private String anio;

	/**
	 * @return the anioGravable
	 */
	public Map<String, String> getAnioGravable()
	{
		return anioGravable;
	}





	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final Map<String, String> anioGravable)
	{
		this.anioGravable = anioGravable;
	}





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
	 * @return the anio
	 */
	public String getAnio()
	{
		return anio;
	}





	/**
	 * @param anio
	 *           the anio to set
	 */
	public void setAnio(final String anio)
	{
		this.anio = anio;
	}





	private List<PredialResponse> predial;
	private List<ImpuestoVehiculos> vehicular;
	private ImpuestoICA impuestoICA;
	private List<ImpuestoGasolina> gasolina;
	private List<ImpuestoDelineacionUrbana> delineacion;
	private List<ImpuestoPublicidadExterior> publicidadExt;


	private String obKey;




	public RetencionesPracticadasForm()
	{

	}





	/**
	 * @return the predial
	 */
	public List<PredialResponse> getPredial()
	{
		return predial;
	}





	/**
	 * @param predial
	 *           the predial to set
	 */
	public void setPredial(final List<PredialResponse> predial)
	{
		this.predial = predial;
	}





	/**
	 * @return the vehicular
	 */
	public List<ImpuestoVehiculos> getVehicular()
	{
		return vehicular;
	}





	/**
	 * @param vehicular
	 *           the vehicular to set
	 */
	public void setVehicular(final List<ImpuestoVehiculos> vehicular)
	{
		this.vehicular = vehicular;
	}





	/**
	 * @return the impuestoICA
	 */
	public ImpuestoICA getImpuestoICA()
	{
		return impuestoICA;
	}





	/**
	 * @param impuestoICA
	 *           the impuestoICA to set
	 */
	public void setImpuestoICA(final ImpuestoICA impuestoICA)
	{
		this.impuestoICA = impuestoICA;
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
	 * @return the obKey
	 */
	public String getObKey()
	{
		return obKey;
	}





	/**
	 * @param obKey
	 *           the obKey to set
	 */
	public void setObKey(final String obKey)
	{
		this.obKey = obKey;
	}


}