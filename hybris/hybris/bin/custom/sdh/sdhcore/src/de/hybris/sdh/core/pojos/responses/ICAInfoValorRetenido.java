/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author hybris
 *
 */
public class ICAInfoValorRetenido
{

	private String anoGravable; //NO REGENERAR GETTER Y SETTER: Este atributo es la combinacion de los atributos dia/mes/anio
	private String tipoID;
	private String numID;
	private String razonSocial;
	private String codMunicipio;
	private String direccion;
	private String telefono;
	private String tarifaApl;
	private String montoRetenido;
	private String dia;
	private String mes;
	private String anio;

	/**
	 * @return the anoGravable
	 */
	public String getAnoGravable()
	{
		//		return anoGravable;
		return this.dia + "/" + this.mes + "/" + this.anio;
	}

	/**
	 * @param anoGravable
	 *           the anoGravable to set
	 */
	public void setAnoGravable(final String anoGravable)
	{
		this.anoGravable = anoGravable;
		this.anio = "";
		this.mes = "";
		this.dia = "";

		if (anoGravable != null)
		{
			if (anoGravable.length() == 10)
			{
				try
				{
					this.anio = anoGravable.substring(6, 10);
					this.mes = anoGravable.substring(3, 5);
					this.dia = anoGravable.substring(0, 2);
				}
				catch (final Exception e)
				{
				}
			}
		}
	}

	/**
	 * @return the tipoID
	 */
	public String getTipoID()
	{
		return tipoID;
	}

	/**
	 * @param tipoID
	 *           the tipoID to set
	 */
	public void setTipoID(final String tipoID)
	{
		this.tipoID = tipoID;
	}



	/**
	 * @return the numID
	 */
	public String getNumID()
	{
		return numID;
	}

	/**
	 * @param numID
	 *           the numID to set
	 */
	public void setNumID(final String numID)
	{
		this.numID = numID;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial()
	{
		return razonSocial;
	}

	/**
	 * @param razonSocial
	 *           the razonSocial to set
	 */
	public void setRazonSocial(final String razonSocial)
	{
		this.razonSocial = razonSocial;
	}

	/**
	 * @return the codMunicipio
	 */
	public String getCodMunicipio()
	{
		return codMunicipio;
	}

	/**
	 * @param codMunicipio
	 *           the codMunicipio to set
	 */
	public void setCodMunicipio(final String codMunicipio)
	{
		this.codMunicipio = codMunicipio;
	}

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
	 * @return the telefono
	 */
	public String getTelefono()
	{
		return telefono;
	}

	/**
	 * @param telefono
	 *           the telefono to set
	 */
	public void setTelefono(final String telefono)
	{
		this.telefono = telefono;
	}

	/**
	 * @return the tarifaApl
	 */
	public String getTarifaApl()
	{
		return tarifaApl;
	}

	/**
	 * @param tarifaApl
	 *           the tarifaApl to set
	 */
	public void setTarifaApl(final String tarifaApl)
	{
		this.tarifaApl = tarifaApl;
	}

	/**
	 * @return the montoRetenido
	 */
	public String getMontoRetenido()
	{
		return montoRetenido;
	}

	/**
	 * @param montoRetenido
	 *           the montoRetenido to set
	 */
	public void setMontoRetenido(final String montoRetenido)
	{
		this.montoRetenido = montoRetenido;
	}

	/**
	 * @return the dia
	 */
	public String getDia()
	{
		return dia;
	}

	/**
	 * @param dia
	 *           the dia to set
	 */
	public void setDia(final String dia)
	{
		this.dia = dia;
	}

	/**
	 * @return the mes
	 */
	public String getMes()
	{
		return mes;
	}

	/**
	 * @param mes
	 *           the mes to set
	 */
	public void setMes(final String mes)
	{
		this.mes = mes;
	}

	/**
	 * @return the anio
	 */
	public String getAnio()
	{
		return anio;
	}

	/**
	 * @param anio
	 *           the anio to set
	 */
	public void setAnio(final String anio)
	{
		this.anio = anio;
	}



}
