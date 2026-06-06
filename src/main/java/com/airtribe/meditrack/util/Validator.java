package com.airtribe.meditrack.util;

import com.airtribe.meditrack.exception.InvalidDataException;

public class Validator {

    private Validator() {
    }

    public static void validateName(String name) throws InvalidDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be empty");
        }
    }

    public static void validateAge(int age) throws InvalidDataException {
        if (age <= 0) {
            throw new InvalidDataException("Age must be greater than 0");
        }
    }

    public static void validateFee(double fee) throws InvalidDataException {
        if (fee < 0) {
            throw new InvalidDataException("Fee cannot be negative");
        }
    }

    public static void validateContact(String contact) throws InvalidDataException {
        if (contact == null || contact.length() != 10) {
            throw new InvalidDataException("Invalid contact number");
        }
    }
}