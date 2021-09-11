package de.hybris.sdh.core.services;

import de.hybris.sdh.core.pojos.requests.PaymentServiceRegisterRequest;
import de.hybris.sdh.core.pojos.responses.PaymentServiceRegisterResponse;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public interface SdhPaymentService {
    PaymentServiceRegisterResponse register (PaymentServiceRegisterRequest paymentServiceRegisterRequest) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
}
