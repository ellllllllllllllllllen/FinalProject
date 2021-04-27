package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class PostLogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            request.logout();
            return null;
        }catch (ServletException e){
        throw new CommandException(e);
        }
    }
}
