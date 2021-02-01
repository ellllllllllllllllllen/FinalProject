package edu.epam.cafe.service;

import edu.epam.cafe.entity.User;
import edu.epam.cafe.exception.DaoException;

import java.util.Optional;

public interface UserService {

    boolean createUser(User user, String password) throws DaoException;
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);

    boolean checkPasswords(String password, String repeatPassword);
    boolean isEmailExist(String email);
    boolean isUsernameExist(String username);

}
