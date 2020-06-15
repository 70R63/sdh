package com.sdh.widgets.explodedbpfinder;

import com.hybris.cockpitng.annotations.SocketEvent;
import com.hybris.cockpitng.annotations.ViewEvent;
import com.hybris.cockpitng.util.DefaultWidgetController;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.pojos.requests.ValidaContribuyenteRequest;
import de.hybris.sdh.core.pojos.responses.SDHValidaMailRolResponse;
import de.hybris.sdh.core.services.SDHValidaContribuyenteService;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Listbox;
import sun.text.normalizer.Utility;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class ExplodedBpFinderController extends DefaultWidgetController {
    //Data
    private static final Logger LOG = LoggerFactory.getLogger(ExplodedBpFinderController.class);
    private static final String SOCKET_ID = "explodedBpFinderInput";
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
    private Button takeFoundBpButton;

    @Resource(name = "sdhValidaContribuyenteService")
    SDHValidaContribuyenteService sdhValidaContribuyenteService;

    @Resource(name = "modelService")
    private ModelService modelService;

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

        request.setExpeditionDate(Objects.nonNull(documentExpirationDateInput) ?
                Objects.nonNull(documentExpirationDateInput.getValue()) ?
                        formatter.format(documentExpirationDateInput.getValue()) : StringUtils.EMPTY
                         : StringUtils.EMPTY );

        String bpNumber = getBpNumberFromWs(request);
        if(!StringUtils.EMPTY.equals(bpNumber)){
            businessPartnerOutput.setText(getBpNumberFromWs(request));
            takeFoundBpButton.setDisabled(false);
        }else{
            businessPartnerOutput.setText("-- No Existe --");
            takeFoundBpButton.setDisabled(true);
            LOG.info("BP not found");
        }

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
    }

    private String getBpNumberFromWs(ValidaContribuyenteRequest request){
        final String response = sdhValidaContribuyenteService.validaContribuyente(request);
        final ObjectMapper mapper = new ObjectMapper();
        String bpNumber;
        try {
            mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            final SDHValidaMailRolResponse sdhValidaMailRolResponse = mapper.readValue(response, SDHValidaMailRolResponse.class);
            bpNumber = sdhValidaMailRolResponse.getInfoContrib().getNumBP();
        } catch (Exception e) {
            bpNumber = StringUtils.EMPTY;
            LOG.error(e.getMessage());
        }
        return bpNumber;
    }

    public CustomerModel getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(CustomerModel currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
