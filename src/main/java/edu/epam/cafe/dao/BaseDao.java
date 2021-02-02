package edu.epam.cafe.dao;

import edu.epam.cafe.entity.User;
import edu.epam.cafe.exception.DaoException;

import java.util.List;

public interface BaseDao{
    List<User> findAll() throws DaoException;
    boolean add(User t, String password) throws DaoException;
    boolean deleteById(long id) throws DaoException;
    User update(User t) throws DaoException;
}
