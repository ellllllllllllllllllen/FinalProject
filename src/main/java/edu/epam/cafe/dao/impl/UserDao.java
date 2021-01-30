package edu.epam.cafe.dao.impl;

import edu.epam.cafe.dao.BaseDao;
import edu.epam.cafe.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserDao implements BaseDao {
    private static final Logger logger = LogManager.getLogger(UserDao.class);
    private static final UserDao instance = new UserDao();

    private UserDao(){

    }

    public static UserDao getInstance() {
        return instance;
    }
    @Override
    public List findAll() throws DaoException {
        return null;
    }

    @Override
    public boolean add(Object o, String password) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteById(Object id) throws DaoException {
        return false;
    }

    @Override
    public Object update(Object o) throws DaoException {
        return null;
    }
}
