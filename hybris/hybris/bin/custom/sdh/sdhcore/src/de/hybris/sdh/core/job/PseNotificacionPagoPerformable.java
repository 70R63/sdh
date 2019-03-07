/**
 *
 */
package de.hybris.sdh.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.sdh.core.services.SDHNotificacionPagoService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


/**
 * @author edson.roa
 *
 */
public class PseNotificacionPagoPerformable extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(PseNotificacionPagoPerformable.class);

	@Resource(name = "sdhNotificacionPagoService")
	private SDHNotificacionPagoService sdhNotificacionPagoService;

	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		sdhNotificacionPagoService.notifyAllTransactionWithStatusOkAndNotNotifiedBefore();
		LOG.info("---- PseNotificacionPagoPerformable ---");
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
