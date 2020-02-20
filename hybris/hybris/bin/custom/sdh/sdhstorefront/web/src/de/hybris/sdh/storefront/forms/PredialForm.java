/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.DetallePredialResponse;
import de.hybris.sdh.core.pojos.responses.PredialDatosEconomicos;
import de.hybris.sdh.core.pojos.responses.PredialDatosFisicos;
import de.hybris.sdh.core.pojos.responses.PredialDatosJuridicos;
import de.hybris.sdh.core.pojos.responses.PredialEstDatosGenerales;
import de.hybris.sdh.core.pojos.responses.PredialEstLiquidacion;
import de.hybris.sdh.core.pojos.responses.PredialEstLiquidacionPrivada;
import de.hybris.sdh.core.pojos.responses.PredialMarcas;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.PredialTblErrores;

import java.util.List;

/**
 * @author Maria Luisa
 *
 */
public class PredialForm
{

	private List<PredialResponse> predial;

	private String numBP;
	private String CHIP;
	private String matrInmobiliaria;
	private String anioGravable;

	private String fechaInactivacion;
	private String opcionuso;
	private String indicadorspac;
	private String indicadorbasegravable;

	private PredialDatosJuridicos datosJuridicos;
	private PredialDatosEconomicos datosEconomicos;
	private PredialDatosFisicos datosFisicos;
	private List<PredialMarcas> marcas;
	private PredialEstLiquidacion estrLiquidacionPredial;
	private PredialEstDatosGenerales estrDatosGenerales;
	private PredialEstLiquidacionPrivada estrLiquidacionPrivada;
	private List<PredialTblErrores> tblErrores;

	private DetallePredialResponse detallePredio;

	private String tipDoc;
	private String compleName;
	private String numDoc;

	/**
	 * @return the detallePredio
	 */
	public DetallePredialResponse getDetallePredio()
	{
		return detallePredio;
	}

	/**
	 * @param detallePredio
	 *           the detallePredio to set
	 */
	public void setDetallePredio(final DetallePredialResponse detallePredio)
	{
		this.detallePredio = detallePredio;
	}

	/**
	 * @return the fechaInactivacion
	 */
	public String getFechaInactivacion()
	{
		return fechaInactivacion;
	}

	/**
	 * @param fechaInactivacion the fechaInactivacion to set
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
	 * @param opcionuso the opcionuso to set
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
	 * @param indicadorspac the indicadorspac to set
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
	 * @param indicadorbasegravable the indicadorbasegravable to set
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
	 * @param datosJuridicos the datosJuridicos to set
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
	 * @param datosEconomicos the datosEconomicos to set
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
	 * @param datosFisicos the datosFisicos to set
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
	 * @param marcas the marcas to set
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
	 * @param estrLiquidacionPredial the estrLiquidacionPredial to set
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
	 * @param estrDatosGenerales the estrDatosGenerales to set
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
	 * @param estrLiquidacionPrivada the estrLiquidacionPrivada to set
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
	 * @param tblErrores the tblErrores to set
	 */
	public void setTblErrores(final List<PredialTblErrores> tblErrores)
	{
		this.tblErrores = tblErrores;
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
	 * @return the cHIP
	 */
	public String getCHIP()
	{
		return CHIP;
	}

	/**
	 * @param cHIP
	 *           the cHIP to set
	 */
	public void setCHIP(final String cHIP)
	{
		CHIP = cHIP;
	}

	/**
	 * @return the matrInmobiliaria
	 */
	public String getMatrInmobiliaria()
	{
		return matrInmobiliaria;
	}

	/**
	 * @param matrInmobiliaria
	 *           the matrInmobiliaria to set
	 */
	public void setMatrInmobiliaria(final String matrInmobiliaria)
	{
		this.matrInmobiliaria = matrInmobiliaria;
	}

	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return anioGravable;
	}

	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		this.anioGravable = anioGravable;
	}

	/**
	 * @return the predial
	 */
	public List<PredialResponse> getPredial()
	{
		return predial;
	}

	/**
	 * @param predial
	 *           the predial to set
	 */
	public void setPredial(final List<PredialResponse> predial)
	{
		this.predial = predial;
	}

	/**
	 * @return the tipDoc
	 */
	public String getTipDoc()
	{
		return tipDoc;
	}

	/**
	 * @param tipDoc
	 *           the tipDoc to set
	 */
	public void setTipDoc(final String tipDoc)
	{
		this.tipDoc = tipDoc;
	}

	/**
	 * @return the compleName
	 */
	public String getCompleName()
	{
		return compleName;
	}

	/**
	 * @param compleName
	 *           the compleName to set
	 */
	public void setCompleName(final String compleName)
	{
		this.compleName = compleName;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}







}
