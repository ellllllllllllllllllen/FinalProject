package edu.epam.cafe.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertyLoader {
    private static final Logger logger = LogManager.getLogger(PropertyLoader.class);
    private static final String DATABASE_PROPERTIES = "database.properties";
    private static final String DATABASE_DRIVER = "driver";

    public Properties load(String path) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        logger.info("Load properties from {}", path);
        return properties;
    }

//    public Optional<String> getDatabaseDriverName() {
//        return getStringProperty(DATABASE_PROPERTIES, DATABASE_DRIVER);
//    }
//
//    public Optional<String> getStringProperty(final String filename, final String id) {
//        logger.info("Property in {} file with {} id is {}", filename, id, properties.get(filename).get(id));
//
//        return properties.containsKey(filename) && properties.get(filename).containsKey(id)
//                ? Optional.of(properties.get(filename).get(id))
//                : Optional.empty();
//    }
}
