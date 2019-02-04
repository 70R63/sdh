/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.CalcPublicidadResponse;
import de.hybris.sdh.core.pojos.responses.DetallePublicidadResponse;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class PublicidadGeneral
{
	private String numBP;
	private String anograv;
	private String numresol;
	private String tipoValla;
	private PublicidadForm detalleForm;
	private DetallePublicidadResponse detalleResponse;
	private DeclaPublicidadController declaracionForm;
	private CalcPublicidadResponse calculoResponse;
	private PublicidadExteriorCatalogos catalogos;
	private List<ImpuestoPublicidadExterior> publicidadExt;

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
	 * @return the anograv
	 */
	public String getAnograv()
	{
		return anograv;
	}

	/**
	 * @param anograv
	 *           the anograv to set
	 */
	public void setAnograv(final String anograv)
	{
		this.anograv = anograv;
	}

	/**
	 * @return the numresol
	 */
	public String getNumresol()
	{
		return numresol;
	}

	/**
	 * @param numresol
	 *           the numresol to set
	 */
	public void setNumresol(final String numresol)
	{
		this.numresol = numresol;
	}

	/**
	 * @return the tipoValla
	 */
	public String getTipoValla()
	{
		return tipoValla;
	}

	/**
	 * @param tipoValla
	 *           the tipoValla to set
	 */
	public void setTipoValla(final String tipoValla)
	{
		this.tipoValla = tipoValla;
	}

	/**
	 * @return the detalleForm
	 */
	public PublicidadForm getDetalleForm()
	{
		return detalleForm;
	}

	/**
	 * @param detalleForm
	 *           the detalleForm to set
	 */
	public void setDetalleForm(final PublicidadForm detalleForm)
	{
		this.detalleForm = detalleForm;
	}

	/**
	 * @return the detalleResponse
	 */
	public DetallePublicidadResponse getDetalleResponse()
	{
		return detalleResponse;
	}

	/**
	 * @param detalleResponse
	 *           the detalleResponse to set
	 */
	public void setDetalleResponse(final DetallePublicidadResponse detalleResponse)
	{
		this.detalleResponse = detalleResponse;
	}

	/**
	 * @return the declaracionForm
	 */
	public DeclaPublicidadController getDeclaracionForm()
	{
		return declaracionForm;
	}

	/**
	 * @param declaracionForm
	 *           the declaracionForm to set
	 */
	public void setDeclaracionForm(final DeclaPublicidadController declaracionForm)
	{
		this.declaracionForm = declaracionForm;
	}

	/**
	 * @return the calculoResponse
	 */
	public CalcPublicidadResponse getCalculoResponse()
	{
		return calculoResponse;
	}

	/**
	 * @param calculoResponse
	 *           the calculoResponse to set
	 */
	public void setCalculoResponse(final CalcPublicidadResponse calculoResponse)
	{
		this.calculoResponse = calculoResponse;
	}

	/**
	 * @return the catalogos
	 */
	public PublicidadExteriorCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final PublicidadExteriorCatalogos catalogos)
	{
		this.catalogos = catalogos;
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
