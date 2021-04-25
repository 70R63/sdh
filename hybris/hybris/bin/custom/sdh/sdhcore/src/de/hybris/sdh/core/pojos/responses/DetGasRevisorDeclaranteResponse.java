/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Administrator
 *
 */
public class DetGasRevisorDeclaranteResponse
{

	String tipoInterloc;
	String tipoDoc;
	String numDoc;
	String nombres;
	String tarjetaProf;
	String tipoDocDESC;


	/**
	 * @return the tipoInterloc
	 */
	public String getTipoInterloc()
	{
		return tipoInterloc;
	}

	/**
	 * @param tipoInterloc
	 *           the tipoInterloc to set
	 */
	public void setTipoInterloc(final String tipoInterloc)
	{
		this.tipoInterloc = tipoInterloc;
	}

	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc()
	{
		return tipoDoc;
	}

	/**
	 * @param tipoDoc
	 *           the tipoDoc to set
	 */
	public void setTipoDoc(final String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc()
	{
		return numDoc;
	}

	/**
	 * @param numDoc
	 *           the numDoc to set
	 */
	public void setNumDoc(final String numDoc)
	{
		this.numDoc = numDoc;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres()
	{
		return nombres;
	}

	/**
	 * @param nombres
	 *           the nombres to set
	 */
	public void setNombres(final String nombres)
	{
		this.nombres = nombres;
	}

	/**
	 * @return the tarjetaProf
	 */
	public String getTarjetaProf()
	{
		return tarjetaProf;
	}

	/**
	 * @param tarjetaProf
	 *           the tarjetaProf to set
	 */
	public void setTarjetaProf(final String tarjetaProf)
	{
		this.tarjetaProf = tarjetaProf;
	}

	/**
	 * @return the tipoDocDESC
	 */
	public String getTipoDocDESC()
	{
		return tipoDocDESC;
	}

	/**
	 * @param tipoDocDESC
	 *           the tipoDocDESC to set
	 */
	public void setTipoDocDESC(final String tipoDocDESC)
	{
		this.tipoDocDESC = tipoDocDESC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetGasRevisorDeclaranteResponse [tipoInterloc=" + tipoInterloc + ", tipoDoc=" + tipoDoc + ", numDoc=" + numDoc
				+ ", nombres=" + nombres + ", tarjetaProf=" + tarjetaProf + ", tipoDocDESC=" + tipoDocDESC + "]";
	}

}