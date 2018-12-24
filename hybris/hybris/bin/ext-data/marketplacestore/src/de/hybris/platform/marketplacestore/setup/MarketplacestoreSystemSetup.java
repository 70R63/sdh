/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.marketplacestore.setup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;
import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.commerceservices.setup.events.CoreDataImportedEvent;
import de.hybris.platform.commerceservices.setup.events.SampleDataImportedEvent;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
import de.hybris.platform.marketplacestore.constants.MarketplacestoreConstants;
import de.hybris.platform.marketplacestore.service.dataimport.impl.MarketplaceSampleDataImportService;

@SystemSetup(extension = MarketplacestoreConstants.EXTENSIONNAME)
public class MarketplacestoreSystemSetup extends AbstractSystemSetup {

	public static final String MARKETPLACE = "marketplace";
	public static final String PRODUCTCATALOGNAME = "globalMarketplace";

	private static final String IMPORT_CORE_DATA = "importCoreData";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	private static final String ACTIVATE_SOLR_CRON_JOBS = "activateSolrCronJobs";

	private CoreDataImportService coreDataImportService;
	private SampleDataImportService sampleDataImportService;

	@SystemSetupParameterMethod
	@Override
	public List<SystemSetupParameter> getInitializationOptions() {
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		//params.add(createBooleanSystemSetupParameter(IMPORT_CORE_DATA, "Import Core Data", true));
		//params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", true));
		//params.add(createBooleanSystemSetupParameter(ACTIVATE_SOLR_CRON_JOBS, "Activate Solr Cron Jobs", true));

		return params;
	}

	/**
	 * This method will be called during the system initialization.
	 *
	 * @param context
	 *            the context provides the selected parameters and values
	 */
	@SystemSetup(type = SystemSetup.Type.PROJECT, process = SystemSetup.Process.ALL)
	public void createProjectData(final SystemSetupContext context) {
		/*final List<ImportData> importData = new ArrayList<ImportData>();

		final ImportData marketplaceImportData = new ImportData();
		marketplaceImportData.setProductCatalogName(PRODUCTCATALOGNAME);
		marketplaceImportData.setContentCatalogNames(Collections.singletonList(MARKETPLACE));
		marketplaceImportData.setStoreNames(Collections.singletonList(MARKETPLACE));
		importData.add(marketplaceImportData);

		getCoreDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new CoreDataImportedEvent(context, importData));

		getSampleDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new SampleDataImportedEvent(context, importData));*()
	}

	public CoreDataImportService getCoreDataImportService() {
		return coreDataImportService;
	}

	@Required
	public void setCoreDataImportService(final CoreDataImportService coreDataImportService) {
		this.coreDataImportService = coreDataImportService;
	}

	public SampleDataImportService getSampleDataImportService() {
		return sampleDataImportService;
	}

	@Required
	public void setSampleDataImportService(final MarketplaceSampleDataImportService sampleDataImportService) {
		this.sampleDataImportService = sampleDataImportService;
	}
}
