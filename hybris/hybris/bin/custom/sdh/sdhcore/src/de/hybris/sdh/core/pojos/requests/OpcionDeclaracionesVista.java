/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.ErrorEnWS;
import de.hybris.sdh.core.pojos.responses.ImpuestoDelineacionUrbanaWithRadicados;
import de.hybris.sdh.core.pojos.responses.ImpuestoGasolina;
import de.hybris.sdh.core.pojos.responses.ImpuestoICA;
import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.ImpuestoVehiculos;
import de.hybris.sdh.core.pojos.responses.OpcionDeclaracionesPDFResponse;
import de.hybris.sdh.core.pojos.responses.ReteICA;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class OpcionDeclaracionesVista
{
	private String claveImpuesto;
	private String anoGravable;
	private String periodo;
	private String objContrato;
	private String urlDownload;
	private OpcionDeclaracionesPDFResponse declaraPDFResponse;
	private OpcionDeclaracionesCatalogos catalogos;
	private List<ErrorEnWS> errores;

	private List<ImpuestoPublicidadExterior> publicidadExt;
	private List<ImpuestoGasolina> gasolina;
	private List<ImpuestoDelineacionUrbanaWithRadicados> delineacion;
	private ImpuestoICA ica;
	private ReteICA reteIca;
	private List<ImpuestoVehiculos> vehicular; //Se agrega la  parte de vehiculos del response


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

	private SDHValidaMailRolResponse customerData;

	/**
	 * @return the customerData
	 */
	public SDHValidaMailRolResponse getCustomerData()
	{
		return customerData;
	}

	/**
	 * @param customerData
	 *           the customerData to set
	 */
	public void setCustomerData(final SDHValidaMailRolResponse customerData)
	{
		this.customerData = customerData;
	}

	/**
	 * @return the claveImpuesto
	 */
	public String getClaveImpuesto()
	{
		return claveImpuesto;
	}

	/**
	 * @param claveImpuesto
	 *           the claveImpuesto to set
	 */
	public void setClaveImpuesto(final String claveImpuesto)
	{
		this.claveImpuesto = claveImpuesto;
	}

	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
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
	 * @return the objContrato
	 */
	public String getObjContrato()
	{
		return objContrato;
	}

	/**
	 * @param objContrato
	 *           the objContrato to set
	 */
	public void setObjContrato(final String objContrato)
	{
		this.objContrato = objContrato;
	}

	/**
	 * @return the urlDownload
	 */
	public String getUrlDownload()
	{
		return urlDownload;
	}

	/**
	 * @param urlDownload
	 *           the urlDownload to set
	 */
	public void setUrlDownload(final String urlDownload)
	{
		this.urlDownload = urlDownload;
	}

	/**
	 * @return the declaraPDFResponse
	 */
	public OpcionDeclaracionesPDFResponse getDeclaraPDFResponse()
	{
		return declaraPDFResponse;
	}

	/**
	 * @param declaraPDFResponse
	 *           the declaraPDFResponse to set
	 */
	public void setDeclaraPDFResponse(final OpcionDeclaracionesPDFResponse declaraPDFResponse)
	{
		this.declaraPDFResponse = declaraPDFResponse;
	}
	/**
	 * @return the catalogos
	 */
	public OpcionDeclaracionesCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final OpcionDeclaracionesCatalogos catalogos)
	{
		this.catalogos = catalogos;
	}

	/**
	 * @return the publicidadExt
	 */
	public List<ImpuestoPublicidadExterior> getPublicidadExt()
	{
		return publicidadExt;
	}

	/**
	 * @param publicidadExt
	 *           the publicidadExt to set
	 */
	public void setPublicidadExt(final List<ImpuestoPublicidadExterior> publicidadExt)
	{
		this.publicidadExt = publicidadExt;
	}

	/**
	 * @return the gasolina
	 */
	public List<ImpuestoGasolina> getGasolina()
	{
		return gasolina;
	}

	/**
	 * @param gasolina
	 *           the gasolina to set
	 */
	public void setGasolina(final List<ImpuestoGasolina> gasolina)
	{
		this.gasolina = gasolina;
	}

	/**
	 * @return the delineacion
	 */
	public List<ImpuestoDelineacionUrbanaWithRadicados> getDelineacion()
	{
		return delineacion;
	}

	/**
	 * @param delineacion
	 *           the delineacion to set
	 */
	public void setDelineacion(final List<ImpuestoDelineacionUrbanaWithRadicados> delineacion)
	{
		this.delineacion = delineacion;
	}

	/**
	 * @return the ica
	 */
	public ImpuestoICA getIca()
	{
		return ica;
	}

	/**
	 * @param ica
	 *           the ica to set
	 */
	public void setIca(final ImpuestoICA ica)
	{
		this.ica = ica;
	}

	/**
	 * @return the reteIca
	 */
	public ReteICA getReteIca()
	{
		return reteIca;
	}

	/**
	 * @param reteIca
	 *           the reteIca to set
	 */
	public void setReteIca(final ReteICA reteIca)
	{
		this.reteIca = reteIca;
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




}
