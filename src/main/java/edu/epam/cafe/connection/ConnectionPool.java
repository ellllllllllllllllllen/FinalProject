package edu.epam.cafe.connection;

import edu.epam.cafe.util.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum ConnectionPool {
    INSTANCE;

    private final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;

    private static final String DATABASE_PROPERTIES = "database.properties";
    private static final String DATABASE_URL = "url";
    private static final String DATABASE_USERNAME = "username";
    private static final String DATABASE_PASSWORD = "password";
    private static final String DATABASE_DRIVER = "driver";
    private static final int DEFAULT_POOL_SIZE = 32;

    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> busyConnections;

    ConnectionPool(){
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        busyConnections = new ArrayDeque<>();
        init();
    }

    private void init() {
        ClassLoader classLoader = ConnectionPool.class.getClassLoader();
        Properties properties = new Properties();
        try {
            InputStream inputStream = classLoader.getResourceAsStream(DATABASE_PROPERTIES);
            properties.load(inputStream);
            String url = properties.getProperty(DATABASE_URL);
            String driver = properties.getProperty(DATABASE_DRIVER);
            String username = properties.getProperty(DATABASE_USERNAME);
            String password = properties.getProperty(DATABASE_PASSWORD);
            Class.forName(driver);
            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                freeConnections.offer(proxyConnection);
            }
        } catch (ClassNotFoundException | IOException | SQLException e) {
            logger.error("Error of file: " + e);
            throw new RuntimeException(e);
        }
    }
    //получает соединение jdbc из пула
    public ProxyConnection getConnection() {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = freeConnections.take();
            busyConnections.offer(proxyConnection);
        } catch (InterruptedException e) {
            logger.error("The connection is not received " + e);
        }
        return proxyConnection;
    }
    //Освобождает данное соединение jdbc и делает его доступным для других клиентов.
    public void releaseConnection(Connection connection){
        if (connection instanceof ProxyConnection) {
            busyConnections.remove(connection);
            freeConnections.offer((ProxyConnection) connection);
        } else {
            logger.error("Invalid connection type passed");
        }
    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException | InterruptedException e) {
                logger.error("The pool was not destroyed " + e);
            }
        }
        deregisterDrivers();
    }
    //Отменяет регистрацию всех драйверов jdbc.
    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Can not deregister driver: " + e);
            }
        });
    }















//    //Закрывает все свободные и занятые соединения jdbc.
//    //Часть потока приложения завершения работы.
//    public void closeAllConnections() throws SQLException {
//        for(Connection connection : busyConnections){
//            logger.info("Closing busy jdbc connection...");
//            connection.commit();
//            connection.close();
//        }
//        for(Connection connection : freeConnections){
//            logger.info("Closing free jdbc connection...");
//            connection.close();
//        }
//        deregisterDrivers();
//        busyConnections.clear();
//        freeConnections.clear();
//    }
//
//    //Получает соединение jdbc из пула соединений,
//    public Connection getConnection() throws InterruptedException {
//        Connection connection = null;
//        connection = freeConnections.take();
//        busyConnections.offer((ProxyConnection) connection);
//        return connection;
//    }
//
//    //Освобождает данное соединение jdbc и делает его доступным для других клиентов.
//    public void releaseConnection(final Connection connection) throws InterruptedException {
//        if(!(connection instanceof ProxyConnection)){
//            logger.error("Unknown connection.");
//        }
//        if(!busyConnections.remove(connection)){
//            logger.error("Connection is not busy");
//        }
//        freeConnections.put((ProxyConnection) connection);
//    }
//    //Инициализирует пул соединений jdbc.
//    private void init() throws IOException, ClassNotFoundException, SQLException {
//        PropertyLoader propertyLoader = new PropertyLoader();
//        Properties properties;
//        properties = propertyLoader.load(DATABASE_PROPERTIES);
//        String url = properties.getProperty(DATABASE_URL);
//        String driver = properties.getProperty(DATABASE_DRIVER);
//        Class.forName(driver);
//        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
//        busyConnections = new ArrayDeque<>(DEFAULT_POOL_SIZE);
//        logger.info("Created connection collections...");
//
//        registerDriver();
//        logger.info("Registered driver...");
//
//        createConnections();
//        logger.info("Initialized connection collection...");
//
//        timeout = getConnectionTimeout();
//        logger.info("Initialized connection timeout...");
//    }
//
//    //Получает имя драйвера jdbc из файла project.properties и регистрирует этот драйвер.
//    //Если не удается найти имя драйвера базы данных, пытается зарегистрировать по умолчанию "com.mysql.cj.jdbc.Driver".
//    private void registerDriver() throws ClassNotFoundException, IOException {
//            logger.info("Trying to register database driver...");
//            Properties properties = new Properties();
//            properties.load(new InputStreamReader(ConnectionPool.class.getResourceAsStream("database.properties")));
//
//            Class.forName(properties.getProperty("driverClassName"));
//    }
//
//    //Создает экземпляры соединения jdbc и помещает их в freeConnections.
//    private void createConnections() throws IOException, SQLException {
//        for(int i = 0; i < DEFAULT_POOL_SIZE; i++){
//            try {
//            Connection connection = new ProxyConnection(DBConnectionUtil.getConnection());
//            freeConnections.add((ProxyConnection) connection);
//            logger.info("Initialized connection {} of {}...", i + 1, DEFAULT_POOL_SIZE);
//            } catch (final SQLException e) {
//                logger.error("Can't create connection to database!", e);
//            }
//        }
//    }
//
//    //Получает тайм-аут соединения jdbc из свойств проекта.
//    //Если в свойствах проекта не определен пул соединений, то возвращает дефолтное значение
//    private int getConnectionTimeout() {
//        return 0;
//    }
//
//    //Отменяет регистрацию всех драйверов jdbc.
//    //Часть потока приложения завершения работы.
//    private void deregisterDrivers() {
//        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
//            try {
//                DriverManager.deregisterDriver(driver);
//            } catch (SQLException e) {
//                logger.error("Ошибка при отмене регистрации драйверов.");
//            }
//        });
//    }
}
