/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class ImpuestoPublicidadExterior
{
	private String numResolu;
	private String tipoValla;
	private boolean seleccionado;
	private String tipoVallaCode;
	private String numObjeto;
	private String anoGravable;




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
	 *
	 */
	public ImpuestoPublicidadExterior()
	{
		// XXX Auto-generated constructor stub
		this.seleccionado = false;
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
	 * @return the tipoValla
	 */
	public String getTipoValla()
	{
		return tipoValla;
	}

	/**
	 * @param tipoValla
	 *           the tipoValla to set
	 */
	public void setTipoValla(final String tipoValla)
	{
		this.tipoValla = tipoValla;
		this.tipoVallaCode = this.getTipoVallaCode(this.tipoValla);
	}

	/**
	 * @return the seleccionado
	 */
	public boolean isSeleccionado()
	{
		return seleccionado;
	}

	/**
	 * @param seleccionado
	 *           the seleccionado to set
	 */
	public void setSeleccionado(final boolean seleccionado)
	{
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the tipoVallaCode
	 */
	public String getTipoVallaCode()
	{
		return tipoVallaCode;
	}

	/**
	 * @param tipoVallaCode
	 *           the tipoVallaCode to set
	 */
	public void setTipoVallaCode(final String tipoVallaCode)
	{
		this.tipoVallaCode = tipoVallaCode;
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

	private String getTipoVallaCode(final String tipoVallaDescripcion)
	{
		String tipoVallaCode = "";

		if ("VALLA VEHICULOS".equalsIgnoreCase(tipoVallaDescripcion) || "VALLA VEHíCULOS".equalsIgnoreCase(tipoVallaDescripcion))
		{
			tipoVallaCode = "02";
		}
		else if ("Valla Tubular de Obra".equalsIgnoreCase(tipoVallaDescripcion))
		{
			tipoVallaCode = "03";
		}
		else if ("Valla de Obra Convencional".equalsIgnoreCase(tipoVallaDescripcion))
		{
			tipoVallaCode = "04";
		}
		else if ("Valla Tubular Comercial".equalsIgnoreCase(tipoVallaDescripcion))
		{
			tipoVallaCode = "01";
		}
		else if ("Pantalla LED".equalsIgnoreCase(tipoVallaDescripcion))
		{
			tipoVallaCode = "05";
		}
		return tipoVallaCode;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ImpuestoPublicidadExterior [numResolu=" + numResolu + ", tipoValla=" + tipoValla + ", seleccionado=" + seleccionado
				+ ", tipoVallaCode=" + tipoVallaCode + ", numObjeto=" + numObjeto + ", anoGravable=" + anoGravable + "]";
	}





}
