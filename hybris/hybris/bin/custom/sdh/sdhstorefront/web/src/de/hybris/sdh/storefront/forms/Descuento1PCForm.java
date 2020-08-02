/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.platform.commercefacades.user.data.CustomerData;


/**
 * @author Federico Flores Dimas
 *
 */
public class Descuento1PCForm
{

	private CustomerData customerData;
	private Descuento1PCCatalogos catalogos;
	private DescargaFacturaForm descargaFactura;

	/**
	 * @return the customerData
	 */
	public CustomerData getCustomerData()
	{
		return customerData;
	}

	/**
	 * @param customerData
	 *           the customerData to set
	 */
	public void setCustomerData(final CustomerData customerData)
	{
		this.customerData = customerData;
	}

	/**
	 * @return the catalogos
	 */
	public Descuento1PCCatalogos getCatalogos()
	{
		return catalogos;
	}

	/**
	 * @param catalogos
	 *           the catalogos to set
	 */
	public void setCatalogos(final Descuento1PCCatalogos catalogos)
	{
		this.catalogos = catalogos;
	}

	/**
	 * @return the descargaFactura
	 */
	public DescargaFacturaForm getDescargaFactura()
	{
		return descargaFactura;
	}

	/**
	 * @param descargaFactura
	 *           the descargaFactura to set
	 */
	public void setDescargaFactura(final DescargaFacturaForm descargaFactura)
	{
		this.descargaFactura = descargaFactura;
	}




}
