package com.gogo.selenium.service;

import com.gogo.selenium.constants.Constants;
import com.gogo.selenium.exception.GoSeleniumException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * @author Srinivas
 * Wrapper Page Object class where all the core selenium driver's elements and actions are present
 */
class PageObject {

    private static final Logger LOGGER = Logger.getLogger(PageObject.class);
    private String url;
    protected WebDriver driver;

    PageObject(final String url) {
        this.url = url;
    }

    protected void initDriver(final String driverName) throws GoSeleniumException {
        LOGGER.info("Initializing driver " + driverName);
        Constants.Driver d = Constants.Driver.fromString(driverName);
        if(d == null) {
            throw new GoSeleniumException(driverName + " not found");
        }
        switch (d) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
        }
    }

    protected void openUrl() {
        LOGGER.info("Opening URL " + url);
        driver.get(url);
    }

    protected String getPageSource() {
        return driver.getPageSource();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
