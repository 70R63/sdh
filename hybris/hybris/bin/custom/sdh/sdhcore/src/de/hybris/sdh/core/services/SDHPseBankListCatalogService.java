/**
 *
 */
package de.hybris.sdh.core.services;

/**
 * @author edson.roa
 *
 */
public interface SDHPseBankListCatalogService
{
	public void deleteAll();

	public void newBankEntry(String financialInstitutionCode, String financialInstitutionName);
}
