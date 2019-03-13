/**
 *
 */
package de.hybris.sdh.core.job;

import de.hybris.platform.catalog.model.CatalogUnawareMediaModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;


public class SDHDeletePDFMediaFilesJobPerformable extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(SDHDeletePDFMediaFilesJobPerformable.class);

	@Resource(name = "flexibleSearchService")
	private FlexibleSearchService flexibleSearchService;

	@Resource(name = "modelService")
	ModelService modelService;

	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		final String query = "SELECT {pk} FROM {CatalogUnawareMedia} WHERE {deleteByCronjob} = 1 AND {creationtime} < ?today";

		final LocalDate localDate = LocalDate.now();
		final Date today = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		final Map<String, Object> params = new HashMap<String, Object>();

		params.put("today", today);

		final SearchResult<CatalogUnawareMediaModel> searchResult = flexibleSearchService.search(query, params);

		if (searchResult.getResult() != null && searchResult.getResult().size() > 0)
		{
			modelService.removeAll(searchResult.getResult());
		}

		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
