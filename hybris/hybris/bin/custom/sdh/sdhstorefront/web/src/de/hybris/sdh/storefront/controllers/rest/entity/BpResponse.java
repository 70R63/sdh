package de.hybris.sdh.storefront.controllers.rest.entity;

public class BpResponse {
    private String bp;

    public BpResponse(String bp) {
        this.bp = bp;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }
}
