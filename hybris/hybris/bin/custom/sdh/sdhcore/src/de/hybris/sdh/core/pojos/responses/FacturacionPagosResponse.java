/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Praxis
 *
 */
public class FacturacionPagosResponse
{
	private ResponseVehicular responseVehicular;
	private ResponsePredial responsePredial;


	/**
	 * @return the responseVehicular
	 */
	public ResponseVehicular getResponseVehicular()
	{
		return responseVehicular;
	}

	/**
	 * @param responseVehicular
	 *           the responseVehicular to set
	 */
	@JsonSetter("ResponseVehicular")
	public void setResponseVehicular(final ResponseVehicular responseVehicular)
	{
		this.responseVehicular = responseVehicular;
	}

	/**
	 * @return the responsePredial
	 */
	public ResponsePredial getResponsePredial()
	{
		return responsePredial;
	}

	/**
	 * @param responsePredial
	 *           the responsePredial to set
	 */
	@JsonSetter("ResponsePredial")
	public void setResponsePredial(final ResponsePredial responsePredial)
	{
		this.responsePredial = responsePredial;
	}

	@Override
	public String toString()
	{

		return "FacturacionPagosResponse [responseVehicular=" + responseVehicular + ", responsePredial=" + responsePredial + "]";

	}






}
