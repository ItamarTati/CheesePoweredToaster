package com.example.util;

import com.example.exception.InvalidInputException;

public class InputValidator {
    public static int parsePositiveInt(String value, String errorMessage) throws InvalidInputException {
        try {
            int result = Integer.parseInt(value);
            if (result <= 0) throw new InvalidInputException(errorMessage);
            return result;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(errorMessage);
        }
    }
}