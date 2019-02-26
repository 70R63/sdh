/**
 *
 */
package de.hybris.sdh.core.pojos.requests.pse;

/**
 * @author edson.roa
 *
 */
public class GetBankListData
{
	private ConstantConnectionData constantConnectionData;
	private MessageHeader messageHeader;

	/**
	 * @return the constantConnectionData
	 */
	public ConstantConnectionData getConstantConnectionData()
	{
		return constantConnectionData;
	}

	/**
	 * @param constantConnectionData
	 *           the constantConnectionData to set
	 */
	public void setConstantConnectionData(final ConstantConnectionData constantConnectionData)
	{
		this.constantConnectionData = constantConnectionData;
	}

	/**
	 * @return the messageHeader
	 */
	public MessageHeader getMessageHeader()
	{
		return messageHeader;
	}

	/**
	 * @param messageHeader
	 *           the messageHeader to set
	 */
	public void setMessageHeader(final MessageHeader messageHeader)
	{
		this.messageHeader = messageHeader;
	}


}
