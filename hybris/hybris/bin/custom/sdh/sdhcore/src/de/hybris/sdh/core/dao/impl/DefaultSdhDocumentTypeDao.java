package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.dao.SdhDocumentTypeDao;
import de.hybris.sdh.core.form.SelectAtomValue;
import de.hybris.sdh.core.model.SdhDocumentTypeModel;

import java.util.ArrayList;
import java.util.List;

public class DefaultSdhDocumentTypeDao extends DefaultGenericDao<SdhDocumentTypeModel>  implements SdhDocumentTypeDao {

    public DefaultSdhDocumentTypeDao(String typecode) {
        super(typecode);
    }

    @Override
    public List<SelectAtomValue> getAllDocumentTypes() {
        List<SelectAtomValue>  list = new ArrayList<>();
        List<SdhDocumentTypeModel> documentTypeModels = super.find();
        documentTypeModels.forEach(documentType ->{
            list.add(new SelectAtomValue(documentType.getCode(),
                    documentType.getDescription()));
        });
        return list;
    }
}
