package com.sachi.micro.tinyurl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadInput extends Exception {
    private static final long serialVersionUID = 1L;
    public BadInput(String message) {
        super(message);
    }
}
