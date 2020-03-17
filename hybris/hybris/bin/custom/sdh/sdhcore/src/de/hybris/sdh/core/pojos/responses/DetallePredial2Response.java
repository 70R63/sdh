/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class DetallePredial2Response
{
	private DetallePredial2Response_infopredio infopredio;
	private List<FirmanteResponse> firmantes;

	/**
	 * @return the infopredio
	 */
	public DetallePredial2Response_infopredio getInfopredio()
	{
		return infopredio;
	}
	
	/**
	 * @param infopredio
	 *           the infopredio to set
	 */
	public void setInfopredio(final DetallePredial2Response_infopredio infopredio)
	{
		this.infopredio = infopredio;
	}
	
	/**
	 * @return the firmantes
	 */
	public List<FirmanteResponse> getFirmantes()
	{
		return firmantes;
	}
	
	/**
	 * @param firmantes
	 *           the firmantes to set
	 */
	public void setFirmantes(final List<FirmanteResponse> firmantes)
	{
		this.firmantes = firmantes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetallePredial2Response [infopredio=" + infopredio + ", firmantes=" + firmantes + "]";
	}



}
