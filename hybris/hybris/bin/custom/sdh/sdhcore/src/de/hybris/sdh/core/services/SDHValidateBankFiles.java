/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.responses.TypFileBancoListResponse;

/**
 * @author edson.roa
 *
 */
public interface SDHValidateBankFiles
{
	TypFileBancoListResponse getTypeFileBank(String codbk);
}
