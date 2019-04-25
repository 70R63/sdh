/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class ICAInfObjetoResponse
{

	private String numForm;
	private String fechaCeseAct;
	private String fechaIniAct;
	private String cantEstablec;
	private String causalCeseAct;
	private String regimen;
	private String matricula;
	private String codLiquida;
	private String orgJuridica;
	private String estadoMatricula;
	private String claseESAL;

	private List<DetalleRelaciones> relaciones;

	private List<DetalleActivEconomicas> activEconomicas;
	private List<DetalleEstablecimientos> establecimientos;
	private DetalleDatosEconomicos datosEconomicos;
	private List<DetalleMarcas> marcas;

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
	 * @return the fechaCeseAct
	 */
	public String getFechaCeseAct()
	{
		return fechaCeseAct;
	}

	/**
	 * @param fechaCeseAct
	 *           the fechaCeseAct to set
	 */
	public void setFechaCeseAct(final String fechaCeseAct)
	{
		this.fechaCeseAct = fechaCeseAct;
	}

	/**
	 * @return the fechaIniAct
	 */
	public String getFechaIniAct()
	{
		return fechaIniAct;
	}

	/**
	 * @param fechaIniAct
	 *           the fechaIniAct to set
	 */
	public void setFechaIniAct(final String fechaIniAct)
	{
		this.fechaIniAct = fechaIniAct;
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
	 * @return the causalCeseAct
	 */
	public String getCausalCeseAct()
	{
		return causalCeseAct;
	}

	/**
	 * @param causalCeseAct
	 *           the causalCeseAct to set
	 */
	public void setCausalCeseAct(final String causalCeseAct)
	{
		this.causalCeseAct = causalCeseAct;
	}

	/**
	 * @return the regimen
	 */
	public String getRegimen()
	{
		return regimen;
	}

	/**
	 * @param regimen
	 *           the regimen to set
	 */
	public void setRegimen(final String regimen)
	{
		this.regimen = regimen;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula()
	{
		return matricula;
	}

	/**
	 * @param matricula
	 *           the matricula to set
	 */
	public void setMatricula(final String matricula)
	{
		this.matricula = matricula;
	}

	/**
	 * @return the codLiquida
	 */
	public String getCodLiquida()
	{
		return codLiquida;
	}

	/**
	 * @param codLiquida
	 *           the codLiquida to set
	 */
	public void setCodLiquida(final String codLiquida)
	{
		this.codLiquida = codLiquida;
	}

	/**
	 * @return the orgJuridica
	 */
	public String getOrgJuridica()
	{
		return orgJuridica;
	}

	/**
	 * @param orgJuridica
	 *           the orgJuridica to set
	 */
	public void setOrgJuridica(final String orgJuridica)
	{
		this.orgJuridica = orgJuridica;
	}

	/**
	 * @return the estadoMatricula
	 */
	public String getEstadoMatricula()
	{
		return estadoMatricula;
	}

	/**
	 * @param estadoMatricula
	 *           the estadoMatricula to set
	 */
	public void setEstadoMatricula(final String estadoMatricula)
	{
		this.estadoMatricula = estadoMatricula;
	}

	/**
	 * @return the claseESAL
	 */
	public String getClaseESAL()
	{
		return claseESAL;
	}

	/**
	 * @param claseESAL
	 *           the claseESAL to set
	 */
	public void setClaseESAL(final String claseESAL)
	{
		this.claseESAL = claseESAL;
	}

	/**
	 * @return the activEconomicas
	 */
	public List<DetalleActivEconomicas> getActivEconomicas()
	{
		return activEconomicas;
	}

	/**
	 * @param activEconomicas
	 *           the activEconomicas to set
	 */
	public void setActivEconomicas(final List<DetalleActivEconomicas> activEconomicas)
	{
		this.activEconomicas = activEconomicas;
	}

	/**
	 * @return the establecimientos
	 */
	public List<DetalleEstablecimientos> getEstablecimientos()
	{
		return establecimientos;
	}

	/**
	 * @param establecimientos
	 *           the establecimientos to set
	 */
	public void setEstablecimientos(final List<DetalleEstablecimientos> establecimientos)
	{
		this.establecimientos = establecimientos;
	}



	/**
	 * @return the datosEconomicos
	 */
	public DetalleDatosEconomicos getDatosEconomicos()
	{
		return datosEconomicos;
	}

	/**
	 * @param datosEconomicos
	 *           the datosEconomicos to set
	 */
	public void setDatosEconomicos(final DetalleDatosEconomicos datosEconomicos)
	{
		this.datosEconomicos = datosEconomicos;
	}

	/**
	 * @return the marcas
	 */
	public List<DetalleMarcas> getMarcas()
	{
		return marcas;
	}

	/**
	 * @param marcas
	 *           the marcas to set
	 */
	public void setMarcas(final List<DetalleMarcas> marcas)
	{
		this.marcas = marcas;
	}

	/**
	 * @return the relaciones
	 */
	public List<DetalleRelaciones> getRelaciones()
	{
		return relaciones;
	}

	/**
	 * @param relaciones
	 *           the relaciones to set
	 */
	public void setRelaciones(final List<DetalleRelaciones> relaciones)
	{
		this.relaciones = relaciones;
	}



}
