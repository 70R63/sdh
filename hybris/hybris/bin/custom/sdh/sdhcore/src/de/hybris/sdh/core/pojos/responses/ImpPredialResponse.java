package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class ImpPredialResponse {
    private List<PredialResponse> predial;
    private String tpmsj;
    private String idmsj;
    private String txtmsj;

    public List<PredialResponse> getPredial() {
        return predial;
    }

    public void setPredial(List<PredialResponse> predial) {
        this.predial = predial;
    }

    public String getTpmsj() {
        return tpmsj;
    }

    public void setTpmsj(String tpmsj) {
        this.tpmsj = tpmsj;
    }

    public String getIdmsj() {
        return idmsj;
    }

    public void setIdmsj(String idmsj) {
        this.idmsj = idmsj;
    }

    public String getTxtmsj() {
        return txtmsj;
    }

    public void setTxtmsj(String txtmsj) {
        this.txtmsj = txtmsj;
    }
}
