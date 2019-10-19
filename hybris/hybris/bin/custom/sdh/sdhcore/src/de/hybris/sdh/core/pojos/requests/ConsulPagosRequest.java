/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Federico Flores Dimas
 *
 */
public class ConsulPagosRequest
{
	private String bp;
	private String impuesto;
	private String anioGravable;
	private String numObjeto;
	private String periodo;



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
	 * @return the bp
	 */
	public String getBp()
	{
		return bp;
	}

	/**
	 * @param bp
	 *           the bp to set
	 */
	public void setBp(final String bp)
	{
		this.bp = bp;
	}

	/**
	 * @return the impuesto
	 */
	public String getImpuesto()
	{
		return impuesto;
	}

	/**
	 * @param impuesto
	 *           the impuesto to set
	 */
	public void setImpuesto(final String impuesto)
	{
		this.impuesto = impuesto;
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

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"BP\":\"" + this.getBp() + "\",");
		stringBuilder.append("\"impuesto\":\"" + this.getImpuesto() + "\",");
		stringBuilder.append("\"anioGravable\":\"" + this.getAnioGravable() + "\",");
		stringBuilder.append("\"periodo\":\"" + this.getPeriodo() + "\",");
		stringBuilder.append("\"numObjeto\":\"" + this.getNumObjeto() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}


}
