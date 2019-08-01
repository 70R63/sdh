/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class ConsCasosRequest
{
	private String NUM_CASO;
	private String NUM_RADICADO;
	private String PROCESS_TYPE;
	private String ESTATUS;
	private String CONTRIBUYENTE;
	private String CLASE_IDENTIFICACION;
	private String ID_IDENTIFICADOR;
	private String LINEA;
	private String IDENTIFICADOR;
	private String VALOR;


	/**
	 * @return the nUM_CASO
	 */
	public String getNUM_CASO()
	{
		return NUM_CASO;
	}


	/**
	 * @param nUM_CASO the nUM_CASO to set
	 */
	public void setNUM_CASO(final String nUM_CASO)
	{
		NUM_CASO = nUM_CASO;
	}


	/**
	 * @return the nUM_RADICADO
	 */
	public String getNUM_RADICADO()
	{
		return NUM_RADICADO;
	}


	/**
	 * @param nUM_RADICADO the nUM_RADICADO to set
	 */
	public void setNUM_RADICADO(final String nUM_RADICADO)
	{
		NUM_RADICADO = nUM_RADICADO;
	}


	/**
	 * @return the pROCESS_TYPE
	 */
	public String getPROCESS_TYPE()
	{
		return PROCESS_TYPE;
	}


	/**
	 * @param pROCESS_TYPE the pROCESS_TYPE to set
	 */
	public void setPROCESS_TYPE(final String pROCESS_TYPE)
	{
		PROCESS_TYPE = pROCESS_TYPE;
	}


	/**
	 * @return the eSTATUS
	 */
	public String getESTATUS()
	{
		return ESTATUS;
	}


	/**
	 * @param eSTATUS the eSTATUS to set
	 */
	public void setESTATUS(final String eSTATUS)
	{
		ESTATUS = eSTATUS;
	}


	/**
	 * @return the cONTRIBUYENTE
	 */
	public String getCONTRIBUYENTE()
	{
		return CONTRIBUYENTE;
	}


	/**
	 * @param cONTRIBUYENTE the cONTRIBUYENTE to set
	 */
	public void setCONTRIBUYENTE(final String cONTRIBUYENTE)
	{
		CONTRIBUYENTE = cONTRIBUYENTE;
	}


	/**
	 * @return the cLASE_IDENTIFICACION
	 */
	public String getCLASE_IDENTIFICACION()
	{
		return CLASE_IDENTIFICACION;
	}


	/**
	 * @param cLASE_IDENTIFICACION the cLASE_IDENTIFICACION to set
	 */
	public void setCLASE_IDENTIFICACION(final String cLASE_IDENTIFICACION)
	{
		CLASE_IDENTIFICACION = cLASE_IDENTIFICACION;
	}


	/**
	 * @return the iD_IDENTIFICADOR
	 */
	public String getID_IDENTIFICADOR()
	{
		return ID_IDENTIFICADOR;
	}


	/**
	 * @param iD_IDENTIFICADOR the iD_IDENTIFICADOR to set
	 */
	public void setID_IDENTIFICADOR(final String iD_IDENTIFICADOR)
	{
		ID_IDENTIFICADOR = iD_IDENTIFICADOR;
	}


	/**
	 * @return the lINEA
	 */
	public String getLINEA()
	{
		return LINEA;
	}


	/**
	 * @param lINEA the lINEA to set
	 */
	public void setLINEA(final String lINEA)
	{
		LINEA = lINEA;
	}


	/**
	 * @return the iDENTIFICADOR
	 */
	public String getIDENTIFICADOR()
	{
		return IDENTIFICADOR;
	}


	/**
	 * @param iDENTIFICADOR the iDENTIFICADOR to set
	 */
	public void setIDENTIFICADOR(final String iDENTIFICADOR)
	{
		IDENTIFICADOR = iDENTIFICADOR;
	}


	/**
	 * @return the vALOR
	 */
	public String getVALOR()
	{
		return VALOR;
	}


	/**
	 * @param vALOR the vALOR to set
	 */
	public void setVALOR(final String vALOR)
	{
		VALOR = vALOR;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"NUM_CASO\":\"", this.getNUM_CASO(), "\","));
		stringBuilder.append(obtenerValorJson("\"NUM_RADICADO\":\"", this.getNUM_RADICADO(), "\","));
		stringBuilder.append(obtenerValorJson("\"PROCESS_TYPE\":\"", this.getPROCESS_TYPE(), "\","));
		stringBuilder.append(obtenerValorJson("\"ESTATUS\":\"", this.getESTATUS(), "\","));
		stringBuilder.append(obtenerValorJson("\"CONTRIBUYENTE\":\"", this.getCONTRIBUYENTE(), "\","));
		stringBuilder.append(obtenerValorJson("\"CLASE_IDENTIFICACION\":\"", this.getCLASE_IDENTIFICACION(), "\","));
		stringBuilder.append(obtenerValorJson("\"ID_IDENTIFICADOR\":\"", this.getID_IDENTIFICADOR(), "\","));
		stringBuilder.append(obtenerValorJson("\"LINEA\":\"", this.getLINEA(), "\","));
		stringBuilder.append(obtenerValorJson("\"IDENTIFICADOR\":\"", this.getIDENTIFICADOR(), "\","));
		stringBuilder.append(obtenerValorJson("\"VALOR\":\"", this.getVALOR(), "\""));
		stringBuilder.append("}");


		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}

}
