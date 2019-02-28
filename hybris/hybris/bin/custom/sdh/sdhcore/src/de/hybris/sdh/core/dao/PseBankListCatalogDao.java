/**
 *
 */
package de.hybris.sdh.core.dao;

import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.sdh.core.model.PseBankListCatalogModel;

/**
 * @author edson.roa
 *
 */
public interface PseBankListCatalogDao
{

	public SearchResult<PseBankListCatalogModel> getAllBankEntries();


	public PseBankListCatalogModel getBankByFinancialInstitutionCode(String financialInstitutionCode);
}
