package utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Driver {
    // This class is used to set up the test environment and initialize the WebDriver
    // It extends the Driver class to inherit the WebDriver instance and methods
    // The @BeforeTest annotation indicates that this method should be run before any test methods in the class
    // The @AfterTest annotation indicates that this method should be run after all test methods in the class
    // The setUp() method initializes the WebDriver and sets the driver instance
    // The tearDown() method closes the browser after the tests are completed

    @BeforeTest
    public void setUp() {
        // Initialize the WebDriver
        browserIntialization("chrome");
        // Set the driver instance
        setDriver(getDriver());
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        getDriver().quit();
    }
}

