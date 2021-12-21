/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Praxis
 *
 */
public class Relacionpagosrespons
{
	private RelacionPagosPredial predialUnificado;
	private RelacionPagosGasolina sobretasaGasolina;
	private RelacionPagosICA impuestoICA;
	private List<RelacionPagosDelineacion> delineacionUrbana;
	private RelacionPagosPublicidad publicidadexterior;
	private RelacionPagosVehicular vehicular;
	private String strpdf;



	/**
	 * @return the strpdf
	 */
	public String getStrpdf()
	{
		return strpdf;
	}

	/**
	 * @param strpdf
	 *           the strpdf to set
	 */
	@JsonSetter("STRPDF")
	public void setStrpdf(final String strpdf)
	{
		this.strpdf = strpdf;
	}

	/**
	 * @return the predialUnificado
	 */
	public RelacionPagosPredial getPredialUnificado()
	{
		return predialUnificado;
	}

	/**
	 * @param predialUnificado
	 *           the predialUnificado to set
	 */
	@JsonSetter("PredialUnificado")
	public void setPredialUnificado(final RelacionPagosPredial predialUnificado)
	{
		this.predialUnificado = predialUnificado;
	}

	/**
	 * @return the sobretasaGasolina
	 */
	public RelacionPagosGasolina getSobretasaGasolina()
	{
		return sobretasaGasolina;
	}

	/**
	 * @param sobretasaGasolina
	 *           the sobretasaGasolina to set
	 */
	@JsonSetter("SobretasaGasolina")
	public void setSobretasaGasolina(final RelacionPagosGasolina sobretasaGasolina)
	{
		this.sobretasaGasolina = sobretasaGasolina;
	}

	/**
	 * @return the impuestoICA
	 */
	public RelacionPagosICA getImpuestoICA()
	{
		return impuestoICA;
	}

	/**
	 * @param impuestoICA
	 *           the impuestoICA to set
	 */
	public void setImpuestoICA(final RelacionPagosICA impuestoICA)
	{
		this.impuestoICA = impuestoICA;
	}

	/**
	 * @return the delineacionUrbana
	 */
	public List<RelacionPagosDelineacion> getDelineacionUrbana()
	{
		return delineacionUrbana;
	}

	/**
	 * @param delineacionUrbana
	 *           the delineacionUrbana to set
	 */
	@JsonSetter("DelineacionUrbana")
	public void setDelineacionUrbana(final List<RelacionPagosDelineacion> delineacionUrbana)
	{
		this.delineacionUrbana = delineacionUrbana;
	}

	/**
	 * @return the publicidadexterior
	 */
	public RelacionPagosPublicidad getPublicidadexterior()
	{
		return publicidadexterior;
	}

	/**
	 * @param publicidadexterior
	 *           the publicidadexterior to set
	 */
	@JsonSetter("Publicidadexterior")
	public void setPublicidadexterior(final RelacionPagosPublicidad publicidadexterior)
	{
		this.publicidadexterior = publicidadexterior;
	}

	/**
	 * @return the vehicular
	 */
	public RelacionPagosVehicular getVehicular()
	{
		return vehicular;
	}

	/**
	 * @param vehicular
	 *           the vehicular to set
	 */
	@JsonSetter("Vehicular")
	public void setVehicular(final RelacionPagosVehicular vehicular)
	{
		this.vehicular = vehicular;
	}








}
