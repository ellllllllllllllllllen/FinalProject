package edu.epam.cafe.dao;

import edu.epam.cafe.exception.DaoException;

import java.util.List;

public interface BaseDao<K, T> {
    List<T> findAll() throws DaoException;
    boolean add(T t, String password) throws DaoException;
    boolean deleteById(K id) throws DaoException;
    T update(T t) throws DaoException;
}
