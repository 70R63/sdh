package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class EnviaFirmasResponse {

    private List<ErrorEnWS> errores;

    public List<ErrorEnWS> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorEnWS> errores) {
        this.errores = errores;
    }
}
