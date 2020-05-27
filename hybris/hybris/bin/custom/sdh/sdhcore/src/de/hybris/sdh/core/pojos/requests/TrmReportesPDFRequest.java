package de.hybris.sdh.core.pojos.requests;

public class TrmReportesPDFRequest {
    private String numBP;
    private String impuesto;
    private String reporte;


    public String getNumBP() {
        return numBP;
    }

    public void setNumBP(final String numBP) {
        this.numBP = numBP;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(final String impuesto) {
        this.impuesto = impuesto;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(final String reporte) {
        this.reporte = reporte;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append(obtenerValorJson("\"numBP\":\"", this.getNumBP(), "\","));
		stringBuilder.append(obtenerValorJson("\"impuesto\":\"", this.getImpuesto(), "\","));
		stringBuilder.append(obtenerValorJson("\"reporte\":\"", this.getReporte(), "\""));
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	private String obtenerValorJson(final String cadena1, final String valor, final String cadena2)
	{
		String valorVariable = "";

		valorVariable = (valor != null) ? cadena1 + valor + cadena2 : cadena1 + cadena2;


		return valorVariable;
	}
}
