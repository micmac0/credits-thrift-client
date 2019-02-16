package com.credits.common.exception;

public class CreditsCommonException extends CreditsException {

    public CreditsCommonException(String errorMessage) {
        super(errorMessage);
    }

    public CreditsCommonException(Exception e) {
        super(e);
    }
}
