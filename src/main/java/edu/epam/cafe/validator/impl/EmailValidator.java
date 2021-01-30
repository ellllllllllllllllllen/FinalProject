package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator<String> {
    private static final Pattern EMAIL_REGEX = Pattern
            .compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
    @Override
    public boolean validate(String email) {
        if (email == null || email.isEmpty()) return false;
        Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }

}
