package com.rankingcash.apicore.exceptions;

public class PriceNotFoundException extends Exception {

    public PriceNotFoundException(String message, Exception e) {
        super(message, e);
    }

}
