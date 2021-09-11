package de.hybris.sdh.core.pojos.requests;

public class PaymentServiceRegisterRequest {

    private PaymentServiceRegisterEntityRequest entity;
    private PaymentServiceRegisterApplicationRequest application;
    private String concept;
    private String description;
    private String ref1;
    private String ref2;
    private String ref3;
    private String deadline;
    private String returnUrl;
    private Integer value;

    public PaymentServiceRegisterRequest(PaymentServiceRegisterEntityRequest entity,
                                         PaymentServiceRegisterApplicationRequest application,
                                         String concept, String description, String ref1,
                                         String ref2, String ref3, String deadline,
                                         String returnUrl, Integer value) {
        this.entity = entity;
        this.application = application;
        this.concept = concept;
        this.description = description;
        this.ref1 = ref1;
        this.ref2 = ref2;
        this.ref3 = ref3;
        this.deadline = deadline;
        this.returnUrl = returnUrl;
        this.value = value;
    }

    public PaymentServiceRegisterEntityRequest getEntity() {
        return entity;
    }

    public void setEntity(PaymentServiceRegisterEntityRequest entity) {
        this.entity = entity;
    }

    public PaymentServiceRegisterApplicationRequest getApplication() {
        return application;
    }

    public void setApplication(PaymentServiceRegisterApplicationRequest application) {
        this.application = application;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public String getRef3() {
        return ref3;
    }

    public void setRef3(String ref3) {
        this.ref3 = ref3;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
