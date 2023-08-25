package com.echitgar.common.exception.web.webservice;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class WebServiceException extends RuntimeException {
    private HttpStatus statusCode;

    public WebServiceException(String message) {
        super(message);
        this.statusCode = HttpStatus.BAD_REQUEST;
    }

    public WebServiceException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}