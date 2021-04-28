package edu.epam.cafe.model.dao.impl;

import edu.epam.cafe.exception.DaoException;
import edu.epam.cafe.model.connection.ConnectionPool;
import edu.epam.cafe.model.dao.BaseDao;
import edu.epam.cafe.model.dao.UserDao;
import edu.epam.cafe.model.entity.Role;
import edu.epam.cafe.model.entity.Sushi;
import edu.epam.cafe.model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SushiDao implements BaseDao {
    private static final Logger logger = LogManager.getLogger(SushiDao.class);
    private static final SushiDao instance = new SushiDao();

    private static final String ADD_SUSHI = "INSERT INTO sushi (`image`, `name`, `description`, `price`) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL_SUSHI = "SELECT image, name, description, price FROM sushi";

    private SushiDao(){

    }
    public static SushiDao getInstance() {
        return instance;
    }

    @Override
    public List<Sushi> findAll() throws DaoException {
        List<Sushi> items = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUSHI)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sushi item = new Sushi();
                item.setSushiId(resultSet.getLong(1));
                item.setImage(resultSet.getString(2));
                item.setName(resultSet.getString(3));
                item.setDescription(resultSet.getString(4));
                item.setPrice(resultSet.getDouble(5));
                items.add(item);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return items;
    }

    @Override
    public boolean add(Object o) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteById(long id) throws DaoException {
        return false;
    }

    @Override
    public User update(Object o) throws DaoException {
        return null;
    }


}
