/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.publicsectorstore.setup;

import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
import de.hybris.platform.publicsectorservices.dataimport.impl.PSSampleDataImportService;
import de.hybris.platform.publicsectorstore.constants.PublicsectorstoreConstants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


@SystemSetup(extension = PublicsectorstoreConstants.EXTENSIONNAME)
public class PSStoreSystemSetup extends AbstractSystemSetup
{
	public static final String PUBLICSECTOR = "publicsector";

	private static final String IMPORT_CORE_DATA = "importCoreData";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	private static final String ACTIVATE_SOLR_CRON_JOBS = "activateSolrCronJobs";

	private CoreDataImportService coreDataImportService;
	private PSSampleDataImportService psSampleDataImportService;

	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<>();

		//params.add(createBooleanSystemSetupParameter(IMPORT_CORE_DATA, "Import Core Data", true));
		//params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", true));
		//params.add(createBooleanSystemSetupParameter(ACTIVATE_SOLR_CRON_JOBS, "Activate Solr Cron Jobs", true));

		return params;
	}

	/**
	 * This method will be called during the system initialization.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = SystemSetup.Type.PROJECT, process = SystemSetup.Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		/*
		 * final List<ImportData> importData = new ArrayList<>();
		 * 
		 * final ImportData publicSectorImportData = new ImportData();
		 * publicSectorImportData.setProductCatalogName(PUBLICSECTOR);
		 * publicSectorImportData.setContentCatalogNames(Arrays.asList(PUBLICSECTOR));
		 * publicSectorImportData.setStoreNames(Arrays.asList(PUBLICSECTOR)); importData.add(publicSectorImportData);
		 * 
		 * getCoreDataImportService().execute(this, context, importData); getEventService().publishEvent(new
		 * CoreDataImportedEvent(context, importData));
		 * 
		 * getPsSampleDataImportService().execute(this, context, importData);
		 * 
		 * getEventService().publishEvent(new SampleDataImportedEvent(context, importData));
		 */
	}

	public CoreDataImportService getCoreDataImportService()
	{
		return coreDataImportService;
	}

	@Required
	public void setCoreDataImportService(final CoreDataImportService coreDataImportService)
	{
		this.coreDataImportService = coreDataImportService;
	}

	protected PSSampleDataImportService getPsSampleDataImportService()
	{
		return psSampleDataImportService;
	}

	@Required
	public void setPsSampleDataImportService(final PSSampleDataImportService psSampleDataImportService)
	{
		this.psSampleDataImportService = psSampleDataImportService;
	}
}
