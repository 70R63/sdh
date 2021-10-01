package de.hybris.sdh.core.pojos.requests;

public class PaymentServiceRegisterEntityRequest {
    private Integer entityId;
    private String name;

    public PaymentServiceRegisterEntityRequest(Integer entityId, String name) {
        this.entityId = entityId;
        this.name = name;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PaymentServiceRegisterEntityRequest{" +
                "entityId=" + entityId +
                ", name='" + name + '\'' +
                '}';
    }
}
