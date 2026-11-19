package com.copaco.quoteservice.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final int httpStatusCode;
    private final String message;

    public BaseException(String message, int httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }
}
