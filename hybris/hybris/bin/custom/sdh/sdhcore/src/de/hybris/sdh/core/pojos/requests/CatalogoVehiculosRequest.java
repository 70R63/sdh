/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class CatalogoVehiculosRequest
{
	private String clase;
	private String cilindraje;
	private String marca;
	private String linea;
	private String modelo;
	private String carroceria;
	private String campo_catalogo;

	/**
	 * @return the clase
	 */
	public String getClase()
	{
		return clase;
	}

	/**
	 * @param clase
	 *           the clase to set
	 */
	public void setClase(final String clase)
	{
		this.clase = clase;
	}

	/**
	 * @return the cilindraje
	 */
	public String getCilindraje()
	{
		return cilindraje;
	}

	/**
	 * @param cilindraje
	 *           the cilindraje to set
	 */
	public void setCilindraje(final String cilindraje)
	{
		this.cilindraje = cilindraje;
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
	 * @return the modelo
	 */
	public String getModelo()
	{
		return modelo;
	}

	/**
	 * @param modelo
	 *           the modelo to set
	 */
	public void setModelo(final String modelo)
	{
		this.modelo = modelo;
	}

	/**
	 * @return the carroceria
	 */
	public String getCarroceria()
	{
		return carroceria;
	}

	/**
	 * @param carroceria
	 *           the carroceria to set
	 */
	public void setCarroceria(final String carroceria)
	{
		this.carroceria = carroceria;
	}

	/**
	 * @return the campo_catalogo
	 */
	public String getCampo_catalogo()
	{
		return campo_catalogo;
	}

	/**
	 * @param campo_catalogo
	 *           the campo_catalogo to set
	 */
	public void setCampo_catalogo(final String campo_catalogo)
	{
		this.campo_catalogo = campo_catalogo;
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

		switch (this.getCampo_catalogo())
		{
			case "linea":
				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"marca\":\"", this.getMarca(), "\""));
				stringBuilder.append("}");
				break;

			case "cilindraje":
				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"marca\":\"", this.getMarca(), "\","));
				stringBuilder.append(obtenerValorJson("\"linea\":\"", this.getLinea(), "\","));
				stringBuilder.append(obtenerValorJson("\"modelo\":\"", this.getModelo(), "\""));
				stringBuilder.append("}");
				break;

			case "avaluo":
				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"clase\":\"", this.getClase(), "\","));
				stringBuilder.append(obtenerValorJson("\"cilindraje\":\"", this.getCilindraje(), "\","));
				stringBuilder.append(obtenerValorJson("\"marca\":\"", this.getMarca(), "\","));
				stringBuilder.append(obtenerValorJson("\"linea\":\"", this.getLinea(), "\","));
				stringBuilder.append(obtenerValorJson("\"modelo\":\"", this.getModelo(), "\","));
				stringBuilder.append(obtenerValorJson("\"carroceria\":\"", this.getCarroceria(), "\""));
				stringBuilder.append("}");
				break;

			default:
				break;
		}



		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}

}
