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


/**
 * @author Praxis
 *
 */
public class RelacionPagosForm
{

	private List<PredialResponse> predial;
	private List<ImpuestoVehiculos> vehicular;
	private ImpuestoICA impuestoICA;
	private List<ImpuestoGasolina> gasolina;
	private List<ImpuestoDelineacionUrbana> delineacion;
	private List<ImpuestoPublicidadExterior> publicidadExt;





	public RelacionPagosForm()
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





}
