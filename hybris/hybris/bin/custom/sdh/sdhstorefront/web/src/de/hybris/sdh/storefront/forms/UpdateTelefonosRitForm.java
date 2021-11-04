/**
 *
 */
package de.hybris.sdh.storefront.forms;

import de.hybris.sdh.core.pojos.responses.ContribTelefono;

import java.util.List;

/**
 * @author hybris
 *
 */
public class UpdateTelefonosRitForm
{
	
	private List<ContribTelefono> telefonos;

	/**
	 * @return the telefonos
	 */
	public List<ContribTelefono> getTelefonos()
	{
		return telefonos;
	}

	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(List<ContribTelefono> telefonos)
	{
		this.telefonos = telefonos;
	}

	@Override
	public String toString()
	{
		return "UpdateTelefonosRitForm [telefonos=" + telefonos + "]";
	}
	




}
