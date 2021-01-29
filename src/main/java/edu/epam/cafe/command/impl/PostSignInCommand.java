package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.service.UserService;
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
    public String execute(HttpServletRequest request) {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");


        return null;
    }
}
