/**
 *
 */
package de.hybris.sdh.core.pojos.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Maria Torres
 *
 */
public class ConcesionariosResponse
{

	private List<Concesionarios> concesionarios;

	/**
	 * @return the concesionarios
	 */
	public List<Concesionarios> getConcesionarios()
	{
		return concesionarios;
	}

	/**
	 * @param concesionarios
	 *           the concesionarios to set
	 */
	@JsonSetter("Concesionarios")
	public void setConcesionarios(final List<Concesionarios> concesionarios)
	{
		this.concesionarios = concesionarios;
	}

	@Override
	public String toString()
	{
		return "ConcesionariosResponse [concesionarios=" + concesionarios + "]";
	}



}
