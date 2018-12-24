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
package de.hybris.platform.powertoolsstore.setup;

import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.commerceservices.setup.events.CoreDataImportedEvent;
import de.hybris.platform.commerceservices.setup.events.SampleDataImportedEvent;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
import de.hybris.platform.powertoolsstore.constants.PowertoolsStoreConstants;
import de.hybris.platform.powertoolsstore.services.dataimport.impl.PowertoolsCoreDataImportService;
import de.hybris.platform.powertoolsstore.services.dataimport.impl.PowertoolsSampleDataImportService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


@SystemSetup(extension = PowertoolsStoreConstants.EXTENSIONNAME)
public class PowertoolsStoreSystemSetup extends AbstractSystemSetup
{
	public static final String POWERTOOLS = "powertools";

	private static final String IMPORT_CORE_DATA = "importCoreData";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	private static final String ACTIVATE_SOLR_CRON_JOBS = "activateSolrCronJobs";

	private PowertoolsCoreDataImportService powertoolsCoreDataImportService;
	private PowertoolsSampleDataImportService powertoolsSampleDataImportService;

	@SystemSetupParameterMethod
	@Override
	public List<SystemSetupParameter> getInitializationOptions()
	{
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
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = SystemSetup.Type.PROJECT, process = SystemSetup.Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		/*final List<ImportData> importData = new ArrayList<ImportData>();

		final ImportData powertoolsImportData = new ImportData();
		powertoolsImportData.setProductCatalogName(POWERTOOLS);
		powertoolsImportData.setContentCatalogNames(Arrays.asList(POWERTOOLS));
		powertoolsImportData.setStoreNames(Arrays.asList(POWERTOOLS));
		importData.add(powertoolsImportData);

		getPowertoolsCoreDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new CoreDataImportedEvent(context, importData));

		getPowertoolsSampleDataImportService().execute(this, context, importData);
		getPowertoolsSampleDataImportService().importCommerceOrgData(context);
		getEventService().publishEvent(new SampleDataImportedEvent(context, importData));*/
	}

	public PowertoolsCoreDataImportService getPowertoolsCoreDataImportService()
	{
		return powertoolsCoreDataImportService;
	}

	@Required
	public void setPowertoolsCoreDataImportService(final PowertoolsCoreDataImportService powertoolsCoreDataImportService)
	{
		this.powertoolsCoreDataImportService = powertoolsCoreDataImportService;
	}


	public PowertoolsSampleDataImportService getPowertoolsSampleDataImportService()
	{
		return powertoolsSampleDataImportService;
	}

	@Required
	public void setPowertoolsSampleDataImportService(final PowertoolsSampleDataImportService powertoolsSampleDataImportService)
	{
		this.powertoolsSampleDataImportService = powertoolsSampleDataImportService;
	}


}
