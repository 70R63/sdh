/**
 *
 */
package de.hybris.sdh.core.pojos.responses;


import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class TramitesSeleccionInfoVista
{

	private List<ItemSelectOption> opciones;
	private DocTramitesResponse docTramitesResponse;
	private String urlAccion;
	private String notas;

	/**
	 * @return the opciones
	 */
	public List<ItemSelectOption> getOpciones()
	{
		return opciones;
	}

	/**
	 * @param opciones
	 *           the opciones to set
	 */
	public void setOpciones(final List<ItemSelectOption> opciones)
	{
		this.opciones = opciones;
	}

	/**
	 * @return the docTramitesResponse
	 */
	public DocTramitesResponse getDocTramitesResponse()
	{
		return docTramitesResponse;
	}

	/**
	 * @param docTramitesResponse
	 *           the docTramitesResponse to set
	 */
	public void setDocTramitesResponse(final DocTramitesResponse docTramitesResponse)
	{
		this.docTramitesResponse = docTramitesResponse;
	}

	/**
	 * @return the urlAccion
	 */
	public String getUrlAccion()
	{
		return urlAccion;
	}

	/**
	 * @param urlAccion
	 *           the urlAccion to set
	 */
	public void setUrlAccion(final String urlAccion)
	{
		this.urlAccion = urlAccion;
	}

	/**
	 * @return the notas
	 */
	public String getNotas()
	{
		return notas;
	}

	/**
	 * @param notas
	 *           the notas to set
	 */
	public void setNotas(final String notas)
	{
		this.notas = notas;
	}



}
