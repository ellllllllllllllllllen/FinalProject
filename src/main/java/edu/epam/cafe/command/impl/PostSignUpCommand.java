package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.ErrorMessage;
import edu.epam.cafe.command.RequestParameter;
import edu.epam.cafe.controller.PagePath;
import edu.epam.cafe.entity.Role;
import edu.epam.cafe.entity.User;
import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.service.UserService;
import edu.epam.cafe.service.impl.UserServiceImpl;
import edu.epam.cafe.validator.Validator;
import edu.epam.cafe.validator.impl.EmailValidator;
import edu.epam.cafe.validator.impl.FirstnameValidator;
import edu.epam.cafe.validator.impl.LastnameValidator;
import edu.epam.cafe.validator.impl.UsernameValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostSignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PostSignUpCommand.class);
//    private final UserService userService;
//    private final Validator validator;
//
//    public PostSignUpCommand(UserService userService, Validator validator) {
//        this.userService = userService;
//        this.validator = validator;
//    }

    public PostSignUpCommand(){

    }

    @Override
    public String execute(HttpServletRequest request){
        UserService userService = new UserServiceImpl();
        Validator emailValidator = new EmailValidator();
        Validator usernameValidator = new UsernameValidator();
        Validator firstnameValidator = new FirstnameValidator();
        Validator lastnameValidator = new LastnameValidator();
        String email = request.getParameter(RequestParameter.EMAIL);
        String username = request.getParameter(RequestParameter.USERNAME);
        String firstName = request.getParameter(RequestParameter.FIRSTNAME);
        String lastName = request.getParameter(RequestParameter.LASTNAME);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String repeatPassword = request.getParameter(RequestParameter.REPEAT_PASSWORD);
        boolean correct = true;
        String page = null;

        if(userService.isEmailExist(email)){
            request.setAttribute(ErrorMessage.MAIL, "Email is already exists.");
            correct = false;
        }
        if(!emailValidator.validate(email)){
            request.setAttribute(ErrorMessage.MAIL, "Email is incorrect.");
            correct = false;
        }
        if(userService.isUsernameExist(username)){
            request.setAttribute(ErrorMessage.USERNAME, "Username is already exists.");
            correct = false;
        }
        if(!usernameValidator.validate(username)){
            request.setAttribute(ErrorMessage.USERNAME, "Username is incorrect.");
            correct = false;
        }
        if(!firstnameValidator.validate(firstName)){
            request.setAttribute(ErrorMessage.FIRSTNAME, "Firstname cannot be empty.");
            correct = false;
        }
        if(!lastnameValidator.validate(lastName)){
            request.setAttribute(ErrorMessage.LASTNAME, "Lastname cannot be empty.");
            correct = false;
        }
        if(!userService.checkPasswords(password, repeatPassword)){
            request.setAttribute(ErrorMessage.PASSWORD, "Password is incorrect or repeat password does not match the password.");
            correct = false;
        }
        if(correct){
            User user = new User(email, username, firstName, lastName, Role.USER);
            userService.createUser(user, password);
            page = PagePath.SIGN_IN;
        } else {
            page = PagePath.SIGN_UP;
        }
        return page;
    }
}
