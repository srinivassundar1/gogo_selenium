package com.gogo.selenium.main;

import com.gogo.selenium.lib.SearchBook;
import com.gogo.selenium.exception.GoSeleniumException;

import java.io.IOException;

public class BookDetailsRunner {
    public static void main(String[] args) throws IOException, GoSeleniumException {
        new SearchBook("locators.yaml").getBookDetails();
    }
}
