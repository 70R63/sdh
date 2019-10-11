package de.hybris.sdh.core.pojos.responses;

public class ConsulFirmasDeclaracionesResponse {

    String idDeclaracion;
    String impuesto;
    String anioGravable;
    String periodo;
	private String estadoFirma;

    public String getIdDeclaracion() {
        return idDeclaracion;
    }

    public void setIdDeclaracion(final String idDeclaracion) {
        this.idDeclaracion = idDeclaracion;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(final String impuesto) {
        this.impuesto = impuesto;
    }

    public String getAnioGravable() {
        return anioGravable;
    }

    public void setAnioGravable(final String anioGravable) {
        this.anioGravable = anioGravable;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(final String periodo) {
        this.periodo = periodo;
    }

	/**
	 * @return the estadoFirma
	 */
	public String getEstadoFirma()
	{
		return estadoFirma;
	}

	/**
	 * @param estadoFirma
	 *           the estadoFirma to set
	 */
	public void setEstadoFirma(final String estadoFirma)
	{
		this.estadoFirma = estadoFirma;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ConsulFirmasDeclaracionesResponse [idDeclaracion=" + idDeclaracion + ", impuesto=" + impuesto + ", anioGravable="
				+ anioGravable + ", periodo=" + periodo + ", estadoFirma=" + estadoFirma + "]";
	}
}
