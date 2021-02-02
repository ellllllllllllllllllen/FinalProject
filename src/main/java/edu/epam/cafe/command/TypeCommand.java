package edu.epam.cafe.command;

import edu.epam.cafe.command.impl.PostLogoutCommand;
import edu.epam.cafe.command.impl.PostSignInCommand;
import edu.epam.cafe.command.impl.PostSignUpCommand;
import edu.epam.cafe.service.impl.UserServiceImpl;

public enum TypeCommand {

    SIGN_IN(new PostSignInCommand()),
    SIGN_UP(new PostSignUpCommand()),
    LOGOUT(new PostLogoutCommand())
}
