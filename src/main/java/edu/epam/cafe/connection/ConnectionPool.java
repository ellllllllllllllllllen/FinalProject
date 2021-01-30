package edu.epam.cafe.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public final class ConnectionPool {
    private final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;

    private static final String DATABASE_PROPERTIES = "database.properties";
    private static final String DATABASE_URL = "url";
    private static final String DATABASE_DRIVER = "driver";
    private static final int DEFAULT_POOL_SIZE = 32;

    private final BlockingQueue<Connection> freeConnections;
    private final Queue<Connection> busyConnections;

    private ConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        busyConnections = new ArrayDeque<>();
        init();
    }
    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    //Закрывает все свободные и занятые соединения jdbc.
    //Часть потока приложения завершения работы.
    public void closeAllConnections() throws SQLException {
        for(Connection connection : busyConnections){
            logger.info("Closing busy jdbc connection...");
            connection.commit();
            connection.close();
        }
        for(Connection connection : freeConnections){
            logger.info("Closing free jdbc connection...");
            connection.close();
        }
        deregisterDrivers();
        busyConnections.clear();
        freeConnections.clear();
    }

    //Получает соединение jdbc из пула соединений,
    public Connection getConnection() throws InterruptedException {
        Connection connection = null;
        connection = freeConnections.take();
        busyConnections.offer(connection);
        return connection;
    }

    //Освобождает данное соединение jdbc и делает его доступным для других клиентов.
    public void releaseConnection(final Connection connection) throws InterruptedException {
        if(!(connection instanceof ProxyConnection)){
            logger.error("Unknown connection.");
        }
        if(!busyConnections.remove(connection)){
            logger.error("Connection is not busy");
        }
        freeConnections.put(connection);
    }
    //Инициализирует пул соединений jdbc.
    private void init() {

    }
    //Получает пул соединений jdbc из свойств проекта.
    //Если в свойствах проекта не определен пул соединений, то возвращает дефолтное значение
    private int getDatabaseConnectionPool() {
        return 0;
    }

    //Получает имя драйвера jdbc из файла project.properties и регистрирует этот драйвер.
    //Если не удается найти имя драйвера базы данных, пытается зарегистрировать по умолчанию "com.mysql.cj.jdbc.Driver".
    private void registerDriver() {

    }

    //Создает экземпляры соединения jdbc и помещает их в freeConnections.
    private void createConnections() {

    }

    //Получает тайм-аут соединения jdbc из свойств проекта.
    //Если в свойствах проекта не определен пул соединений, то возвращает дефолтное значение
    private int getConnectionTimeout() {
        return 0;
    }

    //Отменяет регистрацию всех драйверов jdbc.
    //Часть потока приложения завершения работы.
    private void deregisterDrivers() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Ошибка при отмене регистрации драйверов.");
            }
        });
    }
}
