/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class RadicaDelinResponse
{

	private List<DetRadicadosResponse> radicados;


	/**
	 * @return the radicados
	 */
	public List<DetRadicadosResponse> getRadicados()
	{
		return radicados;
	}


	/**
	 * @param radicados
	 *           the radicados to set
	 */
	public void setRadicados(final List<DetRadicadosResponse> radicados)
	{
		this.radicados = radicados;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RadicaDelinResponse [radicados=" + radicados + "]";
	}






}
