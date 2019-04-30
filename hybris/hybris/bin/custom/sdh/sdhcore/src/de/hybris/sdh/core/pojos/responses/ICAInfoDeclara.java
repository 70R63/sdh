/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class ICAInfoDeclara
{
	private Integer cantEstablec;
	private String entFinanciera;
	private String totalIngrPeriodo;
	private String totalingFueraBog;
	private String totalingBrutos;
	private String devolDescuentos;
	private String totalDeduccion;
	private String totalingNetos;
	private String impIndusComer;
	private String impuestoAviso;
	private String valorImpAviso;
	private String totalUnidadAdic;
	private String impuestoCargo;
	private String valorReteIndus;
	private String saldoCargo;
	private String valorPagar;
	private String sanciones;
	private String interesMora;
	private String totalPagar;
	private String checkAporte;
	private String proyectoAporte;
	private String tarifaAporte;
	private String totalAporteVolun;
	private List<ICAInfoIngFueraBog> ingFueraBog;
	private ICAInfoDeducciones deducciones;
	private List<ICAInfoIngNetosGrava> ingNetosGrava;
	private List<ICAInfoIngPorCiiu> ingPorCIIU;
	private List<ICAInfoValorRetenido> valorRetenido;

	/**
	 * @return the cantEstablec
	 */
	public Integer getCantEstablec()
	{
		return cantEstablec;
	}

	/**
	 * @param cantEstablec
	 *           the cantEstablec to set
	 */
	public void setCantEstablec(final Integer cantEstablec)
	{
		this.cantEstablec = cantEstablec;
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
	 * @return the totalingFueraBog
	 */
	public String getTotalingFueraBog()
	{
		return totalingFueraBog;
	}

	/**
	 * @param totalingFueraBog
	 *           the totalingFueraBog to set
	 */
	public void setTotalingFueraBog(final String totalingFueraBog)
	{
		this.totalingFueraBog = totalingFueraBog;
	}

	/**
	 * @return the totalingBrutos
	 */
	public String getTotalingBrutos()
	{
		return totalingBrutos;
	}

	/**
	 * @param totalingBrutos
	 *           the totalingBrutos to set
	 */
	public void setTotalingBrutos(final String totalingBrutos)
	{
		this.totalingBrutos = totalingBrutos;
	}

	/**
	 * @return the devolDescuentos
	 */
	public String getDevolDescuentos()
	{
		return devolDescuentos;
	}

	/**
	 * @param devolDescuentos
	 *           the devolDescuentos to set
	 */
	public void setDevolDescuentos(final String devolDescuentos)
	{
		this.devolDescuentos = devolDescuentos;
	}

	/**
	 * @return the totalDeduccion
	 */
	public String getTotalDeduccion()
	{
		return totalDeduccion;
	}

	/**
	 * @param totalDeduccion
	 *           the totalDeduccion to set
	 */
	public void setTotalDeduccion(final String totalDeduccion)
	{
		this.totalDeduccion = totalDeduccion;
	}

	/**
	 * @return the totalingNetos
	 */
	public String getTotalingNetos()
	{
		return totalingNetos;
	}

	/**
	 * @param totalingNetos
	 *           the totalingNetos to set
	 */
	public void setTotalingNetos(final String totalingNetos)
	{
		this.totalingNetos = totalingNetos;
	}

	/**
	 * @return the impIndusComer
	 */
	public String getImpIndusComer()
	{
		return impIndusComer;
	}

	/**
	 * @param impIndusComer
	 *           the impIndusComer to set
	 */
	public void setImpIndusComer(final String impIndusComer)
	{
		this.impIndusComer = impIndusComer;
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
	 * @return the totalUnidadAdic
	 */
	public String getTotalUnidadAdic()
	{
		return totalUnidadAdic;
	}

	/**
	 * @param totalUnidadAdic
	 *           the totalUnidadAdic to set
	 */
	public void setTotalUnidadAdic(final String totalUnidadAdic)
	{
		this.totalUnidadAdic = totalUnidadAdic;
	}

	/**
	 * @return the impuestoCargo
	 */
	public String getImpuestoCargo()
	{
		return impuestoCargo;
	}

	/**
	 * @param impuestoCargo
	 *           the impuestoCargo to set
	 */
	public void setImpuestoCargo(final String impuestoCargo)
	{
		this.impuestoCargo = impuestoCargo;
	}

	/**
	 * @return the valorReteIndus
	 */
	public String getValorReteIndus()
	{
		return valorReteIndus;
	}

	/**
	 * @param valorReteIndus
	 *           the valorReteIndus to set
	 */
	public void setValorReteIndus(final String valorReteIndus)
	{
		this.valorReteIndus = valorReteIndus;
	}

	/**
	 * @return the saldoCargo
	 */
	public String getSaldoCargo()
	{
		return saldoCargo;
	}

	/**
	 * @param saldoCargo
	 *           the saldoCargo to set
	 */
	public void setSaldoCargo(final String saldoCargo)
	{
		this.saldoCargo = saldoCargo;
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
	 * @return the sanciones
	 */
	public String getSanciones()
	{
		return sanciones;
	}

	/**
	 * @param sanciones
	 *           the sanciones to set
	 */
	public void setSanciones(final String sanciones)
	{
		this.sanciones = sanciones;
	}

	/**
	 * @return the interesMora
	 */
	public String getInteresMora()
	{
		return interesMora;
	}

	/**
	 * @param interesMora
	 *           the interesMora to set
	 */
	public void setInteresMora(final String interesMora)
	{
		this.interesMora = interesMora;
	}

	/**
	 * @return the totalPagar
	 */
	public String getTotalPagar()
	{
		return totalPagar;
	}

	/**
	 * @param totalPagar
	 *           the totalPagar to set
	 */
	public void setTotalPagar(final String totalPagar)
	{
		this.totalPagar = totalPagar;
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
	 * @return the totalAporteVolun
	 */
	public String getTotalAporteVolun()
	{
		return totalAporteVolun;
	}

	/**
	 * @param totalAporteVolun
	 *           the totalAporteVolun to set
	 */
	public void setTotalAporteVolun(final String totalAporteVolun)
	{
		this.totalAporteVolun = totalAporteVolun;
	}

	/**
	 * @return the ingFueraBog
	 */
	public List<ICAInfoIngFueraBog> getIngFueraBog()
	{
		return ingFueraBog;
	}

	/**
	 * @param ingFueraBog
	 *           the ingFueraBog to set
	 */
	public void setIngFueraBog(final List<ICAInfoIngFueraBog> ingFueraBog)
	{
		this.ingFueraBog = ingFueraBog;
	}

	/**
	 * @return the deducciones
	 */
	public ICAInfoDeducciones getDeducciones()
	{
		return deducciones;
	}

	/**
	 * @param deducciones
	 *           the deducciones to set
	 */
	public void setDeducciones(final ICAInfoDeducciones deducciones)
	{
		this.deducciones = deducciones;
	}

	/**
	 * @return the ingNetosGrava
	 */
	public List<ICAInfoIngNetosGrava> getIngNetosGrava()
	{
		return ingNetosGrava;
	}

	/**
	 * @param ingNetosGrava
	 *           the ingNetosGrava to set
	 */
	public void setIngNetosGrava(final List<ICAInfoIngNetosGrava> ingNetosGrava)
	{
		this.ingNetosGrava = ingNetosGrava;
	}

	/**
	 * @return the ingPorCIIU
	 */
	public List<ICAInfoIngPorCiiu> getIngPorCIIU()
	{
		return ingPorCIIU;
	}

	/**
	 * @param ingPorCIIU
	 *           the ingPorCIIU to set
	 */
	public void setIngPorCIIU(final List<ICAInfoIngPorCiiu> ingPorCIIU)
	{
		this.ingPorCIIU = ingPorCIIU;
	}

	/**
	 * @return the valorRetenido
	 */
	public List<ICAInfoValorRetenido> getValorRetenido()
	{
		return valorRetenido;
	}

	/**
	 * @param valorRetenido
	 *           the valorRetenido to set
	 */
	public void setValorRetenido(final List<ICAInfoValorRetenido> valorRetenido)
	{
		this.valorRetenido = valorRetenido;
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
	 * @return the valorImpAviso
	 */
	public String getValorImpAviso()
	{
		return valorImpAviso;
	}

	/**
	 * @param valorImpAviso
	 *           the valorImpAviso to set
	 */
	public void setValorImpAviso(final String valorImpAviso)
	{
		this.valorImpAviso = valorImpAviso;
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



}
