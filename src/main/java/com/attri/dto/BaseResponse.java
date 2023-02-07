package com.attri.dto;

public class BaseResponse {

    private final int statusCode;
    private final Object object;
    private final String message;

    public BaseResponse(final int statusCode, final Object object, final String message) {
        this.statusCode = statusCode;
        this.object = object;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "statusCode=" + statusCode +
                ", object=" + object +
                ", message='" + message + '\'' +
                '}';
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getObject() {
        return object;
    }

    public String getMessage() {
        return message;
    }
}
