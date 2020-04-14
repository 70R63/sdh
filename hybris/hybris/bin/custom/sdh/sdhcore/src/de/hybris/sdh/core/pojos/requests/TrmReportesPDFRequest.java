package de.hybris.sdh.core.pojos.requests;

public class TrmReportesPDFRequest {
    private String numBP;
    private String impuesto;
    private String reporte;


    public String getNumBP() {
        return numBP;
    }

    public void setNumBP(String numBP) {
        this.numBP = numBP;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }
}
