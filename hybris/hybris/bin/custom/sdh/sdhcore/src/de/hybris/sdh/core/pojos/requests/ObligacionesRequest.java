/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class ObligacionesRequest
{
	private String bp;
	private String rango;
	private String objeto;





	/**
	 * @return the bp
	 */
	public String getBp()
	{
		return bp;
	}

	/**
	 * @param bp
	 *           the bp to set
	 */
	public void setBp(final String bp)
	{
		this.bp = bp;
	}

	/**
	 * @return the rango
	 */
	public String getRango()
	{
		return rango;
	}

	/**
	 * @param rango
	 *           the rango to set
	 */
	public void setRango(final String rango)
	{
		this.rango = rango;
	}

	/**
	 * @return the objeto
	 */
	public String getObjeto()
	{
		return objeto;
	}

	/**
	 * @param objeto
	 *           the objeto to set
	 */
	public void setObjeto(final String objeto)
	{
		this.objeto = objeto;
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;

		return valorVariable;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"bp\":\"", this.getBp(), "\","));
		stringBuilder.append(obtenerValorJson("\"rango\":\"", this.getRango(), "\","));
		stringBuilder.append(obtenerValorJson("\"objeto\":\"", this.getObjeto(), "\""));
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}
}
