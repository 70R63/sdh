/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author hybris
 *
 */
public class CalculoReteIca2Response
{
	private String numForm;

	private CalculoReteIca2InfoDeclara infoDeclara;

	private List<FirmanteResponse> icaFirmantes;

	private List<ErrorEnWS> errores;

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
	public CalculoReteIca2InfoDeclara getInfoDeclara()
	{
		return infoDeclara;
	}

	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	@JsonProperty("info_declara")
	public void setInfoDeclara(final CalculoReteIca2InfoDeclara infoDeclara)
	{
		this.infoDeclara = infoDeclara;
	}

	/**
	 * @return the icaFirmantes
	 */
	public List<FirmanteResponse> getIcaFirmantes()
	{
		return icaFirmantes;
	}

	/**
	 * @param icaFirmantes
	 *           the icaFirmantes to set
	 */
	@JsonProperty("icaFirmantes")
	public void setIcaFirmantes(final List<FirmanteResponse> icaFirmantes)
	{
		this.icaFirmantes = icaFirmantes;
	}

	/**
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}


}
