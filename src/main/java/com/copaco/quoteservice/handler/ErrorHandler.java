package com.copaco.quoteservice.handler;

import com.copaco.quoteservice.exception.BaseException;
import com.copaco.quoteservice.model.RestErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public RestErrorResponse handleBaseException(BaseException baseException) {
        return new RestErrorResponse(baseException.getHttpStatusCode(),
            baseException.getMessage());
    }


}
