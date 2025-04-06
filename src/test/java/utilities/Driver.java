package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;

    /**
     * Gets the current WebDriver instance.
     *
     * @return The current WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Sets the WebDriver instance.
     *
     * @param driver The WebDriver instance to set.
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Initializes the browser based on the provided browser name.
     *
     * @param browser The name of the browser to initialize.
     * @throws IllegalArgumentException If the provided browser name is invalid.
     */
    public static void browserIntialization(String browser) {
        // Step 1: Check if the browser is Chrome
        if (browser.equalsIgnoreCase(String.valueOf(Browser.CHROME))) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        // Step 2: Check if the browser is Firefox
        else if (browser.equalsIgnoreCase(String.valueOf(Browser.FIREFOX))) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        // Step 3: Check if the browser is Edge
        else if (browser.equalsIgnoreCase(String.valueOf(Browser.EDGE))) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        // Step 4: Check if the browser is Safari
        else if (browser.equalsIgnoreCase(String.valueOf(Browser.SAFARI))) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        // Step 5: Check if the browser is Internet Explorer
        else if (browser.equalsIgnoreCase(String.valueOf(Browser.IE))) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        // Step 6: Throw an exception if the browser name is invalid
        else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }
}
