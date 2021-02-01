package edu.epam.cafe.service.impl;

import edu.epam.cafe.dao.BaseDao;
import edu.epam.cafe.dao.impl.UserDao;
import edu.epam.cafe.entity.User;
import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.service.UserService;
import edu.epam.cafe.util.PasswordEncryption;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public boolean createUser(User user, String password) throws DaoException {
        String encryptedPassword = PasswordEncryption.encrypt(password);
        UserDao userDao = UserDao.getInstance();
        boolean update = userDao.add(user, encryptedPassword);
        return update;
    }

    @Override
    public Optional<User> findUserById(Long id) {

        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean checkPasswords(String password, String repeatPassword) {
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }

    @Override
    public boolean isUsernameExist(String username) {
        return false;
    }
}
