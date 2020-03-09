/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class VehicularCilindrajeResponse
{

	private String cilindraje;

	/**
	 * @return the cilindraje
	 */
	public String getCilindraje()
	{
		return cilindraje;
	}

	/**
	 * @param cilindraje
	 *           the cilindraje to set
	 */
	public void setCilindraje(final String cilindraje)
	{
		this.cilindraje = cilindraje;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "VehicularCilindrajeResponse [cilindraje=" + cilindraje + "]";
	}


}
