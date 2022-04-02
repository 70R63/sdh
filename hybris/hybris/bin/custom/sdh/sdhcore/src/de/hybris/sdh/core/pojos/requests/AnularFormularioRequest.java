/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author MTorres
 *
 */
public class AnularFormularioRequest
{
	private List<AnularFormularioObjeto> it_fbnum;
	private String i_laufi;
	private String i_period;

	/**
	 * @return the it_fbnum
	 */
	@JsonGetter("IT_FBNUM")
	public List<AnularFormularioObjeto> getIt_fbnum()
	{
		return it_fbnum;
	}

	/**
	 * @param it_fbnum
	 *           the it_fbnum to set
	 */
	@JsonSetter("IT_FBNUM")
	public void setIt_fbnum(final List<AnularFormularioObjeto> it_fbnum)
	{
		this.it_fbnum = it_fbnum;
	}



	/**
	 * @return the i_laufi
	 */
	@JsonGetter("I_LAUFI")
	public String getI_laufi()
	{
		return i_laufi;
	}

	/**
	 * @param i_laufi
	 *           the i_laufi to set
	 */
	@JsonSetter("I_LAUFI")
	public void setI_laufi(final String i_laufi)
	{
		this.i_laufi = i_laufi;
	}

	/**
	 * @return the i_period
	 */
	@JsonGetter("I_PERIOD")
	public String getI_period()
	{
		return i_period;
	}

	/**
	 * @param i_period
	 *           the i_period to set
	 */
	@JsonSetter("I_PERIOD")
	public void setI_period(final String i_period)
	{
		this.i_period = i_period;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();




		if (this.getIt_fbnum() != null)
		{
			stringBuilder.append("{");
			stringBuilder.append(this.preparaInfo("\"IT_FBNUM\":"));
			stringBuilder.append(",");

			stringBuilder.append(obtenerValorJson("\"I_LAUFI\":\"", this.getI_laufi(), "\","));
			stringBuilder.append(obtenerValorJson("\"I_PERIOD\":\"", this.getI_period(), "\""));
			stringBuilder.append("}");
		}


		return stringBuilder.toString();
	}

	/**
	 * @param string
	 * @return
	 */
	private Object preparaInfo(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		AnularFormularioObjeto infoElemento;
		String valorRetorno = "";

		if (this.getIt_fbnum() != null)
		{

			if (this.getIt_fbnum().size() > 0)
			{

				stringBuilder.append("[");
				for (int i = 0; i < this.getIt_fbnum().size() - 1; i++)
				{
					infoElemento = this.getIt_fbnum().get(i);

					stringBuilder.append("{");
					stringBuilder.append(obtenerValorJson("\"FBNUM\":\"", infoElemento.getFbnum(), "\","));
					stringBuilder.append(obtenerValorJson("\"CASEF\":\"", infoElemento.getCasef(), "\""));
					stringBuilder.append("},");
				}
				infoElemento = this.getIt_fbnum().get(this.getIt_fbnum().size() - 1);

				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"FBNUM\":\"", infoElemento.getFbnum(), "\","));
				stringBuilder.append(obtenerValorJson("\"CASEF\":\"", infoElemento.getCasef(), "\""));
				stringBuilder.append("}");

				stringBuilder.append("]");
			}
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
