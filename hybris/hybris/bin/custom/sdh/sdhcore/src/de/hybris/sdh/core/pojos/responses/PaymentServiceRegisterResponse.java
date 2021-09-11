package de.hybris.sdh.core.pojos.responses;

public class PaymentServiceRegisterResponse {
    private String message;
    private Integer nus;
    private String paymentUrl;

    public PaymentServiceRegisterResponse() {
    }

    public PaymentServiceRegisterResponse(String message, Integer nus, String paymentUrl) {
        this.message = message;
        this.nus = nus;
        this.paymentUrl = paymentUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNus() {
        return nus;
    }

    public void setNus(Integer nus) {
        this.nus = nus;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }
}
