package com.credits.common.utils;

import com.credits.common.exception.CreditsCommonException;

public class Validator {

    public static void validateInteger(String value) throws CreditsCommonException {
        if (Utils.isEmpty(value)) {
            throw new CreditsCommonException("Value is empty");
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new CreditsCommonException(String.format("Invalid Integer value: %s", value));
        }

    }

    public static void validateLong(String value) throws CreditsCommonException {
        if (Utils.isEmpty(value)) {
            throw new CreditsCommonException("Value is empty");
        }
        try {
            Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new CreditsCommonException(String.format("Invalid Long value: %s", value));
        }
    }

    public static void validateDouble(String value) throws CreditsCommonException {
        if (Utils.isEmpty(value)) {
            throw new CreditsCommonException("Value is empty");
        }
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new CreditsCommonException(String.format("Invalid Double value: %s", value));
        }
    }

}
