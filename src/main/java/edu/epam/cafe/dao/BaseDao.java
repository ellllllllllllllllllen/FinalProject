package edu.epam.cafe.dao;

import edu.epam.cafe.entity.User;
import edu.epam.cafe.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface BaseDao{
    List<User> findAll() throws DaoException;
    boolean add(User t, String password) throws DaoException;
    boolean deleteById(long id) throws DaoException;
    User update(User t) throws DaoException;

    Optional<User> findByEmail(String email) throws DaoException;
    Optional<User> findById(long id) throws DaoException;
    Optional<User> findByUsername(String username) throws DaoException;
    Optional<User> findByUsernameAndPassword(String username, String password) throws DaoException;
}
