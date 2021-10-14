package de.hybris.sdh.core.pojos.requests;

import java.math.BigInteger;


public class PaymentServiceRegisterRequest {

    private PaymentServiceRegisterEntityRequest entity;
    private PaymentServiceRegisterApplicationRequest application;
    private String concept;
    private String description;
    private String ref1;
    private String ref2;
    private String ref3;
    private String ref4;
    private String deadline;
    private String returnUrl;
	private BigInteger value;

    public PaymentServiceRegisterRequest(final PaymentServiceRegisterEntityRequest entity,
                                         final PaymentServiceRegisterApplicationRequest application,
                                         final String concept, final String description, final String ref1,
                                         final String ref2, final String ref3, final String ref4, final String deadline,
			final String returnUrl, final BigInteger value)
	{
        this.entity = entity;
        this.application = application;
        this.concept = concept;
        this.description = description;
        this.ref1 = ref1;
        this.ref2 = ref2;
        this.ref3 = ref3;
        this.ref4 = ref4;
        this.deadline = deadline;
        this.returnUrl = returnUrl;
        this.value = value;
    }

    public PaymentServiceRegisterEntityRequest getEntity() {
        return entity;
    }

    public void setEntity(final PaymentServiceRegisterEntityRequest entity) {
        this.entity = entity;
    }

    public PaymentServiceRegisterApplicationRequest getApplication() {
        return application;
    }

    public void setApplication(final PaymentServiceRegisterApplicationRequest application) {
        this.application = application;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(final String concept) {
        this.concept = concept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(final String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(final String ref2) {
        this.ref2 = ref2;
    }

    public String getRef3() {
        return ref3;
    }

    public void setRef3(final String ref3) {
        this.ref3 = ref3;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(final String deadline) {
        this.deadline = deadline;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(final String returnUrl) {
        this.returnUrl = returnUrl;
    }

	public BigInteger getValue()
	{
        return value;
    }

	public void setValue(final BigInteger value)
	{
        this.value = value;
    }

    public String getRef4() { return ref4; }

    public void setRef4(final String ref4) { this.ref4 = ref4; }

    @Override
    public String toString() {
        return "PaymentServiceRegisterRequest{" +
                "entity=" + entity +
                ", application=" + application +
                ", concept='" + concept + '\'' +
                ", description='" + description + '\'' +
                ", ref1='" + ref1 + '\'' +
                ", ref2='" + ref2 + '\'' +
                ", ref3='" + ref3 + '\'' +
                ", ref4='" + ref4 + '\'' +
                ", deadline='" + deadline + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", value=" + value +
                '}';
    }
}
