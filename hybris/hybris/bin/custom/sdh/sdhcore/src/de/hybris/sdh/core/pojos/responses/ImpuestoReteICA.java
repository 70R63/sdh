/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Consultor
 *
 */
public class ImpuestoReteICA
{
	private String numObjeto;
	private String numID;
    private String consecutivo;





    /**
     * @return the consecutivo
     */
    public String getConsecutivo()
    {
        return consecutivo;
    }

    /**
     * @param consecutivo
     *           the consecutivo to set
     */
    public void setConsecutivo(final String consecutivo)
    {
        this.consecutivo = consecutivo;
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

	/**
	 * @return the numID
	 */
	public String getNumID()
	{
		return numID;
	}

	/**
	 * @param numID
	 *           the numID to set
	 */
	public void setNumID(final String numID)
	{
		this.numID = numID;
	}


}
