/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author edson.roa
 *
 */
public class ImpuestoDelineacionUrbanaWithRadicados
{
	private String numObjeto;
	private String cdu;
	private String licenConst;
	private String fechaExp;
	private String fechaReval;
	private String fechFinObra;
	private String fechaEjecutoria;
	private List<DetRadicadosResponse> radicados;

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
	 * @return the cdu
	 */
	public String getCdu()
	{
		return cdu;
	}

	/**
	 * @param cdu
	 *           the cdu to set
	 */
	public void setCdu(final String cdu)
	{
		this.cdu = cdu;
	}

	/**
	 * @return the licenConst
	 */
	public String getLicenConst()
	{
		return licenConst;
	}

	/**
	 * @param licenConst
	 *           the licenConst to set
	 */
	public void setLicenConst(final String licenConst)
	{
		this.licenConst = licenConst;
	}

	/**
	 * @return the fechaExp
	 */
	public String getFechaExp()
	{
		return fechaExp;
	}

	/**
	 * @param fechaExp
	 *           the fechaExp to set
	 */
	public void setFechaExp(final String fechaExp)
	{
		this.fechaExp = fechaExp;
	}

	/**
	 * @return the fechaReval
	 */
	public String getFechaReval()
	{
		return fechaReval;
	}

	/**
	 * @param fechaReval
	 *           the fechaReval to set
	 */
	public void setFechaReval(final String fechaReval)
	{
		this.fechaReval = fechaReval;
	}

	/**
	 * @return the fechFinObra
	 */
	public String getFechFinObra()
	{
		return fechFinObra;
	}

	/**
	 * @param fechFinObra
	 *           the fechFinObra to set
	 */
	public void setFechFinObra(final String fechFinObra)
	{
		this.fechFinObra = fechFinObra;
	}

	/**
	 * @return the fechaEjecutoria
	 */
	public String getFechaEjecutoria()
	{
		return fechaEjecutoria;
	}

	/**
	 * @param fechaEjecutoria
	 *           the fechaEjecutoria to set
	 */
	public void setFechaEjecutoria(final String fechaEjecutoria)
	{
		this.fechaEjecutoria = fechaEjecutoria;
	}

	/**
	 * @return the radicados
	 */
	public List<DetRadicadosResponse> getRadicados()
	{
		return radicados;
	}

	/**
	 * @param radicados
	 *           the radicados to set
	 */
	public void setRadicados(final List<DetRadicadosResponse> radicados)
	{
		this.radicados = radicados;
	}


}
