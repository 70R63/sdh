/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class ConsCasosResultadoResponse
{

	private String process_type;
	private String esctructura;
	private String campo;
	private String factor;
	
	/**
	 * @return the process_type
	 */
	public String getProcess_type()
	{
		return process_type;
	}
	
	/**
	 * @param process_type
	 *           the process_type to set
	 */
	public void setProcess_type(final String process_type)
	{
		this.process_type = process_type;
	}
	
	/**
	 * @return the esctructura
	 */
	public String getEsctructura()
	{
		return esctructura;
	}
	
	/**
	 * @param esctructura
	 *           the esctructura to set
	 */
	public void setEsctructura(final String esctructura)
	{
		this.esctructura = esctructura;
	}
	
	/**
	 * @return the campo
	 */
	public String getCampo()
	{
		return campo;
	}
	
	/**
	 * @param campo
	 *           the campo to set
	 */
	public void setCampo(final String campo)
	{
		this.campo = campo;
	}
	
	/**
	 * @return the factor
	 */
	public String getFactor()
	{
		return factor;
	}
	
	/**
	 * @param factor
	 *           the factor to set
	 */
	public void setFactor(final String factor)
	{
		this.factor = factor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ConsCasosResultadoResponse [process_type=" + process_type + ", esctructura=" + esctructura + ", campo=" + campo
				+ ", factor=" + factor + "]";
	}



}
