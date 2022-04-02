/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ErrorEnWS;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class DescargaFacturaForm
{

	private String numBP;
	private String anoGravable;
	private String numObjeto;
	private String tipoOperacion;

	private String urlDownload;
	private List<ErrorEnWS> errores;

	private String fbnum;
	private String casef;
	private String i_laufi;
	private String i_periodo;


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
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		return anoGravable;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
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
	public void setErrores(final List<ErrorEnWS> errores)
	{
		this.errores = errores;
	}

	/**
	 * @return the tipoOperacion
	 */
	public String getTipoOperacion()
	{
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion
	 *           the tipoOperacion to set
	 */
	public void setTipoOperacion(final String tipoOperacion)
	{
		this.tipoOperacion = tipoOperacion;
	}

	/**
	 * @return the fbnum
	 */
	public String getFbnum()
	{
		return fbnum;
	}

	/**
	 * @param fbnum
	 *           the fbnum to set
	 */
	public void setFbnum(final String fbnum)
	{
		this.fbnum = fbnum;
	}

	/**
	 * @return the casef
	 */
	public String getCasef()
	{
		return casef;
	}

	/**
	 * @param casef
	 *           the casef to set
	 */
	public void setCasef(final String casef)
	{
		this.casef = casef;
	}

	/**
	 * @return the i_laufi
	 */
	public String getI_laufi()
	{
		return i_laufi;
	}

	/**
	 * @param i_laufi
	 *           the i_laufi to set
	 */
	public void setI_laufi(final String i_laufi)
	{
		this.i_laufi = i_laufi;
	}

	/**
	 * @return the i_periodo
	 */
	public String getI_periodo()
	{
		return i_periodo;
	}

	/**
	 * @param i_periodo
	 *           the i_periodo to set
	 */
	public void setI_periodo(final String i_periodo)
	{
		this.i_periodo = i_periodo;
	}


}
