package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator<String> {

    //Буквы, цифры, от 8 до 18 символов.
    private static final Pattern PASSWORD_REGEX = Pattern
            .compile("^[a-z0-9]{8,18}$");

    @Override
    public boolean validate(String password) {
        if (password == null || password.isEmpty()) return false;
        Matcher matcher = PASSWORD_REGEX.matcher(password);
        return matcher.matches();
    }
}
