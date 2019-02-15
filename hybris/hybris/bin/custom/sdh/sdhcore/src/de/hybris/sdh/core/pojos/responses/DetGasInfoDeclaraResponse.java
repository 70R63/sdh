/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

/**
 * @author Administrator
 *
 */
public class DetGasInfoDeclaraResponse
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
	public void setVlrSobretasa(final String vlrSobretasa)
	{
		this.vlrSobretasa = vlrSobretasa;
	}

}
