package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class AgentesAutImpuestoResponse {
    private String idTramite;
    private List<ErrorEnWS> errores;

    public String getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(String idTramite) {
        this.idTramite = idTramite;
    }

    public List<ErrorEnWS> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorEnWS> errores) {
        this.errores = errores;
    }
}
