/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.sdh.core.pojos.responses.DetGasInfoDeclaraResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRevisorDeclaranteResponse;
import de.hybris.sdh.core.pojos.responses.DetGasValoresDeclaraResponse;

import java.util.List;


/**
 * @author fede
 *
 */
public class DeclaracionGasolinaForm
{
	private String anoGravable;
	private String periodo;
	private String NumDoc;
	private String opcionesUso;
	private String tipoIdRev;
	private String tipoIdDec;

	private DetGasCatalogos catalogos;

	private List<DetGasInfoDeclaraResponse> infoDeclara;
	private DetGasValoresDeclaraResponse valoresDeclara;
	private DetGasRevisorDeclaranteResponse revisor;
	private DetGasRevisorDeclaranteResponse Declarante;

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
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return NumDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		NumDoc = numDoc;
	}

	/**
	 * @return the opcionesUso
	 */
	public String getOpcionesUso()
	{
		return opcionesUso;
	}

	/**
	 * @param opcionesUso
	 *           the opcionesUso to set
	 */
	public void setOpcionesUso(final String opcionesUso)
	{
		this.opcionesUso = opcionesUso;
	}

	/**
	 * @return the catalogos
	 */
	public DetGasCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final DetGasCatalogos catalogos)
	{
		this.catalogos = catalogos;
	}

	/**
	 * @return the tipoIdRev
	 */
	public String getTipoIdRev()
	{
		return tipoIdRev;
	}

	/**
	 * @param tipoIdRev
	 *           the tipoIdRev to set
	 */
	public void setTipoIdRev(final String tipoIdRev)
	{
		this.tipoIdRev = tipoIdRev;
	}

	/**
	 * @return the tipoIdDec
	 */
	public String getTipoIdDec()
	{
		return tipoIdDec;
	}

	/**
	 * @param tipoIdDec
	 *           the tipoIdDec to set
	 */
	public void setTipoIdDec(final String tipoIdDec)
	{
		this.tipoIdDec = tipoIdDec;
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
	 * @return the revisor
	 */
	public DetGasRevisorDeclaranteResponse getRevisor()
	{
		return revisor;
	}

	/**
	 * @param revisor
	 *           the revisor to set
	 */
	public void setRevisor(final DetGasRevisorDeclaranteResponse revisor)
	{
		this.revisor = revisor;
	}

	/**
	 * @return the declarante
	 */
	public DetGasRevisorDeclaranteResponse getDeclarante()
	{
		return Declarante;
	}

	/**
	 * @param declarante
	 *           the declarante to set
	 */
	public void setDeclarante(final DetGasRevisorDeclaranteResponse declarante)
	{
		Declarante = declarante;
	}

}
