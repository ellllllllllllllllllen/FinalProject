package edu.epam.cafe.validator;

public interface UserValidator {

    public boolean validateEmail(String email);
    public boolean validateFirstname(String firstname);
    public boolean validateLastname(String lastname);
    public boolean validatePassword(String password);
    public boolean validateUsername(String username);
}
