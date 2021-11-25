/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.Concesionarios;

import java.util.List;


/**
 * @author Maria Luisa Torres
 *
 */
public class ConcesionariosForm
{
	private String referenceStatus;
	private List<Concesionarios> concesionarios;
	private String fecInio;

	/**
	 * @return the referenceStatus
	 */
	public String getReferenceStatus()
	{
		return referenceStatus;
	}

	/**
	 * @param referenceStatus
	 *           the referenceStatus to set
	 */
	public void setReferenceStatus(final String referenceStatus)
	{
		this.referenceStatus = referenceStatus;
	}

	/**
	 * @return the concesionarios
	 */
	public List<Concesionarios> getConcesionarios()
	{
		return concesionarios;
	}

	/**
	 * @param concesionarios
	 *           the concesionarios to set
	 */
	public void setConcesionarios(final List<Concesionarios> concesionarios)
	{
		this.concesionarios = concesionarios;
	}

	/**
	 * @return the fecInio
	 */
	public String getFecInio()
	{
		return fecInio;
	}

	/**
	 * @param fecInio
	 *           the fecInio to set
	 */
	public void setFecInio(final String fecInio)
	{
		this.fecInio = fecInio;
	}
}
