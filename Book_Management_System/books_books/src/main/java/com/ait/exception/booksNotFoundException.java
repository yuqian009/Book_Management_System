package com.ait.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class booksNotFoundException extends RuntimeException
{
    /**
     * Constructs a new runtime exception with the specified detail message.
     */
    public booksNotFoundException(String message)
    {
        super(message);
    }
}
