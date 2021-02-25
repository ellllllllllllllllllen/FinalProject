package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.Validator;

import java.util.regex.Pattern;

public class FirstnameValidator implements Validator<String> {

    //Буквы,  от 1 до 50 символов.
    private static final Pattern USERNAME_REGEX = Pattern.compile("^[a-z]{1,50}$");
    @Override
    public boolean validate(String firstname) {
        boolean isValid = true;
        if (firstname == null || firstname.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
}
