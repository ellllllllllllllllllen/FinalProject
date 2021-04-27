package edu.epam.cafe.controller;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.factory.CommandFactory;
import edu.epam.cafe.command.factory.CommandFactoryImpl;
import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/controller" , "*.do"})
public class Servlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Servlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String page = null;
        try{
            String requestCommand = CommandFactory.COMMAND;
            String commandName = request.getParameter(requestCommand);

            Command command = CommandFactoryImpl.getInstance().createCommand(commandName);

            page = command.execute(request);
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }catch (DaoException | IOException | CommandException e){
            throw new ServletException(e);
        }

    }
}
