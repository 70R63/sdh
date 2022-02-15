package de.hybris.sdh.storefront.controllers.rest;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.CreateTransactionPaymentResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.eanucc.GetTransactionInformationBodyType;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;
import de.hybris.sdh.storefront.controllers.rest.entity.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/psePayment")
public class PsePaymentController {

    @Resource(name = "defaultPseServices")
    private PseServices pseServices;

    @Resource(name = "configurationService")
    private ConfigurationService configurationService;

    @RequestMapping(value = "/getBankList", method = RequestMethod.GET,
            produces = "application/json", consumes = "application/json")
    public GetBankListResponseInformationType[]
        getBankList(@RequestBody PseTransactionInformationRequestEntity pseTransactionInformationRequestEntity){
        return pseServices.getBankList(
                getConstantConnectionData(pseTransactionInformationRequestEntity.getBankCode(),
                        pseTransactionInformationRequestEntity.getTipoDeImpuesto(),
                        pseTransactionInformationRequestEntity.getNumeroDeReferencia()),
                        getMessageHeader());
    }

    @RequestMapping(value= "/createTransactionPayment", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public CreateTransactionPaymentResponseInformationType
        createTransactionPayment(@RequestBody CreateTransactionPaymentRequestEntity createTransactionPaymentRequestEntity){

        return pseServices.createTransactionPayment(
                getConstantConnectionData(
                        createTransactionPaymentRequestEntity
                                .getTransactionInfRequestEntity().getBankCode(),
                        createTransactionPaymentRequestEntity
                                .getTransactionInfRequestEntity().getTipoDeImpuesto(),
                        createTransactionPaymentRequestEntity
                                .getTransactionInfRequestEntity().getNumeroDeReferencia()),
                getMessageHeader(),
                createTransactionPaymentRequestEntity.getTransactionPaymentInf());
    }

    @RequestMapping(value= "/getTransactionInformation", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public Response getTransactionInformation(@RequestBody GetTransactionInformationEntity getTransactionInformationEntity){

        GetTransactionInformationBodyType getTransactionInformationBodyType = new GetTransactionInformationBodyType()
        getTransactionInformationBodyType.setTrazabilityCode(getTransactionInformationEntity.getTrazabilityCode());

        pseServices.getTransactionInformation(
                getConstantConnectionData(
                        getTransactionInformationEntity.getTransactionInfRequestEntity().getBankCode(),
                        getTransactionInformationEntity.getTransactionInfRequestEntity().getTipoDeImpuesto(),
                        getTransactionInformationEntity.getTransactionInfRequestEntity().getNumeroDeReferencia()),
                getMessageHeader(),
                getTransactionInformationBodyType);

        return null;
    }

    private ConstantConnectionData getConstantConnectionData(final String bankCode, final String serviceCode, final String ticketId){
        final ConstantConnectionData constantConnectionData = new ConstantConnectionData();
        constantConnectionData.setPseurl(configurationService.getConfiguration().getString("sdh.pse.pseURL"));
        constantConnectionData.setPpeCode(configurationService.getConfiguration().getString("sdh.pse.ppeCode"));
        constantConnectionData.setEntityUrl(configurationService.getConfiguration().getString("sdh.pse.entityUrl") + "?ticketId=" + ticketId);
        constantConnectionData.setBankCode(bankCode);
        constantConnectionData.setServiceCode(serviceCode);
        return constantConnectionData;
    }

    private MessageHeader getMessageHeader(){
        final MessageHeader messageHeader = new MessageHeader();
        messageHeader.setTo(configurationService.getConfiguration().getString("sdh.pse.messageHeader.to"));
        messageHeader.setFrom(configurationService.getConfiguration().getString("sdh.pse.messageHeader.from"));
        messageHeader.setRepresentingParty(configurationService.getConfiguration()
                .getString("sdh.pse.messageHeader.representingParty"));

        return messageHeader;
    }
}
