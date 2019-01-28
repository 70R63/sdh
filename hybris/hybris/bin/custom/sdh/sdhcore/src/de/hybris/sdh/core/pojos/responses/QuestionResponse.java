/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class QuestionResponse
{
	private String idPreg;
	private String consecutivo;
	private String textoResp;
	private String indicador;

	/**
	 * @return the idPreg
	 */
	public String getIdPreg()
	{
		return idPreg;
	}

	/**
	 * @param idPreg
	 *           the idPreg to set
	 */
	public void setIdPreg(final String idPreg)
	{
		this.idPreg = idPreg;
	}

	/**
	 * @return the consecutivo
	 */
	public String getConsecutivo()
	{
		return consecutivo;
	}

	/**
	 * @param consecutivo
	 *           the consecutivo to set
	 */
	public void setConsecutivo(final String consecutivo)
	{
		this.consecutivo = consecutivo;
	}

	/**
	 * @return the textoResp
	 */
	public String getTextoResp()
	{
		return textoResp;
	}

	/**
	 * @param textoResp
	 *           the textoResp to set
	 */
	public void setTextoResp(final String textoResp)
	{
		this.textoResp = textoResp;
	}

	/**
	 * @return the indicador
	 */
	public String getIndicador()
	{
		return indicador;
	}

	/**
	 * @param indicador
	 *           the indicador to set
	 */
	public void setIndicador(final String indicador)
	{
		this.indicador = indicador;
	}


	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"idPreg\":\"" + this.getIdPreg() + "\",");
		stringBuilder.append("\"consecutivo\":\"" + this.getConsecutivo() + "\",");
		stringBuilder.append("\"textoResp\":\"" + this.getTextoResp() + "\",");
		stringBuilder.append("\"indicador\":\"" + this.getIndicador() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}
