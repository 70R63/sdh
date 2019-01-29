/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class DetGasResponse
{
	private String calidResp;
	private String almacProd;
	private String ubicaPlanta;
	private String numTanques;
	private String almacTanque;
	private String localidad;
	private String codPostal;
	private List<DetGasRepResponse> representantes;
	private List<DetGasInfoDeclaraResponse> infoDeclara;
	private DetGasValoresDeclaraResponse valoresDeclara;
	private List<DetGasRevisorDeclaranteResponse> revisorDeclarante;
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
	 * @return the almacProd
	 */
	public String getAlmacProd()
	{
		return almacProd;
	}
	
	/**
	 * @param almacProd
	 *           the almacProd to set
	 */
	public void setAlmacProd(final String almacProd)
	{
		this.almacProd = almacProd;
	}
	/**
	 * @return the ubicaPlanta
	 */
	public String getUbicaPlanta()
	{
		return ubicaPlanta;
	}
	
	/**
	 * @param ubicaPlanta
	 *           the ubicaPlanta to set
	 */
	public void setUbicaPlanta(final String ubicaPlanta)
	{
		this.ubicaPlanta = ubicaPlanta;
	}
	/**
	 * @return the numTanques
	 */
	public String getNumTanques()
	{
		return numTanques;
	}
	
	/**
	 * @param numTanques
	 *           the numTanques to set
	 */
	public void setNumTanques(final String numTanques)
	{
		this.numTanques = numTanques;
	}
	/**
	 * @return the almacTanque
	 */
	public String getAlmacTanque()
	{
		return almacTanque;
	}
	
	/**
	 * @param almacTanque
	 *           the almacTanque to set
	 */
	public void setAlmacTanque(final String almacTanque)
	{
		this.almacTanque = almacTanque;
	}
	/**
	 * @return the localidad
	 */
	public String getLocalidad()
	{
		return localidad;
	}
	
	/**
	 * @param localidad
	 *           the localidad to set
	 */
	public void setLocalidad(final String localidad)
	{
		this.localidad = localidad;
	}
	/**
	 * @return the codPostal
	 */
	public String getCodPostal()
	{
		return codPostal;
	}
	
	/**
	 * @param codPostal
	 *           the codPostal to set
	 */
	public void setCodPostal(final String codPostal)
	{
		this.codPostal = codPostal;
	}
	/**
	 * @return the representantes
	 */
	public List<DetGasRepResponse> getRepresentantes()
	{
		return representantes;
	}
	
	/**
	 * @param representantes
	 *           the representantes to set
	 */
	public void setRepresentantes(final List<DetGasRepResponse> representantes)
	{
		this.representantes = representantes;
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
