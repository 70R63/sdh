package de.hybris.sdh.core.pojos.responses;

public class FileConsultaResponse {
    private String idmsj;
    private String txtmsj;
    private FileConsultaResultado resultado;

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

    public FileConsultaResultado getResultado() {
        return resultado;
    }

    public void setResultado(FileConsultaResultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "FileConsultaResponse{" +
                "idmsj='" + idmsj + '\'' +
                ", txtmsj='" + txtmsj + '\'' +
                ", resultado=" + resultado +
                '}';
    }
}
