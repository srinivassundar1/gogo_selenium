package com.gogo.selenium.lib;

import com.gogo.selenium.exception.GoSeleniumException;
import com.gogo.selenium.service.SeleniumActionDriver;
import com.gogo.selenium.pojo.SeleniumActions;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import static com.gogo.selenium.utils.YamlToPojo.loadCommands;

/***
 * @author Srinivas
 *
 * Class which performs as follows.
 * ●  Go to amazon.com
 *
 * ●  In the search dropdown list, choose ‘Books’ option.
 *
 * ●  Enter search text ‘data’. A bunch of test results will be displayed.
 *      Choose the first test result (first product listed on the search result page) and read/record as many
 *      details related to that particular test result as possible. For example, title of the book, price of the
 *      book for different editions, be it paperback/hardcopy or kindle edition, etc. Make the above functionality
 *      as generic as possible and componentize this functionality.
 */
public class SearchBook {
    private static final Logger LOGGER = Logger.getLogger(SearchBook.class);
    private SeleniumActions seleniumActions; //POJO containing user commands

    public SearchBook(String commandFile) throws IOException {
        seleniumActions = loadCommands(commandFile);
    }

    /***
     * get book details for the book mentioned in the yaml command file
     * @return {@link BookDetails}
     * @throws GoSeleniumException throws exception if program cannot execute user's commands in the file
     */
    public BookDetails getBookDetails() throws GoSeleniumException {
        Map<String, String> pageSourceMap = SeleniumActionDriver.execute(seleniumActions);
        BookDetails bookDetails = parseBookDetails(pageSourceMap.get("bookDescription"));
        LOGGER.info(bookDetails);
        return bookDetails;
    }

    /***
     * parsing book details using jsoup and extract necessary fields.
     * fetches book title & price of all available editions and builds {@link BookDetails} object to return
     * @param pageSource html page source
     * @return {@link BookDetails}
     */
    private BookDetails parseBookDetails(final String pageSource) {
        LOGGER.info("Parsing book details from book description page");
        Document document = Jsoup.parse(pageSource);
        ListIterator<Element> elementItr = document.getElementsByClass("swatchElement").listIterator();
        Map editionMap = new HashMap<String, String>();
        while (elementItr.hasNext()) {
            Element editionElement = elementItr.next();
            final String edition = editionElement.child(0).child(0).child(0).child(0).child(0).text();
            final String prize = editionElement.child(0).child(0).child(0).child(0).child(2).text();
            editionMap.put(edition, prize);
        }
        BookDetails.Builder builder = BookDetails.Builder.newInstance();
        return builder.setTitle(document.getElementById("productTitle").text())
                .setEditionMap(editionMap).build();
    }
}

class BookDetails {
    private String title;
    private Map<String, String> editionMap;

    private BookDetails(Builder builder) {
        title = builder.title;
        editionMap = builder.editionMap;
    }

    static class Builder {
        private String title;
        private Map<String, String> editionMap;

        static Builder newInstance() {
            return new Builder();
        }

        private Builder() {
        }

        Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        Builder setEditionMap(Map<String, String> editionMap) {
            this.editionMap = editionMap;
            return this;
        }

        BookDetails build() {
            return new BookDetails(this);
        }
    }

    @Override
    public String toString() {
        return "Builder{" +
                "title='" + title + '\'' +
                ", editionMap=" + editionMap +
                '}';
    }
}
