package edu.epam.cafe.model.dao.impl;

import edu.epam.cafe.model.connection.ConnectionPool;
import edu.epam.cafe.model.dao.BaseDao;
import edu.epam.cafe.model.entity.Role;
import edu.epam.cafe.model.entity.User;
import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.util.PasswordEncryption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
//import static edu.epam.cafe.model.dao.Queries.FIND_USER_BY_USERNAME_AND_PASSWORD;

public class UserDao implements BaseDao {
    private static final Logger logger = LogManager.getLogger(UserDao.class);
    private static final UserDao instance = new UserDao();
    private static final String ADD_USER = "INSERT INTO users (`email`, `username`, `pass`, `firstname`, `lastname`, `user_role`) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String FIND_USER_BY_USERNAME = "SELECT id, email, username, firstname, lastname, user_role FROM users WHERE username = ?";
    private static final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT id, email, username, firstname, lastname, user_role FROM users WHERE username = ? AND pass = ?";
    private static final String FIND_USER_BY_EMAIL = "SELECT email, username, firstname, lastname, user_role FROM users WHERE email = ?";

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
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, user.getFirstname());
            preparedStatement.setString(5, user.getLastname());
            preparedStatement.setString(6, user.getRole().toString());

            update = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
//            logger.error(e);
            throw new DaoException(e);  //Unknown column 'email' in 'field list'
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

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setFirstname(resultSet.getString(4));
                user.setLastname(resultSet.getString(5));
                user.setRole(Role.valueOf(resultSet.getString(6).toUpperCase()));
                userOptional = Optional.of(user);
            }
            return userOptional;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> findById(long id) throws DaoException{
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setFirstname(resultSet.getString(4));
                user.setLastname(resultSet.getString(5));
                user.setRole(Role.valueOf(resultSet.getString(6).toUpperCase()));
                userOptional = Optional.of(user);
            }
            return userOptional;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) throws DaoException{
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setFirstname(resultSet.getString(4));
                user.setLastname(resultSet.getString(5));
                user.setRole(Role.valueOf(resultSet.getString(6).toUpperCase()));
                userOptional = Optional.of(user);
            }
            return userOptional;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) throws DaoException{
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, PasswordEncryption.encrypt(password));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setUsername(resultSet.getString(3));
                user.setFirstname(resultSet.getString(4));
                user.setLastname(resultSet.getString(5));
                user.setRole(Role.valueOf(resultSet.getString(6).toUpperCase()));
                userOptional = Optional.of(user);
            }
            return userOptional;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }
}
