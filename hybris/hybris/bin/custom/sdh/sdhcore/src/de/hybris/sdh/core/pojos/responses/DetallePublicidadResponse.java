/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;


/**
 * @author Maria Luisa
 *
 */
public class DetallePublicidadResponse
{
	private InfoDeclaraPubli infoDeclara;
   private String fechResolu;
   private String fechNotif;
   private String vigenDesde;
   private String vigenHasta;
   private String tipoSolicitud;
   private String anoGravable;
   private String numResolu;
	private String direccion;
	private String placa;
	private List<DetallePubli> detalle;
	private List<ErrorEnWS> errores;


	/**
	 * @return the direccion
	 */
	public String getDireccion()
	{
		return direccion;
	}

	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final String direccion)
	{
		this.direccion = direccion;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca()
	{
		return placa;
	}

	/**
	 * @param placa
	 *           the placa to set
	 */
	public void setPlaca(final String placa)
	{
		this.placa = placa;
	}

	/**
	 * @return the infoDeclara
	 */
	public InfoDeclaraPubli getInfoDeclara()
	{
		return infoDeclara;
	}

	/**
	 * @param infoDeclara
	 *           the infoDeclara to set
	 */
	public void setInfoDeclara(final InfoDeclaraPubli infoDeclara)
	{
		this.infoDeclara = infoDeclara;
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
	 * @return the detalle
	 */
	public List<DetallePubli> getDetalle()
	{
		return detalle;
	}

	/**
	 * @param detalle
	 *           the detalle to set
	 */
	public void setDetalle(final List<DetallePubli> detalle)
	{
		this.detalle = detalle;
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

}
