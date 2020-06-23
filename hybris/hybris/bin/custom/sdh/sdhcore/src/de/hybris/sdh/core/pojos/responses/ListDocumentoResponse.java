package de.hybris.sdh.core.pojos.responses;

import java.util.List;

public class ListDocumentoResponse {
    private List<DocumentoResponse> documentos;

    public List<DocumentoResponse> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoResponse> documentos) {
        this.documentos = documentos;
    }
}
