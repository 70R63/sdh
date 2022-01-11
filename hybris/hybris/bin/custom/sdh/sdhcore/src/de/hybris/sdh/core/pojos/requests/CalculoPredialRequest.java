/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author hybris
 *
 */
public class CalculoPredialRequest
{
	private String NumBP;
	private String CHIP;
	private String MatrInmobiliaria;
	private String AnioGravable;
	private String OpcionUso;
	public CalPredialDatLiq datosLiquidacion;
	public CalBasesPresuntas datosBasesPresuntas;
	public CalPredialLiqPriv liquidacionPrivada;





	/**
	 * @return the datosBasesPresuntas
	 */
	public CalBasesPresuntas getDatosBasesPresuntas()
	{
		return datosBasesPresuntas;
	}



	/**
	 * @param datosBasesPresuntas
	 *           the datosBasesPresuntas to set
	 */
	public void setDatosBasesPresuntas(final CalBasesPresuntas datosBasesPresuntas)
	{
		this.datosBasesPresuntas = datosBasesPresuntas;
	}



	/**
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return NumBP;
	}



	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		NumBP = numBP;
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
		return MatrInmobiliaria;
	}



	/**
	 * @param matrInmobiliaria
	 *           the matrInmobiliaria to set
	 */
	public void setMatrInmobiliaria(final String matrInmobiliaria)
	{
		MatrInmobiliaria = matrInmobiliaria;
	}



	/**
	 * @return the anioGravable
	 */
	public String getAnioGravable()
	{
		return AnioGravable;
	}



	/**
	 * @param anioGravable
	 *           the anioGravable to set
	 */
	public void setAnioGravable(final String anioGravable)
	{
		AnioGravable = anioGravable;
	}



	/**
	 * @return the opcionUso
	 */
	public String getOpcionUso()
	{
		return OpcionUso;
	}



	/**
	 * @param opcionUso
	 *           the opcionUso to set
	 */
	public void setOpcionUso(final String opcionUso)
	{
		OpcionUso = opcionUso;
	}




	/**
	 * @return the datosLiquidacion
	 */
	public CalPredialDatLiq getDatosLiquidacion()
	{
		return datosLiquidacion;
	}



	/**
	 * @param datosLiquidacion
	 *           the datosLiquidacion to set
	 */
	@JsonSetter("DatosLiquidacion")
	public void setDatosLiquidacion(final CalPredialDatLiq datosLiquidacion)
	{
		this.datosLiquidacion = datosLiquidacion;
	}



	/**
	 * @return the liquidacionPrivada
	 */
	public CalPredialLiqPriv getLiquidacionPrivada()
	{
		return liquidacionPrivada;
	}



	/**
	 * @param liquidacionPrivada
	 *           the liquidacionPrivada to set
	 */
	@JsonSetter("LiquidacionPrivada")
	public void setLiquidacionPrivada(final CalPredialLiqPriv liquidacionPrivada)
	{
		this.liquidacionPrivada = liquidacionPrivada;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"NumBP\":\"" + (this.getNumBP() != null ? this.getNumBP() : "") + "\",");
		stringBuilder.append("\"CHIP\":\"" + (this.getCHIP() != null ? this.getCHIP() : "") + "\",");
		stringBuilder
				.append("\"MatrInmobiliaria\":\"" + (this.getMatrInmobiliaria() != null ? this.getMatrInmobiliaria() : "") + "\",");
		stringBuilder.append("\"AnioGravable\":\"" + (this.getAnioGravable() != null ? this.getAnioGravable() : "") + "\",");
		stringBuilder.append("\"OpcionUso\":\"" + (this.getOpcionUso() != null ? this.getOpcionUso() : "") + "\",");
		stringBuilder.append("\"DatosLiquidacion\":" + this.getDatosLiquidacion() + ",");
		stringBuilder.append("\"BasesPresuntas\":" + this.getDatosBasesPresuntas() + ",");
		stringBuilder.append("\"LiquidacionPrivada\":" + this.getLiquidacionPrivada());
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();



	}




}
