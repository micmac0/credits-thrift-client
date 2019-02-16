package com.credits.common.exception;

public class CreditsException extends Exception {

    public CreditsException(String errorMessage) {
        super(errorMessage);
    }

    public CreditsException(Exception e) {
        super(e);
    }
}
