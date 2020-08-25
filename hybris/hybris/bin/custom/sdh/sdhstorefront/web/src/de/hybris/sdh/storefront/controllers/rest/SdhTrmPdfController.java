package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.SdhValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.requests.TrmReportesPDFRequest;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.pojos.responses.TrmPdfResponse;
import de.hybris.sdh.core.services.SDHTrmReportesPDF;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;

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

	@Resource(name = "sdhValidaContribuyenteService")
	private SDHValidaContribuyenteService sdhValidaContribuyenteService;

    @RequestMapping("/getPdfString")
    public TrmPdfResponse getBanks(@RequestParam(value="impuesto", defaultValue="") final String impuesto,
			@RequestParam(value = "reporte", defaultValue = "")
			final String reporte, @RequestParam(value = "numDoc", defaultValue = "")
			final String numDoc, @RequestParam(value = "tipDoc", defaultValue = "")
			final String tipDoc)
	{

        final TrmReportesPDFRequest request = new TrmReportesPDFRequest();
        request.setImpuesto(impuesto);
        request.setReporte(reporte);

		if (numDoc == null || tipDoc == null || numDoc.trim().isEmpty() || tipDoc.trim().isEmpty())
		{
			final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
			request.setNumBP(customerModel.getNumBP());
		}
		else
		{

			final SdhValidaContribuyenteRequest contribuyenteRequest = new SdhValidaContribuyenteRequest();
			SDHValidaMailRolResponse contribuyenteResponse = null;
			final ValidaContribuyenteRequest documentos = new ValidaContribuyenteRequest();
			documentos.setNumid(numDoc);
			documentos.setTipoid(tipDoc);
			contribuyenteRequest.setDocumentos(documentos);

			try
			{
				contribuyenteResponse = sdhValidaContribuyenteService.validaContribuyente(contribuyenteRequest);
				if (contribuyenteResponse != null && contribuyenteResponse.getInfoContrib() != null)
				{
					request.setNumBP(contribuyenteResponse.getInfoContrib().getNumBP());
				}
			}
			catch (final Exception e)
			{
				// XXX Auto-generated catch block
				e.printStackTrace();
			}



		}

		System.out.println("Request para trm/reportesPDF: " + request);
		final TrmPdfResponse response = sdhTrmReportesPDF.getPDF(request);
		System.out.println("Response para trm/reportesPDF: " + response);
		return response;
    }
}
