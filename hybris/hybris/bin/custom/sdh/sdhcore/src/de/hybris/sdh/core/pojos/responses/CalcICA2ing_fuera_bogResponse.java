/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class CalcICA2ing_fuera_bogResponse
{

	private String cod_CIIU;
	private String cod_municipio;
	private String ingresos;

	/**
	 * @return the cod_CIIU
	 */
	public String getCod_CIIU()
	{
		return cod_CIIU;
	}

	/**
	 * @param cod_CIIU
	 *           the cod_CIIU to set
	 */
	public void setCod_CIIU(final String cod_CIIU)
	{
		this.cod_CIIU = cod_CIIU;
	}

	/**
	 * @return the cod_municipio
	 */
	public String getCod_municipio()
	{
		return cod_municipio;
	}

	/**
	 * @param cod_municipio
	 *           the cod_municipio to set
	 */
	public void setCod_municipio(final String cod_municipio)
	{
		this.cod_municipio = cod_municipio;
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
		return "CalcICA2ing_fuera_bogResponse [cod_CIIU=" + cod_CIIU + ", cod_municipio=" + cod_municipio + ", ingresos=" + ingresos
				+ "]";
	}


}
