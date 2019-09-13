/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Maria Luisa Torres
 *
 */
public class ObligacionesCabeceraDeli
{

	private String anioGravable;
	private String cdu;
	private String chip;
	private String direccion;
	private ObligacionesDetallePublicidad details;
	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @return the cdu
	 */
	public String getCdu()
	{
		return cdu;
	}

	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}
	/**
	 * @return the details
	 */
	public ObligacionesDetallePublicidad getDetails()
	{
		return details;
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
	 * @param cdu
	 *           the cdu to set
	 */
	public void setCdu(final String cdu)
	{
		this.cdu = cdu;
	}

	/**
	 * @param chip
	 *           the chip to set
	 */
	public void setChip(final String chip)
	{
		this.chip = chip;
	}

	/**
	 * @param details
	 *           the details to set
	 */
	public void setDetails(final ObligacionesDetallePublicidad details)
	{
		this.details = details;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final String direccion)
	{
		this.direccion = direccion;
	}


}
