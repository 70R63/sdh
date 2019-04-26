/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ICACalculoImpRequest
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
	private List<ICADeducciones> deducciones;
	private List<ICAIngNetosGrava> ingNetosGrava;
	private List<ICAIngPorCIIU> ingPorCIIU;
	private List<ICAValorRetenido> valorRetenido;
	private List<ICARelaciones> relaciones;

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numObjeto\":\"" + this.numObjeto + "\",");
		stringBuilder.append("\"numForm\":\"" + this.numForm + "\",");
		stringBuilder.append("\"anoGravable\":\"" + this.anoGravable + "\",");
		stringBuilder.append("\"periodo\":\"" + this.periodo + "\",");
		stringBuilder.append("\"numBP\":\"" + this.numBP + "\",");
		stringBuilder.append("\"cantEstablec\":\"" + this.cantEstablec + "\",");
		stringBuilder.append("\"entFinanciera\":\"" + this.entFinanciera + "\",");
		stringBuilder.append("\"impuestoAviso\":\"" + this.impuestoAviso + "\",");
		stringBuilder.append("\"totalIngrPeriodo\":\"" + this.totalIngrPeriodo + "\",");
		stringBuilder.append("\"valorPagar\":\"" + this.valorPagar + "\",");
		stringBuilder.append("\"checkAporte\":\"" + this.checkAporte + "\",");
		stringBuilder.append("\"proyectoAporte\":\"" + this.proyectoAporte + "\",");
		stringBuilder.append("\"tarifaAporte\":\"" + this.tarifaAporte + "\"");

		//		stringBuilder.append("\"ingFueraBog\":{");
		//		stringBuilder.append("\"codCIIU\":\"" + this.ingFueraBog.getCodCIIU() + "\",");
		//		stringBuilder.append("\"codMunicipio\":\"" + this.ingFueraBog.getCodMunicipio() + "\",");
		//		stringBuilder.append("\"ingresos\":\"" + this.ingFueraBog.getIngresos() + "\",");
		//		stringBuilder.append("},");
		//
		//		stringBuilder.append("\"deducciones\":{");
		//		stringBuilder.append("\"actnosubPA\":\"" + this.deducciones.getActnosubPA() + "\",");
		//		stringBuilder.append("\"enajActFijo\":\"" + this.deducciones.getEnajActFijo() + "\",");
		//		stringBuilder.append("\"exportBienes\":\"" + this.deducciones.getExportBienes() + "\",");
		//		stringBuilder.append("\"exportServ\":\"" + this.deducciones.getExportServ() + "\",");
		//		stringBuilder.append("\"actnosub39\":\"" + this.deducciones.getActnosub39() + "\",");
		//		stringBuilder.append("\"actnosubPH\":\"" + this.deducciones.getActnosubPH() + "\",");
		//		stringBuilder.append("\"juegoSuerteAzar\":\"" + this.deducciones.getJuegoSuerteAzar() + "\",");
		//		stringBuilder.append("\"donaciones\":\"" + this.deducciones.getDonaciones() + "\",");
		//		stringBuilder.append("\"exenActos\":\"" + this.deducciones.getExenActos() + "\",");
		//		stringBuilder.append("\"baseGravEsp\":\"" + this.deducciones.getBaseGravEsp() + "\",");
		//		stringBuilder.append("\"ingrActConsorc\":\"" + this.deducciones.getIngrActConsorc() + "\",");
		//		stringBuilder.append("\"diviNOGiroOrd\":\"" + this.deducciones.getDiviNOGiroOrd() + "\",");
		//		stringBuilder.append("\"exenVictima\":\"" + this.deducciones.getExenVictima() + "\",");
		//		stringBuilder.append("\"correcMoneda\":\"" + this.deducciones.getCorrecMoneda() + "\",");
		//		stringBuilder.append("\"reintegro\":\"" + this.deducciones.getReintegro() + "\",");
		//		stringBuilder.append("\"Salarios\":\"" + this.deducciones.getSalarios() + "\",");
		//		stringBuilder.append("\"devoluciones\":\"" + this.deducciones.getDevoluciones() + "\",");
		//		stringBuilder.append("\"rebajas\":\"" + this.deducciones.getRebajas() + "\",");
		//		stringBuilder.append("\"descuentos\":\"" + this.deducciones.getDescuentos() + "\",");
		//		stringBuilder.append("},");
		//
		//		stringBuilder.append("\"ingNetosGrava\":{");
		//		stringBuilder.append("\"actPrincipal\":\"" + this.ingNetosGrava.getActPrincipal() + "\",");
		//		stringBuilder.append("\"codCIIU\":\"" + this.ingNetosGrava.getCodCIIU() + "\",");
		//		stringBuilder.append("\"ingresos\":\"" + this.ingNetosGrava.getIngresos() + "\",");
		//		stringBuilder.append("},");
		//
		//		stringBuilder.append("\"ingPorCIIU\":{");
		//		stringBuilder.append("\"anoGravable\":\"" + this.ingPorCIIU.getAnoGravable() + "\",");
		//		stringBuilder.append("\"tipoID\":\"" + this.ingPorCIIU.getTipoID() + "\",");
		//		stringBuilder.append("\"numID\":\"" + this.ingPorCIIU.getNumID() + "\",");
		//		stringBuilder.append("\"direccion\":\"" + this.ingPorCIIU.getDireccion() + "\",");
		//		stringBuilder.append("\"telefono\":\"" + this.ingPorCIIU.getTelefono() + "\",");
		//		stringBuilder.append("\"codCIIU\":\"" + this.ingPorCIIU.getCodCIIU() + "\",");
		//		stringBuilder.append("\"ingBrutoSINIVA\":\"" + this.ingPorCIIU.getIngBrutoSINIVA() + "\",");
		//		stringBuilder.append("},");
		//
		//		stringBuilder.append("\"valorRetenido\":{");
		//		stringBuilder.append("\"anoGravable\":\"" + this.valorRetenido.getAnoGravable() + "\",");
		//		stringBuilder.append("\"tipoID\":\"" + this.valorRetenido.getTipoID() + "\",");
		//		stringBuilder.append("\"numID\":\"" + this.valorRetenido.getNumID() + "\",");
		//		stringBuilder.append("\"razonSocial\":\"" + this.valorRetenido.getRazonSocial() + "\",");
		//		stringBuilder.append("\"codMunicipio\":\"" + this.valorRetenido.getCodMunicipio() + "\",");
		//		stringBuilder.append("\"direccion\":\"" + this.valorRetenido.getDireccion() + "\",");
		//		stringBuilder.append("\"telefono\":\"" + this.valorRetenido.getTelefono() + "\",");
		//		stringBuilder.append("\"tarifaApl\":\"" + this.valorRetenido.getTarifaApl() + "\",");
		//		stringBuilder.append("},");
		//
		//		stringBuilder.append("\"relaciones\":{");
		//		stringBuilder.append("\"tipoDoc\":\"" + this.relaciones.getTipoDoc() + "\",");
		//		stringBuilder.append("\"numDoc\":\"" + this.relaciones.getNumDoc() + "\",");
		//		stringBuilder.append("\"nombre\":\"" + this.relaciones.getNombre() + "\",");
		//		stringBuilder.append("\"tipoRelacion\":\"" + this.relaciones.getTipoRelacion() + "\",");
		//		stringBuilder.append("\"fechaDesde\":\"" + this.relaciones.getFechaDesde() + "\",");
		//		stringBuilder.append("\"fechaHasta\":\"" + this.relaciones.getFechaHasta() + "\",");
		//		stringBuilder.append("}");

		stringBuilder.append("}");



		return stringBuilder.toString();
	}


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
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
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
	 * @return the deducciones
	 */
	public List<ICADeducciones> getDeducciones()
	{
		return deducciones;
	}


	/**
	 * @param deducciones
	 *           the deducciones to set
	 */
	public void setDeducciones(final List<ICADeducciones> deducciones)
	{
		this.deducciones = deducciones;
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
