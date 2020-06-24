package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.requests.DetalleGasolinaRequest;
import de.hybris.sdh.core.pojos.requests.DetalleVehiculosRequest;
import de.hybris.sdh.core.pojos.requests.ICAInfObjetoRequest;
import de.hybris.sdh.core.pojos.requests.InfoObjetoDelineacionRequest;
import de.hybris.sdh.core.pojos.responses.DetGasResponse;
import de.hybris.sdh.core.pojos.responses.DetalleVehiculosResponse;
import de.hybris.sdh.core.pojos.responses.ICAInfObjetoResponse;
import de.hybris.sdh.core.pojos.responses.InfoObjetoDelineacionResponse;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHConsultaContribuyenteBPService;
import de.hybris.sdh.core.services.SDHDetalleGasolina;
import de.hybris.sdh.core.services.SDHDetalleVehiculosService;
import de.hybris.sdh.core.services.SDHICAInfObjetoService;
import de.hybris.sdh.facades.SDHCustomerFacade;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaService;
import de.hybris.sdh.storefront.controllers.impuestoGasolina.SobreTasaGasolinaTabla;
import de.hybris.sdh.storefront.controllers.pages.InfoDelineacionInput;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource(name = "sdhDetalleVehiculosService")
    SDHDetalleVehiculosService sdhDetalleVehiculosService;

    private static final Logger LOG = Logger.getLogger(SdhInfoObjectUseOptionController.class);

    @RequestMapping("/getUseOption")
	public String getUseOption(@RequestParam(value="anioGravable", defaultValue="") final String anioGravable,
                                   @RequestParam(value="periodo", defaultValue="") final String periodo,
                                   @RequestParam(value="taxType", defaultValue="") final String taxType,
                                   @RequestParam(value="placa", defaultValue="") final String placa,
                                   @RequestParam(value="cdu", defaultValue="") final String cdu,
                                   @RequestParam(value="numRadicado", defaultValue="") final String numRadicado) {
        String opcionUso = null;
        LOG.info("getUseOptionSobreTasaGasolina");
        LOG.info("anioGravable: "+anioGravable);
        LOG.info("periodo: "+periodo);
        LOG.info("taxType: "+taxType);
        LOG.info("placa: "+placa);
        LOG.info("cdu: "+cdu);

        if(Objects.nonNull(taxType)){
            if(taxType.equals("5")){//Sobretasa a la gasolina
                opcionUso = this.getOpcionUsosobreTasaGasolina(anioGravable, periodo);
            }else if(taxType.equals("3")){ //ICA
                opcionUso = this.getOpcionUsoIca(anioGravable, periodo);
            }else if(taxType.equals("2")){ //Vehicular
                opcionUso = this.getOpcionUsoVehicular(anioGravable, placa);
            }else if(taxType.equals("6")){ //Delineacion Urbana
				opcionUso = this.getOpcionUsoDelineacionUrbana(cdu, numRadicado);
            }
        }

        LOG.info("opcionUso: "+opcionUso);
        return Objects.nonNull(opcionUso) ? opcionUso.replace(" ","").split("-")[0] : null;
    }

    private String getOpcionUsosobreTasaGasolina(final String anioGravable, final String periodo){
        final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
        final DetalleGasolinaRequest detalleGasolinaRequest = new DetalleGasolinaRequest();
        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();

        detalleGasolinaRequest.setNumBP(customerModel.getNumBP());
        detalleGasolinaRequest.setNumDoc(customerModel.getDocumentNumber());
        detalleGasolinaRequest.setAnoGravable(anioGravable);
        detalleGasolinaRequest.setPeriodo(periodo);

        contribuyenteRequest.setNumBP(customerModel.getNumBP());
        final SDHValidaMailRolResponse detalleContribuyente = gasolinaService.consultaContribuyente(
                contribuyenteRequest,
                sdhConsultaContribuyenteBPService,
                LOG);
        final List<SobreTasaGasolinaTabla> tablaDocs = gasolinaService.prepararTablaDeclaracion(detalleContribuyente.getGasolina());
        if (tablaDocs != null){
            for (int i = 0; i < tablaDocs.size(); i++){
                if (!tablaDocs.get(i).toString().isEmpty()){
                    final String tipoDoc = tablaDocs.get(i).getTipoDocumento();
                    detalleGasolinaRequest.setTipoDoc(tipoDoc);
                    break;
                }
            }
        }
        final DetGasResponse detalleGasolinaResponse = gasolinaService.consultaDetGasolina(detalleGasolinaRequest, sdhDetalleGasolinaWS, LOG);
        return detalleGasolinaResponse.getOpcionUso();
    }

    private String getOpcionUsoIca(final String anioGravable, final String periodo){
        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        final ObjectMapper mapper = new ObjectMapper();
        String response = null;
        ICAInfObjetoResponse icaInfObjetoResponse = null;

        final ICAInfObjetoRequest icaInfObjetoRequest = new ICAInfObjetoRequest();
        icaInfObjetoRequest.setNumBP(customerModel.getNumBP());
        icaInfObjetoRequest.setAnoGravable(anioGravable);
        icaInfObjetoRequest.setPeriodo(periodo);

        final SDHValidaMailRolResponse customerData = sdhCustomerFacade.getRepresentadoFromSAP(customerModel.getNumBP());
        icaInfObjetoRequest.setNumObjeto(customerData.getIca().getNumObjeto());

        mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        response = sdhICAInfObjetoService.consultaICAInfObjeto(icaInfObjetoRequest);
        try {
            icaInfObjetoResponse = mapper.readValue(response, ICAInfObjetoResponse.class);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return icaInfObjetoResponse.getOpcionUso();
    }

    private String getOpcionUsoVehicular(final String anioGravable, final String placa){
        final ObjectMapper mapper = new ObjectMapper();
        final DetalleVehiculosRequest detalleVehiculosRequest = new DetalleVehiculosRequest();
        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        DetalleVehiculosResponse detalleVehiculosResponse = null;

        detalleVehiculosRequest.setBpNum(customerModel.getNumBP());
        detalleVehiculosRequest.setPlaca(placa);
        detalleVehiculosRequest.setAnioGravable(anioGravable);


        try {
            detalleVehiculosResponse = mapper.readValue(
                    sdhDetalleVehiculosService.detalleVehiculos(detalleVehiculosRequest), DetalleVehiculosResponse.class);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return detalleVehiculosResponse.getInfo_declara().getInfoVeh().getOpcionUso();
    }

	private String getOpcionUsoDelineacionUrbana(final String cdu, final String numRadicado)
	{
		String opcionUso = null;
        final InfoObjetoDelineacionRequest infoDelineacionRequest = new InfoObjetoDelineacionRequest();
        final CustomerModel customerModel = (CustomerModel) userService.getCurrentUser();
        InfoObjetoDelineacionResponse infoDelineacionResponse = new InfoObjetoDelineacionResponse();
        final SobreTasaGasolinaService gasolinaService = new SobreTasaGasolinaService(configurationService);
        final ConsultaContribuyenteBPRequest contribuyenteRequest = new ConsultaContribuyenteBPRequest();
        SDHValidaMailRolResponse detalleContribuyente;

        contribuyenteRequest.setNumBP(customerModel.getNumBP());
        detalleContribuyente = gasolinaService.consultaContribuyente(contribuyenteRequest, sdhConsultaContribuyenteBPService, LOG);

        final InfoDelineacionInput infoDelineacionInput = new InfoDelineacionInput();
        infoDelineacionInput.setSelectedCDU(cdu);

        infoDelineacionRequest.setNumBP(customerModel.getNumBP());
        //infoDelineacionRequest.setAnoGravable(gasolinaService.getAnoGravableDU(detalleContribuyente.getDelineacion(), infoDelineacionInput));
		infoDelineacionRequest.setAnoGravable("2020");
		//infoDelineacionRequest.setAnoGravable(anioGravable);
		infoDelineacionRequest.setAnoGravable("");
        infoDelineacionRequest.setCdu(cdu);
        infoDelineacionRequest.setNumRadicado(numRadicado);
        infoDelineacionRequest.setTipoLicencia("");
        LOG.info(infoDelineacionRequest);

        infoDelineacionResponse =  gasolinaService.consultaInfoDelineacion(infoDelineacionRequest, sdhDetalleGasolinaWS, LOG);
        LOG.info(infoDelineacionResponse);

		if (infoDelineacionResponse != null && infoDelineacionResponse.getInfoDeclara() != null)
		{
			opcionUso = infoDelineacionResponse.getInfoDeclara().getOpcionUso();
		}

		if (numRadicado.isEmpty() && (
		infoDelineacionResponse.getInfoDeclara().getFechaEjecutaria().equals("00/00/0000")
				|| infoDelineacionResponse.getInfoDeclara().getFechaEjecutaria() == null))
		{
			opcionUso = "99";
		}


		return opcionUso;
    }

}
