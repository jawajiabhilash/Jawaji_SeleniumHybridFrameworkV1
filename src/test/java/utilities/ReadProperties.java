package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to read properties from a configuration file.
 * It uses the {@link Properties} class to load the properties from the file.
 * The {@link #getProperty(String)} method returns the value of a property given its key.
 * The {@link #loadProperties()} method loads the properties from the file and returns a Properties object.
 */
public class ReadProperties {
    // This class is used to read properties from a configuration file
    // It uses the Properties class to load the properties from the file
    // The getProperty() method returns the value of a property given its key
    // The loadProperties() method loads the properties from the file and returns a Properties object
    // The getProperty() method takes a key as input and returns the corresponding value from the properties file

    /**
     * This method takes a key as input and returns the corresponding value from the properties file.
     * Step 1: Call the loadProperties() method to load the properties from the file
     * Step 2: Call the getProperty() method of the Properties class to get the value of the property
     * Step 3: Return the value of the property
     * @param key The key of the property to retrieve
     * @return The value of the property
     */
    public static String getProperty(String key) {
        return loadProperties().getProperty(key);
    }

    static String PATH="src/test/resources/config.properties";

    /**
     * This method loads the properties from the configuration file and returns a Properties object.
     * Step 1: Create a new Properties object
     * Step 2: Create a new FileInputStream object to read the configuration file
     * Step 3: Call the load() method of the Properties class to load the properties from the file
     * Step 4: Catch any IOExceptions that may occur and print the stack trace
     * Step 5: Return the Properties object
     * @return The Properties object
     */
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