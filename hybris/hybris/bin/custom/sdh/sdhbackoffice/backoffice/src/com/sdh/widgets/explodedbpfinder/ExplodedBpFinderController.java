package com.sdh.widgets.explodedbpfinder;

import com.hybris.cockpitng.annotations.SocketEvent;
import com.hybris.cockpitng.annotations.ViewEvent;
import com.hybris.cockpitng.util.DefaultWidgetController;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.dao.impl.DefaultSdhCustomerDao;
import de.hybris.sdh.core.pojos.requests.SdhValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Listbox;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class ExplodedBpFinderController extends DefaultWidgetController {
    //Data
    private static final Logger LOG = LoggerFactory.getLogger(ExplodedBpFinderController.class);
    private static final String SOCKET_ID = "explodedBpFinderInput";
    private static final String NOT_CUSTOMER_FOUND_MSG = "-- No Existe --";
    private CustomerModel currentCustomer;

    @Wire
    private Listbox documentTypeListInput;
    @Wire
    private Textbox documentNumberInput;
    @Wire
    private Datebox documentExpirationDateInput;
    @Wire
    private Textbox businessPartnerOutput;
    @Wire
    private Textbox businessPartnerEmailOutput;
    @Wire
    private Button takeFoundBpButton;

    @Resource(name = "sdhValidaContribuyenteService")
    SDHValidaContribuyenteService sdhValidaContribuyenteService;

    @Resource(name = "modelService")
    private ModelService modelService;

    @Resource(name = "sdhCustomerDao")
    DefaultSdhCustomerDao sdhCustomerDao;

    @SocketEvent(socketId = SOCKET_ID)
    public void init(final CustomerModel customerModel) {
        LOG.info("Performing init...");
        setCurrentCustomer((CustomerModel) customerModel);
        takeFoundBpButton.setDisabled(true);
        documentExpirationDateInput.setDisabled(true);
    }

    @ViewEvent(componentID = "findBpButton", eventName = Events.ON_CLICK)
    public void findBp() {
        ValidaContribuyenteRequest request = new ValidaContribuyenteRequest();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        request.setTipoid(documentTypeListInput.getSelectedItem().getValue());
        request.setNumid(documentNumberInput.getValue());

        request.setFechExp(Objects.nonNull(documentExpirationDateInput) ?
                Objects.nonNull(documentExpirationDateInput.getValue()) ?
                        formatter.format(documentExpirationDateInput.getValue()) : StringUtils.EMPTY
                         : StringUtils.EMPTY );

        SDHValidaMailRolResponse response = getSdhValidaContribuyente(request);
        String bpNumber = Objects.nonNull(response) && Objects.nonNull(response.getInfoContrib())
                ? response.getInfoContrib().getNumBP() :  NOT_CUSTOMER_FOUND_MSG;
        String customerEmail = sdhCustomerDao.findByBp(bpNumber).isPresent() ?
                sdhCustomerDao.findByBp(bpNumber).get().getUid() : NOT_CUSTOMER_FOUND_MSG;

        businessPartnerOutput.setText(bpNumber);
        businessPartnerEmailOutput.setText(customerEmail);
        takeFoundBpButton.setDisabled(false);
    }

    @ViewEvent(componentID = "documentTypeListInput", eventName = Events.ON_SELECT)
    public void documentTypeOnChange() {
        if("CC".equals(documentTypeListInput.getSelectedItem().getValue().toString())){
            documentExpirationDateInput.setDisabled(false);
        }else{
            documentExpirationDateInput.setDisabled(true);
        }
    }

    @ViewEvent(componentID = "takeFoundBpButton", eventName = Events.ON_CLICK)
    public void takeFoundBp() {
        getCurrentCustomer().setNumBP(businessPartnerOutput.getValue());
        modelService.save(getCurrentCustomer());
        takeFoundBpButton.setDisabled(true);
    }
    private SDHValidaMailRolResponse getSdhValidaContribuyente(ValidaContribuyenteRequest documentos){
        SdhValidaContribuyenteRequest request = new SdhValidaContribuyenteRequest();
        SDHValidaMailRolResponse response = null;
        request.setDocumentos(documentos);

        try {
            response = sdhValidaContribuyenteService.validaContribuyente(request);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return response;
    }

    public CustomerModel getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(CustomerModel currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
