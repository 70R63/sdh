package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.facades.online.payment.data.OnlinePaymentSelectInputBoxData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/infoObject")
public class SdhInfoObjectUseOptionController {

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @Resource(name = "sdhDetalleGasolina")
    SDHDetalleGasolina sdhDetalleGasolinaWS;

    @Resource(name = "sdhConsultaContribuyenteBPService")
    SDHConsultaContribuyenteBPService sdhConsultaContribuyenteBPService;

    private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

    @RequestMapping("/getUseOptionSobreTasaGasolina")
	public DetGasResponse getUseOptionSobreTasaGasolina(@RequestParam(value="anioGravable", defaultValue="") String anioGravable,
                                   @RequestParam(value="periodo", defaultValue="") String periodo) {

        LOG.info("getUseOptionSobreTasaGasolina");
        final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
        final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();

        detalleGasolinaRequest.setNumBP(customerModel.getNumBP());
        detalleGasolinaRequest.setNumDoc(customerModel.getDocumentNumber());
        detalleGasolinaRequest.setAnoGravable(anioGravable);
        detalleGasolinaRequest.setPeriodo(periodo);

        contribuyenteRequest.setNumBP(customerModel.getNumBP());
        SDHValidaMailRolResponse detalleContribuyente = gasolinaService.consultaContribuyente(
                    contribuyenteRequest,
                    sdhConsultaContribuyenteBPService,
                    LOG);

        List<SobreTasaGasolinaTabla> tablaDocs = gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina());
        if (tablaDocs != null){
            for (int i = 0; i < tablaDocs.size(); i++){
                if (!tablaDocs.get(i).toString().isEmpty()){
                    String tipoDoc = tablaDocs.get(i).getTipoDocumento();
                    detalleGasolinaRequest.setTipoDoc(tipoDoc);
                    break;
                }
            }
        }

        DetGasResponse detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
		return detalleGasolinaResponse;
    }



}
