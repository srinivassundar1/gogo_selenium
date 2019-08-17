# gogo_selenium

Framework is designed in such a generic way that the consumer can give all the commands he needs to execute in a
human readable YAML format.
The framework converts YAML to POJO using Jackson and passes the commands to the
SeleniumActionDriver.java which executes the commands using SeleniumCommandManager which wraps up the selenium actions

* BookDetailsRunner is the main class that runs the code
* locators.yaml contains the commands to perform the functionality
* SearchBook.java is a library which performs the functionality
* com.gogo.selenium.service contains the core selenium utilities and drivers to execute actions

# How to Run
```bash
mvn test
```
