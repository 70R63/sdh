/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DetallePredial2Response_infopredio
{
	private DetallePredial2Response_datosgenerales datosgenerales;

	/**
	 * @return the datosgenerales
	 */
	public DetallePredial2Response_datosgenerales getDatosgenerales()
	{
		return datosgenerales;
	}

	/**
	 * @param datosgenerales
	 *           the datosgenerales to set
	 */
	public void setDatosgenerales(final DetallePredial2Response_datosgenerales datosgenerales)
	{
		this.datosgenerales = datosgenerales;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetallePredial2Response_infopredio [datosgenerales=" + datosgenerales + "]";
	}


}
