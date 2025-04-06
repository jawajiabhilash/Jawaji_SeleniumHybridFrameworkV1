package utilities;

/**
 * Enum representing different types of browsers.
 */
public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    SAFARI("safari"),
    IE("internet explorer"),
    HEADLESS("headless"),
    HTML_UNIT("htmlunit"),
    PHANTOM_JS("phantomjs"),
    REMOTE("remote");

    // Step 3: Declare the browser variable
    private final String browser;

    /**
     * Step 4: Constructor to initialize the browser variable.
     *
     * @param browser The string value of the browser.
     */
    Browser(String browser) {
        this.browser = browser;
    }

    /**
     * Step 5: Gets the string value of the browser.
     *
     * @return The string value of the browser.
     */
    public String getbrowser() {
        return browser;
    }
}
