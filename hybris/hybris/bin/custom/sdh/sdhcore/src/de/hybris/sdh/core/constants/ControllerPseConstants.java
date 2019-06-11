/**
 *
 */
package de.hybris.sdh.core.constants;

/**
 * @author edson.roa
 *
 */
public class ControllerPseConstants
{
	private final String PREDIAL;
	private final String DELINEACION;
	private final String VEHICULAR;
	private final String PUBLICIDAD;
	private final String GASOLINA;
	private final String ICA;
	private final String RETENCIONDU;
	private final String SOBRETASA;
	private final String RETEICA;



	public ControllerPseConstants()
	{

		//PREDIAL = "PREDIAL";
		//DELINEACION = "2306";
		//VEHICULAR = "VEHICULAR";
		//PUBLICIDAD = "5154";
		//GASOLINA = "2308";
		//ICA = "ICA";
		//RETENCIONDU = "2332";

		PREDIAL = "01";
		ICA = "02";
		VEHICULAR = "03";
		DELINEACION = "06";
		SOBRETASA = "08";
		RETEICA = "31";
		RETENCIONDU = "32";
		PUBLICIDAD = "54";
		GASOLINA = "2308"; // no se eucuentra en la tabla


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




}
