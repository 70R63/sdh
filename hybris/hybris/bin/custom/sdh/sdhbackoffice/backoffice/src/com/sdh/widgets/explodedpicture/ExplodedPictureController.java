package com.sdh.widgets.explodedpicture;

import com.hybris.cockpitng.annotations.SocketEvent;
import com.hybris.cockpitng.annotations.ViewEvent;
import com.hybris.cockpitng.util.DefaultWidgetController;
import de.hybris.platform.core.model.product.ProductModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

public class ExplodedPictureController extends DefaultWidgetController {
    private static final Logger LOG = LoggerFactory.getLogger(ExplodedPictureController.class);
    private static final String SOCKET_ID = "explodedPictureInput";

    @Wire
    private Textbox searchInput;

    // init of explodedpicture.zul
    @SocketEvent(socketId = SOCKET_ID) // explodedPictureInput is <sockets><input id="assemblyGroupInput" in widgetDefinitionXml
    public void init(final ProductModel productModel) {
        LOG.info("Performing init controller action");
        ProductModel ycnProductModel = (ProductModel) productModel;
        searchInput.setText("enter key words" + ycnProductModel.toString());
    }

    @ViewEvent(componentID = "searchBtn", eventName = "onClick") // searchBtn is zul button id
    public void searchKeyWord() {
        searchInput.setText("hello");
    }

}