package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator implements Validator<String> {

    //Буквы, цифры, дефисы и подчёркивания, от 3 до 16 символов.
    private static final Pattern USERNAME_REGEX = Pattern.compile("^[a-z0-9_-]{3,16}$");

    @Override
    public boolean validate(String username) {
        if (username == null || username.isEmpty()) return false;
        Matcher matcher = USERNAME_REGEX.matcher(username);
        return matcher.matches();
    }
}
