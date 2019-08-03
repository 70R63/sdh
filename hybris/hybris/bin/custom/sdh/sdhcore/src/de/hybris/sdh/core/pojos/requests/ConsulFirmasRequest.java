package de.hybris.sdh.core.pojos.requests;

public class ConsulFirmasRequest {

    String agente;
    String contribuyente;

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(String contribuyente) {
        this.contribuyente = contribuyente;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");
        stringBuilder.append("\"agente\":\"" + this.getAgente() + "\",");
        stringBuilder.append("\"contribuyente\":\"" + this.getContribuyente() + "\"");
        stringBuilder.append("}");
        // XXX Auto-generated method stub
        return stringBuilder.toString();
    }
}
