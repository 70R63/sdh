/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.DetalleActivEconomicas;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class UpdateICAActEcoRitRequest
{
	private String numBP;
	private List<DetalleActivEconomicas> activEconomicas;


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
	 * @return the activEconomicas
	 */
	public List<DetalleActivEconomicas> getActivEconomicas()
	{
		return activEconomicas;
	}

	/**
	 * @param activEconomicas
	 *           the activEconomicas to set
	 */
	public void setActivEconomicas(final List<DetalleActivEconomicas> activEconomicas)
	{
		this.activEconomicas = activEconomicas;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\"");

		if (this.getActivEconomicas() != null)
		{
			stringBuilder.append(",");
			stringBuilder.append(this.preparaActEco("\"activEconomicas\":"));
		}


		stringBuilder.append("}");
		return stringBuilder.toString();
	}

	private String preparaActEco(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		DetalleActivEconomicas activEconomica;
		String valorRetorno = "";


		if (this.getActivEconomicas() != null)
		{
			stringBuilder.append("[");
			for (int i = 0; i < this.getActivEconomicas().size() - 1; i++)
			{
				activEconomica = this.getActivEconomicas().get(i);

				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"activPrincipal\":\"", activEconomica.getActivPrincipal(), "\","));
				stringBuilder.append(obtenerValorJson("\"ciiu\":\"", activEconomica.getCiiu(), "\","));
				stringBuilder.append(obtenerValorJson("\"denominacion\":\"", activEconomica.getDenominacion(), "\","));
				stringBuilder.append(obtenerValorJson("\"fecha_ini_act\":\"", activEconomica.getFechaIniAct(), "\","));
				stringBuilder.append(obtenerValorJson("\"fecha_cese_act\":\"", activEconomica.getFechaCeseAct(), "\""));
				stringBuilder.append("},");
			}
			activEconomica = this.getActivEconomicas().get(this.getActivEconomicas().size() - 1);

			stringBuilder.append("{");
			stringBuilder.append(obtenerValorJson("\"activPrincipal\":\"", activEconomica.getActivPrincipal(), "\","));
			stringBuilder.append(obtenerValorJson("\"ciiu\":\"", activEconomica.getCiiu(), "\","));
			stringBuilder.append(obtenerValorJson("\"denominacion\":\"", activEconomica.getDenominacion(), "\","));
			stringBuilder.append(obtenerValorJson("\"fecha_ini_act\":\"", activEconomica.getFechaIniAct(), "\","));
			stringBuilder.append(obtenerValorJson("\"fecha_cese_act\":\"", activEconomica.getFechaCeseAct(), "\""));
			stringBuilder.append("}");

			stringBuilder.append("]");
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = nombreSegmento + stringBuilder.toString();
		}

		return valorRetorno;
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}





}
