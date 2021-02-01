package edu.epam.cafe.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private static final Logger logger = LogManager.getLogger(PropertyLoader.class);

    public Properties load(String path) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        logger.info("Load properties from {}", path);
        return properties;
    }
}
