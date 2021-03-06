/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Consultor
 *
 */
public class ConsultaPagoRequest
{
	private String numBP;
	private String numObjeto;
	private String impuesto;
	private String anioGravable;
	private String periodo;



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
	 * @return the numBP
	 */
	public String getNumBP()
	{
		return numBP;
	}

	/**
	 * @param numBP
	 *           the numBP to set
	 */
	public void setNumBP(final String numBP)
	{
		this.numBP = numBP;
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
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");

		if (this.getPeriodo() != null)
		{
			stringBuilder.append("\"periodo\":\"" + this.getPeriodo() + "\",");
		}

		if (this.getImpuesto() != null)
		{
			stringBuilder.append("\"impuesto\":\"" + this.getImpuesto() + "\",");
		}

		if (this.getAnioGravable() != null)
		{
			if (this.getNumObjeto() != null)
			{
				stringBuilder.append("\"anioGravable\":\"" + this.getAnioGravable() + "\",");
			}
			else
			{
				stringBuilder.append("\"anioGravable\":\"" + this.getAnioGravable() + "\"");
			}

		}

		if (this.getNumObjeto() != null)
		{
		stringBuilder.append("\"numObjeto\":\"" + this.getNumObjeto() + "\"");
		}

		stringBuilder.append("}");


		return stringBuilder.toString();
	}


}
