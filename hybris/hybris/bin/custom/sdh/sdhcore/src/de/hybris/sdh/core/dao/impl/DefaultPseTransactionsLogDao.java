/**
 *
 */
package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.search.exceptions.FlexibleSearchException;
import de.hybris.sdh.core.constants.ControllerPseConstants;
import de.hybris.sdh.core.dao.PseTransactionsLogDao;
import de.hybris.sdh.core.model.PseTransactionsLogModel;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author edson.roa
 *
 */
public class DefaultPseTransactionsLogDao extends DefaultGenericDao<PseTransactionsLogModel> implements PseTransactionsLogDao
{
	private static final Logger LOG = Logger.getLogger(DefaultPseTransactionsLogDao.class); //new

	public DefaultPseTransactionsLogDao(final String typecode)
	{
		super(typecode);
	}

	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService defaultFlexibleSearchService;

	@Override
	public SearchResult<PseTransactionsLogModel> getAllOutstandingTransactions(final String transactionState)
	{

		String GET_ALL_OUTSTANDING_TRANSACTIONS = new String();

		if (transactionState.length() == 0)
		{
			GET_ALL_OUTSTANDING_TRANSACTIONS = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
					+ PseTransactionsLogModel._TYPECODE + " AS p} Where " + "{p:" + PseTransactionsLogModel.TRANSACTIONSTATE
					+ "}  in (null, '')  and " + "{p:" + PseTransactionsLogModel.TRAZABILITYCODE + "} not in ('-1', '') ";
		}
		else
		{
			GET_ALL_OUTSTANDING_TRANSACTIONS = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
					+ PseTransactionsLogModel._TYPECODE + " AS p} Where " + "{p:" + PseTransactionsLogModel.TRANSACTIONSTATE + "} = '"
					+ transactionState + "' ";
		}


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

	/*
	 * (non-Javadoc) Just PSE/ACH Transactions
	 *
	 * @see de.hybris.sdh.core.dao.PseTransactionsLogDao#getAllTransactionsNotNotifiedPaymentAndStatusOk()
	 */
	@Override
	public SearchResult<PseTransactionsLogModel> getAllTransactionsNotNotifiedPaymentAndStatusOk(
			final String transactionStateStatus, final String notificacionRecaudoStatus)
	{
		final String GET_ALL_TRANSACTION_NOT_NOTIFIED_PAYMENT = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
		      + PseTransactionsLogModel._TYPECODE + " AS p} Where "
				+ "{p:" + PseTransactionsLogModel.TRANSACTIONSTATE + "} = '" + transactionStateStatus + "' AND " + "{p:"
				+ PseTransactionsLogModel.NOTIFICACIONDERECAUDO + "} = '" + notificacionRecaudoStatus + "' AND " + "{p:"
				+ PseTransactionsLogModel.ENTITYCODE + "} NOT IN ('" + ControllerPseConstants.CREDIBANCO_IDENTIFIER_TRANSACTION
				+ "')";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(GET_ALL_TRANSACTION_NOT_NOTIFIED_PAYMENT);
		final SearchResult<PseTransactionsLogModel> transactions = getFlexibleSearchService().search(query);
		return getFlexibleSearchService().search(query);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.sdh.core.dao.PseTransactionsLogDao#getAllCredibancoTransactionsNotNotifiedPaymentAndStatusAproved(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public SearchResult<PseTransactionsLogModel> getAllCredibancoTransactionsNotNotifiedPaymentAndStatusAproved(
			final String transactionStateStatus, final String notificacionRecaudoStatus)
	{
		final String GET_ALL_TRANSACTION_NOT_NOTIFIED_PAYMENT = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
				+ PseTransactionsLogModel._TYPECODE + " AS p} Where " + "{p:" + PseTransactionsLogModel.CRERESPONSESTATUS + "} = '"
				+ transactionStateStatus + "' AND " + "{p:" + PseTransactionsLogModel.NOTIFICACIONDERECAUDO + "} = '"
				+ notificacionRecaudoStatus + "' AND " + "{p:" + PseTransactionsLogModel.ENTITYCODE + "} = '"
				+ ControllerPseConstants.CREDIBANCO_IDENTIFIER_TRANSACTION + "'";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(GET_ALL_TRANSACTION_NOT_NOTIFIED_PAYMENT);
		final SearchResult<PseTransactionsLogModel> transactions = getFlexibleSearchService().search(query);
		return getFlexibleSearchService().search(query);
	}

	public String getTransactionState(final String impuesto, final String anogravable, final String periodo,
			final String tipoDeIdentificacion, final String noIdentificacion)
	{
		String transactionState = new String();
		final String pending = "PENDING";
		final String ok = "OK";

		final PseTransactionsLogModel transactionModel = null;
		final String GET_TRANSACTION = "Select {p:" + PseTransactionsLogModel.PK + "} from {" + PseTransactionsLogModel._TYPECODE
				+ " AS p} Where {p:" + PseTransactionsLogModel.TIPODEIMPUESTO + "} = '" + impuesto + "'" + " AND {p:"
				+ PseTransactionsLogModel.ANOGRAVABLE + "} = '" + anogravable + "'" + " AND {p:" + PseTransactionsLogModel.PERIODO
				+ "} = '" + periodo + "'" + " AND {p:" + PseTransactionsLogModel.TRANSACTIONSTATE + "} = '" + pending + "' AND {p:"
				+ PseTransactionsLogModel.TIPODEIDENTIFICACION + "} = '" + tipoDeIdentificacion + "' AND {p:"
				+ PseTransactionsLogModel.NOIDENTIFICACION + "} = '" + noIdentificacion + "' ORDER BY {p:"
				+ PseTransactionsLogModel.TRANSACTIONSTATE + "}";

		LOG.info("-------------INI PENDING QUERY-------------");
		LOG.info(GET_TRANSACTION);
		LOG.info("-------------FIN PENDING QUERY-------------");

		final FlexibleSearchQuery query = new FlexibleSearchQuery(GET_TRANSACTION);
		final SearchResult<PseTransactionsLogModel> transactions = getFlexibleSearchService().search(query);

		if (transactions.getResult().size() > 0)
		{
			transactionState = transactions.getResult().get(0).getTransactionState();
		}

		return transactionState;
	}

	@Override
	public String getNusSequence()
	{
		String GET_NUS_SEQUENCE = new String();
		String nus = new String("0");


		GET_NUS_SEQUENCE = "select NEXT VALUE FOR NUSSEQUENCE as NUS from {SDHPaymentProvType} where {code} = 'ACH'";
		FlexibleSearchQuery query;
		SearchResult<String> resultSet;


		try
		{
			//Consulta para secuencia NUSSEQUENCE en HANA
			GET_NUS_SEQUENCE = "select (NUSSEQUENCE.nextval) as NUS from {SDHPaymentProvType} where {code} = 'ACH'";
			query = new FlexibleSearchQuery(GET_NUS_SEQUENCE);
			query.setResultClassList(Arrays.asList(String.class));
			resultSet = getFlexibleSearchService().search(query);

		}
		catch (final FlexibleSearchException fse)
		{
			//Consulta para secuencia NUSSEQUENCE en HSQLDB
			GET_NUS_SEQUENCE = "select NEXT VALUE FOR NUSSEQUENCE as NUS from {SDHPaymentProvType} where {code} = 'ACH'";
			query = new FlexibleSearchQuery(GET_NUS_SEQUENCE);
			query.setResultClassList(Arrays.asList(String.class));
			resultSet = getFlexibleSearchService().search(query);
		}

		final List<String> resultList = resultSet.getResult();

		for (int i = 0; i < resultList.size(); i++)
		{
			nus = resultList.get(0);
		}



		return nus;

	}

	@Override
	public SearchResult<PseTransactionsLogModel> getAllOutstandingCredibancoTransactions(final String transactionState)
	{
		String GET_ALL_OUTSTANDING_CREDIBANCO_TRANSACTIONS = new String();
		final String NOTIFICACIONDERECAUDO_NO = new String("NO");
		final String CREDIBANCO_TRANSACTION = new String("CREDIBANCO_TRANSACTION");

		if (transactionState.length() == 0)
		{
			GET_ALL_OUTSTANDING_CREDIBANCO_TRANSACTIONS = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
					+ PseTransactionsLogModel._TYPECODE + " AS p} Where " + "{p:" + PseTransactionsLogModel.ENTITYCODE + "}  = '"
					+ CREDIBANCO_TRANSACTION + "' and " + "{p:" + PseTransactionsLogModel.TRANSACTIONSTATE + "}  in (null, '')  and "
					+ "{p:" + PseTransactionsLogModel.CREAPPROVALNUMBER + "} not in (null, '') ";
		}
		else
		{
			GET_ALL_OUTSTANDING_CREDIBANCO_TRANSACTIONS = "Select {p:" + PseTransactionsLogModel.PK + "} from {"
					+ PseTransactionsLogModel._TYPECODE + " AS p} Where " + "{p:" + PseTransactionsLogModel.ENTITYCODE + "}  = '"
					+ CREDIBANCO_TRANSACTION + "' and " + "{p:" + PseTransactionsLogModel.TRANSACTIONSTATE + "} = '"
					+ transactionState + "' and " + "{p:" + PseTransactionsLogModel.NOTIFICACIONDERECAUDO + "} = '"
					+ NOTIFICACIONDERECAUDO_NO + "'";
		}


		final FlexibleSearchQuery query = new FlexibleSearchQuery(GET_ALL_OUTSTANDING_CREDIBANCO_TRANSACTIONS);
		return getFlexibleSearchService().search(query);
	}



}
