/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Federico Flores Dimas
 *
 */
public class DocTramitesDocumentosResponse
{
	private String dependencia;
	private String dependencia_t;
	private String serie;
	private String serie_t;
	private String subserie_t;
	private String subserie;
	private String tipoDocumen;
	private String tipoDocumen_t;

	/**
	 * @return the dependencia
	 */
	public String getDependencia()
	{
		return dependencia;
	}

	/**
	 * @param dependencia
	 *           the dependencia to set
	 */
	public void setDependencia(final String dependencia)
	{
		this.dependencia = dependencia;
	}

	/**
	 * @return the dependencia_t
	 */
	public String getDependencia_t()
	{
		return dependencia_t;
	}

	/**
	 * @param dependencia_t
	 *           the dependencia_t to set
	 */
	public void setDependencia_t(final String dependencia_t)
	{
		this.dependencia_t = dependencia_t;
	}

	/**
	 * @return the serie
	 */
	public String getSerie()
	{
		return serie;
	}

	/**
	 * @param serie
	 *           the serie to set
	 */
	public void setSerie(final String serie)
	{
		this.serie = serie;
	}

	/**
	 * @return the serie_t
	 */
	public String getSerie_t()
	{
		return serie_t;
	}

	/**
	 * @param serie_t
	 *           the serie_t to set
	 */
	public void setSerie_t(final String serie_t)
	{
		this.serie_t = serie_t;
	}

	/**
	 * @return the subserie
	 */
	public String getSubserie()
	{
		return subserie;
	}

	/**
	 * @param subserie
	 *           the subserie to set
	 */
	public void setSubserie(final String subserie)
	{
		this.subserie = subserie;
	}

	/**
	 * @return the subserie_t
	 */
	public String getSubserie_t()
	{
		return subserie_t;
	}

	/**
	 * @param subserie_t
	 *           the subserie_t to set
	 */
	public void setSubserie_t(final String subserie_t)
	{
		this.subserie_t = subserie_t;
	}

	/**
	 * @return the tipoDocumen
	 */
	public String getTipoDocumen()
	{
		return tipoDocumen;
	}

	/**
	 * @param tipoDocumen
	 *           the tipoDocumen to set
	 */
	public void setTipoDocumen(final String tipoDocumen)
	{
		this.tipoDocumen = tipoDocumen;
	}

	/**
	 * @return the tipoDocumen_t
	 */
	public String getTipoDocumen_t()
	{
		return tipoDocumen_t;
	}

	/**
	 * @param tipoDocumen_t
	 *           the tipoDocumen_t to set
	 */
	public void setTipoDocumen_t(final String tipoDocumen_t)
	{
		this.tipoDocumen_t = tipoDocumen_t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DocTramitesDocumentosResponse [dependencia=" + dependencia + ", dependencia_t=" + dependencia_t + ", serie=" + serie
				+ ", serie_t=" + serie_t + ", subserie_t=" + subserie_t + ", subserie=" + subserie + ", tipoDocumen=" + tipoDocumen
				+ ", tipoDocumen_t=" + tipoDocumen_t + "]";
	}

}
