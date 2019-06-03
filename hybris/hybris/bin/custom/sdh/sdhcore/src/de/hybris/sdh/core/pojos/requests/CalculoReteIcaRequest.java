/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;

import org.apache.commons.lang3.StringUtils;


/**
 * @author hybris
 *
 */
public class CalculoReteIcaRequest
{
	private String numForm;

	private String numBP;

	private String valorPagar;

	private List<ReteIcaRelaciones> relaciones;

	/**
	 * @return the numForm
	 */
	public String getNumForm()
	{
		return numForm;
	}

	/**
	 * @param numForm
	 *           the numForm to set
	 */
	public void setNumForm(final String numForm)
	{
		this.numForm = numForm;
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

	/**
	 * @return the valorPagar
	 */
	public String getValorPagar()
	{
		return valorPagar;
	}

	/**
	 * @param valorPagar
	 *           the valorPagar to set
	 */
	public void setValorPagar(final String valorPagar)
	{
		this.valorPagar = valorPagar;
	}

	/**
	 * @return the relaciones
	 */
	public List<ReteIcaRelaciones> getRelaciones()
	{
		return relaciones;
	}

	/**
	 * @param relaciones
	 *           the relaciones to set
	 */
	public void setRelaciones(final List<ReteIcaRelaciones> relaciones)
	{
		this.relaciones = relaciones;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"numForm\":\"" + ((StringUtils.isBlank(this.numForm)) ? "" : this.numForm) + "\",");
		stringBuilder.append("\"numBP\":\"" + ((StringUtils.isBlank(this.numBP)) ? "" : this.numBP) + "\",");
		stringBuilder.append("\"valorPagar\":\"" + ((StringUtils.isBlank(this.valorPagar)) ? "" : this.valorPagar) + "\"");

		if(this.relaciones != null && !this.relaciones.isEmpty())
		{
			stringBuilder.append(",");
			stringBuilder.append("relaciones: [");
			for(final ReteIcaRelaciones eachRelacion : this.relaciones)
			{
				stringBuilder.append("{");
				stringBuilder.append("\"tipoDoc\":\"" + ((StringUtils.isBlank(eachRelacion.getTipoDoc())) ? "" : eachRelacion.getTipoDoc()) + "\",");
				stringBuilder.append("\"numDoc\":\"" + ((StringUtils.isBlank(eachRelacion.getNumDoc())) ? "" : eachRelacion.getNumDoc()) + "\",");
				stringBuilder.append("\"nombre\":\"" + ((StringUtils.isBlank(eachRelacion.getNombre())) ? "" : eachRelacion.getNombre()) + "\",");
				stringBuilder.append("\"tipoRelacion\":\"" + ((StringUtils.isBlank(eachRelacion.getTipoRelacion())) ? "" : eachRelacion.getTipoRelacion()) + "\",");
				stringBuilder.append("\"fechaDesde\":\"" + ((StringUtils.isBlank(eachRelacion.getFechaDesde())) ? "" : eachRelacion.getFechaDesde()) + "\",");
				stringBuilder.append("\"fechaHasta\":\"" + ((StringUtils.isBlank(eachRelacion.getFechaHasta())) ? "" : eachRelacion.getFechaHasta()) + "\"");
				stringBuilder.append("},");
			}

			if (",".equals(stringBuilder.substring(stringBuilder.length() - 1)))
			{
				stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
			}

			stringBuilder.append("]");

		}

		stringBuilder.append("}");

		return stringBuilder.toString();
	}



}
