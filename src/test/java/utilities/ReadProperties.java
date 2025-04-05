package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    // This class is used to read properties from a configuration file
    // It uses the Properties class to load the properties from the file
    // The getProperty() method returns the value of a property given its key
    // The loadProperties() method loads the properties from the file and returns a Properties object
    // The getProperty() method takes a key as input and returns the corresponding value from the properties file

    public static String getProperty(String key) {
        return loadProperties().getProperty(key);
    }

    static String PATH="src/test/resources/config.properties";

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(PATH)) {
            properties.load(inputStream);
        } catch (Exception exception) {
            exception.getMessage();
        }
        return properties;
    }
}
