/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class DetallePredialRequest
{
	private String numBP;
	private String CHIP;
	private String matrInmobiliaria;
	private String anioGravable;
	private String marca;

	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
	}

	/**
	 * @return the cHIP
	 */
	public String getCHIP()
	{
		return CHIP;
	}

	/**
	 * @param cHIP
	 *           the cHIP to set
	 */
	public void setCHIP(final String cHIP)
	{
		CHIP = cHIP;
	}

	/**
	 * @return the matrInmobiliaria
	 */
	public String getMatrInmobiliaria()
	{
		return matrInmobiliaria;
	}

	/**
	 * @param matrInmobiliaria
	 *           the matrInmobiliaria to set
	 */
	public void setMatrInmobiliaria(final String matrInmobiliaria)
	{
		this.matrInmobiliaria = matrInmobiliaria;
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
	 * @return the marca
	 */
	public String getMarca()
	{
		return marca;
	}

	/**
	 * @param marca
	 *           the marca to set
	 */
	public void setMarca(final String marca)
	{
		this.marca = marca;
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
		stringBuilder.append(obtenerValorJson("\"numBP\":\"", this.getNumBP(), "\","));
		stringBuilder.append(obtenerValorJson("\"CHIP\":\"", this.getCHIP(), "\","));
		stringBuilder.append(obtenerValorJson("\"matrInmobiliaria\":\"", this.getMatrInmobiliaria(), "\","));
		stringBuilder.append(obtenerValorJson("\"anioGravable\":\"", this.getAnioGravable(), "\","));
		stringBuilder.append(obtenerValorJson("\"marca\":\"", this.getMarca(), "\""));
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}




}
