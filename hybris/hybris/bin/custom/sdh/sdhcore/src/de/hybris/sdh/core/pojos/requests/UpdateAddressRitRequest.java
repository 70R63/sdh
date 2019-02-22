/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import de.hybris.sdh.core.pojos.responses.ContribDireccion;

import org.apache.commons.lang3.StringUtils;


/**
 * @author hybris
 *
 */
public class UpdateAddressRitRequest
{
	private String numBP;

	private ContribDireccion direccion;




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
	 * @return the direccion
	 */
	public ContribDireccion getDireccion()
	{
		return direccion;
	}




	/**
	 * @param direccion
	 *           the direccion to set
	 */
	public void setDireccion(final ContribDireccion direccion)
	{
		this.direccion = direccion;
	}




	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");



		stringBuilder.append("\"direcciones\": [");

		final ContribDireccion address = this.getDireccion();

		stringBuilder.append("{");
		stringBuilder.append("\"ADR_KIND\": \"" + address.getADR_KIND() + "\",");
			stringBuilder.append("\"STREET\": \"" + ((StringUtils.isBlank(address.getSTREET())) ? "" : address.getSTREET()) + "\",");
			stringBuilder.append(
					"\"STR_SUPPL1\": \"" + ((StringUtils.isBlank(address.getSTR_SUPPL1())) ? "" : address.getSTR_SUPPL1()) + "\",");
			stringBuilder.append(
					"\"STR_SUPPL2\": \"" + ((StringUtils.isBlank(address.getSTR_SUPPL2())) ? "" : address.getSTR_SUPPL2()) + "\",");
			stringBuilder.append("\"POST_CODE1\": \""
					+ ((StringUtils.isBlank(address.getPOST_CODE())) ? "" : StringUtils.leftPad(address.getPOST_CODE(), 6, "0"))
					+ "\",");
			stringBuilder.append("\"CITY1\": \"" + ((StringUtils.isBlank(address.getCITY1())) ? "" : address.getCITY1()) + "\",");
			stringBuilder
					.append("\"COUNTRY\": \"" + ((StringUtils.isBlank(address.getCOUNTRY())) ? "" : address.getCOUNTRY()) + "\",");
			stringBuilder.append("\"REGION\": \"" + ((StringUtils.isBlank(address.getREGION())) ? "" : address.getREGION()) + "\"");
			stringBuilder.append("    }");


		stringBuilder.append("               ]");


		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}


}
