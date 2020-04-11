package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class TrmPdfResponse {
    private String pdf;
    private ErrorPubli errores;

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public ErrorPubli getErrores() {
        return errores;
    }

    public void setErrores(ErrorPubli errores) {
        this.errores = errores;
    }
}
