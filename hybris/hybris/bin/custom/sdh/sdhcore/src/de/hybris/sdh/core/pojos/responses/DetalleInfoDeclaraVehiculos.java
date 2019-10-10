/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Consultor
 *
 */
public class DetalleInfoDeclaraVehiculos
{

	private Infovehic infoVeh;
	private String liquidacion;

	private List<ErrorEnWS> errores;

	/**
	 * @return the infoVeh
	 */
	public Infovehic getInfoVeh()
	{
		return infoVeh;
	}

	/**
	 * @param infoVeh
	 *           the infoVeh to set
	 */
	public void setInfoVeh(final Infovehic infoVeh)
	{
		this.infoVeh = infoVeh;
	}

	/**
	 * @return the liquidacion
	 */
	public String getLiquidacion()
	{
		return liquidacion;
	}

	/**
	 * @param liquidacion
	 *           the liquidacion to set
	 */
	public void setLiquidacion(final String liquidacion)
	{
		this.liquidacion = liquidacion;
	}

	/**
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}


}
