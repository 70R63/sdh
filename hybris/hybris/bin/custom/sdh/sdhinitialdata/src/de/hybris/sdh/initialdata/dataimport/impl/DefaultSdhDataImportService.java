/**
 *
 */
package de.hybris.sdh.initialdata.dataimport.impl;

import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.core.initialization.SystemSetupContext;


/**
 * @author yjwhoinu
 *
 */
public class DefaultSdhDataImportService extends SampleDataImportService
{
	private static final String BILL_MODULE_EXTENSION = "billservices";
	private static final String RELATIONSHIP_MODULE_EXTENSION = "relationshipservices";

	@Override
	protected void importProductCatalog(final String extensionName, final String productCatalogName)
	{
		super.importProductCatalog(extensionName, productCatalogName);
		// Load Bundle Templates
		getSetupImpexService()
				.importImpexFile(String.format("/%s/import/sampledata/productCatalogs/%sProductCatalog/bundletemplates.impex",
						extensionName, productCatalogName), false);
		getSetupImpexService().importImpexFile(
				String.format("/%s/import/sampledata/productCatalogs/%sProductCatalog/bundletemplates-products.impex", extensionName,
						productCatalogName),
				false);
		getSetupImpexService().importImpexFile(
				String.format("/%s/import/sampledata/productCatalogs/%sProductCatalog/bundletemplates-selectioncriteria.impex",
						extensionName, productCatalogName),
				false);
		getSetupImpexService().importImpexFile(
				String.format("/%s/import/sampledata/productCatalogs/%sProductCatalog/bundletemplates-sampledata.impex",
						extensionName, productCatalogName),
				false);
		getSetupImpexService()
				.importImpexFile(String.format("/%s/import/sampledata/productCatalogs/%sProductCatalog/catalog-sync.impex",
						extensionName, productCatalogName), true);
		getSetupImpexService()
				.importImpexFile(String.format("/%s/import/sampledata/productCatalogs/%sProductCatalog/yform-template-content.impex",
						extensionName, productCatalogName), true);

		// Load datahub data classification
		getSetupImpexService().importImpexFile(
				String.format("/%s/import/sampledata/productCatalogs/%sProductCatalog/datahub-data-classification.impex",
						extensionName, productCatalogName),
				false);
	}

	@Override
	protected void importCommonData(final String extensionName)
	{
		super.importCommonData(extensionName);
		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/customer/customers.impex", extensionName),
				true);
		getSetupImpexService().importImpexFile(
				String.format("/%s/import/cockpits/productcockpit/productcockpit-access-rights.impex", extensionName), true);
		getSetupImpexService().importImpexFile(String.format("/%s/import/coredata/common/pscronjobs.impex", extensionName), true);
		getSetupImpexService()
				.importImpexFile(String.format("/%s/import/cockpits/cmscockpit/cmscockpit-access-rights.impex", extensionName), true);
	}

	@Override
	protected void importContentCatalog(final String extensionName, final String contentCatalogName)
	{
		super.importContentCatalog(extensionName, contentCatalogName);

		getSetupImpexService()
				.importImpexFile(String.format("/%s/import/sampledata/contentCatalogs/%sContentCatalog/forms-content.impex",
						extensionName, contentCatalogName), true);
	}

	@Override
	protected void importAllData(final AbstractSystemSetup systemSetup, final SystemSetupContext context,
			final ImportData importData, final boolean syncCatalogs)
	{
		super.importAllData(systemSetup, context, importData, syncCatalogs);

		importSampleOrders(context.getExtensionName());
		importRelationshipData(context.getExtensionName());
		importAssetData(context.getExtensionName());
		importAssetBillData(context.getExtensionName());
	}

	protected void importRelationshipData(final String extensionName)
	{
		if (isExtensionLoaded(RELATIONSHIP_MODULE_EXTENSION))
		{
			if (isExtensionLoaded(BILL_MODULE_EXTENSION))
			{
				getSetupImpexService().importImpexFile(
						String.format("/%s/import/sampledata/relationships/permissible-types.impex", extensionName), true);
			}
			getSetupImpexService()
					.importImpexFile(String.format("/%s/import/sampledata/relationships/permissions.impex", extensionName), true);
		}
	}

	protected void importSampleOrders(final String extensionName)
	{
		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/orders/orders.impex", extensionName), true);
	}

	protected void importAssetData(final String extensionName)
	{
		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/assets/assets.impex", extensionName), true);
	}

	protected void importAssetBillData(final String extensionName)
	{
		getSetupImpexService().importImpexFile(String.format("/%s/import/sampledata/assets/assets-bills.impex", extensionName),
				true);
	}
}
