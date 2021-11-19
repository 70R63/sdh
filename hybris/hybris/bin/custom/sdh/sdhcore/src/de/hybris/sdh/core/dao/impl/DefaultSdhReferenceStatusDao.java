package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.dao.SdhReferenceStatusDao;
import de.hybris.sdh.core.form.SelectAtomValue;
import de.hybris.sdh.core.model.SdhReferenceStatusModel;

import java.util.ArrayList;
import java.util.List;


public class DefaultSdhReferenceStatusDao extends DefaultGenericDao<SdhReferenceStatusModel> implements SdhReferenceStatusDao
{

    public DefaultSdhReferenceStatusDao(final String typecode) {
        super(typecode);
    }

	 @Override
	 public List<SelectAtomValue> getAllReferenceStatus()
	 {
		 final List<SelectAtomValue> list = new ArrayList<>();
		 final List<SdhReferenceStatusModel> referenceStatusModels = super.find();
		 referenceStatusModels.forEach(documentType -> {
			 list.add(new SelectAtomValue(documentType.getCode(), documentType.getDescription()));
		 });
		 return list;
	 }
}
