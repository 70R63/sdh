package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.sdh.core.dao.SDHPaymentMethodDao;
import de.hybris.sdh.core.model.SDHPaymentMethodModel;

import javax.annotation.Resource;


public class DefaultSDHPaymentMethodDao extends DefaultGenericDao<SDHPaymentMethodModel> implements SDHPaymentMethodDao
{

	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService defaultFlexibleSearchService;


	public DefaultSDHPaymentMethodDao(final String typecode)
	{
        super(typecode);
    }

	private static final String GET_SDHPAYMENT_ENTRY_BY_CODE = "Select {p:" + SDHPaymentMethodModel.PK + "} from {"
			+ SDHPaymentMethodModel._TYPECODE + " AS p} WHERE {" + SDHPaymentMethodModel.CODE + "} = ?" + SDHPaymentMethodModel.CODE
			+ "";


	@Override
	public SDHPaymentMethodModel getBySDHPaymentMethodCode(final String sdhPaymentMethodCode)
	{
		final FlexibleSearchQuery query = new FlexibleSearchQuery(GET_SDHPAYMENT_ENTRY_BY_CODE);
		query.addQueryParameter(SDHPaymentMethodModel.CODE, sdhPaymentMethodCode);
		return getFlexibleSearchService().searchUnique(query);
	}

}
