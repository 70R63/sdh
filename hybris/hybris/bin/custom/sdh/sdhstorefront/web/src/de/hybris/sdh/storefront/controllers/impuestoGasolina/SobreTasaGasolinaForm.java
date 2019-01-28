/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.sdh.core.pojos.responses.DetGasResponse;

import java.util.List;


/**
 * @author Administrator
 *
 */
public class SobreTasaGasolinaForm
{
	private List<SobreTasaGasolinaTabla> listaDocumentos;
	private DetGasResponse dataForm;
	private SobreTasaGasolinaCatalogos catalogos;
	private String anioGravable;
	private String periodo;

	/**
	 * @return the listaDocumentos
	 */
	public List<SobreTasaGasolinaTabla> getListaDocumentos()
	{
		return listaDocumentos;
	}

	/**
	 * @param listaDocumentos
	 *           the listaDocumentos to set
	 */
	public void setListaDocumentos(final List<SobreTasaGasolinaTabla> listaDocumentos)
	{
		this.listaDocumentos = listaDocumentos;
	}

	/**
	 * @return the dataForm
	 */
	public DetGasResponse getDataForm()
	{
		return dataForm;
	}

	/**
	 * @param dataForm
	 *           the dataForm to set
	 */
	public void setDataForm(final DetGasResponse dataForm)
	{
		this.dataForm = dataForm;
	}

	/**
	 * @return the catalogos
	 */
	public SobreTasaGasolinaCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final SobreTasaGasolinaCatalogos catalogos)
	{
		this.catalogos = catalogos;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}


}
