package com.gogo.selenium.constants;

/***
 * @author Srinivas
 * User should follow the naming conventions while constructing yaml file as prescribed in the enums
 * declared in this class
 */
public class Constants {

    /***
     * Driver enum in which the web driver runs
     */
    public enum Driver {
        FIREFOX("firefox"), CHROME("chrome");

        private String driverName;

        Driver(String driverName) {
            this.driverName = driverName;
        }

        public static Driver fromString(String text) {
            for (Driver b : Driver.values()) {
                if (b.driverName.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    /***
     * Element types on which the selenium action is performed
     */
    public enum ElementType {
        SELECT("select"),
        INPUT("input"),
        BUTTON("button"),
        PAGE_SOURCE("pageSource"),
        WAIT_PAGE_LOAD("waitPageLoad");

        private String elementType;

        ElementType(String elementType) {
            this.elementType = elementType;
        }

        public static ElementType fromString(String text) {
            for (ElementType b : ElementType.values()) {
                if (b.elementType.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    /***
     * Locators of the elements user prefers to give while executing selenium action
     */
    public enum Locators {
        CSS_SELECTOR("cssSelector"),
        XPATH("xpath"),
        ID("id");

        private String locator;

        Locators(String locator) {
            this.locator = locator;
        }

        public static Locators fromString(String text) {
            for (Locators b : Locators.values()) {
                if (b.locator.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    /***
     * enum of option methods to select an option in the drop down
     */
    public enum SelectOptionType {
        VISIBLE_TEXT("visibleText");

        private String optionType;

        SelectOptionType(String optionType) {
            this.optionType = optionType;
        }

        public static SelectOptionType fromString(String text) {
            for (SelectOptionType b : SelectOptionType.values()) {
                if (b.optionType.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
    }
}
