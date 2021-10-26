/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;



/**
 * @author Federico Flores Dimas
 *
 */
public class PredialPresentarDecResponse
{

	private String stringPDF;
	private String referencia;
	private String fechavenc;
	private String total;
	private String bp;

	private List<ErrorEnWS> errores;

	private String urlDownload;


	/**
	 * @return the stringPDF
	 */
	public String getStringPDF()
	{
		return stringPDF;
	}

	/**
	 * @param stringPDF
	 *           the stringPDF to set
	 */
	@JsonSetter("PDF")
	public void setStringPDF(final String stringPDF)
	{
		this.stringPDF = stringPDF;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia()
	{
		return referencia;
	}

	/**
	 * @param referencia
	 *           the referencia to set
	 */
	@JsonSetter("REFERENCIA")
	public void setReferencia(final String referencia)
	{
		this.referencia = referencia;
	}

	/**
	 * @return the fechavenc
	 */
	public String getFechavenc()
	{
		return fechavenc;
	}

	/**
	 * @param fechavenc
	 *           the fechavenc to set
	 */
	@JsonSetter("FECHAVENC")
	public void setFechavenc(final String fechavenc)
	{
		this.fechavenc = fechavenc;
	}

	/**
	 * @return the total
	 */
	public String getTotal()
	{
		return total;
	}

	/**
	 * @param total
	 *           the total to set
	 */
	@JsonSetter("TOTAL")
	public void setTotal(final String total)
	{
		this.total = total;
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
	@JsonSetter("BP")
	public void setBp(final String bp)
	{
		this.bp = bp;
	}

	/**
	 * @return the errores
	 */
	public List<ErrorEnWS> getErrores()
	{
		return errores;
	}

	/**
	 * @param errores
	 *           the errores to set
	 */
	@JsonSetter("MENSAJES")
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}

	/**
	 * @return the urlDownload
	 */
	public String getUrlDownload()
	{
		return urlDownload;
	}

	/**
	 * @param urlDownload
	 *           the urlDownload to set
	 */
	public void setUrlDownload(final String urlDownload)
	{
		this.urlDownload = urlDownload;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PredialPresentarDecResponse [stringPDF=" + stringPDF + ", referencia=" + referencia + ", fechavenc=" + fechavenc
				+ ", total=" + total + ", bp=" + bp + ", errores=" + errores + ", urlDownload=" + urlDownload + "]";
	}



}
