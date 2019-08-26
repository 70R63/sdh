/**
 *
 */
package de.hybris.sdh.storefront.forms;

import java.util.List;

/**
 * @author Maria Luisa
 *
 */
public class EnviaFirmasForm
{
	private String numForm;

	private List<FirmantesForm> firmantes;

	public String getNumForm() {
		return numForm;
	}


	public void setNumForm(String numForm) {
		this.numForm = numForm;
	}

	public List<FirmantesForm> getFirmantes() {
		return firmantes;
	}

	public void setFirmantes(List<FirmantesForm> firmantes) {
		this.firmantes = firmantes;
	}
}
