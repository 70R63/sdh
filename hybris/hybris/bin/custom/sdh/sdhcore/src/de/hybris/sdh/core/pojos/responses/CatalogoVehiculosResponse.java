/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class CatalogoVehiculosResponse
{
	private List<VehicularLineaResponse> vehicularlinearesponse;
	private List<VehicularCilindrajeResponse> vehicularcilindrajeresponse;
	private String avaluoactual;


	/**
	 * @return the vehicularlinearesponse
	 */
	public List<VehicularLineaResponse> getVehicularlinearesponse()
	{
		return vehicularlinearesponse;
	}
	
	/**
	 * @param vehicularlinearesponse
	 *           the vehicularlinearesponse to set
	 */
	public void setVehicularlinearesponse(final List<VehicularLineaResponse> vehicularlinearesponse)
	{
		this.vehicularlinearesponse = vehicularlinearesponse;
	}
	
	/**
	 * @return the vehicularcilindrajeresponse
	 */
	public List<VehicularCilindrajeResponse> getVehicularcilindrajeresponse()
	{
		return vehicularcilindrajeresponse;
	}
	
	/**
	 * @param vehicularcilindrajeresponse
	 *           the vehicularcilindrajeresponse to set
	 */
	public void setVehicularcilindrajeresponse(final List<VehicularCilindrajeResponse> vehicularcilindrajeresponse)
	{
		this.vehicularcilindrajeresponse = vehicularcilindrajeresponse;
	}
	
	/**
	 * @return the avaluoactual
	 */
	public String getAvaluoactual()
	{
		return avaluoactual;
	}
	
	/**
	 * @param avaluoactual
	 *           the avaluoactual to set
	 */
	public void setAvaluoactual(final String avaluoactual)
	{
		this.avaluoactual = avaluoactual;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CatalogoVehiculosResponse [vehicularlinearesponse=" + vehicularlinearesponse + ", vehicularcilindrajeresponse="
				+ vehicularcilindrajeresponse + ", avaluoactual=" + avaluoactual + "]";
	}




}
