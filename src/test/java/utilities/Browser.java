package utilities;

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

    private final String browser;
    Browser(String browser) {
        this.browser = browser;
    }
    public String getbrowser() {
        return browser;
    }


}
