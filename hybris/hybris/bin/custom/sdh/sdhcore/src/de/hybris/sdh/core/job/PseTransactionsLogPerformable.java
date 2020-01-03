/**
 *
 */
package de.hybris.sdh.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.sdh.core.services.SDHPseTransactionsLogService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author edson.roa
 *
 */
public class PseTransactionsLogPerformable extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(PseTransactionsLogPerformable.class);

	@Resource(name = "pseTransactionsLogService")
	private SDHPseTransactionsLogService pseTransactionsLogService;

	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		LOG.info(" -------------- PseTransactionsLogPerformable Updating PENDING Transactions -------------");
		pseTransactionsLogService.updateAllTransactions("PENDING");
		pseTransactionsLogService.updateAllTransactions("");
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
