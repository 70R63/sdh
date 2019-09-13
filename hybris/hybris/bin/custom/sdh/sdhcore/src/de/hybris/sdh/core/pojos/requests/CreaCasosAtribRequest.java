/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class CreaCasosAtribRequest
{
	private String linea;
	private String identificador;
	private String valor;



	/**
	 * @return the linea
	 */
	public String getLinea()
	{
		return linea;
	}

	/**
	 * @param linea
	 *           the linea to set
	 */
	public void setLinea(final String linea)
	{
		this.linea = linea;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador()
	{
		return identificador;
	}

	/**
	 * @param identificador
	 *           the identificador to set
	 */
	public void setIdentificador(final String identificador)
	{
		this.identificador = identificador;
	}

	/**
	 * @return the valor
	 */
	public String getValor()
	{
		return valor;
	}

	/**
	 * @param valor
	 *           the valor to set
	 */
	public void setValor(final String valor)
	{
		this.valor = valor;
	}





	/**
	 *
	 */
	public CreaCasosAtribRequest()
	{
		super();
	}

	/**
	 * @param linea
	 * @param identificador
	 * @param valor
	 */
	public CreaCasosAtribRequest(final String linea, final String identificador, final String valor)
	{
		super();
		this.linea = linea;
		this.identificador = identificador;
		this.valor = valor;
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

		//		stringBuilder.append("{");
		stringBuilder.append("\"linea\":\"" + this.getLinea() + "\",");
		stringBuilder.append("\"identificador\":\"" + this.getIdentificador() + "\",");
		stringBuilder.append("\"valor\":\"" + this.getValor() + "\"");
		//		stringBuilder.append("}");


		return stringBuilder.toString();
	}


}
