package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterRequest;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;

public interface SdhPaymentService {
    PaymentServiceRegisterResponse register (PaymentServiceRegisterRequest paymentServiceRegisterRequest);
}
