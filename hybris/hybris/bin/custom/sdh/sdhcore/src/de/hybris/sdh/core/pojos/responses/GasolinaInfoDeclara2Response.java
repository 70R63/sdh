/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Administrator
 *
 */
public class GasolinaInfoDeclara2Response
{

	String claseProd;
	String galonesGra;
	String precioRef;
	String alcoholCarbu;
	String baseGravable;
	String vlrSobretasa;




	/**
	 * @return the claseProd
	 */
	public String getClaseProd()
	{
		return claseProd;
	}

	/**
	 * @param claseProd
	 *           the claseProd to set
	 */
	@JsonProperty("Clase_prod")
	public void setClaseProd(final String claseProd)
	{
		this.claseProd = claseProd;
	}

	/**
	 * @return the galonesGra
	 */
	public String getGalonesGra()
	{
		return galonesGra;
	}

	/**
	 * @param galonesGra
	 *           the galonesGra to set
	 */
	@JsonProperty("Galones_gra")
	public void setGalonesGra(final String galonesGra)
	{
		this.galonesGra = galonesGra;
	}

	/**
	 * @return the precioRef
	 */
	public String getPrecioRef()
	{
		return precioRef;
	}

	/**
	 * @param precioRef
	 *           the precioRef to set
	 */
	@JsonProperty("Precio_ref")
	public void setPrecioRef(final String precioRef)
	{
		this.precioRef = precioRef;
	}

	/**
	 * @return the alcoholCarbu
	 */
	public String getAlcoholCarbu()
	{
		return alcoholCarbu;
	}

	/**
	 * @param alcoholCarbu
	 *           the alcoholCarbu to set
	 */
	@JsonProperty("Alcohol_carbu")
	public void setAlcoholCarbu(final String alcoholCarbu)
	{
		this.alcoholCarbu = alcoholCarbu.trim();
	}

	/**
	 * @return the baseGravable
	 */
	public String getBaseGravable()
	{
		return baseGravable;
	}

	/**
	 * @param baseGravable
	 *           the baseGravable to set
	 */
	@JsonProperty("Base_gravable")
	public void setBaseGravable(final String baseGravable)
	{
		this.baseGravable = baseGravable;
	}

	/**
	 * @return the vlrSobretasa
	 */
	public String getVlrSobretasa()
	{
		return vlrSobretasa;
	}

	/**
	 * @param vlrSobretasa
	 *           the vlrSobretasa to set
	 */
	@JsonProperty("Vlr_sobretasa")
	public void setVlrSobretasa(final String vlrSobretasa)
	{
		this.vlrSobretasa = vlrSobretasa;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "DetGasInfoDeclaraResponse [claseProd=" + claseProd + ", galonesGra=" + galonesGra + ", precioRef=" + precioRef
				+ ", alcoholCarbu=" + alcoholCarbu + ", baseGravable=" + baseGravable + ", vlrSobretasa=" + vlrSobretasa + "]";
	}

}
