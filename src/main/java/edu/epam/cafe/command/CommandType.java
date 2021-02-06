package edu.epam.cafe.command;

import edu.epam.cafe.command.impl.PostLogoutCommand;
import edu.epam.cafe.command.impl.PostSignInCommand;
import edu.epam.cafe.command.impl.PostSignUpCommand;
import edu.epam.cafe.service.impl.UserServiceImpl;
import edu.epam.cafe.validator.Validator;
import edu.epam.cafe.validator.impl.UserValidatorImpl;
import edu.epam.cafe.validator.impl.UsernameValidator;

public enum CommandType {


    sign_in(new PostSignInCommand(new UserServiceImpl())),
    sign_up(new PostSignUpCommand(new UserServiceImpl(), new UserValidatorImpl()));
//    LOGOUT(new PostLogoutCommand())

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }


}
