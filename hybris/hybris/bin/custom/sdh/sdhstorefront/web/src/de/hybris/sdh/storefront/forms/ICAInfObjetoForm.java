/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;


/**
 * @author Consultor
 *
 */
public class ICAInfObjetoForm
{
	private String documentType;
	private String documentNumber;
	private String completeName;

	private ICAInfObjetoResponse icaInfObjetoResponse;

	private ICADeclaracionCatalogos catalogos;

	/**
	 * @return the documentType
	 */
	public String getDocumentType()
	{
		return documentType;
	}

	/**
	 * @param documentType
	 *           the documentType to set
	 */
	public void setDocumentType(final String documentType)
	{
		this.documentType = documentType;
	}

	/**
	 * @return the documentNumber
	 */
	public String getDocumentNumber()
	{
		return documentNumber;
	}

	/**
	 * @param documentNumber
	 *           the documentNumber to set
	 */
	public void setDocumentNumber(final String documentNumber)
	{
		this.documentNumber = documentNumber;
	}

	/**
	 * @return the completeName
	 */
	public String getCompleteName()
	{
		return completeName;
	}

	/**
	 * @param completeName
	 *           the completeName to set
	 */
	public void setCompleteName(final String completeName)
	{
		this.completeName = completeName;
	}

	/**
	 * @return the icaInfObjetoResponse
	 */
	public ICAInfObjetoResponse getIcaInfObjetoResponse()
	{
		return icaInfObjetoResponse;
	}

	/**
	 * @param icaInfObjetoResponse
	 *           the icaInfObjetoResponse to set
	 */
	public void setIcaInfObjetoResponse(final ICAInfObjetoResponse icaInfObjetoResponse)
	{
		this.icaInfObjetoResponse = icaInfObjetoResponse;
	}

	/**
	 * @return the catalogos
	 */
	public ICADeclaracionCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final ICADeclaracionCatalogos catalogos)
	{
		this.catalogos = catalogos;
	}


}
