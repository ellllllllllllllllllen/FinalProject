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
    String POST_SIGN_IN_COMMAND = "sign_in";
    String POST_SIGN_UP_COMMAND = "sign_up";
    String POST_LOGOUT_COMMAND = "logout";

    Optional<Command> createCommand(String commandName) throws CommandException;
}
