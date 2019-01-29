/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import java.util.Map;


/**
 * @author Administrator
 *
 */
public class DetGasCatalogos
{

	Map<String, String> opcionesUso;
	Map<String, String> claseProd;
	Map<String, String> alcoholCarbu;
	Map<String, String> tipoIdRev;
	Map<String, String> tipoIdDec;
	/**
	 * @return the opcionesUso
	 */
	public Map<String, String> getOpcionesUso()
	{
		return opcionesUso;
	}
	
	/**
	 * @param opcionesUso
	 *           the opcionesUso to set
	 */
	public void setOpcionesUso(final Map<String, String> opcionesUso)
	{
		this.opcionesUso = opcionesUso;
	}
	/**
	 * @return the claseProd
	 */
	public Map<String, String> getClaseProd()
	{
		return claseProd;
	}
	
	/**
	 * @param claseProd
	 *           the claseProd to set
	 */
	public void setClaseProd(final Map<String, String> claseProd)
	{
		this.claseProd = claseProd;
	}
	/**
	 * @return the alcoholCarbu
	 */
	public Map<String, String> getAlcoholCarbu()
	{
		return alcoholCarbu;
	}
	
	/**
	 * @param alcoholCarbu
	 *           the alcoholCarbu to set
	 */
	public void setAlcoholCarbu(final Map<String, String> alcoholCarbu)
	{
		this.alcoholCarbu = alcoholCarbu;
	}
	/**
	 * @return the tipoIdRev
	 */
	public Map<String, String> getTipoIdRev()
	{
		return tipoIdRev;
	}
	
	/**
	 * @param tipoIdRev
	 *           the tipoIdRev to set
	 */
	public void setTipoIdRev(final Map<String, String> tipoIdRev)
	{
		this.tipoIdRev = tipoIdRev;
	}
	/**
	 * @return the tipoIdDec
	 */
	public Map<String, String> getTipoIdDec()
	{
		return tipoIdDec;
	}
	
	/**
	 * @param tipoIdDec
	 *           the tipoIdDec to set
	 */
	public void setTipoIdDec(final Map<String, String> tipoIdDec)
	{
		this.tipoIdDec = tipoIdDec;
	}



}
