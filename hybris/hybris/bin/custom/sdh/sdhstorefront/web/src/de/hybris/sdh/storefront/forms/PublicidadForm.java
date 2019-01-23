/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ImpuestoPublicidadExterior;
import de.hybris.sdh.core.pojos.responses.detallePublicidad;
import de.hybris.sdh.core.pojos.responses.infoDeclaraPubli;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class PublicidadForm
{
	private String numBP;
	private String numResolu;
	private String anoGravable;
	private String fechResolu;
	private String fechNotif;
	private String vigenDesde;
	private String vigenHasta;
	private String tipoSolicitud;
	private List<infoDeclaraPubli> infdeclara;
	private List<detallePublicidad> detalle;
	private List<ImpuestoPublicidadExterior> publicidadExt;

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
	 * @return the numResolu
	 */
	public String getNumResolu()
	{
		return numResolu;
	}

	/**
	 * @param numResolu
	 *           the numResolu to set
	 */
	public void setNumResolu(final String numResolu)
	{
		this.numResolu = numResolu;
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
	 * @return the fechResolu
	 */
	public String getFechResolu()
	{
		return fechResolu;
	}

	/**
	 * @param fechResolu
	 *           the fechResolu to set
	 */
	public void setFechResolu(final String fechResolu)
	{
		this.fechResolu = fechResolu;
	}

	/**
	 * @return the fechNotif
	 */
	public String getFechNotif()
	{
		return fechNotif;
	}

	/**
	 * @param fechNotif
	 *           the fechNotif to set
	 */
	public void setFechNotif(final String fechNotif)
	{
		this.fechNotif = fechNotif;
	}

	/**
	 * @return the vigenDesde
	 */
	public String getVigenDesde()
	{
		return vigenDesde;
	}

	/**
	 * @param vigenDesde
	 *           the vigenDesde to set
	 */
	public void setVigenDesde(final String vigenDesde)
	{
		this.vigenDesde = vigenDesde;
	}

	/**
	 * @return the vigenHasta
	 */
	public String getVigenHasta()
	{
		return vigenHasta;
	}

	/**
	 * @param vigenHasta
	 *           the vigenHasta to set
	 */
	public void setVigenHasta(final String vigenHasta)
	{
		this.vigenHasta = vigenHasta;
	}

	/**
	 * @return the tipoSolicitud
	 */
	public String getTipoSolicitud()
	{
		return tipoSolicitud;
	}

	/**
	 * @param tipoSolicitud
	 *           the tipoSolicitud to set
	 */
	public void setTipoSolicitud(final String tipoSolicitud)
	{
		this.tipoSolicitud = tipoSolicitud;
	}

	/**
	 * @return the infdeclara
	 */
	public List<infoDeclaraPubli> getInfdeclara()
	{
		return infdeclara;
	}

	/**
	 * @param infdeclara
	 *           the infdeclara to set
	 */
	public void setInfdeclara(final List<infoDeclaraPubli> infdeclara)
	{
		this.infdeclara = infdeclara;
	}

	/**
	 * @return the detalle
	 */
	public List<detallePublicidad> getDetalle()
	{
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	public void setDetalle(final List<detallePublicidad> detalle)
	{
		this.detalle = detalle;
	}

	/**
	 * @return the publicidadExt
	 */
	public List<ImpuestoPublicidadExterior> getPublicidadExt()
	{
		return publicidadExt;
	}

	/**
	 * @param publicidadExt
	 *           the publicidadExt to set
	 */
	public void setPublicidadExt(final List<ImpuestoPublicidadExterior> publicidadExt)
	{
		this.publicidadExt = publicidadExt;
	}


}
