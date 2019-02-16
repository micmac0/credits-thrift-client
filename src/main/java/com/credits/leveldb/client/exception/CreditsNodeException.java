package com.credits.leveldb.client.exception;

import com.credits.common.exception.CreditsException;

public class CreditsNodeException extends CreditsException {

    public CreditsNodeException(String errorMessage) {
        super(errorMessage);
    }

    public CreditsNodeException(Exception e) {
        super(e);
    }
}
