package com.rankingcash.apicore.exceptions;

public class CashbackNotFoundException extends Exception {

    public CashbackNotFoundException(String message, Exception e) {
        super(message, e);
    }

}
