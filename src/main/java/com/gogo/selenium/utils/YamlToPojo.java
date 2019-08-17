package com.gogo.selenium.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.gogo.selenium.pojo.SeleniumActions;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/***
 * @author Srinivas
 * Static utility class to convert yaml to POJO
 */
public class YamlToPojo {

    private static final Logger LOGGER = Logger.getLogger(YamlToPojo.class);

    /***
     * dao to convert yaml file to POJO using Jackson
     * @param commandFile yaml file
     * @return {@link SeleniumActions}
     * @throws IOException IOException if yaml file is corrupted or invalid
     */
    public static SeleniumActions loadCommands(String commandFile) throws IOException {
        LOGGER.info("Converting yaml file to Selenium Actions object model....");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(commandFile), SeleniumActions.class);
    }
}
