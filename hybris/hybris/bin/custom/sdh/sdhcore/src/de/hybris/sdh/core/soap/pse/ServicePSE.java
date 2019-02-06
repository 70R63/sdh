/**
 *
 */
package de.hybris.sdh.core.soap.pse;
import de.hybris.sdh.core.soap.pse.eanucc.GetBankListResponseInformationType;

/**
 * @author Consultor
 *
 */
public interface ServicePSE
{
	public GetBankListResponseInformationType[] getBankList(String from, String to, String representingParty);

}
