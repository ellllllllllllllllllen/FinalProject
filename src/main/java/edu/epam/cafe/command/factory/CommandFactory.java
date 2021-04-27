package edu.epam.cafe.command.factory;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.exception.CommandException;

import java.util.Optional;

public interface CommandFactory {

    String EMAIL = "email";
    String USERNAME = "username";
    String FIRSTNAME = "firstname";
    String LASTNAME = "lastname";
    String PASSWORD = "password";
    String REPEAT_PASSWORD = "repeat_password";

    String COMMAND = "command";
    String SIGN_IN = "sign_in";
    String SIGN_UP = "sign_up";
    String LOGOUT = "logout";

    String SIGN_IN_PAGE = "sign_in_page";
    String SIGN_UP_PAGE = "sign_up_page";

    Command createCommand(String commandName) throws CommandException;
}
