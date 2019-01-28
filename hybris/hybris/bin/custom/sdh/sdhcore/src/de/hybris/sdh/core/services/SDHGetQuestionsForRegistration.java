/**
 *
 */
package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.ConsultaContribuyenteBPRequest;
import de.hybris.sdh.core.pojos.responses.QuestionForRegistrationResponse;

/**
 * @author Consultor
 *
 */
public interface SDHGetQuestionsForRegistration
{
	QuestionForRegistrationResponse getQuestionForRegistration(final ConsultaContribuyenteBPRequest request);
}
