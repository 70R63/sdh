/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.requests.ICADeducciones;
import de.hybris.sdh.core.pojos.requests.ICAIngFueraBog;
import de.hybris.sdh.core.pojos.requests.ICAIngNetosGrava;
import de.hybris.sdh.core.pojos.requests.ICAIngPorCIIU;
import de.hybris.sdh.core.pojos.requests.ICARelaciones;
import de.hybris.sdh.core.pojos.requests.ICAValorRetenido;

import java.util.List;

/**
 * @author Maria Luisa
 *
 */
public class ICACalculaDeclaracionForm
{
	private String numObjeto;
	private String numForm;
	private String anoGravable;
	private String periodo;
	private String numBP;
	private String cantEstablec;
	private String entFinanciera;
	private String impuestoAviso;
	private String totalIngrPeriodo;
	private String valorPagar;
	private String checkAporte;
	private String proyectoAporte;
	private String tarifaAporte;

	private List<ICAIngFueraBog> ingFueraBog;
	private ICADeducciones deducciones;
	private List<ICAIngNetosGrava> ingNetosGrava;
	private List<ICAIngPorCIIU> ingPorCIIU;
	private List<ICAValorRetenido> valorRetenido;
	private List<ICARelaciones> relaciones;

	/**
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
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
	 * @return the cantEstablec
	 */
	public String getCantEstablec()
	{
		return cantEstablec;
	}

	/**
	 * @param cantEstablec
	 *           the cantEstablec to set
	 */
	public void setCantEstablec(final String cantEstablec)
	{
		this.cantEstablec = cantEstablec;
	}

	/**
	 * @return the entFinanciera
	 */
	public String getEntFinanciera()
	{
		return entFinanciera;
	}

	/**
	 * @param entFinanciera
	 *           the entFinanciera to set
	 */
	public void setEntFinanciera(final String entFinanciera)
	{
		this.entFinanciera = entFinanciera;
	}

	/**
	 * @return the impuestoAviso
	 */
	public String getImpuestoAviso()
	{
		return impuestoAviso;
	}

	/**
	 * @param impuestoAviso
	 *           the impuestoAviso to set
	 */
	public void setImpuestoAviso(final String impuestoAviso)
	{
		this.impuestoAviso = impuestoAviso;
	}

	/**
	 * @return the totalIngrPeriodo
	 */
	public String getTotalIngrPeriodo()
	{
		return totalIngrPeriodo;
	}

	/**
	 * @param totalIngrPeriodo
	 *           the totalIngrPeriodo to set
	 */
	public void setTotalIngrPeriodo(final String totalIngrPeriodo)
	{
		this.totalIngrPeriodo = totalIngrPeriodo;
	}

	/**
	 * @return the valorPagar
	 */
	public String getValorPagar()
	{
		return valorPagar;
	}

	/**
	 * @param valorPagar
	 *           the valorPagar to set
	 */
	public void setValorPagar(final String valorPagar)
	{
		this.valorPagar = valorPagar;
	}

	/**
	 * @return the checkAporte
	 */
	public String getCheckAporte()
	{
		return checkAporte;
	}

	/**
	 * @param checkAporte
	 *           the checkAporte to set
	 */
	public void setCheckAporte(final String checkAporte)
	{
		this.checkAporte = checkAporte;
	}

	/**
	 * @return the proyectoAporte
	 */
	public String getProyectoAporte()
	{
		return proyectoAporte;
	}

	/**
	 * @param proyectoAporte
	 *           the proyectoAporte to set
	 */
	public void setProyectoAporte(final String proyectoAporte)
	{
		this.proyectoAporte = proyectoAporte;
	}

	/**
	 * @return the tarifaAporte
	 */
	public String getTarifaAporte()
	{
		return tarifaAporte;
	}

	/**
	 * @param tarifaAporte
	 *           the tarifaAporte to set
	 */
	public void setTarifaAporte(final String tarifaAporte)
	{
		this.tarifaAporte = tarifaAporte;
	}


	/**
	 * @return the deducciones
	 */
	public ICADeducciones getDeducciones()
	{
		return deducciones;
	}

	/**
	 * @param deducciones
	 *           the deducciones to set
	 */
	public void setDeducciones(final ICADeducciones deducciones)
	{
		this.deducciones = deducciones;
	}

	/**
	 * @return the ingFueraBog
	 */
	public List<ICAIngFueraBog> getIngFueraBog()
	{
		return ingFueraBog;
	}

	/**
	 * @param ingFueraBog
	 *           the ingFueraBog to set
	 */
	public void setIngFueraBog(final List<ICAIngFueraBog> ingFueraBog)
	{
		this.ingFueraBog = ingFueraBog;
	}

	/**
	 * @return the ingNetosGrava
	 */
	public List<ICAIngNetosGrava> getIngNetosGrava()
	{
		return ingNetosGrava;
	}

	/**
	 * @param ingNetosGrava
	 *           the ingNetosGrava to set
	 */
	public void setIngNetosGrava(final List<ICAIngNetosGrava> ingNetosGrava)
	{
		this.ingNetosGrava = ingNetosGrava;
	}

	/**
	 * @return the ingPorCIIU
	 */
	public List<ICAIngPorCIIU> getIngPorCIIU()
	{
		return ingPorCIIU;
	}

	/**
	 * @param ingPorCIIU
	 *           the ingPorCIIU to set
	 */
	public void setIngPorCIIU(final List<ICAIngPorCIIU> ingPorCIIU)
	{
		this.ingPorCIIU = ingPorCIIU;
	}

	/**
	 * @return the valorRetenido
	 */
	public List<ICAValorRetenido> getValorRetenido()
	{
		return valorRetenido;
	}

	/**
	 * @param valorRetenido
	 *           the valorRetenido to set
	 */
	public void setValorRetenido(final List<ICAValorRetenido> valorRetenido)
	{
		this.valorRetenido = valorRetenido;
	}

	/**
	 * @return the relaciones
	 */
	public List<ICARelaciones> getRelaciones()
	{
		return relaciones;
	}

	/**
	 * @param relaciones
	 *           the relaciones to set
	 */
	public void setRelaciones(final List<ICARelaciones> relaciones)
	{
		this.relaciones = relaciones;
	}



}
