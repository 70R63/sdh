/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.form.SelectAtomValue;

import java.util.List;

/**
 * @author edson.roa
 *
 */
public interface SDHValidateBankFiles
{
	List<SelectAtomValue> getTypeFileBank(String codbk);
}
