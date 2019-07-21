/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

/**
 * @author Consultor
 *
 */
public class RopRequest
{
	private String tipoImp;
	private String numBP;
	private String numObjeto;
	private String clavePeriodo;
	private String consulta;
	private String importeusuario;

	/**
	 * @return the tipoImp
	 */
	public String getTipoImp()
	{
		return tipoImp;
	}

	/**
	 * @param tipoImp
	 *           the tipoImp to set
	 */
	public void setTipoImp(final String tipoImp)
	{
		this.tipoImp = tipoImp;
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
	 * @return the clavePeriodo
	 */
	public String getClavePeriodo()
	{
		return clavePeriodo;
	}

	/**
	 * @param clavePeriodo
	 *           the clavePeriodo to set
	 */
	public void setClavePeriodo(final String clavePeriodo)
	{
		this.clavePeriodo = clavePeriodo;
	}

	/**
	 * @return the consulta
	 */
	public String getConsulta()
	{
		return consulta;
	}

	/**
	 * @param consulta
	 *           the consulta to set
	 */
	public void setConsulta(final String consulta)
	{
		this.consulta = consulta;
	}

	/**
	 * @return the importeusuario
	 */
	public String getImporteusuario()
	{
		return importeusuario;
	}

	/**
	 * @param importeusuario
	 *           the importeusuario to set
	 */
	public void setImporteusuario(final String importeusuario)
	{
		this.importeusuario = importeusuario;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"tipoImp\":\"" + this.getTipoImp() + "\",");
		stringBuilder.append("\"numBP\":\"" + this.getNumBP() + "\",");
		stringBuilder.append("\"numObjeto\":\"" + this.getNumObjeto() + "\",");
		stringBuilder.append("\"clavePeriodo\":\"" + this.getClavePeriodo() + "\",");
		stringBuilder.append("\"consulta\":\"" + this.getConsulta() + "\",");
		stringBuilder.append("\"importeusuario\":\"" + this.getImporteusuario() + "\"");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}



}
