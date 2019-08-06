/**
 *
 */
package de.hybris.sdh.core.constants;

import java.util.HashMap;


/**
 * @author edson.roa
 *
 */
public class ControllerPseConstants
{
	public final static String PREDIAL 		= "5101";
	public final static String DELINEACION = "5106"; //0607
	public final static String VEHICULAR 	= "5103";
	public final static String PUBLICIDAD 	= "5154";
	public final static String GASOLINA 	= "0108";
	public final static String ICA 			= "5102";
	public final static String RETENCIONDU = "5132"; //3207
	public final static String SOBRETASA 	= "XXXX";
	public final static String RETEICA 		= "5131";

	public final static String DEBITO 	= "01";
	public final static String CREDITO 	= "02";

	public final static String CC 	= "CC";
	public final static String NIT 	= "NIT";
	public final static String CE 	= "CE";
	public final static String TI 	= "TE";
	public final static String PP 	= "PP";

	public final static String ACH_PSE 		= "ACH";
	public final static String CREDIBANCO 	= "CRE";

	public final static String SI = "S";
	public final static String NO = "N";

	private final static String PSE_PROC_PAGO_DEBITO 	= "03";
	private final static String PSE_PROC_PAGO_CREDITO 	= "04";
	public final static HashMap<String, String> PSE_PROC_PAGO = new HashMap<String, String>()
	{
		{
			put(DEBITO, PSE_PROC_PAGO_DEBITO);
			put(CREDITO, PSE_PROC_PAGO_CREDITO);
		}
	};

	private final static String DEBITO_EN_CUENTA_POR_INTERNET 					= "15";
	private final static String TARJETA_CREDITO_VISA 								= "50";
	private final static String TARJETA_CREDITO_MASTERCARD 						= "51";
	private final static String TARJETA_CREDITO_DINERR_CLUB 						= "52";
	private final static String TARJETA_CREDITO_PROPIA_ENTIDAD_FINANCIERA 	= "53";
	private final static String CRETIDO_ROTATIVO 									= "54";
	private final static String TRAJETA_CREDITO_MASTER_CARD 						= "55";
	public final static HashMap<String, String> NOTIFICACION_DE_PAGO_MEDIO_PAGO = new HashMap<String, String>()
	{
		{
			put(DEBITO, DEBITO_EN_CUENTA_POR_INTERNET);
			put(CREDITO, TARJETA_CREDITO_VISA);
			put(CREDITO, TARJETA_CREDITO_MASTERCARD);
			put(CREDITO, TARJETA_CREDITO_DINERR_CLUB);
			put(CREDITO, TARJETA_CREDITO_PROPIA_ENTIDAD_FINANCIERA);
			put(CREDITO, CRETIDO_ROTATIVO);
			put(CREDITO, TRAJETA_CREDITO_MASTER_CARD);
		}
	};

	public final static String CREDIBANCO_RESPONSE_PENDIENTE = "0";
	public final static String CREDIBANCO_RESPONSE_APROBADA 	= "1";
	public final static String CREDIBANCO_RESPONSE_RECHAZADA = "2";
	public final static String CREDIBANCO_RESPONSE_FALLIDA 	= "3";


	public ControllerPseConstants()
	{

	}



	/**
	 * @return the pREDIAL
	 */
	public String getPREDIAL()
	{
		return PREDIAL;
	}



	/**
	 * @return the dELINEACION
	 */
	public String getDELINEACION()
	{
		return DELINEACION;
	}



	/**
	 * @return the vEHICULAR
	 */
	public String getVEHICULAR()
	{
		return VEHICULAR;
	}



	/**
	 * @return the pUBLICIDAD
	 */
	public String getPUBLICIDAD()
	{
		return PUBLICIDAD;
	}



	/**
	 * @return the gASOLINA
	 */
	public String getGASOLINA()
	{
		return GASOLINA;
	}



	/**
	 * @return the iCA
	 */
	public String getICA()
	{
		return ICA;
	}



	/**
	 * @return the rETENCIONDU
	 */
	public String getRETENCIONDU()
	{
		return RETENCIONDU;
	}



	/**
	 * @return the sOBRETASA
	 */
	public String getSOBRETASA()
	{
		return SOBRETASA;
	}



	/**
	 * @return the rETEICA
	 */
	public String getRETEICA()
	{
		return RETEICA;
	}



	/**
	 * @return the predial
	 */
	public static String getPredial()
	{
		return PREDIAL;
	}



	/**
	 * @return the delineacion
	 */
	public static String getDelineacion()
	{
		return DELINEACION;
	}



	/**
	 * @return the vehicular
	 */
	public static String getVehicular()
	{
		return VEHICULAR;
	}



	/**
	 * @return the publicidad
	 */
	public static String getPublicidad()
	{
		return PUBLICIDAD;
	}



	/**
	 * @return the gasolina
	 */
	public static String getGasolina()
	{
		return GASOLINA;
	}



	/**
	 * @return the ica
	 */
	public static String getIca()
	{
		return ICA;
	}



	/**
	 * @return the retenciondu
	 */
	public static String getRetenciondu()
	{
		return RETENCIONDU;
	}



	/**
	 * @return the sobretasa
	 */
	public static String getSobretasa()
	{
		return SOBRETASA;
	}



	/**
	 * @return the reteica
	 */
	public static String getReteica()
	{
		return RETEICA;
	}



	/**
	 * @return the debito
	 */
	public static String getDebito()
	{
		return DEBITO;
	}



	/**
	 * @return the credito
	 */
	public static String getCredito()
	{
		return CREDITO;
	}



	/**
	 * @return the cc
	 */
	public static String getCc()
	{
		return CC;
	}



	/**
	 * @return the nit
	 */
	public static String getNit()
	{
		return NIT;
	}



	/**
	 * @return the ce
	 */
	public static String getCe()
	{
		return CE;
	}



	/**
	 * @return the ti
	 */
	public static String getTi()
	{
		return TI;
	}



	/**
	 * @return the pp
	 */
	public static String getPp()
	{
		return PP;
	}



	/**
	 * @return the achPse
	 */
	public static String getAchPse()
	{
		return ACH_PSE;
	}



	/**
	 * @return the credibanco
	 */
	public static String getCredibanco()
	{
		return CREDIBANCO;
	}



	/**
	 * @return the si
	 */
	public static String getSi()
	{
		return SI;
	}



	/**
	 * @return the no
	 */
	public static String getNo()
	{
		return NO;
	}



	/**
	 * @return the pseProcPagoDebito
	 */
	public static String getPseProcPagoDebito()
	{
		return PSE_PROC_PAGO_DEBITO;
	}



	/**
	 * @return the pseProcPagoCredito
	 */
	public static String getPseProcPagoCredito()
	{
		return PSE_PROC_PAGO_CREDITO;
	}



	/**
	 * @return the pseProcPago
	 */
	public static HashMap<String, String> getPseProcPago()
	{
		return PSE_PROC_PAGO;
	}



	/**
	 * @return the credibancoResponsePendiente
	 */
	public static String getCredibancoResponsePendiente()
	{
		return CREDIBANCO_RESPONSE_PENDIENTE;
	}



	/**
	 * @return the credibancoResponseAprobada
	 */
	public static String getCredibancoResponseAprobada()
	{
		return CREDIBANCO_RESPONSE_APROBADA;
	}



	/**
	 * @return the credibancoResponseRechazada
	 */
	public static String getCredibancoResponseRechazada()
	{
		return CREDIBANCO_RESPONSE_RECHAZADA;
	}



	/**
	 * @return the credibancoResponseFallida
	 */
	public static String getCredibancoResponseFallida()
	{
		return CREDIBANCO_RESPONSE_FALLIDA;
	}




}
