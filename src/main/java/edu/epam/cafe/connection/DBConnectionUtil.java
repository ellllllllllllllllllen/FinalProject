package edu.epam.cafe.connection;

import edu.epam.cafe.util.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {
    private static final Logger logger = LogManager.getLogger(DBConnectionUtil.class);
    private static final String DATABASE_PROPERTIES = "database.properties";
    private static final String DATABASE_URL = "url";
    private static final String DATABASE_USERNAME = "username";
    private static final String DATABASE_PASSWORD = "username";
    private DBConnectionUtil(){

    }
    static Connection getConnection() throws IOException, SQLException {
        logger.info("Getting connection...");
        Connection connection;
        Properties properties;
        PropertyLoader propertyLoader = new PropertyLoader();

        logger.info("Initialized properties...");

        properties = propertyLoader.load(DATABASE_PROPERTIES);
        String url = properties.getProperty(DATABASE_URL);
        String username = properties.getProperty(DATABASE_USERNAME);
        String password = properties.getProperty(DATABASE_PASSWORD);

        connection = DriverManager.getConnection(url, username, password);

        if (connection != null){
            logger.info("Connection was successful.");
        }
        return connection;
    }
}
