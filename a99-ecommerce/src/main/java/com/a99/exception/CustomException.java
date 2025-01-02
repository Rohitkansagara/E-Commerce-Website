package com.a99.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST) // HTTP status 400
public class CustomException extends RuntimeException {

    private final String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

}
