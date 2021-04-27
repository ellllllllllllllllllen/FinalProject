package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.UserValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorImpl implements UserValidator{

    //Общий вид — логин@поддомен.домен. Логин, как и поддомен — слова из букв, цифр,
    // подчёркиваний, дефисов и точек. А домен (имеется в виду 1го уровня) — это от 2 до 6 букв и точек.
    private static final Pattern EMAIL_REGEX = Pattern
            .compile("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$");
    //Буквы, цифры, дефисы и подчёркивания, от 8 до 18 символов.
    private static final Pattern PASSWORD_REGEX = Pattern
            .compile("^{8,18}$");
    //Буквы, цифры, дефисы и подчёркивания, от 3 до 30 символов.
    private static final Pattern USERNAME_REGEX = Pattern.compile("^[a-z]{3,30}$");

    @Override
    public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        Matcher matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean validateFirstname(String firstname) {
        boolean isValid = true;
        if (firstname == null || firstname.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean validateLastname(String lastname) {
        boolean isValid = true;
        if (lastname == null || lastname.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) return false;
        Matcher matcher = PASSWORD_REGEX.matcher(password);
        return matcher.matches();
    }

    @Override
    public boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) return false;
        Matcher matcher = USERNAME_REGEX.matcher(username);
        return matcher.matches();
    }
}
