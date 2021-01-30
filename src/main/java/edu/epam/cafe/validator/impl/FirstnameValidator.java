package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.Validator;

public class FirstnameValidator implements Validator<String> {
    @Override
    public boolean validate(String firstname) {
        boolean isValid = true;
        if (firstname == null || firstname.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
}
