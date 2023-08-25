package com.echitgar.common.exception.web.webservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WebServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WebServiceException.class)
    public ResponseEntity<WebServiceExceptionResponse> handleCustomException(WebServiceException e) {
        WebServiceExceptionResponse webServiceExceptionResponse = new WebServiceExceptionResponse();
        webServiceExceptionResponse.setStatusCode(e.getStatusCode());
        webServiceExceptionResponse.setMessage(e.getMessage());

        return ResponseEntity.status(e.getStatusCode()).body(webServiceExceptionResponse);
    }
}