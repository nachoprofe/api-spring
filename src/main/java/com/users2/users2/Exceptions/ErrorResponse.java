package com.users2.users2.Exceptions;

public class ErrorResponse {
    private ErrorKey id;
    private String message;

    public ErrorResponse(ErrorKey id, String message) {
        this.id = id;
        this.message = message;
    }

    public ErrorKey getId() {
        return id;
    }

    public void setId(ErrorKey id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
