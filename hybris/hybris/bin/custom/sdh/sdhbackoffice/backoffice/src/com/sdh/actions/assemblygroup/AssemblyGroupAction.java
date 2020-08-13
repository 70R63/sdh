package com.sdh.actions.assemblygroup;

import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionResult;
import com.hybris.cockpitng.actions.CockpitAction;
import com.hybris.cockpitng.engine.impl.AbstractComponentWidgetAdapterAware;
import de.hybris.platform.core.model.product.ProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssemblyGroupAction extends AbstractComponentWidgetAdapterAware implements CockpitAction<ProductModel, ProductModel> {
    private static final Logger LOG = LoggerFactory.getLogger(AssemblyGroupAction.class);
    private static final String SOCKET_ID = "assemblyGroupContext";

    @Override
    public ActionResult<ProductModel> perform(ActionContext<ProductModel> actionContext) {
        LOG.info("Performing action");
        ProductModel ycnProductModel = actionContext.getData();
        sendOutput(SOCKET_ID, ycnProductModel); // sending object to widget with assemblyGroupContext
        return new ActionResult<>(ActionResult.SUCCESS);
    }

    @Override
    public boolean canPerform(ActionContext<ProductModel> ctx) {
        return true;
    }

    @Override
    public boolean needsConfirmation(ActionContext<ProductModel> ctx) {
        return false;
    }

    @Override
    public String getConfirmationMessage(ActionContext<ProductModel> ctx) {
        return null;
    }
}
