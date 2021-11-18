package de.hybris.sdh.storefront.controllers.rest.entity;

import org.codehaus.jackson.annotate.JsonProperty;

public class SdhCustomerUpdate {
    private String bp;
    private String uid;
    private String newEmail;

    public String getBp() {
        return bp;
    }

    @JsonProperty("bp")
    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getNewEmail() {
        return newEmail;
    }

    @JsonProperty("newEmail")
    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getUid() { return uid; }

    @JsonProperty("uid")
    public void setUid(String uid) { this.uid = uid; }
}
