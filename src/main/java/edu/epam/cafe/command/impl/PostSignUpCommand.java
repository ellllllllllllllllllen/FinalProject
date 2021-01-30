package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.ErrorMessage;
import edu.epam.cafe.command.RequestParameter;
import edu.epam.cafe.entity.Role;
import edu.epam.cafe.entity.User;
import edu.epam.cafe.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostSignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PostSignUpCommand.class);
    private final UserService userService;

    public PostSignUpCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter(RequestParameter.EMAIL);
        String username = request.getParameter(RequestParameter.USERNAME);
        String firstName = request.getParameter(RequestParameter.FIRSTNAME);
        String lastName = request.getParameter(RequestParameter.LASTNAME);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String repeatPassword = request.getParameter(RequestParameter.REPEAT_PASSWORD);
        boolean correct = true;

        if(userService.isEmailExist(email)){
            request.setAttribute(ErrorMessage.MAIL, "Email is already exists.");
            correct = false;
        }
        if(!userService.isEmailValid(email)){
            request.setAttribute(ErrorMessage.MAIL, "Email is incorrect.");
            correct = false;
        }
        if(userService.isUsernameExist(username)){
            request.setAttribute(ErrorMessage.USERNAME, "Username is already exists.");
            correct = false;
        }
        if(!userService.isUsernameValid(username)){
            request.setAttribute(ErrorMessage.USERNAME, "Username is incorrect.");
            correct = false;
        }
        if(!userService.isFirstnameValid(firstName)){
            request.setAttribute(ErrorMessage.FIRSTNAME, "Firstname cannot be empty.");
            correct = false;
        }
        if(!userService.isLastNameValid(lastName)){
            request.setAttribute(ErrorMessage.LASTNAME, "Lastname cannot be empty.");
            correct = false;
        }
        if(!userService.isPasswordAndRepeatPasswordValid()){
            request.setAttribute(ErrorMessage.PASSWORD, "Password is incorrect or repeat password does not match the password.");
            correct = false;
        }
        if(correct){
            User user = new User(email, username, firstName, lastName, Role.USER, true);
            userService.createUser(user, password);

        }



        return null;
    }
}
