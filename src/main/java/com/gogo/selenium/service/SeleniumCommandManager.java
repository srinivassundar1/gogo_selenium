package com.gogo.selenium.service;

import com.gogo.selenium.constants.Constants;
import com.gogo.selenium.exception.GoSeleniumException;
import com.gogo.selenium.pojo.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/***
 * @author Srinivas
 * Core utility class which executes the command on the Web element in the driver
 */
class SeleniumCommandManager extends PageObject {

    private static final Logger LOGGER = Logger.getLogger(SeleniumCommandManager.class);
    private Map<String, String> pageSourceMap = new LinkedHashMap<String, String>();

    SeleniumCommandManager(final String url, final String driverName) throws GoSeleniumException {
        super(url);
        initDriver(driverName);
        openUrl();
    }

    /***
     * executes each command specified in yaml file in the driver
     * @param command user command to execute
     * @throws GoSeleniumException
     */
    void executeCommand(Command command) throws GoSeleniumException {
        LOGGER.info("Executing command on element " + command.getElementType());
        Constants.ElementType elementType = Constants.ElementType.fromString(command.getElementType());

        if(elementType == null) {
            LOGGER.error(command.getElementType() + " not found");
           throw new GoSeleniumException(command.getElementType() + " not found");
        }

        switch (elementType) {
            case SELECT:
                Select selectElement = command.getSelect();
                Locator locator = selectElement.getLocator();
                org.openqa.selenium.support.ui.Select books = new org.openqa.selenium.support.ui.Select(
                        driver.findElement(fetchLocator(locator)));
                Constants.SelectOptionType optionType = Constants.SelectOptionType.
                        fromString(selectElement.getOption().getType());

                if(optionType == null) {
                    throw new GoSeleniumException(selectElement.getOption().getType() + " not found");
                }

                switch (optionType) {
                    case VISIBLE_TEXT:
                        books.selectByVisibleText(selectElement.getOption().getValue());
                    default:
                }
                break;


            case INPUT:
                Input inputElement = command.getInput();
                locator = inputElement.getLocator();
                driver.findElement(fetchLocator(locator)).sendKeys(inputElement.getText());
                break;

            case BUTTON:
                Button buttonElement = command.getButton();
                locator = buttonElement.getLocator();
                driver.findElement(fetchLocator(locator)).click();
                break;

            case WAIT_PAGE_LOAD:
                driver.manage().timeouts().implicitlyWait(command.getWaitPageLoad(), TimeUnit.SECONDS);
                break;

            case PAGE_SOURCE:
                pageSourceMap.put(command.getPageName(), driver.getPageSource());
                break;
            default:
        }
    }

    private By fetchLocator(Locator locator) throws GoSeleniumException {
        final Constants.Locators locatorType = Constants.Locators.fromString(locator.getType());

        if(locatorType == null) {
            throw new GoSeleniumException(locator.getType() + " not found");
        }
        // reflection is avoided as it affects the performance of the application if fetchLocator is called frequently
//        try {
//            By by = new By() {
//                @Override
//                public List<WebElement> findElements(SearchContext searchContext) {
//                    return null;
//                }
//            };
//            Method method = By.class.getDeclaredMethod(locator.getType(), String.class);
//            method.invoke(by, locator.getValue().toString());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        switch (locatorType) {
            case ID:
                return By.id(locator.getValue().toString());
            case XPATH:
                return By.xpath(locator.getValue().toString());
            case CSS_SELECTOR:
                return By.cssSelector(locator.getValue().toString());
            default:
                return null;
        }
    }

    public Map<String, String> getPageSourceMap() {
        return pageSourceMap;
    }
}
