package de.hybris.sdh.core.pojos.requests;

public class PaymentServiceRegisterApplicationRequest {
    private Integer applicationId;
    private String name;

    public PaymentServiceRegisterApplicationRequest(Integer applicationId, String name) {
        this.applicationId = applicationId;
        this.name = name;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PaymentServiceRegisterApplicationRequest{" +
                "applicationId=" + applicationId +
                ", name='" + name + '\'' +
                '}';
    }
}
