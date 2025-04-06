package utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * This class is used to set up the test environment and initialize the WebDriver.
 * It extends the {@link Driver} class to inherit the WebDriver instance and methods.
 * The {@code @BeforeTest} annotation indicates that the {@link #setUp()} method should be run before any test methods in the class.
 * The {@code @AfterTest} annotation indicates that the {@link #tearDown()} method should be run after all test methods in the class.
 * The {@link #setUp()} method initializes the WebDriver and sets the driver instance.
 * The {@link #tearDown()} method closes the browser after the tests are completed.
 */
public class BaseTest extends Driver {

    /**
     * Initializes the WebDriver before each test.
     * Step 1: Call the browserIntialization() method from the Driver class to initialize the WebDriver
     * Step 2: Pass the browser name from the ReadProperties class
     * Step 3: Call the setDriver() method to set the driver instance
     */
    @BeforeTest
    public void setUp() {
        browserIntialization(ReadProperties.getProperty("browser"));
        setDriver(getDriver());
    }

    /**
     * Closes the browser after each test.
     * Step 1: Call the getDriver().quit() method to close the browser
     */
    @AfterTest
    public void tearDown() {
        getDriver().quit();
    }
}