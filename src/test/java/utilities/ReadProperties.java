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

    // Path to the configuration file
    static String PATH = "src/test/resources/config.properties";

    /**
     * This method takes a key as input and returns the corresponding value from the properties file.
     *
     * Steps:
     * 1. Call the `loadProperties()` method to load the properties from the file.
     * 2. Use the `getProperty()` method of the `Properties` class to retrieve the value of the property.
     * 3. Return the value of the property.
     *
     * @param key The key of the property to retrieve.
     * @return The value of the property.
     */
    public static String getProperty(String key) {
        // Step 1: Load the properties from the file
        Properties properties = loadProperties();

        // Step 2: Retrieve the value of the property using the key
        String value = properties.getProperty(key);

        // Step 3: Return the value of the property
        return value;
    }

    /**
     * This method loads the properties from the configuration file and returns a Properties object.
     *
     * Steps:
     * 1. Create a new `Properties` object to store the properties.
     * 2. Create a `FileInputStream` object to read the configuration file.
     * 3. Use the `load()` method of the `Properties` class to load the properties from the file.
     * 4. Handle any exceptions that may occur during file reading.
     * 5. Return the `Properties` object containing the loaded properties.
     *
     * @return The `Properties` object containing the loaded properties.
     */
    private static Properties loadProperties() {
        // Step 1: Create a new Properties object
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(PATH)) {
            // Step 2: Open the configuration file using FileInputStream
            // Step 3: Load the properties from the file
            properties.load(inputStream);
        } catch (Exception exception) {
            // Step 4: Handle exceptions (e.g., file not found or I/O errors)
            exception.printStackTrace();
        }

        // Step 5: Return the Properties Object
        return properties;
    }
}