package edu.epam.cafe.command;

import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.exception.DaoException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws DaoException, CommandException;
}
