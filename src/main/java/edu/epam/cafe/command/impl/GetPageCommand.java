package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetPageCommand implements Command {
    private final String PAGE;

    public GetPageCommand(String page){
        this.PAGE = page;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return PAGE;
    }
}
