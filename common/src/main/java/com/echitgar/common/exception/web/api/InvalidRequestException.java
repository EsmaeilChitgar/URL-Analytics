package com.echitgar.common.exception.web.api;

import com.echitgar.common.exception.web.webservice.WebServiceException;
import org.springframework.http.HttpStatus;

public class InvalidRequestException extends WebServiceException {
    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(HttpStatus statusCode, String message) {
        super(statusCode, message);
    }

    public InvalidRequestException(int statusCode, String message) {
        super(HttpStatus.valueOf(statusCode), message);
    }
}