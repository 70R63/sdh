/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Praxis
 *
 */
public class ConsultarBPRequest
{
	private String numid;
	private String tipoid;
	private String fechaExp;
	private String valida;




	/**
	 * @return the valida
	 */
	public String getValida()
	{
		return valida;
	}

	/**
	 * @param valida
	 *           the valida to set
	 */
	public void setValida(final String valida)
	{
		this.valida = valida;
	}

	/**
	 * @return the numid
	 */
	public String getNumid()
	{
		return numid;
	}

	/**
	 * @param numid
	 *           the numid to set
	 */
	public void setNumid(final String numid)
	{
		this.numid = numid;
	}

	/**
	 * @return the tipoid
	 */
	public String getTipoid()
	{
		return tipoid;
	}

	/**
	 * @param tipoid
	 *           the tipoid to set
	 */
	public void setTipoid(final String tipoid)
	{
		this.tipoid = tipoid;
	}



	/**
	 * @return the fechaExp
	 */
	public String getFechaExp()
	{
		return fechaExp;
	}

	/**
	 * @param fechaExp
	 *           the fechaExp to set
	 */
	public void setFechaExp(final String fechaExp)
	{
		this.fechaExp = fechaExp;
	}

	@Override
	public String toString()
	{
		//return "{ \"numid\":\"" + numid + "\", \"tipoid\":\"" + tipoid + "\", \"fechExp\":\"" + fechExp + "\", \"valida\":\""
		//		+ valida + "\" }";

		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"numid\":\"", numid, "\","));
		stringBuilder.append(obtenerValorJson("\"tipoid\":\"", tipoid, "\","));
		stringBuilder.append(obtenerValorJson("\"fechaExp\":\"", fechaExp, "\","));
		stringBuilder.append(obtenerValorJson("\"valida\":\"", valida, "\""));
		stringBuilder.append("}");

		return stringBuilder.toString();
	}


	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}






}
