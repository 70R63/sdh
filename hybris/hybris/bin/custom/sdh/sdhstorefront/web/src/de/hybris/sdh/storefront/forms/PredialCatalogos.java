/**
 *
 */
package de.hybris.sdh.storefront.forms;

import java.util.Map;


/**
 * @author Federico Flores Dimas
 *
 */
public class PredialCatalogos
{

	Map<String, String> caracterizacionPredio;
	Map<String, String> propiedadHorizontal;
	Map<String, String> destinoHacendario;
	
	/**
	 * @return the caracterizacionPredio
	 */
	public Map<String, String> getCaracterizacionPredio()
	{
		return caracterizacionPredio;
	}
	
	/**
	 * @param caracterizacionPredio
	 *           the caracterizacionPredio to set
	 */
	public void setCaracterizacionPredio(final Map<String, String> caracterizacionPredio)
	{
		this.caracterizacionPredio = caracterizacionPredio;
	}
	
	/**
	 * @return the propiedadHorizontal
	 */
	public Map<String, String> getPropiedadHorizontal()
	{
		return propiedadHorizontal;
	}
	
	/**
	 * @param propiedadHorizontal
	 *           the propiedadHorizontal to set
	 */
	public void setPropiedadHorizontal(final Map<String, String> propiedadHorizontal)
	{
		this.propiedadHorizontal = propiedadHorizontal;
	}
	
	/**
	 * @return the destinoHacendario
	 */
	public Map<String, String> getDestinoHacendario()
	{
		return destinoHacendario;
	}
	
	/**
	 * @param destinoHacendario
	 *           the destinoHacendario to set
	 */
	public void setDestinoHacendario(final Map<String, String> destinoHacendario)
	{
		this.destinoHacendario = destinoHacendario;
	}


}
