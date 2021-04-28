package edu.epam.cafe.model.dao;

import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.model.entity.User;

import java.util.List;

public interface BaseDao<T> {
    List<T> findAll() throws DaoException;
    boolean add(T t) throws DaoException;
    boolean deleteById(long id) throws DaoException;
    User update(T t) throws DaoException;
}
