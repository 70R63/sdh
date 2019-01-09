/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.sdhrelationshipsaddon.setup.impl;

import de.hybris.platform.addonsupport.setup.impl.DefaultAddonSampleDataImportService;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.core.initialization.SystemSetupContext;

import java.util.List;


/**
 * PSAddonSampleDataImportService to import relationship specific data.
 */
public class PSAddonSampleDataImportService extends DefaultAddonSampleDataImportService
{
	@Override
	public void importSampleData(final String extensionName, final SystemSetupContext context, final List<ImportData> importData,
			final boolean solrReindex)
	{
		super.importSampleData(extensionName, context, importData, solrReindex);
		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/customer/relationships-customers.impex",extensionName), true);
		getSetupImpexService()
				.importImpexFile(String.format("/%s/import/sampledata/relationships/relationships.impex", extensionName), true);
	}

}
