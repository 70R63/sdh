/**
 *
 */
package de.hybris.sdh.core.pojos.requests;

import java.util.List;


/**
 * @author Federico Flores Dimas
 *
 */
public class CreaCasosArchiInfoRequest
{

	//	private String linea;
	//	private String identificador;
	//	private String valor;
	private List<CreaCasosArchiRequest> archivos;


	/**
	 * @return the archivos
	 */
	public List<CreaCasosArchiRequest> getArchivos()
	{
		return archivos;
	}

	/**
	 * @param archivos
	 *           the archivos to set
	 */
	public void setArchivos(final List<CreaCasosArchiRequest> archivos)
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
		return "CreaCasosArchiInfoRequest [archivos=" + archivos + "]";
	}


	public String toString_reducido()
	{
		String returnValue = null;
		if (archivos != null)
		{
			final StringBuffer sb = new StringBuffer();
			for (final CreaCasosArchiRequest creaCasosArchiRequest : archivos)
			{
				sb.append(creaCasosArchiRequest.toString_reducido());
			}
			returnValue = "CreaCasosArchiInfoRequest [archivos=" + sb.toString() + "]";
		}

		return returnValue;
	}


}
