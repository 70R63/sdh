/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Praxis
 *
 */
public class ConsultarBPRequest
{
	private String numid;
	private String tipoid;
	private String fechExp;


	/**
	 * @return the numid
	 */
	public String getNumid()
	{
		return numid;
	}

	/**
	 * @param numid
	 *           the numid to set
	 */
	public void setNumid(final String numid)
	{
		this.numid = numid;
	}

	/**
	 * @return the tipoid
	 */
	public String getTipoid()
	{
		return tipoid;
	}

	/**
	 * @param tipoid
	 *           the tipoid to set
	 */
	public void setTipoid(final String tipoid)
	{
		this.tipoid = tipoid;
	}

	/**
	 * @return the fechExp
	 */
	public String getFechExp()
	{
		return fechExp;
	}

	/**
	 * @param fechExp
	 *           the fechExp to set
	 */
	public void setFechExp(final String fechExp)
	{
		this.fechExp = fechExp;
	}


	@Override
	public String toString()
	{
		return "{ \"numid\":\"" + numid + "\", \"tipoid\":\"" + tipoid + "\", \"fechExp\":\"" + fechExp + "\"}";
	}







}
