/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ItemSelectOption;

import java.util.List;
import java.util.Map;


/**
 * @author Federico Flores Dimas
 *
 */
public class ICADeclaracionCatalogos
{

	private Map<String, String> valor_retenido_meses;
	private List<ItemSelectOption> valor_retenido_dias;
	private String diasMes1;

	/**
	 * @return the valor_retenido_meses
	 */
	public Map<String, String> getValor_retenido_meses()
	{
		return valor_retenido_meses;
	}

	/**
	 * @param valor_retenido_meses
	 *           the valor_retenido_meses to set
	 */
	public void setValor_retenido_meses(final Map<String, String> valor_retenido_meses)
	{
		this.valor_retenido_meses = valor_retenido_meses;
	}
	/**
	 * @return the valor_retenido_dias
	 */
	public List<ItemSelectOption> getValor_retenido_dias()
	{
		return valor_retenido_dias;
	}

	/**
	 * @param valor_retenido_dias
	 *           the valor_retenido_dias to set
	 */
	public void setValor_retenido_dias(final List<ItemSelectOption> valor_retenido_dias)
	{
		this.valor_retenido_dias = valor_retenido_dias;
	}

	/**
	 * @return the diasMes1
	 */
	public String getDiasMes1()
	{
		return diasMes1;
	}

	/**
	 * @param diasMes1
	 *           the diasMes1 to set
	 */
	public void setDiasMes1(final String diasMes1)
	{
		this.diasMes1 = diasMes1;
	}



}
