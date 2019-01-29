/**
 *
 */
package de.hybris.sdh.storefront.controllers.impuestoGasolina;

import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetGasRevisorDeclaranteResponse;
import de.hybris.sdh.core.pojos.responses.DetGasValoresDeclaraResponse;

import java.util.List;


/**
 * @author Administrator
 *
 */
public class SobreTasaGasolinaForm
{
	private String anoGravable;
	private String periodo;
	private List<SobreTasaGasolinaTabla> listaDocumentos;
	private DetGasResponse dataForm;
	private SobreTasaGasolinaCatalogos catalogosSo;

	private String NumDoc;
	private String opcionUso;
	private String tipoIdRev;
	private String tipoIdDec;
	private String numForm;

	private DetGasCatalogos catalogosDe;

	//	private List<DetGasInfoDeclaraResponse> infoDeclara;
	private DetGasValoresDeclaraResponse valoresDeclara;
	private DetGasRevisorDeclaranteResponse revisor;
	private DetGasRevisorDeclaranteResponse Declarante;

	private String action;




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
	 * @return the action
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * @param action
	 *           the action to set
	 */
	public void setAction(final String action)
	{
		this.action = action;
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
	 * @return the listaDocumentos
	 */
	public List<SobreTasaGasolinaTabla> getListaDocumentos()
	{
		return listaDocumentos;
	}

	/**
	 * @param listaDocumentos
	 *           the listaDocumentos to set
	 */
	public void setListaDocumentos(final List<SobreTasaGasolinaTabla> listaDocumentos)
	{
		this.listaDocumentos = listaDocumentos;
	}

	/**
	 * @return the dataForm
	 */
	public DetGasResponse getDataForm()
	{
		return dataForm;
	}

	/**
	 * @param dataForm
	 *           the dataForm to set
	 */
	public void setDataForm(final DetGasResponse dataForm)
	{
		this.dataForm = dataForm;
	}

	/**
	 * @return the catalogosSo
	 */
	public SobreTasaGasolinaCatalogos getCatalogosSo()
	{
		return catalogosSo;
	}

	/**
	 * @param catalogosSo
	 *           the catalogosSo to set
	 */
	public void setCatalogosSo(final SobreTasaGasolinaCatalogos catalogosSo)
	{
		this.catalogosSo = catalogosSo;
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
	public String getOpcionUso()
	{
		return opcionUso;
	}

	/**
	 * @param opcionesUso
	 *           the opcionesUso to set
	 */
	public void setOpcionesUso(final String opcionesUso)
	{
		this.opcionUso = opcionesUso;
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
	 * @return the catalogosDe
	 */
	public DetGasCatalogos getCatalogosDe()
	{
		return catalogosDe;
	}

	/**
	 * @param catalogosDe
	 *           the catalogosDe to set
	 */
	public void setCatalogosDe(final DetGasCatalogos catalogosDe)
	{
		this.catalogosDe = catalogosDe;
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
