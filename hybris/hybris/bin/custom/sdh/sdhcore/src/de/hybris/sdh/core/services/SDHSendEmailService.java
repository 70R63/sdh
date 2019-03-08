/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.SendEmailRequest;

/**
 * @author hybris
 *
 */
public interface SDHSendEmailService
{
	String sendEmail(SendEmailRequest request);
}
