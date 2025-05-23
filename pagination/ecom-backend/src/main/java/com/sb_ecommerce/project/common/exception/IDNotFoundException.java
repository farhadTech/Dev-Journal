package com.sb_ecommerce.project.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IDNotFoundException extends RuntimeException{
    public IDNotFoundException() {}
    public IDNotFoundException(String message) {
        super(message);
    }
}
