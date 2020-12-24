package de.hybris.sdh.storefront.controllers.rest.entity;

import org.codehaus.jackson.annotate.JsonProperty;

public class Response {
    private String msg;

    public Response() { }

    public Response(String msg) { this.msg = msg; }

    public String getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
