package com.sdh.widgets.actions.findbpnumberaction;

import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionListener;
import com.hybris.cockpitng.actions.CockpitAction;
import com.hybris.cockpitng.actions.impl.DefaultActionRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;

public class SdhActionRender extends DefaultActionRenderer {
    public static final String IS_DISABLED = "isDisabled";
    private static final Logger LOG = LoggerFactory.getLogger(SdhActionRender.class);

    @Override
    public void render(Component parent, CockpitAction action, ActionContext context, boolean updateMode, ActionListener listener)
    {
        LOG.info("Performing SdhActionRender");
        super.render(parent, action, context, updateMode, listener);
        HtmlBasedComponent container = this.getOrCreateContainer(parent);
        String sclass = this.getActionBodySclass(context);
        //Boolean isDisabled = (Boolean) context.getParameter(IS_DISABLED);
        //if (isDisabled != null && isDisabled)
        //{
            sclass = sclass + " cng-action-visible-disabled";
            container.setSclass(sclass);
        //}
    }

    @Override
    protected void perform(CockpitAction action, ActionContext context, ActionListener listener)
    {
        Boolean isDisabled = (Boolean) context.getParameter(IS_DISABLED);
        if (isDisabled == null || !isDisabled)
        {
            super.perform(action, context, listener);
        }
    }
}
