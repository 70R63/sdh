/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class CalculaGasolinaResponse
{

	private String numForm;
	private List<DetGasInfoDeclaraResponse> infoDeclara;
	private DetGasValoresDeclaraResponse valoresDeclara;
	private List<DetGasRevisorDeclaranteResponse> revisorDeclarante;

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
	 * @return the valoresDeclara
	 */
	public DetGasValoresDeclaraResponse getValoresDeclara()
	{
		return valoresDeclara;
	}

	/**
	 * @param valoresDeclara
	 *           the valoresDeclara to set
	 */
	public void setValoresDeclara(final DetGasValoresDeclaraResponse valoresDeclara)
	{
		this.valoresDeclara = valoresDeclara;
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


}
