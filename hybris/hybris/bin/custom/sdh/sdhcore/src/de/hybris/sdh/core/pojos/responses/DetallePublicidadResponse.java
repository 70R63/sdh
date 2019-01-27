/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Maria Luisa
 *
 */
public class DetallePublicidadResponse
{


   private String fechResolu;
   private String fechNotif;
   private String vigenDesde;
   private String vigenHasta;
   private String tipoSolicitud;
   private String anoGravable;
   private String numResolu;
	private InfoDeclaraPubli infodeclara;
	private DetallePubli detalle;


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
	 * @return the infodeclara
	 */
	public InfoDeclaraPubli getInfodeclara()
	{
		return infodeclara;
	}

	/**
	 * @param infodeclara
	 *           the infodeclara to set
	 */
	public void setInfodeclara(final InfoDeclaraPubli infodeclara)
	{
		this.infodeclara = infodeclara;
	}

	/**
	 * @return the detalle
	 */
	public DetallePubli getDetalle()
	{
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	public void setDetalle(final DetallePubli detalle)
	{
		this.detalle = detalle;
	}


}