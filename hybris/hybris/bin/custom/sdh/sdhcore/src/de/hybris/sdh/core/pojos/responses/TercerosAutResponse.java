package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class TercerosAutResponse {
    private List<ObligacionesPrediosResponse> obligacionesPredios;
	private List<ObligacionesICA> obligacionesICA;
	private List<ObligacionesVehicular> obligacionesVehicular;
	private List<ObligacionesDelineacion> obligacionesDelineacion;
	private List<ObligacionesGasolina> obligacionesGasolina;
	private List<ObligacionesPublicidad> obligacionesPublicidad;
    private List<ErrorEnWS> errores;

    public List<ErrorEnWS> getErrores() {
        return errores;
    }

    public void setErrores(final List<ErrorEnWS> errores) {
        this.errores = errores;
    }

    public List<ObligacionesPrediosResponse> getObligacionesPredios() {
        return obligacionesPredios;
    }

    public void setObligacionesPredios(final List<ObligacionesPrediosResponse> obligacionesPredios) {
        this.obligacionesPredios = obligacionesPredios;
    }

	/**
	 * @return the obligacionesICA
	 */
	public List<ObligacionesICA> getObligacionesICA()
	{
		return obligacionesICA;
	}

	/**
	 * @param obligacionesICA
	 *           the obligacionesICA to set
	 */
	public void setObligacionesICA(final List<ObligacionesICA> obligacionesICA)
	{
		this.obligacionesICA = obligacionesICA;
	}

	/**
	 * @return the obligacionesVehicular
	 */
	public List<ObligacionesVehicular> getObligacionesVehicular()
	{
		return obligacionesVehicular;
	}

	/**
	 * @param obligacionesVehicular
	 *           the obligacionesVehicular to set
	 */
	public void setObligacionesVehicular(final List<ObligacionesVehicular> obligacionesVehicular)
	{
		this.obligacionesVehicular = obligacionesVehicular;
	}

	/**
	 * @return the obligacionesDelineacion
	 */
	public List<ObligacionesDelineacion> getObligacionesDelineacion()
	{
		return obligacionesDelineacion;
	}

	/**
	 * @param obligacionesDelineacion
	 *           the obligacionesDelineacion to set
	 */
	public void setObligacionesDelineacion(final List<ObligacionesDelineacion> obligacionesDelineacion)
	{
		this.obligacionesDelineacion = obligacionesDelineacion;
	}

	/**
	 * @return the obligacionesGasolina
	 */
	public List<ObligacionesGasolina> getObligacionesGasolina()
	{
		return obligacionesGasolina;
	}

	/**
	 * @param obligacionesGasolina
	 *           the obligacionesGasolina to set
	 */
	public void setObligacionesGasolina(final List<ObligacionesGasolina> obligacionesGasolina)
	{
		this.obligacionesGasolina = obligacionesGasolina;
	}

	/**
	 * @return the obligacionesPublicidad
	 */
	public List<ObligacionesPublicidad> getObligacionesPublicidad()
	{
		return obligacionesPublicidad;
	}

	/**
	 * @param obligacionesPublicidad
	 *           the obligacionesPublicidad to set
	 */
	public void setObligacionesPublicidad(final List<ObligacionesPublicidad> obligacionesPublicidad)
	{
		this.obligacionesPublicidad = obligacionesPublicidad;
	}

}
