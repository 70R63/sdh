package de.hybris.sdh.core.pojos.requests;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class EnviaFirmasRequest {

    private String numForm;
    private List<FirmanteRequest> tablFirmante;

    public String getNumForm() {
        return numForm;
    }

    public void setNumForm(String numForm) {
        this.numForm = numForm;
    }

    public List<FirmanteRequest> getTablFirmante() {
        return tablFirmante;
    }

    public void setTablFirmante(List<FirmanteRequest> tablFirmante) {
        this.tablFirmante = tablFirmante;
    }

    @Override
    public String toString() {

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");
        stringBuilder.append("\"numForm\":\"" + ((StringUtils.isBlank(this.getNumForm())) ? "" : this.getNumForm()) + "\"");

        if(CollectionUtils.isNotEmpty(this.getTablFirmante()))
        {
            stringBuilder.append(",");
            stringBuilder.append("\"tablFirmante\": [");

            for(FirmanteRequest echFirmante : this.getTablFirmante())
            {
                stringBuilder.append("{");
                stringBuilder.append("\"tipoIdent\":\"" + ((StringUtils.isBlank(this.getNumForm())) ? "" : echFirmante.getTipoIdent()) + "\",");
                stringBuilder.append("\"numIdentif\":\"" + ((StringUtils.isBlank(this.getNumForm())) ? "" : echFirmante.getNumIdentif()) + "\",");
                stringBuilder.append("\"firmante\":\"" + ((StringUtils.isBlank(this.getNumForm())) ? "" : echFirmante.getFirmante()) + "\",");
                stringBuilder.append("\"confirmacion\":\"" + ((StringUtils.isBlank(this.getNumForm())) ? "" : echFirmante.getConfirmacion()) + "\"");
                stringBuilder.append("},");

            }
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));

            stringBuilder.append("]");
        }




        stringBuilder.append("}");
        // XXX Auto-generated method stub
        return stringBuilder.toString();
    }
}
