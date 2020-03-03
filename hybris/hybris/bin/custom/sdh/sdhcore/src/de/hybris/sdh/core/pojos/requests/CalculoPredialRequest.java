/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

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
	public CalPredialDatLiq DatosLiquidacion;
	public CalPredialLiqPriv LiquidacionPrivada;



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
		return DatosLiquidacion;
	}



	/**
	 * @param datosLiquidacion
	 *           the datosLiquidacion to set
	 */
	public void setDatosLiquidacion(final CalPredialDatLiq datosLiquidacion)
	{
		DatosLiquidacion = datosLiquidacion;
	}



	/**
	 * @return the liquidacionPrivada
	 */
	public CalPredialLiqPriv getLiquidacionPrivada()
	{
		return LiquidacionPrivada;
	}



	/**
	 * @param liquidacionPrivada
	 *           the liquidacionPrivada to set
	 */
	public void setLiquidacionPrivada(final CalPredialLiqPriv liquidacionPrivada)
	{
		LiquidacionPrivada = liquidacionPrivada;
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
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"CHIP\":\"" + this.getCHIP() + "\",");
		stringBuilder.append("\"matrInmobiliaria\":\"" + this.getMatrInmobiliaria() + "\",");
		stringBuilder.append("\"DatosLiquidacion\":\"" + this.getDatosLiquidacion() + "\",");
		stringBuilder.append("\"LiquidacionPrivada\":\"" + this.getLiquidacionPrivada() + "\",");
		stringBuilder.append("\"anioGravable\":\"" + this.getAnioGravable() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}




}
