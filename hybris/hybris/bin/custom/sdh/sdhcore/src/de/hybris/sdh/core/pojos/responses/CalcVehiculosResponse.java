/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;



/**
 * @author hybris
 *
 */
public class CalcVehiculosResponse
{
	private String numForm;
	private String impuestoCargo;
	private String tarifaActual;
	private String sancion;
	private String intereses;
	private String valorSemafor;
	private String descuentoProntop;
	private String totalPagar;
	private String valorPagar;
	private String totalPagoVol;
	private String avaluo;
	private String descuentoadicional;
	private String descuentoconbustible;

	private List<ErrorPubli> errores;

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
	 * @return the impuestoCargo
	 */
	public String getImpuestoCargo()
	{
		return impuestoCargo;
	}

	/**
	 * @param impuestoCargo
	 *           the impuestoCargo to set
	 */
	public void setImpuestoCargo(final String impuestoCargo)
	{
		this.impuestoCargo = impuestoCargo;
	}

	/**
	 * @return the tarifaActual
	 */
	public String getTarifaActual()
	{
		return tarifaActual;
	}

	/**
	 * @param tarifaActual
	 *           the tarifaActual to set
	 */
	public void setTarifaActual(final String tarifaActual)
	{
		this.tarifaActual = tarifaActual;
	}

	/**
	 * @return the sancion
	 */
	public String getSancion()
	{
		return sancion;
	}

	/**
	 * @param sancion
	 *           the sancion to set
	 */
	public void setSancion(final String sancion)
	{
		this.sancion = sancion;
	}

	/**
	 * @return the intereses
	 */
	public String getIntereses()
	{
		return intereses;
	}

	/**
	 * @param intereses
	 *           the intereses to set
	 */
	public void setIntereses(final String intereses)
	{
		this.intereses = intereses;
	}

	/**
	 * @return the valorSemafor
	 */
	public String getValorSemafor()
	{
		return valorSemafor;
	}

	/**
	 * @param valorSemafor
	 *           the valorSemafor to set
	 */
	public void setValorSemafor(final String valorSemafor)
	{
		this.valorSemafor = valorSemafor;
	}

	/**
	 * @return the descuentoProntop
	 */
	public String getDescuentoProntop()
	{
		return descuentoProntop;
	}

	/**
	 * @param descuentoProntop
	 *           the descuentoProntop to set
	 */
	public void setDescuentoProntop(final String descuentoProntop)
	{
		this.descuentoProntop = descuentoProntop;
	}

	/**
	 * @return the totalPagar
	 */
	public String getTotalPagar()
	{
		return totalPagar;
	}

	/**
	 * @param totalPagar
	 *           the totalPagar to set
	 */
	public void setTotalPagar(final String totalPagar)
	{
		this.totalPagar = totalPagar;
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
	 * @return the totalPagoVol
	 */
	public String getTotalPagoVol()
	{
		return totalPagoVol;
	}

	/**
	 * @param totalPagoVol
	 *           the totalPagoVol to set
	 */
	public void setTotalPagoVol(final String totalPagoVol)
	{
		this.totalPagoVol = totalPagoVol;
	}

	/**
	 * @return the errores
	 */
	public List<ErrorPubli> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	public void setErrores(final List<ErrorPubli> errores)
	{
		this.errores = errores;
	}

	/**
	 * @return the avaluoActual
	 */
	public String getAvaluo()
	{
		return avaluo;
	}

	/**
	 * @param avaluoActual
	 *           the avaluoActual to set
	 */
	@JsonSetter("avaluoActual")
	public void setAvaluo(final String avaluo)
	{
		this.avaluo = avaluo;
	}

	/**
	 * @return the descuentoadicional
	 */
	public String getDescuentoadicional()
	{
		return descuentoadicional;
	}

	/**
	 * @param descuentoadicional
	 *           the descuentoadicional to set
	 */
	public void setDescuentoadicional(final String descuentoadicional)
	{
		this.descuentoadicional = descuentoadicional;
	}

	/**
	 * @return the descuentoconbustible
	 */
	public String getDescuentoconbustible()
	{
		return descuentoconbustible;
	}

	/**
	 * @param descuentoconbustible
	 *           the descuentoconbustible to set
	 */
	public void setDescuentoconbustible(final String descuentoconbustible)
	{
		this.descuentoconbustible = descuentoconbustible;
	}


}
