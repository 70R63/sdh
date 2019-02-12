/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import java.util.List;
import java.util.Map;


/**
 * @author fede
 *
 */
public class SobreTasaGasolinaCatalogos
{

	private List<ItemSelectOption> opcionesCantidadMostrar;
	//	private List<ItemSelectOption> anioGravable;
	private Map<String, String> impuesto;
	private Map<String, String> anioGravable;
	private Map<String, String> periodo;
	private List<ItemSelectOption> calidadResponsable;
	private List<ItemSelectOption> codigoPostal;
	private List<ItemSelectOption> localidad;
	private Map<String, String> tipoId;
	private List<ItemSelectOption> tipoRelacion;
	private List<ItemSelectOption> fuenteDato;

	private Map<String, String> opcionesUso;
	private Map<String, String> claseProd;
	private Map<String, String> alcoholCarbu;
	private Map<String, String> tipoIdRev;
	private Map<String, String> tipoIdDec;

	/**
	 * @return the impuesto
	 */
	public Map<String, String> getImpuesto()
	{
		return impuesto;
	}

	/**
	 * @param impuesto
	 *           the impuesto to set
	 */
	public void setImpuesto(final Map<String, String> impuesto)
	{
		this.impuesto = impuesto;
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
	 * @return the opcionesCantidadMostrar
	 */
	public List<ItemSelectOption> getOpcionesCantidadMostrar()
	{
		return opcionesCantidadMostrar;
	}

	/**
	 * @param opcionesCantidadMostrar
	 *           the opcionesCantidadMostrar to set
	 */
	public void setOpcionesCantidadMostrar(final List<ItemSelectOption> opcionesCantidadMostrar)
	{
		this.opcionesCantidadMostrar = opcionesCantidadMostrar;
	}

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
	 * @return the periodo
	 */
	public Map<String, String> getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final Map<String, String> periodo)
	{
		this.periodo = periodo;
	}

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
	 * @return the tipoId
	 */
	public Map<String, String> getTipoId()
	{
		return tipoId;
	}

	/**
	 * @param tipoId
	 *           the tipoId to set
	 */
	public void setTipoId(final Map<String, String> tipoId)
	{
		this.tipoId = tipoId;
	}

	/**
	 * @return the tipoRelacion
	 */
	public List<ItemSelectOption> getTipoRelacion()
	{
		return tipoRelacion;
	}

	/**
	 * @param tipoRelacion
	 *           the tipoRelacion to set
	 */
	public void setTipoRelacion(final List<ItemSelectOption> tipoRelacion)
	{
		this.tipoRelacion = tipoRelacion;
	}

	/**
	 * @return the fuenteDato
	 */
	public List<ItemSelectOption> getFuenteDato()
	{
		return fuenteDato;
	}

	/**
	 * @param fuenteDato
	 *           the fuenteDato to set
	 */
	public void setFuenteDato(final List<ItemSelectOption> fuenteDato)
	{
		this.fuenteDato = fuenteDato;
	}




}
