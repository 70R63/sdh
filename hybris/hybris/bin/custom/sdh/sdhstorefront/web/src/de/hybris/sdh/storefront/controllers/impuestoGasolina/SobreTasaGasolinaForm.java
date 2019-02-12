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

	private String numBP;
	private String tipoDoc;
	private String impuesto;
	private String anoGravable;
	private String periodo;
	private String numDoc;
	private String opcionUso;
	private String tipoIdRev;
	private String tipoIdDec;
	private String numForm;
	private String NAME_ORG1;
	private String action;
	private String tipoConsulta;

	private List<SobreTasaGasolinaTabla> listaDocumentos;
	private DetGasResponse dataForm;
	private SobreTasaGasolinaCatalogos catalogosSo;

	private DetGasValoresDeclaraResponse valoresDeclara;
	private DetGasRevisorDeclaranteResponse revisor;
	private DetGasRevisorDeclaranteResponse Declarante;



	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}
	/**
	 * @param numBP the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
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
	 * @return the impuesto
	 */
	public String getImpuesto()
	{
		return impuesto;
	}
	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(final String impuesto)
	{
		this.impuesto = impuesto;
	}
	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}
	/**
	 * @param anoGravable the anoGravable to set
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
	 * @param periodo the periodo to set
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
		return numDoc;
	}
	/**
	 * @param numDoc the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}
	/**
	 * @return the opcionUso
	 */
	public String getOpcionUso()
	{
		return opcionUso;
	}
	/**
	 * @param opcionUso the opcionUso to set
	 */
	public void setOpcionUso(final String opcionUso)
	{
		this.opcionUso = opcionUso;
	}
	/**
	 * @return the tipoIdRev
	 */
	public String getTipoIdRev()
	{
		return tipoIdRev;
	}
	/**
	 * @param tipoIdRev the tipoIdRev to set
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
	 * @param tipoIdDec the tipoIdDec to set
	 */
	public void setTipoIdDec(final String tipoIdDec)
	{
		this.tipoIdDec = tipoIdDec;
	}
	/**
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}
	/**
	 * @param numForm the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
	}

	/**
	 * @return the nAME_ORG1
	 */
	public String getNAME_ORG1()
	{
		return NAME_ORG1;
	}

	/**
	 * @param nAME_ORG1
	 *           the nAME_ORG1 to set
	 */
	public void setNAME_ORG1(final String nAME_ORG1)
	{
		NAME_ORG1 = nAME_ORG1;
	}

	/**
	 * @return the action
	 */
	public String getAction()
	{
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(final String action)
	{
		this.action = action;
	}
	/**
	 * @return the listaDocumentos
	 */
	public List<SobreTasaGasolinaTabla> getListaDocumentos()
	{
		return listaDocumentos;
	}
	/**
	 * @param listaDocumentos the listaDocumentos to set
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
	 * @param dataForm the dataForm to set
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
	 * @param catalogosSo the catalogosSo to set
	 */
	public void setCatalogosSo(final SobreTasaGasolinaCatalogos catalogosSo)
	{
		this.catalogosSo = catalogosSo;
	}
	/**
	 * @return the valoresDeclara
	 */
	public DetGasValoresDeclaraResponse getValoresDeclara()
	{
		return valoresDeclara;
	}
	/**
	 * @param valoresDeclara the valoresDeclara to set
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
	 * @param revisor the revisor to set
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
	 * @param declarante the declarante to set
	 */
	public void setDeclarante(final DetGasRevisorDeclaranteResponse declarante)
	{
		Declarante = declarante;
	}

	/**
	 * @return the tipoConsulta
	 */
	public String getTipoConsulta()
	{
		return tipoConsulta;
	}

	/**
	 * @param tipoConsulta
	 *           the tipoConsulta to set
	 */
	public void setTipoConsulta(final String tipoConsulta)
	{
		this.tipoConsulta = tipoConsulta;
	}


}
