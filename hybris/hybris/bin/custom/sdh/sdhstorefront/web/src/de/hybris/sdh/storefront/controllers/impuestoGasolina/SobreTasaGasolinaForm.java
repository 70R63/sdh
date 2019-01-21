/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import java.util.List;


/**
 * @author fede
 *
 */
public class SobreTasaGasolinaForm
{

	private List<ItemSelectOption> calidadResponsable;
	private String numeroTanques;
	private String capaciadAlmacProd;
	private String capaciadAlmacTanques;
	private String ubicacionPlantaAbasto;
	private List<ItemSelectOption> codigoPostal;
	private List<ItemSelectOption> localidad;
	private List<RepresentanteSGasolina> representantes;



	/**
	 * @return the calidadResponsable
	 */
	public List<ItemSelectOption> getCalidadResponsable()
	{
		return calidadResponsable;
	}
	
	/**
	 * @param calidadResponsable
	 *           the calidadResponsable to set
	 */
	public void setCalidadResponsable(final List<ItemSelectOption> calidadResponsable)
	{
		this.calidadResponsable = calidadResponsable;
	}
	/**
	 * @return the numeroTanques
	 */
	public String getNumeroTanques()
	{
		return numeroTanques;
	}
	
	/**
	 * @param numeroTanques
	 *           the numeroTanques to set
	 */
	public void setNumeroTanques(final String numeroTanques)
	{
		this.numeroTanques = numeroTanques;
	}
	/**
	 * @return the capaciadAlmacProd
	 */
	public String getCapaciadAlmacProd()
	{
		return capaciadAlmacProd;
	}
	
	/**
	 * @param capaciadAlmacProd
	 *           the capaciadAlmacProd to set
	 */
	public void setCapaciadAlmacProd(final String capaciadAlmacProd)
	{
		this.capaciadAlmacProd = capaciadAlmacProd;
	}
	/**
	 * @return the capaciadAlmacTanques
	 */
	public String getCapaciadAlmacTanques()
	{
		return capaciadAlmacTanques;
	}
	
	/**
	 * @param capaciadAlmacTanques
	 *           the capaciadAlmacTanques to set
	 */
	public void setCapaciadAlmacTanques(final String capaciadAlmacTanques)
	{
		this.capaciadAlmacTanques = capaciadAlmacTanques;
	}
	/**
	 * @return the ubicacionPlantaAbasto
	 */
	public String getUbicacionPlantaAbasto()
	{
		return ubicacionPlantaAbasto;
	}
	
	/**
	 * @param ubicacionPlantaAbasto
	 *           the ubicacionPlantaAbasto to set
	 */
	public void setUbicacionPlantaAbasto(final String ubicacionPlantaAbasto)
	{
		this.ubicacionPlantaAbasto = ubicacionPlantaAbasto;
	}
	/**
	 * @return the codigoPostal
	 */
	public List<ItemSelectOption> getCodigoPostal()
	{
		return codigoPostal;
	}
	
	/**
	 * @param codigoPostal
	 *           the codigoPostal to set
	 */
	public void setCodigoPostal(final List<ItemSelectOption> codigoPostal)
	{
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return the localidad
	 */
	public List<ItemSelectOption> getLocalidad()
	{
		return localidad;
	}
	
	/**
	 * @param localidad
	 *           the localidad to set
	 */
	public void setLocalidad(final List<ItemSelectOption> localidad)
	{
		this.localidad = localidad;
	}
	
	/**
	 * @return the representantes
	 */
	public List<RepresentanteSGasolina> getRepresentantes()
	{
		return representantes;
	}
	
	/**
	 * @param representantes
	 *           the representantes to set
	 */
	public void setRepresentantes(final List<RepresentanteSGasolina> representantes)
	{
		this.representantes = representantes;
	}


}
