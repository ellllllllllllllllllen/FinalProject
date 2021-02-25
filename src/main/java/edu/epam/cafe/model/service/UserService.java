package edu.epam.cafe.model.service;

import edu.epam.cafe.model.entity.User;
import edu.epam.cafe.exception.ServiceException;

import java.util.Optional;

public interface UserService {

    boolean createUser(User user, String password) throws ServiceException;
    Optional<User> findUserById(Long id) throws ServiceException;
    Optional<User> findUserByEmail(String email) throws ServiceException;
    Optional<User> findUserByUsername(String username) throws ServiceException;
    Optional<User> findUserByUsernameAndPassword(String username, String password) throws ServiceException;

    boolean checkPasswords(String password, String repeatPassword) throws ServiceException;
    boolean isEmailExist(String email) throws ServiceException;
    boolean isUsernameExist(String username) throws ServiceException;
    boolean isUserExist(String username, String password) throws ServiceException;

}
