/**
 *
 */
package de.hybris.sdh.core.services.impl;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.sdh.core.dao.PseBankListCatalogDao;
import de.hybris.sdh.core.model.PseBankListCatalogModel;
import de.hybris.sdh.core.services.SDHPseBankListCatalogService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author edson.roa
 *
 */
public class DefaultSDHPseBankListCatalogService implements SDHPseBankListCatalogService
{


	@Resource(name = "pseBankListCatalogDao")
	private PseBankListCatalogDao pseBankListCatalogDao;

	@Resource(name = "modelService")
	private ModelService modelService;

	private static final Logger LOG = Logger.getLogger(DefaultSDHPseBankListCatalogService.class);

	@Override
	public void deleteAll()
	{
		for (final PseBankListCatalogModel bankModel : pseBankListCatalogDao.getAllBankEntries().getResult())
		{

			LOG.info("Removing BankCatalogEntry:[" + bankModel.getFinancialInstitutionCode() + " , "
					+ bankModel.getFinancialInstitutionName() + "]");

			modelService.remove(bankModel);
		}

		LOG.info("Finished Delete Bank List Catalog Process !");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.sdh.core.services.SDHPseBankListCatalogService#newBankEntry(de.hybris.sdh.core.model.
	 * PseBankListCatalogModel)
	 */
	@Override
	public void newBankEntry(final String financialInstitutionCode, final String financialInstitutionName)
	{
		final PseBankListCatalogModel newBankCatalogModel = modelService.create(PseBankListCatalogModel.class);
		newBankCatalogModel.setFinancialInstitutionCode(financialInstitutionCode);
		newBankCatalogModel.setFinancialInstitutionName(financialInstitutionName);

		LOG.info("New BankCatalogEntry:[" + financialInstitutionCode + " , " + financialInstitutionName + "]");
		modelService.saveAll(newBankCatalogModel);
	}



}
