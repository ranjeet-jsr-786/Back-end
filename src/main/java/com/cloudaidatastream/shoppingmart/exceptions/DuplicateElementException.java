package com.cloudaidatastream.shoppingmart.exceptions;

/**
 * Created by Hi on 04-02-2018.
 */
public class DuplicateElementException extends Exception {

    private String message;

    public DuplicateElementException(String message) {
        super(message);
        this.message = message;
    }
}
