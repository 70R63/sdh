/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class FacturacionForm
{

	private String placa;
	private String marca;
	private String chip;
	private String matricula;
	private String direccion;
	private List<ImpuestoVehiculos> vehicular;
	private List<PredialResponse> predial;

	/**
	 * @return the placa
	 */
	public String getPlaca()
	{
		return placa;
	}

	/**
	 * @param placa
	 *           the placa to set
	 */
	public void setPlaca(final String placa)
	{
		this.placa = placa;
	}

	/**
	 * @return the marca
	 */
	public String getMarca()
	{
		return marca;
	}

	/**
	 * @param marca
	 *           the marca to set
	 */
	public void setMarca(final String marca)
	{
		this.marca = marca;
	}

	/**
	 * @return the chip
	 */
	public String getChip()
	{
		return chip;
	}

	/**
	 * @param chip
	 *           the chip to set
	 */
	public void setChip(final String chip)
	{
		this.chip = chip;
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
	 * @return the direccion
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final String direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * @return the vehicular
	 */
	public List<ImpuestoVehiculos> getVehicular()
	{
		return vehicular;
	}

	/**
	 * @param vehicular
	 *           the vehicular to set
	 */
	public void setVehicular(final List<ImpuestoVehiculos> vehicular)
	{
		this.vehicular = vehicular;
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



}
