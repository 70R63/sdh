/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author hybris
 *
 */
public class DetallePredialResponse
{
	private String fechaInactivacion;
	private String opcionuso;
	private String indicadorspac;
	private String indicadorbasegravable;
	private String autoavaluo;
	private String direccionPredio;
	private String checkAporte;
	private String indicadorDesc1;

	private PredialDatosJuridicos datosJuridicos;
	private PredialDatosEconomicos datosEconomicos;
	private PredialDatosFisicos datosFisicos;
	private List<PredialMarcas> marcas;
	private PredialEstLiquidacion estrLiquidacionPredial;
	private PredialEstDatosGenerales estrDatosGenerales;
	private PredialEstLiquidacionPrivada estrLiquidacionPrivada;
	private List<PredialTblErrores> tblErrores;
	/**
	 * @return the fechaInactivacion
	 */
	public String getFechaInactivacion()
	{
		return fechaInactivacion;
	}

	/**
	 * @param fechaInactivacion
	 *           the fechaInactivacion to set
	 */
	public void setFechaInactivacion(final String fechaInactivacion)
	{
		this.fechaInactivacion = fechaInactivacion;
	}
	/**
	 * @return the opcionuso
	 */
	public String getOpcionuso()
	{
		return opcionuso;
	}

	/**
	 * @param opcionuso
	 *           the opcionuso to set
	 */
	public void setOpcionuso(final String opcionuso)
	{
		this.opcionuso = opcionuso;
	}
	/**
	 * @return the indicadorspac
	 */
	public String getIndicadorspac()
	{
		return indicadorspac;
	}

	/**
	 * @param indicadorspac
	 *           the indicadorspac to set
	 */
	public void setIndicadorspac(final String indicadorspac)
	{
		this.indicadorspac = indicadorspac;
	}
	/**
	 * @return the indicadorbasegravable
	 */
	public String getIndicadorbasegravable()
	{
		return indicadorbasegravable;
	}

	/**
	 * @param indicadorbasegravable
	 *           the indicadorbasegravable to set
	 */
	public void setIndicadorbasegravable(final String indicadorbasegravable)
	{
		this.indicadorbasegravable = indicadorbasegravable;
	}
	/**
	 * @return the datosJuridicos
	 */
	public PredialDatosJuridicos getDatosJuridicos()
	{
		return datosJuridicos;
	}

	/**
	 * @param datosJuridicos
	 *           the datosJuridicos to set
	 */
	public void setDatosJuridicos(final PredialDatosJuridicos datosJuridicos)
	{
		this.datosJuridicos = datosJuridicos;
	}
	/**
	 * @return the datosEconomicos
	 */
	public PredialDatosEconomicos getDatosEconomicos()
	{
		return datosEconomicos;
	}

	/**
	 * @param datosEconomicos
	 *           the datosEconomicos to set
	 */
	public void setDatosEconomicos(final PredialDatosEconomicos datosEconomicos)
	{
		this.datosEconomicos = datosEconomicos;
	}
	/**
	 * @return the datosFisicos
	 */
	public PredialDatosFisicos getDatosFisicos()
	{
		return datosFisicos;
	}

	/**
	 * @param datosFisicos
	 *           the datosFisicos to set
	 */
	public void setDatosFisicos(final PredialDatosFisicos datosFisicos)
	{
		this.datosFisicos = datosFisicos;
	}
	/**
	 * @return the marcas
	 */
	public List<PredialMarcas> getMarcas()
	{
		return marcas;
	}

	/**
	 * @param marcas
	 *           the marcas to set
	 */
	public void setMarcas(final List<PredialMarcas> marcas)
	{
		this.marcas = marcas;
	}
	/**
	 * @return the estrLiquidacionPredial
	 */
	public PredialEstLiquidacion getEstrLiquidacionPredial()
	{
		return estrLiquidacionPredial;
	}

	/**
	 * @param estrLiquidacionPredial
	 *           the estrLiquidacionPredial to set
	 */
	public void setEstrLiquidacionPredial(final PredialEstLiquidacion estrLiquidacionPredial)
	{
		this.estrLiquidacionPredial = estrLiquidacionPredial;
	}
	/**
	 * @return the estrDatosGenerales
	 */
	public PredialEstDatosGenerales getEstrDatosGenerales()
	{
		return estrDatosGenerales;
	}

	/**
	 * @param estrDatosGenerales
	 *           the estrDatosGenerales to set
	 */
	public void setEstrDatosGenerales(final PredialEstDatosGenerales estrDatosGenerales)
	{
		this.estrDatosGenerales = estrDatosGenerales;
	}
	/**
	 * @return the estrLiquidacionPrivada
	 */
	public PredialEstLiquidacionPrivada getEstrLiquidacionPrivada()
	{
		return estrLiquidacionPrivada;
	}

	/**
	 * @param estrLiquidacionPrivada
	 *           the estrLiquidacionPrivada to set
	 */
	public void setEstrLiquidacionPrivada(final PredialEstLiquidacionPrivada estrLiquidacionPrivada)
	{
		this.estrLiquidacionPrivada = estrLiquidacionPrivada;
	}
	/**
	 * @return the tblErrores
	 */
	public List<PredialTblErrores> getTblErrores()
	{
		return tblErrores;
	}

	/**
	 * @param tblErrores
	 *           the tblErrores to set
	 */
	public void setTblErrores(final List<PredialTblErrores> tblErrores)
	{
		this.tblErrores = tblErrores;
	}

	/**
	 * @return the autoavaluo
	 */
	public String getAutoavaluo()
	{
		return autoavaluo;
	}

	/**
	 * @param autoavaluo
	 *           the autoavaluo to set
	 */
	public void setAutoavaluo(final String autoavaluo)
	{
		this.autoavaluo = autoavaluo;
	}

	/**
	 * @return the direccionPredio
	 */
	public String getDireccionPredio()
	{
		return direccionPredio;
	}

	/**
	 * @param direccionPredio
	 *           the direccionPredio to set
	 */
	public void setDireccionPredio(final String direccionPredio)
	{
		this.direccionPredio = direccionPredio;
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
	 * @return the indicadorDesc1
	 */
	public String getIndicadorDesc1()
	{
		return indicadorDesc1;
	}

	/**
	 * @param indicadorDesc1
	 *           the indicadorDesc1 to set
	 */
	public void setIndicadorDesc1(final String indicadorDesc1)
	{
		this.indicadorDesc1 = indicadorDesc1;
	}



}
