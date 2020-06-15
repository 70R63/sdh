package com.sdh.actions.bpfinder;

import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionResult;
import com.hybris.cockpitng.actions.CockpitAction;
import com.hybris.cockpitng.engine.impl.AbstractComponentWidgetAdapterAware;
import de.hybris.platform.core.model.user.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BpFinderAction extends AbstractComponentWidgetAdapterAware implements CockpitAction<CustomerModel, CustomerModel> {
    private static final Logger LOG = LoggerFactory.getLogger(BpFinderAction.class);
    private static final String SOCKET_ID = "bpFinderContext";
    @Override
    public ActionResult<CustomerModel> perform(ActionContext<CustomerModel> actionContext) {
        LOG.info("Performing ...");
        CustomerModel customerModel = actionContext.getData();
        sendOutput(SOCKET_ID, customerModel);
        return new ActionResult<>(ActionResult.SUCCESS);
    }

    @Override
    public boolean canPerform(ActionContext<CustomerModel> ctx) {
        return true;
    }

    @Override
    public boolean needsConfirmation(ActionContext<CustomerModel> ctx) {
        return false;
    }

    @Override
    public String getConfirmationMessage(ActionContext<CustomerModel> ctx) {
        return null;
    }
}
