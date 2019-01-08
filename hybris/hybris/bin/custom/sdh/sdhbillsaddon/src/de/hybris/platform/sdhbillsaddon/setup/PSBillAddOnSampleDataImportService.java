/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.sdhbillsaddon.setup;

import de.hybris.platform.addonsupport.setup.impl.DefaultAddonSampleDataImportService;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.core.initialization.SystemSetupContext;

import java.util.List;


/**
 * Bill Addon Sample Data Import Service which extends {@link DefaultAddonSampleDataImportService}
 */
public class PSBillAddOnSampleDataImportService extends DefaultAddonSampleDataImportService
{
	private static final String IMPORT_URL = "/import";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	private static final String CONTENT_CATALOGS_URL = "/contentCatalogs/";

	@Override
	public void importSampleData(final String extensionName, final SystemSetupContext context, final List<ImportData> importData,
			final boolean solrReindex)
	{
		if (getBooleanSystemSetupParameter(context, IMPORT_SAMPLE_DATA))
		{
			super.importSampleData(extensionName, context, importData, solrReindex);
			importBillCustomers(extensionName);
			importBillPayments(extensionName);

			for (final ImportData importd : importData)
			{
				for (final String contentCatalogName : importd.getContentCatalogNames())
				{
					importBillReceiptsData(context, extensionName, contentCatalogName);
				}
			}
		}
	}

	protected void importBillCustomers(final String extensionName)
	{
		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/customer/bills-customers.impex", extensionName),
				true);
	}

	protected void importBillPayments(final String extensionName)
	{
		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/billpayment/bills.impex", extensionName), true);
		getSetupImpexService().importImpexFile(
				String.format("/%s/import/sampledata/billpayment/bills-transactions.impex", extensionName), true);
	}

	protected void importBillReceiptsData(final SystemSetupContext context, final String importDirectory, final String catalogName)
	{
		logInfo(context, "Importing Bill Receipts Data...");

		final String importRoot = "/" + importDirectory + IMPORT_URL;

		importImpexFile(context, importRoot + CONTENT_CATALOGS_URL + catalogName + "ContentCatalog/bill-receipt-content.impex",
				false);

		logInfo(context, "Done Importing Bill Receipts Data...");
	}

}
