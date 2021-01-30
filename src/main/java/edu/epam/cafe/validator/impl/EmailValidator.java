package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator<String> {
    //Общий вид — логин@поддомен.домен. Логин, как и поддомен — слова из букв, цифр,
    // подчёркиваний, дефисов и точек. А домен (имеется в виду 1го уровня) — это от 2 до 6 букв и точек.
    private static final Pattern EMAIL_REGEX = Pattern
            .compile("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$");

    @Override
    public boolean validate(String email) {
        if (email == null || email.isEmpty()) return false;
        Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }

}
