package edu.epam.cafe.service.impl;

import edu.epam.cafe.entity.User;
import edu.epam.cafe.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> createUser(User user, String password) {
        return Optional.empty();
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
}