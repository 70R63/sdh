/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.sdh.core.pojos.responses.ItemSelectOption;

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


	private Map<String, String> tipoConsulta;

	//delineacion Urbana
	private Map<String, String> anoGravable;
	private Map<String, String> tipoDeLicencia;
	private Map<String, String> objetoLicencia;
	private Map<String, String> modalidadLicencia;
	private Map<String, String> presupuestoObra;
	private Map<String, String> causalExencion;
	private Map<String, String> uso;
	private Map<String, String> codUso;
	private Map<String, String> areaInter;
	private Map<String, String> areaProy;




	/**
	 * @return the uso
	 */
	public Map<String, String> getUso()
	{
		return uso;
	}

	/**
	 * @param uso
	 *           the uso to set
	 */
	public void setUso(final Map<String, String> uso)
	{
		this.uso = uso;
	}

	/**
	 * @return the codUso
	 */
	public Map<String, String> getCodUso()
	{
		return codUso;
	}

	/**
	 * @param codUso
	 *           the codUso to set
	 */
	public void setCodUso(final Map<String, String> codUso)
	{
		this.codUso = codUso;
	}

	/**
	 * @return the areaInter
	 */
	public Map<String, String> getAreaInter()
	{
		return areaInter;
	}

	/**
	 * @param areaInter
	 *           the areaInter to set
	 */
	public void setAreaInter(final Map<String, String> areaInter)
	{
		this.areaInter = areaInter;
	}

	/**
	 * @return the areaProy
	 */
	public Map<String, String> getAreaProy()
	{
		return areaProy;
	}

	/**
	 * @param areaProy
	 *           the areaProy to set
	 */
	public void setAreaProy(final Map<String, String> areaProy)
	{
		this.areaProy = areaProy;
	}

	/**
	 * @return the anoGravable
	 */
	public Map<String, String> getAnoGravable()
	{
		return anoGravable;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final Map<String, String> anoGravable)
	{
		this.anoGravable = anoGravable;
	}

	/**
	 * @return the tipoDeLicencia
	 */
	public Map<String, String> getTipoDeLicencia()
	{
		return tipoDeLicencia;
	}

	/**
	 * @param tipoDeLicencia
	 *           the tipoDeLicencia to set
	 */
	public void setTipoDeLicencia(final Map<String, String> tipoDeLicencia)
	{
		this.tipoDeLicencia = tipoDeLicencia;
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

	/**
	 * @return the tipoConsulta
	 */
	public Map<String, String> getTipoConsulta()
	{
		return tipoConsulta;
	}

	/**
	 * @param tipoConsulta
	 *           the tipoConsulta to set
	 */
	public void setTipoConsulta(final Map<String, String> tipoConsulta)
	{
		this.tipoConsulta = tipoConsulta;
	}

	/**
	 * @return the objetoLicencia
	 */
	public Map<String, String> getObjetoLicencia()
	{
		return objetoLicencia;
	}

	/**
	 * @param objetoLicencia
	 *           the objetoLicencia to set
	 */
	public void setObjetoLicencia(final Map<String, String> objetoLicencia)
	{
		this.objetoLicencia = objetoLicencia;
	}




}
