package edu.epam.cafe.controller;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.CommandProvider;
import edu.epam.cafe.command.RequestParameter;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DaoException {

        String requestCommand = RequestParameter.COMMAND;
        String commandName = request.getParameter(requestCommand);

        Optional<Command> command = CommandProvider.defineCommand(commandName);
        String page = PagePath.INDEX;
        if(command.isPresent()) {
            page = command.get().execute(request);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}