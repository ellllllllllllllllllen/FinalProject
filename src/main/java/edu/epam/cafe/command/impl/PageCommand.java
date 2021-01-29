package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;

import javax.servlet.http.HttpServletRequest;

public class PageCommand implements Command {
    private final String PAGE;

    public PageCommand(String page){
        this.PAGE = page;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
