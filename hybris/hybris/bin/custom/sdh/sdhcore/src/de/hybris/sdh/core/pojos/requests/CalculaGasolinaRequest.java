/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.DetGasInfoDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRevisorDeclaranteResponse;

import java.util.List;


/**
 * @author hybris
 *
 */
public class CalculaGasolinaRequest
{

	private String numBP;
	private String numDoc;
	private String tipoDoc;
	private String anoGravable;
	private String periodo;
	private String numForm;
	private String opcionUso;
	private String calidResp;
	private List<DetGasInfoDeclaraResponse> infoDeclara;
	private List<DetGasRevisorDeclaranteResponse> revisorDeclarante;


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
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}



	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}



	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc()
	{
		return tipoDoc;
	}



	/**
	 * @param tipoDoc
	 *           the tipoDoc to set
	 */
	public void setTipoDoc(final String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}



	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}



	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
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
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}



	/**
	 * @param numForm
	 *           the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
	}



	/**
	 * @return the opcionUso
	 */
	public String getOpcionUso()
	{
		return opcionUso;
	}



	/**
	 * @param opcionUso
	 *           the opcionUso to set
	 */
	public void setOpcionUso(final String opcionUso)
	{
		this.opcionUso = opcionUso;
	}



	/**
	 * @return the calidResp
	 */
	public String getCalidResp()
	{
		return calidResp;
	}



	/**
	 * @param calidResp
	 *           the calidResp to set
	 */
	public void setCalidResp(final String calidResp)
	{
		this.calidResp = calidResp;
	}



	/**
	 * @return the infoDeclara
	 */
	public List<DetGasInfoDeclaraResponse> getInfoDeclara()
	{
		return infoDeclara;
	}



	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	public void setInfoDeclara(final List<DetGasInfoDeclaraResponse> infoDeclara)
	{
		this.infoDeclara = infoDeclara;
	}



	/**
	 * @return the revisorDeclarante
	 */
	public List<DetGasRevisorDeclaranteResponse> getRevisorDeclarante()
	{
		return revisorDeclarante;
	}



	/**
	 * @param revisorDeclarante
	 *           the revisorDeclarante to set
	 */
	public void setRevisorDeclarante(final List<DetGasRevisorDeclaranteResponse> revisorDeclarante)
	{
		this.revisorDeclarante = revisorDeclarante;
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
		stringBuilder.append(obtenerValorJson("\"numDoc\":\"", this.getNumDoc(), "\","));
		stringBuilder.append(obtenerValorJson("\"tipoDoc\":\"", this.getTipoDoc(), "\","));
		stringBuilder.append(obtenerValorJson("\"anoGravable\":\"", this.getAnoGravable(), "\","));
		stringBuilder.append(obtenerValorJson("\"periodo\":\"", this.getPeriodo(), "\","));
		stringBuilder.append(obtenerValorJson("\"numForm\":\"", this.getNumForm(), "\","));
		stringBuilder.append(obtenerValorJson("\"opcionUso\":\"", this.getOpcionUso(), "\","));
		stringBuilder.append(obtenerValorJson("\"calidResp\":\"", this.getCalidResp(), "\""));


		if (this.getInfoDeclara() != null || this.getRevisorDeclarante() != null)
		{

			if (this.getInfoDeclara() != null)
			{
				stringBuilder.append(",");
				stringBuilder.append(this.preparaInfoDeclara("\"infoDeclara\":"));

			}
			if (this.getRevisorDeclarante() != null)
			{
				stringBuilder.append(",");
				stringBuilder.append(this.preparaRevisorDeclarante("\"revisorDeclarante\":"));
			}

		}
		stringBuilder.append("}");

		return stringBuilder.toString();
	}



	/**
	 * @param string
	 * @param numBP2
	 * @param string2
	 * @return
	 */
	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}



	/**
	 * @return
	 */
	private String preparaRevisorDeclarante(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		DetGasRevisorDeclaranteResponse infoDeclara;
		String valorRetorno = "";


		if (this.getRevisorDeclarante() != null)
		{

			if (this.getRevisorDeclarante().size() > 0)
			{

				stringBuilder.append("[");
				for (int i = 0; i < this.getRevisorDeclarante().size() - 1; i++)
				{
					infoDeclara = this.getRevisorDeclarante().get(i);

					stringBuilder.append("{");
					stringBuilder.append(obtenerValorJson("\"tipoInterloc\":\"", infoDeclara.getTipoInterloc(), "\","));
					stringBuilder.append(obtenerValorJson("\"tipoDoc\":\"", infoDeclara.getTipoDoc(), "\","));
					stringBuilder.append(obtenerValorJson("\"numDoc\":\"", infoDeclara.getNumDoc(), "\","));
					stringBuilder.append(obtenerValorJson("\"nombres\":\"", infoDeclara.getNombres(), "\","));
					stringBuilder.append(obtenerValorJson("\"tarjetaProf\":\"", infoDeclara.getTarjetaProf(), "\""));
					stringBuilder.append("},");
				}
				infoDeclara = this.getRevisorDeclarante().get(this.getRevisorDeclarante().size() - 1);

				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"tipoInterloc\":\"", infoDeclara.getTipoInterloc(), "\","));
				stringBuilder.append(obtenerValorJson("\"tipoDoc\":\"", infoDeclara.getTipoDoc(), "\","));
				stringBuilder.append(obtenerValorJson("\"numDoc\":\"", infoDeclara.getNumDoc(), "\","));
				stringBuilder.append(obtenerValorJson("\"nombres\":\"", infoDeclara.getNombres(), "\","));
				stringBuilder.append(obtenerValorJson("\"tarjetaProf\":\"", infoDeclara.getTarjetaProf(), "\""));
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



	/**
	 * @return
	 */
	private String preparaInfoDeclara(final String nombreSegmento)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		DetGasInfoDeclaraResponse infoDeclara;
		String valorRetorno = "";


		if (this.getInfoDeclara() != null)
		{
			stringBuilder.append("[");
			for (int i = 0; i < this.getInfoDeclara().size() - 1; i++)
			{
				infoDeclara = this.getInfoDeclara().get(i);

				stringBuilder.append("{");
				stringBuilder.append(obtenerValorJson("\"claseProd\":\"", infoDeclara.getClaseProd(), "\","));
				stringBuilder.append(obtenerValorJson("\"galonesGra\":\"", infoDeclara.getGalonesGra(), "\","));
				stringBuilder.append(obtenerValorJson("\"precioRef\":\"", infoDeclara.getPrecioRef(), "\","));
				stringBuilder.append(obtenerValorJson("\"alcoholCarbu\":\"", infoDeclara.getAlcoholCarbu(), "\","));
				stringBuilder.append(obtenerValorJson("\"baseGravable\":\"", infoDeclara.getBaseGravable(), "\","));
				stringBuilder.append(obtenerValorJson("\"vlrSobretasa\":\"", infoDeclara.getVlrSobretasa(), "\""));
				stringBuilder.append("},");
			}
			infoDeclara = this.getInfoDeclara().get(this.getInfoDeclara().size() - 1);

			stringBuilder.append("{");
			stringBuilder.append(obtenerValorJson("\"claseProd\":\"", infoDeclara.getClaseProd(), "\","));
			stringBuilder.append(obtenerValorJson("\"galonesGra\":\"", infoDeclara.getGalonesGra(), "\","));
			stringBuilder.append(obtenerValorJson("\"precioRef\":\"", infoDeclara.getPrecioRef(), "\","));
			stringBuilder.append(obtenerValorJson("\"alcoholCarbu\":\"", infoDeclara.getAlcoholCarbu(), "\","));
			stringBuilder.append(obtenerValorJson("\"baseGravable\":\"", infoDeclara.getBaseGravable(), "\","));
			stringBuilder.append(obtenerValorJson("\"vlrSobretasa\":\"", infoDeclara.getVlrSobretasa(), "\""));
			stringBuilder.append("}");

			stringBuilder.append("]");
		}

		if (stringBuilder.toString() != null)
		{
			valorRetorno = nombreSegmento + stringBuilder.toString();
		}

		return valorRetorno;
	}

}
