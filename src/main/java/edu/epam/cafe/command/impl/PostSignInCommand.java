package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.factory.CommandFactory;
import edu.epam.cafe.controller.PagePath;
import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.exception.ServiceException;
import edu.epam.cafe.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostSignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PostSignInCommand.class);

    private final UserService userService;

    public PostSignInCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;
        boolean correct = true;
        try {
            String username = request.getParameter(CommandFactory.USERNAME);
            String password = request.getParameter(CommandFactory.PASSWORD);


            if(!userService.isUsernameExist(username)) {
                request.setAttribute("errorUserMessage", "Incorrect username or password");
                logger.info("Username is not exists. Page = sign in");
                page = PagePath.SIGN_IN;
                correct = false;
            }
            if(!userService.isUserExist(username, password)) {
                request.setAttribute("errorUserMessage", "Incorrect username or password");
                logger.info("User is not exists. Page = sign in");
                page = PagePath.SIGN_IN;
                correct = false;
            }
            if(correct){
                logger.info("Authorize is OK. Page = index");
                page = PagePath.INDEX;
            }else {
                logger.info("Что-то не так");
                page = PagePath.INDEX;
            }
            return page;
        }catch (ServiceException e){
            throw new CommandException(e);
        }
    }
}
