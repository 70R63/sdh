/**
 *
 */
package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.model.PseTransactionsLogModel;

import javax.annotation.Resource;


/**
 * @author edson.roa
 *
 */
public class DefaultPseTransactionsLogDao extends DefaultGenericDao<PseTransactionsLogModel> implements PseTransactionsLogDao
{


	public DefaultPseTransactionsLogDao(final String typecode)
	{
		super(typecode);
	}

	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService defaultFlexibleSearchService;

	@Override
	public SearchResult<PseTransactionsLogModel> getAllOutstandingTransactions(final String transactionState)
	{
		final String GET_ALL_OUTSTANDING_TRANSACTIONS = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
		      + PseTransactionsLogModel._TYPECODE + " AS p} Where "
				+ "{p:" + PseTransactionsLogModel.TRANSACTIONSTATE + "} = '" + transactionState + "' ";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(GET_ALL_OUTSTANDING_TRANSACTIONS);
		return getFlexibleSearchService().search(query);
	}

	@Override
	public PseTransactionsLogModel getTransaction(final String numeroDeReferencia)
	{
		PseTransactionsLogModel transactionModel = null;
		final String GET_TRANSACTION = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
				+ PseTransactionsLogModel._TYPECODE + " AS p} Where {p:" + PseTransactionsLogModel.NUMERODEREFERENCIA + "} = '"
				+ numeroDeReferencia + "'";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(GET_TRANSACTION);
		final SearchResult<PseTransactionsLogModel> transactions = getFlexibleSearchService().search(query);

		if (transactions.getResult().size() > 0)
		{
			transactionModel = transactions.getResult().get(0);
	   }

		return transactionModel;
	}

}
