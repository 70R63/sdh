package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.TrmReportesPDFRequest;
import de.hybris.sdh.core.pojos.responses.TrmPdfResponse;
import de.hybris.sdh.core.services.SDHTrmReportesPDF;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/trmService")
public class SdhTrmPdfController {

    @Resource(name = "sdhTrmReportesPDF")
    SDHTrmReportesPDF sdhTrmReportesPDF;

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping("/getPdfString")
    public TrmPdfResponse getBanks(@RequestParam(value="impuesto", defaultValue="") String impuesto,
                                   @RequestParam(value="reporte", defaultValue="") String reporte) {

        TrmReportesPDFRequest request = new TrmReportesPDFRequest();
        request.setImpuesto(impuesto);
        request.setReporte(reporte);

        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        request.setNumBP(customerModel.getNumBP());

        return sdhTrmReportesPDF.getPDF(request);
    }
}
