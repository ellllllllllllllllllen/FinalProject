package edu.epam.cafe.command.impl;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.factory.CommandFactory;
import edu.epam.cafe.controller.PagePath;
import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.model.dao.impl.SushiDao;
import edu.epam.cafe.model.dao.impl.UserDaoImpl;
import edu.epam.cafe.model.service.UserService;
import edu.epam.cafe.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class GetSushiCommand implements Command {
    private static final Logger logger = LogManager.getLogger(GetSushiCommand .class);

    SushiDao sushiDao = SushiDao.getInstance();

    public GetSushiCommand () {
    }


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;
        boolean correct = true;
        try{
            request.setAttribute("sushi", SushiDao.getInstance().findAll());

        }catch (DaoException e){
            throw new CommandException();
        }

        return page;
    }
}
