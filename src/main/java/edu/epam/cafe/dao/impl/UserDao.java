package edu.epam.cafe.dao.impl;

import edu.epam.cafe.connection.ConnectionPool;
import edu.epam.cafe.connection.DBConnectionUtil;
import edu.epam.cafe.dao.BaseDao;
import edu.epam.cafe.dao.Queries;
import edu.epam.cafe.entity.User;
import edu.epam.cafe.exception.ConnectionPoolException;
import edu.epam.cafe.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements BaseDao {
    private static final Logger logger = LogManager.getLogger(UserDao.class);
    private static final UserDao instance = new UserDao();
    private static final String ADD_USER = "INSERT INTO users (`email`, `username`, `pass`, `firstname`, `lastname`, `user_role`) VALUES (?, ?, ?, ?, ?, ?);";

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
    public boolean add(User user, String password) throws DaoException {
        boolean update;
//        try (Connection connection = DBConnectionUtil.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_USER)) {
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, user.getFirstname());
            preparedStatement.setString(5, user.getLastname());
            preparedStatement.setString(6, user.getRole().toString());

            update = preparedStatement.executeUpdate() > 0;
        } catch (SQLException | ConnectionPoolException e) {
//            logger.error(e);
            throw new DaoException(e);
        }
        return update;
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        return false;
    }

    @Override
    public User update(User t) throws DaoException {
        return null;
    }


}
