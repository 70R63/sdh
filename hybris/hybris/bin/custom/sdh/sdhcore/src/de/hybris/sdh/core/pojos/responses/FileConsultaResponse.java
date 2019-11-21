package de.hybris.sdh.core.pojos.responses;

import java.util.List;


public class FileConsultaResponse {
    private String idmsj;
    private String txtmsj;
	private List<FileConsultaResultado> resultado;

    public String getIdmsj() {
        return idmsj;
    }

    public void setIdmsj(final String idmsj) {
        this.idmsj = idmsj;
    }

    public String getTxtmsj() {
        return txtmsj;
    }

    public void setTxtmsj(final String txtmsj) {
        this.txtmsj = txtmsj;
    }


	/**
	 * @return the resultado
	 */
	public List<FileConsultaResultado> getResultado()
	{
		return resultado;
	}

	/**
	 * @param resultado
	 *           the resultado to set
	 */
	public void setResultado(final List<FileConsultaResultado> resultado)
	{
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
