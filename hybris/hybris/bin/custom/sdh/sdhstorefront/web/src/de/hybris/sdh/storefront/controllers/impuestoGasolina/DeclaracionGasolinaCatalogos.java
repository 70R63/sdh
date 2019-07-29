/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.sdh.core.pojos.responses.ItemSelectOption;

import java.util.List;


/**
 * @author fede
 *
 */
public class DeclaracionGasolinaCatalogos
{

	private List<ItemSelectOption> anioGravable;
	private List<ItemSelectOption> periodo;
	private List<ItemSelectOption> opcionesUso;
	private List<ItemSelectOption> claseProducto;
	private List<ItemSelectOption> porcentajeAlc;
	private List<ItemSelectOption> tipoIdRev;
	private List<ItemSelectOption> tipoIdDec;

	/**
	 * @return the anioGravable
	 */
	public List<ItemSelectOption> getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final List<ItemSelectOption> anioGravable)
	{
		this.anioGravable = anioGravable;
	}

	/**
	 * @return the periodo
	 */
	public List<ItemSelectOption> getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final List<ItemSelectOption> periodo)
	{
		this.periodo = periodo;
	}

	/**
	 * @return the opcionesUso
	 */
	public List<ItemSelectOption> getOpcionesUso()
	{
		return opcionesUso;
	}

	/**
	 * @param opcionesUso
	 *           the opcionesUso to set
	 */
	public void setOpcionesUso(final List<ItemSelectOption> opcionesUso)
	{
		this.opcionesUso = opcionesUso;
	}

	/**
	 * @return the claseProducto
	 */
	public List<ItemSelectOption> getClaseProducto()
	{
		return claseProducto;
	}

	/**
	 * @param claseProducto
	 *           the claseProducto to set
	 */
	public void setClaseProducto(final List<ItemSelectOption> claseProducto)
	{
		this.claseProducto = claseProducto;
	}

	/**
	 * @return the porcentajeAlc
	 */
	public List<ItemSelectOption> getPorcentajeAlc()
	{
		return porcentajeAlc;
	}

	/**
	 * @param porcentajeAlc
	 *           the porcentajeAlc to set
	 */
	public void setPorcentajeAlc(final List<ItemSelectOption> porcentajeAlc)
	{
		this.porcentajeAlc = porcentajeAlc;
	}

	/**
	 * @return the tipoIdRev
	 */
	public List<ItemSelectOption> getTipoIdRev()
	{
		return tipoIdRev;
	}

	/**
	 * @param tipoIdRev
	 *           the tipoIdRev to set
	 */
	public void setTipoIdRev(final List<ItemSelectOption> tipoIdRev)
	{
		this.tipoIdRev = tipoIdRev;
	}

	/**
	 * @return the tipoIdDec
	 */
	public List<ItemSelectOption> getTipoIdDec()
	{
		return tipoIdDec;
	}

	/**
	 * @param tipoIdDec
	 *           the tipoIdDec to set
	 */
	public void setTipoIdDec(final List<ItemSelectOption> tipoIdDec)
	{
		this.tipoIdDec = tipoIdDec;
	}




}
