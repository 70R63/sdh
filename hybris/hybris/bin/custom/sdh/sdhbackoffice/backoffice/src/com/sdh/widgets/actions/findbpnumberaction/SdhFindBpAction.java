package com.sdh.widgets.actions.findbpnumberaction;

import com.hybris.backoffice.widgets.actions.bulkedit.BulkEditAction;
import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionResult;
import com.hybris.cockpitng.actions.CockpitAction;
import com.hybris.cockpitng.engine.impl.AbstractComponentWidgetAdapterAware;
import de.hybris.platform.core.model.user.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdhFindBpAction extends AbstractComponentWidgetAdapterAware implements CockpitAction<CustomerModel, CustomerModel> {
    private static final Logger LOG = LoggerFactory.getLogger(SdhFindBpAction.class);

    @Override
    public ActionResult<CustomerModel> perform(ActionContext<CustomerModel> actionContext) {
        this.sendOutput("sdhBpFdrCtx", new Object());
        LOG.info("Performing Sdh Customer's BP Finder [Action]");
        return new ActionResult("success");
    }

    @Override
    public boolean canPerform(ActionContext<CustomerModel> ctx) {
        Object data = ctx.getData();
        return data instanceof CustomerModel;
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
