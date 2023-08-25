package com.echitgar.common.exception.web.webservice;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class WebServiceExceptionResponse {
    private HttpStatus statusCode;
    private String message;
}
