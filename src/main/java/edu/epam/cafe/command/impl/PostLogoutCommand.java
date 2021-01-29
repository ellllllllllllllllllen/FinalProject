package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;

import javax.servlet.http.HttpServletRequest;

public class PostLogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
