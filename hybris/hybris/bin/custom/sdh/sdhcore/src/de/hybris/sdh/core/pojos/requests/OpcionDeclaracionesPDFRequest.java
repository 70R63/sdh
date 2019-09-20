/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class OpcionDeclaracionesPDFRequest
{
	private String bp;
	private String numObjeto;
	private String claseObjeto;
	private String anioGravable;
	private String periodo;
	private String radicado;

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
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
	}

	/**
	 * @return the claseObjeto
	 */
	public String getClaseObjeto()
	{
		return claseObjeto;
	}

	/**
	 * @param claseObjeto
	 *           the claseObjeto to set
	 */
	public void setClaseObjeto(final String claseObjeto)
	{
		this.claseObjeto = claseObjeto;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
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
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}

	/**
	 * @return the radicado
	 */
	public String getRadicado()
	{
		return radicado;
	}

	/**
	 * @param radicado
	 *           the radicado to set
	 */
	public void setRadicado(final String radicado)
	{
		this.radicado = radicado;
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
		stringBuilder.append(obtenerValorJson("\"numObjeto\":\"", this.getNumObjeto(), "\","));
		stringBuilder.append(obtenerValorJson("\"claseObjeto\":\"", this.getClaseObjeto(), "\","));
		stringBuilder.append(obtenerValorJson("\"anioGravable\":\"", this.getAnioGravable(), "\","));
		stringBuilder.append(obtenerValorJson("\"Periodo\":\"", this.getPeriodo(), "\","));
		stringBuilder.append(obtenerValorJson("\"Radicado\":\"", this.getRadicado(), "\""));
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
