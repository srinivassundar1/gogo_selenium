
package com.gogo.selenium.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "commands",
    "driver"
})
public class SeleniumActions {

    @JsonProperty("commands")
    private List<Command> commands = null;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("commands")
    public List<Command> getCommands() {
        return commands;
    }

    @JsonProperty("commands")
    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "SeleniumActions{" +
                "commands=" + commands +
                ", driver='" + driver + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
