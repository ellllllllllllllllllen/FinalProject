package edu.epam.cafe.validator.impl;

import edu.epam.cafe.validator.UserValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserValidatorImplTest {

    UserValidator userValidator;
    @Before
    public void init(){
        userValidator= new UserValidatorImpl();
    }
    @Test
    public void validateNullEmailReturnFalse() {
        String email = null;
        boolean expected = false;
        boolean actual = userValidator.validateEmail(email);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void validateEmptyEmailReturnFalse() {
        String email = "";
        boolean expected = false;
        boolean actual = userValidator.validateEmail(email);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void validateEmailReturnTrue() {
        String email = "ellen@maail.ru";
        boolean expected = true;
        boolean actual = userValidator.validateEmail(email);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validateNullFirstnameReturnFalse() {
        String firstname = null;
        boolean expected = false;
        boolean actual = userValidator.validateFirstname(firstname);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void validateEmptyFirstnameReturnFalse() {
        String firstname = "";
        boolean expected = false;
        boolean actual = userValidator.validateFirstname(firstname);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void validateFirstnameReturnTrue() {
        String firstname = "Elena";
        boolean expected = true;
        boolean actual = userValidator.validateFirstname(firstname);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validateNullLastnameReturnFalse() {
        String lastname = null;
        boolean expected = false;
        boolean actual = userValidator.validateFirstname(lastname);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void validateEmptyLastnameReturnFalse() {
        String lastname = "";
        boolean expected = false;
        boolean actual = userValidator.validateFirstname(lastname);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void validateLastnameReturnTrue() {
        String lastname = "Elena";
        boolean expected = true;
        boolean actual = userValidator.validateFirstname(lastname);
        Assert.assertEquals(expected, actual);
    }
}