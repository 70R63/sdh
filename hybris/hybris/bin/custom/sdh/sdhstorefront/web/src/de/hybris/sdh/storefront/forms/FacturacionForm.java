/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.PredialResponse;
import de.hybris.sdh.core.pojos.responses.ResponsePredial;
import de.hybris.sdh.core.pojos.responses.ResponseVehicular;

import java.util.List;

/**
 * @author Maria Luisa
 *
 */
public class FacturacionForm
{
	private String numbp;
	private String anioGravable;
	private String numObjeto;
	private String periodo;
	private String placa;
	private String marca;
	private String chip;
	private String matricula;
	private String direccion;
	private List<ImpuestoVehiculos> vehicular;
	private List<PredialResponse> predial;
	private ResponseVehicular responseVehicular;
	private ResponsePredial responsePredial;




	/**
	 * @return the responseVehicular
	 */
	public ResponseVehicular getResponseVehicular()
	{
		return responseVehicular;
	}

	/**
	 * @param responseVehicular
	 *           the responseVehicular to set
	 */
	public void setResponseVehicular(final ResponseVehicular responseVehicular)
	{
		this.responseVehicular = responseVehicular;
	}

	/**
	 * @return the responsePredial
	 */
	public ResponsePredial getResponsePredial()
	{
		return responsePredial;
	}

	/**
	 * @param responsePredial
	 *           the responsePredial to set
	 */
	public void setResponsePredial(final ResponsePredial responsePredial)
	{
		this.responsePredial = responsePredial;
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
	 * @return the numObjeto
	 */
	public String getNumObjeto()
	{
		return numObjeto;
	}

	/**
	 * @param numObjeto
	 *           the numObjeto to set
	 */
	public void setNumObjeto(final String numObjeto)
	{
		this.numObjeto = numObjeto;
	}


	/**
	 * @return the numbp
	 */
	public String getNumbp()
	{
		return numbp;
	}

	/**
	 * @param numbp
	 *           the numbp to set
	 */
	public void setNumbp(final String numbp)
	{
		this.numbp = numbp;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo()
	{
		return periodo;
	}

	/**
	 * @param periodo
	 *           the periodo to set
	 */
	public void setPeriodo(final String periodo)
	{
		this.periodo = periodo;
	}

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
