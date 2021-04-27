package edu.epam.cafe.command.factory;

import edu.epam.cafe.command.Command;
import edu.epam.cafe.command.impl.PostLogoutCommand;
import edu.epam.cafe.command.impl.PostSignInCommand;
import edu.epam.cafe.command.impl.PostSignUpCommand;
import edu.epam.cafe.exception.CommandException;
import edu.epam.cafe.model.service.impl.UserServiceImpl;
import edu.epam.cafe.validator.impl.UserValidatorImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactoryImpl implements CommandFactory{

    private static CommandFactoryImpl instance;
    Map<String, Command> commands = new HashMap<>();

    private CommandFactoryImpl() {
        commands.put(CommandFactory.SIGN_IN, new PostSignInCommand());
        commands.put(CommandFactory.SIGN_UP, new PostSignUpCommand());
        commands.put(CommandFactory.LOGOUT, new PostLogoutCommand());
    }

    public static CommandFactoryImpl getInstance() {
        if (instance == null) {
            instance = new CommandFactoryImpl();
        }

        return instance;
    }

    @Override
    public Command createCommand(String commandName){
        return commands.get(commandName);
    }
}
