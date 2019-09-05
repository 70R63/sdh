/**
 *
 */
package de.hybris.sdh.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.sdh.core.model.SDHICAEconomicActivityModel;


/**
 * @author hybris
 *
 */
public class DefaultSDHICAEconomicActivityDao extends DefaultGenericDao<SDHICAEconomicActivityModel>
{
	public DefaultSDHICAEconomicActivityDao(final String typecode)
	{
		super(typecode);
	}
}
