package com.gogo.selenium.constants;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.rmi.registry.LocateRegistry;
import java.util.Map;

public class Locators {
    private Locators() {

    }
    public static Map<String, String> locator;
    public static String SEARCH_DROP_DOWN = "searchDropdownBox";

    static {
//        Yaml yaml = new Yaml();
//        InputStream inputStream = ClassLoader.getSystemResourceAsStream("locators.yaml");
//        locator = yaml.load(inputStream);
    }

    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("locators.yaml");
        locator = yaml.load(inputStream);
        System.out.println(locator.toString());
    }

}
