package com.gogo.selenium.exception;

/***
 * @author Srinivas
 * Wrapper User defined exception to throw all exceptions throughout the framework
 */
public class GoSeleniumException extends Exception {
    public GoSeleniumException(String msg) {
        super(msg);
    }
}
