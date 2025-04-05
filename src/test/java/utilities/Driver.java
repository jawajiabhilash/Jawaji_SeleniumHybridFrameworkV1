package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver{

    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void browserIntialization(String browser) {
        if (browser.equalsIgnoreCase(String.valueOf(Browser.CHROME))){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase(String.valueOf(Browser.FIREFOX))){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase(String.valueOf(Browser.EDGE))){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase(String.valueOf(Browser.SAFARI))){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

        else if (browser.equalsIgnoreCase(String.valueOf(Browser.IE))){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }
}
