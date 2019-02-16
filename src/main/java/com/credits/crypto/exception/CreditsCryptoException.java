package com.credits.crypto.exception;

import com.credits.common.exception.CreditsException;

public class CreditsCryptoException extends CreditsException {

    public CreditsCryptoException(String errorMessage) {
        super(errorMessage);
    }

    public CreditsCryptoException(Exception e) {
        super(e);
    }
}
