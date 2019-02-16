package com.credits.crypto;

import com.credits.common.exception.CreditsException;
import com.credits.crypto.exception.CreditsCryptoException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public static byte[] encrypt(byte[] bytes) throws CreditsCryptoException {

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new CreditsCryptoException(e);
        }
        digest.update(bytes);
        return digest.digest();
    }
}
