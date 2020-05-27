package de.hybris.sdh.core.pojos.responses;

public class TrmPdfResponse {
    private String pdf;
    private ErrorPubli errores;

    public String getPdf() {
        return pdf;
    }

    public void setPdf(final String pdf) {
        this.pdf = pdf;
    }

    public ErrorPubli getErrores() {
        return errores;
    }

    public void setErrores(final ErrorPubli errores) {
        this.errores = errores;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "TrmPdfResponse [pdf=" + pdf + ", errores=" + errores + "]";
	}


}
