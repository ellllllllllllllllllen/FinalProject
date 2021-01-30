package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.Validator;

public class LastnameValidator implements Validator<String> {
    @Override
    public boolean validate(String lastname) {
        boolean isValid = true;
        if (lastname == null || lastname.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
}
