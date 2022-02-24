package com.anubis.family.api.model.response;

public class MessageResponse {
    private String responseMessage;

    public MessageResponse() {
    }

    public MessageResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
