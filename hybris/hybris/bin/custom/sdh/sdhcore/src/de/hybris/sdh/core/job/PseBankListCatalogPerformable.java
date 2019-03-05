/**
 *
 */
package de.hybris.sdh.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.sdh.core.model.PseBankListCatalogModel;
import de.hybris.sdh.core.services.SDHPseBankListCatalogService;
import de.hybris.sdh.core.soap.pse.PseServices;
import de.hybris.sdh.core.soap.pse.beans.ConstantConnectionData;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;
import de.hybris.sdh.core.soap.pse.impl.MessageHeader;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author edson.roa
 *
 */
public class PseBankListCatalogPerformable extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(PseBankListCatalogPerformable.class);

	@Resource(name = "defaultPseServices")
	private PseServices pseServices;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "sdhPseBankListCatalogService")
	private SDHPseBankListCatalogService sdhPseBankListCatalogService;

	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		final PseBankListCatalogModel bankEntryModel;
		final GetBankListResponseInformationType[] bankList = pseServices.getBankList(this.getConstantConnectionData(),
				this.getMessageHeader());

		sdhPseBankListCatalogService.deleteAll();
		if (bankList != null)
		{
			for (final GetBankListResponseInformationType bank : bankList)
			{
				sdhPseBankListCatalogService.newBankEntry(bank.getFinancialInstitutionCode(), bank.getFinancialInstitutionName());
			}
		}

		LOG.info("Pse Bank List Catalog Performable - CronJob - Finished");

		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	private MessageHeader getMessageHeader()
	{
		final MessageHeader messageHeader = new MessageHeader();
		messageHeader.setTo(configurationService.getConfiguration().getString("sdh.pse.messageHeader.to"));
		messageHeader.setFrom(configurationService.getConfiguration().getString("sdh.pse.messageHeader.from"));
		messageHeader
				.setRepresentingParty(configurationService.getConfiguration().getString("sdh.pse.messageHeader.representingParty"));
		return messageHeader;
	}

	private ConstantConnectionData getConstantConnectionData()
	{
		final ConstantConnectionData constantConnectionData = new ConstantConnectionData();
		constantConnectionData.setPseurl(configurationService.getConfiguration().getString("sdh.pse.pseURL"));
		constantConnectionData.setPpeCode(configurationService.getConfiguration().getString("sdh.pse.ppeCode"));
		return constantConnectionData;
	}


}
