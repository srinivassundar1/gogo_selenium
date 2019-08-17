package com.gogo.selenium.service;

import com.gogo.selenium.exception.GoSeleniumException;
import com.gogo.selenium.pojo.Command;
import com.gogo.selenium.pojo.SeleniumActions;

import java.util.Map;

/***
 * @author Srinivas
 * Driver class which executes all user actions in the user specified driver.
 */
public class SeleniumActionDriver {

    /***
     * passes each command in the user specified order to the {@link SeleniumCommandManager}
     * where selenium action is performed on web element
     * @param seleniumActions selenium actions root POJO converted from yaml
     * @throws GoSeleniumException throws {@link GoSeleniumException} Exception if user command cannot be executed
     */
    public static Map<String, String> execute(SeleniumActions seleniumActions) throws GoSeleniumException {
        SeleniumCommandManager scm = new SeleniumCommandManager(seleniumActions.getUrl(), seleniumActions.getDriver());
        try {
            for (Command command : seleniumActions.getCommands()) {
                scm.executeCommand(command);
            }
        } finally {
            if (scm.getDriver() != null) {
                scm.getDriver().quit();
            }
        }
        return scm.getPageSourceMap();
    }

}
