/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.CalcGasolina2Request;
import de.hybris.sdh.core.pojos.requests.CalcICA2Request;


/**
 * @author Maria Luisa
 *
 */
public interface SDHCalICA2Service
{
	String calcICA2(CalcICA2Request request);
}
