package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.ErrorMessage;
import edu.epam.cafe.command.RequestParameter;
import edu.epam.cafe.controller.PagePath;
import edu.epam.cafe.entity.Role;
import edu.epam.cafe.entity.User;
import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.service.UserService;
import edu.epam.cafe.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostSignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PostSignUpCommand.class);
    private final UserService userService;
    private final UserValidator userValidator;

    public PostSignUpCommand(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @Override
    public String execute(HttpServletRequest request) throws DaoException {
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
            logger.info("Email is already exists.");
            correct = false;
        }
        if(!userValidator.validateEmail(email)){
            request.setAttribute(ErrorMessage.MAIL, "Email is incorrect.");
            correct = false;
        }
        if(userService.isUsernameExist(username)){
            request.setAttribute(ErrorMessage.USERNAME, "Username is already exists.");
            System.out.println("Username is already exists.");
            correct = false;
        }
        if(!userValidator.validateUsername(username)){
            request.setAttribute(ErrorMessage.USERNAME, "Username is incorrect.");
            logger.info("Username is incorrect.");
            correct = false;
        }
        if(!userValidator.validateFirstname(firstName)){
            request.setAttribute(ErrorMessage.FIRSTNAME, "Firstname cannot be empty.");
            correct = false;
        }
        if(!userValidator.validateLastname(lastName)){
            request.setAttribute(ErrorMessage.LASTNAME, "Lastname cannot be empty.");
            correct = false;
        }
        if(!userService.checkPasswords(password, repeatPassword)){
            request.setAttribute(ErrorMessage.PASSWORD, "Password is incorrect or repeat password does not match the password.");
            logger.info("Password is incorrect or repeat password does not match the password.");
            correct = false;
        }
        if(correct){
            logger.info("Все норм создается юзер");
            User user = new User(email, username, firstName, lastName, Role.USER);
            userService.createUser(user, password);
            page = PagePath.SIGN_IN;
        } else {
            logger.info("Что-то не так перенаправляет на страницу signup");
            page = PagePath.SIGN_UP;
        }
        return page;
    }
}
