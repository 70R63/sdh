package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.facades.online.payment.data.OnlinePaymentSelectInputBoxData;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolina;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Resource(name = "sdhICAInfObjetoService")
    SDHICAInfObjetoService sdhICAInfObjetoService;

    @Resource(name = "sdhCustomerFacade")
    SDHCustomerFacade sdhCustomerFacade;

    private static final Logger LOG = Logger.getLogger(SobreTasaGasolina.class);

    @RequestMapping("/getUseOption")
	public String getUseOption(@RequestParam(value="anioGravable", defaultValue="") String anioGravable,
                                   @RequestParam(value="periodo", defaultValue="") String periodo,
                                   @RequestParam(value="taxType", defaultValue="") String taxType) {
        String opcionUso = null;
        LOG.info("getUseOptionSobreTasaGasolina");
        LOG.info("anioGravable: "+anioGravable);
        LOG.info("periodo: "+periodo);
        LOG.info("taxType: "+taxType);

        if(Objects.nonNull(taxType)){
            if(taxType.equals("5")){//Sobretasa a la gasolina
                opcionUso = this.getOpcionUsosobreTasaGasolina(anioGravable, periodo);
            }else if(taxType.equals("3")){ //ICA
                opcionUso = this.getOpcionUsoIca(anioGravable, periodo);
            }
        }

        LOG.info("opcionUso: "+opcionUso);
        return Objects.nonNull(opcionUso) ? opcionUso.replace(" ","").split("-")[0] : null;
    }

    private String getOpcionUsosobreTasaGasolina(String anioGravable, String periodo){
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
        return detalleGasolinaResponse.getOpcionUso();
    }

    private String getOpcionUsoIca(String anioGravable, String periodo){
        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        final ObjectMapper mapper = new ObjectMapper();
        String response = null;
        ICAInfObjetoResponse icaInfObjetoResponse = null;

        final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();
        icaInfObjetoRequest.setNumBP(customerModel.getNumBP());
        icaInfObjetoRequest.setAnoGravable(anioGravable);
        icaInfObjetoRequest.setPeriodo(periodo);

        SDHValidaMailRolResponse customerData = sdhCustomerFacade.getRepresentadoFromSAP(customerModel.getNumBP());
        icaInfObjetoRequest.setNumObjeto(customerData.getIca().getNumObjeto());

        mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);
        try {
            icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return icaInfObjetoResponse.getOpcionUso();
    }



}
