/**
 *
 */
package de.hybris.sdh.storefront.forms;

/**
 * @author Maria Luisa
 *
 */
public class EnviaFirmasForm
{
	private String numForm;

	private String tipoIdent;

	private String numIdentif;

	private String firmante;

	private String confirmacion;

	public String getNumForm() {
		return numForm;
	}

	public void setNumForm(String numForm) {
		this.numForm = numForm;
	}

	public String getTipoIdent() {
		return tipoIdent;
	}

	public void setTipoIdent(String tipoIdent) {
		this.tipoIdent = tipoIdent;
	}

	public String getNumIdentif() {
		return numIdentif;
	}

	public void setNumIdentif(String numIdentif) {
		this.numIdentif = numIdentif;
	}

	public String getFirmante() {
		return firmante;
	}

	public void setFirmante(String firmante) {
		this.firmante = firmante;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}
}
