/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


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
	private String valorImpAviso;
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

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numObjeto\":\"" + ((StringUtils.isBlank(this.numObjeto )) ? "" :this.numObjeto)+"\",");
		stringBuilder.append("\"numForm\":\"" +((StringUtils.isBlank( this.numForm )) ? "" :this.numForm)+"\",");
		stringBuilder.append("\"anoGravable\":\"" +((StringUtils.isBlank( this.anoGravable )) ? "" :this.anoGravable)+"\",");
		stringBuilder.append("\"periodo\":\"" +((StringUtils.isBlank( this.periodo )) ? "" :this.periodo)+"\",");
		stringBuilder.append("\"numBP\":\"" +((StringUtils.isBlank( this.numBP )) ? "" :this.numBP)+"\",");
		stringBuilder.append("\"cantEstablec\":\"" +((StringUtils.isBlank( this.cantEstablec )) ? "" :this.cantEstablec)+"\",");
		stringBuilder.append("\"entFinanciera\":\"" +((StringUtils.isBlank( this.entFinanciera )) ? "" :this.entFinanciera)+"\",");
		stringBuilder.append("\"impuestoAviso\":\"" +((StringUtils.isBlank( this.impuestoAviso )) ? "" :this.impuestoAviso)+"\",");
		stringBuilder.append("\"valorImpAviso\":\"" +((StringUtils.isBlank( this.valorImpAviso )) ? "0.00" :this.valorImpAviso)+"\",");
		stringBuilder.append("\"totalIngrPeriodo\":\"" +((StringUtils.isBlank( this.totalIngrPeriodo )) ? "" :this.totalIngrPeriodo)+"\",");
		stringBuilder.append("\"valorPagar\":\"" +((StringUtils.isBlank( this.valorPagar )) ? "" :this.valorPagar)+"\",");
		stringBuilder.append("\"checkAporte\":\"" +((StringUtils.isBlank( this.checkAporte )) ? "" :this.checkAporte)+"\",");
		stringBuilder.append("\"proyectoAporte\":\"" +((StringUtils.isBlank( this.proyectoAporte )) ? "" :this.proyectoAporte)+"\",");
		stringBuilder.append("\"tarifaAporte\":\"" +((StringUtils.isBlank( this.tarifaAporte )) ? "" :   this.tarifaAporte ) +"\"");

		if(this.ingFueraBog != null && !this.ingFueraBog.isEmpty())
		{
			stringBuilder.append(",");
			stringBuilder.append("\"ingFueraBog\": [");
			for(final ICAIngFueraBog eachIngreso : this.ingFueraBog)
			{
				stringBuilder.append("{");
				stringBuilder.append("\"codCIIU\":\"" + ((StringUtils.isBlank( eachIngreso.getCodCIIU() )) ? "" :   eachIngreso.getCodCIIU() ) + "\",");
				stringBuilder.append("\"codMunicipio\":\"" + ((StringUtils.isBlank( eachIngreso.getCodMunicipio() )) ? "" :   eachIngreso.getCodMunicipio() ) + "\",");
				stringBuilder.append("\"ingresos\":\""
						+ ((StringUtils.isBlank(eachIngreso.getIngresos())) ? "0.00" : eachIngreso.getIngresos()) + "\"");
				stringBuilder.append("},");
			}
			stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
			stringBuilder.append(" ]");

		}


		if(this.deducciones != null)
		{
			stringBuilder.append(",");
			stringBuilder.append("\"deducciones\": ");
			stringBuilder.append("{");
			stringBuilder.append("\"actnosubPA\":\"" + ((StringUtils.isBlank( this.deducciones.getActnosubPA() )) ? "0.00" :   this.deducciones.getActnosubPA() ) + "\",");
         stringBuilder.append("\"enajActFijo\":\"" + ((StringUtils.isBlank( this.deducciones.getEnajActFijo() )) ? "0.00" :   this.deducciones.getEnajActFijo() ) + "\",");
         stringBuilder.append("\"exportBienes\":\"" + ((StringUtils.isBlank( this.deducciones.getExportBienes() )) ? "0.00" :   this.deducciones.getExportBienes() ) + "\",");
         stringBuilder.append("\"exportServ\":\"" + ((StringUtils.isBlank( this.deducciones.getExportServ() )) ? "0.00" :   this.deducciones.getExportServ() ) + "\",");
         stringBuilder.append("\"actnosub39\":\"" + ((StringUtils.isBlank( this.deducciones.getActnosub39() )) ? "0.00" :   this.deducciones.getActnosub39() ) + "\",");
         stringBuilder.append("\"actnosubPH\":\"" + ((StringUtils.isBlank( this.deducciones.getActnosubPH() )) ? "0.00" :   this.deducciones.getActnosubPH() ) + "\",");
         stringBuilder.append("\"juegoSuerteAzar\":\"" + ((StringUtils.isBlank( this.deducciones.getJuegoSuerteAzar() )) ? "0.00" :   this.deducciones.getJuegoSuerteAzar() ) + "\",");
         stringBuilder.append("\"donaciones\":\"" + ((StringUtils.isBlank( this.deducciones.getDonaciones() )) ? "0.00" :   this.deducciones.getDonaciones() ) + "\",");
         stringBuilder.append("\"exenActos\":\"" + ((StringUtils.isBlank( this.deducciones.getExenActos() )) ? "0.00" :   this.deducciones.getExenActos() ) + "\",");
         stringBuilder.append("\"baseGravEsp\":\"" + ((StringUtils.isBlank( this.deducciones.getBaseGravEsp() )) ? "0.00" :   this.deducciones.getBaseGravEsp() ) + "\",");
			stringBuilder.append("\"ingrActConsorc\":\""
					+ ((StringUtils.isBlank(this.deducciones.getIngrActConsorc())) ? "0.00" : this.deducciones.getIngrActConsorc())
					+ "\",");
         stringBuilder.append("\"diviNOGiroOrd\":\"" + ((StringUtils.isBlank( this.deducciones.getDiviNOGiroOrd() )) ? "0.00" :   this.deducciones.getDiviNOGiroOrd() ) + "\",");
         stringBuilder.append("\"exenVictima\":\"" + ((StringUtils.isBlank( this.deducciones.getExenVictima() )) ? "0.00" :   this.deducciones.getExenVictima() ) + "\",");
         stringBuilder.append("\"correcMoneda\":\"" + ((StringUtils.isBlank( this.deducciones.getCorrecMoneda() )) ? "0.00" :   this.deducciones.getCorrecMoneda() ) + "\",");
         stringBuilder.append("\"reintegro\":\"" + ((StringUtils.isBlank( this.deducciones.getReintegro() ))? "0.00" :   this.deducciones.getReintegro() ) + "\",");
         stringBuilder.append("\"salarios\":\"" + ((StringUtils.isBlank( this.deducciones.getSalarios() )) ? "0.00" :   this.deducciones.getSalarios() ) + "\",");
         stringBuilder.append("\"devoluciones\":\"" + ((StringUtils.isBlank( this.deducciones.getDevoluciones() )) ? "0.00" :   this.deducciones.getDevoluciones() ) + "\",");
         stringBuilder.append("\"rebajas\":\"" + ((StringUtils.isBlank( this.deducciones.getRebajas() )) ? "0.00" :   this.deducciones.getRebajas() ) + "\",");
         stringBuilder.append("\"descuentos\":\"" + ((StringUtils.isBlank( this.deducciones.getDescuentos() )) ? "0.00" :   this.deducciones.getDescuentos() ) + "\"");

			stringBuilder.append(" }");
		}

		if(this.ingNetosGrava != null && !this.ingNetosGrava.isEmpty())
		{
			stringBuilder.append(",");
			stringBuilder.append("\"ingNetosGrava\": [");
			for(final ICAIngNetosGrava eachIngreso : this.ingNetosGrava)
			{
				stringBuilder.append("{");
				stringBuilder.append("\"actPrincipal\":\"" + ((StringUtils.isBlank( eachIngreso.getActPrincipal() )) ? "" :   eachIngreso.getActPrincipal() ) + "\",");
				stringBuilder.append("\"codCIIU\":\"" + ((StringUtils.isBlank( eachIngreso.getCodCIIU() )) ? "" :   eachIngreso.getCodCIIU() ) + "\",");
				stringBuilder.append("\"ingresos\":\""+((StringUtils.isBlank(eachIngreso.getIngresos())) ? "0.00" : eachIngreso.getIngresos()) + "\"");
				stringBuilder.append("},");

			}
			stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
			stringBuilder.append(" ]");

		}

		if (this.ingPorCIIU != null && !this.ingPorCIIU.isEmpty())
		{
			stringBuilder.append(",");
			stringBuilder.append("\"ingPorCIIU\": [");
			for (final ICAIngPorCIIU eachIngreso : this.ingPorCIIU)
			{
				stringBuilder.append("{");
				stringBuilder.append("\"anoGravable\":\""+ ((StringUtils.isBlank(eachIngreso.getAnoGravable())) ? "" : eachIngreso.getAnoGravable()) + "\",");
				stringBuilder.append("\"tipoID\":\"" + ((StringUtils.isBlank(eachIngreso.getTipoID())) ? "" : eachIngreso.getTipoID()) + "\",");
				stringBuilder.append("\"numID\":\"" + ((StringUtils.isBlank(eachIngreso.getNumID())) ? "" : eachIngreso.getNumID()) + "\",");
				stringBuilder.append("\"razonSocial\":\""+ ((StringUtils.isBlank(eachIngreso.getRazonSocial())) ? "" : eachIngreso.getRazonSocial()) + "\",");
				stringBuilder.append("\"direccion\":\""+ ((StringUtils.isBlank(eachIngreso.getDireccion())) ? "" : eachIngreso.getDireccion()) + "\",");
				stringBuilder.append("\"telefono\":\""+ ((StringUtils.isBlank(eachIngreso.getTelefono())) ? "" : eachIngreso.getTelefono()) + "\",");
				stringBuilder.append("\"codCIIU\":\"" + ((StringUtils.isBlank(eachIngreso.getCodCIIU())) ? "" : eachIngreso.getCodCIIU()) + "\",");
				stringBuilder.append("\"ingBrutoSINIVA\":\""+ ((StringUtils.isBlank(eachIngreso.getIngBrutoSINIVA())) ? "0.00" : eachIngreso.getIngBrutoSINIVA()) + "\",");
				stringBuilder.append("\"valorTotalDevol\":\""+ ((StringUtils.isBlank(eachIngreso.getValorTotalDevol())) ? "0.00" : eachIngreso.getValorTotalDevol()) + "\"");
				stringBuilder.append("},");
			}
			stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
			stringBuilder.append(" ]");

		}


		if (this.valorRetenido != null && !this.valorRetenido.isEmpty())
		{
			stringBuilder.append(",");
			stringBuilder.append("\"valorRetenido\": [");
			for (final ICAValorRetenido eachIngreso : this.valorRetenido)
			{
				stringBuilder.append("{");
				stringBuilder.append("\"anoGravable\":\""+ ((StringUtils.isBlank(eachIngreso.getAnoGravable())) ? "" : eachIngreso.getAnoGravable()) + "\",");
				stringBuilder.append("\"tipoID\":\"" + ((StringUtils.isBlank(eachIngreso.getTipoID())) ? "" : eachIngreso.getTipoID()) + "\",");
				stringBuilder.append("\"numID\":\"" + ((StringUtils.isBlank(eachIngreso.getNumID())) ? "" : eachIngreso.getNumID()) + "\",");
				stringBuilder.append("\"razonSocial\":\""+ ((StringUtils.isBlank(eachIngreso.getRazonSocial())) ? "" : eachIngreso.getRazonSocial()) + "\",");
				stringBuilder.append("\"codMunicipio\":\""+ ((StringUtils.isBlank(eachIngreso.getCodMunicipio())) ? "" : eachIngreso.getCodMunicipio()) + "\",");
				stringBuilder.append("\"direccion\":\""+ ((StringUtils.isBlank(eachIngreso.getDireccion())) ? "" : eachIngreso.getDireccion()) + "\",");
				stringBuilder.append("\"telefono\":\""+ ((StringUtils.isBlank(eachIngreso.getTelefono())) ? "" : eachIngreso.getTelefono()) + "\",");
				stringBuilder.append("\"tarifaApl\":\""+ ((StringUtils.isBlank(eachIngreso.getTarifaApl())) ? "0.00" : eachIngreso.getTarifaApl()) + "\",");
				stringBuilder.append("\"montoRetenido\":\""+ ((StringUtils.isBlank(eachIngreso.getMontoRetenido())) ? "0.00" : eachIngreso.getMontoRetenido()) + "\"");
				stringBuilder.append("},");
			}
			stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
			stringBuilder.append(" ]");

		}


		if (this.relaciones != null && !this.relaciones.isEmpty())
		{
			stringBuilder.append(",");
			stringBuilder.append("\"valorRetenido\": [");
			for (final ICARelaciones eachIngreso : this.relaciones)
			{
				stringBuilder.append("{");
				stringBuilder.append("\"tipoDoc\":\""+ ((StringUtils.isBlank(eachIngreso.getTipoDoc())) ? "" : eachIngreso.getTipoDoc()) + "\",");
				stringBuilder.append("\"numDoc\":\"" + ((StringUtils.isBlank(eachIngreso.getNumDoc())) ? "" : eachIngreso.getNumDoc()) + "\",");
				stringBuilder.append("\"nombre\":\"" + ((StringUtils.isBlank(eachIngreso.getNombre())) ? "" : eachIngreso.getNombre()) + "\",");
				stringBuilder.append("\"tipoRelacion\":\""+ ((StringUtils.isBlank(eachIngreso.getTipoRelacion())) ? "" : eachIngreso.getTipoRelacion()) + "\",");
				stringBuilder.append("\"fechaDesde\":\""+ ((StringUtils.isBlank(eachIngreso.getFechaDesde())) ? "" : eachIngreso.getFechaDesde()) + "\",");
				stringBuilder.append("\"fechaHasta\":\""+ ((StringUtils.isBlank(eachIngreso.getFechaHasta())) ? "" : eachIngreso.getFechaHasta()) + "\"");
				stringBuilder.append("},");
			}
			stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
			stringBuilder.append(" ]");

		}


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


	/**
	 * @return the valorImpAviso
	 */
	public String getValorImpAviso()
	{
		return valorImpAviso;
	}


	/**
	 * @param valorImpAviso the valorImpAviso to set
	 */
	public void setValorImpAviso(String valorImpAviso)
	{
		this.valorImpAviso = valorImpAviso;
	}




}
