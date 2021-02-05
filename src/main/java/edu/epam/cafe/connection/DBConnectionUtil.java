package edu.epam.cafe.connection;

import edu.epam.cafe.exception.ConnectionPoolException;
import edu.epam.cafe.util.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {
    private static final Logger logger = LogManager.getLogger(DBConnectionUtil.class);
    private static final String DATABASE_PROPERTIES = "database.properties";
    private static final String DATABASE_URL = "url";
    private static final String DATABASE_USERNAME = "username";
    private static final String DATABASE_PASSWORD = "password";
    private static final String DATABASE_DRIVER = "driver";

    public static Connection getConnection() throws ConnectionPoolException {
        try{
            Properties properties = getProperties(DATABASE_PROPERTIES);
            String driver = properties.getProperty(DATABASE_DRIVER);
            String url = properties.getProperty(DATABASE_URL);
            String username = properties.getProperty(DATABASE_USERNAME);
            String password = properties.getProperty(DATABASE_PASSWORD);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException(e);
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        }
    }

    private static Properties getProperties(String propertiesFile) throws ConnectionPoolException {
        try {
            ClassLoader classLoader = DBConnectionUtil.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(propertiesFile);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new ConnectionPoolException(e);
        }
    }






//    public static Connection getConnection(){
//        logger.info("Getting connection...");
//        Connection connection;
//        Properties properties;
//        PropertyLoader propertyLoader = new PropertyLoader();
//
//        logger.info("Initialized properties...");
//
//        properties = propertyLoader.load(DATABASE_PROPERTIES);
//        String url = properties.getProperty(DATABASE_URL);
//        String username = properties.getProperty(DATABASE_USERNAME);
//        String password = properties.getProperty(DATABASE_PASSWORD);
//
//        connection = DriverManager.getConnection(url, username, password);
//
//        if (connection != null){
//            logger.info("Connection was successful.");
//        }
//        return connection;
//    }
}
