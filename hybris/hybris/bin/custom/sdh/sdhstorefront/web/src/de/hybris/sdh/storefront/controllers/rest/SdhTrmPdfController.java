package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.TrmReportesPDFRequest;
import de.hybris.sdh.core.pojos.responses.TrmPdfResponse;
import de.hybris.sdh.core.services.SDHTrmReportesPDF;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trmService")
public class SdhTrmPdfController {

    @Resource(name = "sdhTrmReportesPDF")
    SDHTrmReportesPDF sdhTrmReportesPDF;

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping("/getPdfString")
    public TrmPdfResponse getBanks(@RequestParam(value="impuesto", defaultValue="") final String impuesto,
                                   @RequestParam(value="reporte", defaultValue="") final String reporte) {

        final TrmReportesPDFRequest request = new TrmReportesPDFRequest();
        request.setImpuesto(impuesto);
        request.setReporte(reporte);

        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        request.setNumBP(customerModel.getNumBP());

		System.out.println("Request para trm/reportesPDF: " + request);
		final TrmPdfResponse response = sdhTrmReportesPDF.getPDF(request);
		System.out.println("Response para trm/reportesPDF: " + response);
		return response;
    }
}
