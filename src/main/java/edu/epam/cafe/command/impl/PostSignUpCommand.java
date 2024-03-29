package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.ErrorMessage;
import edu.epam.cafe.command.factory.CommandFactory;
import edu.epam.cafe.controller.PagePath;
import edu.epam.cafe.model.entity.Role;
import edu.epam.cafe.model.entity.User;
import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.exception.ServiceException;
import edu.epam.cafe.model.service.UserService;
import edu.epam.cafe.model.service.impl.UserServiceImpl;
import edu.epam.cafe.validator.UserValidator;
import edu.epam.cafe.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostSignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PostSignUpCommand.class);
    private final UserService userService;
    private final UserValidator userValidator;

    public PostSignUpCommand() {
        this.userService = new UserServiceImpl();
        this.userValidator = new UserValidatorImpl();
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String email = request.getParameter(CommandFactory.EMAIL);
        String username = request.getParameter(CommandFactory.USERNAME);
        String firstName = request.getParameter(CommandFactory.FIRSTNAME);
        String lastName = request.getParameter(CommandFactory.LASTNAME);
        String password = request.getParameter(CommandFactory.PASSWORD);
        String repeatPassword = request.getParameter(CommandFactory.REPEAT_PASSWORD);
        boolean correct = true;
        String page;

        try {
            if (userService.isEmailExist(email)) {
                request.setAttribute(ErrorMessage.MAIL, "Email is already exists.");
                logger.error("Email is already exists.");
                correct = false;
            }
            if (!userValidator.validateEmail(email)) {
                request.setAttribute(ErrorMessage.MAIL, "Email is incorrect.");
                logger.error("Email is incorrect.");
                correct = false;
            }
            if (userService.isUsernameExist(username)) {
                request.setAttribute(ErrorMessage.USERNAME, "Username is already exists.");
                logger.error("Username is already exists.");
                correct = false;
            }
            if (!userValidator.validateUsername(username)) {
                request.setAttribute(ErrorMessage.USERNAME, "Username is incorrect.");
                logger.error("Username is incorrect.");
                correct = false;
            }
            if (!userValidator.validateFirstname(firstName)) {
                request.setAttribute(ErrorMessage.FIRSTNAME, "Firstname cannot be empty.");
                logger.error("Firstname cannot be empty..");
                correct = false;
            }
            if (!userValidator.validateLastname(lastName)) {
                request.setAttribute(ErrorMessage.LASTNAME, "Lastname cannot be empty.");
                logger.error("Lastname cannot be empty.");
                correct = false;
            }
//            if (!userService.checkPasswords(password, repeatPassword)) {
//                request.setAttribute(ErrorMessage.PASSWORD, "Password is incorrect or repeat password does not match the password.");
//                logger.error("Password is incorrect or repeat password does not match the password.");
//                correct = false;
//            }
            if (correct) {
                logger.info("Все норм создается юзер");
                User user = new User(email, username, firstName, lastName, Role.USER);
                userService.createUser(user, password);
                page = PagePath.INDEX;
                request.getSession(true);

            } else {
                logger.error("Что-то не так перенаправляет на страницу signup");
                page = PagePath.SIGN_UP;
            }
            return page;
        }catch (ServiceException e){
            throw new CommandException(e);
        }
    }
}
