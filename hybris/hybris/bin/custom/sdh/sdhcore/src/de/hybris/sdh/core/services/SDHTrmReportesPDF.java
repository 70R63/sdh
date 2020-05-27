package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.TrmReportesPDFRequest;
import de.hybris.sdh.core.pojos.responses.TrmPdfResponse;

public interface SDHTrmReportesPDF {
    TrmPdfResponse getPDF(TrmReportesPDFRequest request);
}
