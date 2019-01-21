/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author hybris
 *
 */
public class CertifNombRequest
{
	private String numBP;
	private String name1;
	private String name2;
	private String apellido1;
	private String apellido2;

	/**
	 * @return the name1
	 */
	public String getName1()
	{
		return name1;
	}

	/**
	 * @param name1
	 *           the name1 to set
	 */
	public void setName1(final String name1)
	{
		this.name1 = name1;
	}

	/**
	 * @return the name2
	 */
	public String getName2()
	{
		return name2;
	}

	/**
	 * @param name2
	 *           the name2 to set
	 */
	public void setName2(final String name2)
	{
		this.name2 = name2;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1()
	{
		return apellido1;
	}

	/**
	 * @param apellido1
	 *           the apellido1 to set
	 */
	public void setApellido1(final String apellido1)
	{
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2()
	{
		return apellido2;
	}

	/**
	 * @param apellido2
	 *           the apellido2 to set
	 */
	public void setApellido2(final String apellido2)
	{
		this.apellido2 = apellido2;
	}



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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"name1\":\"" + this.getName1() + "\",");
		stringBuilder.append("\"name2\":\"" + this.getName2() + "\",");
		stringBuilder.append("\"apellido1\":\"" + this.getApellido1() + "\",");
		stringBuilder.append("\"apellido2\":\"" + this.getApellido2() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}





}
