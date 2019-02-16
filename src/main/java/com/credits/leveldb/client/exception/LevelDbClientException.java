package com.credits.leveldb.client.exception;

import com.credits.common.exception.CreditsException;

public class LevelDbClientException extends CreditsException {

    public LevelDbClientException(String errorMessage) {
        super(errorMessage);
    }

    public LevelDbClientException(Exception e) {
        super(e);
    }
}
