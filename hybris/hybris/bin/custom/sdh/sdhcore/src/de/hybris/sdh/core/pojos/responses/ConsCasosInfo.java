/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class ConsCasosInfo
{
	private String num_caso;
	private String num_radicado;
	private String tramite;
	private String estatus;
	private String cat01;
	private String cat02;
	private String cat03;
	private String cat04;
	private String mensaje;
	private ConsCasosArchiResponse archivos;


	/**
	 * @return the cat01
	 */
	public String getCat01()
	{
		return cat01;
	}

	/**
	 * @param cat01
	 *           the cat01 to set
	 */
	public void setCat01(final String cat01)
	{
		this.cat01 = cat01;
	}

	/**
	 * @return the cat02
	 */
	public String getCat02()
	{
		return cat02;
	}

	/**
	 * @param cat02
	 *           the cat02 to set
	 */
	public void setCat02(final String cat02)
	{
		this.cat02 = cat02;
	}

	/**
	 * @return the cat03
	 */
	public String getCat03()
	{
		return cat03;
	}

	/**
	 * @param cat03
	 *           the cat03 to set
	 */
	public void setCat03(final String cat03)
	{
		this.cat03 = cat03;
	}

	/**
	 * @return the cat04
	 */
	public String getCat04()
	{
		return cat04;
	}

	/**
	 * @param cat04
	 *           the cat04 to set
	 */
	public void setCat04(final String cat04)
	{
		this.cat04 = cat04;
	}

	/**
	 * @return the num_caso
	 */
	public String getNum_caso()
	{
		return num_caso;
	}

	/**
	 * @param num_caso
	 *           the num_caso to set
	 */
	public void setNum_caso(final String num_caso)
	{
		this.num_caso = num_caso;
	}
	/**
	 * @return the num_radicado
	 */
	public String getNum_radicado()
	{
		return num_radicado;
	}

	/**
	 * @param num_radicado
	 *           the num_radicado to set
	 */
	public void setNum_radicado(final String num_radicado)
	{
		this.num_radicado = num_radicado;
	}

	/**
	 * @return the tramite
	 */
	public String getTramite()
	{
		return tramite;
	}

	/**
	 * @param tramite
	 *           the tramite to set
	 */
	public void setTramite(final String tramite)
	{
		this.tramite = tramite;
	}
	/**
	 * @return the estatus
	 */
	public String getEstatus()
	{
		return estatus;
	}

	/**
	 * @param estatus
	 *           the estatus to set
	 */
	public void setEstatus(final String estatus)
	{
		this.estatus = estatus;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje()
	{
		return mensaje;
	}

	/**
	 * @param mensaje
	 *           the mensaje to set
	 */
	public void setMensaje(final String mensaje)
	{
		this.mensaje = mensaje;
	}

	/**
	 * @return the archivos
	 */
	public ConsCasosArchiResponse getArchivos()
	{
		return archivos;
	}

	/**
	 * @param archivos
	 *           the archivos to set
	 */
	public void setArchivos(final ConsCasosArchiResponse archivos)
	{
		this.archivos = archivos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ConsCasosInfo [num_caso=" + num_caso + ", num_radicado=" + num_radicado + ", tramite=" + tramite + ", estatus="
				+ estatus + ", cat01=" + cat01 + ", cat02=" + cat02 + ", cat03=" + cat03 + ", cat04=" + cat04 + ", mensaje=" + mensaje
				+ ", archivos=" + archivos + "]";
	}



}
