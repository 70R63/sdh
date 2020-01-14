/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class CalcICA2ing_netos_gravaResponse
{

	private String act_principal;
	private String cod_ciiu;
	private String ingresos;

	/**
	 * @return the act_principal
	 */
	public String getAct_principal()
	{
		return act_principal;
	}

	/**
	 * @param act_principal
	 *           the act_principal to set
	 */
	public void setAct_principal(final String act_principal)
	{
		this.act_principal = act_principal;
	}

	/**
	 * @return the cod_ciiu
	 */
	public String getCod_ciiu()
	{
		return cod_ciiu;
	}

	/**
	 * @param cod_ciiu
	 *           the cod_ciiu to set
	 */
	public void setCod_ciiu(final String cod_ciiu)
	{
		this.cod_ciiu = cod_ciiu;
	}

	/**
	 * @return the ingresos
	 */
	public String getIngresos()
	{
		return ingresos;
	}

	/**
	 * @param ingresos
	 *           the ingresos to set
	 */
	public void setIngresos(final String ingresos)
	{
		this.ingresos = ingresos;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "CalcICA2ing_netos_gravaResponse [act_principal=" + act_principal + ", cod_ciiu=" + cod_ciiu + ", ingresos="
				+ ingresos + "]";
	}


}
