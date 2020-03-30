package com.server.api.app.errors;

class InvalidRequestException extends ApplicationException {

    public InvalidRequestException(int code, String message) {
        super(code, message);
    }
}
