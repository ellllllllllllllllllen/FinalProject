package edu.epam.cafe.command.factory;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.impl.PostLogoutCommand;
import edu.epam.cafe.command.impl.PostSignInCommand;
import edu.epam.cafe.command.impl.PostSignUpCommand;
import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.model.service.impl.UserServiceImpl;
import edu.epam.cafe.validator.impl.UserValidatorImpl;

import java.util.Optional;

public class CommandFactoryImpl implements CommandFactory{

    private static CommandFactoryImpl instance;

    private CommandFactoryImpl() { }

    public static CommandFactoryImpl getInstance() {
        if (instance == null) {
            instance = new CommandFactoryImpl();
        }

        return instance;
    }

//    @Override
//    public Command createCommand(String commandName) throws CommandException {
//        Command command;
//        switch (commandName) {
//            default:
//                throw new CommandException("Unknown command " + commandName);
//            case POST_SIGN_UP_COMMAND:
//                command = new PostSignUpCommand(new UserServiceImpl(), new UserValidatorImpl());
//                break;
//            case POST_SIGN_IN_COMMAND:
//                command = new PostSignInCommand(new UserServiceImpl());
//                break;
//            case POST_LOGOUT_COMMAND:
//                command = new PostLogoutCommand();
//                break;
//        }
//        return command;
//    }

    @Override
    public Optional<Command> createCommand(String commandName) throws CommandException {
        Optional<Command> optionalCommand;
        Command command;
        switch (commandName) {
            default:
                throw new CommandException("Unknown command " + commandName);
            case POST_SIGN_UP_COMMAND:
                command = new PostSignUpCommand(new UserServiceImpl(), new UserValidatorImpl());
                optionalCommand = Optional.of(command);
                break;
            case POST_SIGN_IN_COMMAND:
                command = new PostSignInCommand(new UserServiceImpl());
                optionalCommand = Optional.of(command);
                break;
            case POST_LOGOUT_COMMAND:
                command = new PostLogoutCommand();
                optionalCommand = Optional.of(command);
                break;
        }
        return optionalCommand;
    }
}
