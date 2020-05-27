package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class TercerosAutResponse {
    private List<ObligacionesPrediosResponse> obligacionesPredios;
    private List<ErrorEnWS> errores;

    public List<ErrorEnWS> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorEnWS> errores) {
        this.errores = errores;
    }

    public List<ObligacionesPrediosResponse> getObligacionesPredios() {
        return obligacionesPredios;
    }

    public void setObligacionesPredios(List<ObligacionesPrediosResponse> obligacionesPredios) {
        this.obligacionesPredios = obligacionesPredios;
    }
}
