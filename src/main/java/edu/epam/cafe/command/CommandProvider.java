package edu.epam.cafe.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CommandProvider {
    public static final Logger logger = LogManager.getLogger(CommandProvider.class);
    public static Optional<Command> defineCommand(String commandName) {
        Optional<Command> optionalCommand = Optional.empty();
        try {
            if(commandName!=null) {
                Command resultCommand = CommandType.valueOf(commandName).getCommand();
                optionalCommand = Optional.of(resultCommand);
            }
        }catch (IllegalArgumentException e){
            logger.error(e);
        }
        return optionalCommand;
    }
}
