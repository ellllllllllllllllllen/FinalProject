package edu.epam.cafe.model.service.impl;

import edu.epam.cafe.model.dao.impl.UserDaoImpl;
import edu.epam.cafe.model.entity.User;
import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.exception.ServiceException;
import edu.epam.cafe.model.service.UserService;
import edu.epam.cafe.util.PasswordEncryption;
import edu.epam.cafe.validator.UserValidator;
import edu.epam.cafe.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final UserValidator userValidator = new UserValidatorImpl();
    private final UserDaoImpl userDao = UserDaoImpl.getInstance();

    @Override
    public boolean createUser(User user, String password)throws ServiceException{
        try {
            String encryptedPassword = PasswordEncryption.encrypt(password);
            UserDaoImpl userDao = UserDaoImpl.getInstance();
            boolean update = userDao.add(user, encryptedPassword);
            return update;
        }catch (DaoException e){
        throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findUserById(Long id) throws ServiceException {
        try {
            Optional<User> user = userDao.findById(id);
            return user;
        }catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws ServiceException {
        try {
            Optional<User> user = userDao.findByEmail(email);
            return user;
        }catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findUserByUsername(String username) throws ServiceException {
        try {
            Optional<User> user = userDao.findByUsername(username);
            return user;
        }catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findUserByUsernameAndPassword(String username, String password) throws ServiceException {
        try {
            Optional<User> user = userDao.findByUsernameAndPassword(username, password);
            return user;
        }catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean checkPasswords(String password, String repeatPassword) {
        boolean isCorrect = false;
        UserValidator userValidator = new UserValidatorImpl();
        if (userValidator.validatePassword(password) && password.equals(repeatPassword)) {
            isCorrect = true;
        }
        return isCorrect;
    }

    @Override
    public boolean isEmailExist(String email) throws ServiceException {
        Optional<User> user = findUserByEmail(email);
        boolean isExist = false;
        if (user.isPresent()) {
            isExist = true;
        }
        return isExist;
    }

    @Override
    public boolean isUsernameExist(String username) throws ServiceException {
        Optional<User> user = findUserByUsername(username);
        boolean isExist = false;
        if (user.isPresent()) {
            isExist = true;
        }
        return isExist;
    }

    @Override
    public boolean isUserExist(String username, String password) throws ServiceException{
        Optional<User> user = findUserByUsernameAndPassword(username, password);
        boolean isExist = false;
        if (user.isPresent()) {
            isExist = true;
        }
        return isExist;
    }
}
